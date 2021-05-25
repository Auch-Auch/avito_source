package com.voximplant.sdk.call;

import a2.b.a.a.a;
public class OutboundVideoStats {
    public long bytesSent;
    public int cameraFrameHeight;
    public int cameraFrameWidth;
    public String codec;
    public double encoderBitrate;
    public int fps;
    public int frameHeight;
    public int frameWidth;
    public long packetsSent;
    public double targetBitrate;
    public double timestamp;

    public String toString() {
        StringBuilder L = a.L("bytesSent:");
        L.append(this.bytesSent);
        L.append(",packetsSent:");
        L.append(this.packetsSent);
        L.append(", camera/send resolution:");
        L.append(this.cameraFrameWidth);
        L.append("x");
        L.append(this.cameraFrameHeight);
        L.append("/");
        L.append(this.frameWidth);
        L.append("x");
        L.append(this.frameHeight);
        L.append("@");
        L.append(this.fps);
        L.append(",codec:");
        L.append(this.codec);
        L.append(", target/encoder bitrate:");
        L.append(this.targetBitrate);
        L.append("/");
        L.append(this.encoderBitrate);
        return L.toString();
    }
}
