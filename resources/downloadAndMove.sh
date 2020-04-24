#!/bin/bash

CURL="/usr/bin/curl"

NAME=${1//.s01/}
PATH_ARR=(${NAME//\// })
FILE="$2${PATH_ARR[${#PATH_ARR[@]}-1]//.[eE]/.S01.E}"
echo "DOWNLOADING: $1"
echo "FILE NAME: $FILE"
#cd $2; $WGET -t 2 -a log.txt $1 -O $2/$FILE

$CURL -o $FILE -C - $1

exit 0