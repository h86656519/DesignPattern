package com.example.designpattern.Model;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

//负责数据的加载和存储
public class MainModel {
    private String msg;
    //1. account contains "@"
    //2. password number and char
    // no network
    // account or pass is empty => button invalid
    // 甚麼時候 button 可以按?

    public void checkaccount(String account, String pass, String email) {
        Log.d("M", "checkaccount: ");
//        if (account.equals("andy")) {
//            msg = "success";
//        } else {
//            msg = "fail";
//        }

//        if (!isVaildEmailFormat(email)){
//            msg = "mail 格式有錯";
//        }
        Log.i("M", "checkaccount: " + account + "pass : " + pass);
        if (account.length() == 0 | pass.length() == 0) {
            msg = "帳密不為空喔";
        }

        Log.i("M", "validatePhonePass : " + validatePhonePass(pass));
        if (validatePhonePass(pass)) {
            msg = "密碼要為字母和數字的組合喔~";
        }

    }

    public String checksuccessAccount() {
        Log.d("M", "checksuccessAccount: ");
        return msg;
    }

    public boolean isVaildEmailFormat(String input) {
        if (input == null)
            return false;
        return android.util.Patterns.EMAIL_ADDRESS.matcher(input).matches();
    }

    //密码验证的正则表达式 (6-16位字母和数字组合)
    public static boolean validatePhonePass(String pass) {
        String passRegex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
        return !pass.matches(passRegex);
    }

    public TextWatcher inputListiner(final EditText editTextUsername, final EditText editTextPassword,
                                     final EditText editTextMail, final Button buttonlogin) {
        TextWatcher loginTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String usernameInput = editTextUsername.getText().toString().trim();
                String passwordInput = editTextPassword.getText().toString().trim();
                String mailInut = editTextMail.getText().toString().trim();
                Log.i("onTextChanged", "onTextChanged: " + (!usernameInput.isEmpty() && !passwordInput.isEmpty() && !mailInut.isEmpty()));
                buttonlogin.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty() && !mailInut.isEmpty());

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
        return loginTextWatcher;
    }

    public Boolean inputListiner2(final EditText editTextUsername, final EditText editTextPassword,
                                  final EditText editTextMail, final Button buttonlogin) {
        final Boolean result = false;
        TextWatcher loginTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String usernameInput = editTextUsername.getText().toString().trim();
                String passwordInput = editTextPassword.getText().toString().trim();
                String mailInut = editTextMail.getText().toString().trim();
                Log.i("onTextChanged", "onTextChanged: " + (!usernameInput.isEmpty() && !passwordInput.isEmpty() && !mailInut.isEmpty()));
                buttonlogin.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty() && !mailInut.isEmpty());

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
        return result;
    }

    public boolean isEmpty(String s){
        if (s.length() > 0){
            return true;
        }else {
            return false;
        }

    }
}
