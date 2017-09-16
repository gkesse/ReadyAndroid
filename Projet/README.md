# Projet Android

La création d'un **Projet Android** nécessite les technologies suivantes :  
* Kit de Développement Java : **JDK**
* Kit de Développement Android : **Android SDK**
* Compilation et Déploiement : **Ant**

# Création d'un Projet Android

Pour la création d'un projet Android, sous Windows :
* Créez un fichier script batch `cmd_create_project.bat` 
* Insérez les instructions ci-dessous
* Exécutez le script en ligne de commande
```
@echo off

set PATH=C:\Windows\System32;
set PATH=C:\Program Files (x86)\Java\jdk1.8.0_77\bin;%PATH%
set PATH=C:\NVPACK\android-sdk-windows;%PATH%
set PATH=C:\NVPACK\android-sdk-windows\platforms;%PATH%
set PATH=C:\NVPACK\android-sdk-windows\platform-tools;%PATH%
set PATH=C:\NVPACK\android-sdk-windows\tools;%PATH%

set GTARGET=android-19
set GNAME=GApp
set GPATH="../GProject"
set GACTIVITY=GMain
set GPKG=com.pkg.app

android create project ^
--target %GTARGET% ^
--name %GNAME% ^
--path %GPATH% ^
--activity %GACTIVITY% ^
--package %GPKG%
```

# Structure d'un Projet Android
![Structure](https://raw.githubusercontent.com/gkesse/ReadyAndroid/master/Projet/img/Structure.png)

# Voir Aussi 
* [ReadyAndroid](https://github.com/gkesse/ReadyAndroid "ReadyAndroid")  
* [Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet "Projet Android")  
* [Création d'un Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#création-dun-projet-android "Création d'un Projet Android")  
* [Structure d'un Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#structure-dun-projet-android "Structure d'un Projet Android")  
