package io;

import java.io.File;

public class Demo04 {
    public static void main(String[] args) {
        File []all=File.listRoots();
        for(File tem:all){
            System.out.println(tem+"\t"+tem.getFreeSpace()/1024/1024/1024.0+
                    "G---"+tem.getTotalSpace()/1024/1024/1024.0+"G");
        }

    }
}
