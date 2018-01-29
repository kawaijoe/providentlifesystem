package aooad.assignment.providentlifesystem.policy.decorator.rider;

import aooad.assignment.providentlifesystem.policy.decorator.PolicyDecorator;
import aooad.assignment.providentlifesystem.policy.decorator.Rider;

import java.util.List;

public class GenericRider extends PolicyDecorator {

    private String name;
    private double price;

    public GenericRider(Rider policy, String name, double price) {
        super(policy);
        this.name = name;
        this.price = price;
    }

    public double calculateCost() {
        return super.calculateCost() + price;
    }

    public List<Rider> getPolicies() {
        return null;
    }
}
