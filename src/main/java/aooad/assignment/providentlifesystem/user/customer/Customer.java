package aooad.assignment.providentlifesystem.user.customer;

import aooad.assignment.providentlifesystem.collection.PolicyCollection;
import aooad.assignment.providentlifesystem.policy.Policy;
import aooad.assignment.providentlifesystem.user.User;

public class Customer extends User {

    private static int last_id = 0;

    private PolicyCollection policyCollection = new PolicyCollection();

    public Customer(String name, String password) {
        super(name, last_id++, password);
    }

    public void viewPolicies() {
    }

}
