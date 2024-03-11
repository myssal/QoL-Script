rem @echo off
set a = test
rem test bulk create multiple file
for /l %x in (7,1,10) do 
	set /a inc = 7
	set fileName = %a% %inc%
	md %fileName%
	set fileInSubFolder = %fileName%\test.skel.txt
	type NUL > %fileInSubFolder%
	set /a inc = %inc% + 1
)

