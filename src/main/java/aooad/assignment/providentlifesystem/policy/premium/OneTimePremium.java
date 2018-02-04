package aooad.assignment.providentlifesystem.policy.premium;

import aooad.assignment.providentlifesystem.policy.Policy;

public class OneTimePremium extends Premium {

    private static final String ERROR_MESSAGE = "Operation could not be completed. Premium is a one-time payment.";

    public OneTimePremium(Policy policy) {
        super(policy, 0);
    }

    @Override
    public void setLapsed() {
        System.out.println(ERROR_MESSAGE);
    }

    @Override
    public void creditCardPayment(String creditCardNumber) {
        System.out.println(ERROR_MESSAGE);
    }

    @Override
    public void creditCardPayment(String creditCardNumber, int interest) {
        System.out.println(ERROR_MESSAGE);
    }

    @Override
    public void chequePayment() {
        System.out.println(ERROR_MESSAGE);
    }

}
