package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import java.util.concurrent.Callable;
import ru.avito.messenger.api.entity.ChatMessage;
public final class o<V> implements Callable<LocalMessage> {
    public final /* synthetic */ MessageSyncAgentImpl a;
    public final /* synthetic */ ChatMessage b;

    public o(MessageSyncAgentImpl messageSyncAgentImpl, ChatMessage chatMessage) {
        this.a = messageSyncAgentImpl;
        this.b = chatMessage;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public LocalMessage call() {
        return this.a.i.convertMessage(this.b);
    }
}
