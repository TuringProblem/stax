#!/bin/bash

if ["$#" -ne 1]; then
    echo "Usage: source run.sh {name}"
    return 1
fi

FILE="$1"
FILE_PATH="/src/main/java/"
RUNABLE="${FILE_PATH}${FILE}.java"

if [! -f "$RUNABLE"]; then
    echo "Error: ${RUNABLE} not found."
    return 1
fi
cd "$FILE_PATH"
echo "Compiling ${FILE}... "
javac "${FILE}.java"

if [$? -ne 0]; then
    echo "Compilation failed."
    return 1
fi

echo "Running ${FILE}..."
java "${FILE}"
