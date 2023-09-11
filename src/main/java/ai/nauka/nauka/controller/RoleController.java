package ai.nauka.nauka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.nauka.nauka.data.RoleDTO;
import ai.nauka.nauka.model.Role;
import ai.nauka.nauka.repository.RoleRepository;

@RestController
@CrossOrigin
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("/roles/{roleName}")
    public RoleDTO getRole(@PathVariable String roleName) {
        Role role = roleRepository.findByRoleName(roleName);
        if (role != null) {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setRoleId(role.getRoleId());
            roleDTO.setRoleName(role.getRoleName());
            roleDTO.setRoleDiscipline(role.getRoleDiscipline());
            roleDTO.setSkills(role.getSkills()); // Include the skills
            roleDTO.setSalaries(role.getSalaries());
            return roleDTO;
        } else {
            // Handle the case when the role is not found
            return null; // You might want to return a response with an appropriate status code
        }
    }

}
