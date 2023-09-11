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

@Entity
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long skillId;
    private String skillName;
    private String skillType;
    private String roleName;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, 
        fetch = FetchType.LAZY)
    @JoinTable(name = "role_skill", 
        joinColumns = @JoinColumn(name="skill_id"), 
        inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles;
    
    
    public long getSkillId() {
        return skillId;
    }
    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    public String getSkillName() {
        return skillName;
    }
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
    public String getSkillType() {
        return skillType;
    }
    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public Skill(long skillId, String skillName, String skillType, String roleName) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.skillType = skillType;
        this.roleName = roleName;
    }

    public Skill() {
    }

    
}
