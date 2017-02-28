package org.vmysak.slitcamvideo;

import org.apache.commons.collections4.CollectionUtils;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.bytedeco.javacpp.opencv_core.cvFlip;

public class SlitCamRunner {

    private final static Logger LOG = LoggerFactory.getLogger(SlitCamRunner.class);
    private final static OpenCVFrameConverter.ToIplImage converterToMat = new OpenCVFrameConverter.ToIplImage();

    public static void main(String[] args) {
        Map<Integer, Frame> frames = FrameLoader.loadFrames("/root/4/3.MOV");

        if (CollectionUtils.isEmpty(frames.keySet())) {
            LOG.error("Error. Loaded {} frames. Exiting", frames.size());
            System.exit(0);
        }

        List<SlitImage> converted = frames.entrySet()
                .parallelStream()
                .map(frame -> convert(frame.getKey(), frame.getValue())).collect(Collectors.toList());

        LOG.info("Conversion success. Converted {} frames", converted.size());

    }

    private static SlitImage convert(Integer index, Frame frame) {
        IplImage img = converterToMat.convert(frame);
        cvFlip(img, img, 90);
        return new SlitImage(index, img);
    }
}
