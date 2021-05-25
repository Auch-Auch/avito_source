package defpackage;

import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.calls_shared.tracker.errors.CallApiRequestException;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import com.avito.android.in_app_calls.ui.CallInteractor;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: p2  reason: default package */
public final class p2<T> implements Consumer<Throwable> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public p2(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Throwable th2 = th;
            ErrorTracker.DefaultImpls.track$default(((CallInteractor) this.b).f, new CallApiRequestException("Can't get call contacts", th2), null, null, 6, null);
            Logs.debug(LogTagsKt.TAG_CALL_INTERACTOR, "Failed to get call contacts by previous call: " + ((CallActivityRequest.Dial.ByPreviousCall) this.c).getPrevCallUuid(), th2);
        } else if (i == 1) {
            Throwable th3 = th;
            ErrorTracker.DefaultImpls.track$default(((CallInteractor) this.b).f, new CallApiRequestException("Can't get call info", th3), null, null, 6, null);
            Logs.debug(LogTagsKt.TAG_CALL_INTERACTOR, "Failed to get call info for previous call: " + ((String) this.c), th3);
        } else {
            throw null;
        }
    }
}
