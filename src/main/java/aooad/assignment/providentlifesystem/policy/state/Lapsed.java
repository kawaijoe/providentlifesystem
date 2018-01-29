package aooad.assignment.providentlifesystem.policy.state;

import aooad.assignment.providentlifesystem.policy.decorator.Rider;
import aooad.assignment.providentlifesystem.policy.insurance.Policy;

public class Lapsed extends State {

    public Lapsed() {
        super();
    }

    public Lapsed(String information) {
        super(information);
    }

    public void makePayment(Policy policy) {
        policy.getPremium().makePayment();
    }

    public void payout(Rider rider) {
        System.out.println("Policy have been lapsed.");
    }

    public void payout(Rider rider, int severity) {
        System.out.println("Policy have been lapsed.");
    }
}
