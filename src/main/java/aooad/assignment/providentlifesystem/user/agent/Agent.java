package aooad.assignment.providentlifesystem.user.agent;

import aooad.assignment.providentlifesystem.collection.PolicyCollection;
import aooad.assignment.providentlifesystem.user.User;
import aooad.assignment.providentlifesystem.user.agent.salarystrategy.SalaryStrategy;

public class Agent extends User {

    private static int last_id = 0;

    private SalaryStrategy salaryStrategy;
    private PolicyCollection policyCollection = new PolicyCollection();

    public Agent(String name, String password, SalaryStrategy salaryStrategy) {
        super(name, last_id++, password);
        this.salaryStrategy = salaryStrategy;
    }

    public double calculatePay() {
        return salaryStrategy.getSalary();
    }

    public SalaryStrategy getSalaryStrategy() {
        return salaryStrategy;
    }

    public void setSalaryStrategy(SalaryStrategy salaryStrategy) {
        this.salaryStrategy = salaryStrategy;
    }
}
