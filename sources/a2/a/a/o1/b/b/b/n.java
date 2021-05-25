package a2.a.a.o1.b.b.b;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.event.BlacklistRemoveEvent;
public final class n<T, R> implements Function<BlacklistRemoveEvent, Unit> {
    public static final n a = new n();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Unit apply(BlacklistRemoveEvent blacklistRemoveEvent) {
        Intrinsics.checkNotNullParameter(blacklistRemoveEvent, "it");
        return Unit.INSTANCE;
    }
}
