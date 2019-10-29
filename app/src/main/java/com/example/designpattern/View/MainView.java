package com.example.designpattern.View;

import android.text.TextWatcher;

public interface MainView {
    void clearEdittext();

    void toastmsg(String checksuccessaccountmsg);

    void setContentView();

//    void setbuttonEnabled(TextWatcher loginTextWatcher);

    void setbuttonEnabled(boolean result);
}
