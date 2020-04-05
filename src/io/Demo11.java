package io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class Demo11 {
    public static List<File> all=new ArrayList<File>();
    public static void main(String[] args) throws Exception {
        /**
         * 查找电脑上所有的图片和mp3
         */
        File []roots=File.listRoots();//得到根分区
        for(File root:roots){
            findJpgAndMp3(root);
        }
    }

    /**
     * 先搜索本目录下的图片和mp3,如果找到，放入list
     * 在查找目录下的子目录
     * @param path
     */
    public static void findJpgAndMp3(File path) throws  Exception{
        if(path.isDirectory()){
            System.out.println("dir" + path);
            File []allJpgAndMp3=path.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    if(name.toLowerCase().endsWith("jpg")||name.toLowerCase().endsWith("mp3"))
                        return true;
                    else
                        return false;
                }
            });
            if(null!=allJpgAndMp3&&allJpgAndMp3.length>0){
                for(File JM:allJpgAndMp3){
                    all.add(JM);
                    System.out.println("-->" + JM);
                }
            }
            //找子目录
            File []subdir=path.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if(pathname.isDirectory())
                        return true;
                    else
                        return false;
                }
            });
            if(null!=subdir&&subdir.length>0){
                for(File sub:subdir){
                    Thread.sleep(50);
                    findJpgAndMp3(sub);
                }
            }
        }


    }
}
