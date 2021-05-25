package com.avito.android.messenger.blacklist.mvi;

import com.avito.android.Features;
import com.avito.android.date_time_formatter.BlacklistDateFormatter;
import com.avito.android.messenger.ErrorType;
import com.avito.android.messenger.blacklist.mvi.BlacklistInteractor;
import com.avito.android.messenger.blacklist.mvi.BlacklistPresenter;
import com.avito.android.messenger.blacklist.mvi.adapter.BlacklistItem;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker;
import com.avito.android.messenger.channels.mvi.common.v4.SimpleReducerQueue;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.UnauthorizedException;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.vk.sdk.api.VKApiConst;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.rxkotlin.DisposableKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.BlockedUser;
import ru.avito.messenger.api.entity.context.ChannelContext;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u000223BC\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030-¢\u0006\u0004\b/\u00100B7\b\u0017\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0004\b/\u00101J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\r\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010\u001f¨\u00064"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenterImpl;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;", "", "initialDataRequest", "()V", "refresh", "requestNextPage", "Lcom/avito/android/messenger/blacklist/mvi/adapter/BlacklistItem$BlockedUser;", "data", "onUnblockClick", "(Lcom/avito/android/messenger/blacklist/mvi/adapter/BlacklistItem$BlockedUser;)V", "onCleared", "Lio/reactivex/disposables/CompositeDisposable;", "r", "Lio/reactivex/disposables/CompositeDisposable;", "lowerLayerSubscriptions", "Lcom/avito/android/date_time_formatter/BlacklistDateFormatter;", "t", "Lcom/avito/android/date_time_formatter/BlacklistDateFormatter;", "dateFormatter", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor;", "s", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor;", "blacklistInteractor", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "", VKApiConst.Q, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getShowErrorStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "showErrorStream", "Lcom/avito/android/util/Formatter;", "", "u", "Lcom/avito/android/util/Formatter;", "errorFormatter", "p", "getShowLoginScreenStream", "showLoginScreenStream", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "reducerQueue", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor;Lcom/avito/android/date_time_formatter/BlacklistDateFormatter;Lcom/avito/android/util/Formatter;Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;)V", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor;Lcom/avito/android/date_time_formatter/BlacklistDateFormatter;Lcom/avito/android/util/Formatter;)V", AuthSource.SEND_ABUSE, "NewBlacklistInteractorStateMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlacklistPresenterImpl extends BaseMviEntityWithReducerQueue<BlacklistPresenter.State> implements BlacklistPresenter {
    @NotNull
    public final SingleLiveEvent<Unit> p;
    @NotNull
    public final SingleLiveEvent<String> q;
    public final CompositeDisposable r;
    public final BlacklistInteractor s;
    public final BlacklistDateFormatter t;
    public final Formatter<Throwable> u;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenterImpl$NewBlacklistInteractorStateMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;)Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "d", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "interactorState", "<init>", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenterImpl;Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class NewBlacklistInteractorStateMutator extends Mutator<BlacklistPresenter.State> {
        public final BlacklistInteractor.State d;
        public final /* synthetic */ BlacklistPresenterImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NewBlacklistInteractorStateMutator(@NotNull BlacklistPresenterImpl blacklistPresenterImpl, BlacklistInteractor.State state) {
            super("NewBlacklistInteractorStateMutator", "interactorState = " + state);
            Intrinsics.checkNotNullParameter(state, "interactorState");
            this.e = blacklistPresenterImpl;
            this.d = state;
        }

        @NotNull
        public BlacklistPresenter.State invoke(@NotNull BlacklistPresenter.State state) {
            BlacklistPresenter.State.ProgressOverlayState progressOverlayState;
            NewBlacklistInteractorStateMutator newBlacklistInteractorStateMutator = this;
            Intrinsics.checkNotNullParameter(state, "oldState");
            BlacklistInteractor.State state2 = newBlacklistInteractorStateMutator.d;
            BlacklistInteractor.State.Loading initialLoadingState = state2.getInitialLoadingState();
            if (initialLoadingState instanceof BlacklistInteractor.State.Loading.InProgress) {
                progressOverlayState = BlacklistPresenter.State.ProgressOverlayState.Loading.INSTANCE;
            } else if (initialLoadingState instanceof BlacklistInteractor.State.Loading.Finished) {
                progressOverlayState = BlacklistPresenter.State.ProgressOverlayState.Hidden.INSTANCE;
            } else if (initialLoadingState instanceof BlacklistInteractor.State.Loading.Error) {
                progressOverlayState = BlacklistPresenter.State.ProgressOverlayState.Error.INSTANCE;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            ArrayList arrayList = new ArrayList();
            List<BlockedUser> blockedUsers = state2.getBlockedUsers();
            Map<String, Long> unblockingUsers = state2.getUnblockingUsers();
            for (T t : blockedUsers) {
                String id = t.getUser().getId();
                String name = t.getUser().getName();
                ChannelContext context = t.getContext();
                if (!(context instanceof ChannelContext.Item)) {
                    context = null;
                }
                ChannelContext.Item item = (ChannelContext.Item) context;
                String title = item != null ? item.getTitle() : null;
                ru.avito.messenger.api.entity.context.ChannelContext context2 = t.getContext();
                if (!(context2 instanceof ChannelContext.Item)) {
                    context2 = null;
                }
                ChannelContext.Item item2 = (ChannelContext.Item) context2;
                String price = item2 != null ? item2.getPrice() : null;
                ru.avito.messenger.api.entity.context.ChannelContext context3 = t.getContext();
                if (!(context3 instanceof ChannelContext.Item)) {
                    context3 = null;
                }
                ChannelContext.Item item3 = (ChannelContext.Item) context3;
                arrayList.add(new BlacklistItem.BlockedUser(id, name, title, price, item3 != null ? item3.getCategory() : null, newBlacklistInteractorStateMutator.e.t.format(Long.valueOf(TimeUnit.SECONDS.toMillis(t.getCreated()))), unblockingUsers.keySet().contains(t.getUser().getId())));
                newBlacklistInteractorStateMutator = this;
            }
            if (state2.getNextPageLoadingState() instanceof BlacklistInteractor.State.Loading.InProgress) {
                arrayList.add(BlacklistItem.PaginationInProgress.INSTANCE);
            }
            return state.copy(progressOverlayState, state2.getRefreshState() instanceof BlacklistInteractor.State.Loading.InProgress, state2.getHasMoreItems() && state2.getNextPageLoadingState() == BlacklistInteractor.State.Loading.Finished.INSTANCE, arrayList);
        }
    }

    public static final class a implements ShouldCancelChecker<BlacklistPresenter.State> {
        @NotNull
        public static final a a = new a();

        @Override // com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker
        public boolean aShouldCancelB(@NotNull Reducible<BlacklistPresenter.State> reducible, @NotNull Reducible<BlacklistPresenter.State> reducible2) {
            Intrinsics.checkNotNullParameter(reducible, AuthSource.SEND_ABUSE);
            Intrinsics.checkNotNullParameter(reducible2, AuthSource.BOOKING_ORDER);
            if (!(reducible instanceof NewBlacklistInteractorStateMutator) || !(reducible2 instanceof NewBlacklistInteractorStateMutator)) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BlacklistPresenterImpl(@NotNull SchedulersFactory schedulersFactory, @NotNull Features features, @NotNull BlacklistInteractor blacklistInteractor, @NotNull BlacklistDateFormatter blacklistDateFormatter, @NotNull Formatter<Throwable> formatter, @NotNull ReducerQueue<BlacklistPresenter.State> reducerQueue) {
        super("BlacklistPresenter", BlacklistPresenter.State.Companion.getDEFAULT(), schedulersFactory, a.a, reducerQueue, null, null, null, 224, null);
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(blacklistInteractor, "blacklistInteractor");
        Intrinsics.checkNotNullParameter(blacklistDateFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(reducerQueue, "reducerQueue");
        this.s = blacklistInteractor;
        this.t = blacklistDateFormatter;
        this.u = formatter;
        this.p = new SingleLiveEvent<>();
        this.q = new SingleLiveEvent<>();
        this.r = new CompositeDisposable();
        Scheduler io2 = getSchedulers().io();
        CompositeDisposable compositeDisposable = this.r;
        SharedScheduler sharedScheduler = new SharedScheduler(io2);
        compositeDisposable.add(Disposables.fromAction(new Action() { // from class: com.avito.android.messenger.blacklist.mvi.BlacklistPresenterImpl$inlined$sam$i$io_reactivex_functions_Action$0
            @Override // io.reactivex.functions.Action
            public final /* synthetic */ void run() {
                Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
            }
        }));
        Disposable subscribe = this.s.getStateObservable().observeOn(sharedScheduler).scan(new BlacklistPresenterImpl$subscribeToBlacklistInteractorStateUpdates$1(this)).subscribeOn(sharedScheduler).subscribe(new BlacklistPresenterImpl$subscribeToBlacklistInteractorStateUpdates$2(this), new BlacklistPresenterKt$sam$i$io_reactivex_functions_Consumer$0(new BlacklistPresenterImpl$logError$1(this, "blacklistInteractor.stateObservable")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "blacklistInteractor.stat…bservable\")\n            )");
        DisposableKt.addTo(subscribe, this.r);
    }

    public static final Function1 access$logError(BlacklistPresenterImpl blacklistPresenterImpl, String str) {
        Objects.requireNonNull(blacklistPresenterImpl);
        return new BlacklistPresenterImpl$logError$1(blacklistPresenterImpl, str);
    }

    public static final boolean access$shouldShowLoginScreen(BlacklistPresenterImpl blacklistPresenterImpl, BlacklistInteractor.State.Loading.Error error) {
        Object obj;
        Objects.requireNonNull(blacklistPresenterImpl);
        Throwable throwable = error.getThrowable();
        ErrorType.Companion companion = ErrorType.Companion;
        if (throwable instanceof UnauthorizedException) {
            obj = ErrorType.Unauthorized.INSTANCE;
        } else if (throwable instanceof IOException) {
            obj = ErrorType.Network.INSTANCE;
        } else {
            obj = ErrorType.Other.INSTANCE;
        }
        return ((ErrorType) TuplesKt.to(obj, blacklistPresenterImpl.u.format(throwable)).getFirst()) == ErrorType.Unauthorized.INSTANCE;
    }

    public static final void access$showLoginScreen(BlacklistPresenterImpl blacklistPresenterImpl) {
        blacklistPresenterImpl.getShowLoginScreenStream().postValue(Unit.INSTANCE);
    }

    public static final void access$subscribeToBlacklistInteractorStateUpdates(BlacklistPresenterImpl blacklistPresenterImpl, Scheduler scheduler) {
        Objects.requireNonNull(blacklistPresenterImpl);
        Disposable subscribe = blacklistPresenterImpl.s.getStateObservable().observeOn(scheduler).scan(new BlacklistPresenterImpl$subscribeToBlacklistInteractorStateUpdates$1(blacklistPresenterImpl)).subscribeOn(scheduler).subscribe(new BlacklistPresenterImpl$subscribeToBlacklistInteractorStateUpdates$2(blacklistPresenterImpl), new BlacklistPresenterKt$sam$i$io_reactivex_functions_Consumer$0(new BlacklistPresenterImpl$logError$1(blacklistPresenterImpl, "blacklistInteractor.stateObservable")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "blacklistInteractor.stat…bservable\")\n            )");
        DisposableKt.addTo(subscribe, blacklistPresenterImpl.r);
    }

    public static final Pair access$toErrorMetaInfo(BlacklistPresenterImpl blacklistPresenterImpl, Throwable th) {
        Object obj;
        Objects.requireNonNull(blacklistPresenterImpl);
        ErrorType.Companion companion = ErrorType.Companion;
        if (th instanceof UnauthorizedException) {
            obj = ErrorType.Unauthorized.INSTANCE;
        } else if (th instanceof IOException) {
            obj = ErrorType.Network.INSTANCE;
        } else {
            obj = ErrorType.Other.INSTANCE;
        }
        return TuplesKt.to(obj, blacklistPresenterImpl.u.format(th));
    }

    @Override // com.avito.android.messenger.blacklist.mvi.BlacklistPresenter
    public void initialDataRequest() {
        this.s.initialDataRequest();
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.r.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.blacklist.mvi.adapter.blocked_user.UnblockClickListener
    public void onUnblockClick(@NotNull BlacklistItem.BlockedUser blockedUser) {
        Intrinsics.checkNotNullParameter(blockedUser, "data");
        this.s.unblockUser(blockedUser.getUserId());
    }

    @Override // com.avito.android.messenger.blacklist.mvi.BlacklistPresenter
    public void refresh() {
        this.s.refresh();
    }

    @Override // com.avito.android.messenger.blacklist.mvi.BlacklistPresenter
    public void requestNextPage() {
        this.s.requestNextPage();
    }

    @Override // com.avito.android.messenger.blacklist.mvi.BlacklistPresenter
    @NotNull
    public SingleLiveEvent<String> getShowErrorStream() {
        return this.q;
    }

    @Override // com.avito.android.messenger.blacklist.mvi.BlacklistPresenter
    @NotNull
    public SingleLiveEvent<Unit> getShowLoginScreenStream() {
        return this.p;
    }

    public static final boolean access$shouldShowLoginScreen(BlacklistPresenterImpl blacklistPresenterImpl, BlacklistInteractor.State.Loading loading, BlacklistInteractor.State.Loading... loadingArr) {
        Object obj;
        Object obj2;
        Objects.requireNonNull(blacklistPresenterImpl);
        if (loading instanceof BlacklistInteractor.State.Loading.Error) {
            Throwable throwable = ((BlacklistInteractor.State.Loading.Error) loading).getThrowable();
            ErrorType.Companion companion = ErrorType.Companion;
            if (throwable instanceof UnauthorizedException) {
                obj2 = ErrorType.Unauthorized.INSTANCE;
            } else if (throwable instanceof IOException) {
                obj2 = ErrorType.Network.INSTANCE;
            } else {
                obj2 = ErrorType.Other.INSTANCE;
            }
            if (((ErrorType) TuplesKt.to(obj2, blacklistPresenterImpl.u.format(throwable)).getFirst()) == ErrorType.Unauthorized.INSTANCE) {
                return true;
            }
        }
        for (BlacklistInteractor.State.Loading loading2 : loadingArr) {
            if (loading2 instanceof BlacklistInteractor.State.Loading.Error) {
                Throwable throwable2 = ((BlacklistInteractor.State.Loading.Error) loading2).getThrowable();
                ErrorType.Companion companion2 = ErrorType.Companion;
                if (throwable2 instanceof UnauthorizedException) {
                    obj = ErrorType.Unauthorized.INSTANCE;
                } else if (throwable2 instanceof IOException) {
                    obj = ErrorType.Network.INSTANCE;
                } else {
                    obj = ErrorType.Other.INSTANCE;
                }
                if (((ErrorType) TuplesKt.to(obj, blacklistPresenterImpl.u.format(throwable2)).getFirst()) == ErrorType.Unauthorized.INSTANCE) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public BlacklistPresenterImpl(@NotNull SchedulersFactory schedulersFactory, @NotNull Features features, @NotNull BlacklistInteractor blacklistInteractor, @NotNull BlacklistDateFormatter blacklistDateFormatter, @NotNull Formatter<Throwable> formatter) {
        this(schedulersFactory, features, blacklistInteractor, blacklistDateFormatter, formatter, new SimpleReducerQueue(schedulersFactory.io(), null, 2, null));
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(blacklistInteractor, "blacklistInteractor");
        Intrinsics.checkNotNullParameter(blacklistDateFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        if ((((com.avito.android.messenger.ErrorType) kotlin.TuplesKt.to(r0, r7.u.format(r8)).getFirst()) == com.avito.android.messenger.ErrorType.Unauthorized.INSTANCE) != false) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean access$shouldShowLoginScreen(com.avito.android.messenger.blacklist.mvi.BlacklistPresenterImpl r7, com.avito.android.messenger.blacklist.mvi.BlacklistInteractor.State r8) {
        /*
            java.util.Objects.requireNonNull(r7)
            com.avito.android.messenger.blacklist.mvi.BlacklistInteractor$State$Loading r0 = r8.getInitialLoadingState()
            r1 = 2
            com.avito.android.messenger.blacklist.mvi.BlacklistInteractor$State$Loading[] r2 = new com.avito.android.messenger.blacklist.mvi.BlacklistInteractor.State.Loading[r1]
            com.avito.android.messenger.blacklist.mvi.BlacklistInteractor$State$Loading r3 = r8.getRefreshState()
            r4 = 0
            r2[r4] = r3
            com.avito.android.messenger.blacklist.mvi.BlacklistInteractor$State$Loading r8 = r8.getNextPageLoadingState()
            r3 = 1
            r2[r3] = r8
            boolean r8 = r0 instanceof com.avito.android.messenger.blacklist.mvi.BlacklistInteractor.State.Loading.Error
            if (r8 == 0) goto L_0x0050
            com.avito.android.messenger.blacklist.mvi.BlacklistInteractor$State$Loading$Error r0 = (com.avito.android.messenger.blacklist.mvi.BlacklistInteractor.State.Loading.Error) r0
            java.lang.Throwable r8 = r0.getThrowable()
            com.avito.android.messenger.ErrorType$Companion r0 = com.avito.android.messenger.ErrorType.Companion
            boolean r0 = r8 instanceof com.avito.android.util.UnauthorizedException
            if (r0 == 0) goto L_0x002b
            com.avito.android.messenger.ErrorType$Unauthorized r0 = com.avito.android.messenger.ErrorType.Unauthorized.INSTANCE
            goto L_0x0034
        L_0x002b:
            boolean r0 = r8 instanceof java.io.IOException
            if (r0 == 0) goto L_0x0032
            com.avito.android.messenger.ErrorType$Network r0 = com.avito.android.messenger.ErrorType.Network.INSTANCE
            goto L_0x0034
        L_0x0032:
            com.avito.android.messenger.ErrorType$Other r0 = com.avito.android.messenger.ErrorType.Other.INSTANCE
        L_0x0034:
            com.avito.android.util.Formatter r5 = access$getErrorFormatter$p(r7)
            java.lang.String r8 = r5.format(r8)
            kotlin.Pair r8 = kotlin.TuplesKt.to(r0, r8)
            java.lang.Object r8 = r8.getFirst()
            com.avito.android.messenger.ErrorType r8 = (com.avito.android.messenger.ErrorType) r8
            com.avito.android.messenger.ErrorType$Unauthorized r0 = com.avito.android.messenger.ErrorType.Unauthorized.INSTANCE
            if (r8 != r0) goto L_0x004c
            r8 = 1
            goto L_0x004d
        L_0x004c:
            r8 = 0
        L_0x004d:
            if (r8 == 0) goto L_0x0050
            goto L_0x008c
        L_0x0050:
            r8 = 0
        L_0x0051:
            if (r8 >= r1) goto L_0x0091
            r0 = r2[r8]
            boolean r5 = r0 instanceof com.avito.android.messenger.blacklist.mvi.BlacklistInteractor.State.Loading.Error
            if (r5 == 0) goto L_0x008e
            com.avito.android.messenger.blacklist.mvi.BlacklistInteractor$State$Loading$Error r0 = (com.avito.android.messenger.blacklist.mvi.BlacklistInteractor.State.Loading.Error) r0
            java.lang.Throwable r0 = r0.getThrowable()
            com.avito.android.messenger.ErrorType$Companion r5 = com.avito.android.messenger.ErrorType.Companion
            boolean r5 = r0 instanceof com.avito.android.util.UnauthorizedException
            if (r5 == 0) goto L_0x0068
            com.avito.android.messenger.ErrorType$Unauthorized r5 = com.avito.android.messenger.ErrorType.Unauthorized.INSTANCE
            goto L_0x0071
        L_0x0068:
            boolean r5 = r0 instanceof java.io.IOException
            if (r5 == 0) goto L_0x006f
            com.avito.android.messenger.ErrorType$Network r5 = com.avito.android.messenger.ErrorType.Network.INSTANCE
            goto L_0x0071
        L_0x006f:
            com.avito.android.messenger.ErrorType$Other r5 = com.avito.android.messenger.ErrorType.Other.INSTANCE
        L_0x0071:
            com.avito.android.util.Formatter r6 = access$getErrorFormatter$p(r7)
            java.lang.String r0 = r6.format(r0)
            kotlin.Pair r0 = kotlin.TuplesKt.to(r5, r0)
            java.lang.Object r0 = r0.getFirst()
            com.avito.android.messenger.ErrorType r0 = (com.avito.android.messenger.ErrorType) r0
            com.avito.android.messenger.ErrorType$Unauthorized r5 = com.avito.android.messenger.ErrorType.Unauthorized.INSTANCE
            if (r0 != r5) goto L_0x0089
            r0 = 1
            goto L_0x008a
        L_0x0089:
            r0 = 0
        L_0x008a:
            if (r0 == 0) goto L_0x008e
        L_0x008c:
            r4 = 1
            goto L_0x0091
        L_0x008e:
            int r8 = r8 + 1
            goto L_0x0051
        L_0x0091:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.blacklist.mvi.BlacklistPresenterImpl.access$shouldShowLoginScreen(com.avito.android.messenger.blacklist.mvi.BlacklistPresenterImpl, com.avito.android.messenger.blacklist.mvi.BlacklistInteractor$State):boolean");
    }
}
