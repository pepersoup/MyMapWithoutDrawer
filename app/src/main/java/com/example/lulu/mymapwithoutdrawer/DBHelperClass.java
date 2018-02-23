package com.example.lulu.mymapwithoutdrawer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lulu on 15/02/2018.
 */

import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.NavigationView;


public class DBHelperClass extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME= "db_naturepeople1.db";
    public static final String TABLE_NAME= "User";
    public static final String COLUMN_ID= "userId";
    public static final String COLUMN_NAME= "userName";
    public static final String COLUMN_PASSWORD= "userPassword";
    public static final String COLUMN_EMAIL= "userEmail";
    public static final String COLUMN_ADDRESS= "userAddress";
    public static final int TYPE= 0;

    private SQLiteDatabase sqLiteDatabase;

    private static final String TABLE_CREATE = "create table User (userId integer primary key not null," +
            "userName text not null, userPassword text not null, userEmail text not null, userAddress text);";


    public DBHelperClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //insertDataUsers(NAME,EMAIL,ADDRESS,PASSWORD);
        sqLiteDatabase.execSQL(TABLE_CREATE);
        this.sqLiteDatabase=sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS" +TABLE_NAME;

        sqLiteDatabase.execSQL(query);
        this.onCreate(sqLiteDatabase);

    }

    /*public boolean insertDataUsers(String name, String password, String email, String address){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(PASSWORD, password);
        contentValues.put(EMAIL, email);
        contentValues.put(ADDRESS, address);
        //contentValues.put(TYPE, type);
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        //how to know if the values are inserted or not
        //insert method will return -1 if an error occurred and data are not inserted
        return result != -1;
    }*/

    public boolean insertContact(Contact contact){
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String query = "select * from User";
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        int count = cursor.getCount();

        contentValues.put(COLUMN_ID, contact.getId());
        contentValues.put(COLUMN_NAME, contact.getName());
        contentValues.put(COLUMN_PASSWORD, contact.getPassword());
        contentValues.put(COLUMN_EMAIL, contact.getEmail());
        contentValues.put(COLUMN_ADDRESS, contact.getAddress());
        //contentValues.put(TYPE, type);
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();

        return true;

    }

    public String searchUser(String email){

        sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT userEmail, userPassword from"+ TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        String a,b;
        b = "Not found";

        if(cursor.moveToFirst()){

            do{
                a = cursor.getString(0);

                if(a.equals(email)){

                    b = cursor.getString(1);
                    break;
                }

            }while (cursor.moveToNext());
        }
        return b;
    }

}
