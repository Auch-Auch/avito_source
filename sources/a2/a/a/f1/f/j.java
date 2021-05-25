package a2.a.a.f1.f;

import com.avito.android.in_app_calls.CallManager;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class j<T, R> implements Function<CallManager.State, Boolean> {
    public static final j a = new j();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Boolean apply(CallManager.State state) {
        CallManager.State state2 = state;
        Intrinsics.checkNotNullParameter(state2, "state");
        return Boolean.valueOf(state2.getConnected());
    }
}
