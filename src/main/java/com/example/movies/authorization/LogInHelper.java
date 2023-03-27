package com.example.movies.authorization;

public class LogInHelper {


    private static LogInHelper instance = null;

    public static LogInHelper getInstance(){
        if(instance == null){
            instance = new LogInHelper();
        }
        return  instance;
    }
    private LogInHelper(){}
    private boolean admin = false;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
