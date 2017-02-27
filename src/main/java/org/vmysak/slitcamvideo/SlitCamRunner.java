package org.vmysak.slitcamvideo;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlitCamRunner {

    private final static Logger LOG = LoggerFactory.getLogger(SlitCamRunner.class);

    public static void main(String[] args) {
        FrameGrabber grabber = new FFmpegFrameGrabber("/root/4/3.mov");

        try {
            grabber.start();

            while (true) {
                Frame img = grabber.grab();

                if (img != null) {
                    LOG.info("Processing " + img.imageDepth);
                } else {
                    throw new Exception("Empty frame");
                }
            }
        } catch (Exception e) {
            LOG.error("Stop");
        }
    }
}
