package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new Thread());
    }
}
