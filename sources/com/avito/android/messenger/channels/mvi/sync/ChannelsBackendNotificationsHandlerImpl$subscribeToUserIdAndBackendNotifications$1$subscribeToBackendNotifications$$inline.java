package com.avito.android.messenger.channels.mvi.sync;

import a2.b.a.a.a;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeWriteLock;
import com.avito.android.messenger.channels.mvi.sync.ChannelsKey;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.ChatMessage;
import t6.n.e;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "T", "event", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "apply", "(Ljava/lang/Object;)Lio/reactivex/CompletableSource;", "com/avito/android/messenger/channels/mvi/sync/ChannelsBackendNotificationsHandlerImpl$subscribeToChatEvents$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsBackendNotificationsHandlerImpl$subscribeToUserIdAndBackendNotifications$1$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5<T, R> implements Function<T, CompletableSource> {
    public final /* synthetic */ String a;
    public final /* synthetic */ ChannelsBackendNotificationsHandlerImpl b;

    public ChannelsBackendNotificationsHandlerImpl$subscribeToUserIdAndBackendNotifications$1$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5(String str, ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl) {
        this.a = str;
        this.b = channelsBackendNotificationsHandlerImpl;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: io.reactivex.Completable */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final CompletableSource apply(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "event");
        String str = this.a;
        ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl = this.b;
        ChatMessage message = t.getMessage();
        if (Intrinsics.areEqual(message.getUid(), str)) {
            Observable<Option<Channel>> observeOn = channelsBackendNotificationsHandlerImpl.f.getChannel(str, message.getChannelId()).observeOn(channelsBackendNotificationsHandlerImpl.h.computation());
            Intrinsics.checkNotNullExpressionValue(observeOn, "channelRepo.getChannel(\n…schedulers.computation())");
            Single<Option<Channel>> onErrorReturn = observeOn.firstOrError().onErrorReturn(ChannelsBackendNotificationsHandlerImpl$subscribeToUserIdAndBackendNotifications$1$getChannelFromDb$$inlined$firstOrNone$2.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "firstOrError().onErrorReturn { none() }");
            Completable flatMapCompletable = onErrorReturn.flatMapCompletable(new Function<Option<? extends T>, CompletableSource>(channelsBackendNotificationsHandlerImpl, str, message) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToUserIdAndBackendNotifications$1$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5$lambda$1
                public final /* synthetic */ ChannelsBackendNotificationsHandlerImpl a;
                public final /* synthetic */ String b;
                public final /* synthetic */ ChatMessage c;

                {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                }

                public final CompletableSource apply(@NotNull Option<? extends T> option) {
                    Completable completable;
                    Intrinsics.checkNotNullParameter(option, "it");
                    if (option instanceof None) {
                        final ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl2 = this.a;
                        final String str2 = this.b;
                        Single<R> map = a.U1(channelsBackendNotificationsHandlerImpl2, channelsBackendNotificationsHandlerImpl2.d.getChannel(this.c.getChannelId())).map(new ChannelsBackendNotificationsHandlerKt$sam$i$io_reactivex_functions_Function$0(new Function1<ru.avito.messenger.api.entity.Channel, Channel>(channelsBackendNotificationsHandlerImpl2.e) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToUserIdAndBackendNotifications$1$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5$lambda$1.1
                            @NotNull
                            public final Channel invoke(@NotNull ru.avito.messenger.api.entity.Channel channel) {
                                Intrinsics.checkNotNullParameter(channel, "p1");
                                return ((MessengerEntityConverter) this.receiver).convertChannel(channel);
                            }
                        }));
                        Intrinsics.checkNotNullExpressionValue(map, "client.getChannel(channe…onverter::convertChannel)");
                        Completable flatMapCompletable2 = map.flatMapCompletable(new Function<Channel, CompletableSource>() { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandlerImpl$subscribeToUserIdAndBackendNotifications$1$subscribeToBackendNotifications$$inlined$subscribeToChatEvents$5$lambda$1.2
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
                        ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl3 = this.a;
                        String str3 = this.b;
                        ChatMessage chatMessage = this.c;
                        LocalMessage lastMessage = channel.getLastMessage();
                        boolean z = true;
                        if (lastMessage == null || lastMessage.created <= chatMessage.getCreated()) {
                            List<User> users = channel.getUsers();
                            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(users, 10));
                            for (T t2 : users) {
                                if ((z ^ Intrinsics.areEqual(t2.getId(), str3)) && Intrinsics.areEqual(t2.getId(), chatMessage.getFromId())) {
                                    t2 = (T) User.copy$default(t2, null, null, Long.valueOf(TimeUnit.SECONDS.convert(channelsBackendNotificationsHandlerImpl3.i.now(), TimeUnit.MILLISECONDS)), null, null, 27, null);
                                }
                                arrayList.add(t2);
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
            Single<T> singleDefault = flatMapCompletable.toSingleDefault(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(singleDefault, "this.toSingleDefault(Unit)");
            Completable ignoreElement = rxFairCompositeWriteLock.callSingle(singleDefault, "handleNewMessageEvent", of, computation).ignoreElement();
            Intrinsics.checkNotNullExpressionValue(ignoreElement, "lock.callSingle(\n       …ler\n    ).ignoreElement()");
            return ignoreElement;
        }
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }
}
