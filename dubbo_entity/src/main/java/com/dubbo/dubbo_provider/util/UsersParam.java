package com.dubbo.dubbo_provider.util;

public class UsersParam extends PageUtil {
    private String name;
    private Integer telephone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }
}
