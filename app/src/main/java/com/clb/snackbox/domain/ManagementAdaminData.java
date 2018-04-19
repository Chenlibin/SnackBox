package com.clb.snackbox.domain;

import java.io.Serializable;

public class ManagementAdaminData implements Serializable {

    private String adminName;
    private String adminPhone;

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

}
