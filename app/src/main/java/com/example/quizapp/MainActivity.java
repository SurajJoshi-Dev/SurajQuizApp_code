package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, View.OnClickListener {
ImageView backbtn;
TextInputEditText dob,firstName,LastName,email,phoneno,username,password,cpassword;
Button singnup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
     //   getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initization();
    }

    private void initization() {
        backbtn=findViewById(R.id.Back_btn);
backbtn.setOnClickListener(this);

        dob=findViewById(R.id.DOB_edt);
        dob.setOnClickListener(this);

        singnup=findViewById(R.id.Sign_Btn);
        singnup.setOnClickListener(this);

        firstName=findViewById(R.id.FirstName_edt);
        LastName=findViewById(R.id.LastName_edt);
        phoneno=findViewById(R.id.PhoneNumber_edt);
        username=findViewById(R.id.UserName_txt);
        password=findViewById(R.id.Password_tdt);
        cpassword=findViewById(R.id.ConfirmPassword_tdt);
        email=findViewById(R.id.Email_txt);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.DOB_edt:
               showDatePickupDialog();

               break;

           case R.id.Sign_Btn:


               if (!firstName.getText().toString().matches("[a-z,A-Z]*")){
                   firstName.setError("Enter Only character");
                   Toast.makeText(this, "First", Toast.LENGTH_LONG).show();

               }
               else  if (!LastName.getText().toString().matches("[a-z,A-Z]*")){
                   LastName.setError("Enter Only character");
                   Toast.makeText(this, "last", Toast.LENGTH_LONG).show();

               }
               else if (email.getText().length()==0){
                   email.setError("Fill Email Address");
                   Toast.makeText(this, "email", Toast.LENGTH_LONG).show();

               }
               else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
                   email.setError("Enter valid Email");
                   Toast.makeText(this, "emailpattern", Toast.LENGTH_LONG).show();
               }
               else if (username.length()==0){
                   username.setError("Fill Username");
                   Toast.makeText(this, "username", Toast.LENGTH_LONG).show();
               }
               else if(phoneno.getText().length()<10){
                   phoneno.setError("Enter Only 10 Digit Mobile Number");
                   Toast.makeText(this, "phone", Toast.LENGTH_LONG).show();
               }
               else if (password.getText().length()<6){
                   password.setError("Please Enter Password minimum in 6 Char");
                   Toast.makeText(this, "password", Toast.LENGTH_LONG).show();

           }
               else if (!cpassword.getText().toString().equals(password.getText().toString())){
                   cpassword.setError("Both Password are not matched");
                   Toast.makeText(this, "confirm p", Toast.LENGTH_LONG).show();
               }
           //    else if(!phoneno.getText().toString().matches("(6|7)?[6-9]{9}")){
             //      phoneno.setError("Enter valid phone number");
               //}

               else {

                   Intent intent=new Intent(MainActivity.this,Login.class);
                   startActivity(intent);
                   Toast.makeText(this, "Register Succesfully", Toast.LENGTH_LONG).show();

               }
//               finish();
               break;
           case R.id.Back_btn:
            //   Intent intent=new Intent(MainActivity.this,Login.class);
              // startActivity(intent);
               Toast.makeText(this, "First Register", Toast.LENGTH_SHORT).show();
               break;

       }
    }

    private void showDatePickupDialog() {
        DatePickerDialog datePickerDialog=new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
      datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
      String day=  +dayOfMonth + "/" +month  + "/" +year;
      dob.setText(day);
    }
}