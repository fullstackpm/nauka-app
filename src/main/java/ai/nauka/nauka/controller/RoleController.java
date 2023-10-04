package ai.nauka.nauka.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ai.nauka.nauka.data.GlobalStatsDTO;
import ai.nauka.nauka.data.RoleDTO;
import ai.nauka.nauka.model.Role;
import ai.nauka.nauka.model.Salary;
import ai.nauka.nauka.repository.RoleRepository;
import ai.nauka.nauka.repository.SkillRepository;
import ai.nauka.nauka.service.GlobalService;
import ai.nauka.nauka.service.RoleProfileService;

@RestController
@CrossOrigin
public class RoleController {

    private final RoleRepository roleRepository;

    private RoleProfileService roleProfileService;

    private GlobalService globalService;

    @Autowired
    public RoleController(RoleRepository roleRepository, RoleProfileService roleProfileService, GlobalService globalService) {
        this.roleRepository = roleRepository;
        this.roleProfileService = roleProfileService;
        this.globalService = globalService;
    }

    @GetMapping("/roles")
    public List<Role> getRolesByDiscipline(@RequestParam(value = "discipline", required = false) String roleDiscipline) {
        return roleRepository.findRolesByDiscipline(roleDiscipline);
    }


    @GetMapping("/roles/{roleName}")
    public RoleDTO getRole(@PathVariable String roleName) {

        RoleDTO roleDTO = roleProfileService.getRoleProfile(roleName);
        return roleDTO;
    }

    @GetMapping("/roles/global-stats")
    public GlobalStatsDTO getGlobalStats() {

        GlobalStatsDTO globalStatsDTO = globalService.getGlobalStats();
        return globalStatsDTO;

    }

}

