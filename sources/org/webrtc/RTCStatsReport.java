package org.webrtc;

import a2.b.a.a.a;
import java.util.Map;
public class RTCStatsReport {
    private final Map<String, RTCStats> stats;
    private final long timestampUs;

    public RTCStatsReport(long j, Map<String, RTCStats> map) {
        this.timestampUs = j;
        this.stats = map;
    }

    @CalledByNative
    private static RTCStatsReport create(long j, Map map) {
        return new RTCStatsReport(j, map);
    }

    public Map<String, RTCStats> getStatsMap() {
        return this.stats;
    }

    public double getTimestampUs() {
        return (double) this.timestampUs;
    }

    public String toString() {
        StringBuilder L = a.L("{ timestampUs: ");
        L.append(this.timestampUs);
        L.append(", stats: [\n");
        boolean z = true;
        for (RTCStats rTCStats : this.stats.values()) {
            if (!z) {
                L.append(",\n");
            }
            L.append(rTCStats);
            z = false;
        }
        L.append(" ] }");
        return L.toString();
    }
}
