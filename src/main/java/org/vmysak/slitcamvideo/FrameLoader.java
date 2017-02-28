package org.vmysak.slitcamvideo;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

import static org.bytedeco.javacpp.opencv_core.cvFlip;

public class FrameLoader {

    private final static Logger LOG = LoggerFactory.getLogger(FrameLoader.class);
    private final static OpenCVFrameConverter.ToIplImage converterToMat = new OpenCVFrameConverter.ToIplImage();

    public static List<SlitImage> loadFrames(String file) {
        List<SlitImage> frames = new LinkedList<>();
        FileInputStream is;
        FrameGrabber grabber;
        try {
            is = new FileInputStream(file);
            grabber = new FFmpegFrameGrabber(file);
        } catch (FileNotFoundException e) {
            LOG.error("Can't open file");
            return frames;
        }

        try {
            grabber.start();
            LOG.info("Loading frames. Framerate: {}", grabber.getFrameRate());
            Integer i = 0;
            Frame img;

            while (true) {
                img = grabber.grabFrame();
                if (img != null) {
                    if (img.image != null) {
                        frames.add(convert(i, img));
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

    private static SlitImage convert(Integer index, Frame frame) {
        opencv_core.IplImage img = converterToMat.convert(frame);
        cvFlip(img, img, 90);
        ByteBuffer buffer = img.asByteBuffer();
        byte[] bytes = new byte[buffer.capacity()];
        buffer.get(bytes, 0, bytes.length);
        return new SlitImage(index, bytes, frame.imageDepth, frame.imageChannels, frame.imageWidth, frame.imageHeight);
    }
}
