//===============================================
package com.pkg.readyapp;
//===============================================
import java.util.*;
//===============================================
// manager
//===============================================
public class GPicto {
    //===============================================
    private static GPicto m_intance = null;
    //===============================================
    private HashMap<String, String> m_pictoMap;
    //===============================================
    private GPicto() {
        m_pictoMap = new HashMap<String, String>();
        m_pictoMap.put("addressbook", "\uf2b9");
    }
    //===============================================
    public static synchronized GPicto Instance() {           
        if(m_intance == null) {   
            m_intance = new GPicto(); 
        }
        return m_intance;
    }
    //===============================================
    public HashMap<String, String> getData() {
        return m_pictoMap;
    }
    //===============================================
}
//===============================================
