package aooad.assignment.providentlifesystem.policy.state;

import aooad.assignment.providentlifesystem.policy.Policy;

public interface State {

    void makeCreditPayment(Policy policy);

    void makeChequePayment(Policy policy);

    void getPayout(Policy policy);

    void getPayout(Policy policy, int severity);

    void setLapse(Policy policy);

    default void terminate(Policy policy) {
        policy.setState(Terminated.getInstance());
    }

}
