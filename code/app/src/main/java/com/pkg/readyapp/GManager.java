//===============================================
package com.pkg.readyapp;
//===============================================
import android.content.*;
import android.widget.*;
import java.util.*;
//===============================================
public class GManager {
    //===============================================
    private static GManager m_instance = null;     
    //===============================================
    private sGManager m_mgr;
    //===============================================
    private GManager() {
        // manager
        m_mgr = new sGManager();
        // android
        m_mgr.android = new sGAndroid();
        m_mgr.android.intent = new HashMap<String, Intent>();
        // sqlite
        m_mgr.sqlite = new sGSQLite();
        m_mgr.sqlite.db_name = ".CONFIG_O.dat";
        m_mgr.sqlite.db_version = 1;
    }
    //===============================================
    public static synchronized GManager Instance() {           
        if(m_instance == null) {   
            m_instance = new GManager(); 
        }
        return m_instance;
    }
    //===============================================
    public sGManager dataGet() {           
        return m_mgr;
    }
    //===============================================
}
//===============================================
class sGManager {
    public sGAndroid android;
    public sGSQLite sqlite;
}
//===============================================
class sGAndroid {
    public Map<String, Intent> intent;
    public Context context;
}
//===============================================
class sGSQLite {
    public String db_name;
    public int db_version;
}
//===============================================
