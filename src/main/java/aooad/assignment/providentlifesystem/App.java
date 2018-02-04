package aooad.assignment.providentlifesystem;

import aooad.assignment.providentlifesystem.collection.PolicyCollection;
import aooad.assignment.providentlifesystem.collection.PolicyIterator;
import aooad.assignment.providentlifesystem.policy.Policy;
import aooad.assignment.providentlifesystem.policy.decorator.PolicyDecorator;
import aooad.assignment.providentlifesystem.policy.state.Terminated;
import aooad.assignment.providentlifesystem.user.User;

import java.util.ArrayList;
import java.util.List;

public class App {

    static List<User> userList = new ArrayList<>();

    static String joestring = "====================\n" +
            "   Menu\n" ;

    static String yutingstring1 = "===========================================================================\n" +
            "                                                           AOOAD Assignment 2018\n" +
            "-------------------------------------------------------------Menu---------------------------------------------------------------\n" +
            "1. Login as Agent\n" +
            "2. Login as Customer\n" +
            "-----------------------------------------------------------------------------------------------------------------------------------\n" +
            "Enter your option :";


    public static void main(String[] args) {

        PolicyCollection policyCollection = new PolicyCollection();

        policyCollection.add(new Policy(new PolicyDecorator("a", 50, 500), "sd"));
        policyCollection.add(new Policy(new PolicyDecorator("b", 50, 500), "sd"));
        policyCollection.add(new Policy(new PolicyDecorator("c", 50, 500), "sd"));
        policyCollection.add(new Policy(new PolicyDecorator("d", 50, 500), "sd"));

        policyCollection.get(1).setState(Terminated.getInstance());
        policyCollection.get(2).setState(Terminated.getInstance());

        PolicyIterator policyIterator = policyCollection.getTerminatedIterator();

        while(policyIterator.hasNext()) {
            System.out.println(policyIterator.next().getState().getClass());
        }

        System.out.println(yutingstring1);


    }
}
