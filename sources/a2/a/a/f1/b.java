package a2.a.a.f1;

import com.avito.android.in_app_calls.CallManager;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Predicate<CallManager.State> {
    public static final b a = new b();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(CallManager.State state) {
        CallManager.State state2 = state;
        Intrinsics.checkNotNullParameter(state2, "state");
        return state2 instanceof CallManager.State.InCall.Ringing;
    }
}
