package aooad.assignment.providentlifesystem.policy;

import aooad.assignment.providentlifesystem.policy.state.Terminated;
import aooad.assignment.providentlifesystem.system.CreditCardFacade;

import java.util.Calendar;
import java.util.HashMap;

public class Payout {

    private static HashMap<Integer, Double> severityMap = new HashMap<Integer, Double>()
    {{
        put(0, 0.0);
        put(1, 50.0);
        put(2, 75.0);
        put(3, 100.0);
    }};

    private Policy policy;
    private int severity;

    public Payout(Policy policy) {
        this.policy = policy;
        this.severity = 0;
    }

    public Payout(Policy policy, int severity) {
        this.policy = policy;
        this.severity = severity;
    }

    public double getPayoutAmount() {
        return policy.calculatePayout() + severityMap.get(severity);
    }

    public void completePayout() {
        if(policy.getMaturityDate() == null) {
            CreditCardFacade.makePayment(getPayoutAmount());
        } else {
            if(policy.getMaturityDate().getTimeInMillis() < Calendar.getInstance().getTimeInMillis()) {
                CreditCardFacade.makePayment(getPayoutAmount());
                policy.setState(Terminated.getInstance());
            } else {
                System.out.println("Cannot complete payout! Maturity date have not been reached.");
            }
        }
    }

}
