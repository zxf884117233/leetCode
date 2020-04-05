package io;

import java.io.File;
import java.io.FilenameFilter;

public class Demo09 {
    public static void main(String[] args) {
        File f=new File("E:\\");
        String [] list=f.list(new FilenameFilter() {
            @Override
            //toLowerCase字符串中的字母被转换为小写字母  过滤文件
            public boolean accept(File dir, String name) {
                if(name.toLowerCase().endsWith(".jpg")){
                    return true;
                }else {
                    return false;
                }
            }
        });

        for(String tem:list){
            System.out.println(tem);
        }
    }
}
