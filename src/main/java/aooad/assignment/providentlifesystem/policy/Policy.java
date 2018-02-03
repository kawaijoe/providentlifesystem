package aooad.assignment.providentlifesystem.policy;

import aooad.assignment.providentlifesystem.policy.decorator.PolicyDecorator;
import aooad.assignment.providentlifesystem.policy.decorator.Rider;
import aooad.assignment.providentlifesystem.policy.premium.OneTimePremium;
import aooad.assignment.providentlifesystem.policy.premium.Premium;
import aooad.assignment.providentlifesystem.policy.state.Active;
import aooad.assignment.providentlifesystem.policy.state.State;

import java.util.Calendar;
import java.util.List;

public class Policy implements Rider {

    private static int lastPolicyNumber = 1;
    private int policyNumber = lastPolicyNumber++;
    private String termsCondition;

    private Premium premium;
    private State state = Active.getInstance();
    private PolicyDecorator policyDecorator;
    private Calendar maturityDate;

    public Policy(PolicyDecorator policyDecorator, String termsCondition) {
        this.termsCondition = termsCondition;
        this.policyDecorator = policyDecorator;
        premium = new OneTimePremium(this);
    }

    public Policy(PolicyDecorator policyDecorator, String termsCondition, int paymentInterval) {
        this.termsCondition = termsCondition;
        this.policyDecorator = policyDecorator;
        premium = new Premium(this, paymentInterval);
    }

    public void addRider(PolicyDecorator policyDecorator) {
        policyDecorator.setRider(this.policyDecorator);
        this.policyDecorator = policyDecorator;
    }

    public PolicyDecorator getPolicyDecorator() {
        return policyDecorator;
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

    public void setMaturityDate(Calendar maturityDate) {
        if(maturityDate != null) {
            this.maturityDate = maturityDate;
        } else {
            System.out.println("Cannot change maturity date once set!");
        }
    }

    public Calendar getMaturityDate() {
        return maturityDate;
    }

    public Premium getPremium() {
        return premium;
    }
}
