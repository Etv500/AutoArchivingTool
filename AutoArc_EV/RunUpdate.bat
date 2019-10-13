@echo off

pushd %~dp0
taskkill /F /IM excel.exe
start "" cmd /c cscript Update.vbs
rem start javaw -jar App.jar
EXIT /B