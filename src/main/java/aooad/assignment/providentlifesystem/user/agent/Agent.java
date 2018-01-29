package aooad.assignment.providentlifesystem.user.agent;

import aooad.assignment.providentlifesystem.user.User;
import aooad.assignment.providentlifesystem.user.agent.salarystrategy.SalaryStrategy;

public class Agent extends User {

    private String name;
    private int id;
    private SalaryStrategy salaryStrategy;

    public Agent(String name, int id, SalaryStrategy salaryStrategy) {
        this.name = name;
        this.id = id;
        this.salaryStrategy = salaryStrategy;
    }

    public double calculatePay() {
        return salaryStrategy.getSalary();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public SalaryStrategy getSalaryStrategy() {
        return salaryStrategy;
    }

    public void setSalaryStrategy(SalaryStrategy salaryStrategy) {
        this.salaryStrategy = salaryStrategy;
    }
}
