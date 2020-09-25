//===============================================
package com.pkg.readyapp;
//===============================================
import android.content.*;
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
        queryCreate(lQuery);
        // creation
        lQuery = ""+
        "create table CONFIG_ANDROID(\n"+
        "CONFIG_KEY text unique not null,\n"+
        "CONFIG_VALUE text\n"+
        ")\n"+
        "";
        queryCreate(lQuery);
    }
    //===============================================
    public void queryCreate(String sql) {        
        sGAndroid lAndroid = GManager.Instance().dataGet().android;
        sGSQLite lSqlite = GManager.Instance().dataGet().sqlite;
        GSQLiteHelper lDbHelper = new GSQLiteHelper(lAndroid.context, lSqlite.db_name, lSqlite.db_version);
        SQLiteDatabase lDb = lDbHelper.getWritableDatabase();
        lDb.execSQL(sql);
        lDb.close();
    }
    //===============================================
}
//===============================================
