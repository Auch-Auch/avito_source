package a2.a.a.o1.b.b.b;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.event.BlacklistInfo;
public final class o<T, R> implements Function<BlacklistInfo, Unit> {
    public static final o a = new o();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Unit apply(BlacklistInfo blacklistInfo) {
        Intrinsics.checkNotNullParameter(blacklistInfo, "it");
        return Unit.INSTANCE;
    }
}
