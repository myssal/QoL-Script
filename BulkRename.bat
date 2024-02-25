rem bulk rename certain file extension in directory(inclue subfolder)
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
)
POP