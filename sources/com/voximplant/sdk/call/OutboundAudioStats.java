package com.voximplant.sdk.call;

import a2.b.a.a.a;
public class OutboundAudioStats {
    public double audioLevel;
    public long bytesSent;
    public String codec;
    public long packetsSent;
    public double timestamp;

    public String toString() {
        StringBuilder L = a.L("bytesSent:");
        L.append(this.bytesSent);
        L.append(",packetsSent:");
        L.append(this.packetsSent);
        L.append(",codec:");
        L.append(this.codec);
        L.append(",level:");
        L.append(this.audioLevel);
        return L.toString();
    }
}
