package a2.a.a.o1.d.a0.n;

import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class l<T, R> implements Function<LocalMessage, Unit> {
    public final /* synthetic */ m a;

    public l(m mVar) {
        this.a = mVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Unit apply(LocalMessage localMessage) {
        LocalMessage localMessage2 = localMessage;
        Intrinsics.checkNotNullParameter(localMessage2, "message");
        this.a.a.k.scheduleMarkChannelAsRead(this.a.b, localMessage2.channelId, localMessage2.created);
        return Unit.INSTANCE;
    }
}
