@echo off
::===============================================
set "PATH=C:/msys64/usr/bin;%PATH%" 
set "PATH=C:/Program Files (x86)/Nox/bin;%PATH%"
set "PATH=C:/Program Files/Android/Android Studio/bin;%PATH%"
set "PATH=C:/Users/Admin/AppData/Local/Android/Sdk/emulator;%PATH%"
set "PATH=C:/Users/Admin/AppData/Local/Android/Sdk/tools;%PATH%"
::===============================================
set "GPROJECT_ROOT=C:/Users/Admin/Downloads/Programs"
set "GPROJECT_PATH=%GPROJECT_ROOT%/ReadyAndroid"
set "GPROJECT_SRC=%GPROJECT_PATH%/code/readyapp"
set "GPROJECT_APK=%GPROJECT_SRC%/app/build/outputs/apk/debug/app-debug.apk"
::===============================================
set "GNOX_ADDR=127.0.0.1"
set "GNOX_PORT=62001"
::===============================================
set "GAVD_NAME=Android_TV_720p_API_QG"
::===============================================
set "GDATA_PATH=%GPROJECT_PATH%/data"
::===============================================
set "GGIT_URL=https://github.com/gkesse/ReadyAndroid.git"
set "GGIT_NAME=ReadyAndroid"
::===============================================
