package a7.a.b.a.m;

import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
public final class b<T, R> implements Function<MessengerConnectionHolder.State, Pair<? extends Class<MessengerConnectionHolder.State>, ? extends Boolean>> {
    public static final b a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Pair<? extends Class<MessengerConnectionHolder.State>, ? extends Boolean> apply(MessengerConnectionHolder.State state) {
        MessengerConnectionHolder.State state2 = state;
        Intrinsics.checkNotNullParameter(state2, "state");
        return TuplesKt.to(state2.getClass(), Boolean.valueOf(state2.isAwaitingConnection()));
    }
}
