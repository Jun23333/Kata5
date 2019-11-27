package model;

public class Mail {
    String mail;
    
    public Mail(String mail) {
        this.mail = mail;
    }

    public String getDomain() {
        return this.mail;
    }

    public static boolean isMail(String line) {
        return line.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
    }
}