package a2.t.a.c.n0;

import com.voximplant.sdk.internal.call.Call;
import com.voximplant.sdk.internal.proto.WSMessage;
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ Call.d a;
    public final /* synthetic */ WSMessage b;

    public /* synthetic */ l(Call.d dVar, WSMessage wSMessage) {
        this.a = dVar;
        this.b = wSMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Call.d dVar = this.a;
        WSMessage wSMessage = this.b;
        Call call = Call.this;
        call.b.setLocalDescription(call.n, new u1(dVar, wSMessage));
    }
}
