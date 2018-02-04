package aooad.assignment.providentlifesystem.policy.decorator;

import java.util.List;

public class PolicyDecorator implements Rider {

    protected Rider rider;
    protected String name;
    protected double price;
    protected double payout;

    public PolicyDecorator(String name, double price, double payout) {
        this.name = name;
        this.price = price;
        this.payout = payout;
    }

    @Override
    public List<Rider> getPolicies() {
        List<Rider> list = rider.getPolicies();
        list.add(this);
        return list;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    @Override
    public double calculateCost() {
        return rider.calculateCost() + price;
    }

    @Override
    public double calculatePayout() {
        return rider.calculatePayout() + payout;
    }

    public String getName() {
        return name;
    }
}
