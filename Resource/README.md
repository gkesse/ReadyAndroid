# Ressource

La cr�ation d'une **Ressource** n�cessite les actions suivantes :
* Editez la ressource dans un fichier ressource XML
* Utiliser la ressource dans un fichier activit� Java

# Cr�ation d'une Ressouce

Nous allons cr�er la ressource ci-dessous :
* Type de la ressource : **string**
* Nom de la ressource : **hello_world**
* Type de la ressource : **Resource : Hello World !**

Pour cr�er la resource **hello_world** :
* Ouvrez le fichier ressource XML (res/values/strings)
* Ins�rez le code ci-dessous
* Enregistrez le fichier ressource XML
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="app_name">GMain</string>
    <string name="hello_world">Resource : Hello World !</string>
</resources>
```

# Editer un fichier Ressource XML

Pour utiliser la ressource **hello_world** :
* Ouvrez le fichier activit� Java (src/com/pkg/app/GMain.java)
* Ins�rez le code ci-dessous
* Enregistrez le fichier activit� Java
```
//===============================================
package com.pkg.app;
//===============================================
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
//===============================================
public class GMain extends Activity {
    //===============================================
    private TextView m_textView = null;
    //===============================================
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        m_textView = new TextView(this);
        m_textView.setText(R.string.hello_world);
        
        setContentView(m_textView);
    }
    //===============================================
}
//===============================================
```

# R�sultats
![Resultats](https://raw.githubusercontent.com/gkesse/ReadyAndroid/master/Resource/img/Resultats.png)

# Voir Aussi
* [ReadyAndroid](https://github.com/gkesse/ReadyAndroid "ReadyAndroid")  
