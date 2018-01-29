package aooad.assignment.providentlifesystem.policy.insurance;

import aooad.assignment.providentlifesystem.policy.decorator.Rider;

import java.util.List;

public class MedicalPolicy extends Policy implements Rider {
    public double calculateCost() {
        return 100;
    }

    public List<Rider> getPolicies() {
        return null;
    }
}
