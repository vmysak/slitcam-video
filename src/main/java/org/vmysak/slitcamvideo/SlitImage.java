package org.vmysak.slitcamvideo;

public class SlitImage {

    public Integer index;
    public byte[] bytes;
    int depth;
    int channels;
    int w;
    int h;

    public SlitImage(Integer index, byte[] bytes, int depth, int channels, int w, int h) {
        this.index = index;
        this.bytes = bytes;
        this.depth = depth;
        this.channels = channels;
        this.w = w;
        this.h = h;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getChannels() {
        return channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
