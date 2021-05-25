package a7.a.b.a;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
public final class a<T, R> implements Function<MessengerConnectionHolder.State.Connected, Unit> {
    public static final a a = new a();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Unit apply(MessengerConnectionHolder.State.Connected connected) {
        Intrinsics.checkNotNullParameter(connected, "it");
        return Unit.INSTANCE;
    }
}
