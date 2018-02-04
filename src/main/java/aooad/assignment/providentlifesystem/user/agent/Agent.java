package aooad.assignment.providentlifesystem.user.agent;

import aooad.assignment.providentlifesystem.collection.PolicyCollection;
import aooad.assignment.providentlifesystem.policy.Policy;
import aooad.assignment.providentlifesystem.policy.decorator.BasePolicy;
import aooad.assignment.providentlifesystem.system.EmailFacade;
import aooad.assignment.providentlifesystem.system.PrinterFacade;
import aooad.assignment.providentlifesystem.user.ConsoleHelper;
import aooad.assignment.providentlifesystem.user.Customer;
import aooad.assignment.providentlifesystem.user.User;
import aooad.assignment.providentlifesystem.user.agent.salarystrategy.SalaryStrategy;

import java.util.*;

public class Agent extends User {

    private static int last_id = 0;
    public static Map<Integer, Agent> agentMap = new HashMap<>();

    private SalaryStrategy salaryStrategy;
    public PolicyCollection policyCollection = new PolicyCollection();

    public Agent(String name, SalaryStrategy salaryStrategy) {
        super(name, last_id++);
        this.salaryStrategy = salaryStrategy;
    }

    public static void register(Agent agent) {
        agentMap.put(agent.getId(), agent);
        System.out.println("Registering Agent " + agent.getName() + "...");
    }

    public void cancelByAgent() { }

    public double calculatePay() {
        return salaryStrategy.getSalary();
    }

    public SalaryStrategy getSalaryStrategy() {
        return salaryStrategy;
    }

    public void setSalaryStrategy(SalaryStrategy salaryStrategy) {
        this.salaryStrategy = salaryStrategy;
    }

    public void menu() {
        int option = -1;

        while(option != 0) {
            ConsoleHelper.printSegment("Agent Menu");
            option = ConsoleHelper.question("Options",
                    List.of("Create a New Insurance Policy",
                            "View Policies"));

            switch(option) {
                case 1:
                    createInsurancePolicy();
                    break;
                case 2:
                    break;
            }
        }
    }

    public void overdueAlert() {
        ConsoleHelper.printSegment("Overdue Alert");
        List<Policy> outstandingList = new ArrayList<>();
        for(int i = 0; i < policyCollection.size(); i++) {
            Policy policy = policyCollection.get(i);
            if(policy.getPremium().isOutstanding()) {
                outstandingList.add(policy);
            }
        }

        for(int i = 0; i < outstandingList.size(); i++) {
            int option = -1;
            while(option != 0) {
                option = ConsoleHelper.question("How would you like to send your alert? (Exit will skip the policy)",
                        List.of("Send Email",
                                "Print Letter"));

                switch(option) {
                    case 1:
                        EmailFacade.send(outstandingList.get(i));
                        break;
                    case 2:
                        PrinterFacade.print(outstandingList.get(i));
                        break;
                }
            }
        }

        if(outstandingList.size() == 0) System.out.println("Great News! No policies are overdue.");
    }

    private void createInsurancePolicy() {
        System.out.println("Create a New Insurance Policy");
        int index = Customer.selectCustomer();
        if(index == -1) return;

        String name = "";

        int option = ConsoleHelper.question("Type of Insurance",
                List.of("Medical Insurance",
                        "Car Insurance",
                        "Travel Insurance"));

        switch(option) {
            case 1:
                Policy policy = new Policy(new BasePolicy(name + " Medical Insurance", 50, 5050),
                        "Some terms and conditions", 365);
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.YEAR, 10);
                policy.setMaturityDate(calendar);
                addPolicy(Customer.customerMap.get(index), policy);
                break;
            case 2:
                addPolicy(Customer.customerMap.get(index), new Policy(new BasePolicy(name + " Car Insurance",
                        50, 5050),"Some terms and conditions", 365));
                break;
            case 3:
                addPolicy(Customer.customerMap.get(index), new Policy(new BasePolicy(name + " Travel Insurance",
                        50, 5050),"Some terms and conditions"));
                break;
        }
    }

    private void addPolicy(Customer customer, Policy policy) {
        customer.policyCollection.add(policy);
        policyCollection.add(policy);
    }

    public static int selectAgent() {
        int option = -1;
        List<String> list = new ArrayList<>();

        for(int i = 0; i < agentMap.size(); i++) {
            list.add(agentMap.get(i).getName());
        }

        option = ConsoleHelper.question("Select Agent", list);
        if(option != 0) return option - 1;
        return -1;
    }

}
