package com.avito.android.messenger.blacklist.mvi;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.blacklist.mvi.BlacklistInteractor;
import com.avito.android.messenger.channels.mvi.common.v4.Action;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.common.v4.MutatorSingle;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker;
import com.avito.android.messenger.channels.mvi.common.v4.SimpleReducerQueue;
import com.avito.android.messenger.util.ThrowablesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.rx.arrow.OptionKt;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
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
import ru.avito.messenger.api.entity.BlockedUser;
import ru.avito.messenger.api.entity.event.BlacklistInfo;
import ru.avito.messenger.api.entity.event.BlacklistRemoveEvent;
import t6.n.h;
import t6.n.r;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\b./012345B@\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0011\u0010\"\u001a\r\u0012\t\u0012\u00070\u001e¢\u0006\u0002\b\u001f0\u001d\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030)¢\u0006\u0004\b+\u0010,B4\b\u0017\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0011\u0010\"\u001a\r\u0012\t\u0012\u00070\u001e¢\u0006\u0002\b\u001f0\u001d¢\u0006\u0004\b+\u0010-J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\r\u0010\u0006R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR!\u0010\"\u001a\r\u0012\t\u0012\u00070\u001e¢\u0006\u0002\b\u001f0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001b¨\u00066"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "", "initialDataRequest", "()V", "refresh", "requestNextPage", "", ChannelContext.Item.USER_ID, "unblockUser", "(Ljava/lang/String;)V", "onCleared", "Lcom/jakewharton/rxrelay2/Relay;", "", "p", "Lcom/jakewharton/rxrelay2/Relay;", "getErrorStream", "()Lcom/jakewharton/rxrelay2/Relay;", "errorStream", "Lcom/avito/android/account/AccountStateProvider;", "s", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lio/reactivex/disposables/CompositeDisposable;", "r", "Lio/reactivex/disposables/CompositeDisposable;", "allSubscriptions", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "t", "Lru/avito/messenger/MessengerClient;", "client", VKApiConst.Q, "afterInitSubscriptions", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "reducerQueue", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;Lcom/avito/android/account/AccountStateProvider;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;)V", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;Lcom/avito/android/account/AccountStateProvider;Lru/avito/messenger/MessengerClient;)V", AuthSource.SEND_ABUSE, "InitialDataRequestComposite", "NextPageRequestComposite", "OnReconnectAction", "OnRemovedFromBlacklistMutator", "PerformRefreshMutator", "RefreshComposite", "UnblockUserComposite", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlacklistInteractorImpl extends BaseMviEntityWithReducerQueue<BlacklistInteractor.State> implements BlacklistInteractor {
    @NotNull
    public final Relay<Throwable> p;
    public final CompositeDisposable q;
    public final CompositeDisposable r;
    public final AccountStateProvider s;
    public final MessengerClient<AvitoMessengerApi> t;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010R.\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00040\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$InitialDataRequestComposite;", "Lcom/avito/android/messenger/channels/mvi/common/v4/CompositeReducible;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "Lkotlin/Function0;", "", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "d", "Lkotlin/jvm/functions/Function0;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "block", "", "e", "J", "id", "<init>", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl;J)V", "SetInProgressMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class InitialDataRequestComposite extends CompositeReducible<BlacklistInteractor.State> {
        @NotNull
        public final Function0<List<Reducible<BlacklistInteractor.State>>> d = new a(this);
        public final long e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$InitialDataRequestComposite$SetInProgressMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "<init>", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$InitialDataRequestComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class SetInProgressMutator extends Mutator<BlacklistInteractor.State> {

            public static final class a extends Lambda implements Function1<BlacklistInteractor.State, BlacklistInteractor.State> {
                public final /* synthetic */ InitialDataRequestComposite a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(InitialDataRequestComposite initialDataRequestComposite) {
                    super(1);
                    this.a = initialDataRequestComposite;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public BlacklistInteractor.State invoke(BlacklistInteractor.State state) {
                    Intrinsics.checkNotNullParameter(state, "it");
                    return BlacklistInteractor.State.copy$default(BlacklistInteractor.State.Companion.getDEFAULT(), new BlacklistInteractor.State.Loading.InProgress(this.a.e), null, null, null, false, null, 62, null);
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public SetInProgressMutator(InitialDataRequestComposite initialDataRequestComposite) {
                super(initialDataRequestComposite.getName() + ".SetInProgressMutator", initialDataRequestComposite.getParams(), new a(initialDataRequestComposite));
            }
        }

        public static final class a extends Lambda implements Function0<List<? extends Reducible<BlacklistInteractor.State>>> {
            public final /* synthetic */ InitialDataRequestComposite a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(InitialDataRequestComposite initialDataRequestComposite) {
                super(0);
                this.a = initialDataRequestComposite;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends Reducible<BlacklistInteractor.State>> invoke() {
                InitialDataRequestComposite initialDataRequestComposite = this.a;
                return CollectionsKt__CollectionsKt.listOf((Object[]) new Reducible[]{new SetInProgressMutator(this.a), new PerformRefreshMutator(initialDataRequestComposite.getName(), this.a.getParams())});
            }
        }

        public InitialDataRequestComposite(long j) {
            super("InitialDataRequestComposite", a2.b.a.a.a.T2("id = ", j), null, 4, null);
            this.e = j;
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible
        @NotNull
        public Function0<List<Reducible<BlacklistInteractor.State>>> getBlock() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0011\u0012B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010R.\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00040\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$NextPageRequestComposite;", "Lcom/avito/android/messenger/channels/mvi/common/v4/CompositeReducible;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "Lkotlin/Function0;", "", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "d", "Lkotlin/jvm/functions/Function0;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "block", "", "e", "J", "id", "<init>", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl;J)V", "LoadNextPageMutator", "SetInProgressMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class NextPageRequestComposite extends CompositeReducible<BlacklistInteractor.State> {
        @NotNull
        public final Function0<List<Reducible<BlacklistInteractor.State>>> d = new a(this);
        public final long e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$NextPageRequestComposite$LoadNextPageMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;)Lio/reactivex/Single;", "<init>", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$NextPageRequestComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class LoadNextPageMutator extends MutatorSingle<BlacklistInteractor.State> {

            public static final class a<T, R> implements Function<List<? extends BlockedUser>, BlacklistInteractor.State> {
                public final /* synthetic */ BlacklistInteractor.State a;

                public a(BlacklistInteractor.State state) {
                    this.a = state;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // io.reactivex.functions.Function
                public BlacklistInteractor.State apply(List<? extends BlockedUser> list) {
                    List<? extends BlockedUser> list2 = list;
                    Intrinsics.checkNotNullParameter(list2, "nextPageOfBlockedUsers");
                    BlacklistInteractor.State state = this.a;
                    return BlacklistInteractor.State.copy$default(state, null, null, BlacklistInteractor.State.Loading.Finished.INSTANCE, CollectionsKt___CollectionsKt.plus((Collection) state.getBlockedUsers(), (Iterable) list2), list2.size() == 10, null, 35, null);
                }
            }

            public static final class b<T, R> implements Function<Throwable, BlacklistInteractor.State> {
                public final /* synthetic */ LoadNextPageMutator a;
                public final /* synthetic */ BlacklistInteractor.State b;

                public b(LoadNextPageMutator loadNextPageMutator, BlacklistInteractor.State state) {
                    this.a = loadNextPageMutator;
                    this.b = state;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // io.reactivex.functions.Function
                public BlacklistInteractor.State apply(Throwable th) {
                    Throwable th2 = th;
                    Intrinsics.checkNotNullParameter(th2, "error");
                    BlacklistInteractorImpl.this.getErrorStream().accept(ThrowablesKt.toAvitoException(th2));
                    return BlacklistInteractor.State.copy$default(this.b, null, null, new BlacklistInteractor.State.Loading.Error(ThrowablesKt.toAvitoException(th2)), null, false, null, 59, null);
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public LoadNextPageMutator() {
                super(NextPageRequestComposite.this.getName() + ".SetInProgressMutator", NextPageRequestComposite.this.getParams());
            }

            @NotNull
            public Single<BlacklistInteractor.State> invoke(@NotNull BlacklistInteractor.State state) {
                Intrinsics.checkNotNullParameter(state, "oldState");
                if (!(state.getNextPageLoadingState() instanceof BlacklistInteractor.State.Loading.InProgress) || ((BlacklistInteractor.State.Loading.InProgress) state.getNextPageLoadingState()).getId() != NextPageRequestComposite.this.e) {
                    String tag = BlacklistInteractorImpl.this.getTAG();
                    StringBuilder sb = new StringBuilder();
                    StringBuilder I = a2.b.a.a.a.I('[');
                    Thread currentThread = Thread.currentThread();
                    Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                    I.append(currentThread.getName());
                    I.append(']');
                    sb.append(I.toString());
                    sb.append(' ');
                    sb.append(this);
                    sb.append(": oldState.nextPageLoadingState = ");
                    sb.append(state.getNextPageLoadingState());
                    sb.append(" => do nothing");
                    Logs.verbose$default(tag, sb.toString(), null, 4, null);
                    return Singles.toSingle(state);
                }
                Single<R> onErrorReturn = BlacklistInteractorImpl.this.t.getBlacklist(state.getBlockedUsers().size(), 10).map(new a(state)).onErrorReturn(new b(this, state));
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "client.getBlacklist(oldS…                        }");
                return onErrorReturn;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$NextPageRequestComposite$SetInProgressMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;)Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "<init>", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$NextPageRequestComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class SetInProgressMutator extends Mutator<BlacklistInteractor.State> {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            public SetInProgressMutator() {
                super(NextPageRequestComposite.this.getName() + ".SetInProgressMutator", NextPageRequestComposite.this.getParams());
            }

            @NotNull
            public BlacklistInteractor.State invoke(@NotNull BlacklistInteractor.State state) {
                Intrinsics.checkNotNullParameter(state, "oldState");
                return state.getHasMoreItems() && (state.getInitialLoadingState() instanceof BlacklistInteractor.State.Loading.Finished) && !(state.getRefreshState() instanceof BlacklistInteractor.State.Loading.InProgress) && !(state.getNextPageLoadingState() instanceof BlacklistInteractor.State.Loading.InProgress) ? BlacklistInteractor.State.copy$default(state, null, null, new BlacklistInteractor.State.Loading.InProgress(NextPageRequestComposite.this.e), null, false, null, 59, null) : state;
            }
        }

        public static final class a extends Lambda implements Function0<List<? extends Reducible<BlacklistInteractor.State>>> {
            public final /* synthetic */ NextPageRequestComposite a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(NextPageRequestComposite nextPageRequestComposite) {
                super(0);
                this.a = nextPageRequestComposite;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends Reducible<BlacklistInteractor.State>> invoke() {
                return CollectionsKt__CollectionsKt.listOf((Object[]) new Reducible[]{new SetInProgressMutator(), new LoadNextPageMutator()});
            }
        }

        public NextPageRequestComposite(long j) {
            super("NextPageRequest", a2.b.a.a.a.T2("id = ", j), null, 4, null);
            this.e = j;
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible
        @NotNull
        public Function0<List<Reducible<BlacklistInteractor.State>>> getBlock() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$OnReconnectAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;)V", "", "d", "Z", "notificationQueueWasRestored", "<init>", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class OnReconnectAction extends Action<BlacklistInteractor.State> {
        public final boolean d;

        public OnReconnectAction(boolean z) {
            super("OnReconnectAction", "notificationQueueWasRestored = " + z);
            this.d = z;
        }

        public void invoke(@NotNull BlacklistInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (!(state.getInitialLoadingState() instanceof BlacklistInteractor.State.Loading.Finished)) {
                BlacklistInteractorImpl.this.initialDataRequest();
            } else if (!(state.getRefreshState() instanceof BlacklistInteractor.State.Loading.Finished) || !this.d) {
                BlacklistInteractorImpl.this.refresh();
            } else if (state.getNextPageLoadingState() instanceof BlacklistInteractor.State.Loading.Error) {
                BlacklistInteractorImpl.this.requestNextPage();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$OnRemovedFromBlacklistMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;)Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "", "d", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", ChannelContext.Item.USER_ID, "<init>", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class OnRemovedFromBlacklistMutator extends Mutator<BlacklistInteractor.State> {
        @NotNull
        public final String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnRemovedFromBlacklistMutator(@NotNull BlacklistInteractorImpl blacklistInteractorImpl, String str) {
            super("OnRemovedFromBlacklistMutator", "userId = " + str);
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            this.d = str;
        }

        @NotNull
        public final String getUserId() {
            return this.d;
        }

        @NotNull
        public BlacklistInteractor.State invoke(@NotNull BlacklistInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            Iterator<BlockedUser> it = state.getBlockedUsers().iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().getUser().getId(), this.d)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return state;
            }
            List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) state.getBlockedUsers());
            mutableList.remove(i);
            Unit unit = Unit.INSTANCE;
            return BlacklistInteractor.State.copy$default(state, null, null, null, mutableList, false, null, 55, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$PerformRefreshMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;)Lio/reactivex/Single;", "", "parentName", "parentParams", "<init>", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class PerformRefreshMutator extends MutatorSingle<BlacklistInteractor.State> {

        public static final class a<T, R> implements Function<List<? extends BlockedUser>, BlacklistInteractor.State> {
            public final /* synthetic */ BlacklistInteractor.State a;
            public final /* synthetic */ int b;

            public a(BlacklistInteractor.State state, int i) {
                this.a = state;
                this.b = i;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.blacklist.mvi.BlacklistInteractor$State */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.functions.Function
            public BlacklistInteractor.State apply(List<? extends BlockedUser> list) {
                List<? extends BlockedUser> list2 = list;
                Intrinsics.checkNotNullParameter(list2, "blockedUsers");
                BlacklistInteractor.State state = this.a;
                BlacklistInteractor.State.Loading.Finished finished = BlacklistInteractor.State.Loading.Finished.INSTANCE;
                return state.copy(finished, finished, finished, list2, list2.size() == this.b, r.emptyMap());
            }
        }

        public static final class b<T, R> implements Function<Throwable, BlacklistInteractor.State> {
            public final /* synthetic */ PerformRefreshMutator a;
            public final /* synthetic */ BlacklistInteractor.State b;

            public b(PerformRefreshMutator performRefreshMutator, BlacklistInteractor.State state) {
                this.a = performRefreshMutator;
                this.b = state;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public BlacklistInteractor.State apply(Throwable th) {
                Throwable th2 = th;
                Intrinsics.checkNotNullParameter(th2, "error");
                if (this.b.getInitialLoadingState() instanceof BlacklistInteractor.State.Loading.InProgress) {
                    BlacklistInteractorImpl.this.q.clear();
                    return BlacklistInteractor.State.copy$default(this.b, new BlacklistInteractor.State.Loading.Error(ThrowablesKt.toAvitoException(th2)), null, null, null, false, null, 62, null);
                }
                BlacklistInteractorImpl.this.getErrorStream().accept(ThrowablesKt.toAvitoException(th2));
                return BlacklistInteractor.State.copy$default(this.b, null, new BlacklistInteractor.State.Loading.Error(ThrowablesKt.toAvitoException(th2)), null, null, false, null, 61, null);
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PerformRefreshMutator(@org.jetbrains.annotations.Nullable java.lang.String r4, @org.jetbrains.annotations.Nullable java.lang.String r5) {
            /*
                r2 = this;
                com.avito.android.messenger.blacklist.mvi.BlacklistInteractorImpl.this = r3
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r0 = ""
                if (r4 == 0) goto L_0x0014
                java.lang.String r1 = "."
                java.lang.String r4 = a2.b.a.a.a.c3(r4, r1)
                if (r4 == 0) goto L_0x0014
                goto L_0x0015
            L_0x0014:
                r4 = r0
            L_0x0015:
                java.lang.String r1 = "PerformRefreshMutator"
                java.lang.String r3 = a2.b.a.a.a.t(r3, r4, r1)
                if (r5 == 0) goto L_0x0026
                boolean r4 = t6.y.m.isBlank(r5)
                if (r4 == 0) goto L_0x0024
                goto L_0x0026
            L_0x0024:
                r4 = 0
                goto L_0x0027
            L_0x0026:
                r4 = 1
            L_0x0027:
                if (r4 != 0) goto L_0x002f
                java.lang.String r4 = "parentParams = "
                java.lang.String r0 = a2.b.a.a.a.c3(r4, r5)
            L_0x002f:
                r2.<init>(r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.blacklist.mvi.BlacklistInteractorImpl.PerformRefreshMutator.<init>(com.avito.android.messenger.blacklist.mvi.BlacklistInteractorImpl, java.lang.String, java.lang.String):void");
        }

        @NotNull
        public Single<BlacklistInteractor.State> invoke(@NotNull BlacklistInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            BlacklistInteractorImpl blacklistInteractorImpl = BlacklistInteractorImpl.this;
            if (blacklistInteractorImpl.q.size() == 0) {
                Scheduler io2 = blacklistInteractorImpl.getSchedulers().io();
                CompositeDisposable compositeDisposable = blacklistInteractorImpl.q;
                SharedScheduler sharedScheduler = new SharedScheduler(io2);
                compositeDisposable.add(Disposables.fromAction(new BlacklistInteractorImpl$inlined$sam$i$io_reactivex_functions_Action$0(new BlacklistInteractorImpl$PerformRefreshMutator$setupAfterInitSubscriptions$$inlined$toShared$1(sharedScheduler))));
                Disposable subscribe = blacklistInteractorImpl.t.observeChatEvents(BlacklistInfo.class).debounce(500, TimeUnit.MILLISECONDS, blacklistInteractorImpl.getSchedulers().computation()).observeOn(sharedScheduler).subscribeOn(sharedScheduler).subscribe(new BlacklistInteractorImpl$subscribeToAddedToBlacklistEvents$1(blacklistInteractorImpl), new BlacklistInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new BlacklistInteractorImpl$logError$1(blacklistInteractorImpl, "BlacklistInfo")));
                Intrinsics.checkNotNullExpressionValue(subscribe, "client.observeChatEvents…klistInfo\")\n            )");
                DisposableKt.addTo(subscribe, blacklistInteractorImpl.q);
                Disposable subscribe2 = blacklistInteractorImpl.t.observeChatEvents(BlacklistRemoveEvent.class).observeOn(sharedScheduler).subscribeOn(sharedScheduler).subscribe(new BlacklistInteractorImpl$subscribeToRemovedFromBlacklistEvents$1(blacklistInteractorImpl), new BlacklistInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new BlacklistInteractorImpl$logError$1(blacklistInteractorImpl, "BlacklistRemoveEvent")));
                Intrinsics.checkNotNullExpressionValue(subscribe2, "client.observeChatEvents…moveEvent\")\n            )");
                DisposableKt.addTo(subscribe2, blacklistInteractorImpl.q);
                DisposableKt.addTo(blacklistInteractorImpl.q, blacklistInteractorImpl.r);
            }
            int coerceAtLeast = e.coerceAtLeast(state.getBlockedUsers().size(), 10);
            Single<R> onErrorReturn = BlacklistInteractorImpl.this.t.getBlacklist(0, Integer.valueOf(coerceAtLeast)).map(new a(state, coerceAtLeast)).onErrorReturn(new b(this, state));
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "client.getBlacklist(0, r…      }\n                }");
            return onErrorReturn;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PerformRefreshMutator(BlacklistInteractorImpl blacklistInteractorImpl, String str, String str2, int i, j jVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R.\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\b0\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$RefreshComposite;", "Lcom/avito/android/messenger/channels/mvi/common/v4/CompositeReducible;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "", "e", "J", "id", "Lkotlin/Function0;", "", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "d", "Lkotlin/jvm/functions/Function0;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "block", "<init>", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl;J)V", "SetInProgressMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class RefreshComposite extends CompositeReducible<BlacklistInteractor.State> {
        @NotNull
        public final Function0<List<Reducible<BlacklistInteractor.State>>> d = new a(this);
        public final long e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$RefreshComposite$SetInProgressMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "<init>", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$RefreshComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class SetInProgressMutator extends Mutator<BlacklistInteractor.State> {

            public static final class a extends Lambda implements Function1<BlacklistInteractor.State, BlacklistInteractor.State> {
                public final /* synthetic */ RefreshComposite a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(RefreshComposite refreshComposite) {
                    super(1);
                    this.a = refreshComposite;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public BlacklistInteractor.State invoke(BlacklistInteractor.State state) {
                    BlacklistInteractor.State state2 = state;
                    Intrinsics.checkNotNullParameter(state2, "oldState");
                    return BlacklistInteractor.State.copy$default(state2, null, new BlacklistInteractor.State.Loading.InProgress(this.a.e), BlacklistInteractor.State.Loading.Finished.INSTANCE, null, false, null, 57, null);
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public SetInProgressMutator(RefreshComposite refreshComposite) {
                super(refreshComposite.getName() + ".SetInProgressMutator", refreshComposite.getParams(), new a(refreshComposite));
            }
        }

        public static final class a extends Lambda implements Function0<List<? extends Reducible<BlacklistInteractor.State>>> {
            public final /* synthetic */ RefreshComposite a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(RefreshComposite refreshComposite) {
                super(0);
                this.a = refreshComposite;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends Reducible<BlacklistInteractor.State>> invoke() {
                RefreshComposite refreshComposite = this.a;
                return CollectionsKt__CollectionsKt.listOf((Object[]) new Reducible[]{new SetInProgressMutator(this.a), new PerformRefreshMutator(refreshComposite.getName(), this.a.getParams())});
            }
        }

        public RefreshComposite(long j) {
            super("RefreshComposite", a2.b.a.a.a.T2("id = ", j), null, 4, null);
            this.e = j;
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible
        @NotNull
        public Function0<List<Reducible<BlacklistInteractor.State>>> getBlock() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R.\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\b0\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$UnblockUserComposite;", "Lcom/avito/android/messenger/channels/mvi/common/v4/CompositeReducible;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "", "f", "J", "id", "Lkotlin/Function0;", "", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "d", "Lkotlin/jvm/functions/Function0;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "block", "", "e", "Ljava/lang/String;", ChannelContext.Item.USER_ID, "<init>", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl;Ljava/lang/String;J)V", "SetInProgressMutator", "UnblockUserMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class UnblockUserComposite extends CompositeReducible<BlacklistInteractor.State> {
        @NotNull
        public final Function0<List<Reducible<BlacklistInteractor.State>>> d = new a(this);
        public final String e;
        public final long f;
        public final /* synthetic */ BlacklistInteractorImpl g;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$UnblockUserComposite$SetInProgressMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;)Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "", "d", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", ChannelContext.Item.USER_ID, "<init>", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$UnblockUserComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class SetInProgressMutator extends Mutator<BlacklistInteractor.State> {
            @NotNull
            public final String d;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public SetInProgressMutator() {
                super(UnblockUserComposite.this.getName() + ".SetInProgressMutator", UnblockUserComposite.this.getParams());
                this.d = UnblockUserComposite.this.e;
            }

            @NotNull
            public final String getUserId() {
                return this.d;
            }

            @NotNull
            public BlacklistInteractor.State invoke(@NotNull BlacklistInteractor.State state) {
                Intrinsics.checkNotNullParameter(state, "oldState");
                return !state.getUnblockingUsers().keySet().contains(this.d) ? BlacklistInteractor.State.copy$default(state, null, null, null, null, false, r.plus(state.getUnblockingUsers(), TuplesKt.to(this.d, Long.valueOf(UnblockUserComposite.this.f))), 31, null) : state;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$UnblockUserComposite$UnblockUserMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;)Lio/reactivex/Single;", "<init>", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl$UnblockUserComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class UnblockUserMutator extends MutatorSingle<BlacklistInteractor.State> {

            public static final class a<T, R> implements Function<Boolean, BlacklistInteractor.State> {
                public final /* synthetic */ UnblockUserMutator a;
                public final /* synthetic */ BlacklistInteractor.State b;

                public a(UnblockUserMutator unblockUserMutator, BlacklistInteractor.State state) {
                    this.a = unblockUserMutator;
                    this.b = state;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // io.reactivex.functions.Function
                public BlacklistInteractor.State apply(Boolean bool) {
                    Intrinsics.checkNotNullParameter(bool, "it");
                    List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.b.getBlockedUsers());
                    h.removeAll(mutableList, (Function1) new a2.a.a.o1.a.a.a(this));
                    BlacklistInteractor.State state = this.b;
                    return BlacklistInteractor.State.copy$default(state, null, null, null, mutableList, false, r.minus(state.getUnblockingUsers(), UnblockUserComposite.this.e), 23, null);
                }
            }

            public static final class b<T, R> implements Function<Throwable, BlacklistInteractor.State> {
                public final /* synthetic */ UnblockUserMutator a;
                public final /* synthetic */ BlacklistInteractor.State b;

                public b(UnblockUserMutator unblockUserMutator, BlacklistInteractor.State state) {
                    this.a = unblockUserMutator;
                    this.b = state;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // io.reactivex.functions.Function
                public BlacklistInteractor.State apply(Throwable th) {
                    Throwable th2 = th;
                    Intrinsics.checkNotNullParameter(th2, "error");
                    UnblockUserComposite.this.g.getErrorStream().accept(ThrowablesKt.toAvitoException(th2));
                    BlacklistInteractor.State state = this.b;
                    return BlacklistInteractor.State.copy$default(state, null, null, null, null, false, r.minus(state.getUnblockingUsers(), UnblockUserComposite.this.e), 31, null);
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public UnblockUserMutator() {
                super(UnblockUserComposite.this.getName() + ".UnblockUserMutator", UnblockUserComposite.this.getParams());
            }

            @NotNull
            public Single<BlacklistInteractor.State> invoke(@NotNull BlacklistInteractor.State state) {
                Intrinsics.checkNotNullParameter(state, "oldState");
                Long l = state.getUnblockingUsers().get(UnblockUserComposite.this.e);
                long j = UnblockUserComposite.this.f;
                if (l == null || l.longValue() != j) {
                    return Singles.toSingle(state);
                }
                Single<R> onErrorReturn = UnblockUserComposite.this.g.t.removeFromBlacklist(UnblockUserComposite.this.e).map(new a(this, state)).onErrorReturn(new b(this, state));
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "client.removeFromBlackli…                        }");
                return onErrorReturn;
            }
        }

        public static final class a extends Lambda implements Function0<List<? extends Reducible<BlacklistInteractor.State>>> {
            public final /* synthetic */ UnblockUserComposite a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(UnblockUserComposite unblockUserComposite) {
                super(0);
                this.a = unblockUserComposite;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends Reducible<BlacklistInteractor.State>> invoke() {
                return CollectionsKt__CollectionsKt.listOf((Object[]) new Reducible[]{new SetInProgressMutator(), new UnblockUserMutator()});
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UnblockUserComposite(@NotNull BlacklistInteractorImpl blacklistInteractorImpl, String str, long j) {
            super("UnblockUserComposite", "userId = " + str + ", id = " + j, null, 4, null);
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            this.g = blacklistInteractorImpl;
            this.e = str;
            this.f = j;
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible
        @NotNull
        public Function0<List<Reducible<BlacklistInteractor.State>>> getBlock() {
            return this.d;
        }
    }

    public static final class a implements ShouldCancelChecker<BlacklistInteractor.State> {
        @NotNull
        public static final a a = new a();

        @Override // com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker
        public boolean aShouldCancelB(@NotNull Reducible<BlacklistInteractor.State> reducible, @NotNull Reducible<BlacklistInteractor.State> reducible2) {
            Intrinsics.checkNotNullParameter(reducible, AuthSource.SEND_ABUSE);
            Intrinsics.checkNotNullParameter(reducible2, AuthSource.BOOKING_ORDER);
            if (reducible instanceof InitialDataRequestComposite.SetInProgressMutator) {
                return true;
            }
            if (reducible instanceof RefreshComposite.SetInProgressMutator) {
                if ((reducible2 instanceof RefreshComposite.SetInProgressMutator) || (reducible2 instanceof PerformRefreshMutator) || (reducible2 instanceof NextPageRequestComposite.SetInProgressMutator) || (reducible2 instanceof NextPageRequestComposite.LoadNextPageMutator) || (reducible2 instanceof OnRemovedFromBlacklistMutator)) {
                    return true;
                }
            } else if (reducible instanceof NextPageRequestComposite.SetInProgressMutator) {
                if (reducible2 instanceof NextPageRequestComposite.SetInProgressMutator) {
                    return true;
                }
            } else if (reducible instanceof UnblockUserComposite.SetInProgressMutator) {
                if (reducible2 instanceof UnblockUserComposite.SetInProgressMutator) {
                    return Intrinsics.areEqual(((UnblockUserComposite.SetInProgressMutator) reducible).getUserId(), ((UnblockUserComposite.SetInProgressMutator) reducible2).getUserId());
                }
            } else if (reducible instanceof OnRemovedFromBlacklistMutator) {
                if (reducible2 instanceof OnRemovedFromBlacklistMutator) {
                    return Intrinsics.areEqual(((OnRemovedFromBlacklistMutator) reducible).getUserId(), ((OnRemovedFromBlacklistMutator) reducible2).getUserId());
                }
                if (reducible2 instanceof UnblockUserComposite.SetInProgressMutator) {
                    return Intrinsics.areEqual(((OnRemovedFromBlacklistMutator) reducible).getUserId(), ((UnblockUserComposite.SetInProgressMutator) reducible2).getUserId());
                }
            }
            return false;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BlacklistInteractorImpl(@NotNull SchedulersFactory schedulersFactory, @NotNull Features features, @NotNull AccountStateProvider accountStateProvider, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull ReducerQueue<BlacklistInteractor.State> reducerQueue) {
        super("BlacklistInteractor", BlacklistInteractor.State.Companion.getDEFAULT(), schedulersFactory, a.a, reducerQueue, null, null, null, 224, null);
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(reducerQueue, "reducerQueue");
        this.s = accountStateProvider;
        this.t = messengerClient;
        this.p = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
        this.q = new CompositeDisposable();
        this.r = new CompositeDisposable();
        Scheduler io2 = getSchedulers().io();
        CompositeDisposable compositeDisposable = this.r;
        SharedScheduler sharedScheduler = new SharedScheduler(io2);
        compositeDisposable.add(Disposables.fromAction(new BlacklistInteractorImpl$inlined$sam$i$io_reactivex_functions_Action$0(new Function0<Unit>(sharedScheduler) { // from class: com.avito.android.messenger.blacklist.mvi.BlacklistInteractorImpl$setupInitSubscriptions$$inlined$toShared$2
            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                ((SharedScheduler) this.receiver).shutdown();
            }
        })));
        Disposable subscribe = this.t.allReconnects().subscribeOn(sharedScheduler).observeOn(sharedScheduler).subscribe(new BlacklistInteractorImpl$subscribeToReconnects$1(this), new BlacklistInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new BlacklistInteractorImpl$logError$1(this, "client.allReconnects()")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "client.allReconnects()\n …onnects()\")\n            )");
        DisposableKt.addTo(subscribe, this.r);
        Observable map = InteropKt.toV2(this.s.userId()).observeOn(sharedScheduler).map(BlacklistInteractorImpl$subscribeToUserIdUpdates$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "accountStateProvider.use….toOption()\n            }");
        Disposable subscribe2 = OptionKt.filterDefined(map).distinctUntilChanged().subscribe(new BlacklistInteractorImpl$subscribeToUserIdUpdates$2(this), new BlacklistInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new BlacklistInteractorImpl$logError$1(this, "accountStateProvider.userId()")));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "accountStateProvider.use….userId()\")\n            )");
        DisposableKt.addTo(subscribe2, this.r);
    }

    public static final Function1 access$logError(BlacklistInteractorImpl blacklistInteractorImpl, String str) {
        Objects.requireNonNull(blacklistInteractorImpl);
        return new BlacklistInteractorImpl$logError$1(blacklistInteractorImpl, str);
    }

    public static final void access$setupAfterInitSubscriptions(BlacklistInteractorImpl blacklistInteractorImpl) {
        Objects.requireNonNull(blacklistInteractorImpl);
        if (blacklistInteractorImpl.q.size() == 0) {
            Scheduler io2 = blacklistInteractorImpl.getSchedulers().io();
            CompositeDisposable compositeDisposable = blacklistInteractorImpl.q;
            SharedScheduler sharedScheduler = new SharedScheduler(io2);
            compositeDisposable.add(Disposables.fromAction(new BlacklistInteractorImpl$inlined$sam$i$io_reactivex_functions_Action$0(new Function0<Unit>(sharedScheduler) { // from class: com.avito.android.messenger.blacklist.mvi.BlacklistInteractorImpl$setupAfterInitSubscriptions$$inlined$toShared$1
                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    ((SharedScheduler) this.receiver).shutdown();
                }
            })));
            Disposable subscribe = blacklistInteractorImpl.t.observeChatEvents(BlacklistInfo.class).debounce(500, TimeUnit.MILLISECONDS, blacklistInteractorImpl.getSchedulers().computation()).observeOn(sharedScheduler).subscribeOn(sharedScheduler).subscribe(new BlacklistInteractorImpl$subscribeToAddedToBlacklistEvents$1(blacklistInteractorImpl), new BlacklistInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new BlacklistInteractorImpl$logError$1(blacklistInteractorImpl, "BlacklistInfo")));
            Intrinsics.checkNotNullExpressionValue(subscribe, "client.observeChatEvents…klistInfo\")\n            )");
            DisposableKt.addTo(subscribe, blacklistInteractorImpl.q);
            Disposable subscribe2 = blacklistInteractorImpl.t.observeChatEvents(BlacklistRemoveEvent.class).observeOn(sharedScheduler).subscribeOn(sharedScheduler).subscribe(new BlacklistInteractorImpl$subscribeToRemovedFromBlacklistEvents$1(blacklistInteractorImpl), new BlacklistInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new BlacklistInteractorImpl$logError$1(blacklistInteractorImpl, "BlacklistRemoveEvent")));
            Intrinsics.checkNotNullExpressionValue(subscribe2, "client.observeChatEvents…moveEvent\")\n            )");
            DisposableKt.addTo(subscribe2, blacklistInteractorImpl.q);
            DisposableKt.addTo(blacklistInteractorImpl.q, blacklistInteractorImpl.r);
        }
    }

    public static final void access$subscribeToAddedToBlacklistEvents(BlacklistInteractorImpl blacklistInteractorImpl, Scheduler scheduler) {
        Objects.requireNonNull(blacklistInteractorImpl);
        Disposable subscribe = blacklistInteractorImpl.t.observeChatEvents(BlacklistInfo.class).debounce(500, TimeUnit.MILLISECONDS, blacklistInteractorImpl.getSchedulers().computation()).observeOn(scheduler).subscribeOn(scheduler).subscribe(new BlacklistInteractorImpl$subscribeToAddedToBlacklistEvents$1(blacklistInteractorImpl), new BlacklistInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new BlacklistInteractorImpl$logError$1(blacklistInteractorImpl, "BlacklistInfo")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "client.observeChatEvents…klistInfo\")\n            )");
        DisposableKt.addTo(subscribe, blacklistInteractorImpl.q);
    }

    public static final void access$subscribeToReconnects(BlacklistInteractorImpl blacklistInteractorImpl, Scheduler scheduler) {
        Objects.requireNonNull(blacklistInteractorImpl);
        Disposable subscribe = blacklistInteractorImpl.t.allReconnects().subscribeOn(scheduler).observeOn(scheduler).subscribe(new BlacklistInteractorImpl$subscribeToReconnects$1(blacklistInteractorImpl), new BlacklistInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new BlacklistInteractorImpl$logError$1(blacklistInteractorImpl, "client.allReconnects()")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "client.allReconnects()\n …onnects()\")\n            )");
        DisposableKt.addTo(subscribe, blacklistInteractorImpl.r);
    }

    public static final void access$subscribeToRemovedFromBlacklistEvents(BlacklistInteractorImpl blacklistInteractorImpl, Scheduler scheduler) {
        Objects.requireNonNull(blacklistInteractorImpl);
        Disposable subscribe = blacklistInteractorImpl.t.observeChatEvents(BlacklistRemoveEvent.class).observeOn(scheduler).subscribeOn(scheduler).subscribe(new BlacklistInteractorImpl$subscribeToRemovedFromBlacklistEvents$1(blacklistInteractorImpl), new BlacklistInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new BlacklistInteractorImpl$logError$1(blacklistInteractorImpl, "BlacklistRemoveEvent")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "client.observeChatEvents…moveEvent\")\n            )");
        DisposableKt.addTo(subscribe, blacklistInteractorImpl.q);
    }

    public static final void access$subscribeToUserIdUpdates(BlacklistInteractorImpl blacklistInteractorImpl, Scheduler scheduler) {
        Objects.requireNonNull(blacklistInteractorImpl);
        Observable map = InteropKt.toV2(blacklistInteractorImpl.s.userId()).observeOn(scheduler).map(BlacklistInteractorImpl$subscribeToUserIdUpdates$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "accountStateProvider.use….toOption()\n            }");
        Disposable subscribe = OptionKt.filterDefined(map).distinctUntilChanged().subscribe(new BlacklistInteractorImpl$subscribeToUserIdUpdates$2(blacklistInteractorImpl), new BlacklistInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new BlacklistInteractorImpl$logError$1(blacklistInteractorImpl, "accountStateProvider.userId()")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountStateProvider.use….userId()\")\n            )");
        DisposableKt.addTo(subscribe, blacklistInteractorImpl.r);
    }

    @Override // com.avito.android.messenger.blacklist.mvi.BlacklistInteractor
    public void initialDataRequest() {
        getReducerQueue().plusAssign(new InitialDataRequestComposite(generateReducibleId("InitialDataRequestComposite")));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.r.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.blacklist.mvi.BlacklistInteractor
    public void refresh() {
        getReducerQueue().plusAssign(new RefreshComposite(generateReducibleId("RefreshComposite")));
    }

    @Override // com.avito.android.messenger.blacklist.mvi.BlacklistInteractor
    public void requestNextPage() {
        getReducerQueue().plusAssign(new NextPageRequestComposite(generateReducibleId("NextPageRequestComposite")));
    }

    @Override // com.avito.android.messenger.blacklist.mvi.BlacklistInteractor
    public void unblockUser(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        getReducerQueue().plusAssign(new UnblockUserComposite(this, str, generateReducibleId("UnblockUserComposite")));
    }

    @Override // com.avito.android.messenger.blacklist.mvi.BlacklistInteractor
    @NotNull
    public Relay<Throwable> getErrorStream() {
        return this.p;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public BlacklistInteractorImpl(@NotNull SchedulersFactory schedulersFactory, @NotNull Features features, @NotNull AccountStateProvider accountStateProvider, @NotNull MessengerClient<AvitoMessengerApi> messengerClient) {
        this(schedulersFactory, features, accountStateProvider, messengerClient, new SimpleReducerQueue(schedulersFactory.io(), null, 2, null));
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
    }
}
