package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo12 {
    public static void main(String[] args) throws Exception{
        OutputStream os=new FileOutputStream("D:aa.txt");
        String str="大家好";
        byte [] data=str.getBytes("utf-8");
        os.write(data);
        os.close();
        InputStream is=new FileInputStream("D:aa.txt");
        int n=-1;
        while ((n=is.read(data))!=-1){
            System.out.println(n);
            String newstr=new String(data,0,n);
            System.out.print(newstr);
        }
    }
}
