@echo off

set APP_PATH=%CD%
cd ..
cd ..
set APP_NAME=qcrcode-interface
set JAR_PATH=%APP_PATH%\%APP_NAME%.jar
set CNF_PATH=%APP_PATH%\application.properties
set JRE_PATH=%CD%\mid\jre
set MEM_OPTS=-Xms256m -Xmx512m

title %APP_NAME%

java ^
-XX:MetaspaceSize=128m ^
-XX:MaxMetaspaceSize=128m ^
%MEM_OPTS% ^
-Xmn256m ^
-Xss256k ^
-XX:SurvivorRatio=8 ^
-XX:+UseConcMarkSweepGC ^
-Dspring.config.location=%CNF_PATH% ^
-jar %JAR_PATH%
pause
