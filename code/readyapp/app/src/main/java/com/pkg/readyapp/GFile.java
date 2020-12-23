//===============================================
package com.pkg.readyapp;
//===============================================
public class GFile {
    //===============================================
    private static GFile m_instance = null;     
    //===============================================
    private GFile() {
        
    }
    //===============================================
    public static synchronized GFile Instance() {           
        if(m_instance == null) {   
            m_instance = new GFile(); 
        }
        return m_instance;
    }
    //===============================================
}
//===============================================
