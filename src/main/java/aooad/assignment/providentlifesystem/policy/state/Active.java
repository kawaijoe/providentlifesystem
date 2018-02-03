package aooad.assignment.providentlifesystem.policy.state;

import aooad.assignment.providentlifesystem.policy.Payout;
import aooad.assignment.providentlifesystem.policy.Policy;

public class Active implements State {

    private static State ourInstance = new Active();

    public static State getInstance() {
        return ourInstance;
    }

    @Override
    public void makePayment(Policy policy) {
        policy.getPremium().creditCardPayment();
    }

    @Override
    public void getPayout(Policy policy) {
        Payout payout = new Payout(policy);
        payout.completePayout();
    }

    @Override
    public void getPayout(Policy policy, int severity) {
        Payout payout = new Payout(policy, severity);
        payout.completePayout();
    }
}
