package a2.t.a.c.n0;

import a2.b.a.a.a;
import com.voximplant.sdk.call.CallStats;
import com.voximplant.sdk.call.IVideoStream;
import com.voximplant.sdk.call.OutboundVideoStats;
import com.voximplant.sdk.call.QualityIssue;
import com.voximplant.sdk.call.QualityIssueLevel;
import com.voximplant.sdk.call.VideoCodec;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.callbacks.OnCodecMismatch;
import com.voximplant.sdk.internal.callbacks.QualityCallbackController;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class f2 {
    public final String a;
    public String b;
    public volatile boolean c;
    public ArrayList<CallStats> d = new ArrayList<>();
    public final QualityCallbackController e;
    public final ExecutorService f = Executors.newSingleThreadExecutor();
    public ConcurrentHashMap<QualityIssue, QualityIssueLevel> g = new ConcurrentHashMap<>();
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public ArrayList<QualityIssueLevel> k = new ArrayList<>();
    public ArrayList<QualityIssueLevel> l = new ArrayList<>();

    public f2(String str, QualityCallbackController qualityCallbackController, VideoCodec videoCodec) {
        this.a = str;
        this.e = qualityCallbackController;
        if (videoCodec == VideoCodec.H264) {
            this.b = "H264";
        } else if (videoCodec == VideoCodec.VP8) {
            this.b = "VP8";
        } else {
            this.b = null;
        }
        ConcurrentHashMap<QualityIssue, QualityIssueLevel> concurrentHashMap = this.g;
        QualityIssue qualityIssue = QualityIssue.CODEC_MISMATCH;
        QualityIssueLevel qualityIssueLevel = QualityIssueLevel.NONE;
        concurrentHashMap.put(qualityIssue, qualityIssueLevel);
        this.g.put(QualityIssue.LOCAL_VIDEO_DEGRADATION, qualityIssueLevel);
        this.g.put(QualityIssue.HIGH_MEDIA_LATENCY, qualityIssueLevel);
        this.g.put(QualityIssue.ICE_DISCONNECTED, qualityIssueLevel);
        this.g.put(QualityIssue.LOW_BANDWIDTH, qualityIssueLevel);
        this.g.put(QualityIssue.NO_AUDIO_SIGNAL, qualityIssueLevel);
        this.g.put(QualityIssue.PACKET_LOSS, qualityIssueLevel);
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0173  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a() {
        /*
        // Method dump skipped, instructions count: 470
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.n0.f2.a():void");
    }

    public final synchronized void b(Map<IVideoStream, OutboundVideoStats> map) {
        QualityIssue qualityIssue;
        QualityIssueLevel qualityIssueLevel;
        boolean z = false;
        for (Map.Entry<IVideoStream, OutboundVideoStats> entry : map.entrySet()) {
            if (entry.getValue().codec == null) {
                if (this.h < 4 || this.g.get((qualityIssue = QualityIssue.CODEC_MISMATCH)) != (qualityIssueLevel = QualityIssueLevel.CRITICAL)) {
                    Logger.w(c() + "Send codec is null, will check next stats. " + entry);
                    this.h = this.h + 1;
                } else {
                    Logger.e(c() + "Not able to detect send codec, invoke codec mismatch issue with critical level");
                    this.g.put(qualityIssue, qualityIssueLevel);
                    this.e.invokeQualityIssueEvent(new OnCodecMismatch(qualityIssueLevel, null));
                }
                return;
            } else if (!entry.getValue().codec.equals(this.b) && !z) {
                Logger.e(c() + "Codec mismatch for video stream: " + entry.getKey().getVideoStreamId() + ", codec used: " + entry.getValue().codec + ", video codec selected: " + this.b);
                QualityCallbackController qualityCallbackController = this.e;
                QualityIssueLevel qualityIssueLevel2 = QualityIssueLevel.MAJOR;
                qualityCallbackController.invokeQualityIssueEvent(new OnCodecMismatch(qualityIssueLevel2, entry.getValue().codec));
                this.g.put(QualityIssue.CODEC_MISMATCH, qualityIssueLevel2);
                this.h = 0;
                z = true;
            }
        }
    }

    public final String c() {
        return a.t(a.L("QualityIssueAnalyzer["), this.a, "] ");
    }
}
