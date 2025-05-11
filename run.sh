#!/bin/bash

if ["$#" -ne 1]; then
    echo "Usage: source run.sh {name}"
    return 1
fi

FILE="$1"
FILE_PATH="~/Documents/stax/src/main/core/"
RUNABLE="${FILE}.java"
JUMP="cd ${FILE_PATH}"

cd "$FILE_PATH" || { echo "Can't cd to $FILE_PATH"; return 1; }
echo "Compiling ${FILE}... "
javac "${RUNABLE}"

if [$? -ne 0]; then
    echo "Compilation failed."
    return 1
fi

echo "Running ${FILE}..."
java "${FILE}"
