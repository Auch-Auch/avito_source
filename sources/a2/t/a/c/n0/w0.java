package a2.t.a.c.n0;

import a2.b.a.a.a;
import com.voximplant.sdk.internal.call.ISdpSetObserver;
import com.voximplant.sdk.internal.call.PCStream;
import com.voximplant.sdk.internal.utils.VoxImplantUtils;
import org.webrtc.SessionDescription;
public final /* synthetic */ class w0 implements Runnable {
    public final /* synthetic */ PCStream.c a;
    public final /* synthetic */ SessionDescription b;
    public final /* synthetic */ ISdpSetObserver c;
    public final /* synthetic */ String d;

    public /* synthetic */ w0(PCStream.c cVar, SessionDescription sessionDescription, ISdpSetObserver iSdpSetObserver, String str) {
        this.a = cVar;
        this.b = sessionDescription;
        this.c = iSdpSetObserver;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PCStream.c cVar = this.a;
        SessionDescription sessionDescription = this.b;
        ISdpSetObserver iSdpSetObserver = this.c;
        String str = this.d;
        a.S0(PCStream.this, new StringBuilder(), "Local sdp is not set = ");
        VoxImplantUtils.logLargeString(sessionDescription.description);
        iSdpSetObserver.onSetFailure(str);
    }
}
