package aooad.assignment.providentlifesystem.system;

import aooad.assignment.providentlifesystem.policy.Policy;

public class EmailFacade {

    public static void send(Policy policy) {
        System.out.println("[Email] Sending Policy");
        System.out.println(policy.toString());
    }
}
