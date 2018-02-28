package com.ssm.pojo;

import java.io.Serializable;

public class Kinds implements Serializable {
    private int kind_id;
    private String kind_max;
    private String kind_min;
    private String max_photo;
    private String min_photo;

    public String getMax_photo() {
        return max_photo;
    }

    public void setMax_photo(String max_photo) {
        this.max_photo = max_photo;
    }

    public String getMin_photo() {
        return min_photo;
    }

    public void setMin_photo(String min_photo) {
        this.min_photo = min_photo;
    }

    @Override
    public String toString() {
        return "Kinds{" + "kind_id=" + kind_id + ", kind_max='" + kind_max + '\'' + ", kind_min='" + kind_min + '\'' + ", max_photo='" + max_photo + '\'' + ", min_photo='" + min_photo + '\'' + '}';
    }

    public int getKind_id() {
        return kind_id;
    }

    public void setKind_id(int kind_id) {
        this.kind_id = kind_id;
    }

    public String getKind_max() {
        return kind_max;
    }

    public void setKind_max(String kind_max) {
        this.kind_max = kind_max;
    }

    public String getKind_min() {
        return kind_min;
    }

    public void setKind_min(String kind_min) {
        this.kind_min = kind_min;
    }
}
