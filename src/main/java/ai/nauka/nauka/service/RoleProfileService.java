package ai.nauka.nauka.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ai.nauka.nauka.data.RoleDTO;
import ai.nauka.nauka.model.Role;
import ai.nauka.nauka.model.Salary;
import ai.nauka.nauka.model.Skill;
import ai.nauka.nauka.repository.RoleRepository;
import ai.nauka.nauka.repository.SalaryRepository;
import ai.nauka.nauka.repository.SkillRepository;

@Service
public class RoleProfileService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private SalaryRepository salaryRepository;
    @Autowired
    private SkillRepository skillRepository;

    public RoleDTO getRoleProfile(String roleName) {
        Role role = roleRepository.findByRoleName(roleName);
        List<Salary> salaries = salaryRepository.findSalariesByRoleName(roleName);
        List<Skill> skills = skillRepository.findSkillsByRoleName(roleName);
        RoleDTO roleDTO = new RoleDTO();

        int size = salaries.size();
        double userSalary = 80000;
        double minSalary = salaries.get(0).getBasicSalary();
        double maxSalary = salaries.get(size-1).getBasicSalary();
        double medSalary = roleDTO.medianValue(salaries);
        double salaryPercentile = roleDTO.percentileValue(salaries, userSalary);
        double diffMinSalary = userSalary - minSalary;
        double diffMaxSalary = userSalary - maxSalary;
        double diffMedSalary = userSalary - medSalary;

        roleDTO.setRoleId(role.getRoleId());
        roleDTO.setRoleName(role.getRoleName());
        roleDTO.setRoleDiscipline(role.getRoleDiscipline());
        roleDTO.setSkills(skills); // Include the skills
        roleDTO.setSalaries(salaries);
        Collections.sort(salaries, Comparator.comparingDouble(Salary::getBasicSalary));

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
    
}


//  @GetMapping("/roles/{roleName}")
//     public RoleDTO getRole(@PathVariable String roleName) {
//         Role role = roleRepository.findByRoleName(roleName);
        
//         // Role global = roleRepository.findAllByRole();

//         RoleDTO roleDTO = new RoleDTO();

//         List<Salary> salaries = role.getSalaries();
//         Collections.sort(salaries, Comparator.comparingDouble(Salary::getBasicSalary));

//         int size = salaries.size();
//         double userSalary = 80000;

//         double minSalary = salaries.get(0).getBasicSalary();
//         double maxSalary = salaries.get(size-1).getBasicSalary();
//         double medSalary = roleDTO.medianValue(salaries);
//         double salaryPercentile = roleDTO.percentileValue(salaries, userSalary);

//         double diffMinSalary = userSalary - minSalary;
//         double diffMaxSalary = userSalary - maxSalary;
//         double diffMedSalary = userSalary - medSalary;

//         if (role == null) {
//             return null;
//         }
//             roleDTO.setRoleId(role.getRoleId());
//             roleDTO.setRoleName(role.getRoleName());
//             roleDTO.setRoleDiscipline(role.getRoleDiscipline());
//             roleDTO.setSkills(role.getSkills()); // Include the skills
//             roleDTO.setSalaries(role.getSalaries());
//             roleDTO.setUserSalary(userSalary);
//             roleDTO.setMedSalary(medSalary);
//             roleDTO.setMinSalary(minSalary);
//             roleDTO.setMaxSalary(maxSalary);
//             roleDTO.setDiffMedSalary(diffMedSalary);
//             roleDTO.setDiffMinSalary(diffMinSalary);
//             roleDTO.setDiffMaxSalary(diffMaxSalary);
//             roleDTO.setRolePercentile(salaryPercentile);
//             return roleDTO;
//         }