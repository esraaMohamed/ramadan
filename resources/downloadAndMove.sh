#!/bin/bash

WGET="/usr/local/bin/wget"

cd $2; $WGET -t 2 -a log.txt $1 -P $2

exit 0