package com.exampleWeb.demoArtifact;

public class UserPW {

    private String username;
    private String password;
    private int age;


    public UserPW(String name, String password, int age){
        this.username = name;
        this.password = password;
        this.age = age;
    }

    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public int getAge(){return age;}

//    public String UserNA(){
//        return '(' + getUsername() + ", " + getAge() + ')';
//    }


    public void setUsername(String name){this.username = name;}
    public void setPassword(String password){this.password = password;}
    public void setAge(int age){this.age = age;}

}
