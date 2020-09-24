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
public class GSQLiteTablesShowActivity extends Activity implements OnClickListener {
    //===============================================
    private String VIEW_ID = "ADMIN.SQLITE.TABLES_SHOW"; 
    //===============================================
    private Map<View, String> m_menuId = new HashMap<View, String>();
    private List<String> m_menuKey = new ArrayList<String>();
    private Map<String, String> m_menuName = new HashMap<String, String>();
    private LinearLayout m_mainLayout = null;
    private LinearLayout m_addressLayout = null;
    private LinearLayout m_bodyLayout = null;
    //===============================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createMenuKey();
        createMenuName();
        createLayout();
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
        finish();
        //Toast.makeText(this, lMenuId, Toast.LENGTH_SHORT).show();
    }
    //===============================================
    private void createMenuKey() {
        m_menuKey.add(VIEW_ID);
        m_menuKey.add("INTERFACE");
    }
    //===============================================
    private void createMenuName() {
        m_menuName.put(VIEW_ID, VIEW_ID);
    }
    //===============================================
    private void createLayout() {
        m_mainLayout = new LinearLayout(this);
        m_addressLayout = new LinearLayout(this);
        m_bodyLayout = new LinearLayout(this);
        
        m_mainLayout.setOrientation(LinearLayout.VERTICAL);
        m_addressLayout.setOrientation(LinearLayout.HORIZONTAL);
        m_bodyLayout.setOrientation(LinearLayout.VERTICAL);
        
        m_mainLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        m_addressLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        m_bodyLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        
        for(int i = 0; i < m_menuKey.size(); i++) {
            String lMenuId = m_menuKey.get(0);
            String lMenuT = m_menuKey.get(i);
            if(i == 0) {
                createAddress(lMenuT);
                continue;
            }
            Button lMenuB = new Button(this);
            lMenuB.setText(lMenuT);
            lMenuB.setAllCaps(false);
            lMenuB.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            lMenuB.setOnClickListener(this);
            m_bodyLayout.addView(lMenuB);
            if(i != 0) {lMenuId += "." + lMenuT;}
            m_menuId.put(lMenuB, lMenuId);
        }
        
        m_mainLayout.addView(m_addressLayout);
        m_mainLayout.addView(m_bodyLayout);
        setContentView(m_mainLayout);
    }
    //===============================================
    private void createAddress(String addressId) {
        String[] lAddressM = addressId.split("\\.");
        String lAddressId = "";
        for(int i = 0; i < lAddressM.length; i++) {
            if(i != 0) {
                TextView lAddressC = new TextView(this);
                lAddressC.setText(">");
                lAddressC.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                m_addressLayout.addView(lAddressC);
            }
            String lAddressT = lAddressM[i];
            Button lAddressB = new Button(this);
            lAddressB.setText(lAddressT);
            lAddressB.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            lAddressB.setOnClickListener(this);
            m_addressLayout.addView(lAddressB);
            if(i != 0) lAddressId += ".";
            lAddressId += lAddressT;
            m_menuId.put(lAddressB, lAddressId);
        }
    }
    //===============================================
}
//===============================================
