package aooad.assignment.providentlifesystem.policy.state;

public abstract class State {

    private String information;


    public State(String information) {
        this.information = information;
    }


    //public abstract void pay(Rider policy, Payment payment);

    //public abstract void charge(Rider policy, Coverage coverage);

    //public abstract Optional<Payout> claim(Rider policy, Coverage coverage, String context);

    public void cancelledByAgent(Policy policy) {
        policy.setStatus(Terminated.AGENT);
    }

    public void cancelledByClient(Policy policy) {
        policy.setStatus(Terminated.CLIENT);
    }


    public String getInformation() {
        return information;
    }

}
