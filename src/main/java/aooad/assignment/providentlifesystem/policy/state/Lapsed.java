package aooad.assignment.providentlifesystem.policy.state;

import aooad.assignment.providentlifesystem.policy.Policy;
import aooad.assignment.providentlifesystem.policy.decorator.Rider;
import aooad.assignment.providentlifesystem.policy.decorator.BasePolicy;

public class Lapsed extends State {

    private String errorMessage = "State have been Lapsed!";

    public Lapsed(Policy policy) {
        super(policy);
    }

    public Lapsed(Policy policy, String errorMessage) {
        super(policy);
        this.errorMessage = errorMessage;
    }

    @Override
    public void makePayment() {
        policy.getPremium().creditCardPayment();
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
