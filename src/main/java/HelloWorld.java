/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class HelloWorld {

    static {
        System.loadLibrary("hello");
    }

    public static void main(String[] args) {
        new HelloWorld().print();  // invokes the native method
    }

    public native void print();
}
