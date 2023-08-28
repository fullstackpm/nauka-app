package ai.nauka.nauka.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import ai.nauka.nauka.model.Salary;

public interface SalaryRepository extends CrudRepository<Salary, Long> {

    List<Salary> findByJobTitleOrderBySalaryDesc(String jobTitle, Pageable pageable);

    default List<Salary> getHighestSalariesbyRole(String jobTitle, int count) {
        return findByJobTitleOrderBySalaryDesc(jobTitle, PageRequest.of(0, count));
    }
    
}
