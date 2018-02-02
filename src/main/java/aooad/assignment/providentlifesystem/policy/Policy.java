package aooad.assignment.providentlifesystem.policy;

import aooad.assignment.providentlifesystem.policy.decorator.PolicyDecorator;
import aooad.assignment.providentlifesystem.policy.decorator.Rider;
import aooad.assignment.providentlifesystem.policy.premium.Premium;
import aooad.assignment.providentlifesystem.policy.premium.PremiumType;
import aooad.assignment.providentlifesystem.policy.state.Active;
import aooad.assignment.providentlifesystem.policy.state.State;

import java.util.List;

public class Policy implements Rider {

    private static int lastPolicyNumber = 1;
    private int policyNumber;
    private String termsCondition;

    private Premium premium;
    private State state;
    private PolicyDecorator policyDecorator;

    public Policy(PremiumType premiumType, String termsCondition, PolicyDecorator policyDecorator) {
        policyNumber = lastPolicyNumber++;
        this.termsCondition = termsCondition;
        premium = new Premium(premiumType, this);
        state = new Active(this);
        this.policyDecorator = policyDecorator;
    }

    public void addRider(PolicyDecorator policyDecorator) {
        policyDecorator.setRider(this.policyDecorator);
        this.policyDecorator = policyDecorator;
    }

    public double calculateCost() {
        return policyDecorator.calculateCost();
    }

    public double calculatePayout() {
        return policyDecorator.calculatePayout();
    }

    public List<Rider> getPolicies() {
        return null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getTermsCondition() {
        return termsCondition;
    }

    public Premium getPremium() {
        return premium;
    }

    public Rider getPolicyDecorator() {
        return policyDecorator;
    }
}
