package org.evidencemaker.button;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.evidencemaker.utility.Utility.*;

public class ImageCreateButton {
    public static void imageCreateButton(){
        try{
            imageCreateButton=new JButton("\uD83D\uDCC2");
            imageCreateButton.addActionListener(
                    e -> {
                        try {
                            Robot robot=new Robot();
                            Rectangle screenshot=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                            BufferedImage screenImage=robot.createScreenCapture(screenshot);
                            Date date=new Date();
                            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
                            screenshotName="Screenshot "+simpleDateFormat.format(date);
                            File outputFile=new File(defaultFolderLocation,screenshotName);
                            ImageIO.write(screenImage,"png",outputFile);
                        } catch (AWTException ex) {
                            throw new RuntimeException(ex);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
