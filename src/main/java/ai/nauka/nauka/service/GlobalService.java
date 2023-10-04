package ai.nauka.nauka.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.nauka.nauka.data.GlobalStatsDTO;
import ai.nauka.nauka.data.RoleDTO;
import ai.nauka.nauka.model.Role;
import ai.nauka.nauka.model.Salary;
import ai.nauka.nauka.model.Skill;
import ai.nauka.nauka.repository.RoleRepository;
import ai.nauka.nauka.repository.SalaryRepository;
import ai.nauka.nauka.repository.SkillRepository;

@Service
public class GlobalService {
    
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private SalaryRepository salaryRepository;
    @Autowired
    private SkillRepository skillRepository;

    public GlobalStatsDTO getGlobalStats() {
        // List<Role> roles = roleRepository.findAll();
        List<Salary> salaries = salaryRepository.findSalaries();
        // List<Skill> skills = skillRepository.findSkillsByRoleName(roleName);
        GlobalStatsDTO globalStatsDTO = new GlobalStatsDTO();

        double userSalary = 80000;

        // Extract all salaries from all roles.
        // List<Salary> allSalaries = new ArrayList<>();
        //     for (Role role : roles) {
        //         allSalaries.addAll(role.getSalaries());
        //     }

        //     if (allSalaries.isEmpty()) {
        //         return null;
        //     }

            // Sort all salaries.
            Collections.sort(salaries, Comparator.comparingDouble(Salary::getBasicSalary));

            int size = salaries.size();
            globalStatsDTO.setUserSalary(userSalary);
            globalStatsDTO.setGlobalMinSalary(salaries.get(0).getBasicSalary());
            globalStatsDTO.setGlobalMaxSalary(salaries.get(size - 1).getBasicSalary());
            globalStatsDTO.setGlobalMedianSalary(globalStatsDTO.medianValue(salaries));
            globalStatsDTO.setPercentile(globalStatsDTO.percentileValue(salaries, userSalary));
            
            return globalStatsDTO;
    }
}