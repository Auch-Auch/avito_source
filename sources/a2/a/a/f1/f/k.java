package a2.a.a.f1.f;

import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.in_app_calls.service.binder.CallState;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class k<T> implements Predicate<CallState> {
    public final /* synthetic */ String a;

    public k(String str) {
        this.a = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(CallState callState) {
        CallState callState2 = callState;
        Intrinsics.checkNotNullParameter(callState2, "state");
        AppCallInfo call = callState2.getCall();
        return (Intrinsics.areEqual(call != null ? call.getCallId() : null, this.a) ^ true) || (callState2 instanceof CallState.Idle);
    }
}
