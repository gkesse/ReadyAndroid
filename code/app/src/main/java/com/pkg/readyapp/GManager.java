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
    private Map<String, Intent> m_intentMap = new HashMap<String, Intent>(); 
    //===============================================
    private GManager() {
        
    }
    //===============================================
    public static synchronized GManager Instance() {           
        if(m_instance == null) {   
            m_instance = new GManager(); 
        }
        return m_instance;
    }
    //===============================================
    public void addIntent(String key, Intent value) {           
        m_intentMap.put(key, value);
    }
    //===============================================
    public Intent getIntent(String key) {           
        return m_intentMap.get(key);
    }
    //===============================================
}
//===============================================
