package ai.nauka.nauka.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String jobTitle;
    private int totalEntries;
    private double minSalary;
    private double maxSalary;
    private double medianSalary;

    @Transient
    private List<Salary> salaries;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public int getTotalEntries() {
        return totalEntries;
    }
    public void setTotalEntries(int totalEntries) {
        this.totalEntries = totalEntries;
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
    public double getMedianSalary() {
        return medianSalary;
    }
    public void setMedianSalary(double medianSalary) {
        this.medianSalary = medianSalary;
    }
    public List<Salary> getSalaries() {
        return salaries;
    }
    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }
    
    public Role(String jobTitle, int totalEntries, double minSalary, double maxSalary, double medianSalary) {
        this.jobTitle = jobTitle;
        this.totalEntries = totalEntries;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.medianSalary = medianSalary;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role [jobTitle=" + jobTitle + ", totalEntries=" + totalEntries + ", minSalary=" + minSalary
                + ", maxSalary=" + maxSalary + ", medianSalary=" + medianSalary + "]";
    }

    
    
}
