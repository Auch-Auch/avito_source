package a2.a.a.o1.g;

import a2.b.a.a.a;
import com.avito.android.remote.model.messenger.UnreadMessagesCounter;
import com.avito.android.util.Logs;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.ChannelsCounters;
public final class b<T, R> implements Function<ChannelsCounters, UnreadMessagesCounter> {
    public final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public UnreadMessagesCounter apply(ChannelsCounters channelsCounters) {
        ChannelsCounters channelsCounters2 = channelsCounters;
        Intrinsics.checkNotNullParameter(channelsCounters2, "channelsCounters");
        String str = this.a.b;
        StringBuilder I = a.I('[');
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        I.append(currentThread.getName());
        I.append("] received counter = ");
        I.append(channelsCounters2.getUnreadChannels());
        Logs.verbose$default(str, I.toString(), null, 4, null);
        return new UnreadMessagesCounter(channelsCounters2.getUnreadChannels(), channelsCounters2.getUnreadChannels());
    }
}
