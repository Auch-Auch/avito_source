package a2.t.a.c.n0;

import com.voximplant.sdk.internal.call.ISdpCreateObserver;
import com.voximplant.sdk.internal.call.PCStream;
import org.webrtc.SessionDescription;
public final /* synthetic */ class s0 implements Runnable {
    public final /* synthetic */ PCStream.a a;
    public final /* synthetic */ ISdpCreateObserver b;
    public final /* synthetic */ SessionDescription c;

    public /* synthetic */ s0(PCStream.a aVar, ISdpCreateObserver iSdpCreateObserver, SessionDescription sessionDescription) {
        this.a = aVar;
        this.b = iSdpCreateObserver;
        this.c = sessionDescription;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PCStream.a aVar = this.a;
        this.b.onCreateSuccess(PCStream.a(PCStream.this, this.c));
    }
}
