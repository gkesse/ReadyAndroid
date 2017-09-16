# Ressource

La création d'une **Ressource** nécessite les actions suivantes :
* Editez la ressource dans un fichier ressource XML
* Utiliser la ressource dans un fichier activité Java

# Création d'une Ressouce

Nous allons créer la ressource ci-dessous :
* Type de la ressource : **string**
* Nom de la ressource : **hello_world**
* Type de la ressource : **Resource : Hello World !**

Pour créer la resource **hello_world** :
* Ouvrez le fichier ressource XML (res/values/strings)
* Insérez le code ci-dessous
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
* Ouvrez le fichier activité Java (src/com/pkg/app/GMain.java)
* Insérez le code ci-dessous
* Enregistrez le fichier activité Java
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

# Résultats
![Resultats](https://raw.githubusercontent.com/gkesse/ReadyAndroid/master/Resource/img/Resultats.png)

# Voir Aussi
* [ReadyAndroid](https://github.com/gkesse/ReadyAndroid "ReadyAndroid")  
