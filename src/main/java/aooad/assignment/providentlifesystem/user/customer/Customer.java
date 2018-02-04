package aooad.assignment.providentlifesystem.user.customer;

import aooad.assignment.providentlifesystem.collection.PolicyCollection;
import aooad.assignment.providentlifesystem.policy.Policy;
import aooad.assignment.providentlifesystem.policy.decorator.PolicyDecorator;
import aooad.assignment.providentlifesystem.policy.decorator.Rider;
import aooad.assignment.providentlifesystem.policy.decorator.rider.GenericRider;
import aooad.assignment.providentlifesystem.user.User;

public class Customer extends User {

    private static int last_id = 0;

    private PolicyCollection policyCollection = new PolicyCollection();

    public Customer(String name, String password) {
        super(name, last_id++, password);
    }

    public void viewPolicies() {
        String heading = "This are all your policies\n";
        Integer count = 0;

        for (int i = 0; i< policyCollection.size(); i++)
        {
            Policy policy = policyCollection.get(i);
            String outstanding = "";
            if (policy.getPremium().isOutstanding())
                outstanding = "Is Outstanding";
            else
                outstanding = "Is not Outstanding";


            System.out.println(String.format("%d. %s       %10s",i,policy.getPolicyDecorator().getName(),outstanding));

            //joe help me in this
            /*for (Rider rider: policy.getPolicyDecorator().getPolicies()
                 ) {
                System.out.println(policy.get);
            }
            */

        }





    }

}
