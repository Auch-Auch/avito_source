package a2.t.a.c.n0;

import com.voximplant.sdk.internal.call.ISdpCreateObserver;
import com.voximplant.sdk.internal.call.PCStream;
import java.util.Objects;
import org.webrtc.SessionDescription;
public final /* synthetic */ class v0 implements Runnable {
    public final /* synthetic */ PCStream.b a;
    public final /* synthetic */ SessionDescription b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ ISdpCreateObserver d;

    public /* synthetic */ v0(PCStream.b bVar, SessionDescription sessionDescription, boolean z, ISdpCreateObserver iSdpCreateObserver) {
        this.a = bVar;
        this.b = sessionDescription;
        this.c = z;
        this.d = iSdpCreateObserver;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PCStream.b bVar = this.a;
        SessionDescription sessionDescription = this.b;
        boolean z = this.c;
        ISdpCreateObserver iSdpCreateObserver = this.d;
        if (z && !PCStream.this.f.c) {
            Objects.requireNonNull(g2.b());
            String[] split = sessionDescription.description.split("\r\n");
            int i = 0;
            while (i < split.length) {
                if (split[i].startsWith("m=video")) {
                    int i2 = i;
                    while (i < split.length) {
                        if (split[i].startsWith("a=recvonly")) {
                            split[i] = "a=inactive";
                        }
                        if (split[i].startsWith("a=sendrecv")) {
                            split[i] = "a=sendonly";
                        }
                        i2 = i;
                        i++;
                    }
                    i = i2;
                }
                i++;
            }
            StringBuilder sb = new StringBuilder();
            for (String str : split) {
                sb.append(str);
                sb.append("\r\n");
            }
            sessionDescription = new SessionDescription(sessionDescription.type, sb.toString());
        }
        iSdpCreateObserver.onCreateSuccess(PCStream.a(PCStream.this, sessionDescription));
    }
}
