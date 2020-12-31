//===============================================
package com.pkg.readyapp;
//===============================================
import android.content.*;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteDatabase.*;
//===============================================
// manager
//===============================================
public class GSQLite extends SQLiteOpenHelper {
    //===============================================
    private static GSQLite m_intance = null;
    //===============================================
    private GSQLite(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //===============================================
    public static synchronized GSQLite Instance() {           
        if(m_intance == null) {
            GManager.sGApp lApp = GManager.Instance().getData().app;
            m_intance = new GSQLite(lApp.context, lApp.sqlite_db_path, null, lApp.sqlite_db_version);; 
        }
        return m_intance;
    }
    //===============================================
    // callback
    //===============================================
    @Override
    public void onCreate(SQLiteDatabase db) {
        
    }
    //===============================================
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        
    }
    //===============================================
    // method
    //===============================================
    public void open() {

    }
    //===============================================
}
//===============================================
