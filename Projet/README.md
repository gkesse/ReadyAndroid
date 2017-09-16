# Démarrage d'un Projet Android

Le démarrage d'un **Projet Android** nécessite les technologies suivantes :  
* Kit de Développement Java : **JDK**
* Kit de Développement Android : **Android SDK**
* Compilation et Déploiement : **Ant**

# Création d'un Projet Android

Pour créer un projet Android, sous Windows :
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

# Création d'un Téléphone Android Virtuel

Pour créer un téléphone Android virtuel, sous Windows :
* Créez un fichier script batch `cmd_create_avd.bat` 
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

# Démarrage d'un Téléphone Android Virtuel

Pour démarrer un téléphone Android virtuel, sous Windows :
* Créez un fichier script batch `cmd_start_avd.bat` 
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

set GAVD=GPhone
set GGPU=host

emulator -avd %GAVD% -gpu %GGPU%
```

# Compilation d'un Projet Android

Pour compiler un projet Android, sous Windows :
* Créez un fichier script batch `cmd_start_avd.bat` 
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

set GPATH=../GProject
set GBUILD=%GPATH%/build.xml

ant -buildfile %GBUILD% debug
```

# Déploiement d'un Projet Android

Pour déployer un projet Android, sous Windows :
* Créez un fichier script batch `cmd_install.bat` 
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
* [Création d'un Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#création-dun-projet-android "Création d'un Projet Android")  
* [Structure d'un Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#structure-dun-projet-android "Structure d'un Projet Android")  
