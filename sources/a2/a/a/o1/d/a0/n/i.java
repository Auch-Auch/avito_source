package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.ChatMessage;
import ru.avito.messenger.api.entity.ChatMessageUpdate;
import ru.avito.messenger.api.entity.event.ChatEvent;
import ru.avito.messenger.api.entity.event.ReadChatEvent;
import ru.avito.messenger.api.entity.event.ReadMessageEvent;
public final class i<T, R> implements Function<ChatEvent, CompletableSource> {
    public final /* synthetic */ MessageSyncAgentImpl a;
    public final /* synthetic */ String b;

    public i(MessageSyncAgentImpl messageSyncAgentImpl, String str) {
        this.a = messageSyncAgentImpl;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(ChatEvent chatEvent) {
        Completable completable;
        ChatEvent chatEvent2 = chatEvent;
        Intrinsics.checkNotNullParameter(chatEvent2, "event");
        if (chatEvent2 instanceof ChatMessage) {
            completable = MessageSyncAgentImpl.access$handleChatMessage(this.a, (ChatMessage) chatEvent2, this.b, true);
        } else if (chatEvent2 instanceof ChatMessageUpdate) {
            completable = MessageSyncAgentImpl.access$handleChatMessage(this.a, ((ChatMessageUpdate) chatEvent2).getMessage(), this.b, false);
        } else if (chatEvent2 instanceof ReadChatEvent) {
            completable = MessageSyncAgentImpl.access$handleReadChatEvent(this.a, (ReadChatEvent) chatEvent2, this.b);
        } else if (chatEvent2 instanceof ReadMessageEvent) {
            completable = MessageSyncAgentImpl.access$handleReadMessageEvent(this.a, (ReadMessageEvent) chatEvent2, this.b);
        } else {
            completable = Completable.complete();
            Intrinsics.checkNotNullExpressionValue(completable, "Completable.complete()");
        }
        return completable.doOnError(new h(this, chatEvent2));
    }
}
