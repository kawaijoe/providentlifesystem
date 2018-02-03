package aooad.assignment.providentlifesystem.user.customer;

import aooad.assignment.providentlifesystem.collection.PolicyCollection;
import aooad.assignment.providentlifesystem.policy.Policy;
import aooad.assignment.providentlifesystem.user.User;

public class Customer extends User {

    private PolicyCollection policyCollection = new PolicyCollection();

    public Customer(String name, int id, String password) {
        super(name, id, password);
    }

    public void viewPolicies() {
    }

}
