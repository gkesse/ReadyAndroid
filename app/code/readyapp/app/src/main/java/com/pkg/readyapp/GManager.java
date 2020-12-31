//===============================================
package com.pkg.readyapp;
//===============================================
import android.content.*;
import android.content.res.*;
import android.widget.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.view.*;
import java.io.*;
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
    private HashMap<String, Typeface> m_faceMap;
    //===============================================
    private GManager() {
        // manager
        mgr = new sGManager();
        // app
        mgr.app = new sGApp();
        mgr.app.app_name = "ReadyApp";
        mgr.app.font_map = new HashMap<String, String>();
        mgr.app.app_font = "allan-regular.ttf";
        mgr.app.icon_font = "fontawesome-webfont.ttf";
        mgr.app.page_id = new HashMap<String, Integer>();
        mgr.app.title_map = new HashMap<String, String>();
        mgr.app.address_url = "home";
        mgr.app.sqlite_db_path = "config.dat";
        mgr.app.sqlite_db_version = 1;
        // font
        m_faceMap = new HashMap<String, Typeface>();
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
    public void loadData() {
        mgr.app.font_map = loadAsset("fonts");
        mgr.app.icon_map = GPicto.Instance().getData();
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
    // asset
    //===============================================
    public HashMap<String, String> loadAsset(String name) {
        AssetManager lAssetManager = mgr.app.context.getAssets();        
        String[] lAssetMap;
        HashMap<String, String> lMap = new HashMap<String, String>();
        
        try {
            lAssetMap = lAssetManager.list(name);
        }
        catch(Exception e) {
            return null;
        }
        
        for(String lAsset : lAssetMap) {
            String lKey = lAsset.toLowerCase();
            String lPath = name + "/" + lAsset;
            lMap.put(lKey, lPath);
        }
        return lMap;
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
    // typeface
    //===============================================
    public Typeface loadFace(String font) {
        Typeface lTypeface = m_faceMap.get(font);
        if(lTypeface == null) {
            try {
                lTypeface = Typeface.createFromAsset(mgr.app.context.getAssets(), mgr.app.font_map.get(font));
            }
            catch(Exception e) {
                return null;
            }
            m_faceMap.put(mgr.app.font_map.get(font), lTypeface);
        }
        return lTypeface;
    }
    //===============================================
    // bitmap
    //===============================================
    public Bitmap getBitmap(String path, String name, int newWidth, int newHeight) {
        AssetManager lAssetManager = mgr.app.context.getAssets();
        InputStream lInputStream;
        Bitmap lBitmap;
        String lFilename = path + "/" + name;
        
        try {
            lInputStream = lAssetManager.open(lFilename);
            lBitmap = BitmapFactory.decodeStream(lInputStream);
            if(newWidth != 0 && newHeight != 0) {
                lBitmap = Bitmap.createScaledBitmap(lBitmap, newWidth, newHeight, false);
            }
        } 
        catch (Exception e) {
            return null;
        } 
        try {
            lInputStream.close();
        } 
        catch (Exception e) {
            return null;
        } 
        return lBitmap;
    }
    //===============================================
    public Bitmap getBitmap(String name, int newWidth, int newHeight) {
        return getBitmap("images", name, newWidth, newHeight);
    }
    //===============================================
    public Bitmap getBitmap(String name) {
        return getBitmap("images", name, 0, 0);
    }
    //===============================================
    // space
    //===============================================
    public View spaceV(int size) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        Space lSpace = new Space(lApp.context);
        lSpace.setMinimumHeight(size);
        return lSpace;
    }
    //===============================================
    public View spaceH(int size) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        Space lSpace = new Space(lApp.context);
        lSpace.setMinimumWidth(size);
        return lSpace;
    }
    //===============================================
    // bgcolor
    //===============================================
    public GradientDrawable bgColor(String bgColor, int borderRadius, int borderWidth, String borderColor) {
        GradientDrawable lBgColor = new GradientDrawable();
        if(!bgColor.equals("")) {lBgColor.setColor(Color.parseColor(bgColor));}
        if(borderRadius != 0) {lBgColor.setCornerRadius(borderRadius);}
        if(borderWidth != 0) {lBgColor.setStroke(borderWidth, Color.parseColor(borderColor));}
        return lBgColor;
    }
    //===============================================
    public GradientDrawable bgColor(String bgColor, int borderRadius) {
        return bgColor(bgColor, borderRadius, 0, "");
    }
    //===============================================
    public GradientDrawable bgColor(String bgColor) {
        return bgColor(bgColor, 0, 0, "");
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
        public String app_font;
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
        // font
        public HashMap<String, String> font_map;
        // icon
        public String icon_font;
        public HashMap<String, String> icon_map;
        // sqlite
        String sqlite_db_path;
        int sqlite_db_version;
    }
    //===============================================
}
//===============================================
