package ai.nauka.nauka.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;
    private String roleName;
    private String roleDiscipline;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, 
        fetch = FetchType.LAZY)
    @JoinTable(name = "role_skill", 
        joinColumns = @JoinColumn(name="role_id"), 
        inverseJoinColumns = @JoinColumn(name="skill_id"))
    @JsonIgnore
    List<Skill> skills;
    @OneToMany(mappedBy = "role")
    @JsonIgnore
    List<Salary> salaries;

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
    public void setDiscipline(String roleDiscipline) {
        this.roleDiscipline = roleDiscipline;
    }
    public List<Skill> getSkills() {
        return skills;
    }
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
    public void setRoleDiscipline(String roleDiscipline) {
        this.roleDiscipline = roleDiscipline;
    }
    public List<Salary> getSalaries() {
        return salaries;
    }
    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }
    public Role(long roleId, String roleName, String roleDiscipline) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDiscipline = roleDiscipline;
    }

    public Role() {
    }


}
