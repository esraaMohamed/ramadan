#!/bin/bash

WGET="/usr/local/bin/wget"
echo $1
FILE="${1//.[eE]/.s01.e}"
cd $2; $WGET -t 2 -a log.txt $1 -O $2/$FILE

exit 0