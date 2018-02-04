package aooad.assignment.providentlifesystem;

import aooad.assignment.providentlifesystem.user.ConsoleHelper;
import aooad.assignment.providentlifesystem.user.Customer;
import aooad.assignment.providentlifesystem.user.agent.Agent;
import aooad.assignment.providentlifesystem.user.agent.salarystrategy.DefaultSalaryStrategy;
import aooad.assignment.providentlifesystem.user.agent.salarystrategy.JuniorSalaryStrategy;
import aooad.assignment.providentlifesystem.user.agent.salarystrategy.SeniorSalaryStrategy;

import java.util.List;

public class App {

    public static void main(String[] args) {
        Agent.register(new Agent("DefaultAgent", new DefaultSalaryStrategy()));
        Agent.register(new Agent("SeniorAgent", new SeniorSalaryStrategy()));
        Agent.register(new Agent("JuniorAgent", new JuniorSalaryStrategy()));
        Customer.register(new Customer("Customer1", "Some Address1"));
        Customer.register(new Customer("Customer2", "Some Address2"));
        Customer.register(new Customer("Customer3", "Some Address3"));

        int option = -1;
        int login = -1;

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

}
