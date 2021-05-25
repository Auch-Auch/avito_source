package com.avito.android.messenger.service.user_last_activity;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.channels.mvi.common.v4.ActionSingle;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.MutatorSingle;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueueWithTransformByKey;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker;
import com.avito.android.messenger.channels.mvi.data.UserRepo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.rx.arrow.OptionKt;
import com.avito.android.util.rx3.InteropKt;
import com.vk.sdk.api.VKApiConst;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.UserIdAndLastActionTime;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.UserLastActivity;
import ru.avito.messenger.api.entity.event.ChatTypingEvent;
import t6.n.e;
import t6.n.r;
import t6.n.y;
import t6.n.z;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0007/012345BK\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0004\b,\u0010-B?\b\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b,\u0010.J-\u0010\u000b\u001a\u00020\n2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0010\u0010\t\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\b0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u00066"}, d2 = {"Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgentImpl;", "Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgent;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgentImpl$State;", "", "Lcom/avito/android/messenger/service/user_last_activity/RequestId;", "requestId", "", "Lcom/avito/android/messenger/service/user_last_activity/UserId;", "userIds", "", "requestUsers", "(Ljava/lang/String;Ljava/util/Set;)V", "onCleared", "()V", "Lcom/avito/android/account/AccountStateProvider;", "r", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lio/reactivex/disposables/CompositeDisposable;", VKApiConst.Q, "Lio/reactivex/disposables/CompositeDisposable;", "backendNotificationSubscriptions", "p", "pollingDisposable", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "s", "Lru/avito/messenger/MessengerClient;", "client", "Lcom/avito/android/server_time/TimeSource;", "u", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/messenger/channels/mvi/data/UserRepo;", "t", "Lcom/avito/android/messenger/channels/mvi/data/UserRepo;", "userRepo", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "reducerQueue", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/channels/mvi/data/UserRepo;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;)V", "(Lcom/avito/android/account/AccountStateProvider;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/channels/mvi/data/UserRepo;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory;)V", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "PollAction", "RequestMutator", "State", "c", "UpdateOnChatTypingAction", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UserLastActivitySyncAgentImpl extends BaseMviEntityWithReducerQueue<State> implements UserLastActivitySyncAgent {
    public final CompositeDisposable p;
    public final CompositeDisposable q;
    public final AccountStateProvider r;
    public final MessengerClient<AvitoMessengerApi> s;
    public final UserRepo t;
    public final TimeSource u;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgentImpl$PollAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/ActionSingle;", "Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgentImpl$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgentImpl$State;)Lio/reactivex/Single;", "<init>", "(Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgentImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class PollAction extends ActionSingle<State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public PollAction() {
            super(null, null, 3, null);
        }

        @NotNull
        public Single<?> invoke(@NotNull State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            UserLastActivitySyncAgentImpl userLastActivitySyncAgentImpl = UserLastActivitySyncAgentImpl.this;
            Set<String> keySet = state.getRequestIdsByUserId().keySet();
            TimeSource timeSource = userLastActivitySyncAgentImpl.u;
            Single<List<String>> onErrorReturn = userLastActivitySyncAgentImpl.t.getIdsOfUsersWithLastActionTimeOlderOrEqualTo((TimeUnit.SECONDS.convert(timeSource.now(), TimeUnit.MILLISECONDS) - 150) + 15, keySet).observeOn(userLastActivitySyncAgentImpl.getSchedulerForReducibles()).firstOrError().onErrorReturn(new UserLastActivitySyncAgentImpl$getUserIdsToPoll$1(userLastActivitySyncAgentImpl, keySet));
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "userRepo.getIdsOfUsersWi…emptyList()\n            }");
            Completable observeOn = onErrorReturn.flatMap(new UserLastActivitySyncAgentImpl$updateUserLastActionTimes$1(userLastActivitySyncAgentImpl)).flatMapCompletable(new UserLastActivitySyncAgentKt$sam$i$io_reactivex_functions_Function$0(new UserLastActivitySyncAgentImpl$updateUserLastActionTimes$2(userLastActivitySyncAgentImpl.t))).observeOn(userLastActivitySyncAgentImpl.getSchedulerForReducibles());
            Intrinsics.checkNotNullExpressionValue(observeOn, "getUserIdsToPoll(request…n(schedulerForReducibles)");
            Single<?> subscribeOn = observeOn.toSingleDefault(Unit.INSTANCE).subscribeOn(UserLastActivitySyncAgentImpl.this.getSchedulerForReducibles());
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "updateUserLastActionTime…n(schedulerForReducibles)");
            return subscribeOn;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\n\u0010\r\u001a\u00060\u0007j\u0002`\b\u0012\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\u000f0\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\r\u001a\u00060\u0007j\u0002`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\u000f0\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgentImpl$RequestMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgentImpl$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgentImpl$State;)Lio/reactivex/Single;", "", "Lcom/avito/android/messenger/service/user_last_activity/RequestId;", "d", "Ljava/lang/String;", "getRequestId", "()Ljava/lang/String;", "requestId", "", "Lcom/avito/android/messenger/service/user_last_activity/UserId;", "e", "Ljava/util/Set;", "userIds", "<init>", "(Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgentImpl;Ljava/lang/String;Ljava/util/Set;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class RequestMutator extends MutatorSingle<State> {
        @NotNull
        public final String d;
        public final Set<String> e;
        public final /* synthetic */ UserLastActivitySyncAgentImpl f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RequestMutator(@NotNull UserLastActivitySyncAgentImpl userLastActivitySyncAgentImpl, @NotNull String str, Set<String> set) {
            super("RequestMutator", "requestId=" + str + ", userIds=" + set);
            Intrinsics.checkNotNullParameter(str, "requestId");
            Intrinsics.checkNotNullParameter(set, "userIds");
            this.f = userLastActivitySyncAgentImpl;
            this.d = str;
            this.e = set;
        }

        @NotNull
        public final String getRequestId() {
            return this.d;
        }

        @NotNull
        public Single<State> invoke(@NotNull State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            Map mutableMap = r.toMutableMap(state.getUserIdsByRequestId());
            if (!this.e.isEmpty()) {
                mutableMap.put(getRequestId(), this.e);
            } else {
                mutableMap.remove(getRequestId());
            }
            Map mutableMap2 = r.toMutableMap(state.getRequestIdsByUserId());
            Set<String> set = state.getUserIdsByRequestId().get(getRequestId());
            if (set == null) {
                for (String str : this.e) {
                    Set set2 = (Set) mutableMap2.get(str);
                    if (set2 != null) {
                        mutableMap2.put(str, z.plus(set2, getRequestId()));
                    } else {
                        mutableMap2.put(str, y.hashSetOf(getRequestId()));
                    }
                }
            } else {
                for (String str2 : z.minus((Set) set, (Iterable) this.e)) {
                    Set set3 = (Set) mutableMap2.get(str2);
                    if (set3 != null) {
                        if (set3.size() > 1) {
                            mutableMap2.put(str2, z.minus(set3, getRequestId()));
                        } else {
                            mutableMap2.remove(str2);
                        }
                    }
                }
                for (String str3 : z.minus(this.e, (Iterable) set)) {
                    Set set4 = (Set) mutableMap2.get(str3);
                    if (set4 != null) {
                        mutableMap2.put(str3, z.plus(set4, getRequestId()));
                    } else {
                        mutableMap2.put(str3, y.hashSetOf(getRequestId()));
                    }
                }
            }
            if (true ^ mutableMap.isEmpty()) {
                if (state.getRequestIdsByUserId().isEmpty() && this.f.p.size() == 0) {
                    Disposable subscribe = Observable.interval(15, TimeUnit.SECONDS, this.f.getSchedulers().computation()).observeOn(this.f.getSchedulers().io()).subscribe(new UserLastActivitySyncAgentImpl$RequestMutator$startPolling$1(this));
                    Intrinsics.checkNotNullExpressionValue(subscribe, "Observable.interval(POLL…n()\n                    }");
                    DisposableKt.addTo(subscribe, this.f.p);
                }
                UserLastActivitySyncAgentImpl userLastActivitySyncAgentImpl = this.f;
                Set keySet = mutableMap2.keySet();
                Single<List<String>> onErrorReturn = userLastActivitySyncAgentImpl.t.getIdsOfUsersWithLastActionTimeOlderOrEqualTo((TimeUnit.SECONDS.convert(userLastActivitySyncAgentImpl.u.now(), TimeUnit.MILLISECONDS) - 150) + 15, keySet).observeOn(userLastActivitySyncAgentImpl.getSchedulerForReducibles()).firstOrError().onErrorReturn(new UserLastActivitySyncAgentImpl$getUserIdsToPoll$1(userLastActivitySyncAgentImpl, keySet));
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "userRepo.getIdsOfUsersWi…emptyList()\n            }");
                Completable observeOn = onErrorReturn.flatMap(new UserLastActivitySyncAgentImpl$updateUserLastActionTimes$1(userLastActivitySyncAgentImpl)).flatMapCompletable(new UserLastActivitySyncAgentKt$sam$i$io_reactivex_functions_Function$0(new UserLastActivitySyncAgentImpl$updateUserLastActionTimes$2(userLastActivitySyncAgentImpl.t))).observeOn(userLastActivitySyncAgentImpl.getSchedulerForReducibles());
                Intrinsics.checkNotNullExpressionValue(observeOn, "getUserIdsToPoll(request…n(schedulerForReducibles)");
                Single<State> subscribeOn = observeOn.toSingleDefault(new State(mutableMap2, mutableMap)).subscribeOn(this.f.getSchedulerForReducibles());
                Intrinsics.checkNotNullExpressionValue(subscribeOn, "updateUserLastActionTime…n(schedulerForReducibles)");
                return subscribeOn;
            }
            this.f.p.clear();
            return Singles.toSingle(UserLastActivitySyncAgentImpl.access$getDefaultState$p(this.f));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001BS\u0012$\u0010\f\u001a \u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00060\u00050\u0002j\u0002`\u0007\u0012$\u0010\r\u001a \u0012\b\u0012\u00060\u0003j\u0002`\u0006\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00050\u0002j\u0002`\n¢\u0006\u0004\b\u001e\u0010\u001fJ.\u0010\b\u001a \u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00060\u00050\u0002j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ.\u0010\u000b\u001a \u0012\b\u0012\u00060\u0003j\u0002`\u0006\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00050\u0002j\u0002`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ`\u0010\u000e\u001a\u00020\u00002&\b\u0002\u0010\f\u001a \u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00060\u00050\u0002j\u0002`\u00072&\b\u0002\u0010\r\u001a \u0012\b\u0012\u00060\u0003j\u0002`\u0006\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00050\u0002j\u0002`\nHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R7\u0010\r\u001a \u0012\b\u0012\u00060\u0003j\u0002`\u0006\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00050\u0002j\u0002`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\tR7\u0010\f\u001a \u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00060\u00050\u0002j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\t¨\u0006 "}, d2 = {"Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgentImpl$State;", "", "", "", "Lcom/avito/android/messenger/service/user_last_activity/UserId;", "", "Lcom/avito/android/messenger/service/user_last_activity/RequestId;", "Lcom/avito/android/messenger/service/user_last_activity/RequestIdsByUserId;", "component1", "()Ljava/util/Map;", "Lcom/avito/android/messenger/service/user_last_activity/UserIdsByRequestId;", "component2", "requestIdsByUserId", "userIdsByRequestId", "copy", "(Ljava/util/Map;Ljava/util/Map;)Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgentImpl$State;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getUserIdsByRequestId", AuthSource.SEND_ABUSE, "getRequestIdsByUserId", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public final Map<String, Set<String>> a;
        @NotNull
        public final Map<String, Set<String>> b;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<java.lang.String, ? extends java.util.Set<java.lang.String>> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<java.lang.String, ? extends java.util.Set<java.lang.String>> */
        /* JADX WARN: Multi-variable type inference failed */
        public State(@NotNull Map<String, ? extends Set<String>> map, @NotNull Map<String, ? extends Set<String>> map2) {
            Intrinsics.checkNotNullParameter(map, "requestIdsByUserId");
            Intrinsics.checkNotNullParameter(map2, "userIdsByRequestId");
            this.a = map;
            this.b = map2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgentImpl$State */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                map = state.a;
            }
            if ((i & 2) != 0) {
                map2 = state.b;
            }
            return state.copy(map, map2);
        }

        @NotNull
        public final Map<String, Set<String>> component1() {
            return this.a;
        }

        @NotNull
        public final Map<String, Set<String>> component2() {
            return this.b;
        }

        @NotNull
        public final State copy(@NotNull Map<String, ? extends Set<String>> map, @NotNull Map<String, ? extends Set<String>> map2) {
            Intrinsics.checkNotNullParameter(map, "requestIdsByUserId");
            Intrinsics.checkNotNullParameter(map2, "userIdsByRequestId");
            return new State(map, map2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && Intrinsics.areEqual(this.b, state.b);
        }

        @NotNull
        public final Map<String, Set<String>> getRequestIdsByUserId() {
            return this.a;
        }

        @NotNull
        public final Map<String, Set<String>> getUserIdsByRequestId() {
            return this.b;
        }

        public int hashCode() {
            Map<String, Set<String>> map = this.a;
            int i = 0;
            int hashCode = (map != null ? map.hashCode() : 0) * 31;
            Map<String, Set<String>> map2 = this.b;
            if (map2 != null) {
                i = map2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("State(requestIdsByUserId=");
            L.append(this.a);
            L.append(", userIdsByRequestId=");
            return a2.b.a.a.a.x(L, this.b, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\n\u0010\r\u001a\u00060\u0007j\u0002`\b\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\r\u001a\u00060\u0007j\u0002`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgentImpl$UpdateOnChatTypingAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/ActionSingle;", "Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgentImpl$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgentImpl$State;)Lio/reactivex/Single;", "", "Lcom/avito/android/messenger/service/user_last_activity/UserId;", "d", "Ljava/lang/String;", "getTypingUserId", "()Ljava/lang/String;", "typingUserId", "", "e", "J", "timestampInSeconds", "f", "timeDiffInSeconds", "<init>", "(Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgentImpl;Ljava/lang/String;JJ)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class UpdateOnChatTypingAction extends ActionSingle<State> {
        @NotNull
        public final String d;
        public final long e;
        public final long f;
        public final /* synthetic */ UserLastActivitySyncAgentImpl g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UpdateOnChatTypingAction(@NotNull UserLastActivitySyncAgentImpl userLastActivitySyncAgentImpl, String str, long j, long j2) {
            super("ChatTypingAction", "typingUserId = " + str + ", timestampInSeconds = " + j);
            Intrinsics.checkNotNullParameter(str, "typingUserId");
            this.g = userLastActivitySyncAgentImpl;
            this.d = str;
            this.e = j;
            this.f = j2;
        }

        @NotNull
        public final String getTypingUserId() {
            return this.d;
        }

        @NotNull
        public Single<?> invoke(@NotNull State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            Single<?> singleDefault = this.g.t.updateUserLastActionTime(this.d, Long.valueOf(this.e), Long.valueOf(this.f)).toSingleDefault(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(singleDefault, "userRepo.updateUserLastA…   .toSingleDefault(Unit)");
            return singleDefault;
        }
    }

    public static final class a implements ShouldCancelChecker<State> {
        @NotNull
        public static final a a = new a();

        @Override // com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker
        public boolean aShouldCancelB(@NotNull Reducible<State> reducible, @NotNull Reducible<State> reducible2) {
            Intrinsics.checkNotNullParameter(reducible, AuthSource.SEND_ABUSE);
            Intrinsics.checkNotNullParameter(reducible2, AuthSource.BOOKING_ORDER);
            if (reducible instanceof RequestMutator) {
                if (reducible2 instanceof RequestMutator) {
                    return Intrinsics.areEqual(((RequestMutator) reducible).getRequestId(), ((RequestMutator) reducible2).getRequestId());
                }
                return false;
            } else if (!(reducible instanceof UpdateOnChatTypingAction) || !(reducible2 instanceof UpdateOnChatTypingAction)) {
                return false;
            } else {
                return Intrinsics.areEqual(((UpdateOnChatTypingAction) reducible).getTypingUserId(), ((UpdateOnChatTypingAction) reducible2).getTypingUserId());
            }
        }
    }

    public static final class b implements ReducerQueueWithTransformByKey.KeySelector<State, String> {
        @NotNull
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.android.messenger.channels.mvi.common.v4.Reducible] */
        @Override // com.avito.android.messenger.channels.mvi.common.v4.ReducerQueueWithTransformByKey.KeySelector
        public String getKey(Reducible<State> reducible) {
            Intrinsics.checkNotNullParameter(reducible, "reducible");
            if (reducible instanceof RequestMutator) {
                return ((RequestMutator) reducible).getRequestId();
            }
            return null;
        }
    }

    public static final class c implements ReducerQueueWithTransformByKey.Transformer<State, String> {
        public final Scheduler a;

        public c(@NotNull Scheduler scheduler) {
            Intrinsics.checkNotNullParameter(scheduler, "schedulerForThrottling");
            this.a = scheduler;
        }

        /* Return type fixed from 'io.reactivex.Observable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, io.reactivex.Observable] */
        @Override // com.avito.android.messenger.channels.mvi.common.v4.ReducerQueueWithTransformByKey.Transformer
        public Observable<Reducible<State>> transform(String str, Observable<Reducible<State>> observable) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(observable, "obs");
            if (str2 == null) {
                return observable;
            }
            Observable<Reducible<State>> throttleLatest = observable.throttleLatest(5000, TimeUnit.MILLISECONDS, this.a, true);
            Intrinsics.checkNotNullExpressionValue(throttleLatest, "obs.throttleLatest(\n    …   true\n                )");
            return throttleLatest;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserLastActivitySyncAgentImpl(@NotNull AccountStateProvider accountStateProvider, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull UserRepo userRepo, @NotNull TimeSource timeSource, @NotNull Features features, @NotNull SchedulersFactory schedulersFactory, @NotNull ReducerQueue<State> reducerQueue) {
        super("UserLastActivitySyncAgent", new State(r.emptyMap(), r.emptyMap()), schedulersFactory, a.a, reducerQueue, null, null, null, 224, null);
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(userRepo, "userRepo");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(reducerQueue, "reducerQueue");
        this.r = accountStateProvider;
        this.s = messengerClient;
        this.t = userRepo;
        this.u = timeSource;
        this.p = new CompositeDisposable();
        this.q = new CompositeDisposable();
        this.q.clear();
        Scheduler io2 = getSchedulers().io();
        CompositeDisposable compositeDisposable = this.q;
        SharedScheduler sharedScheduler = new SharedScheduler(io2);
        compositeDisposable.add(Disposables.fromAction(new Action() { // from class: com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgentImpl$inlined$sam$i$io_reactivex_functions_Action$0
            @Override // io.reactivex.functions.Action
            public final /* synthetic */ void run() {
                Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
            }
        }));
        Observable observeOn = InteropKt.toV2(this.r.userId()).map(UserLastActivitySyncAgentImpl$subscribeToBackendNotifications$userIdSharedObservable$1.INSTANCE).subscribeOn(sharedScheduler).observeOn(sharedScheduler);
        Intrinsics.checkNotNullExpressionValue(observeOn, "accountStateProvider.use…ndNotificationsScheduler)");
        ConnectableObservable publish = OptionKt.filterDefined(observeOn).publish();
        Observable observeOn2 = publish.switchMap(new Function<String, ObservableSource<? extends ChatTypingEvent>>() { // from class: com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgentImpl$subscribeToBackendNotifications$1
            public final ObservableSource<? extends ChatTypingEvent> apply(@NotNull final String str) {
                Intrinsics.checkNotNullParameter(str, "currentUserId");
                return UserLastActivitySyncAgentImpl.this.s.observeChatEvents(ChatTypingEvent.class).filter(new Predicate<ChatTypingEvent>() { // from class: com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgentImpl$subscribeToBackendNotifications$1.1
                    public final boolean test(@NotNull ChatTypingEvent chatTypingEvent) {
                        Intrinsics.checkNotNullParameter(chatTypingEvent, "event");
                        return !Intrinsics.areEqual(chatTypingEvent.getFromId(), str);
                    }
                });
            }
        }).observeOn(sharedScheduler);
        Intrinsics.checkNotNullExpressionValue(observeOn2, "userIdSharedObservable.s…ndNotificationsScheduler)");
        Observable flatMap = observeOn2.groupBy(new Function<ChatTypingEvent, String>() { // from class: com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgentImpl$subscribeToBackendNotifications$$inlined$transformByKey$3
            @Override // io.reactivex.functions.Function
            @Nullable
            public final String apply(@NotNull ChatTypingEvent chatTypingEvent) {
                Intrinsics.checkNotNullParameter(chatTypingEvent, "event");
                return chatTypingEvent.getFromId();
            }
        }).flatMap(new Function<GroupedObservable<String, ChatTypingEvent>, ObservableSource<? extends ChatTypingEvent>>() { // from class: com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgentImpl$subscribeToBackendNotifications$$inlined$transformByKey$4
            public final ObservableSource<? extends ChatTypingEvent> apply(@NotNull GroupedObservable<String, ChatTypingEvent> groupedObservable) {
                Intrinsics.checkNotNullParameter(groupedObservable, "groupedObs");
                if (!(groupedObservable.getKey() != null)) {
                    return groupedObservable;
                }
                Observable<ChatTypingEvent> throttleLatest = groupedObservable.throttleLatest(5000L, TimeUnit.MILLISECONDS, true);
                Intrinsics.checkNotNullExpressionValue(throttleLatest, "throttleLatest(\n        …                        )");
                return throttleLatest;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "groupBy { event ->\n     …bs.key, groupedObs)\n    }");
        Disposable subscribe = flatMap.subscribeOn(sharedScheduler).subscribe(new Consumer() { // from class: com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgentKt$sam$i$io_reactivex_functions_Consumer$0
            @Override // io.reactivex.functions.Consumer
            public final /* synthetic */ void accept(Object obj) {
                Intrinsics.checkNotNullExpressionValue(Function1.this.invoke(obj), "invoke(...)");
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "userIdSharedObservable.s…handleNewChatTypingEvent)");
        DisposableKt.addTo(subscribe, this.q);
        Disposable connect = publish.connect();
        Intrinsics.checkNotNullExpressionValue(connect, "userIdSharedObservable.connect()");
        DisposableKt.addTo(connect, this.q);
    }

    public static final /* synthetic */ State access$getDefaultState$p(UserLastActivitySyncAgentImpl userLastActivitySyncAgentImpl) {
        return (State) userLastActivitySyncAgentImpl.getDefaultState();
    }

    public static final Single access$getLastActionTimesByUserId(UserLastActivitySyncAgentImpl userLastActivitySyncAgentImpl, MessengerClient messengerClient, Collection collection) {
        Single<List<UserLastActivity>> single;
        Objects.requireNonNull(userLastActivitySyncAgentImpl);
        if (!collection.isEmpty()) {
            if (collection.size() <= 100) {
                single = messengerClient.getUserLastActivity(CollectionsKt___CollectionsKt.toList(collection)).timeout(15, TimeUnit.SECONDS).observeOn(userLastActivitySyncAgentImpl.getSchedulerForReducibles()).onErrorReturn(new UserLastActivitySyncAgentImpl$getUsersLastActivityInSingleRequest$1(userLastActivitySyncAgentImpl, collection));
                Intrinsics.checkNotNullExpressionValue(single, "getUserLastActivity(user…emptyList()\n            }");
            } else {
                List<List<String>> chunked = CollectionsKt___CollectionsKt.chunked(collection, 100);
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(chunked, 10));
                for (List<String> list : chunked) {
                    arrayList.add(messengerClient.getUserLastActivity(list));
                }
                single = Single.merge(arrayList).collectInto(new ArrayList(), UserLastActivitySyncAgentImpl$getUsersLastActivityInMultipleRequests$1.INSTANCE).timeout(15, TimeUnit.SECONDS).observeOn(userLastActivitySyncAgentImpl.getSchedulerForReducibles()).onErrorReturn(new UserLastActivitySyncAgentImpl$getUsersLastActivityInMultipleRequests$2(userLastActivitySyncAgentImpl, collection));
                Intrinsics.checkNotNullExpressionValue(single, "Single.merge(getUsersSin…bleListOf()\n            }");
            }
            Single<R> map = single.map(new UserLastActivitySyncAgentImpl$getLastActionTimesByUserId$1(userLastActivitySyncAgentImpl));
            Intrinsics.checkNotNullExpressionValue(map, "if (userIds.size <= MAX_…onTime)\n                }");
            return map;
        }
        Single just = Single.just(CollectionsKt__CollectionsKt.emptyList());
        Intrinsics.checkNotNullExpressionValue(just, "Single.just(emptyList())");
        return just;
    }

    public static final Single access$getUserIdsToPoll(UserLastActivitySyncAgentImpl userLastActivitySyncAgentImpl, Set set) {
        Objects.requireNonNull(userLastActivitySyncAgentImpl);
        TimeSource timeSource = userLastActivitySyncAgentImpl.u;
        Single<List<String>> onErrorReturn = userLastActivitySyncAgentImpl.t.getIdsOfUsersWithLastActionTimeOlderOrEqualTo((TimeUnit.SECONDS.convert(timeSource.now(), TimeUnit.MILLISECONDS) - 150) + 15, set).observeOn(userLastActivitySyncAgentImpl.getSchedulerForReducibles()).firstOrError().onErrorReturn(new UserLastActivitySyncAgentImpl$getUserIdsToPoll$1(userLastActivitySyncAgentImpl, set));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "userRepo.getIdsOfUsersWi…emptyList()\n            }");
        return onErrorReturn;
    }

    public static final Single access$getUsersLastActivityInMultipleRequests(UserLastActivitySyncAgentImpl userLastActivitySyncAgentImpl, MessengerClient messengerClient, Collection collection) {
        Objects.requireNonNull(userLastActivitySyncAgentImpl);
        List<List<String>> chunked = CollectionsKt___CollectionsKt.chunked(collection, 100);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(chunked, 10));
        for (List<String> list : chunked) {
            arrayList.add(messengerClient.getUserLastActivity(list));
        }
        Single onErrorReturn = Single.merge(arrayList).collectInto(new ArrayList(), UserLastActivitySyncAgentImpl$getUsersLastActivityInMultipleRequests$1.INSTANCE).timeout(15, TimeUnit.SECONDS).observeOn(userLastActivitySyncAgentImpl.getSchedulerForReducibles()).onErrorReturn(new UserLastActivitySyncAgentImpl$getUsersLastActivityInMultipleRequests$2(userLastActivitySyncAgentImpl, collection));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "Single.merge(getUsersSin…bleListOf()\n            }");
        return onErrorReturn;
    }

    public static final Single access$getUsersLastActivityInSingleRequest(UserLastActivitySyncAgentImpl userLastActivitySyncAgentImpl, MessengerClient messengerClient, Collection collection) {
        Objects.requireNonNull(userLastActivitySyncAgentImpl);
        Single<List<UserLastActivity>> onErrorReturn = messengerClient.getUserLastActivity(CollectionsKt___CollectionsKt.toList(collection)).timeout(15, TimeUnit.SECONDS).observeOn(userLastActivitySyncAgentImpl.getSchedulerForReducibles()).onErrorReturn(new UserLastActivitySyncAgentImpl$getUsersLastActivityInSingleRequest$1(userLastActivitySyncAgentImpl, collection));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "getUserLastActivity(user…emptyList()\n            }");
        return onErrorReturn;
    }

    public static final void access$handleNewChatTypingEvent(UserLastActivitySyncAgentImpl userLastActivitySyncAgentImpl, ChatTypingEvent chatTypingEvent) {
        userLastActivitySyncAgentImpl.getReducerQueue().plusAssign(new UpdateOnChatTypingAction(userLastActivitySyncAgentImpl, chatTypingEvent.getFromId(), TimeUnit.SECONDS.convert(userLastActivitySyncAgentImpl.u.now(), TimeUnit.MILLISECONDS), 0));
    }

    public static final UserIdAndLastActionTime access$toUserIdAndLastActionTime(UserLastActivitySyncAgentImpl userLastActivitySyncAgentImpl, UserLastActivity userLastActivity) {
        Long l;
        Objects.requireNonNull(userLastActivitySyncAgentImpl);
        Long lastActionTime = userLastActivity.getLastActionTime();
        if (lastActionTime != null) {
            l = Long.valueOf(TimeUnit.SECONDS.convert(userLastActivitySyncAgentImpl.u.now(), TimeUnit.MILLISECONDS) - lastActionTime.longValue());
        } else {
            l = null;
        }
        return new UserIdAndLastActionTime(userLastActivity.getUserId(), userLastActivity.getLastActionTime(), l);
    }

    public static final Completable access$updateUserLastActionTimes(UserLastActivitySyncAgentImpl userLastActivitySyncAgentImpl, Set set) {
        Objects.requireNonNull(userLastActivitySyncAgentImpl);
        TimeSource timeSource = userLastActivitySyncAgentImpl.u;
        Single<List<String>> onErrorReturn = userLastActivitySyncAgentImpl.t.getIdsOfUsersWithLastActionTimeOlderOrEqualTo((TimeUnit.SECONDS.convert(timeSource.now(), TimeUnit.MILLISECONDS) - 150) + 15, set).observeOn(userLastActivitySyncAgentImpl.getSchedulerForReducibles()).firstOrError().onErrorReturn(new UserLastActivitySyncAgentImpl$getUserIdsToPoll$1(userLastActivitySyncAgentImpl, set));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "userRepo.getIdsOfUsersWi…emptyList()\n            }");
        Completable observeOn = onErrorReturn.flatMap(new UserLastActivitySyncAgentImpl$updateUserLastActionTimes$1(userLastActivitySyncAgentImpl)).flatMapCompletable(new UserLastActivitySyncAgentKt$sam$i$io_reactivex_functions_Function$0(new UserLastActivitySyncAgentImpl$updateUserLastActionTimes$2(userLastActivitySyncAgentImpl.t))).observeOn(userLastActivitySyncAgentImpl.getSchedulerForReducibles());
        Intrinsics.checkNotNullExpressionValue(observeOn, "getUserIdsToPoll(request…n(schedulerForReducibles)");
        return observeOn;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.p.clear();
        this.q.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgent
    public void requestUsers(@NotNull String str, @NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(set, "userIds");
        getReducerQueue().plusAssign(new RequestMutator(this, str, set));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public UserLastActivitySyncAgentImpl(@NotNull AccountStateProvider accountStateProvider, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull UserRepo userRepo, @NotNull TimeSource timeSource, @NotNull Features features, @NotNull SchedulersFactory schedulersFactory) {
        this(accountStateProvider, messengerClient, userRepo, timeSource, features, schedulersFactory, new ReducerQueueWithTransformByKey(schedulersFactory.io(), b.a, new c(schedulersFactory.computation())));
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(userRepo, "userRepo");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
    }
}
