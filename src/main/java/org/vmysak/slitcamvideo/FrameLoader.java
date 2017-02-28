package org.vmysak.slitcamvideo;

import org.apache.commons.lang3.SerializationUtils;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;

public class FrameLoader {

    private final static Logger LOG = LoggerFactory.getLogger(FrameLoader.class);

    public static Map<Integer, Frame> loadFrames(String file) {
        Map<Integer, Frame> frames = new LinkedHashMap<>();
        FrameGrabber grabber = new FFmpegFrameGrabber(file);

        try {
            grabber.start();
            LOG.info("Loading frames. Framerate: {}", grabber.getFrameRate());
            Integer i = 0;

            while (true) {
                Frame img = grabber.grab();
                if (img != null) {
                    if (img.image != null) {
                        frames.put(i, img);
                        i++;
                    }
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
