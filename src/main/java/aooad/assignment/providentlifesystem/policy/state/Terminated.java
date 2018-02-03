package aooad.assignment.providentlifesystem.policy.state;

import aooad.assignment.providentlifesystem.policy.Policy;

public class Terminated implements State {

    private static State ourInstance = new Terminated();

    public static State getInstance() {
        return ourInstance;
    }

    private final String ERROR_MESSAGE = "State have been terminated!";

    @Override
    public void makePayment(Policy policy) {
        System.out.println(ERROR_MESSAGE);
    }

    @Override
    public void getPayout(Policy policy) {
        System.out.println(ERROR_MESSAGE);
    }

    @Override
    public void getPayout(Policy policy, int severity) {
        System.out.println(ERROR_MESSAGE);
    }
}
