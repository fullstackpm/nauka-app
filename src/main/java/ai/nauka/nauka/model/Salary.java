package ai.nauka.nauka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Salary {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long salaryId;
    private int age; 
    private String gender;
    private String educationLevel;
    private String roleName;
    private int yearsOfExperience;
    private double basicSalary;
    private String currency;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Salary() {
    }


    public Salary(long salaryId, int age, String gender, String educationLevel, String roleName, int yearsOfExperience,
            double basicSalary, String currency) {
        this.salaryId = salaryId;
        this.age = age;
        this.gender = gender;
        this.educationLevel = educationLevel;
        this.roleName = roleName;
        this.yearsOfExperience = yearsOfExperience;
        this.basicSalary = basicSalary;
        this.currency = currency;
    }

    public long getSalaryId() {
        return salaryId;
    }


    public void setSalaryId(long salaryId) {
        this.salaryId = salaryId;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getEducationLevel() {
        return educationLevel;
    }


    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }


    public String getRoleName() {
        return roleName;
    }


    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public int getYearsOfExperience() {
        return yearsOfExperience;
    }


    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }


    public double getBasicSalary() {
        return basicSalary;
    }


    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }


    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public Role getRole() {
        return role;
    }


    public void setRole(Role role) {
        this.role = role;
    }

    
    
}
