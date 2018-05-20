#!/bin/bash

javac -h ../../dotproduct/c com/hania/DotProduct.java com/hania/MainFrame.java
gcc -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin" -dynamiclib -o com/hania/libdotproduct.dylib ../../dotproduct/c/com_hania_DotProduct.c
java -Djava.library.path=./com/hania/. com/hania/MainFrame
