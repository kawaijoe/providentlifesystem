package aooad.assignment.providentlifesystem.policy.premium;

import aooad.assignment.providentlifesystem.policy.insurance.Policy;
import aooad.assignment.providentlifesystem.policy.state.Active;
import aooad.assignment.providentlifesystem.policy.state.Lapsed;
import aooad.assignment.providentlifesystem.policy.state.State;
import aooad.assignment.providentlifesystem.policy.state.Terminated;
import aooad.assignment.providentlifesystem.system.CreditCardFacade;

import java.util.Date;

public class Premium {

    private Date lastPaid;
    private PremiumType premiumType;
    private State state;
    private Policy policy;

    public Premium(Date lastPaid, PremiumType premiumType, Policy policy) {
        this.lastPaid = lastPaid;
        this.premiumType = premiumType;
        this.state = policy.getState();
        this.policy = policy;
    }

    public void checkUnpaid() {
        boolean unpaid = false;
        switch(premiumType) {
            case MONTHLY:
                // TODO: Check if expired
                unpaid = true;
                break;
            case YEARLY:
                // TODO: Check if expired
                unpaid = true;
                break;
        }
        if(unpaid) state = new Lapsed();
        else if (!(state instanceof Terminated)) state = new Active();
    }

    public void makePayment() {
        if (premiumType != PremiumType.ONETIME && !(state instanceof Terminated)) {
            addTimeToLastPaid();
            checkUnpaid();
            CreditCardFacade.retrievePayment(policy.calculateCost());
        }
    }

    public void paidByCheck() {
        if(premiumType != PremiumType.ONETIME) {
            addTimeToLastPaid();
            checkUnpaid();
        }
    }

    private void addTimeToLastPaid() {
        switch (premiumType) {
            case MONTHLY:
                // TODO: Add 1 month of lastPaid
                break;
            case YEARLY:
                // TODO: Add 1 Year to lastPaid
                break;
        }
    }

}
