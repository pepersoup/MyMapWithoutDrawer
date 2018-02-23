package com.example.lulu.mymapwithoutdrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DBHelperClass myDbHelper = new DBHelperClass(this);
    EditText editName, editPassword, editEmail, editAddress;
    //Button btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myDbHelper = new DBHelperClass(this);

    }

    public void onRegisterClick(View view){
        if(view.getId()==R.id.button_register){

            editName = findViewById(R.id.editText_Name);
            editPassword = findViewById(R.id.editText_Password);
            editEmail = findViewById(R.id.editText_Email);
            editAddress = findViewById(R.id.editText_address);

            String editNameStr = editName.getText().toString();
            String editEmailStr = editEmail.getText().toString();
            String editAddressStr = editAddress.getText().toString();
            String editPasswordStr = editPassword.getText().toString();

            Contact contact = new Contact();

            contact.setName(editNameStr);
            contact.setEmail(editEmailStr);
            contact.setAddress(editAddressStr);
            contact.setPassword(editPasswordStr);

            boolean isInserted= myDbHelper.insertContact(contact);

            if (isInserted) {
                Toast.makeText(RegisterActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(RegisterActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();

            }
        }
    }

    /*public void InsertRegisterData() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact contact = new Contact();

                contact.setName(editName.getText().toString());
                contact.setEmail(editEmail.getText().toString());
                contact.setAddress(editAddress.getText().toString());
                contact.setPassword(editPassword.getText().toString());

                myDb.insertDataUsers();
                boolean isInserted = myDb.insertDataUsers(
                        editName.getText().toString(),
                        editEmail.getText().toString(),
                        editAddress.getText().toString(),
                        editPassword.getText().toString()
                        );
                if (isInserted) {
                    Toast.makeText(RegisterActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();

                }
            }
        }
        );
    }*/
}