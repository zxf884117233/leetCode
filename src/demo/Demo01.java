package demo;

import java.io.Closeable;
import java.io.IOException;

class A implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("s");
    }
}

class B implements Closeable {

    @Override
    public void close() throws IOException {
        throw new IOException();
    }
}

public class Demo01 {

    public static void main(String[] args) {
        try {
            A a = new A();
            B b = new B();
            System.out.println("T");
            a.close();
            b.close();
        } catch (Exception e) {
            System.out.println("IOE");
        } finally {
            System.out.println("P");
        }
    }

}