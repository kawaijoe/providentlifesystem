package aooad.assignment.providentlifesystem.system;

public class CreditCardFacade {

    public static void makePayment(double amount, String creditCardNumber) {
        // Some low level complex implementation
        if(checkValidCreditCard(creditCardNumber)) {
            System.out.print("[CreditCard] Payment by Credit Card(" + creditCardNumber + ") of S$" + amount +
                    " have been made!");
        }

    }

    public static void retrievePayment(double amount, String creditCardNumber) {
        // Some low level complex implementation
        if(checkValidCreditCard(creditCardNumber)) {
            System.out.print("[CreditCard] Retrieved payment by Credit Card(" + creditCardNumber + ") of S$" + amount +
                    " have been made!");
        }
    }

    private static boolean checkValidCreditCard(String creditCardNumber) {
        boolean valid = creditCardNumber.matches("[0-9]+") && creditCardNumber.length() == 16;
        if(!valid)
            System.out.println("[CreditCard][ERROR] Invalid credit card! A credit card needs to be a 16 digit number.");
        return valid;
    }

}
