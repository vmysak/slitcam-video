package org.vmysak.slitcamvideo;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.IplImage;

public class SlitImage {

    public SlitImage(Integer index, IplImage image) {
        this.index = index;
        this.image = image;
    }

    public Integer index;
    public IplImage image;
}
