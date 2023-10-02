package ai.nauka.nauka.data;

import java.util.List;

import ai.nauka.nauka.model.Salary;
import ai.nauka.nauka.model.Skill;

public class RoleDTO {
    private long roleId;
    private String roleName;
    private String roleDiscipline;
    private double userSalary;
    private double medSalary;
    private double minSalary;
    private double maxSalary;
    private double diffMedSalary;
    private double diffMinSalary;
    private double diffMaxSalary;
    private double rolePercentile;
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
    public double getDiffMedSalary() {
        return diffMedSalary;
    }
    public void setDiffMedSalary(double diffMedSalary) {
        this.diffMedSalary = diffMedSalary;
    }
    public double getDiffMinSalary() {
        return diffMinSalary;
    }
    public void setDiffMinSalary(double diffMinSalary) {
        this.diffMinSalary = diffMinSalary;
    }
    public double getDiffMaxSalary() {
        return diffMaxSalary;
    }
    public void setDiffMaxSalary(double diffMaxSalary) {
        this.diffMaxSalary = diffMaxSalary;
    }
    public double getMedSalary() {
        return medSalary;
    }
    public void setMedSalary(double medSalary) {
        this.medSalary = medSalary;
    }
    public double getMinSalary() {
        return minSalary;
    }
    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }
    public double getMaxSalary() {
        return maxSalary;
    }
    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }
    public double getRolePercentile() {
        return rolePercentile;
    }
    public void setRolePercentile(double rolePercentile) {
        this.rolePercentile = rolePercentile;
    }
    public double getUserSalary() {
        return userSalary;
    }
    public void setUserSalary(double userSalary) {
        this.userSalary = userSalary;
    }

    public double medianValue(List<Salary> salaries) {
        double medSalary = 0;

        int size = salaries.size();
        if (salaries != null && !salaries.isEmpty()) {
            if (size % 2 == 0)
                medSalary = ((double) (salaries.get(size / 2 - 1).getBasicSalary() + salaries.get(size / 2).getBasicSalary()) / 2);
            else
                medSalary = ((double) salaries.get(size / 2).getBasicSalary());
            }
        return medSalary;
    }

    public double percentileValue(List<Salary> salaries, double userSalary) {
        int countBelow = 0;
        int countEqual = 0;

        for (Salary salary : salaries) {
            double basicSalary = salary.getBasicSalary();
            if (userSalary > basicSalary) {
                countBelow++;
            } else if (userSalary == basicSalary) {
                countEqual++;
            }
        }

        int totalValues = salaries.size();
        double percentile = ((countBelow + 0.5 * countEqual) / totalValues) * 100;

        return percentile;
    }
}
