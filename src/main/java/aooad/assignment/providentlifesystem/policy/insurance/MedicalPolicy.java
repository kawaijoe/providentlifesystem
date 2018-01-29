package aooad.assignment.providentlifesystem.policy.insurance;

import aooad.assignment.providentlifesystem.policy.decorator.Rider;
import aooad.assignment.providentlifesystem.policy.premium.PremiumType;

import java.util.Date;
import java.util.List;

public class MedicalPolicy extends Policy {
    public MedicalPolicy(String termsCondition, Date lastPaid, PremiumType premiumType) {
        super(termsCondition, lastPaid, premiumType);
    }

    public double calculateCost() {
        return 100;
    }

    public double calculatePayout() {
        return 0;
    }

    public List<Rider> getPolicies() {
        return null;
    }
}
