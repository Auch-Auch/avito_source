package a2.a.a.o1.b.b.b;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.event.ReadChatEvent;
public final class l<T, R> implements Function<ReadChatEvent, Unit> {
    public static final l a = new l();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Unit apply(ReadChatEvent readChatEvent) {
        Intrinsics.checkNotNullParameter(readChatEvent, "it");
        return Unit.INSTANCE;
    }
}
