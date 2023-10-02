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

@RestController
@CrossOrigin
public class RoleController {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("/roles")
    public List<Role> getRolesByDiscipline(@RequestParam(value = "discipline", required = false) String roleDiscipline) {
        // System.out.println("Received roleDiscipline: " + roleDiscipline);
        return roleRepository.findRolesByDiscipline(roleDiscipline);
    }


    @GetMapping("/roles/{roleName}")
    public RoleDTO getRole(@PathVariable String roleName) {
        Role role = roleRepository.findByRoleName(roleName);
        // Role global = roleRepository.findAllByRole();

        RoleDTO roleDTO = new RoleDTO();

        List<Salary> salaries = role.getSalaries();
        Collections.sort(salaries, Comparator.comparingDouble(Salary::getBasicSalary));

        int size = salaries.size();
        double userSalary = 80000;

        double minSalary = salaries.get(0).getBasicSalary();
        double maxSalary = salaries.get(size-1).getBasicSalary();
        double medSalary = roleDTO.medianValue(salaries);
        double salaryPercentile = roleDTO.percentileValue(salaries, userSalary);

        double diffMinSalary = userSalary - minSalary;
        double diffMaxSalary = userSalary - maxSalary;
        double diffMedSalary = userSalary - medSalary;

        if (role == null) {
            return null;
        }
            roleDTO.setRoleId(role.getRoleId());
            roleDTO.setRoleName(role.getRoleName());
            roleDTO.setRoleDiscipline(role.getRoleDiscipline());
            roleDTO.setSkills(role.getSkills()); // Include the skills
            roleDTO.setSalaries(role.getSalaries());
            roleDTO.setUserSalary(userSalary);
            roleDTO.setMedSalary(medSalary);
            roleDTO.setMinSalary(minSalary);
            roleDTO.setMaxSalary(maxSalary);
            roleDTO.setDiffMedSalary(diffMedSalary);
            roleDTO.setDiffMinSalary(diffMinSalary);
            roleDTO.setDiffMaxSalary(diffMaxSalary);
            roleDTO.setRolePercentile(salaryPercentile);
            return roleDTO;
        }

   
        @GetMapping("/roles/global-stats")
        public GlobalStatsDTO getGlobalStats() {
            double userSalary = 80000;

            List<Role> allRoles = roleRepository.findAll();
            GlobalStatsDTO globalStatsDTO = new GlobalStatsDTO();

            if (allRoles == null) {
            return null;
        }

            // Extract all salaries from all roles.
            List<Salary> allSalaries = new ArrayList<>();
            for (Role role : allRoles) {
                allSalaries.addAll(role.getSalaries());
            }

            if (allSalaries.isEmpty()) {
                return null;
            }

            // Sort all salaries.
            Collections.sort(allSalaries, Comparator.comparingDouble(Salary::getBasicSalary));

            GlobalStatsDTO globalStats = new GlobalStatsDTO();
            int size = allSalaries.size();
            globalStats.setUserSalary(userSalary);
            globalStats.setGlobalMinSalary(allSalaries.get(0).getBasicSalary());
            globalStats.setGlobalMaxSalary(allSalaries.get(size - 1).getBasicSalary());
            globalStats.setGlobalMedianSalary(globalStatsDTO.medianValue(allSalaries));
            globalStats.setPercentile(globalStatsDTO.percentileValue(allSalaries, userSalary));
            // globalStats.setSalaries(allSalaries);

            return globalStats;

    }

}

