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