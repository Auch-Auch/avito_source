package a2.t.a.c.n0;

import a2.t.a.c.n0.d2;
import com.voximplant.sdk.call.CallStats;
import com.voximplant.sdk.internal.call.IPCStreamListener;
import com.voximplant.sdk.internal.call.PCStream;
public final /* synthetic */ class j1 implements d2.a {
    public final /* synthetic */ PCStream a;

    public /* synthetic */ j1(PCStream pCStream) {
        this.a = pCStream;
    }

    public final void a(CallStats callStats) {
        PCStream pCStream = this.a;
        pCStream.y.execute(new Runnable(callStats) { // from class: a2.t.a.c.n0.a1
            public final /* synthetic */ CallStats b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PCStream pCStream2 = PCStream.this;
                CallStats callStats2 = this.b;
                IPCStreamListener iPCStreamListener = pCStream2.a;
                if (iPCStreamListener != null) {
                    iPCStreamListener.onCallStatisticsReady(callStats2);
                }
            }
        });
    }
}
