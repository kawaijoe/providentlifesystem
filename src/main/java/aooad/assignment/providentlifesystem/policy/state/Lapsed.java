package aooad.assignment.providentlifesystem.policy.state;

import aooad.assignment.providentlifesystem.policy.Policy;

public class Lapsed implements State {

    private static State ourInstance = new Lapsed();

    public static State getInstance() {
        return ourInstance;
    }

    private final String ERROR_MESSAGE = "State have been Lapsed!";

    @Override
    public void makeCreditPayment(Policy policy, String creditCardNumber) {
        policy.getPremium().creditCardPayment(creditCardNumber, 7);
    }

    @Override
    public void makeChequePayment(Policy policy) {
        policy.getPremium().chequePayment();
    }

    @Override
    public void getPayout(Policy policy, String creditCardNumber) {
        System.out.println(ERROR_MESSAGE);
    }

    @Override
    public void getPayout(Policy policy, String creditCardNumber, int severity) {
        System.out.println(ERROR_MESSAGE);
    }

    @Override
    public void setLapse(Policy policy) {
        System.out.println(ERROR_MESSAGE);
    }
}
