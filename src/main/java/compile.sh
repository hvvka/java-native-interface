#!/bin/bash

javac -h com/hania com/hania/DotProduct.java com/hania/MainFrame.java
gcc -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin" -dynamiclib -o com/hania/libdotproduct.dylib com/hania/com_hania_DotProduct.c
java -Djava.library.path=./com/hania/. com/hania/MainFrame
