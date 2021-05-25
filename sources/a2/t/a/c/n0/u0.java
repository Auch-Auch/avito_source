package a2.t.a.c.n0;

import com.voximplant.sdk.internal.call.ISdpCreateObserver;
public final /* synthetic */ class u0 implements Runnable {
    public final /* synthetic */ ISdpCreateObserver a;
    public final /* synthetic */ String b;

    public /* synthetic */ u0(ISdpCreateObserver iSdpCreateObserver, String str) {
        this.a = iSdpCreateObserver;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onCreateFail(this.b);
    }
}
