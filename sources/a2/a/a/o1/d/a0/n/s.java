package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import t6.n.d;
public final class s<T, R> implements Function<LocalMessage, SingleSource<? extends List<? extends LocalMessage>>> {
    public final /* synthetic */ MessageSyncAgentImpl a;

    public s(MessageSyncAgentImpl messageSyncAgentImpl) {
        this.a = messageSyncAgentImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends List<? extends LocalMessage>> apply(LocalMessage localMessage) {
        LocalMessage localMessage2 = localMessage;
        Intrinsics.checkNotNullParameter(localMessage2, "localMessage");
        return this.a.h.resolveMessageBodies(d.listOf(localMessage2));
    }
}
