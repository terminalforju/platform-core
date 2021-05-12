package com.project.model.user.pojo;

import java.io.Serializable;
import java.util.List;

public class Users implements Serializable {
    private List<UserTab> userTabs;

    public List<UserTab> getUserTabs() {
        return userTabs;
    }

    public void setUserTabs(List<UserTab> userTabs) {
        this.userTabs = userTabs;
    }
}
