@echo off
rem bat file directory

cd %~dp0
cd ..
set APP_HOME=%cd%
rem remove trail slash
if %APP_HOME:~-1%==\ SET APP_HOME=%APP_HOME:~0,-1%
rem replace \ with /
set APP_HOME=%APP_HOME:\=/%
echo Starting from %APP_HOME%

set PID_PATH=%APP_HOME%/temp/daemon.pid
if exist %PID_PATH% (
	echo "Application has started!"
	pause
	exit /B 0
) else (
	set CLASSPATH=%APP_HOME%/lib/*;%CLASSPATH%
	rem -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=127.0.0.1:6000,suspend=y
	start /min java -Dapp.home=%APP_HOME% -Dlogback.configurationFile=%APP_HOME%/conf/logback-daemon.xml ^
	-cp %CLASSPATH% jframe.launcher.Main
)




