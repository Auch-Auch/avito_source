package a2.a.a.o1.b.b.b;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.event.ChannelsUpdatedEvent;
public final class m<T, R> implements Function<ChannelsUpdatedEvent, Unit> {
    public static final m a = new m();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Unit apply(ChannelsUpdatedEvent channelsUpdatedEvent) {
        Intrinsics.checkNotNullParameter(channelsUpdatedEvent, "it");
        return Unit.INSTANCE;
    }
}
