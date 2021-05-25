package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class j0<T> implements Predicate<MissingUsersSyncAgentImpl.ThrottleState> {
    public static final j0 a = new j0();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(MissingUsersSyncAgentImpl.ThrottleState throttleState) {
        MissingUsersSyncAgentImpl.ThrottleState throttleState2 = throttleState;
        Intrinsics.checkNotNullParameter(throttleState2, "it");
        return !throttleState2.getIdsToRequest().isEmpty();
    }
}
