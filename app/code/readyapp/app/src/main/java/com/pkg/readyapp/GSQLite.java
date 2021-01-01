//===============================================
package com.pkg.readyapp;
//===============================================
import android.content.*;
import android.database.*;
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
        String lQuery;
        // config_data
        lQuery = String.format(""+
        "create table if not exists config_data (\n"+
        "config_key text,\n"+
        "config_value text\n"+
        ")\n"+
        "");
        queryWrite(lQuery);
        // config_data
        lQuery = String.format(""+
        "select type, name, tbl_name, rootpage from sqlite_master\n"+
        "where type='table'\n"+
        "");
        queryShow(lQuery, "10;20;20", 10);
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
    public void queryShow(String sql, String widthMap, int defaultWidth) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        SQLiteDatabase lDb = getWritableDatabase();
        Cursor lCursor = lDb.rawQuery(sql, null);
        String[] lColumnNames = lCursor.getColumnNames();
        int lColumnCount = lColumnNames.length;
        // sep
        lApp.debug.append(String.format("+-"));
        for(int i = 0; i < lColumnCount; i++) {
            if(i != 0) {lApp.debug.append(String.format("-+-"));}
            int lWidth = GManager.Instance().getWidth(widthMap, i, defaultWidth);
            for(int j = 0; j < lWidth; j++) {
                lApp.debug.append(String.format("-"));
            }
        }
        lApp.debug.append(String.format("-+"));
        lApp.debug.append(String.format("\n"));
        // header
        lApp.debug.append(String.format("| "));
        for(int i = 0; i < lColumnCount; i++) {
            if(i != 0) {lApp.debug.append(String.format(" | "));}
            String lColumnName = lColumnNames[i];
            int lWidth = GManager.Instance().getWidth(widthMap, i, defaultWidth);
            lApp.debug.append(String.format("%" + (-lWidth) + "s", lColumnName));
        }
        lApp.debug.append(String.format(" |"));
        lApp.debug.append(String.format("\n"));
        // sep
        lApp.debug.append(String.format("+-"));
        for(int i = 0; i < lColumnCount; i++) {
            if(i != 0) {lApp.debug.append(String.format("-+-"));}
            int lWidth = GManager.Instance().getWidth(widthMap, i, defaultWidth);
            for(int j = 0; j < lWidth; j++) {
                lApp.debug.append(String.format("-"));
            }
        }
        lApp.debug.append(String.format("-+"));
        lApp.debug.append(String.format("\n"));
        // data
        if(lCursor.moveToFirst()) {
            for(int i = 0; i < lCursor.getCount(); i++) {
                lApp.debug.append(String.format("| "));
                for(int j = 0; j < lColumnCount; j++) {
                    if(j != 0) {lApp.debug.append(String.format(" | "));}
                    String lData = lCursor.getString(j);
                    int lWidth = GManager.Instance().getWidth(widthMap, j, defaultWidth);
                    lApp.debug.append(String.format("%" + (-lWidth) + "s", lData));
                }
                lApp.debug.append(String.format(" |"));
                lApp.debug.append(String.format("\n"));
                lCursor.moveToNext();
            }
            lCursor.close();
        }
        // sep
        lApp.debug.append(String.format("+-"));
        for(int i = 0; i < lColumnCount; i++) {
            if(i != 0) {lApp.debug.append(String.format("-+-"));}
            int lWidth = GManager.Instance().getWidth(widthMap, i, defaultWidth);
            for(int j = 0; j < lWidth; j++) {
                lApp.debug.append(String.format("-"));
            }
        }
        lApp.debug.append(String.format("-+"));
        lApp.debug.append(String.format("\n"));
        //
        lDb.close();
    }
    //===============================================
    public void queryWrite(String sql) {
        SQLiteDatabase lDb = getWritableDatabase();
        lDb.execSQL(sql);
        lDb.close();
    }
    //===============================================
}
//===============================================
