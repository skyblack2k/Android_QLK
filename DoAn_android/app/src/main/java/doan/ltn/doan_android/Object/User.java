package doan.ltn.doan_android.Object;

import android.databinding.Bindable;

public class User {
    String UserName;
    String Password;

    public User(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
