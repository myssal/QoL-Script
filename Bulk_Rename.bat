rem bulk rename certain file extension in directory(include subfolder)
@ECHO OFF
PUSHD .
FOR /R %%d IN (.) DO (
    cd "%%d"
    IF EXIST *.txt (
       REN *.txt *.
    )
	IF EXIST *.prefab (
       REN *.prefab *.
    )
	IF EXIST *.asset (
       REN *.asset *.
    )
)
rem POP