package com.facebook.imagepipeline.transcoder;
public class ImageTranscodeResult {
    public final int a;

    public ImageTranscodeResult(int i) {
        this.a = i;
    }

    public int getTranscodeStatus() {
        return this.a;
    }

    public String toString() {
        return String.format(null, "Status: %d", Integer.valueOf(this.a));
    }
}
