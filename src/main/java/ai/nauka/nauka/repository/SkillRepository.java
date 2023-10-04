package ai.nauka.nauka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ai.nauka.nauka.model.Salary;
import ai.nauka.nauka.model.Skill;

public interface SkillRepository extends CrudRepository<Skill, Long> {
    
    @Query("SELECT s FROM Skill s WHERE (:roleName IS NULL OR s.roleName = :roleName)")
    List<Skill> findSkillsByRoleName(@Param("roleName") String roleName);
}
