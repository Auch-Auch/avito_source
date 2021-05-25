package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions;

import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.RawJson;
import com.avito.android.remote.model.RawJsonKt;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsInteractor;", "", "methodName", "Lcom/avito/android/remote/model/RawJson;", "params", "Lio/reactivex/Single;", "callApiMethod", "(Ljava/lang/String;Lcom/avito/android/remote/model/RawJson;)Lio/reactivex/Single;", ChannelContext.Item.USER_ID, "channelId", "reactionText", "Lio/reactivex/Completable;", "sendReactionAndDeleteContextActions", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/MessengerClient;", "client", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractor;", "c", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractor;", "sendMessageInteractor", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "channelSyncAgent", "<init>", "(Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractor;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ContextActionsInteractorImpl implements ContextActionsInteractor {
    public final MessengerClient<AvitoMessengerApi> a;
    public final ChannelSyncAgent b;
    public final SendMessageInteractor c;

    public static final class a<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends RawJson>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ RawJson b;

        public a(String str, RawJson rawJson) {
            this.a = str;
            this.b = rawJson;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends RawJson> apply(AvitoMessengerApi avitoMessengerApi) {
            AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
            Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
            return avitoMessengerApi2.callMethod(this.a, RawJsonKt.orEmpty(this.b));
        }
    }

    public static final class b<T, R> implements Function<LocalMessage, CompletableSource> {
        public final /* synthetic */ ContextActionsInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(ContextActionsInteractorImpl contextActionsInteractorImpl, String str, String str2) {
            this.a = contextActionsInteractorImpl;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(LocalMessage localMessage) {
            Intrinsics.checkNotNullParameter(localMessage, "it");
            return this.a.b.deleteContextActions(this.b, this.c);
        }
    }

    @Inject
    public ContextActionsInteractorImpl(@NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull ChannelSyncAgent channelSyncAgent, @NotNull SendMessageInteractor sendMessageInteractor) {
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(channelSyncAgent, "channelSyncAgent");
        Intrinsics.checkNotNullParameter(sendMessageInteractor, "sendMessageInteractor");
        this.a = messengerClient;
        this.b = channelSyncAgent;
        this.c = sendMessageInteractor;
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsInteractor
    @NotNull
    public Single<RawJson> callApiMethod(@NotNull String str, @Nullable RawJson rawJson) {
        Intrinsics.checkNotNullParameter(str, "methodName");
        Single<R> flatMap = this.a.withMessengerApi().flatMap(new a(str, rawJson));
        Intrinsics.checkNotNullExpressionValue(flatMap, "client.withMessengerApi(…          )\n            }");
        return flatMap;
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsInteractor
    @NotNull
    public Completable sendReactionAndDeleteContextActions(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, ChannelContext.Item.USER_ID, str2, "channelId", str3, "reactionText");
        Completable flatMapCompletable = this.c.createReactionMessage(str, str3).flatMapCompletable(new b(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "sendMessageInteractor.cr… channelId)\n            }");
        return flatMapCompletable;
    }
}
