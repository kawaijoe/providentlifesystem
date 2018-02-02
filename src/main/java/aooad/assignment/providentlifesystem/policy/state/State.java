package aooad.assignment.providentlifesystem.policy.state;

import aooad.assignment.providentlifesystem.policy.Policy;

public abstract class State {

    protected Policy policy;

    State(Policy policy) {
        this.policy = policy;
    }

    public abstract void makePayment();

    public abstract void getPayout();

    public abstract void getPayout(int severity);

}
