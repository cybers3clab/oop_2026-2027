package esercitazione5.loginServer;
import esercitazione5.loginServer.attacker.Attack;

public class LoginServer {
    static void main() {
        Login login = new Login();
        User u1 = new User("u1", "p1");
        User u2 = new User("u2", "p2");
        User u3 = new User("u3", "p3");

        login.registerUser(u1);
        login.registerUser(u2);
        login.registerUser(u3);

        Attack attack = new Attack();
        attack.bypassLogin(login);
    }
}
