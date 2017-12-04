@echo off
set filePath=%~dp0
set log=\log
set log.path= %filePath:~0,-4%%log%

java -jar ../lib/suger.jar
@pause    	