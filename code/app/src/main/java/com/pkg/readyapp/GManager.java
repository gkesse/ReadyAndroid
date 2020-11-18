//===============================================
package com.pkg.readyapp;
//===============================================
import android.content.*;
import android.widget.*;
import java.util.*;
//===============================================
// manager
//===============================================
public class GManager {
    //===============================================
    private static GManager m_instance = null;     
    //===============================================
    private sGManager m_mgr;
    //===============================================
    // constructor
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
    // data
    //===============================================
    public sGManager dataGet() {           
        return m_mgr;
    }
    //===============================================
    // show_data
    //===============================================
    public void showData(String data) {        
        Toast.makeText(m_mgr.android.context, data, Toast.LENGTH_SHORT).show();
    }
    //===============================================
    public void showList(List<String> data) {        
        String lData = "";
        for(int i = 0; i < data.size(); i++) {
            if(i != 0) lData += "\n";
            lData += data.get(i);
        }
        Toast.makeText(m_mgr.android.context, lData, Toast.LENGTH_SHORT).show();
    }
    //===============================================
    public void showMap(List<List<String>> data) {
        String lData = "";
        for(int i = 0; i < data.size(); i++) {
            if(i != 0) lData += "\n";
            for(int j = 0; j < data.get(i).size(); j++) {
                if(j != 0) lData += " | ";
                lData += data.get(i).get(j);
            }
        }
        Toast.makeText(m_mgr.android.context, lData, Toast.LENGTH_SHORT).show();
    }
    //===============================================
}
//===============================================
// struct
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
