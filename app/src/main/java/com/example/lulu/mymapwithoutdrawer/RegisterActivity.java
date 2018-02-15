package com.example.lulu.mymapwithoutdrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DBHelperClass myDb;
    EditText editName, editPassword, editEmail, editAddress;
    Button btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myDb = new DBHelperClass(this);

        editName = (EditText) findViewById(R.id.editText_Name);
        editPassword = (EditText) findViewById(R.id.editText_Password);
        editEmail = (EditText) findViewById(R.id.editText_Email);
        editAddress = (EditText) findViewById(R.id.editText_address);
        btn_register = (Button) findViewById(R.id.button_register);


        InsertRegisterData();
    }

    public void InsertRegisterData() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = myDb.insertDataUsers(editName.getText().toString(),
                        editPassword.getText().toString(),
                        editEmail.getText().toString(),
                        editAddress.getText().toString());
                if (isInserted) {
                    Toast.makeText(RegisterActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();

                }
            }

        }
        );
    }
}