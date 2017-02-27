package org.vmysak.slitcamvideo;

import cv.Video;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class SlitCamRunner {

    static {
        System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        Video.main(args);
//        VideoCapture capture = new VideoCapture();
//        capture.open("/root/4/3.mov");
//        Mat frame = new Mat();
//        JFrame jframe = new JFrame("MyTitle");
//        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JLabel vidpanel = new JLabel();
//        jframe.setContentPane(vidpanel);
//        jframe.setVisible(true);
//
//        while (true) {
//            if (capture.read(frame)) {
//                System.out.printf("s");
//                BufferedImage img = new BufferedImage(frame.width(), frame.height(), BufferedImage.TYPE_INT_ARGB_PRE);
//                byte[] data = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
//                frame.get(0, 0, data);
//                ImageIcon image = new ImageIcon(img);
//                vidpanel.setIcon(image);
//                vidpanel.repaint();
//
//            }
//        }
    }

}
