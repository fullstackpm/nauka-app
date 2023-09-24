package ai.nauka.nauka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ai.nauka.nauka.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    
    Role findByRoleName(String roleName);

    @Query("select r from Role r")
    List<Role> getAllRole();

    @Query("select r from Role r where r.roleDiscipline = :roleDiscipline")
    List<Role> getAllRoleByDiscipline(@Param("roleDiscipline") String roleDiscipline);
}
