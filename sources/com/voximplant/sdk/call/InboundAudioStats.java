package com.voximplant.sdk.call;

import a2.b.a.a.a;
public class InboundAudioStats {
    public long bytesReceived;
    public String codec;
    public int jitterBufferMs;
    public double loss;
    public int packetsLost;
    public long packetsReceived;
    public double timestamp;

    public String toString() {
        StringBuilder L = a.L("bytesReceived:");
        L.append(this.bytesReceived);
        L.append(",packetsReceived:");
        L.append(this.packetsReceived);
        L.append(",packetsLost:");
        L.append(this.packetsLost);
        L.append(",loss:");
        L.append(this.loss);
        L.append(",codec:");
        L.append(this.codec);
        return L.toString();
    }
}
