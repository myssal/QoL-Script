@echo off
for %%a in (*.*) do (
md "%%~na" 2>nul
move "%%a" "%%~na"
)
pause