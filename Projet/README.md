# Projet Android

La cr�ation d'un **Projet Android** n�cessitent les technologies suivantes :  
* Kit de D�veloppement Java : **JDK**
* Kit de D�veloppement Android : **Android SDK**

# Cr�ation d'un Projet Android

Pour la cr�ation d'un projet Android, sous Windows :
* Cr�ez un fichier script batch `cmp_create_project.bat` 
* Ins�rez les instructions ci-dessous
* Ex�cutez le script en ligne de commande
```
@echo off

set PATH=C:\Windows\System32;
set PATH=C:\Program Files (x86)\Java\jdk1.8.0_77\bin;%PATH%
set PATH=C:\NVPACK\android-sdk-windows;%PATH%
set PATH=C:\NVPACK\android-sdk-windows\platforms;%PATH%
set PATH=C:\NVPACK\android-sdk-windows\platform-tools;%PATH%
set PATH=C:\NVPACK\android-sdk-windows\tools;%PATH%
set PATH=C:\Ant\apache-ant-1.9.6\bin;%PATH%

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
