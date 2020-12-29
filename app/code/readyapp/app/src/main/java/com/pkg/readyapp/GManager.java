//===============================================
package com.pkg.readyapp;
//===============================================
import android.content.*;
import android.widget.*;
import android.graphics.*;
import java.util.*;
//===============================================
// manager
//===============================================
public class GManager {
    //===============================================
    private static GManager m_intance = null;
    //===============================================
    private sGManager mgr;
    //===============================================
    private HashMap<String, Typeface> m_fontMap;
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
        mgr.app.page_id = new HashMap<String, Integer>();
        mgr.app.title_map = new HashMap<String, String>();
        mgr.app.address_url = "";
        // font
        m_fontMap = new HashMap<String, Typeface>();
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
    // font
    //===============================================
    public Typeface loadFont(String font) {
        Typeface lTypeface = m_fontMap.get(font);
        if(lTypeface == null) {
            try {
                lTypeface = Typeface.createFromAsset(mgr.app.context.getAssets(), font);
            }
            catch(Exception e) {
                showMessage("error");
                return null;
            }
            showMessage("ok");
            m_fontMap.put(font, lTypeface);
        }
        return lTypeface;
    }
    //===============================================
    // page
    //===============================================
    public void setPage(String address) {
        if(!mgr.app.page_id.containsKey(address)) {
            mgr.app.address_bar.setText(mgr.app.address_url);
            return;
        }
        int lPageId = mgr.app.page_id.get(address);
        String lTitle = mgr.app.title_map.get(address);
        mgr.app.page_map.setCurrentIndex(lPageId);
        mgr.app.address_key.setContent(address);
        mgr.app.address_bar.setText(address);
        mgr.app.title.setText(lTitle);
        mgr.app.address_url = address;
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
        public Context context;
        // address
        public EditText address_bar;
        public GWidget address_key;
        public String address_url;
        // widget
        public String widget_id;
        // page
        public GWidget page_map;
        public HashMap<String, Integer> page_id;
        // title
        public TextView title;
        public HashMap<String, String> title_map;
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
