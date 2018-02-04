package aooad.assignment.providentlifesystem;

import aooad.assignment.providentlifesystem.policy.Policy;
import aooad.assignment.providentlifesystem.policy.decorator.BasePolicy;
import aooad.assignment.providentlifesystem.policy.premium.Premium;
import aooad.assignment.providentlifesystem.user.ConsoleHelper;
import aooad.assignment.providentlifesystem.user.Customer;
import aooad.assignment.providentlifesystem.user.agent.Agent;
import aooad.assignment.providentlifesystem.user.agent.salarystrategy.DefaultSalaryStrategy;
import aooad.assignment.providentlifesystem.user.agent.salarystrategy.JuniorSalaryStrategy;
import aooad.assignment.providentlifesystem.user.agent.salarystrategy.SeniorSalaryStrategy;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.List;

public class App {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Agent.register(new Agent("DefaultAgent", new DefaultSalaryStrategy()));
        Agent.register(new Agent("SeniorAgent", new SeniorSalaryStrategy()));
        Agent.register(new Agent("JuniorAgent", new JuniorSalaryStrategy()));
        Customer.register(new Customer("Customer1", "Some Address1"));
        Customer.register(new Customer("Customer2", "Some Address2"));
        Customer.register(new Customer("Customer3", "Some Address3"));

        createOutstandingPolicy();

        int option = -1;
        int login;

        while(option != 0) {
            ConsoleHelper.printSegment("Welcome to Provident Life System");
            option = ConsoleHelper.question("Login as", List.of(
                    "Agent",
                    "Customer"));

            switch(option) {
                case 1:
                    login = Agent.selectAgent();
                    if(login != -1) {
                        Agent agent = Agent.agentMap.get(login);
                        agent.overdueAlert();
                        agent.menu();
                    }
                    break;
                case 2:
                    login = Customer.selectCustomer();
                    if(login != -1) {
                        Customer customer = Customer.customerMap.get(login);
                        customer.menu();
                    }
                    break;
            }
        }

    }

    // Create Outstanding Policy using Java's Reflection API
    private static void createOutstandingPolicy() throws NoSuchFieldException, IllegalAccessException {
        Policy policy = new Policy(new BasePolicy("Test Insurance", 50, 5050),
                "Some terms and conditions", 0);
        Customer.customerMap.get(0).policyCollection.add(policy);
        Agent.agentMap.get(0).policyCollection.add(policy);

        Premium premium = Customer.customerMap.get(0).policyCollection.get(0).getPremium();
        Field f1 = premium.getClass().getDeclaredField("lastPaid");
        f1.setAccessible(true);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        f1.set(premium, calendar);
    }

}
