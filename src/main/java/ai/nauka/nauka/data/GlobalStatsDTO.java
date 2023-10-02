package ai.nauka.nauka.data;

import java.util.List;

import ai.nauka.nauka.model.Salary;

public class GlobalStatsDTO {

    private double userSalary;
    private double globalMedianSalary;
    private double globalMinSalary;
    private double globalMaxSalary;
    private double percentile;

    // private List<Salary> salaries;

    public double getGlobalMedianSalary() {
        return globalMedianSalary;
    }
    public double getGlobalMinSalary() {
        return globalMinSalary;
    }
    public double getGlobalMaxSalary() {
        return globalMaxSalary;
    }

    public void setGlobalMedianSalary(double globalMedianSalary) {
        this.globalMedianSalary = globalMedianSalary;
    }
    public void setGlobalMinSalary(double globalMinSalary) {
        this.globalMinSalary = globalMinSalary;
    }
    public void setGlobalMaxSalary(double globalMaxSalary) {
        this.globalMaxSalary = globalMaxSalary;
    }
    // public List<Salary> getSalaries() {
    //     return salaries;
    // }
    // public void setSalaries(List<Salary> salaries) {
    //     this.salaries = salaries;
    // }
    public double getUserSalary() {
        return userSalary;
    }
    public void setUserSalary(double userSalary) {
        this.userSalary = userSalary;
    }
    public double getPercentile() {
        return percentile;
    }
    public void setPercentile(double percentile) {
        this.percentile = percentile;
    }


    public double medianValue(List<Salary> salaries) {
    int size = salaries.size();
    if (size % 2 == 0)
        return (salaries.get(size / 2 - 1).getBasicSalary() + salaries.get(size / 2).getBasicSalary()) / 2.0;
    else
        return salaries.get(size / 2).getBasicSalary();
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
