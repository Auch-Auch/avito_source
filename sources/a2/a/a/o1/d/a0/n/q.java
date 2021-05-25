package a2.a.a.o1.d.a0.n;

import a2.b.a.a.a;
import arrow.core.Option;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.util.Logs;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class q<T, R> implements Function<Option<? extends LocalMessage>, ObservableSource<? extends LocalMessage>> {
    public final /* synthetic */ LocalMessage a;

    public q(LocalMessage localMessage) {
        this.a = localMessage;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends LocalMessage> apply(Option<? extends LocalMessage> option) {
        Option<? extends LocalMessage> option2 = option;
        Intrinsics.checkNotNullParameter(option2, "option");
        LocalMessage localMessage = (LocalMessage) option2.orNull();
        if (localMessage == null) {
            return Observable.just(this.a);
        }
        StringBuilder Q = a.Q("New message ignored: \n", "\tchannelId=");
        a.m1(Q, this.a.channelId, ", \n", "\tremoteId=");
        a.m1(Q, this.a.remoteId, ", \n", "\tlocalId=");
        a.m1(Q, this.a.localId, " \n", "Conflict with local message: remoteId=");
        Q.append(localMessage.remoteId);
        Logs.debug$default("MessageSyncAgent", Q.toString(), null, 4, null);
        return Observable.empty();
    }
}
