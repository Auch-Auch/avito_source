package a2.t.a.c.n0;

import com.avito.android.remote.model.messenger.message.MessageBody;
import com.voximplant.sdk.call.EndpointStats;
import com.voximplant.sdk.call.OutboundAudioStats;
import com.voximplant.sdk.call.OutboundVideoStats;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.webrtc.RTCStats;
public class d2 {
    public final ExecutorService a = Executors.newSingleThreadExecutor();
    public HashMap<r1, OutboundAudioStats> b = new HashMap<>();
    public HashMap<h2, OutboundVideoStats> c = new HashMap<>();
    public HashMap<a2, EndpointStats> d = new HashMap<>();

    public interface a {
    }

    /* JADX WARNING: Removed duplicated region for block: B:267:0x05f9  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x061c  */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x078d  */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x07bc  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x0621 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x07c1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(org.webrtc.RTCStatsReport r21, java.util.List<a2.t.a.c.n0.r1> r22, java.util.List<a2.t.a.c.n0.h2> r23, java.util.List<a2.t.a.c.n0.a2> r24, a2.t.a.c.n0.d2.a r25) {
        /*
        // Method dump skipped, instructions count: 2597
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.n0.d2.a(org.webrtc.RTCStatsReport, java.util.List, java.util.List, java.util.List, a2.t.a.c.n0.d2$a):void");
    }

    public final RTCStats b(List<RTCStats> list, String str) {
        for (RTCStats rTCStats : list) {
            if (rTCStats.getId().equals(str)) {
                return rTCStats;
            }
        }
        return null;
    }

    public final RTCStats c(List<RTCStats> list, String str, String str2) {
        for (RTCStats rTCStats : list) {
            String str3 = (String) rTCStats.getMembers().get(str);
            if (str3 != null && str3.equals(str2)) {
                return rTCStats;
            }
        }
        return null;
    }

    public final String d(RTCStats rTCStats) {
        String str;
        if (rTCStats == null || !rTCStats.getMembers().containsKey(MessageBody.File.MIME_TYPE) || (str = (String) rTCStats.getMembers().get(MessageBody.File.MIME_TYPE)) == null) {
            return null;
        }
        return str.substring(str.indexOf("/") + 1);
    }
}
