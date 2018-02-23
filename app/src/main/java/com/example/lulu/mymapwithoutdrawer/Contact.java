package com.example.lulu.mymapwithoutdrawer;

/**
 * Created by lulu on 17/02/2018.
 */

public class Contact {

    int id;
    String name, email, address, password;

    //setters
    public void setName(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setPassword(String password){
        this.password= password;
    }

    //getters

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getAddress(){
        return this.address;
    }
    public String getPassword(){
        return this.password;
    }

}
