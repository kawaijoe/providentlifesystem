package aooad.assignment.providentlifesystem.policy.insurance;

import aooad.assignment.providentlifesystem.policy.decorator.Rider;

import java.util.List;

public class CarPolicy extends Policy {
    public double calculateCost() {
        return 150;
    }

    public double calculatePayout() {
        return 0;
    }

    public List<Rider> getPolicies() {
        return null;
    }
}
