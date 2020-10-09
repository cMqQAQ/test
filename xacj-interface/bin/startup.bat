@echo off
set APP_PATH=%CD%
set APP_NAME=qcrcode-interface
set JAR_PATH=%APP_PATH%\app\%APP_NAME%-%1\%APP_NAME%.jar
set CNF_PATH=%APP_PATH%\app\%APP_NAME%-%1\application.properties
set JRE_PATH=%CD%\mid\jre
set MEM_OPTS=-Xms256m -Xmx512m

title %APP_NAME%

start %JRE_PATH%\bin\%APP_NAME% ^
-XX:MetaspaceSize=128m ^
-XX:MaxMetaspaceSize=128m ^
%MEM_OPTS% ^
-Xmn256m ^
-Xss256k ^
-XX:SurvivorRatio=8 ^
-XX:+UseConcMarkSweepGC ^
-Dspring.config.location=%CNF_PATH% ^
-jar %JAR_PATH%
exit

