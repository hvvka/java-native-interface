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

The simplest way:
```bash
$ ./gradlew run
```

And others:

#### Bash script

```bash
$ cd src/main/java
$ ./compile.sh
```

### Steps (manual)

Compile Java program and generate header file:
```bash
$ cd src/main/java
$ javac -h ../../dotproduct/c com/hania/DotProduct.java com/hania/MainFrame.java
```

Compile C program:
```bash
$ gcc -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin" -dynamiclib -o com/hania/libdotproduct.dylib ../../dotproduct/c/com_hania_DotProduct.c
```

Run the Java program:
```bash
$ java -Djava.library.path=./com/hania/. com/hania/MainFrame
```


## Tests

```bash
$ ./gradlew test
```
