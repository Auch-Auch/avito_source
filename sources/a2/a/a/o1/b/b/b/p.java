package a2.a.a.o1.b.b.b;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.event.ChatClearEvent;
public final class p<T, R> implements Function<ChatClearEvent, Unit> {
    public static final p a = new p();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Unit apply(ChatClearEvent chatClearEvent) {
        Intrinsics.checkNotNullParameter(chatClearEvent, "it");
        return Unit.INSTANCE;
    }
}
