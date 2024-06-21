package com.example.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database  extends SQLiteOpenHelper {
    private static final String dbname="calculator.db";

    public database(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Addition="CREATE TABLE ADDITION (ID INTEGER PRIMARY KEY AUTOINCREMENT, NUM1 DOUBLE, SIGN TEXT, NUM2 DOUBLE, RESULT DOUBLE)";
        db.execSQL(Addition);
        String Subtraction="CREATE TABLE SUBTRACTION (ID INTEGER PRIMARY KEY AUTOINCREMENT, NUM1 DOUBLE, SIGN TEXT, NUM2 DOUBLE, RESULT DOUBLE)";
        db.execSQL(Subtraction);
        String Multiplication="CREATE TABLE MULTIPLICATION (ID INTEGER PRIMARY KEY AUTOINCREMENT, NUM1 DOUBLE, SIGN TEXT, NUM2 DOUBLE, RESULT DOUBLE)";
        db.execSQL(Multiplication);
        String Division="CREATE TABLE DIVISION (ID INTEGER PRIMARY KEY AUTOINCREMENT, NUM1 DOUBLE, SIGN TEXT, NUM2 DOUBLE, RESULT DOUBLE)";
        db.execSQL(Division);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public boolean Insert_to_addition(double num1,double num2, double result )
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues add=new ContentValues();
        add.put("NUM1",num1);
        add.put("NUM2",num2);
        add.put("SIGN","+");
        add.put("RESULT",result);
        long r=db.insert("ADDITION",null,add);
        if(r==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean Insert_to_Subtraction(double num1,double num2, double result )
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues sub=new ContentValues();
        sub.put("NUM1",num1);
        sub.put("NUM2",num2);
        sub.put("SIGN","-");
        sub.put("RESULT",result);
        long r=db.insert("SUBTRACTION",null,sub);
        if(r==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean Insert_to_Multiplication(double num1,double num2, double result )
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues mul=new ContentValues();
        mul.put("NUM1",num1);
        mul.put("NUM2",num2);
        mul.put("SIGN","*");
        mul.put("RESULT",result);
        long r=db.insert("MULTIPLICATION",null,mul);
        if(r==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean Insert_to_Division(double num1,double num2, double result )
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues div=new ContentValues();
        div.put("NUM1",num1);
        div.put("NUM2",num2);
        div.put("SIGN","/");
        div.put("RESULT",result);
        long r=db.insert("DIVISION",null,div);
        if(r==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }




    public Cursor getAddition()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from ADDITION",null);
        return cursor;
    }
    public Cursor getSubtraction()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from SUBTRACTION",null);
        return cursor;
    }
    public Cursor getMultiplication()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from MULTIPLICATION",null);
        return cursor;
    }
    public Cursor getDivision()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from DIVISION",null);
        return cursor;
    }
    public void DeleteAddition()
    {
        SQLiteDatabase db=getWritableDatabase();
        db.delete("Addition",null,null);
    }
    public void DeleteSubtraction()
    {
        SQLiteDatabase db=getWritableDatabase();
        db.delete("Subtraction",null,null);
    }
    public void DeleteMultiplication()
    {
        SQLiteDatabase db=getWritableDatabase();
        db.delete("Multiplication",null,null);
    }
    public void DeleteDivision()
    {
        SQLiteDatabase db=getWritableDatabase();
        db.delete("Division",null,null);
    }

}
