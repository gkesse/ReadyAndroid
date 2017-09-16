# D�marrage d'un Projet Android

Le d�marrage d'un **Projet Android** n�cessite les technologies suivantes :  
* Kit de D�veloppement Java : **JDK**
* Kit de D�veloppement Android : **Android SDK**
* Compilation et D�ploiement : **Ant**

# Cr�ation d'un Projet Android

Pour cr�er un projet Android, sous Windows :
* Cr�ez un fichier script batch `cmd_create_project.bat` 
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

# Cr�ation d'un T�l�phone Android Virtuel

Pour cr�er un t�l�phone Android virtuel, sous Windows :
* Cr�ez un fichier script batch `cmd_create_avd.bat` 
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

set GTARGET=android-19
set GNAME=GPhone
set GPATH=avd
set GSDCARD=
set GSKIN=HVGA-P
set GABI=default/armeabi-v7a

android create avd ^
-t %GTARGET% ^
-n %GNAME% ^
-p %GPATH% ^
-c %GSDCARD% ^
-s %GSKIN% ^
--abi %GABI%
```

# D�marrage d'un T�l�phone Android Virtuel

Pour d�marrer un t�l�phone Android virtuel, sous Windows :
* Cr�ez un fichier script batch `cmd_start_avd.bat` 
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

set GAVD=GPhone
set GGPU=host

emulator -avd %GAVD% -gpu %GGPU%
```

# Compilation d'un Projet Android

Pour compiler un projet Android, sous Windows :
* Cr�ez un fichier script batch `cmd_start_avd.bat` 
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

set GPATH=../GProject
set GBUILD=%GPATH%/build.xml

ant -buildfile %GBUILD% debug
```

# D�ploiement d'un Projet Android

Pour d�ployer un projet Android, sous Windows :
* Cr�ez un fichier script batch `cmd_install.bat` 
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

set GPATH=../GProject
set GBUILD=%GPATH%/build.xml

ant -buildfile %GBUILD% debug
```

# Application Android
![Application Android](https://raw.githubusercontent.com/gkesse/ReadyAndroid/master/Projet/img/Application.png)
![Resultat](https://raw.githubusercontent.com/gkesse/ReadyAndroid/master/Projet/img/Resultat.png)

# Voir Aussi 
* [ReadyAndroid](https://github.com/gkesse/ReadyAndroid "ReadyAndroid")  
* [Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet "Projet Android")  
* [Cr�ation d'un Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#cr�ation-dun-projet-android "Cr�ation d'un Projet Android")  
* [Structure d'un Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#structure-dun-projet-android "Structure d'un Projet Android")  
