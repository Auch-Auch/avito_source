package com.avito.android.messenger.channels.mvi.sync;

import com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeWriteLock;
import com.avito.android.messenger.channels.mvi.data.ChannelRepo;
import com.avito.android.messenger.channels.mvi.data.DraftRepoWriter;
import com.avito.android.messenger.channels.mvi.sync.ChannelsKey;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import t6.n.x;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B@\u0012\u0011\u0010\u001f\u001a\r\u0012\t\u0012\u00070\u001b¢\u0006\u0002\b\u001c0\u001a\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010#\u001a\u00020 \u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b$\u0010%J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J/\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R!\u0010\u001f\u001a\r\u0012\t\u0012\u00070\u001b¢\u0006\u0002\b\u001c0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChatAndDraftEraserImpl;", "Lcom/avito/android/messenger/channels/mvi/sync/ChatAndDraftEraser;", "", ChannelContext.Item.USER_ID, "channelId", "Lio/reactivex/Completable;", "deleteChatAndDraftFromEverywhere", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "deleteChatAndDraftFromDb", "interlocutorId", "itemId", "deleteChatAndAllDraftsWithInterlocutorFromDb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;", "channelRepo", "Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;", "c", "Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;", "draftRepoWriter", "Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelsKey;", "e", "Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock;", "lock", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/MessengerClient;", "client", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChatAndDraftEraserImpl implements ChatAndDraftEraser {
    public final MessengerClient<AvitoMessengerApi> a;
    public final ChannelRepo b;
    public final DraftRepoWriter c;
    public final SchedulersFactory d;
    public final RxFairCompositeWriteLock<ChannelsKey> e;

    public static final class a<T, R> implements Function<String, CompletableSource> {
        public final /* synthetic */ ChatAndDraftEraserImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(ChatAndDraftEraserImpl chatAndDraftEraserImpl, String str, String str2) {
            this.a = chatAndDraftEraserImpl;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(String str) {
            Intrinsics.checkNotNullParameter(str, "it");
            ChatAndDraftEraserImpl chatAndDraftEraserImpl = this.a;
            String str2 = this.b;
            String str3 = this.c;
            Completable andThen = chatAndDraftEraserImpl.c.deleteDraft(str2, str3).observeOn(chatAndDraftEraserImpl.d.computation()).andThen(chatAndDraftEraserImpl.b.deleteChannel(str2, str3).observeOn(chatAndDraftEraserImpl.d.computation()).subscribeOn(chatAndDraftEraserImpl.d.computation()));
            Intrinsics.checkNotNullExpressionValue(andThen, "draftRepoWriter.deleteDr…putation())\n            )");
            return andThen.observeOn(this.a.d.computation());
        }
    }

    public ChatAndDraftEraserImpl(@NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull ChannelRepo channelRepo, @NotNull DraftRepoWriter draftRepoWriter, @NotNull SchedulersFactory schedulersFactory, @NotNull RxFairCompositeWriteLock<ChannelsKey> rxFairCompositeWriteLock) {
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(channelRepo, "channelRepo");
        Intrinsics.checkNotNullParameter(draftRepoWriter, "draftRepoWriter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(rxFairCompositeWriteLock, "lock");
        this.a = messengerClient;
        this.b = channelRepo;
        this.c = draftRepoWriter;
        this.d = schedulersFactory;
        this.e = rxFairCompositeWriteLock;
    }

    public static final Completable access$doDeleteChatAndDraftFromDb(ChatAndDraftEraserImpl chatAndDraftEraserImpl, String str, String str2) {
        Objects.requireNonNull(chatAndDraftEraserImpl);
        Completable andThen = chatAndDraftEraserImpl.c.deleteDraft(str, str2).observeOn(chatAndDraftEraserImpl.d.computation()).andThen(chatAndDraftEraserImpl.b.deleteChannel(str, str2).observeOn(chatAndDraftEraserImpl.d.computation()).subscribeOn(chatAndDraftEraserImpl.d.computation()));
        Intrinsics.checkNotNullExpressionValue(andThen, "draftRepoWriter.deleteDr…putation())\n            )");
        return andThen;
    }

    @Override // com.avito.android.messenger.channels.mvi.sync.ChatAndDraftEraser
    @NotNull
    public Completable deleteChatAndAllDraftsWithInterlocutorFromDb(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Completable completable;
        a2.b.a.a.a.b1(str, ChannelContext.Item.USER_ID, str2, "interlocutorId", str3, "channelId", str4, "itemId");
        Completable observeOn = this.c.deleteAllDraftsWithInterlocutor(str, str2).observeOn(this.d.computation());
        if (!m.isBlank(str3)) {
            completable = this.b.deleteChannel(str, str3);
        } else {
            completable = this.b.deleteChannel(str, str2, str4);
        }
        Completable andThen = observeOn.andThen(completable.observeOn(this.d.computation()));
        Intrinsics.checkNotNullExpressionValue(andThen, "draftRepoWriter.deleteAl…putation())\n            )");
        RxFairCompositeWriteLock<ChannelsKey> rxFairCompositeWriteLock = this.e;
        Set<? extends ChannelsKey> of = x.setOf(ChannelsKey.All.INSTANCE);
        Scheduler computation = this.d.computation();
        Single<T> singleDefault = andThen.toSingleDefault(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(singleDefault, "this.toSingleDefault(Unit)");
        Completable ignoreElement = rxFairCompositeWriteLock.callSingle(singleDefault, "deleteChatAndAllDraftsWithInterlocutorFromDb", of, computation).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "lock.callSingle(\n       …ler\n    ).ignoreElement()");
        return ignoreElement;
    }

    @Override // com.avito.android.messenger.channels.mvi.sync.ChatAndDraftEraser
    @NotNull
    public Completable deleteChatAndDraftFromDb(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Completable andThen = this.c.deleteDraft(str, str2).observeOn(this.d.computation()).andThen(this.b.deleteChannel(str, str2).observeOn(this.d.computation()).subscribeOn(this.d.computation()));
        Intrinsics.checkNotNullExpressionValue(andThen, "draftRepoWriter.deleteDr…putation())\n            )");
        RxFairCompositeWriteLock<ChannelsKey> rxFairCompositeWriteLock = this.e;
        Set<? extends ChannelsKey> of = x.setOf(new ChannelsKey.Id(str2));
        Scheduler computation = this.d.computation();
        Single<T> singleDefault = andThen.toSingleDefault(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(singleDefault, "this.toSingleDefault(Unit)");
        Completable ignoreElement = rxFairCompositeWriteLock.callSingle(singleDefault, "deleteChatAndDraftFromDb", of, computation).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "lock.callSingle(\n       …ler\n    ).ignoreElement()");
        return ignoreElement;
    }

    @Override // com.avito.android.messenger.channels.mvi.sync.ChatAndDraftEraser
    @NotNull
    public Completable deleteChatAndDraftFromEverywhere(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Completable flatMapCompletable = this.a.clearChat(str2).observeOn(this.d.computation()).flatMapCompletable(new a(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "client.clearChat(channel…putation())\n            }");
        RxFairCompositeWriteLock<ChannelsKey> rxFairCompositeWriteLock = this.e;
        Set<? extends ChannelsKey> of = x.setOf(new ChannelsKey.Id(str2));
        Scheduler computation = this.d.computation();
        Single<T> singleDefault = flatMapCompletable.toSingleDefault(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(singleDefault, "this.toSingleDefault(Unit)");
        Completable ignoreElement = rxFairCompositeWriteLock.callSingle(singleDefault, "deleteChatAndDraftFromEverywhere", of, computation).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "lock.callSingle(\n       …ler\n    ).ignoreElement()");
        return ignoreElement;
    }
}
