package ai.nauka.nauka.data;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import ai.nauka.nauka.model.Role;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final EntityManager em;

    // private final JdbcTemplate jdbcTemplate;

    // @Autowired
    // public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
    // this.jdbcTemplate = jdbcTemplate;
    // }

    public JobCompletionNotificationListener(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

            Map<String, Role> roleData = new HashMap<>();

            // em.createQuery(
            //         "select s.jobTitle, count(*), min(s.salary), max(s.salary), avg(s.salary) from Salary s group by s.jobTitle",
            //         Object[].class)
            //         .getResultList()
            //         .stream()
            //         .map(e -> new Role((String) e[0], ((Number) e[1]).intValue(), (double) e[2], (double) e[3], (double) e[4]))
            //         .forEach(role -> roleData.put(role.getJobTitle(), role));

            em.createQuery(
                    "select s.jobTitle, count(*), min(s.salary), max(s.salary), median(s.salary) from Salary s group by s.jobTitle",
                    Object[].class)
                    .getResultList()
                    .stream()
                    .map(e -> new Role((String) e[0], ((Number) e[1]).intValue(), (double) e[2], (double) e[3], (double) e[4]))
                    .forEach(role -> roleData.put(role.getJobTitle(), role));
            
            roleData.values().forEach(role -> em.persist(role));
            roleData.values().forEach(role -> System.out.println(role));
        }
    }
}