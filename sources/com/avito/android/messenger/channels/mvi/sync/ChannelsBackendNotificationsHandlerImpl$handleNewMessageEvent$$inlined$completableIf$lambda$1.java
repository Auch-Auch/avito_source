package com.avito.android.messenger.channels.mvi.sync;

import a2.b.a.a.a;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.ChatMessage;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "Larrow/core/Option;", "it", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "apply", "(Larrow/core/Option;)Lio/reactivex/CompletableSource;", "com/avito/android/messenger/channels/mvi/sync/ChannelsBackendNotificationsHandlerImpl$$special$$inlined$flatMapCompletableFold$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsBackendNotificationsHandlerImpl$handleNewMessageEvent$$inlined$completableIf$lambda$1<T, R> implements Function<Option<? extends T>, CompletableSource> {
    public final /* synthetic */ ChannelsBackendNotificationsHandlerImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ChatMessage c;

    public ChannelsBackendNotificationsHandlerImpl$handleNewMessageEvent$$inlined$completableIf$lambda$1(ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl, String str, ChatMessage chatMessage) {
        this.a = channelsBackendNotificationsHandlerImpl;
        this.b = str;
        this.c = chatMessage;
    }

    public final CompletableSource apply(@NotNull Option<? extends T> option) {
        Completable completable;
        Intrinsics.checkNotNullParameter(option, "it");
        if (option instanceof None) {
            ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl = this.a;
            String str = this.b;
            Single<R> map = a.U1(channelsBackendNotificationsHandlerImpl, channelsBackendNotificationsHandlerImpl.d.getChannel(this.c.getChannelId())).map(new ChannelsBackendNotificationsHandlerKt$sam$i$io_reactivex_functions_Function$0(new 1(channelsBackendNotificationsHandlerImpl.e)));
            Intrinsics.checkNotNullExpressionValue(map, "client.getChannel(channe…onverter::convertChannel)");
            Completable flatMapCompletable = map.flatMapCompletable((Function) new 2(channelsBackendNotificationsHandlerImpl, str));
            Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "getChannelFromServer(new…newChannel)\n            }");
            return flatMapCompletable;
        } else if (option instanceof Some) {
            Channel channel = (Channel) ((Some) option).getT();
            ChannelsBackendNotificationsHandlerImpl channelsBackendNotificationsHandlerImpl2 = this.a;
            String str2 = this.b;
            ChatMessage chatMessage = this.c;
            LocalMessage lastMessage = channel.getLastMessage();
            boolean z = true;
            if (lastMessage == null || lastMessage.created <= chatMessage.getCreated()) {
                List<User> users = channel.getUsers();
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(users, 10));
                for (T t : users) {
                    if ((z ^ Intrinsics.areEqual(t.getId(), str2)) && Intrinsics.areEqual(t.getId(), chatMessage.getFromId())) {
                        t = (T) User.copy$default(t, null, null, Long.valueOf(TimeUnit.SECONDS.convert(channelsBackendNotificationsHandlerImpl2.i.now(), TimeUnit.MILLISECONDS)), null, null, 27, null);
                    }
                    arrayList.add(t);
                    z = true;
                }
                boolean z2 = Intrinsics.areEqual(chatMessage.getFromId(), str2) || chatMessage.isRead();
                ChatMessage.PartialChannel channel2 = chatMessage.getChannel();
                completable = a.L1(channelsBackendNotificationsHandlerImpl2, channelsBackendNotificationsHandlerImpl2.f.putChannel(str2, Channel.copy$default(channel, null, null, null, arrayList, 0, Math.max(channel2 != null ? channel2.getUpdated() : -1, Math.max(chatMessage.getCreated(), channel.getUpdated())), null, null, false, z2, false, false, null, ChannelsBackendNotificationsHandlerImpl.access$determineContextActions(channelsBackendNotificationsHandlerImpl2, channel, chatMessage), null, ChannelsBackendNotificationsHandlerImpl.access$determineFlow(channelsBackendNotificationsHandlerImpl2, channel, chatMessage), null, null, null, 482775, null)), "channelRepo.putChannel(u…schedulers.computation())");
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
}
