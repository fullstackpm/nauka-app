package ai.nauka.nauka.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import ai.nauka.nauka.model.Salary;

public class SalaryDataProcessor implements ItemProcessor<SalaryInput, Salary> {

  private static final Logger log = LoggerFactory.getLogger(SalaryDataProcessor.class);
//   private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

  @Override
  public Salary process(final SalaryInput salaryInput) throws Exception {
    
    Salary salary = new Salary();

    salary.setId(Long.parseLong(salaryInput.getId()));
    salary.setEducationLevel(salaryInput.getEducation_level());
    salary.setJobTitle(salaryInput.getJob_title());
    salary.setYearsOfExperience(Double.parseDouble(salaryInput.getYears_of_experience()));
    salary.setSalary(Double.parseDouble(salaryInput.getSalary()));

    return salary;
  }


}
