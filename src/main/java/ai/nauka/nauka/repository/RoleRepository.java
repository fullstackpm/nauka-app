package ai.nauka.nauka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ai.nauka.nauka.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    
    Role findByRoleName(String roleName);
    
    List<Role> findAll();

    @Query("SELECT s.basicSalary FROM Role r JOIN r.salaries s")
    List<Double> findAllSalaries();
    
    @Query("SELECT r FROM Role r WHERE (:roleDiscipline IS NULL OR r.roleDiscipline = :roleDiscipline)")
    List<Role> findRolesByDiscipline(@Param("roleDiscipline") String roleDiscipline);
    
}
