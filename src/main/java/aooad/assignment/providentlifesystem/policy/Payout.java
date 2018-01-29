package aooad.assignment.providentlifesystem.policy;

import aooad.assignment.providentlifesystem.policy.decorator.Rider;
import aooad.assignment.providentlifesystem.system.CreditCardFacade;

import java.util.HashMap;

public class Payout {

    private static HashMap<Integer, Double> severityMap = new HashMap<Integer, Double>()
    {{
        put(0, 0.0);
        put(1, 50.0);
        put(2, 75.0);
        put(3, 100.0);
    }};

    private Rider rider;
    private String reason;
    private int severity = 0;

    public Payout(Rider rider) {
        this.rider = rider;
    }

    public Payout(Rider rider, int severity) {
        this.rider = rider;
        this.severity = severity;
    }

    public double getPayoutAmount() {
        return rider.calculatePayout() + severityMap.get(severity);
    }

    public void completePayout() {
        CreditCardFacade.makePayment(getPayoutAmount());
    }

}
