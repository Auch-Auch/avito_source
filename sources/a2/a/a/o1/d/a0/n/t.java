package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.ChatMessage;
public final class t<T, R> implements Function<List<? extends LocalMessage>, CompletableSource> {
    public final /* synthetic */ MessageSyncAgentImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ChatMessage c;

    public t(MessageSyncAgentImpl messageSyncAgentImpl, String str, ChatMessage chatMessage) {
        this.a = messageSyncAgentImpl;
        this.b = str;
        this.c = chatMessage;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.messenger.conversation.mvi.data.MessageRepo */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(List<? extends LocalMessage> list) {
        List<? extends LocalMessage> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "messages");
        return this.a.e.createMessages(list2).andThen(MessageSyncAgentImpl.access$syncMissingUsers(this.a, this.b, this.c.getChannelId(), list2));
    }
}
