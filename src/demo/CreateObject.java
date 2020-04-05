package demo;


import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 对象的创建方式4种
 * 1. new 对象
 * 2. java反射创建对象
 * 3. 利用序列化创建对象
 * 4. 实现clone方法创建对象
 */
public class CreateObject {
    public static void main(String[] args) throws Exception {
        //new创建对象
        Dog dog1 = new Dog("1");
        System.out.println(dog1);

        //java反射创建对象
        //获取class对象的3种方法
        //1.直接使用class关键字
        Class<Dog> clazz1 = Dog.class;
        //2.class.forName()方法
        Class clazz2 = Class.forName("demo.Dog");
        //3.继承Object的getClass
        Dog dog = new Dog();
        Class clazz3 = dog.getClass();

        //newInstance调用无参构造器，必须含有一个无参构造器,若使用第2种过去class的方法，需要强转
        Dog dog2 = (Dog) clazz2.newInstance();
        dog2.setName("2");
        System.out.println(dog2);
        //调用有参构造器
        Constructor<Dog> constructor = clazz3.getConstructor(String.class);
        Dog dog3 = constructor.newInstance("3");
        System.out.println(dog3);

        //序列化创建对象，不会调用构造器
        //构造输出流，将对象存储在磁盘上
        FileOutputStream fps = new FileOutputStream("dog.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fps);
        oos.writeObject(dog1);
        oos.close();
        //构造输入流，将磁盘对象读到内存中
        FileInputStream fis = new FileInputStream("dog.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Dog dog4 = (Dog) ois.readObject();
        dog4.setName("4");
        ois.close();
        System.out.println(dog4);

        //实现clone方法创建对象
        Dog dog5 = (Dog) dog1.clone();
        dog5.setName("5");
        System.out.println(dog5);
    }
}

class Dog implements Serializable, Cloneable {
    String name;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}