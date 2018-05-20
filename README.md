# java-native-interface

## Setup

Type in CLI path to JDK:
```bash
$ export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home
```

or save to `~/.bash_profile`:
```bash
$ echo "export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home" >> ~/.bash_profile
$ source ~/.bash_profile
```


## Run

```bash
$ cd src/main/java
$ ./compile.sh
```

### Steps (manual)

Compile Java program and generate header file:
```bash
$ javac -h com/hania com/hania/DotProduct.java com/hania/MainFrame.java
```

Compile C program:
```bash
$ gcc -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin" -dynamiclib -o com/hania/libdotproduct.dylib com/hania/com_hania_DotProduct.c
```

Run the Java program:
```bash
$ java -Djava.library.path=./com/hania/. com/hania/DotProduct
```
