package aooad.assignment.providentlifesystem.user;

import aooad.assignment.providentlifesystem.collection.PolicyCollection;
import aooad.assignment.providentlifesystem.policy.Policy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleHelper {

    public static void displayList(String title, List<String> items) {
        int count = 0;
        System.out.println(title);
        for(String item : items) {
            System.out.println(++count + ". " + items);
        }
    }

    public static List<String> viewPoliciesBuilder(PolicyCollection policyCollection) {
        List<String> options = new ArrayList<>();

        for(int i = 0; i < policyCollection.size(); i++) {
            Policy policy = policyCollection.get(i);
            String text = (policy.getPremium().isOutstanding() ? "<Outstanding> " : "") +
                    policy.toString();

            options.add(text);
        }

        return options;
    }

    public static int question(String question, List<String> options) {
        System.out.println("\n" + question + ": ");
        return getAnswer(options);
    }

    private static int getAnswer(List<String> options) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        for(String option : options) {
            System.out.println(++count + ". " + option);
        }
        System.out.println("0. Exit");

        while(true) {
            System.out.print("Enter option: ");
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if(input > count || input < 0) {
                    System.out.println("[ERROR] Invalid option");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Please enter a number.");
            }
        }
    }

    public static void printSegment(String text) {
        System.out.println("\n========== " + text + " ==========");
    }

}
