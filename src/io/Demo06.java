package io;

import java.io.File;
import java.io.IOException;

public class Demo06 {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i <10 ; i++) {
            File tem=File.createTempFile("logs",".txt");
            tem.deleteOnExit();//当退出JVM虚拟机是，删除文件
        }
        Thread.sleep(10000);
    }
}
