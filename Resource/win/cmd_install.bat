@echo off

set PATH=C:\Program Files (x86)\Java\jdk1.8.0_77\bin
set PATH=C:\Ant\apache-ant-1.9.6\bin;%PATH%

set GPATH=../GProject
set GBUILD=%GPATH%/build.xml

ant -buildfile %GBUILD% debug install
