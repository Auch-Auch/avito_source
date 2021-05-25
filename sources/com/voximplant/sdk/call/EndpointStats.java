package com.voximplant.sdk.call;

import a2.b.a.a.a;
import java.util.Map;
public class EndpointStats {
    public long audioBytesReceived;
    public int audioPacketsLost;
    public long audioPacketsReceived;
    public Map<IAudioStream, InboundAudioStats> remoteAudioStats;
    public Map<IVideoStream, InboundVideoStats> remoteVideoStats;
    public double timestamp;
    public long totalBytesReceived;
    public long totalPacketsReceived;
    public long videoBytesReceived;
    public int videoPacketsLost;
    public long videoPacketsReceived;

    public String toString() {
        StringBuilder L = a.L("Total:audioBytesReceived:");
        L.append(this.audioBytesReceived);
        L.append(",audioPacketsReceived:");
        L.append(this.audioPacketsReceived);
        L.append(",videoBytesReceived:");
        L.append(this.videoBytesReceived);
        L.append(",videoPacketsReceived:");
        L.append(this.videoPacketsReceived);
        L.append(".Active audio:");
        L.append(this.remoteAudioStats.toString());
        L.append(".Active video:");
        L.append(this.remoteVideoStats.toString());
        return L.toString();
    }
}
