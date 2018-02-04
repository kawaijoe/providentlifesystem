package aooad.assignment.providentlifesystem.user.administrator;

import aooad.assignment.providentlifesystem.user.User;

public class Administrator extends User {

    private static int last_id = 0;

    public Administrator(String name, String password) {
        super(name, last_id++, password);
    }
}
