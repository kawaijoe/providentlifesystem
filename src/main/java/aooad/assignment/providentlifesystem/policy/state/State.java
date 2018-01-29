package aooad.assignment.providentlifesystem.policy.state;

import aooad.assignment.providentlifesystem.policy.decorator.Rider;
import aooad.assignment.providentlifesystem.policy.insurance.Policy;

public abstract class State {

    private String information = "";

    public State() { }

    public State(String information) {
        this.information = information;
    }

    public abstract void makePayment(Policy policy);

    public abstract void payout(Rider policy);

    public abstract void payout(Rider rider, int severity);

    public void cancelledByAgent(Policy policy) {
        policy.setState(Terminated.AGENT);
    }

    public void cancelledByClient(Policy policy) {
        policy.setState(Terminated.CLIENT);
    }

    public String getInformation() {
        return information;
    }

}
