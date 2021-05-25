package a7.a.b.a.m;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
public final class a<T> implements Predicate<MessengerConnectionHolder.State> {
    public static final a a = new a();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(MessengerConnectionHolder.State state) {
        MessengerConnectionHolder.State state2 = state;
        Intrinsics.checkNotNullParameter(state2, "state");
        return (state2 instanceof MessengerConnectionHolder.State.Disconnected) || (state2 instanceof MessengerConnectionHolder.State.Connected);
    }
}
