#!/bin/bash

set -m

mkdir -p ~/.groovy/lib
cp ../.groovy/lib/*jar ~/.groovy/lib

#Doesn't have CORS
#python -m SimpleHTTPServer 8099
#Can't get this to work on Mountain Lion. Need to run in Eclipse.
groovy server.groovy &

# 100 nodes is too big, infovis hangs

sleep 3s

open "index.html"

fg 
