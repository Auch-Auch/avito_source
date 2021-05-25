package a2.t.a.c.n0;

import com.voximplant.sdk.call.CallError;
import com.voximplant.sdk.internal.call.Call;
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ Call.a.C0326a a;

    public /* synthetic */ g(Call.a.C0326a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Call.a.this.c(CallError.TIMEOUT);
    }
}
