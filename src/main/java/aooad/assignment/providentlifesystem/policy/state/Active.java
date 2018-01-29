package aooad.assignment.providentlifesystem.policy.state;

import aooad.assignment.providentlifesystem.policy.Payout;
import aooad.assignment.providentlifesystem.policy.decorator.Rider;
import aooad.assignment.providentlifesystem.policy.insurance.Policy;

public class Active extends State {

    public Active() {
        super();
    }

    public Active(String information) {
        super(information);
    }

    public void makePayment(Policy policy) {
        policy.getPremium().makePayment();
    }

    public void payout(Rider rider) {
        Payout payout = new Payout(rider, 0);
    }

    public void payout(Rider rider, int severity) {
        Payout payout = new Payout(rider, severity);
    }
}
