package org.evidencemaker.utility;


import org.apache.poi.xwpf.usermodel.XWPFDocument;

import javax.swing.*;
import java.io.File;

public class Utility {
       public static JFrame frame;
       public static JButton folderCreateButton;
       public static JButton imageCreateButton;
       public static JButton docOpenButton;
       public static JButton docCloseButton;

       public static String defaultFolderName=null;
       public static File defaultFolderLocation=null;
       public static String screenshotName=null;

       public static XWPFDocument document;
}
