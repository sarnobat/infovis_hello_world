#!/bin/bash

set -m

groovy server.groovy &
sleep 3s

open "index.html"

fg 
