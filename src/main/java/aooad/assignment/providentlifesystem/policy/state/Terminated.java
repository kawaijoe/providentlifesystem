package aooad.assignment.providentlifesystem.policy.state;

import aooad.assignment.providentlifesystem.policy.decorator.Rider;
import aooad.assignment.providentlifesystem.policy.insurance.Policy;

public class Terminated extends State {

    public static final State AGENT = new Terminated("Policy terminated by Agent.");
    public static final State CLIENT = new Terminated("Policy terminated by Client.");
    public static final State PAID_OUT = new Terminated("Policy terminated. Paid out.");

    public Terminated() {
        super();
    }

    public Terminated(String information) {
        super(information);
    }

    public void makePayment(Policy policy) {
        System.out.println(getInformation());
    }

    public void payout(Rider policy) {
        System.out.println(getInformation());
    }

    public void payout(Rider rider, int severity) {
        System.out.println(getInformation());
    }
}
