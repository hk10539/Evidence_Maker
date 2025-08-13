package org.evidencemaker.button;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.evidencemaker.utility.Utility.*;
public class DocOpenButton {
    public static void docOpenButton(){
        try{
            docOpenButton=new JButton("\uD83D\uDCC3");
            docOpenButton.addActionListener(
                    e -> {
                        try{
                            document=new XWPFDocument();

                            Robot robot=new Robot();
                            Rectangle screenshot=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                            BufferedImage screenImage=robot.createScreenCapture(screenshot);
                            Date date=new Date();
                            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
                            screenshotName="Screenshot "+simpleDateFormat.format(date)+".png";
                            File outputFile=new File(defaultFolderLocation,screenshotName);
                        ImageIO.write(screenImage,"png",outputFile);
                        JOptionPane.showMessageDialog(frame,"Successfully","OK",JOptionPane.INFORMATION_MESSAGE);

                            FileInputStream is=new FileInputStream(defaultFolderLocation+"/"+screenshotName);
                            XWPFParagraph imgParagraph=document.createParagraph();
                            XWPFRun imgRun=imgParagraph.createRun();
                            imgRun.addPicture(is,XWPFDocument.PICTURE_TYPE_JPEG,defaultFolderLocation+"/"+screenshotName, Units.toEMU(500),Units.toEMU(350));
                            is.close();
                            imgRun.addBreak(BreakType.PAGE);
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
