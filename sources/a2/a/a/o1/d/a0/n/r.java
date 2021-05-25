package a2.a.a.o1.d.a0.n;

import arrow.core.Option;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.ChatMessage;
public final class r<T, R> implements Function<LocalMessage, ObservableSource<? extends LocalMessage>> {
    public final /* synthetic */ MessageSyncAgentImpl a;
    public final /* synthetic */ ChatMessage b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;

    public r(MessageSyncAgentImpl messageSyncAgentImpl, ChatMessage chatMessage, String str, boolean z) {
        this.a = messageSyncAgentImpl;
        this.b = chatMessage;
        this.c = str;
        this.d = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends LocalMessage> apply(LocalMessage localMessage) {
        LocalMessage localMessage2 = localMessage;
        Intrinsics.checkNotNullParameter(localMessage2, "newMessage");
        if (!Intrinsics.areEqual(this.b.getFromId(), this.c) || !this.d) {
            return Observable.just(localMessage2);
        }
        return this.a.e.getMessage(this.c, localMessage2.channelId, localMessage2.localId).first(Option.Companion.empty()).flatMapObservable(new q(localMessage2));
    }
}
