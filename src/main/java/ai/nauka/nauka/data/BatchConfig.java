package ai.nauka.nauka.data;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import ai.nauka.nauka.model.Salary;

@Configuration
public class BatchConfig {

    private final String[] FIELD_NAMES = new String[] {"id","age", "gender", "education_level", "job_title", "years_of_experience", "salary"};
    
    @Bean
    public FlatFileItemReader<SalaryInput> reader() {
        return new FlatFileItemReaderBuilder<SalaryInput>()
                .name("SalaryItemReader")
                .resource(new ClassPathResource("basic-salary-data.csv"))
                .linesToSkip(1)
                .delimited()
                .names(FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<SalaryInput>() {
                    {
                        setTargetType(SalaryInput.class);
                    }
                })
                .build();
    }

    @Bean
    public SalaryDataProcessor processor() {
        return new SalaryDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Salary> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Salary>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO salary (id, education_level, job_title, years_of_experience, salary) VALUES (:id, :educationLevel, :jobTitle, :yearsOfExperience, :salary)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(JobRepository jobRepository,
            JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
            PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Salary> writer) {
        return new StepBuilder("step1", jobRepository)
                .<SalaryInput, Salary>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
}
