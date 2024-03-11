@ECHO OFF
PUSHD .
FOR /R %%d IN (.) DO (
    cd "%%d"
    IF EXIST *. (
       REN *. *.json
    )
)
POP