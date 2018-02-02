package aooad.assignment.providentlifesystem.policy.state;

import aooad.assignment.providentlifesystem.policy.Payout;
import aooad.assignment.providentlifesystem.policy.Policy;

public class Active extends State {

    public Active(Policy policy) {
        super(policy);
    }

    public void makePayment() {
        policy.getPremium().creditCardPayment();
    }

    public void getPayout() {
        Payout payout = new Payout(policy);
        payout.completePayout();
    }

    public void getPayout(int severity) {
        Payout payout = new Payout(policy, severity);
        payout.completePayout();
    }
}
