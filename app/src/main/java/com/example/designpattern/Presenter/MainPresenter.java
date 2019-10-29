package com.example.designpattern.Presenter;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.designpattern.Model.MainModel;
import com.example.designpattern.View.MainView;

//控制器，负责逻辑控制。
public class MainPresenter {
    private MainView mainView;
    private MainModel mainModel;

    public MainPresenter(MainView mainView, MainModel mainModel) {
        this.mainView = mainView;
        this.mainModel = mainModel;
    }

    public void onCreate() {
        Log.d("P", "noCreate: ");
        mainView.setContentView();
    }

    public void onloginclick(String account, String pass, String mail) {
        Log.d("P", "onloginclick: ");
//        mainModel.checkaccount(account, pass,mail);
        mainView.toastmsg(mainModel.checksuccessAccount());
//        mainModel.isVaildEmailFormat(mail);
        //mainView.clearEdittext();

    }

    public void inputListiner(EditText editTextUsername, EditText editTextPassword, EditText editTextMail, Button buttonlogin) {
//        mainView.setbuttonEnabled(mainModel.inputListiner(editTextUsername, editTextPassword, editTextMail, buttonlogin));
        mainView.setbuttonEnabled(mainModel.inputListiner2(editTextUsername, editTextPassword, editTextMail, buttonlogin));
    }

}
