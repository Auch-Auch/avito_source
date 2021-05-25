package a2.t.a.c.n0;

import com.voximplant.sdk.call.CallError;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.call.Call;
import com.voximplant.sdk.internal.call.PCStream;
public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ Call.e a;

    public /* synthetic */ n(Call.e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Call.e eVar = this.a;
        Call call = Call.this;
        if (call.b.w) {
            Logger.w(Call.this.b() + "CallActionReceiveVideo: receiveVideo: fail due to the call is on hold");
            eVar.c(CallError.MEDIA_IS_ON_HOLD);
        } else if (call.m.c) {
            Logger.w(Call.this.b() + "CallActionReceiveVideo: receiveVideo:  fail due to video receive is already enabled");
            eVar.c(CallError.ALREADY_IN_THIS_STATE);
        } else {
            eVar.h();
            Call call2 = Call.this;
            call2.m.c = true;
            eVar.d = true;
            call2.i.clear();
            Call call3 = Call.this;
            PCStream pCStream = call3.b;
            e2 e2Var = call3.m;
            call3.h.d();
            pCStream.b(false, e2Var);
        }
    }
}
