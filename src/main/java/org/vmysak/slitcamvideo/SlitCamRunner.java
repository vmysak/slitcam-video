package org.vmysak.slitcamvideo;

import org.apache.commons.collections4.CollectionUtils;
import org.bytedeco.javacpp.opencv_core.*;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;

public class SlitCamRunner {

    private final static Logger LOG = LoggerFactory.getLogger(SlitCamRunner.class);
    private final static OpenCVFrameConverter.ToIplImage converterToMat = new OpenCVFrameConverter.ToIplImage();

    public static void main(String[] args) {
        List<SlitImage> frames = FrameLoader.loadFrames("/root/4/3.MOV");

        if (CollectionUtils.isEmpty(frames)) {
            LOG.error("Error. Loaded {} frames. Exiting", frames.size());
            System.exit(0);
        }

        LOG.info("Conversion success. Converted {} frames", frames.size());

        frames.parallelStream().forEach(SlitCamRunner::crop);

    }

    private static void crop(SlitImage img) {
//        CvRect r = new CvRect(1, 4, 4, 4);
//        cvSetImageROI(img.bytes, r);
        IplImage cropped = cvCreateImage(new CvSize(img.w, img.h), img.depth, img.channels);
//        cvCopy(img.bytes, cropped);
        cvSaveImage("/tmp/wtf/prt.jpg" + img.index, cropped);
    }
}
