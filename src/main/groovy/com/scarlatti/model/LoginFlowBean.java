package com.scarlatti.model;

import java.io.Serializable;

/**
 * ~     _____                                    __
 * ~    (, /  |  /)                /)         (__/  )      /)        ,
 * ~      /---| // _ _  _  _ __  _(/ __ ___     / _ _  __ // _ _/_/_
 * ~   ) /    |(/_(//_)/_)(_(/ ((_(_/ ((_)   ) / (_(_(/ ((/_(_((_(__(_
 * ~  (_/                                   (_/
 * ~  Friday, 11/17/2017
 */

/**
 * This class must be serializable because Spring web flow
 * apparently stores the object at some point, perhaps mid-flow
 * as a serialized Java object.
 */
public class LoginFlowBean implements Serializable {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "LoginFlowBean [userName=" + userName + ", password=" + password + "]";
        }
}
