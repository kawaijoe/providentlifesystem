package aooad.assignment.providentlifesystem.policy.state;

import aooad.assignment.providentlifesystem.policy.Policy;

public interface State {

    void makePayment(Policy policy);

    void getPayout(Policy policy);

    void getPayout(Policy policy, int severity);

}
