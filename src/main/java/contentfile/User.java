package contentfile;

public class User {
    private String userName;
    private int passwordHash;
    private boolean isMember;
    private Boolean logIn = null;
    private boolean premiumUser;

    public User(String name, String password) {
        this.userName = name;
        this.passwordHash = password;
    }

    void upgradeForPremium() {
        premiumUser = true;
    }

    void setLogIn(boolean value) {
        if (logIn = null){
            logIn = true;
        }
        logIn = value;
    }

    public boolean isPremium() {
        return premiumUser;
    }

    public boolean getLogIn() {
        return logIn;
    }

    public String getUserName() {
        return userName;
    }

    public boolean checkPassword(String password) {
        return getPasswordHash(password) == this.passwordHash;
    }

    private int getPasswordHash(String password) {
        return (this.userName + password).hashCode();
    }
}

