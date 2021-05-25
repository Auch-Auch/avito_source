package a2.a.a.f1.h;

import a2.b.a.a.a;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.calls_shared.tracker.errors.CallApiRequestException;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import com.avito.android.in_app_calls.ui.CallInteractor;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ CallInteractor a;
    public final /* synthetic */ CallActivityRequest.Dial.NewCall b;

    public b(CallInteractor callInteractor, CallActivityRequest.Dial.NewCall newCall) {
        this.a = callInteractor;
        this.b = newCall;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        ErrorTracker.DefaultImpls.track$default(this.a.f, new CallApiRequestException("Can't create call", th2), null, null, 6, null);
        StringBuilder L = a.L("Failed to register outgoing call: ");
        L.append(this.b.getCallUuid());
        Logs.debug(LogTagsKt.TAG_CALL_INTERACTOR, L.toString(), th2);
    }
}
