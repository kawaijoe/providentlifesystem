package aooad.assignment.providentlifesystem.system;

public class PrinterFacade {
    private static PrinterFacade ourInstance = new PrinterFacade();

    public static PrinterFacade getInstance() {
        return ourInstance;
    }

    private PrinterFacade() { }
}
