package aooad.assignment.providentlifesystem.policy.decorator;

import java.util.List;

public class BasePolicy extends PolicyDecorator {

    public BasePolicy(String name, double price) {
        super(name, price, 0);
    }

    public BasePolicy(String name, double price, double payout) {
        super(name, price, payout);
    }

    public double calculateCost() {
        return price;
    }

    public double calculatePayout() {
        return payout;
    }

    public List<Rider> getPolicies() {
        return null;
    }
}
