package com.avito.android.messenger.conversation.mvi.context;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.ChatOpenError;
import com.avito.android.messenger.analytics.OpenItemPageFromMessenger;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.channels.mvi.common.v4.Action;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.common.v4.MutatorSingle;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker;
import com.avito.android.messenger.channels.mvi.common.v4.SimpleReducerQueue;
import com.avito.android.messenger.channels.mvi.data.ChannelRepo;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.conversation.OpenedFrom;
import com.avito.android.messenger.conversation.analytics.ChannelTracker;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.di.ChannelId;
import com.avito.android.messenger.service.OpenErrorTrackerScheduler;
import com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgent;
import com.avito.android.messenger.util.ThrowablesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.LogsT;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.UnauthorizedException;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.rx.arrow.OptionKt;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import t6.n.e;
import t6.n.y;
import t6.n.z;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\nYZ[\\]^_`abBz\u0012\b\b\u0001\u0010 \u001a\u00020\u001d\u0012\u0006\u0010S\u001a\u00020R\u0012\u0006\u0010,\u001a\u00020)\u0012\u0011\u0010Q\u001a\r\u0012\t\u0012\u00070M¢\u0006\u0002\bN0L\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00030T¢\u0006\u0004\bV\u0010WBn\b\u0017\u0012\b\b\u0001\u0010 \u001a\u00020\u001d\u0012\u0006\u0010S\u001a\u00020R\u0012\u0006\u0010,\u001a\u00020)\u0012\u0011\u0010Q\u001a\r\u0012\t\u0012\u00070M¢\u0006\u0002\bN0L\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\bV\u0010XJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\f\u0010\nR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010\u000fR\"\u00104\u001a\b\u0012\u0004\u0012\u00020\u001d0/8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\"\u00107\u001a\b\u0012\u0004\u0012\u00020\u001d0/8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u00103R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010\u001fR\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\"\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00060F8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR!\u0010Q\u001a\r\u0012\t\u0012\u00070M¢\u0006\u0002\bN0L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006c"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "", "isRetry", "", "initialDataRequest", "(Z)V", "refresh", "()V", "openAdvert", "onCleared", "Lio/reactivex/disposables/CompositeDisposable;", "t", "Lio/reactivex/disposables/CompositeDisposable;", "afterInitSubscriptions", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;", "channelRepo", "Lcom/avito/android/messenger/conversation/OpenedFrom;", "C", "Lcom/avito/android/messenger/conversation/OpenedFrom;", "openedFrom", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "F", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "channelSyncAgent", "", "w", "Ljava/lang/String;", "channelId", "Lcom/avito/android/analytics/Analytics;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/service/OpenErrorTrackerScheduler;", "B", "Lcom/avito/android/messenger/service/OpenErrorTrackerScheduler;", "openErrorTrackerScheduler", "Lcom/avito/android/account/AccountStateProvider;", "x", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "s", "allSubscriptions", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", VKApiConst.Q, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getOpenMyAdvertScreenStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "openMyAdvertScreenStream", "p", "getOpenAdvertScreenStream", "openAdvertScreenStream", "Ljava/util/concurrent/atomic/AtomicLong;", "u", "Ljava/util/concurrent/atomic/AtomicLong;", "initialDataRequestId", VKApiConst.VERSION, "userLastActivityRequestId", "Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "D", "Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "perfTracker", "Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgent;", "z", "Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgent;", "userLastActivitySyncAgent", "Lcom/jakewharton/rxrelay2/PublishRelay;", "r", "Lcom/jakewharton/rxrelay2/PublishRelay;", "getLoggedOutStream", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "loggedOutStream", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "y", "Lru/avito/messenger/MessengerClient;", "client", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "reducerQueue", "<init>", "(Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/account/AccountStateProvider;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgent;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/messenger/service/OpenErrorTrackerScheduler;Lcom/avito/android/messenger/conversation/OpenedFrom;Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;)V", "(Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/account/AccountStateProvider;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgent;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/messenger/service/OpenErrorTrackerScheduler;Lcom/avito/android/messenger/conversation/OpenedFrom;Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;)V", AuthSource.SEND_ABUSE, "ChannelUpdatedMutator", "ChatTypingStartMutator", "ChatTypingStopMutator", "ConnectingStateChangedMutator", "InitialDataRequestComposite", "OnReconnectAction", "OpenAdvertAction", "RefreshMutator", "UserIdUpdatedMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelContextInteractorImpl extends BaseMviEntityWithReducerQueue<ChannelContextInteractor.State> implements ChannelContextInteractor {
    public final Analytics A;
    public final OpenErrorTrackerScheduler B;
    public final OpenedFrom C;
    public final ChannelTracker D;
    public final ChannelRepo E;
    public final ChannelSyncAgent F;
    @NotNull
    public final SingleLiveEvent<String> p;
    @NotNull
    public final SingleLiveEvent<String> q;
    @NotNull
    public final PublishRelay<Unit> r;
    public final CompositeDisposable s;
    public final CompositeDisposable t;
    public final AtomicLong u;
    public final String v;
    public final String w;
    public final AccountStateProvider x;
    public final MessengerClient<AvitoMessengerApi> y;
    public final UserLastActivitySyncAgent z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$ChannelUpdatedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;)Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "Lcom/avito/android/remote/model/messenger/Channel;", "d", "Lcom/avito/android/remote/model/messenger/Channel;", "newChannel", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl;Lcom/avito/android/remote/model/messenger/Channel;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ChannelUpdatedMutator extends Mutator<ChannelContextInteractor.State> {
        public final Channel d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChannelUpdatedMutator(@NotNull ChannelContextInteractorImpl channelContextInteractorImpl, Channel channel) {
            super(null, "newChannel = " + channel, 1, null);
            Intrinsics.checkNotNullParameter(channel, "newChannel");
            this.d = channel;
        }

        @NotNull
        public ChannelContextInteractor.State invoke(@NotNull ChannelContextInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            return ChannelContextInteractor.State.copy$default(state, null, new Loading.Success(this.d), null, false, 13, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$ChatTypingStartMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;)Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "", "d", "Ljava/lang/String;", "getTypingUserId", "()Ljava/lang/String;", "typingUserId", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ChatTypingStartMutator extends Mutator<ChannelContextInteractor.State> {
        @NotNull
        public final String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChatTypingStartMutator(@NotNull ChannelContextInteractorImpl channelContextInteractorImpl, String str) {
            super(null, "typingUserId=" + str, 1, null);
            Intrinsics.checkNotNullParameter(str, "typingUserId");
            this.d = str;
        }

        @NotNull
        public final String getTypingUserId() {
            return this.d;
        }

        @NotNull
        public ChannelContextInteractor.State invoke(@NotNull ChannelContextInteractor.State state) {
            ChannelContextInteractor.State state2;
            Intrinsics.checkNotNullParameter(state, "oldState");
            Loading<Channel> channelState = state.getChannelState();
            if (channelState instanceof Loading.Success) {
                Channel channel = (Channel) ((Loading.Success) channelState).getValue();
                Set<String> typingUserIds = state.getTypingUserIds();
                String str = this.d;
                Set mutableSet = CollectionsKt___CollectionsKt.toMutableSet(typingUserIds);
                mutableSet.remove(str);
                mutableSet.add(str);
                state2 = ChannelContextInteractor.State.copy$default(state, null, null, mutableSet, false, 11, null);
            } else {
                state2 = null;
            }
            return state2 != null ? state2 : state;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$ChatTypingStopMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;)Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "", "d", "Ljava/lang/String;", "getTypingUserId", "()Ljava/lang/String;", "typingUserId", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ChatTypingStopMutator extends Mutator<ChannelContextInteractor.State> {
        @NotNull
        public final String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChatTypingStopMutator(@NotNull ChannelContextInteractorImpl channelContextInteractorImpl, String str) {
            super(null, "typingUserId = " + str, 1, null);
            Intrinsics.checkNotNullParameter(str, "typingUserId");
            this.d = str;
        }

        @NotNull
        public final String getTypingUserId() {
            return this.d;
        }

        @NotNull
        public ChannelContextInteractor.State invoke(@NotNull ChannelContextInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            return state.getTypingUserIds().contains(this.d) ? ChannelContextInteractor.State.copy$default(state, null, null, z.minus(state.getTypingUserIds(), this.d), false, 11, null) : state;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$ConnectingStateChangedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;)Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "", "d", "Z", "isConnecting", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ConnectingStateChangedMutator extends Mutator<ChannelContextInteractor.State> {
        public final boolean d;

        public ConnectingStateChangedMutator(ChannelContextInteractorImpl channelContextInteractorImpl, boolean z) {
            super(null, "isConnecting=" + z, 1, null);
            this.d = z;
        }

        @NotNull
        public ChannelContextInteractor.State invoke(@NotNull ChannelContextInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            return this.d != state.isConnecting() ? ChannelContextInteractor.State.copy$default(state, null, null, null, this.d, 7, null) : state;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0015\u0016\u0017B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR.\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\f0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$InitialDataRequestComposite;", "Lcom/avito/android/messenger/channels/mvi/common/v4/CompositeReducible;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "", "e", "Z", "isRetry", "", "f", "J", "id", "Lkotlin/Function0;", "", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "d", "Lkotlin/jvm/functions/Function0;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "block", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl;ZJ)V", "GetChannelMutator", "GetUserIdMutator", "SetInProgressMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class InitialDataRequestComposite extends CompositeReducible<ChannelContextInteractor.State> {
        @NotNull
        public final Function0<List<Reducible<ChannelContextInteractor.State>>> d = new a(this);
        public final boolean e;
        public final long f;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;)Lio/reactivex/Single;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$InitialDataRequestComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class GetChannelMutator extends MutatorSingle<ChannelContextInteractor.State> {

            /* compiled from: java-style lambda group */
            public static final class a<T> implements Consumer<ChannelContextInteractor.State> {
                public final /* synthetic */ int a;
                public final /* synthetic */ Object b;

                public a(int i, Object obj) {
                    this.a = i;
                    this.b = obj;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r4v5, types: [com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Function$0] */
                /* JADX WARNING: Unknown variable types count: 1 */
                @Override // io.reactivex.functions.Consumer
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void accept(com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor.State r7) {
                    /*
                    // Method dump skipped, instructions count: 410
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl.InitialDataRequestComposite.GetChannelMutator.a.accept(java.lang.Object):void");
                }
            }

            public static final class b<T, R> implements Function<Throwable, ChannelContextInteractor.State> {
                public final /* synthetic */ GetChannelMutator a;
                public final /* synthetic */ ChannelContextInteractor.State b;

                public b(GetChannelMutator getChannelMutator, ChannelContextInteractor.State state) {
                    this.a = getChannelMutator;
                    this.b = state;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // io.reactivex.functions.Function
                public ChannelContextInteractor.State apply(Throwable th) {
                    Throwable th2 = th;
                    Intrinsics.checkNotNullParameter(th2, "it");
                    ChannelContextInteractorImpl.this.D.trackContextLoadError();
                    Throwable avitoException = ThrowablesKt.toAvitoException(th2);
                    ChannelContextInteractorImpl.this.B.scheduleTrackChatOpenError(ChannelContextInteractorImpl.this.w, ChannelContextInteractorImpl.this.C == OpenedFrom.PUSH ? ChatOpenError.ERROR_ON_CHAT_LOADING_FROM_PUSH : ChatOpenError.ERROR_ON_CHAT_LOADING_FROM_LIST);
                    return ChannelContextInteractor.State.copy$default(this.b, null, new Loading.Error(avitoException), null, false, 13, null);
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public GetChannelMutator() {
                super(InitialDataRequestComposite.this.getName() + ".GetChannelMutator", InitialDataRequestComposite.this.getParams());
            }

            public static final Single access$updateStateAndScheduleRefresh(GetChannelMutator getChannelMutator, ChannelContextInteractor.State state, String str, Channel channel) {
                Objects.requireNonNull(getChannelMutator);
                Single doAfterSuccess = Singles.toSingle(ChannelContextInteractor.State.copy$default(state, str, new Loading.Success(channel), null, false, 12, null)).doAfterSuccess(new ChannelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$updateStateAndScheduleRefresh$1(getChannelMutator));
                Intrinsics.checkNotNullExpressionValue(doAfterSuccess, "oldState.copy(\n         …h()\n                    }");
                return doAfterSuccess;
            }

            @NotNull
            public Single<ChannelContextInteractor.State> invoke(@NotNull ChannelContextInteractor.State state) {
                Intrinsics.checkNotNullParameter(state, "oldState");
                Loading<Channel> channelState = state.getChannelState();
                if (!(channelState instanceof Loading.InProgress)) {
                    channelState = null;
                }
                Loading.InProgress inProgress = (Loading.InProgress) channelState;
                if (inProgress == null || inProgress.getId() != InitialDataRequestComposite.this.f) {
                    return Singles.toSingle(state);
                }
                ChannelContextInteractorImpl channelContextInteractorImpl = ChannelContextInteractorImpl.this;
                Observable map = InteropKt.toV2(channelContextInteractorImpl.x.userId()).observeOn(channelContextInteractorImpl.getSchedulerForReducibles()).map(ChannelContextInteractorImpl$userIdOptionObservable$1.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(map, "accountStateProvider.use….toOption()\n            }");
                Single flatMap = map.firstOrError().flatMap(new ChannelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$invoke$$inlined$withUserId$1(this, state));
                Intrinsics.checkNotNullExpressionValue(flatMap, "userIdOptionObservable(s…          )\n            }");
                Single<ChannelContextInteractor.State> subscribeOn = flatMap.observeOn(ChannelContextInteractorImpl.this.getSchedulerForReducibles()).doOnSuccess(new a(0, this)).doAfterSuccess(new a(1, this)).onErrorReturn(new b(this, state)).subscribeOn(ChannelContextInteractorImpl.this.getSchedulerForReducibles());
                Intrinsics.checkNotNullExpressionValue(subscribeOn, "withUserId(schedulerForR…n(schedulerForReducibles)");
                return subscribeOn;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$InitialDataRequestComposite$GetUserIdMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$InitialDataRequestComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class GetUserIdMutator extends MutatorSingle<ChannelContextInteractor.State> {

            public static final class a extends Lambda implements Function1<ChannelContextInteractor.State, Single<ChannelContextInteractor.State>> {
                public final /* synthetic */ InitialDataRequestComposite a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(InitialDataRequestComposite initialDataRequestComposite) {
                    super(1);
                    this.a = initialDataRequestComposite;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public Single<ChannelContextInteractor.State> invoke(ChannelContextInteractor.State state) {
                    ChannelContextInteractor.State state2 = state;
                    Intrinsics.checkNotNullParameter(state2, "oldState");
                    if (!this.a.e) {
                        Loading<Channel> channelState = state2.getChannelState();
                        if (!(channelState instanceof Loading.InProgress)) {
                            channelState = null;
                        }
                        Loading.InProgress inProgress = (Loading.InProgress) channelState;
                        if (inProgress != null && inProgress.getId() == this.a.f) {
                            ChannelContextInteractorImpl channelContextInteractorImpl = ChannelContextInteractorImpl.this;
                            Observable map = InteropKt.toV2(channelContextInteractorImpl.x.userId()).observeOn(channelContextInteractorImpl.getSchedulerForReducibles()).map(ChannelContextInteractorImpl$userIdOptionObservable$1.INSTANCE);
                            Intrinsics.checkNotNullExpressionValue(map, "accountStateProvider.use….toOption()\n            }");
                            Single flatMap = map.firstOrError().flatMap(new ChannelContextInteractorImpl$InitialDataRequestComposite$GetUserIdMutator$1$$special$$inlined$withUserId$1(state2));
                            Intrinsics.checkNotNullExpressionValue(flatMap, "userIdOptionObservable(s…          )\n            }");
                            Single<ChannelContextInteractor.State> onErrorReturn = flatMap.onErrorReturn(new a2.a.a.o1.d.a0.a.a(this, state2));
                            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "withUserId(schedulerForR…ate\n                    }");
                            return onErrorReturn;
                        }
                    }
                    return Singles.toSingle(state2);
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public GetUserIdMutator(InitialDataRequestComposite initialDataRequestComposite) {
                super(initialDataRequestComposite.getName() + ".GetUserIdMutator", initialDataRequestComposite.getParams(), new a(initialDataRequestComposite));
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$InitialDataRequestComposite$SetInProgressMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$InitialDataRequestComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class SetInProgressMutator extends Mutator<ChannelContextInteractor.State> {

            public static final class a extends Lambda implements Function1<ChannelContextInteractor.State, ChannelContextInteractor.State> {
                public final /* synthetic */ InitialDataRequestComposite a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(InitialDataRequestComposite initialDataRequestComposite) {
                    super(1);
                    this.a = initialDataRequestComposite;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public ChannelContextInteractor.State invoke(ChannelContextInteractor.State state) {
                    ChannelContextInteractor.State state2 = state;
                    Intrinsics.checkNotNullParameter(state2, "oldState");
                    String tag = ChannelContextInteractorImpl.this.getTAG();
                    StringBuilder L = a2.b.a.a.a.L("InitialDataRequestComposite.SetInProgressMutator(isRetry=");
                    L.append(this.a.e);
                    L.append(").invoke()");
                    LogsT.verbose$default(tag, L.toString(), null, 4, null);
                    if (!(state2.getChannelState() instanceof Loading.Empty) && !this.a.e) {
                        return state2;
                    }
                    ChannelContextInteractorImpl.this.D.startMessagesLoading();
                    ChannelContextInteractorImpl.this.D.startContextLoading();
                    return ChannelContextInteractor.State.copy$default(state2, null, new Loading.InProgress(this.a.f), null, false, 13, null);
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public SetInProgressMutator(InitialDataRequestComposite initialDataRequestComposite) {
                super(initialDataRequestComposite.getName() + ".SetInProgressMutator", initialDataRequestComposite.getParams(), new a(initialDataRequestComposite));
            }
        }

        public static final class a extends Lambda implements Function0<List<? extends Reducible<ChannelContextInteractor.State>>> {
            public final /* synthetic */ InitialDataRequestComposite a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(InitialDataRequestComposite initialDataRequestComposite) {
                super(0);
                this.a = initialDataRequestComposite;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends Reducible<ChannelContextInteractor.State>> invoke() {
                String tag = ChannelContextInteractorImpl.this.getTAG();
                StringBuilder L = a2.b.a.a.a.L("InitialDataRequestComposite(isRetry=");
                L.append(this.a.e);
                L.append(").block()");
                LogsT.verbose$default(tag, L.toString(), null, 4, null);
                return CollectionsKt__CollectionsKt.listOf((Object[]) new Reducible[]{new SetInProgressMutator(this.a), new GetUserIdMutator(this.a), new GetChannelMutator()});
            }
        }

        public InitialDataRequestComposite(boolean z, long j) {
            super("InitialDataRequestComposite", "isRetry=" + z, null, 4, null);
            this.e = z;
            this.f = j;
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible
        @NotNull
        public Function0<List<Reducible<ChannelContextInteractor.State>>> getBlock() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$OnReconnectAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;)V", "", "d", "Z", "notificationQueueWasRestored", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class OnReconnectAction extends Action<ChannelContextInteractor.State> {
        public final boolean d;

        public OnReconnectAction(boolean z) {
            super(null, null, 3, null);
            this.d = z;
        }

        public void invoke(@NotNull ChannelContextInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (!(state.getChannelState() instanceof Loading.Success)) {
                ChannelContextInteractorImpl.this.initialDataRequest(true);
            } else if (!this.d) {
                ChannelContextInteractorImpl.this.refresh();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$OpenAdvertAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;)V", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class OpenAdvertAction extends Action<ChannelContextInteractor.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public OpenAdvertAction() {
            super(null, null, 3, null);
        }

        public void invoke(@NotNull ChannelContextInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            Loading<Channel> channelState = state.getChannelState();
            ChannelContext.Item item = null;
            if (channelState instanceof Loading.Success) {
                ChannelContext context = ((Channel) ((Loading.Success) channelState).getValue()).getContext();
                if (context instanceof ChannelContext.Item) {
                    item = context;
                }
                item = item;
            }
            if (item != null) {
                if (Intrinsics.areEqual(item.getUserId(), state.getCurrentUserId())) {
                    ChannelContextInteractorImpl.this.getOpenMyAdvertScreenStream().postValue(item.getId());
                } else {
                    ChannelContextInteractorImpl.this.getOpenAdvertScreenStream().postValue(item.getId());
                }
                Loading<Channel> channelState2 = state.getChannelState();
                if (channelState2 instanceof Loading.Success) {
                    ChannelContextInteractorImpl.this.A.track(new OpenItemPageFromMessenger(((Channel) ((Loading.Success) channelState2).getValue()).getChannelId()));
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$RefreshMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;)Lio/reactivex/Single;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class RefreshMutator extends MutatorSingle<ChannelContextInteractor.State> {

        public static final class a<T, R> implements Function<Throwable, ChannelContextInteractor.State> {
            public final /* synthetic */ ChannelContextInteractor.State a;

            public a(ChannelContextInteractor.State state) {
                this.a = state;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public ChannelContextInteractor.State apply(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                return this.a;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public RefreshMutator() {
            super(null, null, 3, null);
        }

        @NotNull
        public Single<ChannelContextInteractor.State> invoke(@NotNull ChannelContextInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            ChannelContextInteractorImpl channelContextInteractorImpl = ChannelContextInteractorImpl.this;
            Observable map = InteropKt.toV2(channelContextInteractorImpl.x.userId()).observeOn(channelContextInteractorImpl.getSchedulerForReducibles()).map(ChannelContextInteractorImpl$userIdOptionObservable$1.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(map, "accountStateProvider.use….toOption()\n            }");
            Single flatMap = map.firstOrError().flatMap(new ChannelContextInteractorImpl$RefreshMutator$invoke$$inlined$withUserId$1(this, state));
            Intrinsics.checkNotNullExpressionValue(flatMap, "userIdOptionObservable(s…          )\n            }");
            Single<ChannelContextInteractor.State> onErrorReturn = flatMap.onErrorReturn(new a(state));
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "withUserId(schedulerForR…ldState\n                }");
            return onErrorReturn;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$UserIdUpdatedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;)Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "", "d", "Ljava/lang/String;", "newUserId", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class UserIdUpdatedMutator extends Mutator<ChannelContextInteractor.State> {
        public final String d;
        public final /* synthetic */ ChannelContextInteractorImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UserIdUpdatedMutator(@NotNull ChannelContextInteractorImpl channelContextInteractorImpl, String str) {
            super(null, a2.b.a.a.a.c3("newUserId=", str), 1, null);
            Intrinsics.checkNotNullParameter(str, "newUserId");
            this.e = channelContextInteractorImpl;
            this.d = str;
        }

        @NotNull
        public ChannelContextInteractor.State invoke(@NotNull ChannelContextInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (!(!Intrinsics.areEqual(this.d, state.getCurrentUserId()))) {
                return state;
            }
            this.e.refresh();
            return ChannelContextInteractor.State.copy$default(state, this.d, null, null, false, 14, null);
        }
    }

    public static final class a implements ShouldCancelChecker<ChannelContextInteractor.State> {
        @NotNull
        public static final a a = new a();

        @Override // com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker
        public boolean aShouldCancelB(@NotNull Reducible<ChannelContextInteractor.State> reducible, @NotNull Reducible<ChannelContextInteractor.State> reducible2) {
            Intrinsics.checkNotNullParameter(reducible, AuthSource.SEND_ABUSE);
            Intrinsics.checkNotNullParameter(reducible2, AuthSource.BOOKING_ORDER);
            if (reducible instanceof InitialDataRequestComposite.SetInProgressMutator) {
                if ((reducible2 instanceof InitialDataRequestComposite.SetInProgressMutator) || (reducible2 instanceof InitialDataRequestComposite.GetUserIdMutator) || (reducible2 instanceof InitialDataRequestComposite.GetChannelMutator) || (reducible2 instanceof RefreshMutator) || (reducible2 instanceof UserIdUpdatedMutator) || (reducible2 instanceof ChannelUpdatedMutator)) {
                    return true;
                }
            } else if (reducible instanceof RefreshMutator) {
                if ((reducible2 instanceof RefreshMutator) || (reducible2 instanceof ChannelUpdatedMutator)) {
                    return true;
                }
            } else if (reducible instanceof UserIdUpdatedMutator) {
                if (reducible2 instanceof UserIdUpdatedMutator) {
                    return true;
                }
            } else if (reducible instanceof ChannelUpdatedMutator) {
                if (reducible2 instanceof ChannelUpdatedMutator) {
                    return true;
                }
            } else if (reducible instanceof ConnectingStateChangedMutator) {
                if (reducible2 instanceof ConnectingStateChangedMutator) {
                    return true;
                }
            } else if (reducible instanceof ChatTypingStartMutator) {
                if (reducible2 instanceof ChatTypingStopMutator) {
                    return Intrinsics.areEqual(((ChatTypingStartMutator) reducible).getTypingUserId(), ((ChatTypingStopMutator) reducible2).getTypingUserId());
                }
            } else if (reducible instanceof ChatTypingStopMutator) {
                if (reducible2 instanceof ChatTypingStartMutator) {
                    return Intrinsics.areEqual(((ChatTypingStopMutator) reducible).getTypingUserId(), ((ChatTypingStartMutator) reducible2).getTypingUserId());
                }
            } else if ((reducible instanceof OnReconnectAction) && ((reducible2 instanceof OnReconnectAction) || (reducible2 instanceof RefreshMutator) || (reducible2 instanceof ChannelUpdatedMutator))) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Predicate$0] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChannelContextInteractorImpl(@com.avito.android.messenger.di.ChannelId @org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.NotNull com.avito.android.util.SchedulersFactory r24, @org.jetbrains.annotations.NotNull com.avito.android.account.AccountStateProvider r25, @org.jetbrains.annotations.NotNull ru.avito.messenger.MessengerClient<ru.avito.messenger.api.AvitoMessengerApi> r26, @org.jetbrains.annotations.NotNull com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgent r27, @org.jetbrains.annotations.NotNull com.avito.android.analytics.Analytics r28, @org.jetbrains.annotations.NotNull com.avito.android.messenger.service.OpenErrorTrackerScheduler r29, @org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.OpenedFrom r30, @org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.analytics.ChannelTracker r31, @org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.data.ChannelRepo r32, @org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent r33, @org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue<com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor.State> r34) {
        /*
        // Method dump skipped, instructions count: 457
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl.<init>(java.lang.String, com.avito.android.util.SchedulersFactory, com.avito.android.account.AccountStateProvider, ru.avito.messenger.MessengerClient, com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgent, com.avito.android.analytics.Analytics, com.avito.android.messenger.service.OpenErrorTrackerScheduler, com.avito.android.messenger.conversation.OpenedFrom, com.avito.android.messenger.conversation.analytics.ChannelTracker, com.avito.android.messenger.channels.mvi.data.ChannelRepo, com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent, com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue):void");
    }

    public static final Single access$getChannelFromDb(ChannelContextInteractorImpl channelContextInteractorImpl, String str) {
        Objects.requireNonNull(channelContextInteractorImpl);
        Single<Option<Channel>> firstOrError = channelContextInteractorImpl.E.getChannel(str, channelContextInteractorImpl.w).observeOn(channelContextInteractorImpl.getSchedulerForReducibles()).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "channelRepo.getChannel(\n…          .firstOrError()");
        return firstOrError;
    }

    public static final Set access$getInterlocutorIds$p(ChannelContextInteractorImpl channelContextInteractorImpl, ChannelContextInteractor.State state) {
        Objects.requireNonNull(channelContextInteractorImpl);
        Loading<Channel> channelState = state.getChannelState();
        List<User> list = null;
        if (!(channelState instanceof Loading.Success)) {
            channelState = null;
        }
        Loading.Success success = (Loading.Success) channelState;
        Channel channel = (Channel) (success != null ? success.getValue() : null);
        if (channel != null) {
            list = channel.getUsers();
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getId());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (!Intrinsics.areEqual((String) next, state.getCurrentUserId())) {
                arrayList2.add(next);
            }
        }
        return CollectionsKt___CollectionsKt.toSet(arrayList2);
    }

    public static final Function1 access$logError(ChannelContextInteractorImpl channelContextInteractorImpl, String str) {
        Objects.requireNonNull(channelContextInteractorImpl);
        return new ChannelContextInteractorImpl$logError$1(channelContextInteractorImpl, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Function$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$setupAfterInitSubscriptions(com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl r6) {
        /*
        // Method dump skipped, instructions count: 376
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl.access$setupAfterInitSubscriptions(com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl):void");
    }

    public static final void access$setupUsersLastActivityPolling(ChannelContextInteractorImpl channelContextInteractorImpl, Scheduler scheduler) {
        Disposable subscribe = channelContextInteractorImpl.getStateObservable().map(new ChannelContextInteractorImpl$setupUsersLastActivityPolling$1(channelContextInteractorImpl)).distinctUntilChanged().observeOn(scheduler).subscribe(new ChannelContextInteractorImpl$setupUsersLastActivityPolling$2(channelContextInteractorImpl), new ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Consumer$0(new ChannelContextInteractorImpl$logError$1(channelContextInteractorImpl, "State")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "stateObservable\n        …or(\"State\")\n            )");
        DisposableKt.addTo(subscribe, channelContextInteractorImpl.t);
    }

    public static final void access$subscribeToChannelUpdatesFromDb(ChannelContextInteractorImpl channelContextInteractorImpl, ConnectableObservable connectableObservable, Scheduler scheduler) {
        Objects.requireNonNull(channelContextInteractorImpl);
        Observable observeOn = connectableObservable.switchMap(new ChannelContextInteractorImpl$subscribeToChannelUpdatesFromDb$1(channelContextInteractorImpl)).observeOn(scheduler);
        Intrinsics.checkNotNullExpressionValue(observeOn, "nonEmptyUserIdSharedObse…    .observeOn(scheduler)");
        Disposable subscribe = OptionKt.filterDefined(observeOn).subscribe(new ChannelContextInteractorImpl$subscribeToChannelUpdatesFromDb$2(channelContextInteractorImpl), new ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Consumer$0(new ChannelContextInteractorImpl$logError$1(channelContextInteractorImpl, "channelRepo.getChannel()")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "nonEmptyUserIdSharedObse…Channel()\")\n            )");
        DisposableKt.addTo(subscribe, channelContextInteractorImpl.t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Function$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$subscribeToChatTypingEvents(com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl r2, io.reactivex.observables.ConnectableObservable r3, io.reactivex.Scheduler r4) {
        /*
            java.util.Objects.requireNonNull(r2)
            com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$subscribeToChatTypingEvents$1 r0 = new com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$subscribeToChatTypingEvents$1
            r0.<init>(r2)
            io.reactivex.Observable r3 = r3.switchMap(r0)
            io.reactivex.Observable r3 = r3.observeOn(r4)
            kotlin.reflect.KProperty1 r0 = com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$subscribeToChatTypingEvents$2.INSTANCE
            if (r0 == 0) goto L_0x001a
            com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Function$0 r1 = new com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Function$0
            r1.<init>(r0)
            r0 = r1
        L_0x001a:
            io.reactivex.functions.Function r0 = (io.reactivex.functions.Function) r0
            io.reactivex.Observable r3 = r3.groupBy(r0)
            com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$subscribeToChatTypingEvents$3 r0 = new com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$subscribeToChatTypingEvents$3
            r0.<init>(r2)
            io.reactivex.Completable r3 = r3.flatMapCompletable(r0)
            io.reactivex.Completable r3 = r3.subscribeOn(r4)
            com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$subscribeToChatTypingEvents$4 r4 = com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$subscribeToChatTypingEvents$4.INSTANCE
            com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$logError$1 r0 = new com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$logError$1
            java.lang.String r1 = "ChatTypingEvent"
            r0.<init>(r2, r1)
            com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Consumer$0 r1 = new com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Consumer$0
            r1.<init>(r0)
            io.reactivex.disposables.Disposable r3 = r3.subscribe(r4, r1)
            java.lang.String r4 = "nonEmptyUserIdSharedObse…pingEvent\")\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            io.reactivex.disposables.CompositeDisposable r2 = access$getAfterInitSubscriptions$p(r2)
            io.reactivex.rxkotlin.DisposableKt.addTo(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl.access$subscribeToChatTypingEvents(com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl, io.reactivex.observables.ConnectableObservable, io.reactivex.Scheduler):void");
    }

    public static final void access$subscribeToConnectingStateChanges(ChannelContextInteractorImpl channelContextInteractorImpl, Scheduler scheduler) {
        Objects.requireNonNull(channelContextInteractorImpl);
        Disposable subscribe = channelContextInteractorImpl.y.state().observeOn(scheduler).map(ChannelContextInteractorImpl$subscribeToConnectingStateChanges$1.INSTANCE).distinctUntilChanged().subscribeOn(scheduler).subscribe(new ChannelContextInteractorImpl$subscribeToConnectingStateChanges$2(channelContextInteractorImpl), new ChannelContextInteractorImpl$subscribeToConnectingStateChanges$3(channelContextInteractorImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "client.state()\n         …          }\n            )");
        DisposableKt.addTo(subscribe, channelContextInteractorImpl.s);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Predicate$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$subscribeToLogouts(com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl r3, io.reactivex.Scheduler r4) {
        /*
            java.util.Objects.requireNonNull(r3)
            com.avito.android.account.AccountStateProvider r0 = access$getAccountStateProvider$p(r3)
            io.reactivex.rxjava3.core.Observable r0 = r0.userId()
            io.reactivex.Observable r0 = com.avito.android.util.rx3.InteropKt.toV2(r0)
            io.reactivex.Observable r0 = r0.observeOn(r4)
            r1 = 1
            io.reactivex.Observable r0 = r0.skip(r1)
            com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$subscribeToLogouts$1 r1 = com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$subscribeToLogouts$1.INSTANCE
            if (r1 == 0) goto L_0x0023
            com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Predicate$0 r2 = new com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Predicate$0
            r2.<init>(r1)
            r1 = r2
        L_0x0023:
            io.reactivex.functions.Predicate r1 = (io.reactivex.functions.Predicate) r1
            io.reactivex.Observable r0 = r0.filter(r1)
            io.reactivex.Observable r4 = r0.subscribeOn(r4)
            com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$subscribeToLogouts$2 r0 = new com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$subscribeToLogouts$2
            r0.<init>(r3)
            com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$logError$1 r1 = new com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$logError$1
            java.lang.String r2 = "Blank user id"
            r1.<init>(r3, r2)
            com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Consumer$0 r2 = new com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Consumer$0
            r2.<init>(r1)
            io.reactivex.disposables.Disposable r4 = r4.subscribe(r0, r2)
            java.lang.String r0 = "accountStateProvider.use…k user id\")\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            io.reactivex.disposables.CompositeDisposable r3 = access$getAllSubscriptions$p(r3)
            io.reactivex.rxkotlin.DisposableKt.addTo(r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl.access$subscribeToLogouts(com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl, io.reactivex.Scheduler):void");
    }

    public static final void access$subscribeToNonEmptyUserIdUpdates(ChannelContextInteractorImpl channelContextInteractorImpl, ConnectableObservable connectableObservable) {
        Objects.requireNonNull(channelContextInteractorImpl);
        Disposable subscribe = connectableObservable.subscribe(new ChannelContextInteractorImpl$subscribeToNonEmptyUserIdUpdates$1(channelContextInteractorImpl), new ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Consumer$0(new ChannelContextInteractorImpl$logError$1(channelContextInteractorImpl, "Non-blank user Id")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "nonEmptyUserIdSharedObse…k user Id\")\n            )");
        DisposableKt.addTo(subscribe, channelContextInteractorImpl.t);
    }

    public static final void access$subscribeToReconnects(ChannelContextInteractorImpl channelContextInteractorImpl, Scheduler scheduler) {
        Objects.requireNonNull(channelContextInteractorImpl);
        Disposable subscribe = channelContextInteractorImpl.y.allReconnects().observeOn(scheduler).subscribeOn(scheduler).subscribe(new ChannelContextInteractorImpl$subscribeToReconnects$1(channelContextInteractorImpl), new ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Consumer$0(new ChannelContextInteractorImpl$logError$1(channelContextInteractorImpl, "client.allReconnects()")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "client.allReconnects()\n …onnects()\")\n            )");
        DisposableKt.addTo(subscribe, channelContextInteractorImpl.s);
    }

    public static final void access$subscribeToStopTypingEvents(ChannelContextInteractorImpl channelContextInteractorImpl, ConnectableObservable connectableObservable, Scheduler scheduler) {
        Objects.requireNonNull(channelContextInteractorImpl);
        Disposable subscribe = connectableObservable.switchMap(new ChannelContextInteractorImpl$subscribeToStopTypingEvents$1(channelContextInteractorImpl)).observeOn(scheduler).subscribe(new ChannelContextInteractorImpl$subscribeToStopTypingEvents$2(channelContextInteractorImpl), new ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Consumer$0(new ChannelContextInteractorImpl$logError$1(channelContextInteractorImpl, "New messages")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "nonEmptyUserIdSharedObse… messages\")\n            )");
        DisposableKt.addTo(subscribe, channelContextInteractorImpl.t);
    }

    public static final Completable access$syncChat(ChannelContextInteractorImpl channelContextInteractorImpl, String str) {
        Objects.requireNonNull(channelContextInteractorImpl);
        Completable observeOn = channelContextInteractorImpl.F.syncChat(str, channelContextInteractorImpl.w).observeOn(channelContextInteractorImpl.getSchedulerForReducibles());
        Intrinsics.checkNotNullExpressionValue(observeOn, "channelSyncAgent.syncCha…n(schedulerForReducibles)");
        return observeOn;
    }

    public static final Single access$syncChatAndUpdateState(ChannelContextInteractorImpl channelContextInteractorImpl, String str, ChannelContextInteractor.State state) {
        Objects.requireNonNull(channelContextInteractorImpl);
        Completable observeOn = channelContextInteractorImpl.F.syncChat(str, channelContextInteractorImpl.w).observeOn(channelContextInteractorImpl.getSchedulerForReducibles());
        Intrinsics.checkNotNullExpressionValue(observeOn, "channelSyncAgent.syncCha…n(schedulerForReducibles)");
        Single flatMap = observeOn.toSingleDefault(Unit.INSTANCE).flatMap(new Function<Unit, SingleSource<? extends T>>(str) { // from class: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$syncChatAndUpdateState$$inlined$flatMapSingle$1
            public final /* synthetic */ String b;

            {
                this.b = r2;
            }

            public final SingleSource<? extends T> apply(@NotNull Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "it");
                ChannelContextInteractorImpl channelContextInteractorImpl2 = ChannelContextInteractorImpl.this;
                Single<Option<Channel>> firstOrError = channelContextInteractorImpl2.E.getChannel(this.b, channelContextInteractorImpl2.w).observeOn(channelContextInteractorImpl2.getSchedulerForReducibles()).firstOrError();
                Intrinsics.checkNotNullExpressionValue(firstOrError, "channelRepo.getChannel(\n…          .firstOrError()");
                return firstOrError;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "toSingleDefault(Unit).flatMap { singleFactory() }");
        Single flatMap2 = flatMap.flatMap(new Function<Option<? extends T>, SingleSource<? extends R>>(str, state, str) { // from class: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$syncChatAndUpdateState$$inlined$flatMapFold$1
            public final /* synthetic */ String b;
            public final /* synthetic */ ChannelContextInteractor.State c;
            public final /* synthetic */ String d;

            {
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            public final SingleSource<? extends R> apply(@NotNull Option<? extends T> option) {
                Intrinsics.checkNotNullParameter(option, "it");
                if (option instanceof None) {
                    StringBuilder L = a.L("Channel is not in DB after channelSyncAgent.syncChat(): userId = ");
                    L.append(this.b);
                    L.append(", channelId = ");
                    L.append(ChannelContextInteractorImpl.this.w);
                    Single error = Single.error(new RuntimeException(L.toString()));
                    Intrinsics.checkNotNullExpressionValue(error, "Single.error<ChannelCont…channelId = $channelId\"))");
                    return error;
                } else if (option instanceof Some) {
                    return Singles.toSingle(ChannelContextInteractor.State.copy$default(this.c, this.d, new Loading.Success((Channel) ((Some) option).getT()), null, false, 12, null));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Option) ((Option) obj));
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap2, "flatMap { it.fold(ifEmpty, some) }");
        return flatMap2;
    }

    public static final Observable access$userIdOptionObservable(ChannelContextInteractorImpl channelContextInteractorImpl, Scheduler scheduler) {
        Objects.requireNonNull(channelContextInteractorImpl);
        Observable map = InteropKt.toV2(channelContextInteractorImpl.x.userId()).observeOn(scheduler).map(ChannelContextInteractorImpl$userIdOptionObservable$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "accountStateProvider.use….toOption()\n            }");
        return map;
    }

    public static final Single access$withUserId(ChannelContextInteractorImpl channelContextInteractorImpl, Scheduler scheduler, Function1 function1) {
        Objects.requireNonNull(channelContextInteractorImpl);
        Observable map = InteropKt.toV2(channelContextInteractorImpl.x.userId()).observeOn(scheduler).map(ChannelContextInteractorImpl$userIdOptionObservable$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "accountStateProvider.use….toOption()\n            }");
        Single flatMap = map.firstOrError().flatMap(new Function<Option<? extends String>, SingleSource<? extends R>>() { // from class: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$withUserId$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ Object apply(Option<? extends String> option) {
                return apply((Option<String>) option);
            }

            public final SingleSource<? extends R> apply(@NotNull Option<String> option) {
                Intrinsics.checkNotNullParameter(option, "userIdOption");
                if (option instanceof None) {
                    throw new UnauthorizedException();
                } else if (option instanceof Some) {
                    return (SingleSource) Function1.this.invoke(((Some) option).getT());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "userIdOptionObservable(s…          )\n            }");
        return flatMap;
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor
    public void initialDataRequest(boolean z2) {
        String tag = getTAG();
        LogsT.verbose$default(tag, "initialDataRequest(isRetry = " + z2 + ')', null, 4, null);
        getReducerQueue().plusAssign(new InitialDataRequestComposite(z2, this.u.getAndIncrement()));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.s.clear();
        this.z.requestUsers(this.v, y.emptySet());
        super.onCleared();
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.OpenAdvertHandler
    public void openAdvert() {
        getReducerQueue().plusAssign(new OpenAdvertAction());
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor
    public void refresh() {
        getReducerQueue().plusAssign(new RefreshMutator());
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor
    @NotNull
    public PublishRelay<Unit> getLoggedOutStream() {
        return this.r;
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.OpenAdvertHandler
    @NotNull
    public SingleLiveEvent<String> getOpenAdvertScreenStream() {
        return this.p;
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.OpenAdvertHandler
    @NotNull
    public SingleLiveEvent<String> getOpenMyAdvertScreenStream() {
        return this.q;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public ChannelContextInteractorImpl(@ChannelId @NotNull String str, @NotNull SchedulersFactory schedulersFactory, @NotNull AccountStateProvider accountStateProvider, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull UserLastActivitySyncAgent userLastActivitySyncAgent, @NotNull Analytics analytics, @NotNull OpenErrorTrackerScheduler openErrorTrackerScheduler, @NotNull OpenedFrom openedFrom, @NotNull ChannelTracker channelTracker, @NotNull ChannelRepo channelRepo, @NotNull ChannelSyncAgent channelSyncAgent) {
        this(str, schedulersFactory, accountStateProvider, messengerClient, userLastActivitySyncAgent, analytics, openErrorTrackerScheduler, openedFrom, channelTracker, channelRepo, channelSyncAgent, new SimpleReducerQueue(schedulersFactory.io(), "ChannelContextInteractor"));
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(userLastActivitySyncAgent, "userLastActivitySyncAgent");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(openErrorTrackerScheduler, "openErrorTrackerScheduler");
        Intrinsics.checkNotNullParameter(openedFrom, "openedFrom");
        Intrinsics.checkNotNullParameter(channelTracker, "perfTracker");
        Intrinsics.checkNotNullParameter(channelRepo, "channelRepo");
        Intrinsics.checkNotNullParameter(channelSyncAgent, "channelSyncAgent");
    }
}
