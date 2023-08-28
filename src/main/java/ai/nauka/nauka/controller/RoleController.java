package ai.nauka.nauka.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ai.nauka.nauka.model.Role;
import ai.nauka.nauka.repository.RoleRepository;
import ai.nauka.nauka.repository.SalaryRepository;

@RestController
public class RoleController {

    private RoleRepository roleRepository;
    private SalaryRepository salaryRepository;

    public RoleController(RoleRepository roleRepository, SalaryRepository salaryRepository) {
        this.roleRepository = roleRepository;
        this.salaryRepository = salaryRepository;
    }

    @GetMapping("/role/{jobTitle}")
    public Role getRole(@PathVariable String jobTitle) {
        Role role = this.roleRepository.findByJobTitle(jobTitle);
        role.setSalaries(salaryRepository.getHighestSalariesbyRole(jobTitle, 4));
        return role;
    }
    
}
