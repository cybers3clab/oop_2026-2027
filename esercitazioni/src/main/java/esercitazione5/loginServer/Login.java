package esercitazione5.loginServer;

import java.util.LinkedList;
import java.util.List;

public class Login {
    private final List<User> users = new LinkedList<>();

    public void registerUser(User u) {
        if(!users.contains(u))
            users.add(u);
    }

    public boolean login(User u) throws LoginException {
        if (u == null) return false;
        User current = null;
        try {
            for(User registered : users) {
                boolean nameEqual = registered.getName().equals(u.getName());
                current = registered; // PROBLEMA <-- current viene assegnato PRIMA di ogni possibile crash
                if (nameEqual) {
                    if (registered.getPassword().equals(u.getPassword()))
                        return true;
                    throw new LoginException("Invalid password for user", u);
                }
            }
            return false;
        }
        catch(Exception e) {
            throw new LoginException("Invalid user", current);
        }
    }
}