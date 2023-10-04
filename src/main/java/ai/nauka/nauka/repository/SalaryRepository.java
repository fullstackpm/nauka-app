package ai.nauka.nauka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ai.nauka.nauka.model.Role;
import ai.nauka.nauka.model.Salary;

public interface SalaryRepository extends CrudRepository<Salary, Long> {

    @Query("SELECT s FROM Salary s")
    List<Salary> findSalaries();
    
    @Query("SELECT s FROM Salary s WHERE (:roleName IS NULL OR s.roleName = :roleName)")
    List<Salary> findSalariesByRoleName(@Param("roleName") String roleName);

}
