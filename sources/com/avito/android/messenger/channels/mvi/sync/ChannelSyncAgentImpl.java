package com.avito.android.messenger.channels.mvi.sync;

import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeWriteLock;
import com.avito.android.messenger.channels.mvi.data.ChannelRepo;
import com.avito.android.messenger.channels.mvi.data.DraftRepoWriter;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.channels.mvi.sync.ChannelsKey;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.RxLogger;
import com.avito.android.util.RxLoggerDelegate;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.Channel;
import t6.n.x;
import t6.o.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002Bk\u0012\u0006\u0010I\u001a\u00020F\u0012\f\u0010`\u001a\b\u0012\u0004\u0012\u00020]0\\\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010M\u001a\u00020J\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010Q\u001a\u00020N\u0012\u0006\u0010B\u001a\u00020?\u0012\f\u0010>\u001a\b\u0012\u0004\u0012\u00020;0:\u0012\u0006\u0010W\u001a\u00020\u0019\u0012\u0006\u0010E\u001a\u00020\u0019¢\u0006\u0004\ba\u0010bBO\b\u0017\u0012\u0006\u0010I\u001a\u00020F\u0012\f\u0010`\u001a\b\u0012\u0004\u0012\u00020]0\\\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010M\u001a\u00020J\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010Q\u001a\u00020N\u0012\u0006\u0010B\u001a\u00020?¢\u0006\u0004\ba\u0010cB_\b\u0016\u0012\u0006\u0010I\u001a\u00020F\u0012\f\u0010`\u001a\b\u0012\u0004\u0012\u00020]0\\\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010M\u001a\u00020J\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010Q\u001a\u00020N\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010W\u001a\u00020\u0019\u0012\u0006\u0010E\u001a\u00020\u0019¢\u0006\u0004\ba\u0010dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018JA\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0012J\u001f\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u0012J/\u0010 \u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\u0012J\u001c\u0010$\u001a\u00020\u0010*\u00020\u00102\u0006\u0010#\u001a\u00020\u0006H\u0001¢\u0006\u0004\b$\u0010%J.\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000'\"\u0004\b\u0000\u0010&*\b\u0012\u0004\u0012\u00028\u00000'2\u0006\u0010#\u001a\u00020\u0006H\u0001¢\u0006\u0004\b$\u0010(J.\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010&*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010#\u001a\u00020\u0006H\u0001¢\u0006\u0004\b$\u0010)R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020;0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010DR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u001c\u0010`\u001a\b\u0012\u0004\u0012\u00020]0\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_¨\u0006e"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgentImpl;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "Lcom/avito/android/util/RxLogger;", "", "subscribeToUserIdAndBackendNotifications", "()V", "", ChannelContext.Item.USER_ID, "itemId", "source", "Lio/reactivex/Single;", "createChat", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "createAvitoChat", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "channelId", "Lio/reactivex/Completable;", "syncChat", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "Ljava/util/SortedSet;", "tags", "excludeTags", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent$SyncChatsResult;", "syncLatestChats", "(Ljava/lang/String;Ljava/util/SortedSet;Ljava/util/SortedSet;)Lio/reactivex/Single;", "", "currentOffset", "syncNextPage", "(Ljava/lang/String;ILjava/util/SortedSet;Ljava/util/SortedSet;)Lio/reactivex/Single;", "deleteChatAndDraftFromEverywhere", "deleteChatAndDraftFromDb", "interlocutorId", "deleteChatAndAllDraftsWithInterlocutorFromDb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "deleteContextActions", "message", "log", "(Lio/reactivex/Completable;Ljava/lang/String;)Lio/reactivex/Completable;", "T", "Lio/reactivex/Observable;", "(Lio/reactivex/Observable;Ljava/lang/String;)Lio/reactivex/Observable;", "(Lio/reactivex/Single;Ljava/lang/String;)Lio/reactivex/Single;", "Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;", "h", "Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;", "draftRepoWriter", "Lcom/avito/android/messenger/channels/mvi/sync/LocalChannelEditorImpl;", "c", "Lcom/avito/android/messenger/channels/mvi/sync/LocalChannelEditorImpl;", "localChannelEditor", "Lcom/avito/android/Features;", "i", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelsBackendNotificationsHandlerImpl;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/channels/mvi/sync/ChannelsBackendNotificationsHandlerImpl;", "backendNotificationsHandler", "Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelsKey;", "l", "Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock;", "lock", "Lcom/avito/android/server_time/TimeSource;", "k", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "n", "I", "pageSize", "Lcom/avito/android/account/AccountStateProvider;", "d", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;", a2.g.r.g.a, "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;", "channelRepo", "Lcom/avito/android/util/SchedulersFactory;", "j", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/messenger/channels/mvi/sync/ChatAndDraftEraserImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/channels/mvi/sync/ChatAndDraftEraserImpl;", "chatAndDraftEraser", AuthSource.OPEN_CHANNEL_LIST, "initialRequestSize", "Lcom/avito/android/messenger/MessengerEntityConverter;", "f", "Lcom/avito/android/messenger/MessengerEntityConverter;", "messengerEntityConverter", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "e", "Lru/avito/messenger/MessengerClient;", "client", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/MessengerEntityConverter;Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock;II)V", "(Lcom/avito/android/account/AccountStateProvider;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/MessengerEntityConverter;Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/server_time/TimeSource;)V", "(Lcom/avito/android/account/AccountStateProvider;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/MessengerEntityConverter;Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/server_time/TimeSource;II)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelSyncAgentImpl implements ChannelSyncAgent, RxLogger {
    public final ChatAndDraftEraserImpl a;
    public final ChannelsBackendNotificationsHandlerImpl b;
    public final LocalChannelEditorImpl c;
    public final AccountStateProvider d;
    public final MessengerClient<AvitoMessengerApi> e;
    public final MessengerEntityConverter f;
    public final ChannelRepo g;
    public final DraftRepoWriter h;
    public final Features i;
    public final SchedulersFactory j;
    public final TimeSource k;
    public final RxFairCompositeWriteLock<ChannelsKey> l;
    public final int m;
    public final int n;
    public final /* synthetic */ RxLoggerDelegate o;

    public static final class a extends Lambda implements Function0<Scheduler> {
        public final /* synthetic */ SchedulersFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SchedulersFactory schedulersFactory) {
            super(0);
            this.a = schedulersFactory;
        }

        @Override // kotlin.jvm.functions.Function0
        public Scheduler invoke() {
            return this.a.io();
        }
    }

    public static final class b extends Lambda implements Function0<Scheduler> {
        public final /* synthetic */ SchedulersFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SchedulersFactory schedulersFactory) {
            super(0);
            this.a = schedulersFactory;
        }

        @Override // kotlin.jvm.functions.Function0
        public Scheduler invoke() {
            return this.a.io();
        }
    }

    public static final class c<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends Channel>> {
        public final /* synthetic */ ChannelSyncAgentImpl a;
        public final /* synthetic */ String b;

        public c(ChannelSyncAgentImpl channelSyncAgentImpl, String str) {
            this.a = channelSyncAgentImpl;
            this.b = str;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Channel> apply(AvitoMessengerApi avitoMessengerApi) {
            AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
            Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
            return avitoMessengerApi2.createChatWithAvito(this.b).observeOn(this.a.j.computation());
        }
    }

    public static final class d<T, R> implements Function<Channel, SingleSource<? extends String>> {
        public final /* synthetic */ ChannelSyncAgentImpl a;
        public final /* synthetic */ String b;

        public d(ChannelSyncAgentImpl channelSyncAgentImpl, String str) {
            this.a = channelSyncAgentImpl;
            this.b = str;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends String> apply(Channel channel) {
            Channel channel2 = channel;
            Intrinsics.checkNotNullParameter(channel2, "channel");
            return this.a.g.putChannel(this.b, this.a.f.convertChannel(channel2)).observeOn(this.a.j.computation()).andThen(Singles.toSingle(channel2.getChannelId()));
        }
    }

    public static final class e<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends Channel>> {
        public final /* synthetic */ ChannelSyncAgentImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public e(ChannelSyncAgentImpl channelSyncAgentImpl, String str, String str2) {
            this.a = channelSyncAgentImpl;
            this.b = str;
            this.c = str2;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Channel> apply(AvitoMessengerApi avitoMessengerApi) {
            AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
            Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
            return avitoMessengerApi2.createChat(this.b, this.c).observeOn(this.a.j.computation());
        }
    }

    public static final class f<T, R> implements Function<Channel, SingleSource<? extends String>> {
        public final /* synthetic */ ChannelSyncAgentImpl a;
        public final /* synthetic */ String b;

        public f(ChannelSyncAgentImpl channelSyncAgentImpl, String str) {
            this.a = channelSyncAgentImpl;
            this.b = str;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends String> apply(Channel channel) {
            Channel channel2 = channel;
            Intrinsics.checkNotNullParameter(channel2, "channel");
            return this.a.g.putChannel(this.b, this.a.f.convertChannel(channel2)).observeOn(this.a.j.computation()).andThen(Singles.toSingle(channel2.getChannelId()));
        }
    }

    public static final class g<T, R> implements Function<Channel, CompletableSource> {
        public final /* synthetic */ ChannelSyncAgentImpl a;
        public final /* synthetic */ String b;

        public g(ChannelSyncAgentImpl channelSyncAgentImpl, String str) {
            this.a = channelSyncAgentImpl;
            this.b = str;
        }

        @Override // io.reactivex.functions.Function
        public CompletableSource apply(Channel channel) {
            Channel channel2 = channel;
            Intrinsics.checkNotNullParameter(channel2, "channel");
            ChannelSyncAgentImpl channelSyncAgentImpl = this.a;
            String str = this.b;
            Completable K1 = a2.b.a.a.a.K1(channelSyncAgentImpl, channelSyncAgentImpl.g.putChannel(str, channelSyncAgentImpl.f.convertChannel(channel2)), "channelRepo.putChannel(\n…schedulers.computation())");
            StringBuilder R = a2.b.a.a.a.R(" -> putChannelInDb(userId = ", str, ", newChannel = ");
            R.append(channel2.getChannelId());
            R.append(')');
            return channelSyncAgentImpl.log(K1, R.toString());
        }
    }

    public static final class h<T, R> implements Function<List<? extends Channel>, SingleSource<? extends ChannelSyncAgent.SyncChatsResult>> {
        public final /* synthetic */ ChannelSyncAgentImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ SortedSet c;
        public final /* synthetic */ SortedSet d;

        public h(ChannelSyncAgentImpl channelSyncAgentImpl, String str, SortedSet sortedSet, SortedSet sortedSet2) {
            this.a = channelSyncAgentImpl;
            this.b = str;
            this.c = sortedSet;
            this.d = sortedSet2;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ChannelSyncAgent.SyncChatsResult> apply(List<? extends Channel> list) {
            List<? extends Channel> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "chatsFromServer");
            ChannelSyncAgentImpl channelSyncAgentImpl = this.a;
            String str = this.b;
            int i = channelSyncAgentImpl.m;
            SortedSet sortedSet = this.c;
            SortedSet sortedSet2 = this.d;
            if (list2.isEmpty()) {
                Single<T> flatMap = ChannelSyncAgentImpl.access$getOldestSyncedChatTimestamp(channelSyncAgentImpl, str, list2, 0, sortedSet, sortedSet2).flatMap(new ChannelSyncAgentImpl$syncEmptyPageOfChatsFromServerWithDb$1(channelSyncAgentImpl, str, sortedSet, sortedSet2));
                Intrinsics.checkNotNullExpressionValue(flatMap, "getOldestSyncedChatTimes…          )\n            }");
                StringBuilder sb = new StringBuilder();
                sb.append(" -> syncEmptyPageOfChatsFromServerWithDb(userId = ");
                sb.append(str);
                sb.append(", chatsFromServer = (");
                a2.b.a.a.a.t1(list2, sb, ")[...], offset = ", 0, ", tags = ");
                return channelSyncAgentImpl.log(flatMap, a2.b.a.a.a.z(sb, sortedSet, ", excludeTags = ", sortedSet2, ')'));
            } else if (list2.size() < i) {
                MessengerEntityConverter messengerEntityConverter = channelSyncAgentImpl.f;
                ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list2, 10));
                for (Iterator<T> it = list2.iterator(); it.hasNext(); it = it) {
                    arrayList.add(messengerEntityConverter.convertChannel(it.next()));
                }
                Completable K1 = a2.b.a.a.a.K1(channelSyncAgentImpl, channelSyncAgentImpl.g.putChannels(str, arrayList), "chatsFromServer.map(mess…schedulers.computation())");
                StringBuilder R = a2.b.a.a.a.R(" -> putChatsFromServerInDb(userId = ", str, ", chatsFromServer = (");
                R.append(list2.size());
                R.append(")[...])");
                Completable log = channelSyncAgentImpl.log(K1, R.toString());
                String str2 = ", excludeTags = ";
                Single W1 = a2.b.a.a.a.W1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str, 0, i, (Collection<String>) sortedSet, (Collection<String>) sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$1.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
                StringBuilder S = a2.b.a.a.a.S(" -> getNonEmptyChatIdsFromDb(userId = ", str, ", offset = ", 0, ", requestSize = ");
                a2.b.a.a.a.h1(S, i, ", tags = ", sortedSet, str2);
                Completable flatMapCompletable = a2.b.a.a.a.Y1(S, sortedSet2, ')', channelSyncAgentImpl, W1).flatMapCompletable(new ChannelSyncAgentImpl$deleteChatsThatDoNotMatchTheOnesOnServerFromDb$1(channelSyncAgentImpl, str, list2));
                Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "getNonEmptyChatIdsFromDb…          )\n            }");
                String str3 = ", chatsFromServer = (";
                StringBuilder R2 = a2.b.a.a.a.R(" -> deleteChatsThatDoNotMatchTheOnesOnServerFromDb(userId = ", str, str3);
                String str4 = ")[...], offset = ";
                a2.b.a.a.a.t1(list2, R2, str4, 0, ", requestSize = ");
                a2.b.a.a.a.h1(R2, i, ", tags = ", sortedSet, str2);
                Completable andThen = log.andThen(a2.b.a.a.a.O1(R2, sortedSet2, ')', channelSyncAgentImpl, flatMapCompletable));
                long j = Long.MIN_VALUE;
                for (Iterator<T> it2 = list2.iterator(); it2.hasNext(); it2 = it2) {
                    j = t6.v.e.coerceAtLeast(j, it2.next().getUpdated());
                    str3 = str3;
                }
                Completable deleteNonEmptyChannelsNewerThatTimestamp = channelSyncAgentImpl.g.deleteNonEmptyChannelsNewerThatTimestamp(str, j, sortedSet, sortedSet2);
                StringBuilder R3 = a2.b.a.a.a.R(" -> deleteNewerDeprecatedChats(userId = ", str, str3);
                a2.b.a.a.a.v1(list2, R3, ")[...], tags = ", sortedSet, str2);
                Completable andThen2 = andThen.andThen(a2.b.a.a.a.O1(R3, sortedSet2, ')', channelSyncAgentImpl, deleteNonEmptyChannelsNewerThatTimestamp));
                long j2 = Long.MIN_VALUE;
                for (Iterator<T> it3 = list2.iterator(); it3.hasNext(); it3 = it3) {
                    j2 = t6.v.e.coerceAtLeast(j2, it3.next().getUpdated());
                }
                Iterator<T> it4 = list2.iterator();
                long j3 = Long.MAX_VALUE;
                while (it4.hasNext()) {
                    j3 = t6.v.e.coerceAtMost(j3, it4.next().getUpdated());
                    str2 = str2;
                    str4 = str4;
                }
                Single<T> X1 = a2.b.a.a.a.X1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str, j2, j3, sortedSet, sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$2.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
                StringBuilder T = a2.b.a.a.a.T(" -> getNonEmptyChatIdsFromDb(userId = ", str, ", olderOrEqualToTimestamp = ", j2);
                a2.b.a.a.a.l1(T, ", newerOrEqualToTimestamp = ", j3, ", tags = ");
                Completable flatMapCompletable2 = channelSyncAgentImpl.log(X1, a2.b.a.a.a.z(T, sortedSet, str2, sortedSet2, ')')).flatMapCompletable(new ChannelSyncAgentImpl$deleteDeprecatedChatsInTheMiddle$3(channelSyncAgentImpl, str, list2));
                Intrinsics.checkNotNullExpressionValue(flatMapCompletable2, "getNonEmptyChatIdsFromDb…          )\n            }");
                StringBuilder R4 = a2.b.a.a.a.R(" -> deleteDeprecatedChatsInTheMiddle(userId = ", str, str3);
                a2.b.a.a.a.v1(list2, R4, ")[...], tags = ", sortedSet, str2);
                Completable andThen3 = andThen2.andThen(a2.b.a.a.a.O1(R4, sortedSet2, ')', channelSyncAgentImpl, flatMapCompletable2));
                Intrinsics.checkNotNullExpressionValue(andThen3, "putChatsFromServerInDb(\n…          )\n            )");
                Single<R> flatMap2 = andThen3.toSingleDefault(Unit.INSTANCE).flatMap(new ChannelSyncAgentImpl$syncLatestChats$1$syncPartialPageOfChatsFromServerWithDb$$inlined$flatMapSingle$1(channelSyncAgentImpl, str, list2, 0, sortedSet, sortedSet2));
                Intrinsics.checkNotNullExpressionValue(flatMap2, "toSingleDefault(Unit).flatMap { singleFactory() }");
                Single<R> flatMap3 = flatMap2.flatMap(new ChannelSyncAgentImpl$syncPartialPageOfChatsFromServerWithDb$3(channelSyncAgentImpl, str, sortedSet, sortedSet2));
                Intrinsics.checkNotNullExpressionValue(flatMap3, "putChatsFromServerInDb(\n…          )\n            }");
                StringBuilder R5 = a2.b.a.a.a.R(" -> syncPartialPageOfChatsFromServerWithDb(userId = ", str, str3);
                a2.b.a.a.a.t1(list2, R5, str4, 0, ", requestSize = ");
                a2.b.a.a.a.h1(R5, i, ", tags = ", sortedSet, str2);
                return a2.b.a.a.a.Y1(R5, sortedSet2, ')', channelSyncAgentImpl, flatMap3);
            } else {
                SortedSet sortedSet3 = sortedSet2;
                List<? extends Channel> list3 = list2;
                MessengerEntityConverter messengerEntityConverter2 = channelSyncAgentImpl.f;
                ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(list3, 10));
                for (Iterator<T> it5 = list3.iterator(); it5.hasNext(); it5 = it5) {
                    arrayList2.add(messengerEntityConverter2.convertChannel(it5.next()));
                }
                Completable K12 = a2.b.a.a.a.K1(channelSyncAgentImpl, channelSyncAgentImpl.g.putChannels(str, arrayList2), "chatsFromServer.map(mess…schedulers.computation())");
                StringBuilder R6 = a2.b.a.a.a.R(" -> putChatsFromServerInDb(userId = ", str, ", chatsFromServer = (");
                R6.append(list3.size());
                R6.append(")[...])");
                Completable log2 = channelSyncAgentImpl.log(K12, R6.toString());
                Single W12 = a2.b.a.a.a.W1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str, 0, i, (Collection<String>) sortedSet, (Collection<String>) sortedSet3)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$1.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
                StringBuilder S2 = a2.b.a.a.a.S(" -> getNonEmptyChatIdsFromDb(userId = ", str, ", offset = ", 0, ", requestSize = ");
                a2.b.a.a.a.h1(S2, i, ", tags = ", sortedSet, ", excludeTags = ");
                Completable flatMapCompletable3 = a2.b.a.a.a.Y1(S2, sortedSet3, ')', channelSyncAgentImpl, W12).flatMapCompletable(new ChannelSyncAgentImpl$deleteChatsThatDoNotMatchTheOnesOnServerFromDb$1(channelSyncAgentImpl, str, list3));
                Intrinsics.checkNotNullExpressionValue(flatMapCompletable3, "getNonEmptyChatIdsFromDb…          )\n            }");
                StringBuilder R7 = a2.b.a.a.a.R(" -> deleteChatsThatDoNotMatchTheOnesOnServerFromDb(userId = ", str, ", chatsFromServer = (");
                a2.b.a.a.a.t1(list3, R7, ")[...], offset = ", 0, ", requestSize = ");
                a2.b.a.a.a.h1(R7, i, ", tags = ", sortedSet, ", excludeTags = ");
                Completable andThen4 = log2.andThen(a2.b.a.a.a.O1(R7, sortedSet3, ')', channelSyncAgentImpl, flatMapCompletable3));
                long j4 = Long.MIN_VALUE;
                for (Iterator<T> it6 = list3.iterator(); it6.hasNext(); it6 = it6) {
                    j4 = t6.v.e.coerceAtLeast(j4, it6.next().getUpdated());
                }
                Completable deleteNonEmptyChannelsNewerThatTimestamp2 = channelSyncAgentImpl.g.deleteNonEmptyChannelsNewerThatTimestamp(str, j4, sortedSet, sortedSet3);
                StringBuilder R8 = a2.b.a.a.a.R(" -> deleteNewerDeprecatedChats(userId = ", str, ", chatsFromServer = (");
                a2.b.a.a.a.v1(list3, R8, ")[...], tags = ", sortedSet, ", excludeTags = ");
                Completable andThen5 = andThen4.andThen(a2.b.a.a.a.O1(R8, sortedSet3, ')', channelSyncAgentImpl, deleteNonEmptyChannelsNewerThatTimestamp2));
                Iterator<T> it7 = list3.iterator();
                long j5 = Long.MIN_VALUE;
                while (it7.hasNext()) {
                    j5 = t6.v.e.coerceAtLeast(j5, it7.next().getUpdated());
                }
                Iterator<T> it8 = list3.iterator();
                long j6 = Long.MAX_VALUE;
                while (it8.hasNext()) {
                    j6 = t6.v.e.coerceAtMost(j6, it8.next().getUpdated());
                    list3 = list3;
                    sortedSet3 = sortedSet3;
                }
                Single<T> X12 = a2.b.a.a.a.X1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str, j5, j6, sortedSet, sortedSet3)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$2.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
                StringBuilder T2 = a2.b.a.a.a.T(" -> getNonEmptyChatIdsFromDb(userId = ", str, ", olderOrEqualToTimestamp = ", j5);
                a2.b.a.a.a.l1(T2, ", newerOrEqualToTimestamp = ", j6, ", tags = ");
                Completable flatMapCompletable4 = channelSyncAgentImpl.log(X12, a2.b.a.a.a.z(T2, sortedSet, ", excludeTags = ", sortedSet3, ')')).flatMapCompletable(new ChannelSyncAgentImpl$deleteDeprecatedChatsInTheMiddle$3(channelSyncAgentImpl, str, list3));
                Intrinsics.checkNotNullExpressionValue(flatMapCompletable4, "getNonEmptyChatIdsFromDb…          )\n            }");
                StringBuilder R9 = a2.b.a.a.a.R(" -> deleteDeprecatedChatsInTheMiddle(userId = ", str, ", chatsFromServer = (");
                a2.b.a.a.a.v1(list3, R9, ")[...], tags = ", sortedSet, ", excludeTags = ");
                Completable andThen6 = andThen5.andThen(a2.b.a.a.a.O1(R9, sortedSet3, ')', channelSyncAgentImpl, flatMapCompletable4));
                Intrinsics.checkNotNullExpressionValue(andThen6, "putChatsFromServerInDb(\n…          )\n            )");
                Single<R> flatMap4 = andThen6.toSingleDefault(Unit.INSTANCE).flatMap(new ChannelSyncAgentImpl$syncLatestChats$1$syncFullPageOfChatsFromServerWithDb$$inlined$flatMapSingle$1(channelSyncAgentImpl, str, list3, 0, sortedSet, sortedSet3));
                Intrinsics.checkNotNullExpressionValue(flatMap4, "toSingleDefault(Unit).flatMap { singleFactory() }");
                Single<R> map = flatMap4.map(ChannelSyncAgentImpl$syncFullPageOfChatsFromServerWithDb$3.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(map, "putChatsFromServerInDb(\n…          )\n            }");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" -> syncFullPageOfChatsFromServerWithDb(userId = ");
                sb2.append(str);
                sb2.append(", chatsFromServer = (");
                a2.b.a.a.a.t1(list3, sb2, ")[...], offset = ", 0, ", requestSize = ");
                a2.b.a.a.a.h1(sb2, i, ", tags = ", sortedSet, ", excludeTags = ");
                return a2.b.a.a.a.Y1(sb2, sortedSet3, ')', channelSyncAgentImpl, map);
            }
        }
    }

    public static final class i<T, R> implements Function<List<? extends Channel>, SingleSource<? extends ChannelSyncAgent.SyncChatsResult>> {
        public final /* synthetic */ ChannelSyncAgentImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ SortedSet d;
        public final /* synthetic */ SortedSet e;

        public i(ChannelSyncAgentImpl channelSyncAgentImpl, String str, int i, SortedSet sortedSet, SortedSet sortedSet2) {
            this.a = channelSyncAgentImpl;
            this.b = str;
            this.c = i;
            this.d = sortedSet;
            this.e = sortedSet2;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ChannelSyncAgent.SyncChatsResult> apply(List<? extends Channel> list) {
            int i;
            int i2;
            String str;
            String str2;
            String str3;
            String str4;
            int i3;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            List<? extends Channel> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "chatsFromServer");
            ChannelSyncAgentImpl channelSyncAgentImpl = this.a;
            String str11 = this.b;
            int i4 = this.c;
            int i5 = channelSyncAgentImpl.n;
            SortedSet sortedSet = this.d;
            SortedSet sortedSet2 = this.e;
            if (list2.isEmpty()) {
                Single<T> flatMap = ChannelSyncAgentImpl.access$getOldestSyncedChatTimestamp(channelSyncAgentImpl, str11, list2, i4, sortedSet, sortedSet2).flatMap(new ChannelSyncAgentImpl$syncEmptyPageOfChatsFromServerWithDb$1(channelSyncAgentImpl, str11, sortedSet, sortedSet2));
                Intrinsics.checkNotNullExpressionValue(flatMap, "getOldestSyncedChatTimes…          )\n            }");
                StringBuilder sb = new StringBuilder();
                sb.append(" -> syncEmptyPageOfChatsFromServerWithDb(userId = ");
                sb.append(str11);
                sb.append(", chatsFromServer = (");
                a2.b.a.a.a.t1(list2, sb, ")[...], offset = ", i4, ", tags = ");
                return channelSyncAgentImpl.log(flatMap, a2.b.a.a.a.z(sb, sortedSet, ", excludeTags = ", sortedSet2, ')'));
            }
            boolean z = true;
            if (list2.size() < i5) {
                MessengerEntityConverter messengerEntityConverter = channelSyncAgentImpl.f;
                ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list2, 10));
                for (Iterator<T> it = list2.iterator(); it.hasNext(); it = it) {
                    arrayList.add(messengerEntityConverter.convertChannel(it.next()));
                }
                Completable K1 = a2.b.a.a.a.K1(channelSyncAgentImpl, channelSyncAgentImpl.g.putChannels(str11, arrayList), "chatsFromServer.map(mess…schedulers.computation())");
                StringBuilder R = a2.b.a.a.a.R(" -> putChatsFromServerInDb(userId = ", str11, ", chatsFromServer = (");
                R.append(list2.size());
                R.append(")[...])");
                Completable log = channelSyncAgentImpl.log(K1, R.toString());
                String str12 = ", excludeTags = ";
                Single W1 = a2.b.a.a.a.W1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str11, i4, i5, (Collection<String>) sortedSet, (Collection<String>) sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$1.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
                StringBuilder S = a2.b.a.a.a.S(" -> getNonEmptyChatIdsFromDb(userId = ", str11, ", offset = ", i4, ", requestSize = ");
                a2.b.a.a.a.h1(S, i5, ", tags = ", sortedSet, str12);
                Completable flatMapCompletable = a2.b.a.a.a.Y1(S, sortedSet2, ')', channelSyncAgentImpl, W1).flatMapCompletable(new ChannelSyncAgentImpl$deleteChatsThatDoNotMatchTheOnesOnServerFromDb$1(channelSyncAgentImpl, str11, list2));
                Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "getNonEmptyChatIdsFromDb…          )\n            }");
                StringBuilder R2 = a2.b.a.a.a.R(" -> deleteChatsThatDoNotMatchTheOnesOnServerFromDb(userId = ", str11, ", chatsFromServer = (");
                String str13 = ")[...], offset = ";
                a2.b.a.a.a.t1(list2, R2, str13, i4, ", requestSize = ");
                a2.b.a.a.a.h1(R2, i5, ", tags = ", sortedSet, str12);
                Completable andThen = log.andThen(a2.b.a.a.a.O1(R2, sortedSet2, ')', channelSyncAgentImpl, flatMapCompletable));
                if (i4 != 0) {
                    z = false;
                }
                if (z) {
                    long j = Long.MIN_VALUE;
                    for (Iterator<T> it2 = list2.iterator(); it2.hasNext(); it2 = it2) {
                        j = t6.v.e.coerceAtLeast(j, it2.next().getUpdated());
                    }
                    i3 = i4;
                    str9 = ", chatsFromServer = (";
                    str7 = "getNonEmptyChatIdsFromDb…          )\n            }";
                    str8 = ", tags = ";
                    str6 = ", requestSize = ";
                    str5 = " -> getNonEmptyChatIdsFromDb(userId = ";
                    Completable deleteNonEmptyChannelsNewerThatTimestamp = channelSyncAgentImpl.g.deleteNonEmptyChannelsNewerThatTimestamp(str11, j, sortedSet, sortedSet2);
                    StringBuilder R3 = a2.b.a.a.a.R(" -> deleteNewerDeprecatedChats(userId = ", str11, str9);
                    str10 = ")[...], tags = ";
                    a2.b.a.a.a.v1(list2, R3, str10, sortedSet, str12);
                    andThen = andThen.andThen(a2.b.a.a.a.O1(R3, sortedSet2, ')', channelSyncAgentImpl, deleteNonEmptyChannelsNewerThatTimestamp));
                } else {
                    str8 = ", tags = ";
                    str6 = ", requestSize = ";
                    str5 = " -> getNonEmptyChatIdsFromDb(userId = ";
                    i3 = i4;
                    str9 = ", chatsFromServer = (";
                    str10 = ")[...], tags = ";
                    str7 = "getNonEmptyChatIdsFromDb…          )\n            }";
                }
                long j2 = Long.MIN_VALUE;
                for (Iterator<T> it3 = list2.iterator(); it3.hasNext(); it3 = it3) {
                    j2 = t6.v.e.coerceAtLeast(j2, it3.next().getUpdated());
                }
                Iterator<T> it4 = list2.iterator();
                long j3 = Long.MAX_VALUE;
                while (it4.hasNext()) {
                    j3 = t6.v.e.coerceAtMost(j3, it4.next().getUpdated());
                    str13 = str13;
                    str12 = str12;
                }
                Single<T> X1 = a2.b.a.a.a.X1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str11, j2, j3, sortedSet, sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$2.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
                StringBuilder T = a2.b.a.a.a.T(str5, str11, ", olderOrEqualToTimestamp = ", j2);
                a2.b.a.a.a.l1(T, ", newerOrEqualToTimestamp = ", j3, str8);
                Completable flatMapCompletable2 = channelSyncAgentImpl.log(X1, a2.b.a.a.a.z(T, sortedSet, str12, sortedSet2, ')')).flatMapCompletable(new ChannelSyncAgentImpl$deleteDeprecatedChatsInTheMiddle$3(channelSyncAgentImpl, str11, list2));
                Intrinsics.checkNotNullExpressionValue(flatMapCompletable2, str7);
                StringBuilder R4 = a2.b.a.a.a.R(" -> deleteDeprecatedChatsInTheMiddle(userId = ", str11, str9);
                a2.b.a.a.a.v1(list2, R4, str10, sortedSet, str12);
                Completable andThen2 = andThen.andThen(a2.b.a.a.a.O1(R4, sortedSet2, ')', channelSyncAgentImpl, flatMapCompletable2));
                Intrinsics.checkNotNullExpressionValue(andThen2, "putChatsFromServerInDb(\n…          )\n            )");
                Single<R> flatMap2 = andThen2.toSingleDefault(Unit.INSTANCE).flatMap(new ChannelSyncAgentImpl$syncNextPage$1$syncPartialPageOfChatsFromServerWithDb$$inlined$flatMapSingle$1(channelSyncAgentImpl, str11, list2, i3, sortedSet, sortedSet2));
                Intrinsics.checkNotNullExpressionValue(flatMap2, "toSingleDefault(Unit).flatMap { singleFactory() }");
                Single<R> flatMap3 = flatMap2.flatMap(new ChannelSyncAgentImpl$syncPartialPageOfChatsFromServerWithDb$3(channelSyncAgentImpl, str11, sortedSet, sortedSet2));
                Intrinsics.checkNotNullExpressionValue(flatMap3, "putChatsFromServerInDb(\n…          )\n            }");
                StringBuilder R5 = a2.b.a.a.a.R(" -> syncPartialPageOfChatsFromServerWithDb(userId = ", str11, str9);
                a2.b.a.a.a.t1(list2, R5, str13, i3, str6);
                a2.b.a.a.a.h1(R5, i5, str8, sortedSet, str12);
                return a2.b.a.a.a.Y1(R5, sortedSet2, ')', channelSyncAgentImpl, flatMap3);
            }
            String str14 = "getNonEmptyChatIdsFromDb…          )\n            }";
            String str15 = ", chatsFromServer = (";
            MessengerEntityConverter messengerEntityConverter2 = channelSyncAgentImpl.f;
            ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(list2, 10));
            for (Iterator<T> it5 = list2.iterator(); it5.hasNext(); it5 = it5) {
                arrayList2.add(messengerEntityConverter2.convertChannel(it5.next()));
            }
            Completable K12 = a2.b.a.a.a.K1(channelSyncAgentImpl, channelSyncAgentImpl.g.putChannels(str11, arrayList2), "chatsFromServer.map(mess…schedulers.computation())");
            StringBuilder R6 = a2.b.a.a.a.R(" -> putChatsFromServerInDb(userId = ", str11, str15);
            R6.append(list2.size());
            R6.append(")[...])");
            Completable log2 = channelSyncAgentImpl.log(K12, R6.toString());
            Single W12 = a2.b.a.a.a.W1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str11, i4, i5, (Collection<String>) sortedSet, (Collection<String>) sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$1.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
            StringBuilder S2 = a2.b.a.a.a.S(" -> getNonEmptyChatIdsFromDb(userId = ", str11, ", offset = ", i4, ", requestSize = ");
            a2.b.a.a.a.h1(S2, i5, ", tags = ", sortedSet, ", excludeTags = ");
            Completable flatMapCompletable3 = a2.b.a.a.a.Y1(S2, sortedSet2, ')', channelSyncAgentImpl, W12).flatMapCompletable(new ChannelSyncAgentImpl$deleteChatsThatDoNotMatchTheOnesOnServerFromDb$1(channelSyncAgentImpl, str11, list2));
            Intrinsics.checkNotNullExpressionValue(flatMapCompletable3, str14);
            StringBuilder R7 = a2.b.a.a.a.R(" -> deleteChatsThatDoNotMatchTheOnesOnServerFromDb(userId = ", str11, str15);
            a2.b.a.a.a.t1(list2, R7, ")[...], offset = ", i4, ", requestSize = ");
            a2.b.a.a.a.h1(R7, i5, ", tags = ", sortedSet, ", excludeTags = ");
            Completable andThen3 = log2.andThen(a2.b.a.a.a.O1(R7, sortedSet2, ')', channelSyncAgentImpl, flatMapCompletable3));
            if (i4 != 0) {
                z = false;
            }
            if (z) {
                long j4 = Long.MIN_VALUE;
                for (Iterator<T> it6 = list2.iterator(); it6.hasNext(); it6 = it6) {
                    j4 = t6.v.e.coerceAtLeast(j4, it6.next().getUpdated());
                }
                str2 = ", tags = ";
                i = i5;
                str = ")[...], offset = ";
                str3 = ", requestSize = ";
                i2 = i4;
                Completable deleteNonEmptyChannelsNewerThatTimestamp2 = channelSyncAgentImpl.g.deleteNonEmptyChannelsNewerThatTimestamp(str11, j4, sortedSet, sortedSet2);
                StringBuilder R8 = a2.b.a.a.a.R(" -> deleteNewerDeprecatedChats(userId = ", str11, str15);
                str4 = ")[...], tags = ";
                a2.b.a.a.a.v1(list2, R8, str4, sortedSet, ", excludeTags = ");
                andThen3 = andThen3.andThen(a2.b.a.a.a.O1(R8, sortedSet2, ')', channelSyncAgentImpl, deleteNonEmptyChannelsNewerThatTimestamp2));
            } else {
                i = i5;
                str2 = ", tags = ";
                i2 = i4;
                str = ")[...], offset = ";
                str4 = ")[...], tags = ";
                str3 = ", requestSize = ";
            }
            long j5 = Long.MIN_VALUE;
            for (Iterator<T> it7 = list2.iterator(); it7.hasNext(); it7 = it7) {
                j5 = t6.v.e.coerceAtLeast(j5, it7.next().getUpdated());
            }
            Iterator<T> it8 = list2.iterator();
            long j6 = Long.MAX_VALUE;
            while (it8.hasNext()) {
                j6 = t6.v.e.coerceAtMost(j6, it8.next().getUpdated());
                str14 = str14;
                str15 = str15;
            }
            Single<T> X12 = a2.b.a.a.a.X1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str11, j5, j6, sortedSet, sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$2.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
            StringBuilder T2 = a2.b.a.a.a.T(" -> getNonEmptyChatIdsFromDb(userId = ", str11, ", olderOrEqualToTimestamp = ", j5);
            a2.b.a.a.a.l1(T2, ", newerOrEqualToTimestamp = ", j6, str2);
            Completable flatMapCompletable4 = channelSyncAgentImpl.log(X12, a2.b.a.a.a.z(T2, sortedSet, ", excludeTags = ", sortedSet2, ')')).flatMapCompletable(new ChannelSyncAgentImpl$deleteDeprecatedChatsInTheMiddle$3(channelSyncAgentImpl, str11, list2));
            Intrinsics.checkNotNullExpressionValue(flatMapCompletable4, str14);
            StringBuilder R9 = a2.b.a.a.a.R(" -> deleteDeprecatedChatsInTheMiddle(userId = ", str11, str15);
            a2.b.a.a.a.v1(list2, R9, str4, sortedSet, ", excludeTags = ");
            Completable andThen4 = andThen3.andThen(a2.b.a.a.a.O1(R9, sortedSet2, ')', channelSyncAgentImpl, flatMapCompletable4));
            Intrinsics.checkNotNullExpressionValue(andThen4, "putChatsFromServerInDb(\n…          )\n            )");
            Single<R> flatMap4 = andThen4.toSingleDefault(Unit.INSTANCE).flatMap(new ChannelSyncAgentImpl$syncNextPage$1$syncFullPageOfChatsFromServerWithDb$$inlined$flatMapSingle$1(channelSyncAgentImpl, str11, list2, i2, sortedSet, sortedSet2));
            Intrinsics.checkNotNullExpressionValue(flatMap4, "toSingleDefault(Unit).flatMap { singleFactory() }");
            Single<R> map = flatMap4.map(ChannelSyncAgentImpl$syncFullPageOfChatsFromServerWithDb$3.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(map, "putChatsFromServerInDb(\n…          )\n            }");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" -> syncFullPageOfChatsFromServerWithDb(userId = ");
            sb2.append(str11);
            sb2.append(str15);
            a2.b.a.a.a.t1(list2, sb2, str, i2, str3);
            a2.b.a.a.a.h1(sb2, i, str2, sortedSet, ", excludeTags = ");
            return a2.b.a.a.a.Y1(sb2, sortedSet2, ')', channelSyncAgentImpl, map);
        }
    }

    public ChannelSyncAgentImpl(@NotNull AccountStateProvider accountStateProvider, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull MessengerEntityConverter messengerEntityConverter, @NotNull ChannelRepo channelRepo, @NotNull DraftRepoWriter draftRepoWriter, @NotNull Features features, @NotNull SchedulersFactory schedulersFactory, @NotNull TimeSource timeSource, @NotNull RxFairCompositeWriteLock<ChannelsKey> rxFairCompositeWriteLock, int i2, int i3) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(messengerEntityConverter, "messengerEntityConverter");
        Intrinsics.checkNotNullParameter(channelRepo, "channelRepo");
        Intrinsics.checkNotNullParameter(draftRepoWriter, "draftRepoWriter");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(rxFairCompositeWriteLock, "lock");
        this.o = new RxLoggerDelegate(false, "ChannelSyncAgent");
        this.d = accountStateProvider;
        this.e = messengerClient;
        this.f = messengerEntityConverter;
        this.g = channelRepo;
        this.h = draftRepoWriter;
        this.i = features;
        this.j = schedulersFactory;
        this.k = timeSource;
        this.l = rxFairCompositeWriteLock;
        this.m = i2;
        this.n = i3;
        ChatAndDraftEraserImpl chatAndDraftEraserImpl = new ChatAndDraftEraserImpl(messengerClient, channelRepo, draftRepoWriter, schedulersFactory, rxFairCompositeWriteLock);
        this.a = chatAndDraftEraserImpl;
        this.b = new ChannelsBackendNotificationsHandlerImpl(accountStateProvider, messengerClient, messengerEntityConverter, channelRepo, features, schedulersFactory, timeSource, rxFairCompositeWriteLock, chatAndDraftEraserImpl);
        this.c = new LocalChannelEditorImpl(channelRepo, schedulersFactory, rxFairCompositeWriteLock);
    }

    public static final Completable access$deleteChatsThatDoNotMatchTheOnesOnServerFromDb(ChannelSyncAgentImpl channelSyncAgentImpl, String str, List list, int i2, int i3, SortedSet sortedSet, SortedSet sortedSet2) {
        Objects.requireNonNull(channelSyncAgentImpl);
        Single W1 = a2.b.a.a.a.W1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str, i2, i3, (Collection<String>) sortedSet, (Collection<String>) sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$1.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
        StringBuilder S = a2.b.a.a.a.S(" -> getNonEmptyChatIdsFromDb(userId = ", str, ", offset = ", i2, ", requestSize = ");
        a2.b.a.a.a.h1(S, i3, ", tags = ", sortedSet, ", excludeTags = ");
        Completable flatMapCompletable = a2.b.a.a.a.Y1(S, sortedSet2, ')', channelSyncAgentImpl, W1).flatMapCompletable(new ChannelSyncAgentImpl$deleteChatsThatDoNotMatchTheOnesOnServerFromDb$1(channelSyncAgentImpl, str, list));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "getNonEmptyChatIdsFromDb…          )\n            }");
        StringBuilder R = a2.b.a.a.a.R(" -> deleteChatsThatDoNotMatchTheOnesOnServerFromDb(userId = ", str, ", chatsFromServer = (");
        a2.b.a.a.a.t1(list, R, ")[...], offset = ", i2, ", requestSize = ");
        a2.b.a.a.a.h1(R, i3, ", tags = ", sortedSet, ", excludeTags = ");
        return a2.b.a.a.a.O1(R, sortedSet2, ')', channelSyncAgentImpl, flatMapCompletable);
    }

    public static final Completable access$deleteDeprecatedChatsInTheMiddle(ChannelSyncAgentImpl channelSyncAgentImpl, String str, List list, SortedSet sortedSet, SortedSet sortedSet2) {
        Objects.requireNonNull(channelSyncAgentImpl);
        Iterator it = list.iterator();
        long j2 = Long.MIN_VALUE;
        while (it.hasNext()) {
            j2 = t6.v.e.coerceAtLeast(j2, ((Channel) it.next()).getUpdated());
        }
        Iterator it2 = list.iterator();
        long j3 = Long.MAX_VALUE;
        while (it2.hasNext()) {
            j3 = t6.v.e.coerceAtMost(j3, ((Channel) it2.next()).getUpdated());
        }
        Single X1 = a2.b.a.a.a.X1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str, j2, j3, sortedSet, sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$2.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
        StringBuilder T = a2.b.a.a.a.T(" -> getNonEmptyChatIdsFromDb(userId = ", str, ", olderOrEqualToTimestamp = ", j2);
        a2.b.a.a.a.l1(T, ", newerOrEqualToTimestamp = ", j3, ", tags = ");
        Completable flatMapCompletable = channelSyncAgentImpl.log(X1, a2.b.a.a.a.z(T, sortedSet, ", excludeTags = ", sortedSet2, ')')).flatMapCompletable(new ChannelSyncAgentImpl$deleteDeprecatedChatsInTheMiddle$3(channelSyncAgentImpl, str, list));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "getNonEmptyChatIdsFromDb…          )\n            }");
        StringBuilder R = a2.b.a.a.a.R(" -> deleteDeprecatedChatsInTheMiddle(userId = ", str, ", chatsFromServer = (");
        a2.b.a.a.a.v1(list, R, ")[...], tags = ", sortedSet, ", excludeTags = ");
        return a2.b.a.a.a.O1(R, sortedSet2, ')', channelSyncAgentImpl, flatMapCompletable);
    }

    public static final Completable access$deleteNewerDeprecatedChats(ChannelSyncAgentImpl channelSyncAgentImpl, String str, List list, SortedSet sortedSet, SortedSet sortedSet2) {
        Objects.requireNonNull(channelSyncAgentImpl);
        Iterator it = list.iterator();
        long j2 = Long.MIN_VALUE;
        while (it.hasNext()) {
            j2 = t6.v.e.coerceAtLeast(j2, ((Channel) it.next()).getUpdated());
        }
        Completable deleteNonEmptyChannelsNewerThatTimestamp = channelSyncAgentImpl.g.deleteNonEmptyChannelsNewerThatTimestamp(str, j2, sortedSet, sortedSet2);
        StringBuilder R = a2.b.a.a.a.R(" -> deleteNewerDeprecatedChats(userId = ", str, ", chatsFromServer = (");
        a2.b.a.a.a.v1(list, R, ")[...], tags = ", sortedSet, ", excludeTags = ");
        return a2.b.a.a.a.O1(R, sortedSet2, ')', channelSyncAgentImpl, deleteNonEmptyChannelsNewerThatTimestamp);
    }

    public static final Completable access$deleteOlderDeprecatedChats(ChannelSyncAgentImpl channelSyncAgentImpl, String str, Option option, SortedSet sortedSet, SortedSet sortedSet2) {
        Objects.requireNonNull(channelSyncAgentImpl);
        Completable K1 = a2.b.a.a.a.K1(channelSyncAgentImpl, channelSyncAgentImpl.g.deleteNonEmptyChannelsOlderThanTimestamp(str, ((Number) OptionKt.getOrElse(option, ChannelSyncAgentImpl$deleteOlderDeprecatedChats$1.INSTANCE)).longValue(), sortedSet, sortedSet2), "channelRepo.deleteNonEmp…schedulers.computation())");
        StringBuilder sb = new StringBuilder();
        sb.append(" -> deleteOlderDeprecatedChats(userId = ");
        sb.append(str);
        sb.append(", oldestSyncedChatTimestamp = ");
        sb.append(option);
        sb.append(", tags = ");
        return channelSyncAgentImpl.log(K1, a2.b.a.a.a.z(sb, sortedSet, ", excludeTags = ", sortedSet2, ')'));
    }

    public static final List access$getChatIdsToDelete(ChannelSyncAgentImpl channelSyncAgentImpl, List list, List list2) {
        Objects.requireNonNull(channelSyncAgentImpl);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!Intrinsics.areEqual(str, (String) list2.get(i2))) {
                arrayList.add(str);
            } else if (i2 < list2.size() - 1) {
                i2++;
            }
        }
        return arrayList;
    }

    public static final Single access$getNonEmptyChatIdsFromDb(ChannelSyncAgentImpl channelSyncAgentImpl, String str, int i2, int i3, SortedSet sortedSet, SortedSet sortedSet2) {
        Objects.requireNonNull(channelSyncAgentImpl);
        Single W1 = a2.b.a.a.a.W1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str, i2, i3, (Collection<String>) sortedSet, (Collection<String>) sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$1.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
        StringBuilder S = a2.b.a.a.a.S(" -> getNonEmptyChatIdsFromDb(userId = ", str, ", offset = ", i2, ", requestSize = ");
        a2.b.a.a.a.h1(S, i3, ", tags = ", sortedSet, ", excludeTags = ");
        return a2.b.a.a.a.Y1(S, sortedSet2, ')', channelSyncAgentImpl, W1);
    }

    public static final Single access$getOldestSyncedChatTimestamp(ChannelSyncAgentImpl channelSyncAgentImpl, String str, List list, int i2, SortedSet sortedSet, SortedSet sortedSet2) {
        Single<Option<Long>> single;
        Objects.requireNonNull(channelSyncAgentImpl);
        int size = list.size() + i2;
        if (size == 0) {
            single = Singles.toSingle(OptionKt.none());
        } else {
            single = channelSyncAgentImpl.g.getTimestampOfNonEmptyChannelAtPosition(str, size - 1, sortedSet, sortedSet2).observeOn(channelSyncAgentImpl.j.computation()).filter(a2.a.a.o1.b.b.d.a.a).firstOrError();
        }
        Intrinsics.checkNotNullExpressionValue(single, "if (syncedChatsCount == ….firstOrError()\n        }");
        StringBuilder sb = new StringBuilder();
        sb.append(" -> getOldestSyncedChatTimestamp(userId = ");
        sb.append(str);
        sb.append(", chatsFromServer = (");
        a2.b.a.a.a.t1(list, sb, ")[...], offset = ", i2, ", tags = ");
        return channelSyncAgentImpl.log(single, a2.b.a.a.a.z(sb, sortedSet, ", excludeTags = ", sortedSet2, ')'));
    }

    public static final Completable access$putChannelInDb(ChannelSyncAgentImpl channelSyncAgentImpl, String str, Channel channel) {
        Objects.requireNonNull(channelSyncAgentImpl);
        Completable K1 = a2.b.a.a.a.K1(channelSyncAgentImpl, channelSyncAgentImpl.g.putChannel(str, channelSyncAgentImpl.f.convertChannel(channel)), "channelRepo.putChannel(\n…schedulers.computation())");
        StringBuilder R = a2.b.a.a.a.R(" -> putChannelInDb(userId = ", str, ", newChannel = ");
        R.append(channel.getChannelId());
        R.append(')');
        return channelSyncAgentImpl.log(K1, R.toString());
    }

    public static final Completable access$putChatsFromServerInDb(ChannelSyncAgentImpl channelSyncAgentImpl, String str, List list) {
        Objects.requireNonNull(channelSyncAgentImpl);
        MessengerEntityConverter messengerEntityConverter = channelSyncAgentImpl.f;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(messengerEntityConverter.convertChannel((Channel) it.next()));
        }
        Completable K1 = a2.b.a.a.a.K1(channelSyncAgentImpl, channelSyncAgentImpl.g.putChannels(str, arrayList), "chatsFromServer.map(mess…schedulers.computation())");
        StringBuilder R = a2.b.a.a.a.R(" -> putChatsFromServerInDb(userId = ", str, ", chatsFromServer = (");
        R.append(list.size());
        R.append(")[...])");
        return channelSyncAgentImpl.log(K1, R.toString());
    }

    public static final Single access$syncChatsFromServerWithDb(ChannelSyncAgentImpl channelSyncAgentImpl, String str, List list, int i2, int i3, SortedSet sortedSet, SortedSet sortedSet2) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Completable completable;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        Objects.requireNonNull(channelSyncAgentImpl);
        if (list.isEmpty()) {
            Single flatMap = access$getOldestSyncedChatTimestamp(channelSyncAgentImpl, str, list, i2, sortedSet, sortedSet2).flatMap(new ChannelSyncAgentImpl$syncEmptyPageOfChatsFromServerWithDb$1(channelSyncAgentImpl, str, sortedSet, sortedSet2));
            Intrinsics.checkNotNullExpressionValue(flatMap, "getOldestSyncedChatTimes…          )\n            }");
            StringBuilder sb = new StringBuilder();
            sb.append(" -> syncEmptyPageOfChatsFromServerWithDb(userId = ");
            sb.append(str);
            sb.append(", chatsFromServer = (");
            a2.b.a.a.a.t1(list, sb, ")[...], offset = ", i2, ", tags = ");
            return channelSyncAgentImpl.log(flatMap, a2.b.a.a.a.z(sb, sortedSet, ", excludeTags = ", sortedSet2, ')'));
        }
        boolean z = true;
        if (list.size() < i3) {
            MessengerEntityConverter messengerEntityConverter = channelSyncAgentImpl.f;
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
            for (Iterator it = list.iterator(); it.hasNext(); it = it) {
                arrayList.add(messengerEntityConverter.convertChannel((Channel) it.next()));
            }
            Completable K1 = a2.b.a.a.a.K1(channelSyncAgentImpl, channelSyncAgentImpl.g.putChannels(str, arrayList), "chatsFromServer.map(mess…schedulers.computation())");
            StringBuilder R = a2.b.a.a.a.R(" -> putChatsFromServerInDb(userId = ", str, ", chatsFromServer = (");
            R.append(list.size());
            R.append(")[...])");
            Completable log = channelSyncAgentImpl.log(K1, R.toString());
            Single W1 = a2.b.a.a.a.W1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str, i2, i3, (Collection<String>) sortedSet, (Collection<String>) sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$1.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
            StringBuilder S = a2.b.a.a.a.S(" -> getNonEmptyChatIdsFromDb(userId = ", str, ", offset = ", i2, ", requestSize = ");
            a2.b.a.a.a.h1(S, i3, ", tags = ", sortedSet, ", excludeTags = ");
            Completable flatMapCompletable = a2.b.a.a.a.Y1(S, sortedSet2, ')', channelSyncAgentImpl, W1).flatMapCompletable(new ChannelSyncAgentImpl$deleteChatsThatDoNotMatchTheOnesOnServerFromDb$1(channelSyncAgentImpl, str, list));
            Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "getNonEmptyChatIdsFromDb…          )\n            }");
            StringBuilder R2 = a2.b.a.a.a.R(" -> deleteChatsThatDoNotMatchTheOnesOnServerFromDb(userId = ", str, ", chatsFromServer = (");
            a2.b.a.a.a.t1(list, R2, ")[...], offset = ", i2, ", requestSize = ");
            a2.b.a.a.a.h1(R2, i3, ", tags = ", sortedSet, ", excludeTags = ");
            Completable andThen = log.andThen(a2.b.a.a.a.O1(R2, sortedSet2, ')', channelSyncAgentImpl, flatMapCompletable));
            if (i2 != 0) {
                z = false;
            }
            if (z) {
                long j2 = Long.MIN_VALUE;
                for (Iterator it2 = list.iterator(); it2.hasNext(); it2 = it2) {
                    j2 = t6.v.e.coerceAtLeast(j2, ((Channel) it2.next()).getUpdated());
                }
                str10 = ", requestSize = ";
                str14 = ", chatsFromServer = (";
                str9 = "channelRepo.getNonEmptyC…          .firstOrError()";
                str13 = "getNonEmptyChatIdsFromDb…          )\n            }";
                str12 = ")[...], offset = ";
                str8 = "putChatsFromServerInDb(\n…          )\n            }";
                str11 = ", tags = ";
                Completable deleteNonEmptyChannelsNewerThatTimestamp = channelSyncAgentImpl.g.deleteNonEmptyChannelsNewerThatTimestamp(str, j2, sortedSet, sortedSet2);
                StringBuilder R3 = a2.b.a.a.a.R(" -> deleteNewerDeprecatedChats(userId = ", str, str14);
                str15 = ")[...], tags = ";
                a2.b.a.a.a.v1(list, R3, str15, sortedSet, ", excludeTags = ");
                andThen = andThen.andThen(a2.b.a.a.a.O1(R3, sortedSet2, ')', channelSyncAgentImpl, deleteNonEmptyChannelsNewerThatTimestamp));
            } else {
                str13 = "getNonEmptyChatIdsFromDb…          )\n            }";
                str9 = "channelRepo.getNonEmptyC…          .firstOrError()";
                str11 = ", tags = ";
                str10 = ", requestSize = ";
                str14 = ", chatsFromServer = (";
                str15 = ")[...], tags = ";
                str8 = "putChatsFromServerInDb(\n…          )\n            }";
                str12 = ")[...], offset = ";
            }
            Iterator it3 = list.iterator();
            long j3 = Long.MIN_VALUE;
            while (it3.hasNext()) {
                j3 = t6.v.e.coerceAtLeast(j3, ((Channel) it3.next()).getUpdated());
                str14 = str14;
            }
            String str16 = str14;
            Iterator it4 = list.iterator();
            long j4 = Long.MAX_VALUE;
            while (it4.hasNext()) {
                j4 = t6.v.e.coerceAtMost(j4, ((Channel) it4.next()).getUpdated());
                str16 = str16;
            }
            Single X1 = a2.b.a.a.a.X1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str, j3, j4, sortedSet, sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$2.INSTANCE, str9);
            StringBuilder T = a2.b.a.a.a.T(" -> getNonEmptyChatIdsFromDb(userId = ", str, ", olderOrEqualToTimestamp = ", j3);
            a2.b.a.a.a.l1(T, ", newerOrEqualToTimestamp = ", j4, str11);
            Completable flatMapCompletable2 = channelSyncAgentImpl.log(X1, a2.b.a.a.a.z(T, sortedSet, ", excludeTags = ", sortedSet2, ')')).flatMapCompletable(new ChannelSyncAgentImpl$deleteDeprecatedChatsInTheMiddle$3(channelSyncAgentImpl, str, list));
            Intrinsics.checkNotNullExpressionValue(flatMapCompletable2, str13);
            StringBuilder R4 = a2.b.a.a.a.R(" -> deleteDeprecatedChatsInTheMiddle(userId = ", str, str16);
            a2.b.a.a.a.v1(list, R4, str15, sortedSet, ", excludeTags = ");
            Completable andThen2 = andThen.andThen(a2.b.a.a.a.O1(R4, sortedSet2, ')', channelSyncAgentImpl, flatMapCompletable2));
            Intrinsics.checkNotNullExpressionValue(andThen2, "putChatsFromServerInDb(\n…          )\n            )");
            Single flatMap2 = andThen2.toSingleDefault(Unit.INSTANCE).flatMap(new Function<Unit, SingleSource<? extends T>>(str, list, i2, sortedSet, sortedSet2) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgentImpl$syncPartialPageOfChatsFromServerWithDb$$inlined$flatMapSingle$1
                public final /* synthetic */ String b;
                public final /* synthetic */ List c;
                public final /* synthetic */ int d;
                public final /* synthetic */ SortedSet e;
                public final /* synthetic */ SortedSet f;

                {
                    this.b = r2;
                    this.c = r3;
                    this.d = r4;
                    this.e = r5;
                    this.f = r6;
                }

                public final SingleSource<? extends T> apply(@NotNull Unit unit) {
                    Intrinsics.checkNotNullParameter(unit, "it");
                    return ChannelSyncAgentImpl.access$getOldestSyncedChatTimestamp(ChannelSyncAgentImpl.this, this.b, this.c, this.d, this.e, this.f);
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap2, "toSingleDefault(Unit).flatMap { singleFactory() }");
            Single flatMap3 = flatMap2.flatMap(new ChannelSyncAgentImpl$syncPartialPageOfChatsFromServerWithDb$3(channelSyncAgentImpl, str, sortedSet, sortedSet2));
            Intrinsics.checkNotNullExpressionValue(flatMap3, str8);
            StringBuilder R5 = a2.b.a.a.a.R(" -> syncPartialPageOfChatsFromServerWithDb(userId = ", str, str16);
            a2.b.a.a.a.t1(list, R5, str12, i2, str10);
            a2.b.a.a.a.h1(R5, i3, str11, sortedSet, ", excludeTags = ");
            return a2.b.a.a.a.Y1(R5, sortedSet2, ')', channelSyncAgentImpl, flatMap3);
        }
        MessengerEntityConverter messengerEntityConverter2 = channelSyncAgentImpl.f;
        ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        for (Iterator it5 = list.iterator(); it5.hasNext(); it5 = it5) {
            arrayList2.add(messengerEntityConverter2.convertChannel((Channel) it5.next()));
        }
        Completable K12 = a2.b.a.a.a.K1(channelSyncAgentImpl, channelSyncAgentImpl.g.putChannels(str, arrayList2), "chatsFromServer.map(mess…schedulers.computation())");
        StringBuilder R6 = a2.b.a.a.a.R(" -> putChatsFromServerInDb(userId = ", str, ", chatsFromServer = (");
        R6.append(list.size());
        R6.append(")[...])");
        Completable log2 = channelSyncAgentImpl.log(K12, R6.toString());
        Single W12 = a2.b.a.a.a.W1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str, i2, i3, (Collection<String>) sortedSet, (Collection<String>) sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$1.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
        StringBuilder S2 = a2.b.a.a.a.S(" -> getNonEmptyChatIdsFromDb(userId = ", str, ", offset = ", i2, ", requestSize = ");
        String str17 = ", excludeTags = ";
        a2.b.a.a.a.h1(S2, i3, ", tags = ", sortedSet, str17);
        Completable flatMapCompletable3 = a2.b.a.a.a.Y1(S2, sortedSet2, ')', channelSyncAgentImpl, W12).flatMapCompletable(new ChannelSyncAgentImpl$deleteChatsThatDoNotMatchTheOnesOnServerFromDb$1(channelSyncAgentImpl, str, list));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable3, "getNonEmptyChatIdsFromDb…          )\n            }");
        StringBuilder R7 = a2.b.a.a.a.R(" -> deleteChatsThatDoNotMatchTheOnesOnServerFromDb(userId = ", str, ", chatsFromServer = (");
        a2.b.a.a.a.t1(list, R7, ")[...], offset = ", i2, ", requestSize = ");
        a2.b.a.a.a.h1(R7, i3, ", tags = ", sortedSet, str17);
        Completable andThen3 = log2.andThen(a2.b.a.a.a.O1(R7, sortedSet2, ')', channelSyncAgentImpl, flatMapCompletable3));
        if (i2 != 0) {
            z = false;
        }
        if (z) {
            long j5 = Long.MIN_VALUE;
            for (Iterator it6 = list.iterator(); it6.hasNext(); it6 = it6) {
                j5 = t6.v.e.coerceAtLeast(j5, ((Channel) it6.next()).getUpdated());
            }
            str5 = "getNonEmptyChatIdsFromDb…          )\n            }";
            str4 = " -> getNonEmptyChatIdsFromDb(userId = ";
            str6 = ", chatsFromServer = (";
            str2 = ", tags = ";
            str3 = ", requestSize = ";
            Completable deleteNonEmptyChannelsNewerThatTimestamp2 = channelSyncAgentImpl.g.deleteNonEmptyChannelsNewerThatTimestamp(str, j5, sortedSet, sortedSet2);
            StringBuilder R8 = a2.b.a.a.a.R(" -> deleteNewerDeprecatedChats(userId = ", str, str6);
            str7 = ")[...], tags = ";
            a2.b.a.a.a.v1(list, R8, str7, sortedSet, str17);
            completable = andThen3.andThen(a2.b.a.a.a.O1(R8, sortedSet2, ')', channelSyncAgentImpl, deleteNonEmptyChannelsNewerThatTimestamp2));
        } else {
            str2 = ", tags = ";
            str3 = ", requestSize = ";
            str4 = " -> getNonEmptyChatIdsFromDb(userId = ";
            str5 = "getNonEmptyChatIdsFromDb…          )\n            }";
            str7 = ")[...], tags = ";
            str6 = ", chatsFromServer = (";
            completable = andThen3;
        }
        Iterator it7 = list.iterator();
        long j6 = Long.MIN_VALUE;
        while (it7.hasNext()) {
            j6 = t6.v.e.coerceAtLeast(j6, ((Channel) it7.next()).getUpdated());
        }
        Iterator it8 = list.iterator();
        long j7 = Long.MAX_VALUE;
        while (it8.hasNext()) {
            j7 = t6.v.e.coerceAtMost(j7, ((Channel) it8.next()).getUpdated());
            str17 = str17;
        }
        Single X12 = a2.b.a.a.a.X1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str, j6, j7, sortedSet, sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$2.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
        StringBuilder T2 = a2.b.a.a.a.T(str4, str, ", olderOrEqualToTimestamp = ", j6);
        a2.b.a.a.a.l1(T2, ", newerOrEqualToTimestamp = ", j7, str2);
        Completable flatMapCompletable4 = channelSyncAgentImpl.log(X12, a2.b.a.a.a.z(T2, sortedSet, str17, sortedSet2, ')')).flatMapCompletable(new ChannelSyncAgentImpl$deleteDeprecatedChatsInTheMiddle$3(channelSyncAgentImpl, str, list));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable4, str5);
        StringBuilder R9 = a2.b.a.a.a.R(" -> deleteDeprecatedChatsInTheMiddle(userId = ", str, str6);
        a2.b.a.a.a.v1(list, R9, str7, sortedSet, str17);
        Completable andThen4 = completable.andThen(a2.b.a.a.a.O1(R9, sortedSet2, ')', channelSyncAgentImpl, flatMapCompletable4));
        Intrinsics.checkNotNullExpressionValue(andThen4, "putChatsFromServerInDb(\n…          )\n            )");
        Single flatMap4 = andThen4.toSingleDefault(Unit.INSTANCE).flatMap(new Function<Unit, SingleSource<? extends T>>(str, list, i2, sortedSet, sortedSet2) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgentImpl$syncFullPageOfChatsFromServerWithDb$$inlined$flatMapSingle$1
            public final /* synthetic */ String b;
            public final /* synthetic */ List c;
            public final /* synthetic */ int d;
            public final /* synthetic */ SortedSet e;
            public final /* synthetic */ SortedSet f;

            {
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
            }

            public final SingleSource<? extends T> apply(@NotNull Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "it");
                return ChannelSyncAgentImpl.access$getOldestSyncedChatTimestamp(ChannelSyncAgentImpl.this, this.b, this.c, this.d, this.e, this.f);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap4, "toSingleDefault(Unit).flatMap { singleFactory() }");
        Single map = flatMap4.map(ChannelSyncAgentImpl$syncFullPageOfChatsFromServerWithDb$3.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "putChatsFromServerInDb(\n…          )\n            }");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" -> syncFullPageOfChatsFromServerWithDb(userId = ");
        sb2.append(str);
        sb2.append(str6);
        a2.b.a.a.a.t1(list, sb2, ")[...], offset = ", i2, str3);
        a2.b.a.a.a.h1(sb2, i3, str2, sortedSet, str17);
        return a2.b.a.a.a.Y1(sb2, sortedSet2, ')', channelSyncAgentImpl, map);
    }

    public static final Single access$syncEmptyPageOfChatsFromServerWithDb(ChannelSyncAgentImpl channelSyncAgentImpl, String str, List list, int i2, SortedSet sortedSet, SortedSet sortedSet2) {
        Objects.requireNonNull(channelSyncAgentImpl);
        Single flatMap = access$getOldestSyncedChatTimestamp(channelSyncAgentImpl, str, list, i2, sortedSet, sortedSet2).flatMap(new ChannelSyncAgentImpl$syncEmptyPageOfChatsFromServerWithDb$1(channelSyncAgentImpl, str, sortedSet, sortedSet2));
        Intrinsics.checkNotNullExpressionValue(flatMap, "getOldestSyncedChatTimes…          )\n            }");
        StringBuilder sb = new StringBuilder();
        sb.append(" -> syncEmptyPageOfChatsFromServerWithDb(userId = ");
        sb.append(str);
        sb.append(", chatsFromServer = (");
        a2.b.a.a.a.t1(list, sb, ")[...], offset = ", i2, ", tags = ");
        return channelSyncAgentImpl.log(flatMap, a2.b.a.a.a.z(sb, sortedSet, ", excludeTags = ", sortedSet2, ')'));
    }

    public static final Single access$syncFullPageOfChatsFromServerWithDb(ChannelSyncAgentImpl channelSyncAgentImpl, String str, List list, int i2, int i3, SortedSet sortedSet, SortedSet sortedSet2) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Objects.requireNonNull(channelSyncAgentImpl);
        MessengerEntityConverter messengerEntityConverter = channelSyncAgentImpl.f;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(messengerEntityConverter.convertChannel((Channel) it.next()));
        }
        Completable K1 = a2.b.a.a.a.K1(channelSyncAgentImpl, channelSyncAgentImpl.g.putChannels(str, arrayList), "chatsFromServer.map(mess…schedulers.computation())");
        StringBuilder R = a2.b.a.a.a.R(" -> putChatsFromServerInDb(userId = ", str, ", chatsFromServer = (");
        R.append(list.size());
        R.append(")[...])");
        Completable log = channelSyncAgentImpl.log(K1, R.toString());
        Single W1 = a2.b.a.a.a.W1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str, i2, i3, (Collection<String>) sortedSet, (Collection<String>) sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$1.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
        StringBuilder S = a2.b.a.a.a.S(" -> getNonEmptyChatIdsFromDb(userId = ", str, ", offset = ", i2, ", requestSize = ");
        a2.b.a.a.a.h1(S, i3, ", tags = ", sortedSet, ", excludeTags = ");
        Completable flatMapCompletable = a2.b.a.a.a.Y1(S, sortedSet2, ')', channelSyncAgentImpl, W1).flatMapCompletable(new ChannelSyncAgentImpl$deleteChatsThatDoNotMatchTheOnesOnServerFromDb$1(channelSyncAgentImpl, str, list));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "getNonEmptyChatIdsFromDb…          )\n            }");
        StringBuilder R2 = a2.b.a.a.a.R(" -> deleteChatsThatDoNotMatchTheOnesOnServerFromDb(userId = ", str, ", chatsFromServer = (");
        String str8 = ")[...], offset = ";
        a2.b.a.a.a.t1(list, R2, str8, i2, ", requestSize = ");
        a2.b.a.a.a.h1(R2, i3, ", tags = ", sortedSet, ", excludeTags = ");
        Completable andThen = log.andThen(a2.b.a.a.a.O1(R2, sortedSet2, ')', channelSyncAgentImpl, flatMapCompletable));
        if (i2 == 0) {
            long j2 = Long.MIN_VALUE;
            for (Iterator it2 = list.iterator(); it2.hasNext(); it2 = it2) {
                j2 = t6.v.e.coerceAtLeast(j2, ((Channel) it2.next()).getUpdated());
            }
            str5 = ", tags = ";
            str6 = ", excludeTags = ";
            str7 = ")[...], tags = ";
            str4 = ", requestSize = ";
            str2 = "getNonEmptyChatIdsFromDb…          )\n            }";
            str3 = " -> getNonEmptyChatIdsFromDb(userId = ";
            Completable deleteNonEmptyChannelsNewerThatTimestamp = channelSyncAgentImpl.g.deleteNonEmptyChannelsNewerThatTimestamp(str, j2, sortedSet, sortedSet2);
            StringBuilder R3 = a2.b.a.a.a.R(" -> deleteNewerDeprecatedChats(userId = ", str, ", chatsFromServer = (");
            a2.b.a.a.a.v1(list, R3, str7, sortedSet, str6);
            andThen = andThen.andThen(a2.b.a.a.a.O1(R3, sortedSet2, ')', channelSyncAgentImpl, deleteNonEmptyChannelsNewerThatTimestamp));
        } else {
            str7 = ")[...], tags = ";
            str6 = ", excludeTags = ";
            str4 = ", requestSize = ";
            str2 = "getNonEmptyChatIdsFromDb…          )\n            }";
            str3 = " -> getNonEmptyChatIdsFromDb(userId = ";
            str5 = ", tags = ";
        }
        Iterator it3 = list.iterator();
        long j3 = Long.MIN_VALUE;
        while (it3.hasNext()) {
            j3 = t6.v.e.coerceAtLeast(j3, ((Channel) it3.next()).getUpdated());
        }
        long j4 = Long.MAX_VALUE;
        Iterator it4 = list.iterator();
        while (it4.hasNext()) {
            j4 = t6.v.e.coerceAtMost(j4, ((Channel) it4.next()).getUpdated());
            str8 = str8;
        }
        Single X1 = a2.b.a.a.a.X1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str, j3, j4, sortedSet, sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$2.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
        StringBuilder T = a2.b.a.a.a.T(str3, str, ", olderOrEqualToTimestamp = ", j3);
        a2.b.a.a.a.l1(T, ", newerOrEqualToTimestamp = ", j4, str5);
        Completable flatMapCompletable2 = channelSyncAgentImpl.log(X1, a2.b.a.a.a.z(T, sortedSet, str6, sortedSet2, ')')).flatMapCompletable(new ChannelSyncAgentImpl$deleteDeprecatedChatsInTheMiddle$3(channelSyncAgentImpl, str, list));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable2, str2);
        StringBuilder R4 = a2.b.a.a.a.R(" -> deleteDeprecatedChatsInTheMiddle(userId = ", str, ", chatsFromServer = (");
        a2.b.a.a.a.v1(list, R4, str7, sortedSet, str6);
        Completable andThen2 = andThen.andThen(a2.b.a.a.a.O1(R4, sortedSet2, ')', channelSyncAgentImpl, flatMapCompletable2));
        Intrinsics.checkNotNullExpressionValue(andThen2, "putChatsFromServerInDb(\n…          )\n            )");
        Single flatMap = andThen2.toSingleDefault(Unit.INSTANCE).flatMap(new Function<Unit, SingleSource<? extends T>>(str, list, i2, sortedSet, sortedSet2) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgentImpl$syncFullPageOfChatsFromServerWithDb$$inlined$flatMapSingle$2
            public final /* synthetic */ String b;
            public final /* synthetic */ List c;
            public final /* synthetic */ int d;
            public final /* synthetic */ SortedSet e;
            public final /* synthetic */ SortedSet f;

            {
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
            }

            public final SingleSource<? extends T> apply(@NotNull Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "it");
                return ChannelSyncAgentImpl.access$getOldestSyncedChatTimestamp(ChannelSyncAgentImpl.this, this.b, this.c, this.d, this.e, this.f);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "toSingleDefault(Unit).flatMap { singleFactory() }");
        Single map = flatMap.map(ChannelSyncAgentImpl$syncFullPageOfChatsFromServerWithDb$3.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "putChatsFromServerInDb(\n…          )\n            }");
        StringBuilder sb = new StringBuilder();
        sb.append(" -> syncFullPageOfChatsFromServerWithDb(userId = ");
        sb.append(str);
        sb.append(", chatsFromServer = (");
        a2.b.a.a.a.t1(list, sb, str8, i2, str4);
        a2.b.a.a.a.h1(sb, i3, str5, sortedSet, str6);
        return a2.b.a.a.a.Y1(sb, sortedSet2, ')', channelSyncAgentImpl, map);
    }

    public static final Single access$syncPartialPageOfChatsFromServerWithDb(ChannelSyncAgentImpl channelSyncAgentImpl, String str, List list, int i2, int i3, SortedSet sortedSet, SortedSet sortedSet2) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Objects.requireNonNull(channelSyncAgentImpl);
        MessengerEntityConverter messengerEntityConverter = channelSyncAgentImpl.f;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(messengerEntityConverter.convertChannel((Channel) it.next()));
        }
        Completable K1 = a2.b.a.a.a.K1(channelSyncAgentImpl, channelSyncAgentImpl.g.putChannels(str, arrayList), "chatsFromServer.map(mess…schedulers.computation())");
        StringBuilder R = a2.b.a.a.a.R(" -> putChatsFromServerInDb(userId = ", str, ", chatsFromServer = (");
        R.append(list.size());
        R.append(")[...])");
        Completable log = channelSyncAgentImpl.log(K1, R.toString());
        Single W1 = a2.b.a.a.a.W1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str, i2, i3, (Collection<String>) sortedSet, (Collection<String>) sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$1.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
        StringBuilder S = a2.b.a.a.a.S(" -> getNonEmptyChatIdsFromDb(userId = ", str, ", offset = ", i2, ", requestSize = ");
        a2.b.a.a.a.h1(S, i3, ", tags = ", sortedSet, ", excludeTags = ");
        Completable flatMapCompletable = a2.b.a.a.a.Y1(S, sortedSet2, ')', channelSyncAgentImpl, W1).flatMapCompletable(new ChannelSyncAgentImpl$deleteChatsThatDoNotMatchTheOnesOnServerFromDb$1(channelSyncAgentImpl, str, list));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "getNonEmptyChatIdsFromDb…          )\n            }");
        StringBuilder R2 = a2.b.a.a.a.R(" -> deleteChatsThatDoNotMatchTheOnesOnServerFromDb(userId = ", str, ", chatsFromServer = (");
        String str8 = ")[...], offset = ";
        a2.b.a.a.a.t1(list, R2, str8, i2, ", requestSize = ");
        a2.b.a.a.a.h1(R2, i3, ", tags = ", sortedSet, ", excludeTags = ");
        Completable andThen = log.andThen(a2.b.a.a.a.O1(R2, sortedSet2, ')', channelSyncAgentImpl, flatMapCompletable));
        if (i2 == 0) {
            long j2 = Long.MIN_VALUE;
            for (Iterator it2 = list.iterator(); it2.hasNext(); it2 = it2) {
                j2 = t6.v.e.coerceAtLeast(j2, ((Channel) it2.next()).getUpdated());
            }
            str5 = ", tags = ";
            str6 = ", excludeTags = ";
            str7 = ")[...], tags = ";
            str4 = ", requestSize = ";
            str2 = "getNonEmptyChatIdsFromDb…          )\n            }";
            str3 = " -> getNonEmptyChatIdsFromDb(userId = ";
            Completable deleteNonEmptyChannelsNewerThatTimestamp = channelSyncAgentImpl.g.deleteNonEmptyChannelsNewerThatTimestamp(str, j2, sortedSet, sortedSet2);
            StringBuilder R3 = a2.b.a.a.a.R(" -> deleteNewerDeprecatedChats(userId = ", str, ", chatsFromServer = (");
            a2.b.a.a.a.v1(list, R3, str7, sortedSet, str6);
            andThen = andThen.andThen(a2.b.a.a.a.O1(R3, sortedSet2, ')', channelSyncAgentImpl, deleteNonEmptyChannelsNewerThatTimestamp));
        } else {
            str7 = ")[...], tags = ";
            str6 = ", excludeTags = ";
            str4 = ", requestSize = ";
            str2 = "getNonEmptyChatIdsFromDb…          )\n            }";
            str3 = " -> getNonEmptyChatIdsFromDb(userId = ";
            str5 = ", tags = ";
        }
        Iterator it3 = list.iterator();
        long j3 = Long.MIN_VALUE;
        while (it3.hasNext()) {
            j3 = t6.v.e.coerceAtLeast(j3, ((Channel) it3.next()).getUpdated());
        }
        long j4 = Long.MAX_VALUE;
        Iterator it4 = list.iterator();
        while (it4.hasNext()) {
            j4 = t6.v.e.coerceAtMost(j4, ((Channel) it4.next()).getUpdated());
            str8 = str8;
        }
        Single X1 = a2.b.a.a.a.X1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str, j3, j4, sortedSet, sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$2.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
        StringBuilder T = a2.b.a.a.a.T(str3, str, ", olderOrEqualToTimestamp = ", j3);
        a2.b.a.a.a.l1(T, ", newerOrEqualToTimestamp = ", j4, str5);
        Completable flatMapCompletable2 = channelSyncAgentImpl.log(X1, a2.b.a.a.a.z(T, sortedSet, str6, sortedSet2, ')')).flatMapCompletable(new ChannelSyncAgentImpl$deleteDeprecatedChatsInTheMiddle$3(channelSyncAgentImpl, str, list));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable2, str2);
        StringBuilder R4 = a2.b.a.a.a.R(" -> deleteDeprecatedChatsInTheMiddle(userId = ", str, ", chatsFromServer = (");
        a2.b.a.a.a.v1(list, R4, str7, sortedSet, str6);
        Completable andThen2 = andThen.andThen(a2.b.a.a.a.O1(R4, sortedSet2, ')', channelSyncAgentImpl, flatMapCompletable2));
        Intrinsics.checkNotNullExpressionValue(andThen2, "putChatsFromServerInDb(\n…          )\n            )");
        Single flatMap = andThen2.toSingleDefault(Unit.INSTANCE).flatMap(new Function<Unit, SingleSource<? extends T>>(str, list, i2, sortedSet, sortedSet2) { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgentImpl$syncPartialPageOfChatsFromServerWithDb$$inlined$flatMapSingle$2
            public final /* synthetic */ String b;
            public final /* synthetic */ List c;
            public final /* synthetic */ int d;
            public final /* synthetic */ SortedSet e;
            public final /* synthetic */ SortedSet f;

            {
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
            }

            public final SingleSource<? extends T> apply(@NotNull Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "it");
                return ChannelSyncAgentImpl.access$getOldestSyncedChatTimestamp(ChannelSyncAgentImpl.this, this.b, this.c, this.d, this.e, this.f);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "toSingleDefault(Unit).flatMap { singleFactory() }");
        Single flatMap2 = flatMap.flatMap(new ChannelSyncAgentImpl$syncPartialPageOfChatsFromServerWithDb$3(channelSyncAgentImpl, str, sortedSet, sortedSet2));
        Intrinsics.checkNotNullExpressionValue(flatMap2, "putChatsFromServerInDb(\n…          )\n            }");
        StringBuilder R5 = a2.b.a.a.a.R(" -> syncPartialPageOfChatsFromServerWithDb(userId = ", str, ", chatsFromServer = (");
        a2.b.a.a.a.t1(list, R5, str8, i2, str4);
        a2.b.a.a.a.h1(R5, i3, str5, sortedSet, str6);
        return a2.b.a.a.a.Y1(R5, sortedSet2, ')', channelSyncAgentImpl, flatMap2);
    }

    @Override // com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent
    @NotNull
    public Single<String> createAvitoChat(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Single<R> flatMap = this.e.withMessengerApi().observeOn(this.j.computation()).flatMap(new c(this, str2)).flatMap(new d(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "client.withMessengerApi(…toSingle())\n            }");
        return this.l.callSingle(log(flatMap, a2.b.a.a.a.e("createAvitoChat(userId = ", str, ", source = ", str2, ')')), "createAvitoChat", x.setOf(ChannelsKey.All.INSTANCE), this.j.computation());
    }

    @Override // com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent
    @NotNull
    public Single<String> createChat(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "itemId");
        Single<R> flatMap = this.e.withMessengerApi().observeOn(this.j.computation()).flatMap(new e(this, str2, str3)).flatMap(new f(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "client.withMessengerApi(…toSingle())\n            }");
        StringBuilder W = a2.b.a.a.a.W("createChat(userId = ", str, ", itemId = ", str2, ", source = ");
        W.append(str3);
        W.append(')');
        return this.l.callSingle(log(flatMap, W.toString()), "createChat", x.setOf(ChannelsKey.All.INSTANCE), this.j.computation());
    }

    @Override // com.avito.android.messenger.channels.mvi.sync.ChatAndDraftEraser
    @NotNull
    public Completable deleteChatAndAllDraftsWithInterlocutorFromDb(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        a2.b.a.a.a.b1(str, ChannelContext.Item.USER_ID, str2, "interlocutorId", str3, "channelId", str4, "itemId");
        Completable deleteChatAndAllDraftsWithInterlocutorFromDb = this.a.deleteChatAndAllDraftsWithInterlocutorFromDb(str, str2, str3, str4);
        StringBuilder W = a2.b.a.a.a.W("deleteChatAndAllDraftsWithInterlocutorFromDb(userId = ", str, ", interlocutorId = ", str2, ", channelId = ");
        W.append(str3);
        W.append(", itemId = ");
        W.append(str4);
        W.append(')');
        return log(deleteChatAndAllDraftsWithInterlocutorFromDb, W.toString());
    }

    @Override // com.avito.android.messenger.channels.mvi.sync.ChatAndDraftEraser
    @NotNull
    public Completable deleteChatAndDraftFromDb(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return log(this.a.deleteChatAndDraftFromDb(str, str2), a2.b.a.a.a.e("deleteChatAndDraftFromDb(userId = ", str, ", channelId = ", str2, ')'));
    }

    @Override // com.avito.android.messenger.channels.mvi.sync.ChatAndDraftEraser
    @NotNull
    public Completable deleteChatAndDraftFromEverywhere(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return log(this.a.deleteChatAndDraftFromEverywhere(str, str2), a2.b.a.a.a.e("deleteChatAndDraftFromEverywhere(userId = ", str, ", channelId = ", str2, ')'));
    }

    @Override // com.avito.android.messenger.channels.mvi.sync.LocalChannelEditor
    @NotNull
    public Completable deleteContextActions(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return log(this.c.deleteContextActions(str, str2), a2.b.a.a.a.e("deleteContextActions(userId = ", str, ", channelId = ", str2, ')'));
    }

    @Override // com.avito.android.util.RxLogger
    @NotNull
    public Completable log(@NotNull Completable completable, @NotNull String str) {
        Intrinsics.checkNotNullParameter(completable, "$this$log");
        Intrinsics.checkNotNullParameter(str, "message");
        return this.o.log(completable, str);
    }

    @Override // com.avito.android.util.RxLogger
    @NotNull
    public <T> Observable<T> log(@NotNull Observable<T> observable, @NotNull String str) {
        Intrinsics.checkNotNullParameter(observable, "$this$log");
        Intrinsics.checkNotNullParameter(str, "message");
        return this.o.log(observable, str);
    }

    @Override // com.avito.android.util.RxLogger
    @NotNull
    public <T> Single<T> log(@NotNull Single<T> single, @NotNull String str) {
        Intrinsics.checkNotNullParameter(single, "$this$log");
        Intrinsics.checkNotNullParameter(str, "message");
        return this.o.log(single, str);
    }

    @Override // com.avito.android.messenger.channels.mvi.sync.ChannelsBackendNotificationsHandler
    public void subscribeToUserIdAndBackendNotifications() {
        this.b.subscribeToUserIdAndBackendNotifications();
    }

    @Override // com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent
    @NotNull
    public Completable syncChat(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Completable flatMapCompletable = this.e.getChannel(str2).observeOn(this.j.computation()).flatMapCompletable(new g(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "client.getChannel(channe…d, channel)\n            }");
        Completable log = log(flatMapCompletable, a2.b.a.a.a.e("syncChat(userId = ", str, ", channelId = ", str2, ')'));
        RxFairCompositeWriteLock<ChannelsKey> rxFairCompositeWriteLock = this.l;
        Set<? extends ChannelsKey> of = x.setOf(new ChannelsKey.Id(str2));
        Scheduler computation = this.j.computation();
        Single<T> singleDefault = log.toSingleDefault(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(singleDefault, "this.toSingleDefault(Unit)");
        Completable ignoreElement = rxFairCompositeWriteLock.callSingle(singleDefault, "syncChat", of, computation).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "lock.callSingle(\n       …ler\n    ).ignoreElement()");
        return ignoreElement;
    }

    @Override // com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent
    @NotNull
    public Single<ChannelSyncAgent.SyncChatsResult> syncLatestChats(@NotNull String str, @NotNull SortedSet<String> sortedSet, @NotNull SortedSet<String> sortedSet2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(sortedSet, "tags");
        Intrinsics.checkNotNullParameter(sortedSet2, "excludeTags");
        int i2 = this.m;
        Single<List<Channel>> observeOn = this.e.getChannels(0, Integer.valueOf(i2), sortedSet, sortedSet2).observeOn(this.j.computation());
        Intrinsics.checkNotNullExpressionValue(observeOn, "client.getChannels(\n    …schedulers.computation())");
        Single flatMap = log(observeOn, a2.b.a.a.a.z(a2.b.a.a.a.N(" -> getChatsFromServer(offset = ", 0, ", requestSize = ", i2, ", tags = "), sortedSet, ", excludeTags = ", sortedSet2, ')')).flatMap(new h(this, str, sortedSet, sortedSet2));
        Intrinsics.checkNotNullExpressionValue(flatMap, "getChatsFromServer(\n    …          )\n            }");
        StringBuilder sb = new StringBuilder();
        sb.append("syncLatestChats(userId = ");
        sb.append(str);
        sb.append(", tags = ");
        sb.append(sortedSet);
        sb.append(", excludeTags = ");
        return this.l.callSingle(a2.b.a.a.a.Y1(sb, sortedSet2, ')', this, flatMap), "syncLatestChats", x.setOf(new ChannelsKey.Tags(sortedSet, sortedSet2)), this.j.computation());
    }

    @Override // com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent
    @NotNull
    public Single<ChannelSyncAgent.SyncChatsResult> syncNextPage(@NotNull String str, int i2, @NotNull SortedSet<String> sortedSet, @NotNull SortedSet<String> sortedSet2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(sortedSet, "tags");
        Intrinsics.checkNotNullParameter(sortedSet2, "excludeTags");
        int i3 = this.n;
        Single<List<Channel>> observeOn = this.e.getChannels(i2, Integer.valueOf(i3), sortedSet, sortedSet2).observeOn(this.j.computation());
        Intrinsics.checkNotNullExpressionValue(observeOn, "client.getChannels(\n    …schedulers.computation())");
        Single flatMap = log(observeOn, a2.b.a.a.a.z(a2.b.a.a.a.N(" -> getChatsFromServer(offset = ", i2, ", requestSize = ", i3, ", tags = "), sortedSet, ", excludeTags = ", sortedSet2, ')')).flatMap(new i(this, str, i2, sortedSet, sortedSet2));
        Intrinsics.checkNotNullExpressionValue(flatMap, "getChatsFromServer(\n    …          )\n            }");
        StringBuilder sb = new StringBuilder();
        sb.append("syncNextPage(userId = ");
        sb.append(str);
        sb.append(", currentOffset = ");
        sb.append(i2);
        sb.append(", tags = ");
        return this.l.callSingle(log(flatMap, a2.b.a.a.a.z(sb, sortedSet, ", excludeTags = ", sortedSet2, ')')), "syncNextPage", x.setOf(new ChannelsKey.Tags(sortedSet, sortedSet2)), this.j.computation());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public ChannelSyncAgentImpl(@NotNull AccountStateProvider accountStateProvider, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull MessengerEntityConverter messengerEntityConverter, @NotNull ChannelRepo channelRepo, @NotNull DraftRepoWriter draftRepoWriter, @NotNull Features features, @NotNull SchedulersFactory schedulersFactory, @NotNull TimeSource timeSource) {
        this(accountStateProvider, messengerClient, messengerEntityConverter, channelRepo, draftRepoWriter, features, schedulersFactory, timeSource, new RxFairCompositeWriteLock("ChannelSyncAgent-lock", new a(schedulersFactory), a2.a.a.o1.b.b.d.c.a, false, null, null, null, 112, null), 30, 10);
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(messengerEntityConverter, "messengerEntityConverter");
        Intrinsics.checkNotNullParameter(channelRepo, "channelRepo");
        Intrinsics.checkNotNullParameter(draftRepoWriter, "draftRepoWriter");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
    }

    public static final Single access$getNonEmptyChatIdsFromDb(ChannelSyncAgentImpl channelSyncAgentImpl, String str, long j2, long j3, SortedSet sortedSet, SortedSet sortedSet2) {
        Objects.requireNonNull(channelSyncAgentImpl);
        Single X1 = a2.b.a.a.a.X1(a2.b.a.a.a.P1(channelSyncAgentImpl, channelSyncAgentImpl.g.getNonEmptyChannelIds(str, j2, j3, sortedSet, sortedSet2)), ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$2.INSTANCE, "channelRepo.getNonEmptyC…          .firstOrError()");
        StringBuilder T = a2.b.a.a.a.T(" -> getNonEmptyChatIdsFromDb(userId = ", str, ", olderOrEqualToTimestamp = ", j2);
        a2.b.a.a.a.l1(T, ", newerOrEqualToTimestamp = ", j3, ", tags = ");
        return channelSyncAgentImpl.log(X1, a2.b.a.a.a.z(T, sortedSet, ", excludeTags = ", sortedSet2, ')'));
    }

    public static final Completable access$deleteChatsThatDoNotMatchTheOnesOnServerFromDb(ChannelSyncAgentImpl channelSyncAgentImpl, String str, List list, List list2) {
        Objects.requireNonNull(channelSyncAgentImpl);
        List<Channel> sortedWith = CollectionsKt___CollectionsKt.sortedWith(list2, new Comparator<T>() { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgentImpl$deleteChatsThatDoNotMatchTheOnesOnServerFromDb$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return a.compareValues(Long.valueOf(t2.getUpdated()), Long.valueOf(t.getUpdated()));
            }
        });
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(sortedWith, 10));
        for (Channel channel : sortedWith) {
            arrayList.add(channel.getChannelId());
        }
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!Intrinsics.areEqual(str2, (String) arrayList.get(i2))) {
                arrayList2.add(str2);
            } else if (i2 < arrayList.size() - 1) {
                i2++;
            }
        }
        Completable K1 = a2.b.a.a.a.K1(channelSyncAgentImpl, channelSyncAgentImpl.g.deleteChannelsById(str, arrayList2), "channelRepo.deleteChanne…schedulers.computation())");
        StringBuilder R = a2.b.a.a.a.R(" -> deleteChatsThatDoNotMatchTheOnesOnServerFromDb(userId = ", str, ", chatIdsFromDb = (");
        R.append(list.size());
        R.append(")[...], chatsFromServer = (");
        R.append(list2.size());
        R.append(")[...])");
        return channelSyncAgentImpl.log(K1, R.toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ChannelSyncAgentImpl(@NotNull AccountStateProvider accountStateProvider, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull MessengerEntityConverter messengerEntityConverter, @NotNull ChannelRepo channelRepo, @NotNull DraftRepoWriter draftRepoWriter, @NotNull Features features, @NotNull SchedulersFactory schedulersFactory, @NotNull TimeSource timeSource, int i2, int i3) {
        this(accountStateProvider, messengerClient, messengerEntityConverter, channelRepo, draftRepoWriter, features, schedulersFactory, timeSource, new RxFairCompositeWriteLock("ChannelSyncAgent-lock", new b(schedulersFactory), a2.a.a.o1.b.b.d.c.a, false, null, null, null, 112, null), i2, i3);
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(messengerEntityConverter, "messengerEntityConverter");
        Intrinsics.checkNotNullParameter(channelRepo, "channelRepo");
        Intrinsics.checkNotNullParameter(draftRepoWriter, "draftRepoWriter");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
    }
}
