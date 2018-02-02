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

    public List<Rider> getPolicies() {
        return rider.getPolicies();
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public double calculateCost() {
        return rider.calculateCost() + price;
    }

    public double calculatePayout() {
        return rider.calculatePayout() + payout;
    }

    public String getName() {
        return name;
    }
}
