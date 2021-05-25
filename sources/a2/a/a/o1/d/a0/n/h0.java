package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Timed;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
public final class h0<T, R> implements Function<Timed<Set<? extends String>>, MissingUsersSyncAgentImpl.ThrottleState> {
    public static final h0 a = new h0();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public MissingUsersSyncAgentImpl.ThrottleState apply(Timed<Set<? extends String>> timed) {
        Timed<Set<? extends String>> timed2 = timed;
        Intrinsics.checkNotNullParameter(timed2, "idsToRequestWithTime");
        long time = timed2.time();
        Set<? extends String> value = timed2.value();
        Intrinsics.checkNotNullExpressionValue(value, "idsToRequestWithTime.value()");
        Set<? extends String> value2 = timed2.value();
        Intrinsics.checkNotNullExpressionValue(value2, "idsToRequestWithTime.value()");
        return new MissingUsersSyncAgentImpl.ThrottleState(time, value, value2);
    }
}
