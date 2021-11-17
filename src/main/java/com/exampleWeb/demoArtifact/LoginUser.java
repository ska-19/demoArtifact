package com.exampleWeb.demoArtifact;

public class LoginUser {
    private String username;
    private String newPassword;
    private String repeatPassword;


    public LoginUser(String name, String newPassword,String repeatPassword){
        this.username = name;
        this.newPassword = newPassword;
        this.repeatPassword = repeatPassword;
    }

    public String getUsername(){return username;}
    public String getNewPassword(){return newPassword;}
    public String getRepeatPassword(){return repeatPassword;}


//    public String UserNA(){
//        return '(' + getUsername() + ", " + getAge() + ')';
//    }


    public void setUsername(String name){this.username = name;}
    public void setNewPassword(String newPassword){this.newPassword = newPassword;}
    public void setRepeatPassword(String repeatPassword){this.repeatPassword = repeatPassword;}

}
