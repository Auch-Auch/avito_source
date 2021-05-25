package com.avito.android.messenger.channels.mvi.sync;

import a2.b.a.a.a;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoReader;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushAgent;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushAgentImpl;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoReader;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import t6.n.y;
import t6.n.z;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003/01B\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\t\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\t\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020$0\t\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010(\u001a\u00020'\u0012\u0012\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030*0)\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b,\u0010-Be\b\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\t\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\t\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020$0\t\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b,\u0010.J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\fR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\fR\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020$0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\f¨\u00062"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgentImpl;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent$State;", "", "channelId", "", "sync", "(Ljava/lang/String;)V", "Ldagger/Lazy;", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageSyncAgent;", "s", "Ldagger/Lazy;", "messageSyncAgent", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoReader;", "p", "channelRepoReader", "", "t", "J", "retryCount", "Lcom/avito/android/account/AccountStateProvider;", "n", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "o", "client", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoReader;", "r", "messageRepoReader", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", VKApiConst.Q, "channelSyncAgent", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "mutatorsRelay", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Lcom/avito/android/util/SchedulersFactory;Lcom/jakewharton/rxrelay2/Relay;J)V", "(Lcom/avito/android/account/AccountStateProvider;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Lcom/avito/android/util/SchedulersFactory;)V", "EnqSyncMutator", "PerformSyncMutator", "UserIdChangedMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelSyncOnPushAgentImpl extends BaseMviEntityWithMutatorsRelay<ChannelSyncOnPushAgent.State> implements ChannelSyncOnPushAgent {
    public final CompositeDisposable m;
    public final AccountStateProvider n;
    public final Lazy<MessengerClient<AvitoMessengerApi>> o;
    public final Lazy<ChannelRepoReader> p;
    public final Lazy<ChannelSyncAgent> q;
    public final Lazy<MessageRepoReader> r;
    public final Lazy<MessageSyncAgent> s;
    public final long t;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgentImpl$EnqSyncMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent$State;)Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent$State;", "", "c", "Ljava/lang/String;", "channelId", "<init>", "(Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgentImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class EnqSyncMutator extends Mutator<ChannelSyncOnPushAgent.State> {
        public final String c;
        public final /* synthetic */ ChannelSyncOnPushAgentImpl d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EnqSyncMutator(@NotNull ChannelSyncOnPushAgentImpl channelSyncOnPushAgentImpl, String str) {
            super(a.d3("EnqSyncMutator(channelId=", str, ')'));
            Intrinsics.checkNotNullParameter(str, "channelId");
            this.d = channelSyncOnPushAgentImpl;
            this.c = str;
        }

        @NotNull
        public ChannelSyncOnPushAgent.State invoke(@NotNull ChannelSyncOnPushAgent.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state.getDownloadedChannelIds().contains(this.c)) {
                return state;
            }
            this.d.getMutatorsRelay().accept(new PerformSyncMutator(this.d, this.c));
            return ChannelSyncOnPushAgent.State.copy$default(state, null, state.getUnprocessedRequestsCount() + 1, 1, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgentImpl$PerformSyncMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent$State;)Lio/reactivex/Single;", "", "c", "Ljava/lang/String;", "channelId", "<init>", "(Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgentImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class PerformSyncMutator extends MutatorSingle<ChannelSyncOnPushAgent.State> {
        public final String c;
        public final /* synthetic */ ChannelSyncOnPushAgentImpl d;

        public static final /* synthetic */ class a extends FunctionReferenceImpl implements Function1<String, Completable> {
            public a(PerformSyncMutator performSyncMutator) {
                super(1, performSyncMutator, PerformSyncMutator.class, "syncChannelAndMessages", "syncChannelAndMessages(Ljava/lang/String;)Lio/reactivex/Completable;", 0);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Completable invoke(String str) {
                String str2 = str;
                Intrinsics.checkNotNullParameter(str2, "p1");
                PerformSyncMutator performSyncMutator = (PerformSyncMutator) this.receiver;
                Single<Option<Channel>> firstOrError = ((ChannelRepoReader) performSyncMutator.d.p.get()).getChannel(str2, performSyncMutator.c).observeOn(performSyncMutator.d.getSchedulerForMutators()).firstOrError();
                Intrinsics.checkNotNullExpressionValue(firstOrError, "channelRepoReader.get().…          .firstOrError()");
                Completable subscribeOn = firstOrError.flatMapCompletable(new ChannelSyncOnPushAgentImpl$PerformSyncMutator$syncChannelAndMessages$1(performSyncMutator, str2)).andThen(MessageSyncAgent.DefaultImpls.syncLatestMessages$default((MessageSyncAgent) performSyncMutator.d.s.get(), str2, performSyncMutator.c, null, null, 12, null).observeOn(performSyncMutator.d.getSchedulerForMutators()).subscribeOn(performSyncMutator.d.getSchedulerForMutators())).subscribeOn(performSyncMutator.d.getSchedulerForMutators());
                Intrinsics.checkNotNullExpressionValue(subscribeOn, "getChannelFromDb(userId)…eOn(schedulerForMutators)");
                return subscribeOn;
            }
        }

        public static final class b<V> implements Callable<ChannelSyncOnPushAgent.State> {
            public final /* synthetic */ PerformSyncMutator a;
            public final /* synthetic */ ChannelSyncOnPushAgent.State b;

            public b(PerformSyncMutator performSyncMutator, ChannelSyncOnPushAgent.State state) {
                this.a = performSyncMutator;
                this.b = state;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public ChannelSyncOnPushAgent.State call() {
                ChannelSyncOnPushAgent.State state = this.b;
                return state.copy(z.plus(state.getDownloadedChannelIds(), this.a.c), this.b.getUnprocessedRequestsCount() - 1);
            }
        }

        public static final class c<T, R> implements Function<Throwable, ChannelSyncOnPushAgent.State> {
            public final /* synthetic */ ChannelSyncOnPushAgent.State a;

            public c(ChannelSyncOnPushAgent.State state) {
                this.a = state;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public ChannelSyncOnPushAgent.State apply(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                ChannelSyncOnPushAgent.State state = this.a;
                return ChannelSyncOnPushAgent.State.copy$default(state, null, state.getUnprocessedRequestsCount() - 1, 1, null);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PerformSyncMutator(@NotNull ChannelSyncOnPushAgentImpl channelSyncOnPushAgentImpl, String str) {
            super(a2.b.a.a.a.d3("PerformSyncMutator(channelId=", str, ')'));
            Intrinsics.checkNotNullParameter(str, "channelId");
            this.d = channelSyncOnPushAgentImpl;
            this.c = str;
        }

        public static final Completable access$connect(PerformSyncMutator performSyncMutator) {
            Completable observeOn = ((MessengerClient) performSyncMutator.d.o.get()).connect(true).observeOn(performSyncMutator.d.getSchedulerForMutators());
            Intrinsics.checkNotNullExpressionValue(observeOn, "client.get().connect(for…eOn(schedulerForMutators)");
            return observeOn;
        }

        public static final Completable access$connectAndSyncChannelIfNeeded(PerformSyncMutator performSyncMutator, String str, Option option) {
            Completable completable;
            Completable observeOn = ((MessengerClient) performSyncMutator.d.o.get()).connect(true).observeOn(performSyncMutator.d.getSchedulerForMutators());
            Intrinsics.checkNotNullExpressionValue(observeOn, "client.get().connect(for…eOn(schedulerForMutators)");
            if (option instanceof None) {
                completable = ((ChannelSyncAgent) performSyncMutator.d.q.get()).syncChat(str, performSyncMutator.c);
            } else if (option instanceof Some) {
                Channel channel = (Channel) ((Some) option).getT();
                completable = Completable.complete();
                Intrinsics.checkNotNullExpressionValue(completable, "Completable.complete()");
            } else {
                throw new NoWhenBranchMatchedException();
            }
            Completable subscribeOn = completable.observeOn(performSyncMutator.d.getSchedulerForMutators()).subscribeOn(performSyncMutator.d.getSchedulerForMutators());
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "channelOption.fold(\n    …eOn(schedulerForMutators)");
            Completable subscribeOn2 = observeOn.andThen(subscribeOn).subscribeOn(performSyncMutator.d.getSchedulerForMutators());
            Intrinsics.checkNotNullExpressionValue(subscribeOn2, "connect()\n              …eOn(schedulerForMutators)");
            return subscribeOn2;
        }

        public static final Single access$getChannelFromDb(PerformSyncMutator performSyncMutator, String str) {
            Single<Option<Channel>> firstOrError = ((ChannelRepoReader) performSyncMutator.d.p.get()).getChannel(str, performSyncMutator.c).observeOn(performSyncMutator.d.getSchedulerForMutators()).firstOrError();
            Intrinsics.checkNotNullExpressionValue(firstOrError, "channelRepoReader.get().…          .firstOrError()");
            return firstOrError;
        }

        public static final Completable access$syncChannelAndMessages(PerformSyncMutator performSyncMutator, String str) {
            Single<Option<Channel>> firstOrError = ((ChannelRepoReader) performSyncMutator.d.p.get()).getChannel(str, performSyncMutator.c).observeOn(performSyncMutator.d.getSchedulerForMutators()).firstOrError();
            Intrinsics.checkNotNullExpressionValue(firstOrError, "channelRepoReader.get().…          .firstOrError()");
            Completable subscribeOn = firstOrError.flatMapCompletable(new ChannelSyncOnPushAgentImpl$PerformSyncMutator$syncChannelAndMessages$1(performSyncMutator, str)).andThen(MessageSyncAgent.DefaultImpls.syncLatestMessages$default((MessageSyncAgent) performSyncMutator.d.s.get(), str, performSyncMutator.c, null, null, 12, null).observeOn(performSyncMutator.d.getSchedulerForMutators()).subscribeOn(performSyncMutator.d.getSchedulerForMutators())).subscribeOn(performSyncMutator.d.getSchedulerForMutators());
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "getChannelFromDb(userId)…eOn(schedulerForMutators)");
            return subscribeOn;
        }

        public static final Completable access$syncChannelIfNeeded(PerformSyncMutator performSyncMutator, String str, Option option) {
            Completable completable;
            Objects.requireNonNull(performSyncMutator);
            if (option instanceof None) {
                completable = ((ChannelSyncAgent) performSyncMutator.d.q.get()).syncChat(str, performSyncMutator.c);
            } else if (option instanceof Some) {
                Channel channel = (Channel) ((Some) option).getT();
                completable = Completable.complete();
                Intrinsics.checkNotNullExpressionValue(completable, "Completable.complete()");
            } else {
                throw new NoWhenBranchMatchedException();
            }
            Completable subscribeOn = completable.observeOn(performSyncMutator.d.getSchedulerForMutators()).subscribeOn(performSyncMutator.d.getSchedulerForMutators());
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "channelOption.fold(\n    …eOn(schedulerForMutators)");
            return subscribeOn;
        }

        @NotNull
        public Single<ChannelSyncOnPushAgent.State> invoke(@NotNull ChannelSyncOnPushAgent.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state.getDownloadedChannelIds().contains(this.c)) {
                return Singles.toSingle(ChannelSyncOnPushAgent.State.copy$default(state, null, state.getUnprocessedRequestsCount() - 1, 1, null));
            }
            Maybe switchIfEmpty = InteropKt.toV2(this.d.n.currentUserId()).observeOn(this.d.getSchedulerForMutators()).switchIfEmpty(Maybe.error(new RuntimeException("currentUserId is empty")));
            Intrinsics.checkNotNullExpressionValue(switchIfEmpty, "accountStateProvider.cur…mpty\"))\n                )");
            Single<ChannelSyncOnPushAgent.State> subscribeOn = switchIfEmpty.flatMapCompletable(new a2.a.a.o1.b.b.d.b(new a(this))).toSingle(new b(this, state)).retry(this.d.t).onErrorReturn(new c(state)).subscribeOn(this.d.getSchedulerForMutators());
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "getCurrentUserId()\n     …eOn(schedulerForMutators)");
            return subscribeOn;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgentImpl$UserIdChangedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent$State;)Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent$State;", "<init>", "(Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgentImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class UserIdChangedMutator extends Mutator<ChannelSyncOnPushAgent.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public UserIdChangedMutator(ChannelSyncOnPushAgentImpl channelSyncOnPushAgentImpl) {
            super(null, 1, null);
        }

        @NotNull
        public ChannelSyncOnPushAgent.State invoke(@NotNull ChannelSyncOnPushAgent.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            return ChannelSyncOnPushAgent.State.copy$default(state, y.emptySet(), 0, 2, null);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelSyncOnPushAgentImpl(@NotNull AccountStateProvider accountStateProvider, @NotNull Lazy<MessengerClient<AvitoMessengerApi>> lazy, @NotNull Lazy<ChannelRepoReader> lazy2, @NotNull Lazy<ChannelSyncAgent> lazy3, @NotNull Lazy<MessageRepoReader> lazy4, @NotNull Lazy<MessageSyncAgent> lazy5, @NotNull SchedulersFactory schedulersFactory, @NotNull Relay<MutatorSingle<ChannelSyncOnPushAgent.State>> relay, long j) {
        super("ChannelSyncOnPushAgent", ChannelSyncOnPushAgent.State.Companion.getDEFAULT(), schedulersFactory, relay);
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(lazy, "client");
        Intrinsics.checkNotNullParameter(lazy2, "channelRepoReader");
        Intrinsics.checkNotNullParameter(lazy3, "channelSyncAgent");
        Intrinsics.checkNotNullParameter(lazy4, "messageRepoReader");
        Intrinsics.checkNotNullParameter(lazy5, "messageSyncAgent");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(relay, "mutatorsRelay");
        this.n = accountStateProvider;
        this.o = lazy;
        this.p = lazy2;
        this.q = lazy3;
        this.r = lazy4;
        this.s = lazy5;
        this.t = j;
        this.m = new CompositeDisposable();
        Disposable subscribe = InteropKt.toV2(this.n.userId()).distinctUntilChanged().subscribeOn(getSchedulers().io()).subscribe(new Consumer<String>() { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushAgentImpl$subscribeToUserIdUpdates$1
            /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: com.jakewharton.rxrelay2.Relay */
            /* JADX WARN: Multi-variable type inference failed */
            public final void accept(String str) {
                Relay mutatorsRelay = ChannelSyncOnPushAgentImpl.this.getMutatorsRelay();
                ChannelSyncOnPushAgentImpl.UserIdChangedMutator userIdChangedMutator = new ChannelSyncOnPushAgentImpl.UserIdChangedMutator(ChannelSyncOnPushAgentImpl.this);
                mutatorsRelay.accept(new MutatorSingle(userIdChangedMutator.getName(), new ChannelSyncOnPushAgentImpl$subscribeToUserIdUpdates$1$$special$$inlined$plusAssign$1(userIdChangedMutator)));
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountStateProvider.use…edMutator()\n            }");
        DisposableKt.addTo(subscribe, this.m);
    }

    @Override // com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushAgent
    public void sync(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Relay mutatorsRelay = getMutatorsRelay();
        EnqSyncMutator enqSyncMutator = new EnqSyncMutator(this, str);
        mutatorsRelay.accept(new MutatorSingle(enqSyncMutator.getName(), new ChannelSyncOnPushAgentImpl$sync$$inlined$plusAssign$1(enqSyncMutator)));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChannelSyncOnPushAgentImpl(@org.jetbrains.annotations.NotNull com.avito.android.account.AccountStateProvider r13, @org.jetbrains.annotations.NotNull dagger.Lazy<ru.avito.messenger.MessengerClient<ru.avito.messenger.api.AvitoMessengerApi>> r14, @org.jetbrains.annotations.NotNull dagger.Lazy<com.avito.android.messenger.channels.mvi.data.ChannelRepoReader> r15, @org.jetbrains.annotations.NotNull dagger.Lazy<com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent> r16, @org.jetbrains.annotations.NotNull dagger.Lazy<com.avito.android.messenger.conversation.mvi.data.MessageRepoReader> r17, @org.jetbrains.annotations.NotNull dagger.Lazy<com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgent> r18, @org.jetbrains.annotations.NotNull com.avito.android.util.SchedulersFactory r19) {
        /*
            r12 = this;
            java.lang.String r0 = "accountStateProvider"
            r2 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "client"
            r3 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "channelRepoReader"
            r4 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "channelSyncAgent"
            r5 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "messageRepoReader"
            r6 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "messageSyncAgent"
            r7 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "schedulers"
            r8 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.jakewharton.rxrelay2.PublishRelay r0 = com.jakewharton.rxrelay2.PublishRelay.create()
            com.jakewharton.rxrelay2.Relay r9 = r0.toSerialized()
            java.lang.String r0 = "PublishRelay.create<T>().toSerialized()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            r10 = 3
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushAgentImpl.<init>(com.avito.android.account.AccountStateProvider, dagger.Lazy, dagger.Lazy, dagger.Lazy, dagger.Lazy, dagger.Lazy, com.avito.android.util.SchedulersFactory):void");
    }
}
