# java-native-interface

Temat: 
Rozbudowa wybranej aplikacji Java o funkcje zaimplementowane w 
kodzie natywnym. 

Wymagania: 
Do realizacji zadania potrzebna będzie wiedza o sposobie implementacji 
i wykorzystaniu metod natywnych (JNI). Niezbędna będzie znajomość tematu 
tworzenia bibliotek ładowanych dynamicznie w języku C/C++. 

Zadanie: 
Napisz program z wykorzystaniem JNI, w którym zostanie wykorzystana 
klasa posiadająca metody natywne służące do obliczania iloczynu skalarnego 
dwóch wektorów. Schemat implementacji tej klasy powinien być taki, 
jak pokazano poniżej. W trakcie implementacji należy zwrócić uwagę 
na właściwą alokację i zwalnianie pamięci po stronie kodu natywnego 
oraz na zgodność bitową JVM oraz bibliteki ładowanej dynamicznie (32/64 bit). 
Do realizacji zadania można wykorzystać dowolne kompilatory języka C/C++ 
(niezbędne do wygenerowania biblioteki ładowanej dynamicznie).

---------------

Include library in Java's library path: `-Djava.library.path=/path/to/lib`
 
---------------

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

Generate header file:
```bash
$ javac -h com/hania com/hania/DotProduct.java
```

## Run

Compile C program:
```bash
$ gcc -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin" -dynamiclib -o com/hania/libdotproduct.dylib com/hania/com_hania_DotProduct.c
```

Run the Java program:
```bash
$ java -Djava.library.path=./com/hania/. com/hania/DotProduct
```

----------------
