package com.avito.android.messenger.channels.mvi.sync;

import a2.b.a.a.a;
import a2.g.r.g;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeWriteLock;
import com.avito.android.messenger.channels.mvi.data.ChannelRepo;
import com.avito.android.messenger.channels.mvi.sync.ChannelsKey;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.InputState;
import com.avito.android.remote.model.messenger.ReadOnlyState;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.remote.model.messenger.deal_action.DealAction;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.ChatMessage;
import ru.avito.messenger.api.entity.ChatMessageUpdate;
import ru.avito.messenger.api.entity.body.MessageBody;
import ru.avito.messenger.api.entity.context.ChannelContextActions;
import ru.avito.messenger.api.entity.context.ChannelDealAction;
import ru.avito.messenger.api.entity.event.BlacklistInfo;
import ru.avito.messenger.api.entity.event.ChannelUpdate;
import ru.avito.messenger.api.entity.event.ChannelsUpdatedEvent;
import ru.avito.messenger.api.entity.event.ChatClearEvent;
import ru.avito.messenger.api.entity.event.ReadChatEvent;
import t6.n.e;
import t6.n.j;
import t6.n.x;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\r\u001a\u00020\n\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010.\u001a\u00020+¢\u0006\u0004\b1\u00102J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010%¨\u00063"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelsBackendNotificationsHandlerImpl;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelsBackendNotificationsHandler;", "", "subscribeToUserIdAndBackendNotifications", "()V", "Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelsKey;", "j", "Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock;", "lock", "Lcom/avito/android/server_time/TimeSource;", "i", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/messenger/MessengerEntityConverter;", "e", "Lcom/avito/android/messenger/MessengerEntityConverter;", "messengerEntityConverter", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;", "f", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;", "channelRepo", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/account/AccountStateProvider;", "c", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "d", "Lru/avito/messenger/MessengerClient;", "client", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/disposables/CompositeDisposable;", "bgNotificationDisposables", "Lcom/avito/android/Features;", g.a, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/messenger/channels/mvi/sync/ChatAndDraftEraser;", "k", "Lcom/avito/android/messenger/channels/mvi/sync/ChatAndDraftEraser;", "chatAndDraftEraser", AuthSource.SEND_ABUSE, "userIdDisposable", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/MessengerEntityConverter;Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock;Lcom/avito/android/messenger/channels/mvi/sync/ChatAndDraftEraser;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsBackendNotificationsHandlerImpl implements ChannelsBackendNotificationsHandler {
    public final CompositeDisposable a = new CompositeDisposable();
    public final CompositeDisposable b = new CompositeDisposable();
    public final AccountStateProvider c;
    public final MessengerClient<AvitoMessengerApi> d;
    public final MessengerEntityConverter e;
    public final ChannelRepo f;
    public final Features g;
    public final SchedulersFactory h;
    public final TimeSource i;
    public final RxFairCompositeWriteLock<ChannelsKey> j;
    public final ChatAndDraftEraser k;

    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ ChannelsBackendNotificationsHandlerImpl a;

        public a(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl) {
            this.a = channelsBackendNotificationsHandlerImpl;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            this.a.b.clear();
            Intrinsics.checkNotNullExpressionValue(str2, "newUserId");
            if (!m.isBlank(str2)) {
                ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl = this.a;
                CompositeDisposable compositeDisposable = channelsBackendNotificationsHandlerImpl.b;
                Completable M1 = a2.b.a.a.a.M1(channelsBackendNotificationsHandlerImpl, a2.b.a.a.a.Q1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.observeChatEvents(ReadChatEvent.class)).concatMapCompletable(new ChannelsBackendNotificationsHandlerImpl$subscribeToUserIdAndBackendNotifications$1$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$1(str2, channelsBackendNotificationsHandlerImpl)), "client.observeChatEvents…schedulers.computation())");
                String simpleName = ReadChatEvent.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "T::class.java.simpleName");
                ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1 channelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1 = ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1.INSTANCE;
                Disposable subscribe = M1.subscribe(channelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1, new ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$2(simpleName));
                Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(\n            {…)\n            }\n        )");
                DisposableKt.addTo(subscribe, compositeDisposable);
                CompositeDisposable compositeDisposable2 = channelsBackendNotificationsHandlerImpl.b;
                Completable M12 = a2.b.a.a.a.M1(channelsBackendNotificationsHandlerImpl, a2.b.a.a.a.Q1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.observeChatEvents(ChatClearEvent.class)).concatMapCompletable(new ChannelsBackendNotificationsHandlerImpl$subscribeToUserIdAndBackendNotifications$1$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$2(str2, channelsBackendNotificationsHandlerImpl)), "client.observeChatEvents…schedulers.computation())");
                String simpleName2 = ChatClearEvent.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName2, "T::class.java.simpleName");
                Disposable subscribe2 = M12.subscribe(channelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1, new ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$2(simpleName2));
                Intrinsics.checkNotNullExpressionValue(subscribe2, "subscribe(\n            {…)\n            }\n        )");
                DisposableKt.addTo(subscribe2, compositeDisposable2);
                CompositeDisposable compositeDisposable3 = channelsBackendNotificationsHandlerImpl.b;
                Completable M13 = a2.b.a.a.a.M1(channelsBackendNotificationsHandlerImpl, a2.b.a.a.a.Q1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.observeChatEvents(BlacklistInfo.class)).concatMapCompletable(new ChannelsBackendNotificationsHandlerImpl$subscribeToUserIdAndBackendNotifications$1$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$3(str2, channelsBackendNotificationsHandlerImpl)), "client.observeChatEvents…schedulers.computation())");
                String simpleName3 = BlacklistInfo.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName3, "T::class.java.simpleName");
                Disposable subscribe3 = M13.subscribe(channelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1, new ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$2(simpleName3));
                Intrinsics.checkNotNullExpressionValue(subscribe3, "subscribe(\n            {…)\n            }\n        )");
                DisposableKt.addTo(subscribe3, compositeDisposable3);
                CompositeDisposable compositeDisposable4 = channelsBackendNotificationsHandlerImpl.b;
                Completable M14 = a2.b.a.a.a.M1(channelsBackendNotificationsHandlerImpl, a2.b.a.a.a.Q1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.observeChatEvents(ChatMessage.class)).concatMapCompletable(new ChannelsBackendNotificationsHandlerImpl$subscribeToUserIdAndBackendNotifications$1$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$4(str2, channelsBackendNotificationsHandlerImpl)), "client.observeChatEvents…schedulers.computation())");
                String simpleName4 = ChatMessage.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName4, "T::class.java.simpleName");
                Disposable subscribe4 = M14.subscribe(channelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1, new ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$2(simpleName4));
                Intrinsics.checkNotNullExpressionValue(subscribe4, "subscribe(\n            {…)\n            }\n        )");
                DisposableKt.addTo(subscribe4, compositeDisposable4);
                CompositeDisposable compositeDisposable5 = channelsBackendNotificationsHandlerImpl.b;
                Completable M15 = a2.b.a.a.a.M1(channelsBackendNotificationsHandlerImpl, a2.b.a.a.a.Q1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.observeChatEvents(ChatMessageUpdate.class)).concatMapCompletable(new ChannelsBackendNotificationsHandlerImpl$subscribeToUserIdAndBackendNotifications$1$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5(str2, channelsBackendNotificationsHandlerImpl)), "client.observeChatEvents…schedulers.computation())");
                String simpleName5 = ChatMessageUpdate.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName5, "T::class.java.simpleName");
                Disposable subscribe5 = M15.subscribe(channelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1, new ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$2(simpleName5));
                Intrinsics.checkNotNullExpressionValue(subscribe5, "subscribe(\n            {…)\n            }\n        )");
                DisposableKt.addTo(subscribe5, compositeDisposable5);
                CompositeDisposable compositeDisposable6 = channelsBackendNotificationsHandlerImpl.b;
                Completable M16 = a2.b.a.a.a.M1(channelsBackendNotificationsHandlerImpl, a2.b.a.a.a.Q1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.observeChatEvents(ChannelsUpdatedEvent.class)).concatMapCompletable(new ChannelsBackendNotificationsHandlerImpl$subscribeToUserIdAndBackendNotifications$1$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6(str2, channelsBackendNotificationsHandlerImpl)), "client.observeChatEvents…schedulers.computation())");
                String simpleName6 = ChannelsUpdatedEvent.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName6, "T::class.java.simpleName");
                Disposable subscribe6 = M16.subscribe(channelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1, new ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$2(simpleName6));
                Intrinsics.checkNotNullExpressionValue(subscribe6, "subscribe(\n            {…)\n            }\n        )");
                DisposableKt.addTo(subscribe6, compositeDisposable6);
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("ChannelsBackendNotificationsHandler", "accountStateProvider.userId() subscription encountered an error", th);
        }
    }

    public ChannelsBackendNotificationsHandlerImpl(@NotNull AccountStateProvider accountStateProvider, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull MessengerEntityConverter messengerEntityConverter, @NotNull ChannelRepo channelRepo, @NotNull Features features, @NotNull SchedulersFactory schedulersFactory, @NotNull TimeSource timeSource, @NotNull RxFairCompositeWriteLock<ChannelsKey> rxFairCompositeWriteLock, @NotNull ChatAndDraftEraser chatAndDraftEraser) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(messengerEntityConverter, "messengerEntityConverter");
        Intrinsics.checkNotNullParameter(channelRepo, "channelRepo");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(rxFairCompositeWriteLock, "lock");
        Intrinsics.checkNotNullParameter(chatAndDraftEraser, "chatAndDraftEraser");
        this.c = accountStateProvider;
        this.d = messengerClient;
        this.e = messengerEntityConverter;
        this.f = channelRepo;
        this.g = features;
        this.h = schedulersFactory;
        this.i = timeSource;
        this.j = rxFairCompositeWriteLock;
        this.k = chatAndDraftEraser;
    }

    public static final Channel access$applyUpdateIfItExists(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, Channel channel, ChannelsUpdatedEvent channelsUpdatedEvent) {
        ReadOnlyState readOnlyState;
        SortedSet sortedSet;
        InputState inputState;
        PlatformActions platformActions;
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        ChannelUpdate channelUpdate = channelsUpdatedEvent.channels.get(channel.getChannelId());
        PlatformActions platformActions2 = null;
        if (channelUpdate == null) {
            return null;
        }
        MessengerEntityConverter messengerEntityConverter = channelsBackendNotificationsHandlerImpl.e;
        boolean booleanValue = channelsBackendNotificationsHandlerImpl.g.getMessengerContextActionsInChannelUpdates().invoke().booleanValue();
        Long l = channelUpdate.updated;
        long max = l != null ? Math.max(l.longValue(), channel.getUpdated()) : channel.getUpdated();
        ru.avito.messenger.api.entity.ReadOnlyState readOnlyState2 = channelUpdate.readOnlyState;
        if (readOnlyState2 == null || (readOnlyState = messengerEntityConverter.convertChannelReadOnlyState(readOnlyState2)) == null) {
            readOnlyState = channel.getReadOnlyState();
        }
        Boolean bool = channelUpdate.isDeleted;
        boolean booleanValue2 = bool != null ? bool.booleanValue() : channel.isDeleted();
        Boolean bool2 = channelUpdate.isRead;
        boolean booleanValue3 = bool2 != null ? bool2.booleanValue() : channel.isRead();
        Boolean bool3 = channelUpdate.isSpam;
        boolean booleanValue4 = bool3 != null ? bool3.booleanValue() : channel.isSpam();
        Boolean bool4 = channelUpdate.isAnswered;
        boolean booleanValue5 = bool4 != null ? bool4.booleanValue() : channel.isAnswered();
        List<String> list = channelUpdate.tags;
        if (list == null || (sortedSet = j.toSortedSet(list)) == null) {
            sortedSet = j.toSortedSet(channel.getTags());
            List<String> list2 = channelUpdate.addedTags;
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            }
            sortedSet.addAll(list2);
            List<String> list3 = channelUpdate.removedTags;
            if (list3 == null) {
                list3 = CollectionsKt__CollectionsKt.emptyList();
            }
            sortedSet.removeAll(list3);
        }
        ChannelDealAction channelDealAction = channelUpdate.dealAction;
        if (!(channelDealAction instanceof DealAction)) {
            channelDealAction = null;
        }
        DealAction dealAction = (DealAction) channelDealAction;
        if (dealAction == null) {
            dealAction = channel.getDealAction();
        }
        String suspectMessageId = channel.getSuspectMessageId();
        ChannelUpdate.Suspect suspect = channelUpdate.suspect;
        if (suspect != null) {
            suspectMessageId = suspect.messageId;
        }
        ru.avito.messenger.api.entity.InputState inputState2 = channelUpdate.inputState;
        if (inputState2 == null || (inputState = messengerEntityConverter.convertChannelInputState(inputState2)) == null) {
            inputState = channel.getInputState();
        }
        if (booleanValue) {
            platformActions = channel.getContextActions();
            ChannelContextActions channelContextActions = channelUpdate.contextActions;
            if (channelContextActions != null) {
                if (!(channelContextActions instanceof PlatformActions)) {
                    channelContextActions = null;
                }
                PlatformActions platformActions3 = (PlatformActions) channelContextActions;
                if (platformActions3 != null) {
                    Long version = platformActions3.getVersion();
                    Long version2 = platformActions != null ? platformActions.getVersion() : null;
                    if (version == null || version2 == null || version.longValue() > version2.longValue()) {
                        platformActions2 = platformActions3;
                    }
                    if (platformActions2 != null) {
                        platformActions = platformActions2;
                    }
                }
            }
        } else {
            platformActions = channel.getContextActions();
        }
        return Channel.copy$default(channel, null, null, null, null, 0, max, null, readOnlyState, booleanValue2, booleanValue3, booleanValue4, booleanValue5, sortedSet, platformActions, dealAction, null, suspectMessageId, null, inputState, 163935, null);
    }

    public static final Single access$createUpdatedChannels(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, ChannelsUpdatedEvent channelsUpdatedEvent, List list) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        Set<String> mutableSet = CollectionsKt___CollectionsKt.toMutableSet(channelsUpdatedEvent.channels.keySet());
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Channel channel = (Channel) it.next();
            mutableSet.remove(channel.getChannelId());
            Channel access$applyUpdateIfItExists = access$applyUpdateIfItExists(channelsBackendNotificationsHandlerImpl, channel, channelsUpdatedEvent);
            if (access$applyUpdateIfItExists != null) {
                arrayList.add(access$applyUpdateIfItExists);
            }
        }
        if (!(!mutableSet.isEmpty())) {
            return Singles.toSingle(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(mutableSet, 10));
        for (String str : mutableSet) {
            Single map = a2.b.a.a.a.U1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.getChannel(str)).map(new ChannelsBackendNotificationsHandlerKt$sam$i$io_reactivex_functions_Function$0(new ChannelsBackendNotificationsHandlerImpl$getChannelFromServer$1(channelsBackendNotificationsHandlerImpl.e)));
            Intrinsics.checkNotNullExpressionValue(map, "client.getChannel(channe…onverter::convertChannel)");
            arrayList2.add(map);
        }
        Single zip = Single.zip(arrayList2, new ChannelsBackendNotificationsHandlerImpl$plusGetUnprocessedChannelsFromServer$2(arrayList));
        Intrinsics.checkNotNullExpressionValue(zip, "Single.zip(\n            …eCastToListOf()\n        }");
        return zip;
    }

    public static final PlatformActions access$determineContextActions(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, Channel channel, ChatMessage chatMessage) {
        PlatformActions contextActions;
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        MessageBody body = chatMessage.getBody();
        PlatformActions platformActions = null;
        if (!(body instanceof MessageBody.SystemMessageBody.Platform)) {
            body = null;
        }
        MessageBody.SystemMessageBody.Platform platform = (MessageBody.SystemMessageBody.Platform) body;
        if (!(platform == null || (contextActions = platform.getContextActions()) == null)) {
            Long version = contextActions.getVersion();
            PlatformActions contextActions2 = channel.getContextActions();
            Long version2 = contextActions2 != null ? contextActions2.getVersion() : null;
            if (!channelsBackendNotificationsHandlerImpl.g.getMessengerContextActionsInChannelUpdates().invoke().booleanValue() || version == null || version2 == null || version.longValue() > version2.longValue()) {
                platformActions = contextActions;
            }
            if (platformActions != null) {
                return platformActions;
            }
        }
        return channel.getContextActions();
    }

    public static final String access$determineFlow(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, Channel channel, ChatMessage chatMessage) {
        String flow;
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        ru.avito.messenger.api.entity.body.MessageBody body = chatMessage.getBody();
        if (!(body instanceof MessageBody.SystemMessageBody.Platform)) {
            body = null;
        }
        MessageBody.SystemMessageBody.Platform platform = (MessageBody.SystemMessageBody.Platform) body;
        return (platform == null || (flow = platform.getFlow()) == null) ? channel.getFlow() : flow;
    }

    public static final boolean access$determineIsRead(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, String str, ChatMessage chatMessage) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        return Intrinsics.areEqual(chatMessage.getFromId(), str) || chatMessage.isRead();
    }

    public static final long access$determineUpdated(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, Channel channel, ChatMessage chatMessage) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        ChatMessage.PartialChannel channel2 = chatMessage.getChannel();
        return Math.max(channel2 != null ? channel2.getUpdated() : -1, Math.max(chatMessage.getCreated(), channel.getUpdated()));
    }

    public static final List access$determineUsers(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, Channel channel, String str, ChatMessage chatMessage) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        List<User> users = channel.getUsers();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(users, 10));
        for (T t : users) {
            if ((!Intrinsics.areEqual(t.getId(), str)) && Intrinsics.areEqual(t.getId(), chatMessage.getFromId())) {
                t = (T) User.copy$default(t, null, null, Long.valueOf(TimeUnit.SECONDS.convert(channelsBackendNotificationsHandlerImpl.i.now(), TimeUnit.MILLISECONDS)), null, null, 27, null);
            }
            arrayList.add(t);
        }
        return arrayList;
    }

    public static final Single access$getChannelFromDb(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, String str, String str2) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        Observable<Option<Channel>> observeOn = channelsBackendNotificationsHandlerImpl.f.getChannel(str, str2).observeOn(channelsBackendNotificationsHandlerImpl.h.computation());
        Intrinsics.checkNotNullExpressionValue(observeOn, "channelRepo.getChannel(\n…schedulers.computation())");
        Single<Option<Channel>> onErrorReturn = observeOn.firstOrError().onErrorReturn(ChannelsBackendNotificationsHandlerImpl$getChannelFromDb$$inlined$firstOrNone$5.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "firstOrError().onErrorReturn { none() }");
        return onErrorReturn;
    }

    public static final Single access$getChannelFromServer(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, String str) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        Single map = a2.b.a.a.a.U1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.getChannel(str)).map(new ChannelsBackendNotificationsHandlerKt$sam$i$io_reactivex_functions_Function$0(new ChannelsBackendNotificationsHandlerImpl$getChannelFromServer$1(channelsBackendNotificationsHandlerImpl.e)));
        Intrinsics.checkNotNullExpressionValue(map, "client.getChannel(channe…onverter::convertChannel)");
        return map;
    }

    public static final Completable access$getChannelFromServerAndPutItInDb(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, String str, ChatMessage chatMessage) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        Single map = a2.b.a.a.a.U1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.getChannel(chatMessage.getChannelId())).map(new ChannelsBackendNotificationsHandlerKt$sam$i$io_reactivex_functions_Function$0(new ChannelsBackendNotificationsHandlerImpl$getChannelFromServer$1(channelsBackendNotificationsHandlerImpl.e)));
        Intrinsics.checkNotNullExpressionValue(map, "client.getChannel(channe…onverter::convertChannel)");
        Completable flatMapCompletable = map.flatMapCompletable(new Function<Channel, CompletableSource>(str) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$getChannelFromServerAndPutItInDb$1
            public final /* synthetic */ String b;

            {
                this.b = r2;
            }

            public final CompletableSource apply(@NotNull Channel channel) {
                Intrinsics.checkNotNullParameter(channel, "newChannel");
                ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl2 = ChannelsBackendNotificationsHandlerImpl.this;
                return a.L1(channelsBackendNotificationsHandlerImpl2, channelsBackendNotificationsHandlerImpl2.f.putChannel(this.b, channel), "channelRepo.putChannel(u…schedulers.computation())");
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "getChannelFromServer(new…newChannel)\n            }");
        return flatMapCompletable;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0062 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Collection access$getChannelTagsToDelete(com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl r5, ru.avito.messenger.api.entity.event.ChannelsUpdatedEvent r6, java.lang.String r7) {
        /*
            java.util.Objects.requireNonNull(r5)
            java.util.Map<java.lang.String, ru.avito.messenger.api.entity.event.ChannelUpdate> r5 = r6.channels
            java.util.LinkedHashSet r6 = new java.util.LinkedHashSet
            r6.<init>()
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0012:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0066
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            ru.avito.messenger.api.entity.event.ChannelUpdate r0 = (ru.avito.messenger.api.entity.event.ChannelUpdate) r0
            java.util.List<java.lang.String> r0 = r0.removedTags
            if (r0 == 0) goto L_0x005e
            boolean r2 = r0.isEmpty()
            r2 = r2 ^ 1
            if (r2 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r0 = 0
        L_0x0038:
            if (r0 == 0) goto L_0x005e
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = t6.n.e.collectionSizeOrDefault(r0, r3)
            r2.<init>(r3)
            java.util.Iterator r0 = r0.iterator()
        L_0x0049:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0062
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            ru.avito.android.persistence.messenger.ChannelTag r4 = new ru.avito.android.persistence.messenger.ChannelTag
            r4.<init>(r7, r1, r3)
            r2.add(r4)
            goto L_0x0049
        L_0x005e:
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0062:
            t6.n.h.addAll(r6, r2)
            goto L_0x0012
        L_0x0066:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl.access$getChannelTagsToDelete(com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl, ru.avito.messenger.api.entity.event.ChannelsUpdatedEvent, java.lang.String):java.util.Collection");
    }

    public static final Single access$getChannelsFromDb(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, String str, Set set) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        Single<List<Channel>> observeOn = channelsBackendNotificationsHandlerImpl.f.getBareChannels(str, set).firstOrError().observeOn(channelsBackendNotificationsHandlerImpl.h.computation());
        Intrinsics.checkNotNullExpressionValue(observeOn, "channelRepo.getBareChann…schedulers.computation())");
        return observeOn;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x009b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.reactivex.Completable access$handleChannelsUpdatedEvent(com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl r9, ru.avito.messenger.api.entity.event.ChannelsUpdatedEvent r10, java.lang.String r11) {
        /*
            java.util.Objects.requireNonNull(r9)
            java.util.Map<java.lang.String, ru.avito.messenger.api.entity.event.ChannelUpdate> r0 = r10.channels
            java.util.Set r0 = r0.keySet()
            com.avito.android.messenger.channels.mvi.data.ChannelRepo r1 = access$getChannelRepo$p(r9)
            io.reactivex.Observable r0 = r1.getBareChannels(r11, r0)
            io.reactivex.Single r0 = r0.firstOrError()
            com.avito.android.util.SchedulersFactory r1 = access$getSchedulers$p(r9)
            io.reactivex.Scheduler r1 = r1.computation()
            io.reactivex.Single r0 = r0.observeOn(r1)
            java.lang.String r1 = "channelRepo.getBareChann…schedulers.computation())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$handleChannelsUpdatedEvent$1 r1 = new com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$handleChannelsUpdatedEvent$1
            r1.<init>(r10)
            io.reactivex.Single r0 = r0.flatMap(r1)
            com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$handleChannelsUpdatedEvent$2 r1 = new com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$handleChannelsUpdatedEvent$2
            r1.<init>(r11)
            io.reactivex.Completable r0 = r0.flatMapCompletable(r1)
            com.avito.android.messenger.channels.mvi.data.ChannelRepo r1 = access$getChannelRepo$p(r9)
            java.util.Map<java.lang.String, ru.avito.messenger.api.entity.event.ChannelUpdate> r2 = r10.channels
            java.util.LinkedHashSet r3 = new java.util.LinkedHashSet
            r3.<init>()
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x004b:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x009f
            java.lang.Object r4 = r2.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r4.getValue()
            ru.avito.messenger.api.entity.event.ChannelUpdate r4 = (ru.avito.messenger.api.entity.event.ChannelUpdate) r4
            java.util.List<java.lang.String> r4 = r4.removedTags
            if (r4 == 0) goto L_0x0097
            boolean r6 = r4.isEmpty()
            r6 = r6 ^ 1
            if (r6 == 0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r4 = 0
        L_0x0071:
            if (r4 == 0) goto L_0x0097
            java.util.ArrayList r6 = new java.util.ArrayList
            r7 = 10
            int r7 = t6.n.e.collectionSizeOrDefault(r4, r7)
            r6.<init>(r7)
            java.util.Iterator r4 = r4.iterator()
        L_0x0082:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x009b
            java.lang.Object r7 = r4.next()
            java.lang.String r7 = (java.lang.String) r7
            ru.avito.android.persistence.messenger.ChannelTag r8 = new ru.avito.android.persistence.messenger.ChannelTag
            r8.<init>(r11, r5, r7)
            r6.add(r8)
            goto L_0x0082
        L_0x0097:
            java.util.List r6 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x009b:
            t6.n.h.addAll(r3, r6)
            goto L_0x004b
        L_0x009f:
            io.reactivex.Completable r11 = r1.deleteChannelTags(r3)
            io.reactivex.Completable r11 = r0.concatWith(r11)
            java.lang.String r0 = "getChannelsFromDb(\n     …t, userId))\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeWriteLock r0 = access$getLock$p(r9)
            java.util.Map<java.lang.String, ru.avito.messenger.api.entity.event.ChannelUpdate> r10 = r10.channels
            java.util.Set r10 = r10.keySet()
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00bf:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x00d4
            java.lang.Object r2 = r10.next()
            java.lang.String r2 = (java.lang.String) r2
            com.avito.android.messenger.channels.mvi.sync.ChannelsKey$Id r3 = new com.avito.android.messenger.channels.mvi.sync.ChannelsKey$Id
            r3.<init>(r2)
            r1.add(r3)
            goto L_0x00bf
        L_0x00d4:
            com.avito.android.util.SchedulersFactory r9 = access$getSchedulers$p(r9)
            io.reactivex.Scheduler r9 = r9.computation()
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            io.reactivex.Single r10 = r11.toSingleDefault(r10)
            java.lang.String r11 = "this.toSingleDefault(Unit)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            java.lang.String r11 = "handleChannelsUpdatedEvent"
            io.reactivex.Single r9 = r0.callSingle(r10, r11, r1, r9)
            io.reactivex.Completable r9 = r9.ignoreElement()
            java.lang.String r10 = "lock.callSingle(\n       …ler\n    ).ignoreElement()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl.access$handleChannelsUpdatedEvent(com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl, ru.avito.messenger.api.entity.event.ChannelsUpdatedEvent, java.lang.String):io.reactivex.Completable");
    }

    public static final Completable access$handleChatAddedToBlacklistEvent(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, BlacklistInfo blacklistInfo, String str) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        if (Intrinsics.areEqual(blacklistInfo.ownerId, str)) {
            return channelsBackendNotificationsHandlerImpl.k.deleteChatAndAllDraftsWithInterlocutorFromDb(str, blacklistInfo.userId, blacklistInfo.context.getChannelId(), blacklistInfo.context.getItemId());
        }
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }

    public static final Completable access$handleChatClearEvent(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, ChatClearEvent chatClearEvent, String str) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        if (Intrinsics.areEqual(chatClearEvent.uid, str)) {
            return channelsBackendNotificationsHandlerImpl.k.deleteChatAndDraftFromDb(str, chatClearEvent.getChannelId());
        }
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }

    public static final Completable access$handleMessageUpdateEvent(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, ChatMessageUpdate chatMessageUpdate, String str) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        ChatMessage message = chatMessageUpdate.getMessage();
        if (Intrinsics.areEqual(message.getUid(), str)) {
            Observable<Option<Channel>> observeOn = channelsBackendNotificationsHandlerImpl.f.getChannel(str, message.getChannelId()).observeOn(channelsBackendNotificationsHandlerImpl.h.computation());
            Intrinsics.checkNotNullExpressionValue(observeOn, "channelRepo.getChannel(\n…schedulers.computation())");
            Single<Option<Channel>> onErrorReturn = observeOn.firstOrError().onErrorReturn(ChannelsBackendNotificationsHandlerImpl$getChannelFromDb$$inlined$firstOrNone$3.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "firstOrError().onErrorReturn { none() }");
            Completable flatMapCompletable = onErrorReturn.flatMapCompletable(new Function<Option<? extends T>, CompletableSource>(str, message) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$handleNewMessageEvent$$inlined$completableIf$lambda$3
                public final /* synthetic */ String b;
                public final /* synthetic */ ChatMessage c;

                {
                    this.b = r2;
                    this.c = r3;
                }

                public final CompletableSource apply(@NotNull Option<? extends T> option) {
                    Completable completable;
                    Intrinsics.checkNotNullParameter(option, "it");
                    if (option instanceof None) {
                        final ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl2 = ChannelsBackendNotificationsHandlerImpl.this;
                        final String str2 = this.b;
                        Single<R> map = a.U1(channelsBackendNotificationsHandlerImpl2, channelsBackendNotificationsHandlerImpl2.d.getChannel(this.c.getChannelId())).map(new ChannelsBackendNotificationsHandlerKt$sam$i$io_reactivex_functions_Function$0(new Function1<ru.avito.messenger.api.entity.Channel, Channel>(channelsBackendNotificationsHandlerImpl2.e) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$handleNewMessageEvent$$inlined$completableIf$lambda$3.1
                            @NotNull
                            public final Channel invoke(@NotNull ru.avito.messenger.api.entity.Channel channel) {
                                Intrinsics.checkNotNullParameter(channel, "p1");
                                return ((MessengerEntityConverter) this.receiver).convertChannel(channel);
                            }
                        }));
                        Intrinsics.checkNotNullExpressionValue(map, "client.getChannel(channe…onverter::convertChannel)");
                        Completable flatMapCompletable2 = map.flatMapCompletable(new Function<Channel, CompletableSource>() { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$handleNewMessageEvent$$inlined$completableIf$lambda$3.2
                            public final CompletableSource apply(@NotNull Channel channel) {
                                Intrinsics.checkNotNullParameter(channel, "newChannel");
                                ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl3 = channelsBackendNotificationsHandlerImpl2;
                                return a.L1(channelsBackendNotificationsHandlerImpl3, channelsBackendNotificationsHandlerImpl3.f.putChannel(str2, channel), "channelRepo.putChannel(u…schedulers.computation())");
                            }
                        });
                        Intrinsics.checkNotNullExpressionValue(flatMapCompletable2, "getChannelFromServer(new…newChannel)\n            }");
                        return flatMapCompletable2;
                    } else if (option instanceof Some) {
                        Channel channel = (Channel) ((Some) option).getT();
                        ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl3 = ChannelsBackendNotificationsHandlerImpl.this;
                        String str3 = this.b;
                        ChatMessage chatMessage = this.c;
                        LocalMessage lastMessage = channel.getLastMessage();
                        boolean z = true;
                        if (lastMessage == null || lastMessage.created <= chatMessage.getCreated()) {
                            List<User> users = channel.getUsers();
                            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(users, 10));
                            for (T t : users) {
                                if ((z ^ Intrinsics.areEqual(t.getId(), str3)) && Intrinsics.areEqual(t.getId(), chatMessage.getFromId())) {
                                    t = (T) User.copy$default(t, null, null, Long.valueOf(TimeUnit.SECONDS.convert(channelsBackendNotificationsHandlerImpl3.i.now(), TimeUnit.MILLISECONDS)), null, null, 27, null);
                                }
                                arrayList.add(t);
                                z = true;
                            }
                            boolean z2 = Intrinsics.areEqual(chatMessage.getFromId(), str3) || chatMessage.isRead();
                            ChatMessage.PartialChannel channel2 = chatMessage.getChannel();
                            completable = a.L1(channelsBackendNotificationsHandlerImpl3, channelsBackendNotificationsHandlerImpl3.f.putChannel(str3, Channel.copy$default(channel, null, null, null, arrayList, 0, Math.max(channel2 != null ? channel2.getUpdated() : -1, Math.max(chatMessage.getCreated(), channel.getUpdated())), null, null, false, z2, false, false, null, ChannelsBackendNotificationsHandlerImpl.access$determineContextActions(channelsBackendNotificationsHandlerImpl3, channel, chatMessage), null, ChannelsBackendNotificationsHandlerImpl.access$determineFlow(channelsBackendNotificationsHandlerImpl3, channel, chatMessage), null, null, null, 482775, null)), "channelRepo.putChannel(u…schedulers.computation())");
                        } else {
                            completable = Completable.complete();
                            Intrinsics.checkNotNullExpressionValue(completable, "Completable.complete()");
                        }
                        return completable;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // io.reactivex.functions.Function
                public /* bridge */ /* synthetic */ CompletableSource apply(Object obj) {
                    return apply((Option) ((Option) obj));
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "flatMapCompletable { it.fold(ifEmpty, some) }");
            RxFairCompositeWriteLock rxFairCompositeWriteLock = channelsBackendNotificationsHandlerImpl.j;
            Set of = x.setOf(new ChannelsKey.Id(message.getChannelId()));
            Scheduler computation = channelsBackendNotificationsHandlerImpl.h.computation();
            Single singleDefault = flatMapCompletable.toSingleDefault(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(singleDefault, "this.toSingleDefault(Unit)");
            Completable ignoreElement = rxFairCompositeWriteLock.callSingle(singleDefault, "handleNewMessageEvent", of, computation).ignoreElement();
            Intrinsics.checkNotNullExpressionValue(ignoreElement, "lock.callSingle(\n       …ler\n    ).ignoreElement()");
            return ignoreElement;
        }
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }

    public static final Completable access$handleNewMessageEvent(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, ChatMessage chatMessage, String str) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        if (Intrinsics.areEqual(chatMessage.getUid(), str)) {
            Observable<Option<Channel>> observeOn = channelsBackendNotificationsHandlerImpl.f.getChannel(str, chatMessage.getChannelId()).observeOn(channelsBackendNotificationsHandlerImpl.h.computation());
            Intrinsics.checkNotNullExpressionValue(observeOn, "channelRepo.getChannel(\n…schedulers.computation())");
            Single<Option<Channel>> onErrorReturn = observeOn.firstOrError().onErrorReturn(ChannelsBackendNotificationsHandlerImpl$getChannelFromDb$$inlined$firstOrNone$4.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "firstOrError().onErrorReturn { none() }");
            Completable flatMapCompletable = onErrorReturn.flatMapCompletable(new Function<Option<? extends T>, CompletableSource>(str, chatMessage) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$handleNewMessageEvent$$inlined$completableIf$lambda$4
                public final /* synthetic */ String b;
                public final /* synthetic */ ChatMessage c;

                {
                    this.b = r2;
                    this.c = r3;
                }

                public final CompletableSource apply(@NotNull Option<? extends T> option) {
                    Completable completable;
                    Intrinsics.checkNotNullParameter(option, "it");
                    if (option instanceof None) {
                        final ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl2 = ChannelsBackendNotificationsHandlerImpl.this;
                        final String str2 = this.b;
                        Single<R> map = a.U1(channelsBackendNotificationsHandlerImpl2, channelsBackendNotificationsHandlerImpl2.d.getChannel(this.c.getChannelId())).map(new ChannelsBackendNotificationsHandlerKt$sam$i$io_reactivex_functions_Function$0(new Function1<ru.avito.messenger.api.entity.Channel, Channel>(channelsBackendNotificationsHandlerImpl2.e) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$handleNewMessageEvent$$inlined$completableIf$lambda$4.1
                            @NotNull
                            public final Channel invoke(@NotNull ru.avito.messenger.api.entity.Channel channel) {
                                Intrinsics.checkNotNullParameter(channel, "p1");
                                return ((MessengerEntityConverter) this.receiver).convertChannel(channel);
                            }
                        }));
                        Intrinsics.checkNotNullExpressionValue(map, "client.getChannel(channe…onverter::convertChannel)");
                        Completable flatMapCompletable2 = map.flatMapCompletable(new Function<Channel, CompletableSource>() { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$handleNewMessageEvent$$inlined$completableIf$lambda$4.2
                            public final CompletableSource apply(@NotNull Channel channel) {
                                Intrinsics.checkNotNullParameter(channel, "newChannel");
                                ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl3 = channelsBackendNotificationsHandlerImpl2;
                                return a.L1(channelsBackendNotificationsHandlerImpl3, channelsBackendNotificationsHandlerImpl3.f.putChannel(str2, channel), "channelRepo.putChannel(u…schedulers.computation())");
                            }
                        });
                        Intrinsics.checkNotNullExpressionValue(flatMapCompletable2, "getChannelFromServer(new…newChannel)\n            }");
                        return flatMapCompletable2;
                    } else if (option instanceof Some) {
                        Channel channel = (Channel) ((Some) option).getT();
                        ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl3 = ChannelsBackendNotificationsHandlerImpl.this;
                        String str3 = this.b;
                        ChatMessage chatMessage2 = this.c;
                        LocalMessage lastMessage = channel.getLastMessage();
                        boolean z = true;
                        if (lastMessage == null || lastMessage.created <= chatMessage2.getCreated()) {
                            List<User> users = channel.getUsers();
                            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(users, 10));
                            for (T t : users) {
                                if ((z ^ Intrinsics.areEqual(t.getId(), str3)) && Intrinsics.areEqual(t.getId(), chatMessage2.getFromId())) {
                                    t = (T) User.copy$default(t, null, null, Long.valueOf(TimeUnit.SECONDS.convert(channelsBackendNotificationsHandlerImpl3.i.now(), TimeUnit.MILLISECONDS)), null, null, 27, null);
                                }
                                arrayList.add(t);
                                z = true;
                            }
                            boolean z2 = Intrinsics.areEqual(chatMessage2.getFromId(), str3) || chatMessage2.isRead();
                            ChatMessage.PartialChannel channel2 = chatMessage2.getChannel();
                            completable = a.L1(channelsBackendNotificationsHandlerImpl3, channelsBackendNotificationsHandlerImpl3.f.putChannel(str3, Channel.copy$default(channel, null, null, null, arrayList, 0, Math.max(channel2 != null ? channel2.getUpdated() : -1, Math.max(chatMessage2.getCreated(), channel.getUpdated())), null, null, false, z2, false, false, null, ChannelsBackendNotificationsHandlerImpl.access$determineContextActions(channelsBackendNotificationsHandlerImpl3, channel, chatMessage2), null, ChannelsBackendNotificationsHandlerImpl.access$determineFlow(channelsBackendNotificationsHandlerImpl3, channel, chatMessage2), null, null, null, 482775, null)), "channelRepo.putChannel(u…schedulers.computation())");
                        } else {
                            completable = Completable.complete();
                            Intrinsics.checkNotNullExpressionValue(completable, "Completable.complete()");
                        }
                        return completable;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // io.reactivex.functions.Function
                public /* bridge */ /* synthetic */ CompletableSource apply(Object obj) {
                    return apply((Option) ((Option) obj));
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "flatMapCompletable { it.fold(ifEmpty, some) }");
            RxFairCompositeWriteLock rxFairCompositeWriteLock = channelsBackendNotificationsHandlerImpl.j;
            Set of = x.setOf(new ChannelsKey.Id(chatMessage.getChannelId()));
            Scheduler computation = channelsBackendNotificationsHandlerImpl.h.computation();
            Single singleDefault = flatMapCompletable.toSingleDefault(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(singleDefault, "this.toSingleDefault(Unit)");
            Completable ignoreElement = rxFairCompositeWriteLock.callSingle(singleDefault, "handleNewMessageEvent", of, computation).ignoreElement();
            Intrinsics.checkNotNullExpressionValue(ignoreElement, "lock.callSingle(\n       …ler\n    ).ignoreElement()");
            return ignoreElement;
        }
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }

    public static final Completable access$handleReadEvent(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, ReadChatEvent readChatEvent, String str) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        if (Intrinsics.areEqual(readChatEvent.getFromId(), str)) {
            Completable channelIsRead = channelsBackendNotificationsHandlerImpl.f.setChannelIsRead(str, readChatEvent.getChannelId());
            RxFairCompositeWriteLock rxFairCompositeWriteLock = channelsBackendNotificationsHandlerImpl.j;
            Set of = x.setOf(new ChannelsKey.Id(readChatEvent.getChannelId()));
            Scheduler computation = channelsBackendNotificationsHandlerImpl.h.computation();
            Single singleDefault = channelIsRead.toSingleDefault(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(singleDefault, "this.toSingleDefault(Unit)");
            Completable ignoreElement = rxFairCompositeWriteLock.callSingle(singleDefault, "handleReadEvent", of, computation).ignoreElement();
            Intrinsics.checkNotNullExpressionValue(ignoreElement, "lock.callSingle(\n       …ler\n    ).ignoreElement()");
            return ignoreElement;
        }
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }

    public static final Single access$plusGetUnprocessedChannelsFromServer(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, List list, Set set) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(set, 10));
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Single map = a2.b.a.a.a.U1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.getChannel((String) it.next())).map(new ChannelsBackendNotificationsHandlerKt$sam$i$io_reactivex_functions_Function$0(new ChannelsBackendNotificationsHandlerImpl$getChannelFromServer$1(channelsBackendNotificationsHandlerImpl.e)));
            Intrinsics.checkNotNullExpressionValue(map, "client.getChannel(channe…onverter::convertChannel)");
            arrayList.add(map);
        }
        Single zip = Single.zip(arrayList, new ChannelsBackendNotificationsHandlerImpl$plusGetUnprocessedChannelsFromServer$2(list));
        Intrinsics.checkNotNullExpressionValue(zip, "Single.zip(\n            …eCastToListOf()\n        }");
        return zip;
    }

    public static final Completable access$putChannelInDb(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, String str, Channel channel) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        return a2.b.a.a.a.L1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.f.putChannel(str, channel), "channelRepo.putChannel(u…schedulers.computation())");
    }

    public static final Disposable access$subscribeAndLogErrors(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, Completable completable, String str) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        Disposable subscribe = completable.subscribe(ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1.INSTANCE, new ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$2(str));
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(\n            {…)\n            }\n        )");
        return subscribe;
    }

    public static final void access$subscribeToBackendNotifications(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, String str) {
        Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
        CompositeDisposable compositeDisposable = channelsBackendNotificationsHandlerImpl.b;
        Completable M1 = a2.b.a.a.a.M1(channelsBackendNotificationsHandlerImpl, a2.b.a.a.a.Q1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.observeChatEvents(ReadChatEvent.class)).concatMapCompletable(new Function<T, CompletableSource>(str, channelsBackendNotificationsHandlerImpl) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$1
            public final /* synthetic */ String a;
            public final /* synthetic */ ChannelsBackendNotificationsHandlerImpl b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // io.reactivex.functions.Function
            public final CompletableSource apply(@NotNull T t) {
                Intrinsics.checkNotNullParameter(t, "event");
                String str2 = this.a;
                T t2 = t;
                ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl2 = this.b;
                if (Intrinsics.areEqual(t2.getFromId(), str2)) {
                    Completable channelIsRead = channelsBackendNotificationsHandlerImpl2.f.setChannelIsRead(str2, t2.getChannelId());
                    RxFairCompositeWriteLock rxFairCompositeWriteLock = channelsBackendNotificationsHandlerImpl2.j;
                    Set of = x.setOf(new ChannelsKey.Id(t2.getChannelId()));
                    Scheduler computation = channelsBackendNotificationsHandlerImpl2.h.computation();
                    Single<T> singleDefault = channelIsRead.toSingleDefault(Unit.INSTANCE);
                    Intrinsics.checkNotNullExpressionValue(singleDefault, "this.toSingleDefault(Unit)");
                    Completable ignoreElement = rxFairCompositeWriteLock.callSingle(singleDefault, "handleReadEvent", of, computation).ignoreElement();
                    Intrinsics.checkNotNullExpressionValue(ignoreElement, "lock.callSingle(\n       …ler\n    ).ignoreElement()");
                    return ignoreElement;
                }
                Completable complete = Completable.complete();
                Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
                return complete;
            }
        }), "client.observeChatEvents…schedulers.computation())");
        String simpleName = ReadChatEvent.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "T::class.java.simpleName");
        ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1 channelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1 = ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1.INSTANCE;
        Disposable subscribe = M1.subscribe(channelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1, new ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$2(simpleName));
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(\n            {…)\n            }\n        )");
        DisposableKt.addTo(subscribe, compositeDisposable);
        CompositeDisposable compositeDisposable2 = channelsBackendNotificationsHandlerImpl.b;
        Completable M12 = a2.b.a.a.a.M1(channelsBackendNotificationsHandlerImpl, a2.b.a.a.a.Q1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.observeChatEvents(ChatClearEvent.class)).concatMapCompletable(new Function<T, CompletableSource>(str, channelsBackendNotificationsHandlerImpl) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$2
            public final /* synthetic */ String a;
            public final /* synthetic */ ChannelsBackendNotificationsHandlerImpl b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // io.reactivex.functions.Function
            public final CompletableSource apply(@NotNull T t) {
                Intrinsics.checkNotNullParameter(t, "event");
                String str2 = this.a;
                T t2 = t;
                ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl2 = this.b;
                if (Intrinsics.areEqual(t2.uid, str2)) {
                    return channelsBackendNotificationsHandlerImpl2.k.deleteChatAndDraftFromDb(str2, t2.getChannelId());
                }
                Completable complete = Completable.complete();
                Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
                return complete;
            }
        }), "client.observeChatEvents…schedulers.computation())");
        String simpleName2 = ChatClearEvent.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName2, "T::class.java.simpleName");
        Disposable subscribe2 = M12.subscribe(channelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1, new ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$2(simpleName2));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "subscribe(\n            {…)\n            }\n        )");
        DisposableKt.addTo(subscribe2, compositeDisposable2);
        CompositeDisposable compositeDisposable3 = channelsBackendNotificationsHandlerImpl.b;
        Completable M13 = a2.b.a.a.a.M1(channelsBackendNotificationsHandlerImpl, a2.b.a.a.a.Q1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.observeChatEvents(BlacklistInfo.class)).concatMapCompletable(new Function<T, CompletableSource>(str, channelsBackendNotificationsHandlerImpl) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$3
            public final /* synthetic */ String a;
            public final /* synthetic */ ChannelsBackendNotificationsHandlerImpl b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // io.reactivex.functions.Function
            public final CompletableSource apply(@NotNull T t) {
                Intrinsics.checkNotNullParameter(t, "event");
                String str2 = this.a;
                T t2 = t;
                ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl2 = this.b;
                if (Intrinsics.areEqual(t2.ownerId, str2)) {
                    return channelsBackendNotificationsHandlerImpl2.k.deleteChatAndAllDraftsWithInterlocutorFromDb(str2, t2.userId, t2.context.getChannelId(), t2.context.getItemId());
                }
                Completable complete = Completable.complete();
                Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
                return complete;
            }
        }), "client.observeChatEvents…schedulers.computation())");
        String simpleName3 = BlacklistInfo.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName3, "T::class.java.simpleName");
        Disposable subscribe3 = M13.subscribe(channelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1, new ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$2(simpleName3));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "subscribe(\n            {…)\n            }\n        )");
        DisposableKt.addTo(subscribe3, compositeDisposable3);
        CompositeDisposable compositeDisposable4 = channelsBackendNotificationsHandlerImpl.b;
        Completable M14 = a2.b.a.a.a.M1(channelsBackendNotificationsHandlerImpl, a2.b.a.a.a.Q1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.observeChatEvents(ChatMessage.class)).concatMapCompletable(new Function<T, CompletableSource>(str, channelsBackendNotificationsHandlerImpl) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$4
            public final /* synthetic */ String a;
            public final /* synthetic */ ChannelsBackendNotificationsHandlerImpl b;

            {
                this.a = r1;
                this.b = r2;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: io.reactivex.Completable */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.functions.Function
            public final CompletableSource apply(@NotNull T t) {
                Intrinsics.checkNotNullParameter(t, "event");
                String str2 = this.a;
                T t2 = t;
                ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl2 = this.b;
                if (Intrinsics.areEqual(t2.getUid(), str2)) {
                    Observable<Option<Channel>> observeOn = channelsBackendNotificationsHandlerImpl2.f.getChannel(str2, t2.getChannelId()).observeOn(channelsBackendNotificationsHandlerImpl2.h.computation());
                    Intrinsics.checkNotNullExpressionValue(observeOn, "channelRepo.getChannel(\n…schedulers.computation())");
                    Single<Option<Channel>> onErrorReturn = observeOn.firstOrError().onErrorReturn(ChannelsBackendNotificationsHandlerImpl$getChannelFromDb$$inlined$firstOrNone$1.INSTANCE);
                    Intrinsics.checkNotNullExpressionValue(onErrorReturn, "firstOrError().onErrorReturn { none() }");
                    Completable flatMapCompletable = onErrorReturn.flatMapCompletable(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0046: INVOKE  (r0v3 'flatMapCompletable' io.reactivex.Completable) = 
                          (r2v6 'onErrorReturn' io.reactivex.Single<arrow.core.Option<com.avito.android.remote.model.messenger.Channel>>)
                          (wrap: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$4$lambda$1 : 0x0043: CONSTRUCTOR  (r3v6 com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$4$lambda$1) = 
                          (r1v0 'channelsBackendNotificationsHandlerImpl2' com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl)
                          (r0v1 'str2' java.lang.String)
                          (r5v1 't2' T)
                         call: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$4$lambda$1.<init>(com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl, java.lang.String, ru.avito.messenger.api.entity.ChatMessage):void type: CONSTRUCTOR)
                         type: VIRTUAL call: io.reactivex.Single.flatMapCompletable(io.reactivex.functions.Function):io.reactivex.Completable in method: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$4.apply(T):io.reactivex.CompletableSource, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0043: CONSTRUCTOR  (r3v6 com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$4$lambda$1) = 
                          (r1v0 'channelsBackendNotificationsHandlerImpl2' com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl)
                          (r0v1 'str2' java.lang.String)
                          (r5v1 't2' T)
                         call: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$4$lambda$1.<init>(com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl, java.lang.String, ru.avito.messenger.api.entity.ChatMessage):void type: CONSTRUCTOR in method: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$4.apply(T):io.reactivex.CompletableSource, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                        	... 23 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$4$lambda$1, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 29 more
                        */
                    /*
                        this = this;
                        java.lang.String r0 = "event"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                        java.lang.String r0 = r4.a
                        ru.avito.messenger.api.entity.ChatMessage r5 = (ru.avito.messenger.api.entity.ChatMessage) r5
                        com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl r1 = r4.b
                        java.lang.String r2 = r5.getUid()
                        boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r0)
                        if (r2 == 0) goto L_0x0083
                        java.lang.String r2 = r5.getChannelId()
                        com.avito.android.messenger.channels.mvi.data.ChannelRepo r3 = com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl.access$getChannelRepo$p(r1)
                        io.reactivex.Observable r2 = r3.getChannel(r0, r2)
                        com.avito.android.util.SchedulersFactory r3 = com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl.access$getSchedulers$p(r1)
                        io.reactivex.Scheduler r3 = r3.computation()
                        io.reactivex.Observable r2 = r2.observeOn(r3)
                        java.lang.String r3 = "channelRepo.getChannel(\n…schedulers.computation())"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                        io.reactivex.Single r2 = r2.firstOrError()
                        com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$getChannelFromDb$$inlined$firstOrNone$1 r3 = com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$getChannelFromDb$$inlined$firstOrNone$1.INSTANCE
                        io.reactivex.Single r2 = r2.onErrorReturn(r3)
                        java.lang.String r3 = "firstOrError().onErrorReturn { none() }"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                        com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$4$lambda$1 r3 = new com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$4$lambda$1
                        r3.<init>(r1, r0, r5)
                        io.reactivex.Completable r0 = r2.flatMapCompletable(r3)
                        java.lang.String r2 = "flatMapCompletable { it.fold(ifEmpty, some) }"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
                        com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeWriteLock r2 = com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl.access$getLock$p(r1)
                        com.avito.android.messenger.channels.mvi.sync.ChannelsKey$Id r3 = new com.avito.android.messenger.channels.mvi.sync.ChannelsKey$Id
                        java.lang.String r5 = r5.getChannelId()
                        r3.<init>(r5)
                        java.util.Set r5 = t6.n.x.setOf(r3)
                        com.avito.android.util.SchedulersFactory r1 = com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl.access$getSchedulers$p(r1)
                        io.reactivex.Scheduler r1 = r1.computation()
                        kotlin.Unit r3 = kotlin.Unit.INSTANCE
                        io.reactivex.Single r0 = r0.toSingleDefault(r3)
                        java.lang.String r3 = "this.toSingleDefault(Unit)"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
                        java.lang.String r3 = "handleNewMessageEvent"
                        io.reactivex.Single r5 = r2.callSingle(r0, r3, r5, r1)
                        io.reactivex.Completable r5 = r5.ignoreElement()
                        java.lang.String r0 = "lock.callSingle(\n       …ler\n    ).ignoreElement()"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                        goto L_0x008c
                    L_0x0083:
                        io.reactivex.Completable r5 = io.reactivex.Completable.complete()
                        java.lang.String r0 = "Completable.complete()"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                    L_0x008c:
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$4.apply(java.lang.Object):io.reactivex.CompletableSource");
                }
            }), "client.observeChatEvents…schedulers.computation())");
            String simpleName4 = ChatMessage.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName4, "T::class.java.simpleName");
            Disposable subscribe4 = M14.subscribe(channelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1, new ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$2(simpleName4));
            Intrinsics.checkNotNullExpressionValue(subscribe4, "subscribe(\n            {…)\n            }\n        )");
            DisposableKt.addTo(subscribe4, compositeDisposable4);
            CompositeDisposable compositeDisposable5 = channelsBackendNotificationsHandlerImpl.b;
            Completable M15 = a2.b.a.a.a.M1(channelsBackendNotificationsHandlerImpl, a2.b.a.a.a.Q1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.observeChatEvents(ChatMessageUpdate.class)).concatMapCompletable(new Function<T, CompletableSource>(str, channelsBackendNotificationsHandlerImpl) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5
                public final /* synthetic */ String a;
                public final /* synthetic */ ChannelsBackendNotificationsHandlerImpl b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: io.reactivex.Completable */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.reactivex.functions.Function
                public final CompletableSource apply(@NotNull T t) {
                    Intrinsics.checkNotNullParameter(t, "event");
                    String str2 = this.a;
                    ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl2 = this.b;
                    ChatMessage message = t.getMessage();
                    if (Intrinsics.areEqual(message.getUid(), str2)) {
                        Observable<Option<Channel>> observeOn = channelsBackendNotificationsHandlerImpl2.f.getChannel(str2, message.getChannelId()).observeOn(channelsBackendNotificationsHandlerImpl2.h.computation());
                        Intrinsics.checkNotNullExpressionValue(observeOn, "channelRepo.getChannel(\n…schedulers.computation())");
                        Single<Option<Channel>> onErrorReturn = observeOn.firstOrError().onErrorReturn(ChannelsBackendNotificationsHandlerImpl$getChannelFromDb$$inlined$firstOrNone$2.INSTANCE);
                        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "firstOrError().onErrorReturn { none() }");
                        Completable flatMapCompletable = onErrorReturn.flatMapCompletable(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004a: INVOKE  (r0v3 'flatMapCompletable' io.reactivex.Completable) = 
                              (r2v6 'onErrorReturn' io.reactivex.Single<arrow.core.Option<com.avito.android.remote.model.messenger.Channel>>)
                              (wrap: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5$lambda$1 : 0x0047: CONSTRUCTOR  (r3v6 com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5$lambda$1) = 
                              (r1v0 'channelsBackendNotificationsHandlerImpl2' com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl)
                              (r0v1 'str2' java.lang.String)
                              (r5v2 'message' ru.avito.messenger.api.entity.ChatMessage)
                             call: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5$lambda$1.<init>(com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl, java.lang.String, ru.avito.messenger.api.entity.ChatMessage):void type: CONSTRUCTOR)
                             type: VIRTUAL call: io.reactivex.Single.flatMapCompletable(io.reactivex.functions.Function):io.reactivex.Completable in method: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5.apply(T):io.reactivex.CompletableSource, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0047: CONSTRUCTOR  (r3v6 com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5$lambda$1) = 
                              (r1v0 'channelsBackendNotificationsHandlerImpl2' com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl)
                              (r0v1 'str2' java.lang.String)
                              (r5v2 'message' ru.avito.messenger.api.entity.ChatMessage)
                             call: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5$lambda$1.<init>(com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl, java.lang.String, ru.avito.messenger.api.entity.ChatMessage):void type: CONSTRUCTOR in method: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5.apply(T):io.reactivex.CompletableSource, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                            	... 23 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5$lambda$1, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                            	... 29 more
                            */
                        /*
                            this = this;
                            java.lang.String r0 = "event"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                            java.lang.String r0 = r4.a
                            ru.avito.messenger.api.entity.ChatMessageUpdate r5 = (ru.avito.messenger.api.entity.ChatMessageUpdate) r5
                            com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl r1 = r4.b
                            ru.avito.messenger.api.entity.ChatMessage r5 = r5.getMessage()
                            java.lang.String r2 = r5.getUid()
                            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r0)
                            if (r2 == 0) goto L_0x0087
                            java.lang.String r2 = r5.getChannelId()
                            com.avito.android.messenger.channels.mvi.data.ChannelRepo r3 = com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl.access$getChannelRepo$p(r1)
                            io.reactivex.Observable r2 = r3.getChannel(r0, r2)
                            com.avito.android.util.SchedulersFactory r3 = com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl.access$getSchedulers$p(r1)
                            io.reactivex.Scheduler r3 = r3.computation()
                            io.reactivex.Observable r2 = r2.observeOn(r3)
                            java.lang.String r3 = "channelRepo.getChannel(\n…schedulers.computation())"
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                            io.reactivex.Single r2 = r2.firstOrError()
                            com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$getChannelFromDb$$inlined$firstOrNone$2 r3 = com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$getChannelFromDb$$inlined$firstOrNone$2.INSTANCE
                            io.reactivex.Single r2 = r2.onErrorReturn(r3)
                            java.lang.String r3 = "firstOrError().onErrorReturn { none() }"
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                            com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5$lambda$1 r3 = new com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5$lambda$1
                            r3.<init>(r1, r0, r5)
                            io.reactivex.Completable r0 = r2.flatMapCompletable(r3)
                            java.lang.String r2 = "flatMapCompletable { it.fold(ifEmpty, some) }"
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
                            com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeWriteLock r2 = com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl.access$getLock$p(r1)
                            com.avito.android.messenger.channels.mvi.sync.ChannelsKey$Id r3 = new com.avito.android.messenger.channels.mvi.sync.ChannelsKey$Id
                            java.lang.String r5 = r5.getChannelId()
                            r3.<init>(r5)
                            java.util.Set r5 = t6.n.x.setOf(r3)
                            com.avito.android.util.SchedulersFactory r1 = com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl.access$getSchedulers$p(r1)
                            io.reactivex.Scheduler r1 = r1.computation()
                            kotlin.Unit r3 = kotlin.Unit.INSTANCE
                            io.reactivex.Single r0 = r0.toSingleDefault(r3)
                            java.lang.String r3 = "this.toSingleDefault(Unit)"
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
                            java.lang.String r3 = "handleNewMessageEvent"
                            io.reactivex.Single r5 = r2.callSingle(r0, r3, r5, r1)
                            io.reactivex.Completable r5 = r5.ignoreElement()
                            java.lang.String r0 = "lock.callSingle(\n       …ler\n    ).ignoreElement()"
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                            goto L_0x0090
                        L_0x0087:
                            io.reactivex.Completable r5 = io.reactivex.Completable.complete()
                            java.lang.String r0 = "Completable.complete()"
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                        L_0x0090:
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5.apply(java.lang.Object):io.reactivex.CompletableSource");
                    }
                }), "client.observeChatEvents…schedulers.computation())");
                String simpleName5 = ChatMessageUpdate.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName5, "T::class.java.simpleName");
                Disposable subscribe5 = M15.subscribe(channelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1, new ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$2(simpleName5));
                Intrinsics.checkNotNullExpressionValue(subscribe5, "subscribe(\n            {…)\n            }\n        )");
                DisposableKt.addTo(subscribe5, compositeDisposable5);
                CompositeDisposable compositeDisposable6 = channelsBackendNotificationsHandlerImpl.b;
                Completable M16 = a2.b.a.a.a.M1(channelsBackendNotificationsHandlerImpl, a2.b.a.a.a.Q1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.observeChatEvents(ChannelsUpdatedEvent.class)).concatMapCompletable(new Function<T, CompletableSource>(str, channelsBackendNotificationsHandlerImpl) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6
                    public final /* synthetic */ String a;
                    public final /* synthetic */ ChannelsBackendNotificationsHandlerImpl b;

                    {
                        this.a = r1;
                        this.b = r2;
                    }

                    @Override // io.reactivex.functions.Function
                    public final CompletableSource apply(@NotNull T t) {
                        Collection collection;
                        Intrinsics.checkNotNullParameter(t, "event");
                        String str2 = this.a;
                        T t2 = t;
                        ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl2 = this.b;
                        Single<List<Channel>> observeOn = channelsBackendNotificationsHandlerImpl2.f.getBareChannels(str2, t2.channels.keySet()).firstOrError().observeOn(channelsBackendNotificationsHandlerImpl2.h.computation());
                        Intrinsics.checkNotNullExpressionValue(observeOn, "channelRepo.getBareChann…schedulers.computation())");
                        Completable flatMapCompletable = observeOn.flatMap(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003c: INVOKE  (r2v6 'flatMapCompletable' io.reactivex.Completable) = 
                              (wrap: io.reactivex.Single<R> : 0x0033: INVOKE  (r2v5 io.reactivex.Single<R>) = 
                              (r2v4 'observeOn' io.reactivex.Single<java.util.List<com.avito.android.remote.model.messenger.Channel>>)
                              (wrap: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6$lambda$1 : 0x0030: CONSTRUCTOR  (r3v4 com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6$lambda$1) = 
                              (r1v0 'channelsBackendNotificationsHandlerImpl2' com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl)
                              (r12v1 't2' T)
                             call: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6$lambda$1.<init>(com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl, ru.avito.messenger.api.entity.event.ChannelsUpdatedEvent):void type: CONSTRUCTOR)
                             type: VIRTUAL call: io.reactivex.Single.flatMap(io.reactivex.functions.Function):io.reactivex.Single)
                              (wrap: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6$lambda$2 : 0x0039: CONSTRUCTOR  (r3v5 com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6$lambda$2) = 
                              (r1v0 'channelsBackendNotificationsHandlerImpl2' com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl)
                              (r0v1 'str2' java.lang.String)
                             call: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6$lambda$2.<init>(com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl, java.lang.String):void type: CONSTRUCTOR)
                             type: VIRTUAL call: io.reactivex.Single.flatMapCompletable(io.reactivex.functions.Function):io.reactivex.Completable in method: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6.apply(T):io.reactivex.CompletableSource, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0033: INVOKE  (r2v5 io.reactivex.Single<R>) = 
                              (r2v4 'observeOn' io.reactivex.Single<java.util.List<com.avito.android.remote.model.messenger.Channel>>)
                              (wrap: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6$lambda$1 : 0x0030: CONSTRUCTOR  (r3v4 com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6$lambda$1) = 
                              (r1v0 'channelsBackendNotificationsHandlerImpl2' com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl)
                              (r12v1 't2' T)
                             call: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6$lambda$1.<init>(com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl, ru.avito.messenger.api.entity.event.ChannelsUpdatedEvent):void type: CONSTRUCTOR)
                             type: VIRTUAL call: io.reactivex.Single.flatMap(io.reactivex.functions.Function):io.reactivex.Single in method: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6.apply(T):io.reactivex.CompletableSource, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:749)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                            	... 15 more
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0030: CONSTRUCTOR  (r3v4 com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6$lambda$1) = 
                              (r1v0 'channelsBackendNotificationsHandlerImpl2' com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl)
                              (r12v1 't2' T)
                             call: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6$lambda$1.<init>(com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl, ru.avito.messenger.api.entity.event.ChannelsUpdatedEvent):void type: CONSTRUCTOR in method: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6.apply(T):io.reactivex.CompletableSource, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                            	... 21 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6$lambda$1, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                            	... 27 more
                            */
                        /*
                            this = this;
                            java.lang.String r0 = "event"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                            java.lang.String r0 = r11.a
                            ru.avito.messenger.api.entity.event.ChannelsUpdatedEvent r12 = (ru.avito.messenger.api.entity.event.ChannelsUpdatedEvent) r12
                            com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl r1 = r11.b
                            java.util.Map<java.lang.String, ru.avito.messenger.api.entity.event.ChannelUpdate> r2 = r12.channels
                            java.util.Set r2 = r2.keySet()
                            com.avito.android.messenger.channels.mvi.data.ChannelRepo r3 = com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl.access$getChannelRepo$p(r1)
                            io.reactivex.Observable r2 = r3.getBareChannels(r0, r2)
                            io.reactivex.Single r2 = r2.firstOrError()
                            com.avito.android.util.SchedulersFactory r3 = com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl.access$getSchedulers$p(r1)
                            io.reactivex.Scheduler r3 = r3.computation()
                            io.reactivex.Single r2 = r2.observeOn(r3)
                            java.lang.String r3 = "channelRepo.getBareChann…schedulers.computation())"
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                            com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6$lambda$1 r3 = new com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6$lambda$1
                            r3.<init>(r1, r12)
                            io.reactivex.Single r2 = r2.flatMap(r3)
                            com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6$lambda$2 r3 = new com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6$lambda$2
                            r3.<init>(r1, r0)
                            io.reactivex.Completable r2 = r2.flatMapCompletable(r3)
                            com.avito.android.messenger.channels.mvi.data.ChannelRepo r3 = com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl.access$getChannelRepo$p(r1)
                            java.util.Map<java.lang.String, ru.avito.messenger.api.entity.event.ChannelUpdate> r4 = r12.channels
                            java.util.LinkedHashSet r5 = new java.util.LinkedHashSet
                            r5.<init>()
                            java.util.Set r4 = r4.entrySet()
                            java.util.Iterator r4 = r4.iterator()
                        L_0x0053:
                            boolean r6 = r4.hasNext()
                            if (r6 == 0) goto L_0x00a7
                            java.lang.Object r6 = r4.next()
                            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
                            java.lang.Object r7 = r6.getKey()
                            java.lang.String r7 = (java.lang.String) r7
                            java.lang.Object r6 = r6.getValue()
                            ru.avito.messenger.api.entity.event.ChannelUpdate r6 = (ru.avito.messenger.api.entity.event.ChannelUpdate) r6
                            java.util.List<java.lang.String> r6 = r6.removedTags
                            if (r6 == 0) goto L_0x009f
                            boolean r8 = r6.isEmpty()
                            r8 = r8 ^ 1
                            if (r8 == 0) goto L_0x0078
                            goto L_0x0079
                        L_0x0078:
                            r6 = 0
                        L_0x0079:
                            if (r6 == 0) goto L_0x009f
                            java.util.ArrayList r8 = new java.util.ArrayList
                            r9 = 10
                            int r9 = t6.n.e.collectionSizeOrDefault(r6, r9)
                            r8.<init>(r9)
                            java.util.Iterator r6 = r6.iterator()
                        L_0x008a:
                            boolean r9 = r6.hasNext()
                            if (r9 == 0) goto L_0x00a3
                            java.lang.Object r9 = r6.next()
                            java.lang.String r9 = (java.lang.String) r9
                            ru.avito.android.persistence.messenger.ChannelTag r10 = new ru.avito.android.persistence.messenger.ChannelTag
                            r10.<init>(r0, r7, r9)
                            r8.add(r10)
                            goto L_0x008a
                        L_0x009f:
                            java.util.List r8 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
                        L_0x00a3:
                            t6.n.h.addAll(r5, r8)
                            goto L_0x0053
                        L_0x00a7:
                            io.reactivex.Completable r0 = r3.deleteChannelTags(r5)
                            io.reactivex.Completable r0 = r2.concatWith(r0)
                            java.lang.String r2 = "getChannelsFromDb(\n     …t, userId))\n            )"
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
                            com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeWriteLock r2 = com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl.access$getLock$p(r1)
                            java.util.Map<java.lang.String, ru.avito.messenger.api.entity.event.ChannelUpdate> r12 = r12.channels
                            java.util.Set r12 = r12.keySet()
                            java.util.LinkedHashSet r3 = new java.util.LinkedHashSet
                            r3.<init>()
                            java.util.Iterator r12 = r12.iterator()
                        L_0x00c7:
                            boolean r4 = r12.hasNext()
                            if (r4 == 0) goto L_0x00dc
                            java.lang.Object r4 = r12.next()
                            java.lang.String r4 = (java.lang.String) r4
                            com.avito.android.messenger.channels.mvi.sync.ChannelsKey$Id r5 = new com.avito.android.messenger.channels.mvi.sync.ChannelsKey$Id
                            r5.<init>(r4)
                            r3.add(r5)
                            goto L_0x00c7
                        L_0x00dc:
                            com.avito.android.util.SchedulersFactory r12 = com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl.access$getSchedulers$p(r1)
                            io.reactivex.Scheduler r12 = r12.computation()
                            kotlin.Unit r1 = kotlin.Unit.INSTANCE
                            io.reactivex.Single r0 = r0.toSingleDefault(r1)
                            java.lang.String r1 = "this.toSingleDefault(Unit)"
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                            java.lang.String r1 = "handleChannelsUpdatedEvent"
                            io.reactivex.Single r12 = r2.callSingle(r0, r1, r3, r12)
                            io.reactivex.Completable r12 = r12.ignoreElement()
                            java.lang.String r0 = "lock.callSingle(\n       …ler\n    ).ignoreElement()"
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
                            return r12
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$6.apply(java.lang.Object):io.reactivex.CompletableSource");
                    }
                }), "client.observeChatEvents…schedulers.computation())");
                String simpleName6 = ChannelsUpdatedEvent.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName6, "T::class.java.simpleName");
                Disposable subscribe6 = M16.subscribe(channelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1, new ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$2(simpleName6));
                Intrinsics.checkNotNullExpressionValue(subscribe6, "subscribe(\n            {…)\n            }\n        )");
                DisposableKt.addTo(subscribe6, compositeDisposable6);
            }

            public static final /* synthetic */ Disposable access$subscribeToChatEvents(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, String str, CompositeDisposable compositeDisposable, Function2 function2) {
                Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
                MessengerClient messengerClient = channelsBackendNotificationsHandlerImpl.d;
                Intrinsics.reifiedOperationMarker(4, "T");
                Completable subscribeOn = a2.b.a.a.a.Q1(channelsBackendNotificationsHandlerImpl, messengerClient.observeChatEvents(Object.class)).concatMapCompletable(new Function<T, CompletableSource>(str) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToChatEvents$1
                    public final /* synthetic */ String b;

                    {
                        this.b = r2;
                    }

                    @Override // io.reactivex.functions.Function
                    public final CompletableSource apply(@NotNull T t) {
                        Intrinsics.checkNotNullParameter(t, "event");
                        return (CompletableSource) Function2.this.invoke(t, this.b);
                    }
                }).subscribeOn(channelsBackendNotificationsHandlerImpl.h.computation());
                Intrinsics.checkNotNullExpressionValue(subscribeOn, "client.observeChatEvents…schedulers.computation())");
                Intrinsics.reifiedOperationMarker(4, "T");
                String simpleName = Object.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "T::class.java.simpleName");
                Disposable subscribe = subscribeOn.subscribe(ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$1.INSTANCE, new ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$2(simpleName));
                Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(\n            {…)\n            }\n        )");
                return DisposableKt.addTo(subscribe, compositeDisposable);
            }

            public static final Completable access$updateChannelInDbWithInfoFromNewMessage(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, String str, Channel channel, ChatMessage chatMessage) {
                Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
                LocalMessage lastMessage = channel.getLastMessage();
                boolean z = true;
                if (lastMessage == null || lastMessage.created <= chatMessage.getCreated()) {
                    List<User> users = channel.getUsers();
                    ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(users, 10));
                    for (T t : users) {
                        if ((z ^ Intrinsics.areEqual(t.getId(), str)) && Intrinsics.areEqual(t.getId(), chatMessage.getFromId())) {
                            t = (T) User.copy$default(t, null, null, Long.valueOf(TimeUnit.SECONDS.convert(channelsBackendNotificationsHandlerImpl.i.now(), TimeUnit.MILLISECONDS)), null, null, 27, null);
                        }
                        arrayList.add(t);
                        z = true;
                    }
                    boolean z2 = Intrinsics.areEqual(chatMessage.getFromId(), str) || chatMessage.isRead();
                    ChatMessage.PartialChannel channel2 = chatMessage.getChannel();
                    return a2.b.a.a.a.L1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.f.putChannel(str, Channel.copy$default(channel, null, null, null, arrayList, 0, Math.max(channel2 != null ? channel2.getUpdated() : -1, Math.max(chatMessage.getCreated(), channel.getUpdated())), null, null, false, z2, false, false, null, access$determineContextActions(channelsBackendNotificationsHandlerImpl, channel, chatMessage), null, access$determineFlow(channelsBackendNotificationsHandlerImpl, channel, chatMessage), null, null, null, 482775, null)), "channelRepo.putChannel(u…schedulers.computation())");
                }
                Completable complete = Completable.complete();
                Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
                return complete;
            }

            public static final Channel access$withUpdates(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, Channel channel, String str, ChatMessage chatMessage) {
                Objects.requireNonNull(channelsBackendNotificationsHandlerImpl);
                List<User> users = channel.getUsers();
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(users, 10));
                for (T t : users) {
                    if ((!Intrinsics.areEqual(t.getId(), str)) && Intrinsics.areEqual(t.getId(), chatMessage.getFromId())) {
                        t = (T) User.copy$default(t, null, null, Long.valueOf(TimeUnit.SECONDS.convert(channelsBackendNotificationsHandlerImpl.i.now(), TimeUnit.MILLISECONDS)), null, null, 27, null);
                    }
                    arrayList.add(t);
                }
                boolean z = Intrinsics.areEqual(chatMessage.getFromId(), str) || chatMessage.isRead();
                ChatMessage.PartialChannel channel2 = chatMessage.getChannel();
                return Channel.copy$default(channel, null, null, null, arrayList, 0, Math.max(channel2 != null ? channel2.getUpdated() : -1, Math.max(chatMessage.getCreated(), channel.getUpdated())), null, null, false, z, false, false, null, access$determineContextActions(channelsBackendNotificationsHandlerImpl, channel, chatMessage), null, access$determineFlow(channelsBackendNotificationsHandlerImpl, channel, chatMessage), null, null, null, 482775, null);
            }

            @Override // com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandler
            public void subscribeToUserIdAndBackendNotifications() {
                if (this.a.size() == 0) {
                    Disposable subscribe = InteropKt.toV2(this.c.userId()).observeOn(this.h.computation()).distinctUntilChanged().subscribeOn(this.h.computation()).subscribe(new a(this), b.a);
                    Intrinsics.checkNotNullExpressionValue(subscribe, "accountStateProvider.use…      }\n                )");
                    DisposableKt.addTo(subscribe, this.a);
                }
            }
        }
