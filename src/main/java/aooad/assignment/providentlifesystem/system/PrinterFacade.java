package aooad.assignment.providentlifesystem.system;

import aooad.assignment.providentlifesystem.policy.Policy;

public class PrinterFacade {

    public static void print(Policy policy) {
        System.out.println("[Printer] Retrieving Customer Information");
        System.out.println("[Printer] Letter Generated");
        System.out.println("[Printer] Printing Letter");
        System.out.println(policy.toString());
    }
}
