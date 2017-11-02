#!/bin/bash

if [ $# -eq 0 ]; then
   echo "USAGE: ./addResult.sh JSON_FILE"
   exit
fi

ADDRESS=http://localhost:9000
curl -XPOST -H "Content-Type: application/json" -d '@'$1'' $ADDRESS/result
