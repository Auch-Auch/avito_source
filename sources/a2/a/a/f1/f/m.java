package a2.a.a.f1.f;

import a2.b.a.a.a;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.in_app_calls.service.CallReconnectHandlerImpl;
import com.avito.android.in_app_calls.service.ReconnectClient;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeoutException;
public final class m<T> implements Consumer<Throwable> {
    public final /* synthetic */ CallReconnectHandlerImpl.a a;
    public final /* synthetic */ AppCallInfo b;

    public m(CallReconnectHandlerImpl.a aVar, AppCallInfo appCallInfo) {
        this.a = aVar;
        this.b = appCallInfo;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        Logs.debug("CallReconnectHandler", "Reconnect failed with error", th2);
        if (th2 instanceof TimeoutException) {
            this.a.a.f.trackReconnectError("timeout");
        } else if (th2 instanceof ReconnectClient.ReconnectRequestException) {
            CallAnalyticsTracker callAnalyticsTracker = this.a.a.f;
            StringBuilder L = a.L("error_");
            L.append(((ReconnectClient.ReconnectRequestException) th2).getCode());
            callAnalyticsTracker.trackReconnectError(L.toString());
        } else {
            this.a.a.f.trackReconnectError("error_unknown");
        }
        this.a.a.getReconnectFailures().accept(this.b.getCallId());
    }
}
