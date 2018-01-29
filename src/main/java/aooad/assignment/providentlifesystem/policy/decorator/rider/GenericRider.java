package aooad.assignment.providentlifesystem.policy.decorator.rider;

import aooad.assignment.providentlifesystem.policy.decorator.PolicyDecorator;
import aooad.assignment.providentlifesystem.policy.decorator.Rider;

import java.util.List;

public class GenericRider extends PolicyDecorator {

    private String name;
    private double price;
    private double payout;

    public GenericRider(Rider policy, String name, double price, double payout) {
        super(policy);
        this.name = name;
        this.price = price;
        this.payout = payout;
    }

    public double calculateCost() {
        return super.calculateCost() + price;
    }

    public double calculatePayout() {
        return super.calculatePayout() + payout;
    }

    public List<Rider> getPolicies() {
        return null;
    }
}
