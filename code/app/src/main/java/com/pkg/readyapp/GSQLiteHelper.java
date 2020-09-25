//===============================================
package com.pkg.readyapp;
//===============================================
import android.content.*;
import android.widget.*;
import android.database.*;
import android.database.sqlite.*;
import java.util.*;
//===============================================
public class GSQLiteHelper extends SQLiteOpenHelper {
  //===============================================
    public GSQLiteHelper(Context context, String dbName, int dbVersion) {
        super(context, dbName, null, dbVersion);
    }
    //===============================================
    @Override
    public void onCreate(SQLiteDatabase database) {}
    //===============================================
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    //===============================================
}
//===============================================
