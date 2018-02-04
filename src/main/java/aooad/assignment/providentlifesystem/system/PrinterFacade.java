package aooad.assignment.providentlifesystem.system;

import aooad.assignment.providentlifesystem.policy.Policy;

public class PrinterFacade {

    public static void print(Policy policy) {
        System.out.println("[Printer] Printing Policy");
        System.out.println(policy.toString());
    }
}
