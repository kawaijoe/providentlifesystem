package aooad.assignment.providentlifesystem.policy.state;

import aooad.assignment.providentlifesystem.policy.Policy;

public interface State {

    void makeCreditPayment(Policy policy, String creditCardNumber);

    void makeChequePayment(Policy policy);

    void getPayout(Policy policy, String creditCardNumber);

    void getPayout(Policy policy, String creditCardNumber, int severity);

    void setLapse(Policy policy);

    default void terminate(Policy policy) {
        policy.setState(Terminated.getInstance());
    }

}
