#!/bin/bash

set -m

mkdir -p ~/.groovy/lib
cp ../.groovy/lib/*jar ~/.groovy/lib

groovy server.groovy &
sleep 3s

open "index.html"

fg 
