package a2.t.a.c.n0;

import com.voximplant.sdk.call.ICallCompletionHandler;
import com.voximplant.sdk.internal.call.Call;
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ Call.a a;

    public /* synthetic */ h(Call.a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ICallCompletionHandler iCallCompletionHandler = this.a.b;
        if (iCallCompletionHandler != null) {
            iCallCompletionHandler.onComplete();
        }
    }
}
