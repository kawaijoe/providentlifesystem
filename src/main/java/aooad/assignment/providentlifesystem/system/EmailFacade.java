package aooad.assignment.providentlifesystem.system;

public class EmailFacade {
    private static EmailFacade ourInstance = new EmailFacade();

    public static EmailFacade getInstance() {
        return ourInstance;
    }

    private EmailFacade() { }
}
