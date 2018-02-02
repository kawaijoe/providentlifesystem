package aooad.assignment.providentlifesystem.policy.premium;

import aooad.assignment.providentlifesystem.policy.Policy;
import aooad.assignment.providentlifesystem.policy.state.Active;
import aooad.assignment.providentlifesystem.policy.state.Lapsed;
import aooad.assignment.providentlifesystem.policy.state.Terminated;
import aooad.assignment.providentlifesystem.system.CreditCardFacade;

import java.util.Calendar;

public class Premium {

    private Calendar lastPaid;
    private PremiumType premiumType;
    private Policy policy;

    public Premium(PremiumType premiumType, Policy policy) {
        this.lastPaid = Calendar.getInstance();
        this.premiumType = premiumType;
        this.policy = policy;
    }

    public void setLapsed() {
        if(policy.getState() instanceof Terminated) return;

        boolean unpaid = false;
        switch(premiumType) {
            case MONTHLY:
                if(dateDifferent() > 30) unpaid = true;
                break;
            case YEARLY:
                if(dateDifferent() > 365) unpaid = true;
                break;
        }

        if(unpaid) policy.setState(new Lapsed(policy));
        else policy.setState(new Active(policy));
    }

    public void creditCardPayment() {
        if(policy.getState() instanceof Terminated || premiumType != PremiumType.ONETIME) return;

        CreditCardFacade.retrievePayment(policy.calculateCost());
        policy.setState(new Active(policy));
        lastPaid = Calendar.getInstance();
    }

    public void chequePayment() {
        if(policy.getState() instanceof Terminated || premiumType != PremiumType.ONETIME) return;

        policy.setState(new Active(policy));
        lastPaid = Calendar.getInstance();
    }

    private int dateDifferent() {
        long diff = Calendar.getInstance().getTimeInMillis() - lastPaid.getTimeInMillis();
        return (int) diff / (24 * 60 * 60 * 1000);
    }

}
