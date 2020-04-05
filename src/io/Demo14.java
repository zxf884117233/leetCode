package io;

import java.io.*;

public class Demo14 {
    public static void main(String[] args) throws Exception {
        File f=new File("D:cc.txt");
        if(!f.exists()) f.createNewFile();
        FileWriter fileWriter=new FileWriter(f);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        for(int i=65;i<65+26;i++){
            bufferedWriter.write(i);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
        FileReader fileReader=new FileReader(f);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String str=null;
        while((str=bufferedReader.readLine())!=null){
            System.out.print(str);
        }
        bufferedReader.close();
        fileReader.close();
    }
}
