package com.ssm.pojo;

import java.io.Serializable;

public class Boss implements Serializable {
private int boss_id;
private String boss_name;
private String boss_password;

    public int getBoss_id() {
        return boss_id;
    }

    public void setBoss_id(int boss_id) {
        this.boss_id = boss_id;
    }

    public String getBoss_name() {
        return boss_name;
    }

    public void setBoss_name(String boss_name) {
        this.boss_name = boss_name;
    }

    public String getBoss_password() {
        return boss_password;
    }

    public void setBoss_password(String boss_password) {
        this.boss_password = boss_password;
    }
}
