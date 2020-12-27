//===============================================
package com.pkg.readyapp;
//===============================================
import android.content.*;
import android.widget.*;
//===============================================
// manager
//===============================================
public class GManager {
    //===============================================
    private static GManager m_intance = null;
    //===============================================
    private sGManager mgr;
    //===============================================
    private GManager() {
        // manager
        mgr = new sGManager();
        // app
        mgr.app = new sGApp();
        mgr.app.button_bg = "#503030";
        mgr.app.button_border = "#503030";
        mgr.app.button_border_radius = 10;
        mgr.app.button_border_width = 1;
        mgr.app.font_awesome = "fonts/fontawesome-webfont.woff2";
    }
    //===============================================
    public static synchronized GManager Instance() {           
        if(m_intance == null) {   
            m_intance = new GManager(); 
        }
        return m_intance;
    }
    //===============================================
    // data
    //===============================================
    public sGManager getData() {
        return mgr;
    }
 //===============================================
    public void showData(String data) {
        System.out.print(String.format("[%s]\n", data));
    }
    //===============================================
    public void showData(String[] data) {
        System.out.print(String.format("["));
        for(int i = 0; i < data.length; i++) {
            if(i != 0) System.out.print(String.format(" ; "));
            String lData = data[i];
            System.out.print(String.format("%s", lData));
        }
        System.out.print(String.format("\n"));
    }
    //===============================================
    // message
    //===============================================
    public void showMessage(String text) {
        Toast.makeText(mgr.app.context, text, Toast.LENGTH_SHORT).show();
    }
    //===============================================
    // env
    //===============================================
    public String getEnv(String key) {
        return System.getenv(key);
    }
    //===============================================
    // string
    //===============================================
    public int getWidth(String widthMap, int index, int defaultWidth) {
        String[] lWidthMap = widthMap.split(";");
        int lLength = lWidthMap.length;
        if(index >= lLength) return defaultWidth;
        String lWidthId = lWidthMap[index]; int lOut;
        if(!isNumeric(lWidthId)) return defaultWidth;
        int lWidth = Integer.parseInt(lWidthId);
        return lWidth;
    }    
    //===============================================
    public boolean isNumeric(String str) {
        for (char lChar : str.toCharArray()) {
            if (!Character.isDigit(lChar)) return false;
        }
        return true;
    }
    //===============================================
    // struct
    //===============================================
    class sGManager {
        public sGApp app;
    }
    //===============================================
    class sGApp {
        // app
        public String app_name;
        // context
        Context context;
        // button
        public String button_bg;
        public String button_border;
        public int button_border_radius;
        public int button_border_width;
        // font
        public String font_awesome;
    }
    //===============================================
}
//===============================================