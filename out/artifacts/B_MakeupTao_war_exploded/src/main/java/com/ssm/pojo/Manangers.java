package com.ssm.pojo;

import java.io.Serializable;

public class Manangers implements Serializable {
    private int mananger_id;
    private String mananger_name;
    private String mananger_password;

    @Override
    public String toString() {
        return "Manangers{" + "mananger_id=" + mananger_id + ", mananger_name='" + mananger_name + '\'' + ", mananger_password='" + mananger_password + '\'' + '}';
    }

    public int getMananger_id() {
        return mananger_id;
    }

    public void setMananger_id(int mananger_id) {
        this.mananger_id = mananger_id;
    }

    public String getMananger_name() {
        return mananger_name;
    }

    public void setMananger_name(String mananger_name) {
        this.mananger_name = mananger_name;
    }

    public String getMananger_password() {
        return mananger_password;
    }

    public void setMananger_password(String mananger_password) {
        this.mananger_password = mananger_password;
    }
}
