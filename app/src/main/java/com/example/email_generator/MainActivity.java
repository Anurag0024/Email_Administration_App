package com.example.email_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText edt1,edt2;
    TextView emp_detail;
    Button btn_generate;
    AutoCompleteTextView department_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1= (EditText)findViewById(R.id.fname_id);
        edt2= (EditText)findViewById(R.id.lname_id);
        btn_generate = (Button)findViewById(R.id.genrate_btnid);
        emp_detail= (TextView) findViewById(R.id.account_id);
        department_tv= (AutoCompleteTextView)findViewById(R.id.department_id);

        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = edt1.getText().toString();
                String lname = edt2.getText().toString();
                String depart = department_tv.getText().toString();

                if (!TextUtils.isEmpty(fname) & !TextUtils.isEmpty(lname) && !TextUtils.isEmpty(depart))
                {
                    emp_detail.setText("Your Name:  " + fname + lname + "\nYour Email:   " + fname + "." + lname +
                            "@" + depart + "_company.com" + "\nYour Password:   " + generatepassword(8) + "\nMail Box Capacity:   1000");
                }
                else
                    {
                        Toast.makeText(MainActivity.this, "Please fill emoployee all detail", Toast.LENGTH_SHORT).show();
                }
            }
        });

// this is for the department of the employee
          String[] departments= new String[]{"Hr","Development","Commercial","Sales","Accounts","None"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,departments);
         department_tv.setAdapter(adapter);
         //this is for the when the user click on the autocomplete text view to show list
          department_tv.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
               department_tv.showDropDown();
              }
          });




    }

    private String generatepassword(int length){
        char[] chars= "AJYD56DRSK34ISNSTI4MSZEH3HDMEI28272829JWSNWSSVTSWWUX38EYHE4T37E8E8EIWJWNW".toCharArray();
        StringBuilder stringBuilder= new StringBuilder();
        Random random= new Random();
        for(int i=0;i<length;i++)
        {
            char c= chars[random.nextInt(chars.length)];
            stringBuilder.append(c);

        }
        return stringBuilder.toString();
    }
}