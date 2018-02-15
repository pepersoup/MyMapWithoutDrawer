package com.example.lulu.mymapwithoutdrawer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lulu on 15/02/2018.
 */

import android.database.sqlite.SQLiteOpenHelper;


public class DBHelperClass extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME= "db_naturepeople.db";
    public static final String TABLE_NAME= "users";
    public static final String ID= "usersId";
    public static final String NAME= "userName";
    public static final String PASSWORD= "userPassword";
    public static final String EMAIL= "userEmail";
    public static final String ADDRESS= "userAddress";
    public static final int TYPE= 0;

    private SQLiteDatabase database;


    public DBHelperClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME);

    }

    public boolean insertDataUsers(String name, String password, String email, String address){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(PASSWORD, password);
        contentValues.put(EMAIL, email);
        contentValues.put(ADDRESS, address);
        //contentValues.put(TYPE, type);
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        //how to know if the values are inserted or not
        //insert method will return -1 id not have been inserted

        if(result == -1){
            return false;
        }else {
            return true;
        }
    }
}
