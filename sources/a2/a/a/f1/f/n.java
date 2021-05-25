package a2.a.a.f1.f;

import com.avito.android.in_app_calls.service.CallReconnectHandlerImpl;
import io.reactivex.functions.Action;
public final class n implements Action {
    public final /* synthetic */ CallReconnectHandlerImpl.a a;

    public n(CallReconnectHandlerImpl.a aVar) {
        this.a = aVar;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.a.a.f.trackReconnectError("hangup");
    }
}
