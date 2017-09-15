@echo off

set PATH=C:\Windows\System32;
set PATH=C:\Program Files (x86)\Java\jdk1.8.0_77\bin;%PATH%
set PATH=C:\NVPACK\android-sdk-windows;%PATH%
set PATH=C:\NVPACK\android-sdk-windows\platforms;%PATH%
set PATH=C:\NVPACK\android-sdk-windows\platform-tools;%PATH%
set PATH=C:\NVPACK\android-sdk-windows\tools;%PATH%

set GTARGET=android-17
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
