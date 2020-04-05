package demo;

/**
 * 双检索
 *
 * @return
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    private static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

/**
 * 内部类线程安全
 */
class InnerSingleTon {
    private static class SingletonHolder {
        public static final InnerSingleTon singleton = new InnerSingleTon();
    }

    public static InnerSingleTon getSingleton() {
        return SingletonHolder.singleton;
    }
}

/**
 * 饿汉
 *
 * @return
 */
class LhSingleton {
    private LhSingleton() {
    }

    private static LhSingleton singleton;

    private static LhSingleton getSingleton() {
        if (singleton == null) {
            singleton = new LhSingleton();
        }
        return singleton;
    }
}

/**
 * 饿汉
 */
class EhSingleton {
    private EhSingleton() {
    }

    private static EhSingleton singleton = new EhSingleton();

    private static EhSingleton getSingleton() {
        return singleton;
    }
}