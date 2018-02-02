package aooad.assignment.providentlifesystem.policy.state;

import aooad.assignment.providentlifesystem.policy.Policy;
import aooad.assignment.providentlifesystem.policy.decorator.Rider;
import aooad.assignment.providentlifesystem.policy.decorator.BasePolicy;

public class Terminated extends State {

    private String errorMessage = "State have been terminated!";

    public Terminated(Policy policy) {
        super(policy);
    }

    public Terminated(Policy policy, String errorMessage) {
        super(policy);
        this.errorMessage = errorMessage;
    }

    @Override
    public void makePayment() {
        System.out.println(errorMessage);
    }

    @Override
    public void getPayout() {
        System.out.println(errorMessage);
    }

    @Override
    public void getPayout(int severity) {
        System.out.println(errorMessage);
    }
}
