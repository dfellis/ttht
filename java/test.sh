#!/bin/sh

CLASSPATH=./build/libs/java.jar:/usr/share/java/junit4.jar
exec java -cp $CLASSPATH com.test.Main "$@"
