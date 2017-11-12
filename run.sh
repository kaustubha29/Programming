#!/bin/sh
rm -rf $prog_name.class

prog_name=$1
SECONDS=0
clear
javac $prog_name.java
java $prog_name
echo
duration=$SECONDS


RC=$?
if [ $RC -ne 0 ]
then
	echo Failure :: Errorcode $RC
else
	echo Success in $duration seconds
fi


