//===============================================
package com.pkg.readyapp;
//===============================================
import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteDatabase.*;
import java.util.*;
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
        GManager.Instance().showMap(queryMap(lQuery));
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
    public String queryValue(String sql) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        SQLiteDatabase lDb = getWritableDatabase();
        Cursor lCursor = lDb.rawQuery(sql, null);
        String[] lColumnNames = lCursor.getColumnNames();
        int lColumnCount = lColumnNames.length;
        String lData = "";
        
        if(lCursor.moveToFirst()) {
            for(int i = 0; i < lCursor.getCount(); i++) {
                for(int j = 0; j < lColumnCount; j++) {
                    lData = lCursor.getString(j);
                    break;
                }
                lCursor.moveToNext();
                break;
            }
            lCursor.close();
        }

        lDb.close();
        return lData;
    }
    //===============================================
    public List<String> queryCol(String sql) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        SQLiteDatabase lDb = getWritableDatabase();
        Cursor lCursor = lDb.rawQuery(sql, null);
        String[] lColumnNames = lCursor.getColumnNames();
        int lColumnCount = lColumnNames.length;
        List<String> lDataMap = new ArrayList<String>();
        
        if(lCursor.moveToFirst()) {
            for(int i = 0; i < lCursor.getCount(); i++) {
                for(int j = 0; j < lColumnCount; j++) {
                    String lData = lCursor.getString(j);
                    lDataMap.add(lData);
                    break;
                }
                lCursor.moveToNext();
            }
            lCursor.close();
        }

        lDb.close();
        return lDataMap;
    }
    //===============================================
    public List<String> queryRow(String sql) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        SQLiteDatabase lDb = getWritableDatabase();
        Cursor lCursor = lDb.rawQuery(sql, null);
        String[] lColumnNames = lCursor.getColumnNames();
        int lColumnCount = lColumnNames.length;
        List<String> lDataMap = new ArrayList<String>();
        
        if(lCursor.moveToFirst()) {
            for(int i = 0; i < lCursor.getCount(); i++) {
                for(int j = 0; j < lColumnCount; j++) {
                    String lData = lCursor.getString(j);
                    lDataMap.add(lData);
                }
                lCursor.moveToNext();
                break;
            }
            lCursor.close();
        }

        lDb.close();
        return lDataMap;
    }
    //===============================================
    public List<List<String>> queryMap(String sql) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        SQLiteDatabase lDb = getWritableDatabase();
        Cursor lCursor = lDb.rawQuery(sql, null);
        String[] lColumnNames = lCursor.getColumnNames();
        int lColumnCount = lColumnNames.length;
        List<List<String>> lDataMap = new ArrayList<List<String>>();
        
        if(lCursor.moveToFirst()) {
            for(int i = 0; i < lCursor.getCount(); i++) {
                List<String> lDataRow = new ArrayList<String>();
                for(int j = 0; j < lColumnCount; j++) {
                    String lData = lCursor.getString(j);
                    lDataRow.add(lData);
                }
                lDataMap.add(lDataRow);
                lCursor.moveToNext();
            }
            lCursor.close();
        }

        lDb.close();
        return lDataMap;
    }
    //===============================================
}
//===============================================
