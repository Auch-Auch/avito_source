package a2.a.a.f1.f;

import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.in_app_calls.service.CallReconnectHandlerImpl;
import com.avito.android.util.Logs;
import io.reactivex.functions.Action;
public final class o implements Action {
    public final /* synthetic */ CallReconnectHandlerImpl.a a;
    public final /* synthetic */ AppCallInfo b;

    public o(CallReconnectHandlerImpl.a aVar, AppCallInfo appCallInfo) {
        this.a = aVar;
        this.b = appCallInfo;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Logs.debug$default("CallReconnectHandler", "Reconnect timed out", null, 4, null);
        this.a.a.f.trackReconnectError("timeout");
        this.a.a.getReconnectFailures().accept(this.b.getCallId());
    }
}
