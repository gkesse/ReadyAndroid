@echo off

set PATH=C:\Ant\apache-ant-1.9.6\bin

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
