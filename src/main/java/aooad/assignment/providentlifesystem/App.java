package aooad.assignment.providentlifesystem;

import aooad.assignment.providentlifesystem.collection.PolicyCollection;
import aooad.assignment.providentlifesystem.collection.PolicyIterator;
import aooad.assignment.providentlifesystem.policy.Policy;
import aooad.assignment.providentlifesystem.policy.decorator.PolicyDecorator;
import aooad.assignment.providentlifesystem.policy.state.Terminated;
import aooad.assignment.providentlifesystem.user.Helper.InputHelper;
import aooad.assignment.providentlifesystem.user.Helper.OutputHelper;
import aooad.assignment.providentlifesystem.user.administrator.AdministratorController;
import aooad.assignment.providentlifesystem.user.agent.AgentController;
import aooad.assignment.providentlifesystem.user.customer.CustomerController;

import java.util.List;

public class App {

    static final AdministratorController ADMINISTRATOR_CONTROLLER = new AdministratorController();
    static final AgentController AGENT_CONTROLLER = new AgentController();
    static final CustomerController CUSTOMER_CONTROLLER = new CustomerController();

    static final String LOGIN_MENU = "========== Welcome to Provident Life System ==========\n" +
            "Login as:\n" +
            "1) Administrator\n" +
            "2) Agent\n" +
            "3) Customer\n\n" +
            "Enter your option: ";

    public static void main(String[] args) {
        /*

        int loginType = -1;

        while(loginType != 0) {
            OutputHelper.printSegment("Welcome to Provident Life System");
            loginType = InputHelper.question("Login as", List.of(
                    "Administrator",
                    "Agent",
                    "Customer"));

            switch(loginType) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    break;
            }
        }
        */



        PolicyCollection policyCollection = new PolicyCollection();

        policyCollection.add(new Policy(new PolicyDecorator("a", 50, 500), "sd"));
        policyCollection.add(new Policy(new PolicyDecorator("b", 50, 500), "sd"));
        policyCollection.add(new Policy(new PolicyDecorator("c", 50, 500), "sd"));
        policyCollection.add(new Policy(new PolicyDecorator("d", 50, 500), "sd"));

        policyCollection.get(1).setState(Terminated.getInstance());
        policyCollection.get(2).setState(Terminated.getInstance());

        System.out.println(Terminated.getInstance().getClass().getSimpleName());

        PolicyIterator policyIterator = policyCollection.getTerminatedIterator();

        while(policyIterator.hasNext()) {
            System.out.println(policyIterator.next().getState().getClass());
        }
    }

}
