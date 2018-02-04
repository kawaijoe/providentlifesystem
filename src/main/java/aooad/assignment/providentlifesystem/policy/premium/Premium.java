package aooad.assignment.providentlifesystem.policy.premium;

import aooad.assignment.providentlifesystem.policy.Policy;
import aooad.assignment.providentlifesystem.policy.state.Active;
import aooad.assignment.providentlifesystem.policy.state.Lapsed;
import aooad.assignment.providentlifesystem.system.CreditCardFacade;

import java.util.Calendar;

public class Premium {

    private Calendar lastPaid;
    private Policy policy;
    private int paymentInterval;

    public Premium(Policy policy, int paymentInterval) {
        this.lastPaid = Calendar.getInstance();
        this.paymentInterval = paymentInterval;
        this.policy = policy;
    }

    public void setLapsed() {
        if(dateDifferent() > paymentInterval) {
            policy.setState(Lapsed.getInstance());
        } else {
            System.out.println("Cannot set policy as lapsed! Policy have not expired.");
        }
    }

    public void creditCardPayment() {
        CreditCardFacade.retrievePayment(policy.calculateCost());
        policy.setState(Active.getInstance());
        lastPaid = Calendar.getInstance();
    }

    public void chequePayment() {
        policy.setState(Active.getInstance());
        lastPaid = Calendar.getInstance();
    }

    private int dateDifferent() {
        long diff = Calendar.getInstance().getTimeInMillis() - lastPaid.getTimeInMillis();
        return (int) diff / (24 * 60 * 60 * 1000);
    }

    public boolean isOutstanding()
    {
        return dateDifferent() > paymentInterval;
    }
}
