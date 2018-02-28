package com.ssm.pojo;

import java.io.Serializable;

public class Address implements Serializable {
    private int address_id;
    private int user_id;
    private String address_name;
    private String address_tel;
    private String address_add;
    private int address_state;
    private Users users;

    @Override
    public String toString() {
        return "Address{" + "address_id=" + address_id + ", user_id=" + user_id + ", address_name='" + address_name + '\'' + ", address_tel='" + address_tel + '\'' + ", address_add='" + address_add + '\'' + ", address_state=" + address_state + ", users=" + users + '}';
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAddress_name() {
        return address_name;
    }

    public void setAddress_name(String address_name) {
        this.address_name = address_name;
    }

    public String getAddress_tel() {
        return address_tel;
    }

    public void setAddress_tel(String address_tel) {
        this.address_tel = address_tel;
    }

    public String getAddress_add() {
        return address_add;
    }

    public void setAddress_add(String address_add) {
        this.address_add = address_add;
    }

    public int getAddress_state() {
        return address_state;
    }

    public void setAddress_state(int address_state) {
        this.address_state = address_state;
    }
}
