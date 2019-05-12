#!/bin/bash

WGET="/usr/local/bin/wget"

$WGET $1 -P $2

echo "Content of $2 after download: "
ls $2

exit 0