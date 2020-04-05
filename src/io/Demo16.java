package io;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Demo16 {
    public static void main(String[] args) throws Exception {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif", "en");
        chooser.setFileFilter(filter);
        int dialog = chooser.showOpenDialog(null);
        if (dialog == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String fname = f.getName();
            File f1 = null;
            if (fname.endsWith(".en")) {
                f1 = new File(f.getParent(), fname.substring(0, fname.length() - 3));
            } else {
                f1 = new File(f.getParent(), fname + ".en");
            }
            encrpyt(f,f1);
            f.delete();
        }


    }

    public static void encrpyt(File befor, File afte) throws Exception{
        FileInputStream is=new FileInputStream(befor);
        FileOutputStream os=new FileOutputStream(afte);
        int len=is.available();
        byte[] buffer=new byte[len];
        while((len=is.read(buffer))>0){
            for(int i=0;i<buffer.length;i++){
                buffer[i]=(byte) (buffer[i]^0x38);
            }
            os.write(buffer);
        }
        is.close();
        os.close();
    }
}
