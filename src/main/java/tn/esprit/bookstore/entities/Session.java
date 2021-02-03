package tn.esprit.bookstore.entities;

public class Session {
    private static Session instance;
    private String userName;

    private Session(String userName) {
        this.userName = userName;

    }

    public static Session getInstance() {
        return instance;
    }

    public static Session getInstance(String userName) {
        if (instance == null) {
            instance = new Session(userName);
        }
        return instance;
    }

    public String getUserName() {
        return userName;
    }

    //    public Set<String> getPrivileges() {
//        return privileges;
//    }
    public void cleanUserSession() {
        userName = "";// or null

    }

    @Override
    public String toString() {
        return "UserSession{"
                + "userName='" + userName + '\''
                + '}';
    }
}
