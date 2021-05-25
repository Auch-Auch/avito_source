package a2.a.a.f1.f;

import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.in_app_calls.service.binder.CallState;
import io.reactivex.rxjava3.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Predicate<CallState> {
    public final /* synthetic */ String a;

    public d(String str) {
        this.a = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(CallState callState) {
        AppCallInfo call = callState.getCall();
        return !Intrinsics.areEqual(call != null ? call.getCallId() : null, this.a);
    }
}
