package aooad.assignment.providentlifesystem.system;

import aooad.assignment.providentlifesystem.policy.Policy;

public class EmailFacade {

    public static void send(Policy policy) {
        System.out.println("[Email] Retrieving Customer Information");
        System.out.println("[Email] Email Generated");
        System.out.println("[Email] Sent!");
        System.out.println(policy.toString());
    }

}
