@echo off

for /f %%a in ('dir /a-d /b') do (
  if not "%%~dpnxa"=="%~dpnx0" call :func "%%~a"
)

goto :EOF

:func
set file=%~1
set dir=%file:~0,10% 
rem check first 10 characters
md "%dir%" 2>nul
move "%file%" "%dir%" 
goto :EOF