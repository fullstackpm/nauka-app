package ai.nauka.nauka.repository;

import org.springframework.data.repository.CrudRepository;

import ai.nauka.nauka.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    
    Role findByRoleName(String roleName);
}
