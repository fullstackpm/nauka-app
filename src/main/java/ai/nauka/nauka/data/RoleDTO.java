package ai.nauka.nauka.data;

import java.util.List;

import ai.nauka.nauka.model.Salary;
import ai.nauka.nauka.model.Skill;

public class RoleDTO {
    private long roleId;
    private String roleName;
    private String roleDiscipline;
    private List<Skill> skills;
    private List<Salary> salaries;
    
    public long getRoleId() {
        return roleId;
    }
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleDiscipline() {
        return roleDiscipline;
    }
    public void setRoleDiscipline(String roleDiscipline) {
        this.roleDiscipline = roleDiscipline;
    }
    public List<Skill> getSkills() {
        return skills;
    }
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
    public List<Salary> getSalaries() {
        return salaries;
    }
    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }
    

    
}
