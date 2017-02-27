package org.vmysak.slitcamvideo;

import org.apache.commons.collections4.CollectionUtils;
import org.bytedeco.javacv.Frame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class SlitCamRunner {

    private final static Logger LOG = LoggerFactory.getLogger(SlitCamRunner.class);

    public static void main(String[] args) {
        Map<Integer, Frame> frames = FrameLoader.loadFrames("/root/4/3.mov");

        if (CollectionUtils.isEmpty(frames.keySet())) {
            LOG.error("Error. Loaded {} frames. Exiting" + frames.size());
            System.exit(0);
        }
    }
}
