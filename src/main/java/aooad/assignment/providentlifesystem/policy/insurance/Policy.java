package aooad.assignment.providentlifesystem.policy.insurance;

import aooad.assignment.providentlifesystem.policy.premium.PremiumType;
import aooad.assignment.providentlifesystem.policy.premium.Premium;
import aooad.assignment.providentlifesystem.policy.decorator.Rider;
import aooad.assignment.providentlifesystem.policy.state.Active;
import aooad.assignment.providentlifesystem.policy.state.State;

import java.util.Date;


public abstract class Policy implements Rider {

    public static int lastPolicyNumber = 1;
    private int policyNumber;
    private String termsCondition;
    private Premium premium;
    private State state = new Active();

    public Policy(String termsCondition, Date lastPaid, PremiumType premiumType) {
        this.policyNumber = lastPolicyNumber++;
        this.termsCondition = termsCondition;
        this.premium = new Premium(lastPaid, premiumType, this);
    }

    public static int getLastPolicyNumber() {
        return lastPolicyNumber;
    }

    public static void setLastPolicyNumber(int lastPolicyNumber) {
        Policy.lastPolicyNumber = lastPolicyNumber;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getTermsCondition() {
        return termsCondition;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Premium getPremium() {
        return premium;
    }
}
