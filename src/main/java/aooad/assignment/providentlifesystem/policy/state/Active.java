package aooad.assignment.providentlifesystem.policy.state;

import aooad.assignment.providentlifesystem.policy.Payout;
import aooad.assignment.providentlifesystem.policy.Policy;

public class Active implements State {

    private static State ourInstance = new Active();

    public static State getInstance() {
        return ourInstance;
    }

    @Override
    public void makeCreditPayment(Policy policy, String creditCardNumber) {
        policy.getPremium().creditCardPayment(creditCardNumber);
    }

    @Override
    public void makeChequePayment(Policy policy) {
        policy.getPremium().chequePayment();
    }

    @Override
    public void getPayout(Policy policy, String creditCardNumber) {
        Payout payout = new Payout(policy);
        payout.completePayout(creditCardNumber);
    }

    @Override
    public void getPayout(Policy policy, String creditCardNumber, int severity) {
        Payout payout = new Payout(policy, severity);
        payout.completePayout(creditCardNumber);
    }

    @Override
    public void setLapse(Policy policy) {
        policy.getPremium().setLapsed();
    }
}
