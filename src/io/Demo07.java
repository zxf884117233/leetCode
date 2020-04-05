package io;

import java.io.File;

public class Demo07 {
    public static void main(String[] args) {
        File f=new File("E:\\");
        String []list=f.list();//返回目录下的所有的内容
        for(String tem:list){
            System.out.println(tem);
        }
    }
}
