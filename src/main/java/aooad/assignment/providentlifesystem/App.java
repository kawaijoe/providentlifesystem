package aooad.assignment.providentlifesystem;

import aooad.assignment.providentlifesystem.collection.PolicyCollection;
import aooad.assignment.providentlifesystem.collection.PolicyIterator;
import aooad.assignment.providentlifesystem.policy.Policy;
import aooad.assignment.providentlifesystem.policy.decorator.BasePolicy;
import aooad.assignment.providentlifesystem.policy.premium.PremiumType;
import aooad.assignment.providentlifesystem.policy.state.Terminated;
import aooad.assignment.providentlifesystem.user.User;
import aooad.assignment.providentlifesystem.user.agent.Agent;

import java.util.ArrayList;
import java.util.List;

public class App {

    static List<User> userList = new ArrayList<>();

    static String abc = "====================\n" +
            "   Menu\n";

    public static void main(String[] args) {
        //userList.add(new Agent());
        System.out.println(abc);

        PolicyCollection policyCollection = new PolicyCollection();
        policyCollection.add(new Policy(PremiumType.MONTHLY, "", new BasePolicy("policy", 50, 5000)));
        policyCollection.getPolicyList().get(0).setState(new Terminated(policyCollection.getPolicyList().get(0)));
        //policyCollection.add(new Policy(PremiumType.MONTHLY, "", new BasePolicy("policy", 50, 5000)));

        PolicyIterator policyIterator = policyCollection.getActiveIterator();

        while(policyIterator.hasNext()) {
            System.out.println(policyIterator.next().getState().getClass());
        }
    }
}
