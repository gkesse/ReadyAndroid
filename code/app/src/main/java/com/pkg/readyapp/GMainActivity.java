//===============================================
package com.pkg.readyapp;
//===============================================
import android.os.*;
import android.app.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.LinearLayout.*;
import android.content.*;
import java.util.*;
//===============================================
public class GMainActivity extends Activity implements OnClickListener {
    //===============================================
    private String VIEW_ID = "ADMIN"; 
    //===============================================
    private Map<View, String> m_menuId = new HashMap<View, String>();
    private List<String> m_menuKey = new ArrayList<String>();
    private Map<String, String> m_menuName = new HashMap<String, String>();
    //===============================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createMenuKey();
        createMenuName();
        createLayout();
        createIntent();
    }
    //===============================================
    @Override
    public void onClick(View v) {
        String lMenuId = m_menuId.get(v);
        if(lMenuId == null) return;
        if(lMenuId.equals(VIEW_ID)) return;
        Intent lIntent = GManager.Instance().getIntent(lMenuId);
        if(lIntent == null) return;
        startActivity(lIntent);
        //Toast.makeText(this, lMenuId, Toast.LENGTH_SHORT).show();
    }
    //===============================================
    private void createMenuKey() {
        m_menuKey.add(VIEW_ID);
        m_menuKey.add("SQLITE");
        m_menuKey.add("OPENCV");
        m_menuKey.add("FILE");
    }
    //===============================================
    private void createMenuName() {
        m_menuName.put(VIEW_ID, VIEW_ID);
    }
    //===============================================
    private void createLayout() {
        LinearLayout lMainLayout = new LinearLayout(this);
        lMainLayout.setOrientation(LinearLayout.VERTICAL);
        lMainLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                
        for(int i = 0; i < m_menuKey.size(); i++) {
            String lMenuId = m_menuKey.get(0);
            String lMenuT = m_menuKey.get(i);
            Button lMenuB = new Button(this);
            String lMenuN = m_menuName.get(lMenuT);
            if(lMenuN == null) lMenuN = lMenuT;
            lMenuB.setText(lMenuN);
            lMenuB.setAllCaps(false);
            lMenuB.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            lMenuB.setOnClickListener(this);
            lMainLayout.addView(lMenuB);
            if(i != 0) {lMenuId += "." + lMenuT;}
            m_menuId.put(lMenuB, lMenuId);
        }
        
        setContentView(lMainLayout);
    }
    //===============================================
    private void createIntent() {
        GManager.Instance().addIntent("ADMIN", getIntent()); 
        GManager.Instance().addIntent("ADMIN.SQLITE", new Intent(this, GSQLiteActivity.class)); 
        GManager.Instance().addIntent("ADMIN.SQLITE.TABLES_SHOW", new Intent(this, GSQLiteTablesShowActivity.class)); 
    }
    //===============================================
}
//===============================================
