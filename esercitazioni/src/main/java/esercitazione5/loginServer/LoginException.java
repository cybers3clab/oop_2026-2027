package esercitazione5.loginServer;

public class LoginException extends RuntimeException {
    private User problemUser;

    public LoginException (String message , User problemUser ) {
        super(message + "\n\tName: " + problemUser.getName() + ", password: " + problemUser.getPassword());
        this.problemUser = problemUser;
    }
}
