package com.example.pc.chatapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText login_login, password_login;
    private TextView create_account , forgot_password;
    private String username, password;
    Button log_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_login = (EditText) findViewById(R.id.user_login);
        password_login = (EditText) findViewById(R.id.pass_login);
        log_button = (Button) findViewById(R.id.login_button);
        create_account = (TextView) findViewById(R.id.create_account_login) ;
        forgot_password = (TextView) findViewById(R.id.forgot_password_login) ;


        log_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAllowed();//call when the button is clicked to validate the input
            }
        });
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override//This will redirect into LoginActivity's page
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override//This will redirect into LoginActivity's page
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        loginAllowed();
    }

    public void loginAllowed(){
        initialize();
        if(!validate()){
            Toast.makeText(this, "Log-in has Failed! Try again.", Toast.LENGTH_LONG).show();
        }
    }
    public void initialize(){
        username = login_login.getText().toString().trim();
        password = password_login.getText().toString().trim();
    }

    public boolean validate(){
    boolean valid = true;
    if (username.isEmpty()){
        login_login.setError("Please, insert a valid username.");
        valid = false;
    }
    if (password.isEmpty()){
        password_login.setError("Please, insert a valid password.");
        valid = false;
    }
    return valid;
    }

}
