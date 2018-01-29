package aooad.assignment.providentlifesystem.policy.decorator;

import java.util.List;

public class PolicyDecorator implements Rider {

    protected Rider rider;

    public PolicyDecorator(Rider rider) {
        this.rider = rider;
    }

    public double calculateCost() {
        return rider.calculateCost();
    }

    public double calculatePayout() {
        return rider.calculatePayout();
    }

    public List<Rider> getPolicies() {
        return rider.getPolicies();
    }
}
