package aooad.assignment.providentlifesystem.policy.decorator;

import java.util.ArrayList;
import java.util.List;

public class BasePolicy extends PolicyDecorator {

    public BasePolicy(String name, double price) {
        super(name, price, 0);
    }

    public BasePolicy(String name, double price, double payout) {
        super(name, price, payout);
    }

    @Override
    public double calculateCost() {
        return price;
    }

    @Override
    public double calculatePayout() {
        return payout;
    }

    @Override
    public List<Rider> getPolicies() {
        List<Rider> list = new ArrayList<>();
        list.add(this);
        return list;
    }
}
