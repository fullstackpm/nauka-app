package ai.nauka.nauka.repository;

import org.springframework.data.repository.CrudRepository;

import ai.nauka.nauka.model.Salary;

public interface SalaryRepository extends CrudRepository<Salary, Long> {
    
}
