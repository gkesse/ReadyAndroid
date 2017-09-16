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

# Configuration d'un Téléphone Android Virtuel

Pour activer le mode de débogage USB d'un téléphone Android :
* Ouvrez le menu Android 
* Allez dans le menu Dev Settings
* Cochez l'option USB Debugging

Pour modifier la langue d'un téléphone Android :
* Ouvrez le menu Android 
* Allez dans le menu Settings
* Ouvrez le menu Languages & Inputs 
* Allez dans le menu Languages
* Choisissez une langue English (United State) 

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
* [Démarrage d'un Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#démarrage-dun-projet-android "Démarrage d'un Projet Android")  
* [Création d'un Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#création-dun-projet-android "Création d'un Projet Android")  
* [Structure d'un Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#structure-dun-projet-android "Structure d'un Projet Android")  
* [Création d'un Téléphone Android Virtuel](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#création-dun-téléphone-android-virtuel "Création d'un Téléphone Android Virtuel")  
* [Démarrage d'un Téléphone Android Virtuel](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#démarrage-dun-téléphone-android-virtuel "Démarrage d'un Téléphone Android Virtuel")  
* [Configuration d'un Téléphone Android Virtuel](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#configuration-dun-téléphone-android-virtuel "Configuration d'un Téléphone Android Virtuel")  
* [Compilation d'un Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#compilation-dun-projet-android "Compilation d'un Projet Android")  
* [Déploiement d'un Projet Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#déploiement-dun-projet-android "Déploiement d'un Projet Android")  
* [Application Android](https://github.com/gkesse/ReadyAndroid/tree/master/Projet#application-android "Application Android")  
