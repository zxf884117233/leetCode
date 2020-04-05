package demo;

public class TestGCRoot {
    public static void method01() {

        TestGCRoot t = new TestGCRoot();

        System.gc();

        System.out.println("第一次GC完成");

    }

    private int _10MB = 10 * 1024 * 1024;

    private byte[] memory = new byte[8 * _10MB];


    public static void main(String[] args) {

        method01();

        System.out.println("返回main方法");

        System.gc();

        System.out.println("第二次GC完成");
    }
}