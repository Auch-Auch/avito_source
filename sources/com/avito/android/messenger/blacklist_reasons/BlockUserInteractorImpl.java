package com.avito.android.messenger.blacklist_reasons;

import com.avito.android.messenger.blacklist_reasons.BlockUserInteractor;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.common.v4.MutatorSingle;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker;
import com.avito.android.messenger.util.ThrowablesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.event.BlacklistInfo;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0005*+,-.B$\b\u0007\u0012\u0011\u0010\u001e\u001a\r\u0012\t\u0012\u00070\u001a¢\u0006\u0002\b\u001b0\u0019\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R!\u0010\u001e\u001a\r\u0012\t\u0012\u00070\u001a¢\u0006\u0002\b\u001b0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006/"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractorImpl;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;", "", ChannelContext.Item.USER_ID, "channelId", "itemId", "", "reasonId", "", "blockUser", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "", "isSpam", "messageId", "confirmChatAsSpam", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "retry", "()V", "reset", "Lio/reactivex/disposables/CompositeDisposable;", "p", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "r", "Lru/avito/messenger/MessengerClient;", "client", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Result;", VKApiConst.Q, "Lcom/jakewharton/rxrelay2/Relay;", "getResultStream", "()Lcom/jakewharton/rxrelay2/Relay;", "resultStream", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lru/avito/messenger/MessengerClient;Lcom/avito/android/util/SchedulersFactory;)V", "BlockUserMutator", "CancelChecker", "ResetMutator", "RetryMutator", "StartBlockingProgressMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlockUserInteractorImpl extends BaseMviEntityWithReducerQueue<BlockUserInteractor.State> implements BlockUserInteractor {
    public final CompositeDisposable p;
    @NotNull
    public final Relay<BlockUserInteractor.Result> q = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
    public final MessengerClient<AvitoMessengerApi> r;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractorImpl$BlockUserMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;)Lio/reactivex/Single;", "<init>", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractorImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class BlockUserMutator extends MutatorSingle<BlockUserInteractor.State> {

        public static final class a<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends Unit>> {
            public final /* synthetic */ BlockUserInteractor.Action a;

            public a(BlockUserInteractor.Action action) {
                this.a = action;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public SingleSource<? extends Unit> apply(AvitoMessengerApi avitoMessengerApi) {
                AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
                Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
                if (!((BlockUserInteractor.Action.ConfirmChatAsSpam) this.a).isSpam()) {
                    return avitoMessengerApi2.confirmChatAsNonSpam(this.a.getChannelId(), ((BlockUserInteractor.Action.ConfirmChatAsSpam) this.a).getMessageId());
                }
                long parseLong = Long.parseLong(this.a.getUserId());
                String messageId = ((BlockUserInteractor.Action.ConfirmChatAsSpam) this.a).getMessageId();
                String itemId = this.a.getItemId();
                return avitoMessengerApi2.confirmChatAsSpam(parseLong, messageId, itemId != null ? l.toLongOrNull(itemId) : null);
            }
        }

        public static final class b<T, R> implements Function<Unit, BlockUserInteractor.State> {
            public static final b a = new b();

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public BlockUserInteractor.State apply(Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "it");
                return BlockUserInteractor.State.Blocked.INSTANCE;
            }
        }

        public static final class c<T> implements Consumer<BlockUserInteractor.State> {
            public final /* synthetic */ BlockUserMutator a;
            public final /* synthetic */ BlockUserInteractor.State b;

            public c(BlockUserMutator blockUserMutator, BlockUserInteractor.State state) {
                this.a = blockUserMutator;
                this.b = state;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(BlockUserInteractor.State state) {
                BlockUserInteractor.Action action = ((BlockUserInteractor.State.InProgress) this.b).getAction();
                BlockUserInteractorImpl.this.getResultStream().accept(new BlockUserInteractor.Result.Success(((BlockUserInteractor.State.InProgress) this.b).getAction(), (action instanceof BlockUserInteractor.Action.BlockUser) || ((action instanceof BlockUserInteractor.Action.ConfirmChatAsSpam) && ((BlockUserInteractor.Action.ConfirmChatAsSpam) action).isSpam()), true));
            }
        }

        public static final class d<T, R> implements Function<Throwable, BlockUserInteractor.State> {
            public final /* synthetic */ BlockUserMutator a;
            public final /* synthetic */ BlockUserInteractor.State b;

            public d(BlockUserMutator blockUserMutator, BlockUserInteractor.State state) {
                this.a = blockUserMutator;
                this.b = state;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public BlockUserInteractor.State apply(Throwable th) {
                Throwable th2 = th;
                Intrinsics.checkNotNullParameter(th2, "error");
                Throwable avitoException = ThrowablesKt.toAvitoException(th2);
                BlockUserInteractorImpl.this.getResultStream().accept(new BlockUserInteractor.Result.Error(((BlockUserInteractor.State.InProgress) this.b).getAction(), avitoException));
                return new BlockUserInteractor.State.Error(((BlockUserInteractor.State.InProgress) this.b).getAction(), avitoException);
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public BlockUserMutator() {
            super("BlockUserMutator()", null, 2, null);
        }

        @NotNull
        public Single<BlockUserInteractor.State> invoke(@NotNull BlockUserInteractor.State state) {
            Single<Unit> single;
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof BlockUserInteractor.State.InProgress) {
                BlockUserInteractor.Action action = ((BlockUserInteractor.State.InProgress) state).getAction();
                if (action instanceof BlockUserInteractor.Action.BlockUser) {
                    single = BlockUserInteractorImpl.this.r.addToBlacklist(action.getUserId(), action.getChannelId(), action.getItemId(), ((BlockUserInteractor.Action.BlockUser) action).getReasonId());
                } else if (action instanceof BlockUserInteractor.Action.ConfirmChatAsSpam) {
                    single = BlockUserInteractorImpl.this.r.withMessengerApi().flatMap(new a(action));
                    Intrinsics.checkNotNullExpressionValue(single, "client.withMessengerApi(…                        }");
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                Single<BlockUserInteractor.State> onErrorReturn = single.observeOn(BlockUserInteractorImpl.this.getSchedulers().computation()).map(b.a).doOnSuccess(new c(this, state)).onErrorReturn(new d(this, state));
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "when (val action = oldSt…                        }");
                return onErrorReturn;
            } else if (Intrinsics.areEqual(state, BlockUserInteractor.State.Empty.INSTANCE) || Intrinsics.areEqual(state, BlockUserInteractor.State.Blocked.INSTANCE) || (state instanceof BlockUserInteractor.State.Error)) {
                return Singles.toSingle(state);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractorImpl$CancelChecker;", "Lcom/avito/android/messenger/channels/mvi/common/v4/ShouldCancelChecker;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "", "aShouldCancelB", "(Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;)Z", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class CancelChecker implements ShouldCancelChecker<BlockUserInteractor.State> {
        @Override // com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker
        public boolean aShouldCancelB(@NotNull Reducible<BlockUserInteractor.State> reducible, @NotNull Reducible<BlockUserInteractor.State> reducible2) {
            Intrinsics.checkNotNullParameter(reducible, AuthSource.SEND_ABUSE);
            Intrinsics.checkNotNullParameter(reducible2, AuthSource.BOOKING_ORDER);
            return Intrinsics.areEqual(reducible, ResetMutator.INSTANCE);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractorImpl$ResetMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;)Lio/reactivex/Single;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ResetMutator extends MutatorSingle<BlockUserInteractor.State> {
        @NotNull
        public static final ResetMutator INSTANCE = new ResetMutator();

        public ResetMutator() {
            super(null, null, 3, null);
        }

        @NotNull
        public Single<BlockUserInteractor.State> invoke(@NotNull BlockUserInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            Single<BlockUserInteractor.State> just = Single.just(BlockUserInteractor.State.Empty.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(State.Empty)");
            return just;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractorImpl$RetryMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;)Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;", "<init>", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractorImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class RetryMutator extends Mutator<BlockUserInteractor.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public RetryMutator() {
            super(null, null, 3, null);
        }

        @NotNull
        public BlockUserInteractor.State invoke(@NotNull BlockUserInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof BlockUserInteractor.State.Error) {
                BlockUserInteractorImpl.this.getReducerQueue().plusAssign(new BlockUserMutator());
                return new BlockUserInteractor.State.InProgress(((BlockUserInteractor.State.Error) state).getAction());
            } else if (Intrinsics.areEqual(state, BlockUserInteractor.State.Empty.INSTANCE) || Intrinsics.areEqual(state, BlockUserInteractor.State.Blocked.INSTANCE) || (state instanceof BlockUserInteractor.State.InProgress)) {
                return state;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractorImpl$StartBlockingProgressMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;)Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "d", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "action", "<init>", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractorImpl;Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class StartBlockingProgressMutator extends Mutator<BlockUserInteractor.State> {
        public final BlockUserInteractor.Action d;
        public final /* synthetic */ BlockUserInteractorImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StartBlockingProgressMutator(@NotNull BlockUserInteractorImpl blockUserInteractorImpl, BlockUserInteractor.Action action) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(action, "action");
            this.e = blockUserInteractorImpl;
            this.d = action;
        }

        @NotNull
        public BlockUserInteractor.State invoke(@NotNull BlockUserInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (Intrinsics.areEqual(state, BlockUserInteractor.State.Empty.INSTANCE) || Intrinsics.areEqual(state, BlockUserInteractor.State.Blocked.INSTANCE) || (state instanceof BlockUserInteractor.State.Error)) {
                this.e.getReducerQueue().plusAssign(new BlockUserMutator());
                return new BlockUserInteractor.State.InProgress(this.d);
            } else if (state instanceof BlockUserInteractor.State.InProgress) {
                return state;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class a<T> implements Consumer<BlacklistInfo> {
        public final /* synthetic */ BlockUserInteractorImpl a;

        public a(BlockUserInteractorImpl blockUserInteractorImpl) {
            this.a = blockUserInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(BlacklistInfo blacklistInfo) {
            BlacklistInfo blacklistInfo2 = blacklistInfo;
            this.a.getResultStream().accept(new BlockUserInteractor.Result.Success(new BlockUserInteractor.Action.BlockUser(blacklistInfo2.userId, blacklistInfo2.context.getChannelId(), blacklistInfo2.context.getItemId(), null), true, false));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public BlockUserInteractorImpl(@NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull SchedulersFactory schedulersFactory) {
        super("BlockUserInteractorImpl", BlockUserInteractor.State.Empty.INSTANCE, schedulersFactory, new CancelChecker(), null, null, null, null, 240, null);
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.r = messengerClient;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.p = compositeDisposable;
        Disposable subscribe = messengerClient.observeChatEvents(BlacklistInfo.class).observeOn(schedulersFactory.computation()).subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "client.observeChatEvents…          )\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
    }

    @Override // com.avito.android.messenger.blacklist_reasons.BlockUserInteractor
    public void blockUser(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        getReducerQueue().plusAssign(new StartBlockingProgressMutator(this, new BlockUserInteractor.Action.BlockUser(str, str2, str3, l)));
    }

    @Override // com.avito.android.messenger.blacklist_reasons.BlockUserInteractor
    public void confirmChatAsSpam(boolean z, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "messageId");
        getReducerQueue().plusAssign(new StartBlockingProgressMutator(this, new BlockUserInteractor.Action.ConfirmChatAsSpam(str, str2, str4, str3, z)));
    }

    @Override // com.avito.android.messenger.blacklist_reasons.BlockUserInteractor
    public void reset() {
        getReducerQueue().plusAssign(ResetMutator.INSTANCE);
    }

    @Override // com.avito.android.messenger.blacklist_reasons.BlockUserInteractor
    public void retry() {
        getReducerQueue().plusAssign(new RetryMutator());
    }

    @Override // com.avito.android.messenger.blacklist_reasons.BlockUserInteractor
    @NotNull
    public Relay<BlockUserInteractor.Result> getResultStream() {
        return this.q;
    }
}
