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

# Configuration d'un T�l�phone Android Virtuel

Pour activer le mode de d�bogage USB d'un t�l�phone Android :
* Ouvrez le menu Android 
* Allez dans le menu Dev Settings
* Cochez l'option USB Debugging

Pour modifier la langue d'un t�l�phone Android :
* Ouvrez le menu Android 
* Allez dans le menu Settings
* Ouvrez le menu Languages & Inputs 
* Allez dans le menu Languages
* Choisissez une langue English (United State) 

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
* [D�marrage d'un Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#d�marrage-dun-projet-android "D�marrage d'un Projet Android")  
* [Cr�ation d'un Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#cr�ation-dun-projet-android "Cr�ation d'un Projet Android")  
* [Structure d'un Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#structure-dun-projet-android "Structure d'un Projet Android")  
* [Cr�ation d'un T�l�phone Android Virtuel](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#cr�ation-dun-t�l�phone-android-virtuel "Cr�ation d'un T�l�phone Android Virtuel")  
* [D�marrage d'un T�l�phone Android Virtuel](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#d�marrage-dun-t�l�phone-android-virtuel "D�marrage d'un T�l�phone Android Virtuel")  
* [Configuration d'un T�l�phone Android Virtuel](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#configuration-dun-t�l�phone-android-virtuel "Configuration d'un T�l�phone Android Virtuel")  
* [Compilation d'un Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#compilation-dun-projet-android "Compilation d'un Projet Android")  
* [D�ploiement d'un Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#d�ploiement-dun-projet-android "D�ploiement d'un Projet Android")  
* [Application Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#application-android "Application Android")  
