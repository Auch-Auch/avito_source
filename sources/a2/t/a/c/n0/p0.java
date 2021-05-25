package a2.t.a.c.n0;

import com.voximplant.sdk.internal.call.ISdpSetObserver;
public final /* synthetic */ class p0 implements Runnable {
    public final /* synthetic */ ISdpSetObserver a;

    public /* synthetic */ p0(ISdpSetObserver iSdpSetObserver) {
        this.a = iSdpSetObserver;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onSetSuccess();
    }
}
