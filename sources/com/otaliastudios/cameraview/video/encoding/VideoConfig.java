package com.otaliastudios.cameraview.video.encoding;

import androidx.annotation.NonNull;
public class VideoConfig {
    public int bitRate;
    public String encoder;
    public int frameRate;
    public int height;
    public String mimeType;
    public int rotation;
    public int width;

    public <C extends VideoConfig> void copy(@NonNull C c) {
        c.width = this.width;
        c.height = this.height;
        c.bitRate = this.bitRate;
        c.frameRate = this.frameRate;
        c.rotation = this.rotation;
        c.mimeType = this.mimeType;
        c.encoder = this.encoder;
    }
}
