package aooad.assignment.providentlifesystem.policy.insurance;

import aooad.assignment.providentlifesystem.policy.decorator.Rider;

import java.util.List;

public class TravelPolicy extends Policy implements Rider {

    public double calculateCost() {
        return 25.0;
    }

    public List<Rider> getPolicies() {
        return null;
    }

}
