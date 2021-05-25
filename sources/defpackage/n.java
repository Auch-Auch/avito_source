package defpackage;

import com.avito.android.in_app_calls.CallManager;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: n  reason: default package */
public final class n<T> implements Predicate<CallManager.State> {
    public static final n b = new n(0);
    public static final n c = new n(1);
    public final /* synthetic */ int a;

    public n(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public final boolean test(CallManager.State state) {
        int i = this.a;
        boolean z = false;
        if (i == 0) {
            CallManager.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "it");
            if ((state2 instanceof CallManager.State.InCall) || ((state2 instanceof CallManager.State.Idle.None) && ((CallManager.State.Idle.None) state2).getCallRequest() != null)) {
                z = true;
            }
            return !z;
        } else if (i == 1) {
            CallManager.State state3 = state;
            Intrinsics.checkNotNullParameter(state3, "it");
            if ((state3 instanceof CallManager.State.InCall) || ((state3 instanceof CallManager.State.Idle.None) && ((CallManager.State.Idle.None) state3).getCallRequest() != null)) {
                return true;
            }
            return false;
        } else {
            throw null;
        }
    }
}
