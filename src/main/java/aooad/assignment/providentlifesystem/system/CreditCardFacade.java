package aooad.assignment.providentlifesystem.system;

public class CreditCardFacade {
    private static CreditCardFacade ourInstance = new CreditCardFacade();

    public static CreditCardFacade getInstance() {
        return ourInstance;
    }

    private CreditCardFacade() { }
}
