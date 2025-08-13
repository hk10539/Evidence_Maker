package org.evidencemaker.button;

import javax.swing.*;

import java.io.FileOutputStream;

import static org.evidencemaker.utility.Utility.*;

public class DocCloseButton {
    public static void docCloseButton(){
        try{
            docCloseButton=new JButton("\uD83D\uDCC4");
            docCloseButton.addActionListener(
                    e -> {
                        try{
                            FileOutputStream out=new FileOutputStream(defaultFolderLocation+"/sample.docx");
                            document.write(out);
                            out.close();
                            document.close();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
