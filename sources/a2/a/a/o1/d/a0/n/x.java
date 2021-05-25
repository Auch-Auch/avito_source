package a2.a.a.o1.d.a0.n;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.config.MessengerConfig;
public final class x<T, R> implements Function<MessengerConfig, Long> {
    public static final x a = new x();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Long apply(MessengerConfig messengerConfig) {
        MessengerConfig messengerConfig2 = messengerConfig;
        Intrinsics.checkNotNullParameter(messengerConfig2, "it");
        return Long.valueOf(messengerConfig2.getTimeToModifyMessage());
    }
}
