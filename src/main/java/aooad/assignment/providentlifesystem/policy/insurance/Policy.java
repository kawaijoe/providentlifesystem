package aooad.assignment.providentlifesystem.policy.insurance;

import aooad.assignment.providentlifesystem.policy.Payout;
import aooad.assignment.providentlifesystem.policy.state.Active;
import aooad.assignment.providentlifesystem.policy.state.State;

import java.util.List;

public abstract class Policy {

    public static int lastPolicyNumber = 0;
    private int policyNumber;
    private String termsCondition;
    private State state = new Active();
    private List<Payout> payoutList;

    // Premium

    public static int getLastPolicyNumber() {
        return lastPolicyNumber;
    }

    public static void setLastPolicyNumber(int lastPolicyNumber) {
        Policy.lastPolicyNumber = lastPolicyNumber;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getTermsCondition() {
        return termsCondition;
    }

    public void setTermsCondition(String termsCondition) {
        this.termsCondition = termsCondition;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
