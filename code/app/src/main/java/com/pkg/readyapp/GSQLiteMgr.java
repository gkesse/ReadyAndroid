//===============================================
package com.pkg.readyapp;
//===============================================
import android.content.*;
import android.widget.*;
import android.database.*;
import android.database.sqlite.*;
//===============================================
public class GSQLiteMgr {
    //===============================================
    private static GSQLiteMgr m_instance = null;     
    //===============================================
    private GSQLiteMgr() {
        
    }
    //===============================================
    public static synchronized GSQLiteMgr Instance() {           
        if(m_instance == null) {   
            m_instance = new GSQLiteMgr(); 
        }
        return m_instance;
    }
    //===============================================
    public void test() {
        String lQuery = "";
        // suppression
        lQuery = ""+
        "drop table CONFIG_ANDROID\n"+
        "";
        queryWrite(lQuery);
        // creation
        lQuery = ""+
        "create table CONFIG_ANDROID(\n"+
        "CONFIG_KEY text unique not null,\n"+
        "CONFIG_VALUE text\n"+
        ")\n"+
        "";
        queryWrite(lQuery);
        // creation
        lQuery = ""+
        "insert into CONFIG_ANDROID(CONFIG_KEY, CONFIG_VALUE)\n"+
        "values('MY_KEY_01', 'MY_VALUE_01')\n"+
        "";
        queryWrite(lQuery);
        lQuery = ""+
        "insert into CONFIG_ANDROID(CONFIG_KEY, CONFIG_VALUE)\n"+
        "values('MY_KEY_02', 'MY_VALUE_02')\n"+
        "";
        queryWrite(lQuery);
        lQuery = ""+
        "insert into CONFIG_ANDROID(CONFIG_KEY, CONFIG_VALUE)\n"+
        "values('MY_KEY_03', 'MY_VALUE_03')\n"+
        "";
        queryWrite(lQuery);
        // affichage
        lQuery = ""+
        "select * from CONFIG_ANDROID\n"+
        "";
        queryShow(lQuery);
    }
    //===============================================
    public void queryWrite(String sql) {        
        sGAndroid lAndroid = GManager.Instance().dataGet().android;
        sGSQLite lSqlite = GManager.Instance().dataGet().sqlite;
        GSQLiteHelper lDbHelper = new GSQLiteHelper(lAndroid.context, lSqlite.db_name, lSqlite.db_version);
        SQLiteDatabase lDb = lDbHelper.getWritableDatabase();
        lDb.execSQL(sql);
        lDb.close();
    }
    //===============================================
    public void queryShow(String sql) {        
        sGAndroid lAndroid = GManager.Instance().dataGet().android;
        sGSQLite lSqlite = GManager.Instance().dataGet().sqlite;
        GSQLiteHelper lDbHelper = new GSQLiteHelper(lAndroid.context, lSqlite.db_name, lSqlite.db_version);
        SQLiteDatabase lDb = lDbHelper.getWritableDatabase();
        Cursor lCursor = lDb.rawQuery(sql, null);
        String lValue = "";
        if(lCursor.moveToFirst()) {
            int lColCount = lCursor.getColumnCount();
            while(true) {
                for(int i = 0; i < lColCount; i++) {
                    if(i != 0) lValue += " | ";
                    lValue += lCursor.getString(i);
                }
                lValue += "\n";
                if(!lCursor.moveToNext()) break;
            }
        }
        Toast.makeText(lAndroid.context, lValue, Toast.LENGTH_SHORT).show();
        lCursor.close();
        lDb.close();
    }
    //===============================================
    public String queryValue(String sql) {        
        sGAndroid lAndroid = GManager.Instance().dataGet().android;
        sGSQLite lSqlite = GManager.Instance().dataGet().sqlite;
        GSQLiteHelper lDbHelper = new GSQLiteHelper(lAndroid.context, lSqlite.db_name, lSqlite.db_version);
        SQLiteDatabase lDb = lDbHelper.getWritableDatabase();
        Cursor lCursor = lDb.rawQuery(sql, null);
        String lValue = "";
        if(lCursor.moveToFirst()) {
            lValue = lCursor.getString(0);
        }
        lCursor.close();
        lDb.close();
        return lValue;
    }
    //===============================================
}
//===============================================
