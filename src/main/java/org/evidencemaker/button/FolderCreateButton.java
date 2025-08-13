package org.evidencemaker.button;

import javax.swing.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.evidencemaker.utility.Utility.*;

public class FolderCreateButton {
    public static void folderCreateButton(){
        try{
            folderCreateButton=new JButton("\uD83D\uDCC1");
            folderCreateButton.addActionListener(
                    e -> {
                        Date date=new Date();
                        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
                        defaultFolderName="Record "+simpleDateFormat.format(date);
                        defaultFolderLocation= new File(System.getProperty("user.home")+"/Documents/"+defaultFolderName);
                        boolean created=defaultFolderLocation.mkdir();
                        if(created || defaultFolderLocation.exists()){
                            JOptionPane.showMessageDialog(frame,"Successfully","OK",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(frame,"Failed to create folder");
                        }
                    }
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
