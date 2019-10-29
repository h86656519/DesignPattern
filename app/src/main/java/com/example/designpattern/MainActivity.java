package com.example.designpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.designpattern.Model.MainModel;
import com.example.designpattern.Presenter.MainPresenter;
import com.example.designpattern.View.MainView;


//视图，负责界面的展示。
//implements 透過 interface MainView 讓 MainPresenter 來控制view = 將原本在MainActivity 控制邏輯切給 MainPresenter 來做
public class MainActivity extends AppCompatActivity implements MainView {
    private MainPresenter mainPresenter;
    private EditText editaccount, editpass;
    boolean result = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPresenter = new MainPresenter(this, new MainModel());
        mainPresenter.onCreate();

        getlonginViewByid().setEnabled(result); //初始button
        getemailViewByid().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = getemailViewByid().getText().toString().trim();
                getlonginViewByid().setEnabled(!input.isEmpty());
                Log.i("V", "onTextChanged input : " + input);
                Log.i("V", "onTextChanged result : " + result);
                Log.i("V", "onTextChanged s.toString() : " + s.toString());
                mainPresenter.isEmpty(s.toString());
                getlonginViewByid().setEnabled(result);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    @Override
    public void clearEdittext() {
        Log.d("V", "clearEdittext: ");
        getaccountViewById().setText("");
        getpassViewByid().setText("");
        getemailViewByid().setText("");
    }

    @Override
    public void toastmsg(String checksuccessaccountmsg) {
        Log.d("V", "toastmsg : " + checksuccessaccountmsg);
        Toast.makeText(this, checksuccessaccountmsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setbuttonEnabled(boolean result) {
       // mainPresenter.inputListiner(getaccountViewById(), getpassViewByid(), getemailViewByid(), getlonginViewByid());
//        getaccountViewById().addTextChangedListener(inputListiner(getaccountViewById()));
//        getpassViewByid().addTextChangedListener(inputListiner(getpassViewByid()));
//        getemailViewByid().addTextChangedListener(inputListiner(getemailViewByid()));

        Log.i("V", "setbuttonEnabled result : " + result);
        this.result = result;
    }

    public void btn_login(View view) {
        mainPresenter.onloginclick(getaccountViewById().getText().toString(), getpassViewByid().getText().toString(), getemailViewByid().getText().toString());
    }

    private EditText getaccountViewById() {
        return findViewById(R.id.editText);
    }

    private EditText getpassViewByid() {
        return findViewById(R.id.editText2);
    }

    private EditText getemailViewByid() {
        return findViewById(R.id.editText3);
    }

    private Button getlonginViewByid() {
        return findViewById(R.id.btn_login);
    }

    public TextWatcher inputListiner(final EditText editText) {
        TextWatcher loginTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = editText.getText().toString().trim();
                getlonginViewByid().setEnabled(!input.isEmpty());

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
        return loginTextWatcher;
    }
}
