package org.vmysak.slitcamvideo;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class FrameLoader {

    private final static Logger LOG = LoggerFactory.getLogger(FrameLoader.class);

    public static Map<Integer, Frame> loadFrames(String file) {
        FrameGrabber grabber = new FFmpegFrameGrabber(file);
        Map<Integer, Frame> frames = new LinkedHashMap<>();

        try {
            grabber.start();
            LOG.info("Loading frames. Framerate: {}", grabber.getFrameRate());
            Integer i = 0;

            while (true) {
                Frame img = grabber.grab();
                if (img != null) {
                    frames.put(i, img);
                    i++;
                } else {
                    throw new Exception("Empty frame");
                }
            }

        } catch (Exception e) {
            LOG.info("Loaded {} frames", frames.size());
        }
        return frames;
    }
}
