package org.evidencemaker.frame;

import org.evidencemaker.button.DocCloseButton;
import org.evidencemaker.button.DocOpenButton;
import org.evidencemaker.button.FolderCreateButton;
import org.evidencemaker.button.ImageCreateButton;

import javax.swing.*;
import java.awt.*;
import static org.evidencemaker.utility.Utility.*;

public class Frame {
    public static void frame(){
        try{
            frame=new JFrame("Evidence Maker");
            frame.setSize(250,75);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            frame.setAlwaysOnTop(true);
            Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(screenSize.width-frame.getWidth(),screenSize.height-frame.getHeight());
            FolderCreateButton.folderCreateButton();
            ImageCreateButton.imageCreateButton();
            DocOpenButton.docOpenButton();
            DocCloseButton.docCloseButton();
            frame.add(folderCreateButton);
            frame.add(imageCreateButton);
            frame.add(docOpenButton);
            frame.add(docCloseButton);

            frame.setVisible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
