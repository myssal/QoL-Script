@ECHO OFF
PUSHD.
FOR /R %%d IN (.) DO (
    cd "%%d"
	for /f %%f in ('dir /b /a-d ^| findstr /vile ".png .skel .atlas .bat"') do del "%%f"
)
POP

rem for /f %F in ('dir /b /a-d ^| findstr /vile ".png .skel .atlas .bat"') do del "%F"