package io;

import java.io.File;

public class Demo08 {
    public static void main(String[] args) {
        File f=new File("E:\\");
        File [] all=f.listFiles();
        for(File tem:all){
            if(tem.isDirectory()){
                System.out.println("<dir>" + tem);
            }else{
                System.out.println(tem);
            }
        }
    }
}
