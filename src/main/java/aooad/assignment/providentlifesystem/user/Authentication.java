package aooad.assignment.providentlifesystem.user;

import aooad.assignment.providentlifesystem.user.administrator.Administrator;
import aooad.assignment.providentlifesystem.user.agent.Agent;
import aooad.assignment.providentlifesystem.user.customer.Customer;

public class Authentication {

    public static User user;

    public static boolean isAgent() {
        return user instanceof Agent;
    }

    public static boolean isAdministrator() {
        return user instanceof Administrator;
    }

    public static boolean isCustomer() {
        return user instanceof Customer;
    }

}
