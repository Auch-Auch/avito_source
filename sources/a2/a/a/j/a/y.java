package a2.a.a.j.a;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.MessengerState;
public final class y<T, R> implements Function<MessengerState, Boolean> {
    public static final y a = new y();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Boolean apply(MessengerState messengerState) {
        MessengerState messengerState2 = messengerState;
        Intrinsics.checkNotNullParameter(messengerState2, "it");
        return Boolean.valueOf(messengerState2 instanceof MessengerState.Connected);
    }
}
