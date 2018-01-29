package aooad.assignment.providentlifesystem.policy.insurance;

import aooad.assignment.providentlifesystem.policy.decorator.Rider;

import java.util.List;

public class LumpSumPolicy extends Policy {
    public double calculateCost() {
        return 100;
    }

    public double calculatePayout() {
        return 1000;
    }

    public List<Rider> getPolicies() {
        return null;
    }
}
