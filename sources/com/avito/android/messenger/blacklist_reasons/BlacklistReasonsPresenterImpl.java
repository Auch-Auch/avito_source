package com.avito.android.messenger.blacklist_reasons;

import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsProvider;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsView;
import com.avito.android.messenger.blacklist_reasons.BlockUserInteractor;
import com.avito.android.messenger.channels.mvi.common.v2.Action;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002,-B/\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006."}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsPresenterImpl;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State;", "", "loadBlacklistReasons", "()V", "", ChannelContext.Item.USER_ID, "channelId", "itemId", "", "reasonId", "blockUserWithReason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "retry", "onCleared", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "n", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getUserBlockedStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "userBlockedStream", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "o", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "blockUserInteractor", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider;", "p", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider;", "blacklistReasonsProvider", "Lcom/avito/android/util/Formatter;", "", VKApiConst.Q, "Lcom/avito/android/util/Formatter;", "errorFormatter", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider;Lcom/avito/android/util/Formatter;Lcom/avito/android/util/SchedulersFactory;)V", "NewStatesMutator", "RetryAction", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlacklistReasonsPresenterImpl extends BaseMviEntityWithMutatorsRelay<BlacklistReasonsView.State> implements BlacklistReasonsPresenter {
    public final CompositeDisposable m;
    @NotNull
    public final SingleLiveEvent<Unit> n = new SingleLiveEvent<>();
    public final BlockUserInteractor o;
    public final BlacklistReasonsProvider p;
    public final Formatter<Throwable> q;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsPresenterImpl$NewStatesMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State;)Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State;", "d", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State;", "reasonsState", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;", "c", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;", "interactorState", "<init>", "(Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsPresenterImpl;Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class NewStatesMutator extends Mutator<BlacklistReasonsView.State> {
        public final BlockUserInteractor.State c;
        public final BlacklistReasonsProvider.State d;
        public final /* synthetic */ BlacklistReasonsPresenterImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NewStatesMutator(@NotNull BlacklistReasonsPresenterImpl blacklistReasonsPresenterImpl, @NotNull BlockUserInteractor.State state, BlacklistReasonsProvider.State state2) {
            super(null, 1, null);
            Intrinsics.checkNotNullParameter(state, "interactorState");
            Intrinsics.checkNotNullParameter(state2, "reasonsState");
            this.e = blacklistReasonsPresenterImpl;
            this.c = state;
            this.d = state2;
        }

        @NotNull
        public BlacklistReasonsView.State invoke(@NotNull BlacklistReasonsView.State state) {
            BlacklistReasonsView.State blockUserError;
            Intrinsics.checkNotNullParameter(state, "oldState");
            BlacklistReasonsProvider.State state2 = this.d;
            if (Intrinsics.areEqual(state2, BlacklistReasonsProvider.State.Loading.INSTANCE)) {
                return BlacklistReasonsView.State.InProgress.Reasons.INSTANCE;
            }
            if (state2 instanceof BlacklistReasonsProvider.State.Empty) {
                if (((BlacklistReasonsProvider.State.Empty) this.d).getError() == null) {
                    return BlacklistReasonsView.State.Empty.INSTANCE;
                }
                blockUserError = new BlacklistReasonsView.State.List.ReasonsError(this.e.q.format(((BlacklistReasonsProvider.State.Empty) this.d).getError()));
            } else if (state2 instanceof BlacklistReasonsProvider.State.Loaded) {
                BlockUserInteractor.State state3 = this.c;
                if (Intrinsics.areEqual(state3, BlockUserInteractor.State.Empty.INSTANCE)) {
                    return new BlacklistReasonsView.State.List.Ok(((BlacklistReasonsProvider.State.Loaded) this.d).getReasons());
                }
                if (Intrinsics.areEqual(state3, BlockUserInteractor.State.Blocked.INSTANCE)) {
                    return BlacklistReasonsView.State.Empty.INSTANCE;
                }
                if (state3 instanceof BlockUserInteractor.State.InProgress) {
                    return BlacklistReasonsView.State.InProgress.BlockUser.INSTANCE;
                }
                if (state3 instanceof BlockUserInteractor.State.Error) {
                    blockUserError = new BlacklistReasonsView.State.List.BlockUserError(((BlacklistReasonsProvider.State.Loaded) this.d).getReasons(), this.e.q.format(((BlockUserInteractor.State.Error) this.c).getError()));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return blockUserError;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsPresenterImpl$RetryAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State;)V", "<init>", "(Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsPresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class RetryAction extends Action<BlacklistReasonsView.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public RetryAction() {
            super(null, 1, null);
        }

        public void invoke(@NotNull BlacklistReasonsView.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (Intrinsics.areEqual(state, BlacklistReasonsView.State.Empty.INSTANCE) || (state instanceof BlacklistReasonsView.State.List.ReasonsError)) {
                BlacklistReasonsPresenterImpl.this.loadBlacklistReasons();
            } else if (state instanceof BlacklistReasonsView.State.List.BlockUserError) {
                BlacklistReasonsPresenterImpl.this.o.retry();
            }
        }
    }

    public static final class a<T> implements Consumer<Pair<? extends BlockUserInteractor.State, ? extends BlacklistReasonsProvider.State>> {
        public final /* synthetic */ BlacklistReasonsPresenterImpl a;

        public a(BlacklistReasonsPresenterImpl blacklistReasonsPresenterImpl) {
            this.a = blacklistReasonsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Pair<? extends BlockUserInteractor.State, ? extends BlacklistReasonsProvider.State> pair) {
            Pair<? extends BlockUserInteractor.State, ? extends BlacklistReasonsProvider.State> pair2 = pair;
            Relay mutatorsRelay = this.a.getMutatorsRelay();
            NewStatesMutator newStatesMutator = new NewStatesMutator(this.a, (BlockUserInteractor.State) pair2.component1(), (BlacklistReasonsProvider.State) pair2.component2());
            mutatorsRelay.accept(new MutatorSingle(newStatesMutator.getName(), new BlacklistReasonsPresenterImpl$1$$special$$inlined$plusAssign$1(newStatesMutator)));
        }
    }

    public static final class b<T> implements Predicate<BlockUserInteractor.Result.Success> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(BlockUserInteractor.Result.Success success) {
            BlockUserInteractor.Result.Success success2 = success;
            Intrinsics.checkNotNullParameter(success2, "result");
            return success2.isLocal();
        }
    }

    public static final class c<T> implements Consumer<BlockUserInteractor.Result.Success> {
        public final /* synthetic */ BlacklistReasonsPresenterImpl a;

        public c(BlacklistReasonsPresenterImpl blacklistReasonsPresenterImpl) {
            this.a = blacklistReasonsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(BlockUserInteractor.Result.Success success) {
            this.a.getUserBlockedStream().postValue(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public BlacklistReasonsPresenterImpl(@NotNull BlockUserInteractor blockUserInteractor, @NotNull BlacklistReasonsProvider blacklistReasonsProvider, @NotNull Formatter<Throwable> formatter, @NotNull SchedulersFactory schedulersFactory) {
        super("BlacklistReasonsPresenter", BlacklistReasonsView.State.Empty.INSTANCE, schedulersFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(blockUserInteractor, "blockUserInteractor");
        Intrinsics.checkNotNullParameter(blacklistReasonsProvider, "blacklistReasonsProvider");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.o = blockUserInteractor;
        this.p = blacklistReasonsProvider;
        this.q = formatter;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.m = compositeDisposable;
        Observable combineLatest = Observable.combineLatest(blockUserInteractor.getStateObservable(), blacklistReasonsProvider.getStateObservable(), new BiFunction<T1, T2, R>() { // from class: com.avito.android.messenger.blacklist_reasons.BlacklistReasonsPresenterImpl$$special$$inlined$combineLatestWith$1
            @Override // io.reactivex.functions.BiFunction
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                return (R) TuplesKt.to(t1, t2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
        Disposable subscribe = combineLatest.observeOn(schedulersFactory.computation()).subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "blockUserInteractor.stat…asonsState)\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
        Observable<U> ofType = blockUserInteractor.getResultStream().ofType(BlockUserInteractor.Result.Success.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        Disposable subscribe2 = ofType.filter(b.a).subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "blockUserInteractor.resu…dStream.postValue(Unit) }");
        DisposableKt.addTo(subscribe2, compositeDisposable);
    }

    @Override // com.avito.android.messenger.blacklist_reasons.BlacklistReasonsPresenter
    public void blockUserWithReason(@NotNull String str, @NotNull String str2, @Nullable String str3, long j) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        this.o.blockUser(str, str2, str3, Long.valueOf(j));
    }

    @Override // com.avito.android.messenger.blacklist_reasons.BlacklistReasonsPresenter
    public void loadBlacklistReasons() {
        this.o.reset();
        BlacklistReasonsProvider.DefaultImpls.loadBlacklistReasons$default(this.p, false, 1, null);
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.m.clear();
        this.o.reset();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.blacklist_reasons.BlacklistReasonsPresenter
    public void retry() {
        Relay mutatorsRelay = getMutatorsRelay();
        RetryAction retryAction = new RetryAction();
        mutatorsRelay.accept(new MutatorSingle(retryAction.getName(), new BlacklistReasonsPresenterImpl$retry$$inlined$plusAssign$1(retryAction)));
    }

    @Override // com.avito.android.messenger.blacklist_reasons.BlacklistReasonsPresenter
    @NotNull
    public SingleLiveEvent<Unit> getUserBlockedStream() {
        return this.n;
    }
}
