package com.voximplant.sdk.call;
public class VideoFlags {
    public boolean receiveVideo;
    public boolean sendVideo;

    public VideoFlags() {
        this.receiveVideo = true;
        this.sendVideo = true;
    }

    public VideoFlags(boolean z, boolean z2) {
        this.receiveVideo = z;
        this.sendVideo = z2;
    }
}
