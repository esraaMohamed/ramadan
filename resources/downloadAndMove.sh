#!/bin/bash

WGET="/usr/local/bin/wget"

cd $2; $WGET -o /dev/stdout $1 -P $2 | tee -a log.txt

exit 0