package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {
private EditText Name;
private EditText password;
private TextView Info;
private Button Login;
private int count=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.etName);
        password=(EditText)findViewById(R.id.etPassword);
        Info=(TextView) findViewById(R.id.tvInfo);
        Login=(Button)findViewById(R.id.btnLogin);
        Info.setText("Remaining No of attempts: 5");
        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                validate(Name.getText().toString(),password.getText().toString());

            }
        });
    }
    private void validate(String username,String Password){
        if((username.equals("harish"))&&(Password.equals("true"))){
            Intent intent=new Intent(MainActivity.this,other_activity.class);
             startActivity(intent);
        }
        else{
            count--;
            Info.setText("Remaining No of attempts: "+String.valueOf(count));
            if(count==0){
                Login.setEnabled(false);
            }
        }
    }
}