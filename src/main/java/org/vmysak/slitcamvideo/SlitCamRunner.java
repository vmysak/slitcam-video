package org.vmysak.slitcamvideo;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;

import javax.swing.*;

public class SlitCamRunner {

    public static void main(String[] args) {
        CanvasFrame canvas = new CanvasFrame("VideoCanvas");
        canvas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        FrameGrabber grabber = new FFmpegFrameGrabber("/root/4/3.mov");

        try {
            grabber.start();

            while (true) {
                Frame img = grabber.grab();
                canvas.setCanvasSize(grabber.getImageWidth(), grabber.getImageHeight());

                if (img != null) {
                    canvas.showImage(img);
                } else {
                    throw new Exception("Empty frame");
                }
            }
        } catch (Exception e) {
            System.out.println("Stop");
        }
    }
}
