package com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote;

import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.ChatMessage;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_remote/DeleteRemoteMessageInteractor;", "", "remoteId", "Lio/reactivex/Completable;", "deleteMessage", "(Ljava/lang/String;)Lio/reactivex/Completable;", "Lcom/avito/android/messenger/MessengerEntityConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/MessengerEntityConverter;", "messengerEntityConverter", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/MessengerClient;", "client", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoWriter;", "c", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoWriter;", "messageRepoWriter", "<init>", "(Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/MessengerEntityConverter;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoWriter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DeleteRemoteMessageInteractorImpl implements DeleteRemoteMessageInteractor {
    public final MessengerClient<AvitoMessengerApi> a;
    public final MessengerEntityConverter b;
    public final MessageRepoWriter c;

    public static final class a<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends ChatMessage>> {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ChatMessage> apply(AvitoMessengerApi avitoMessengerApi) {
            AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
            Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
            return avitoMessengerApi2.deleteMessage(this.a);
        }
    }

    public static final class b<T, R> implements Function<ChatMessage, CompletableSource> {
        public final /* synthetic */ DeleteRemoteMessageInteractorImpl a;

        public b(DeleteRemoteMessageInteractorImpl deleteRemoteMessageInteractorImpl) {
            this.a = deleteRemoteMessageInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(ChatMessage chatMessage) {
            ChatMessage chatMessage2 = chatMessage;
            Intrinsics.checkNotNullParameter(chatMessage2, "newMessage");
            LocalMessage convertMessage = this.a.b.convertMessage(chatMessage2);
            return this.a.c.updateMessage(convertMessage).andThen(this.a.c.deleteMessageMetaInfo(convertMessage.userId, convertMessage.channelId, convertMessage.localId));
        }
    }

    @Inject
    public DeleteRemoteMessageInteractorImpl(@NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull MessengerEntityConverter messengerEntityConverter, @NotNull MessageRepoWriter messageRepoWriter) {
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(messengerEntityConverter, "messengerEntityConverter");
        Intrinsics.checkNotNullParameter(messageRepoWriter, "messageRepoWriter");
        this.a = messengerClient;
        this.b = messengerEntityConverter;
        this.c = messageRepoWriter;
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote.DeleteRemoteMessageInteractor
    @NotNull
    public Completable deleteMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "remoteId");
        Completable flatMapCompletable = this.a.withMessengerApi().flatMap(new a(str)).flatMapCompletable(new b(this));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "client.withMessengerApi(…          )\n            }");
        return flatMapCompletable;
    }
}
