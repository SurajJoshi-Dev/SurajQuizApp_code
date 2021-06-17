package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity implements View.OnClickListener {
TextInputEditText username,password;
Button login;
ImageView BackButton;
TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
      //  getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initization();

    }

    private void initization() {
        login=findViewById(R.id.Login_Btn);
        login.setOnClickListener(this);

        register=findViewById(R.id.LoginReg_btn);
                register.setOnClickListener(this);

                BackButton=findViewById(R.id.BackButton_btn);
                BackButton.setOnClickListener(this);
username=findViewById(R.id.LoginUsername_btn);
password=findViewById(R.id.Loginpassword_btn);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Login_Btn:
                if (username.length() ==0) {
                    username.setError("Please Enter Username");

                }
                else if (password.length() < 6) {
                    password.setError("Please Enter Password minimum in 6 Char");
                }
                else {
                    Intent intent11=new Intent(Login.this,RecyclerMain.class);
                    startActivity(intent11);
                    Toast.makeText(this, "Login Succesfully", Toast.LENGTH_SHORT).show();
                }
                break;

           case R.id.BackButton_btn:
                Intent intent=new Intent(Login.this,MainActivity.class);
                startActivity(intent);
                break;

            case R.id.LoginReg_btn:
                Intent intent1=new Intent(Login.this,MainActivity.class);
                startActivity(intent1);
                break;
        }

    }}