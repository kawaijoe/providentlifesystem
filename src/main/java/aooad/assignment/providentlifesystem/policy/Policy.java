package aooad.assignment.providentlifesystem.policy;

import aooad.assignment.providentlifesystem.policy.decorator.Rider;
import aooad.assignment.providentlifesystem.policy.premium.OneTimePremium;
import aooad.assignment.providentlifesystem.policy.premium.Premium;
import aooad.assignment.providentlifesystem.policy.state.Active;
import aooad.assignment.providentlifesystem.policy.state.State;

import java.util.Calendar;
import java.util.List;

public class Policy {

    private static int lastPolicyNumber = 1;
    private int policyNumber = lastPolicyNumber++;
    private String termsCondition;

    private Premium premium;
    private State state = Active.getInstance();
    private Rider rider;
    private Calendar maturityDate;

    public Policy(Rider rider, String termsCondition) {
        this.termsCondition = termsCondition;
        this.rider = rider;
        premium = new OneTimePremium(this);
    }

    public Policy(Rider rider, String termsCondition, int paymentInterval) {
        this.termsCondition = termsCondition;
        this.rider = rider;
        premium = new Premium(this, paymentInterval);
    }

    public void addRider(Rider rider) {
        rider.setRider(this.rider);
        this.rider = rider;
    }

    public Rider getRider() {
        return rider;
    }

    public double calculateCost() {
        return rider.calculateCost();
    }

    public double calculatePayout() {
        return rider.calculatePayout();
    }

    private List<Rider> getPolicies() {
        return rider.getPolicies();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<Rider> riderList = getPolicies();
        sb.append(riderList.get(0).getName());
        for(int i = 1; i < riderList.size(); i++) {
            sb.append("\n - ");
            sb.append(riderList.get(i).getName());
        }
        return sb.toString();
    }
}
