package com.ps.comunio.comuniops;

/**
 * Created by Rener on 14/11/2015.
 */
public class Usuarios_DB {
    String username;
    String pass;
    public Usuarios_DB(String username,String pass) {
        this.username = username;
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
