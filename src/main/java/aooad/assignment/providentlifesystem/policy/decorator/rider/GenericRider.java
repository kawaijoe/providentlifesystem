package aooad.assignment.providentlifesystem.policy.decorator.rider;

import aooad.assignment.providentlifesystem.policy.decorator.PolicyDecorator;
import aooad.assignment.providentlifesystem.policy.decorator.Rider;

public class GenericRider extends PolicyDecorator {

    public GenericRider(String name, double price, double payout) {
        super(name, price, payout);
    }

}
