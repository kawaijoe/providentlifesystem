package aooad.assignment.providentlifesystem.policy.decorator;

import java.util.List;

public interface Rider {

    double calculateCost();
    List<Rider> getPolicies();
    
}
