package esercitazione5.loginServer;

public class User {
    private String name;
    private String password ;

    public User(String name, String password) {
        if(name == null || password == null || name.isEmpty() || password.isEmpty())
            throw new IllegalArgumentException("Utente non valido");
        this.name = name;
        this.password = password;
    }

    public String getName() { return name; }

    String getPassword() { return password; }

    public void setName(String name) {
        this.name = name;
    }
}
