package a2.t.a.c.n0;

import a2.b.a.a.a;
import com.voximplant.sdk.internal.call.ISdpSetObserver;
import com.voximplant.sdk.internal.call.PCStream;
import com.voximplant.sdk.internal.utils.VoxImplantUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.webrtc.IceCandidate;
import org.webrtc.SessionDescription;
public final /* synthetic */ class y0 implements Runnable {
    public final /* synthetic */ PCStream.d a;
    public final /* synthetic */ SessionDescription b;
    public final /* synthetic */ ISdpSetObserver c;

    public /* synthetic */ y0(PCStream.d dVar, SessionDescription sessionDescription, ISdpSetObserver iSdpSetObserver) {
        this.a = dVar;
        this.b = sessionDescription;
        this.c = iSdpSetObserver;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PCStream.d dVar = this.a;
        SessionDescription sessionDescription = this.b;
        ISdpSetObserver iSdpSetObserver = this.c;
        String str = PCStream.this.z;
        if (str != null && str.equals("server_plan_b")) {
            PCStream.this.k();
        }
        a.S0(PCStream.this, new StringBuilder(), "Remote sdp is set =");
        VoxImplantUtils.logLargeString(sessionDescription.description);
        iSdpSetObserver.onSetSuccess();
        PCStream pCStream = PCStream.this;
        CopyOnWriteArrayList<IceCandidate> copyOnWriteArrayList = pCStream.s;
        if (copyOnWriteArrayList != null) {
            Iterator<IceCandidate> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (pCStream.c.addIceCandidate(it.next())) {
                    a.S0(pCStream, new StringBuilder(), "drainCandidates: candidate is set successfully");
                } else {
                    a.R0(pCStream, new StringBuilder(), "drainCandidates: failed to set candidate");
                }
            }
            pCStream.s.clear();
        }
    }
}
