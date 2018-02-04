package aooad.assignment.providentlifesystem.user.agent;

import aooad.assignment.providentlifesystem.collection.PolicyCollection;
import aooad.assignment.providentlifesystem.policy.Policy;
import aooad.assignment.providentlifesystem.policy.decorator.BasePolicy;
import aooad.assignment.providentlifesystem.policy.decorator.rider.GenericRider;
import aooad.assignment.providentlifesystem.system.EmailFacade;
import aooad.assignment.providentlifesystem.system.PrinterFacade;
import aooad.assignment.providentlifesystem.user.ConsoleHelper;
import aooad.assignment.providentlifesystem.user.Customer;
import aooad.assignment.providentlifesystem.user.User;
import aooad.assignment.providentlifesystem.user.agent.salarystrategy.SalaryStrategy;

import java.io.Console;
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
                    viewPolicies();
                    break;
            }
        }
    }

    private void viewPolicies() {
        ConsoleHelper.displayList("Policies", ConsoleHelper.viewPoliciesBuilder(policyCollection));
        int option = ConsoleHelper.question("Select an option",
                List.of("Generate Payment Due Alert",
                        "Edit Policy"));
        switch(option) {
            case 1:
                generateOverdueAlert();
                break;
            case 2:
                editPolicy();
                break;
        }
    }

    private void editPolicy() {
        int option = -1;

        while(option != 0) {
            option = ConsoleHelper.question("Choose an option",
                    List.of("Add Rider",
                            "Pay Premium by Cheque"));

            switch(option) {
                case 1:
                    addRider();
                    break;
                case 2:
                    payPremiumByCheque();
                    break;
            }
        }
    }

    private void addRider() {
        int option = ConsoleHelper.question("View Policies (Enter Policy ID to Add Rider)",
                ConsoleHelper.viewPoliciesBuilder(policyCollection));
        Policy policy = policyCollection.get(option - 1);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Rider Name: ");
        String name = scanner.nextLine();

        double price;
        while(true) {
            System.out.print("Enter Price: ");
            try {
                price = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Please enter a number.");
            }
        }

        double payout;
        while(true) {
            System.out.print("Enter Payout: ");
            try {
                payout = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Please enter a number.");
            }
        }

        policy.addRider(new GenericRider(name, price, payout));
    }

    private void payPremiumByCheque() {
        int option = ConsoleHelper.question("View Policies (Enter PolicyID to pay for premium)",
                ConsoleHelper.viewPoliciesBuilder(policyCollection));
        Policy policy = policyCollection.get(option - 1);
        policy.getPremium().chequePayment();
    }

    private void generateOverdueAlert() {
        List<Policy> policyList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        for(int i = 0; i < policyCollection.size(); i++) {
            Policy policy = policyCollection.get(i);
            if(policy.getPremium().isOutstanding()) {
                policyList.add(policy);
                stringList.add(policy.toString());
            }
        }

        Policy policy = policyList.get(ConsoleHelper.question("Select a Policy to Generate Alert", stringList) - 1);

        int option = ConsoleHelper.question("How would you like to send your alert?",
                List.of("Send Email",
                        "Print Letter"));

        switch(option) {
            case 1:
                EmailFacade.send(policy);
                break;
            case 2:
                PrinterFacade.print(policy);
                break;
        }
    }

    public void overdueAlert() {
        ConsoleHelper.printSegment("Overdue Alert");
        List<String> outstandingList = new ArrayList<>();
        for(int i = 0; i < policyCollection.size(); i++) {
            Policy policy = policyCollection.get(i);
            if(policy.getPremium().isOutstanding()) {
                outstandingList.add(policy.toString());
            }
        }

        if(outstandingList.size() == 0) System.out.println("Great News! No policies are overdue.");
        else ConsoleHelper.displayList("Outstanding Policies", outstandingList);
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
        List<String> list = new ArrayList<>();

        for(int i = 0; i < agentMap.size(); i++) {
            list.add(agentMap.get(i).getName());
        }

        int option = ConsoleHelper.question("Select Agent", list);
        if(option != 0) return option - 1;
        return -1;
    }

}
