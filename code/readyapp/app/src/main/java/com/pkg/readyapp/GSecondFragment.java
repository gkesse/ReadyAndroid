//===============================================
package com.pkg.readyapp;
//===============================================
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.LinearLayout.*;
import android.content.*;
import android.net.*;
//===============================================
public class GSecondFragment extends Fragment {
    //===============================================
    private LinearLayout lFragLayout;
    //===============================================
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout lMainLayout = new LinearLayout(getActivity());
        lMainLayout.setOrientation(LinearLayout.VERTICAL);
        lMainLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView lTextView = new TextView(getActivity());
        lTextView.setText("Je suis le fragment ");
                
        lMainLayout.addView(lTextView);

        return lMainLayout;
    }
    //===============================================
}
//===============================================
