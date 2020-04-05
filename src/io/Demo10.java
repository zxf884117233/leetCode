package io;

import java.io.File;
import java.io.FileFilter;

public class Demo10 {
    public static void main(String[] args) {
        File f=new File("E:\\");
        File [] list=f.listFiles(new FileFilter() {
            @Override
            //过滤目录
            public boolean accept(File pathname) {
                if(pathname.isDirectory())
                    return  true;
                else
                    return false;
            }
        });
        for(File tem:list){
            System.out.println(tem);
        }
    }
}
