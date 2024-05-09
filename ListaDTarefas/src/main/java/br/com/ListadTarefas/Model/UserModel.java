package br.com.ListadTarefas.Model;

public class UserModel {
    private String id;
    private String userName;
    private String userEmail;
    private String userPass;

    public UserModel(String id, String userName,String userEmail, String userPass) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserModel(String userPass, String userEmail) {
        this.userPass = userPass;
        this.userEmail = userEmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
