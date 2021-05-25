package com.avito.android.messenger.conversation.mvi.platform_actions;

import com.avito.android.Features;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker;
import com.avito.android.messenger.channels.mvi.common.v4.SimpleReducerQueue;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinatorImpl;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.SchedulersFactory;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import t6.c;
import t6.n.q;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0006789:;<BY\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00101\u001a\u000200\u0012\"\u0010!\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0002\b\u00030\u001cj\u000b\u0012\u0002\b\u0003`\u001d¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001e0\u000f\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000302¢\u0006\u0004\b4\u00105BM\b\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00101\u001a\u000200\u0012\"\u0010!\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0002\b\u00030\u001cj\u000b\u0012\u0002\b\u0003`\u001d¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001e0\u000f¢\u0006\u0004\b4\u00106J;\u0010\r\u001a\u00020\f2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u001e\u0010\u000b\u001a\u001a\u0012\b\u0012\u00060\u0004j\u0002`\b\u0012\f\u0012\n\u0018\u00010\tj\u0004\u0018\u0001`\n0\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0011\u001a\u00020\f2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\b0\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\f2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0013\u001a\u00060\tj\u0002`\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR2\u0010!\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0002\b\u00030\u001cj\u000b\u0012\u0002\b\u0003`\u001d¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001e0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006="}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinatorImpl;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASConsumerKey;", "consumerKey", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASKey;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PAState;", "previouslyConsumedStatesByKey", "", "consumerBound", "(Ljava/lang/Object;Ljava/util/Map;)V", "", "consumedStateKeys", "consumerUnbound", "(Ljava/lang/Object;Ljava/util/Set;)V", "state", "stateConsumed", "(Ljava/lang/Object;Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;)V", "onCleared", "()V", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "r", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "channelContextInteractor", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateProducer$Factory;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASProducerFactory;", "Lkotlin/jvm/JvmSuppressWildcards;", "t", "Ljava/util/Set;", "stateProducerFactories", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;", "s", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;", "messageListInteractor", "Lio/reactivex/disposables/CompositeDisposable;", "p", "Lio/reactivex/disposables/CompositeDisposable;", "allSubscriptions", "Ljava/util/concurrent/atomic/AtomicLong;", VKApiConst.Q, "Ljava/util/concurrent/atomic/AtomicLong;", "currentChannelDataId", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "reducerQueue", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;Ljava/util/Set;Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;)V", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;Ljava/util/Set;)V", AuthSource.SEND_ABUSE, "ConsumerBoundMutator", "ConsumerUnboundMutator", "NewChannelDataMutator", "ProcessMutator", "StateConsumedMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformActionsCoordinatorImpl extends BaseMviEntityWithReducerQueue<PlatformActionsCoordinator.CoordinatorState> implements PlatformActionsCoordinator {
    public final CompositeDisposable p;
    public final AtomicLong q;
    public final ChannelContextInteractor r;
    public final MessageListInteractor s;
    public final Set<PlatformActionsStateProducer.Factory<?>> t;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007\u0012\u001e\u0010\u0011\u001a\u001a\u0012\b\u0012\u00060\u0006j\u0002`\f\u0012\f\u0012\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e0\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\n\u001a\u00060\u0006j\u0002`\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR.\u0010\u0011\u001a\u001a\u0012\b\u0012\u00060\u0006j\u0002`\f\u0012\f\u0012\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinatorImpl$ConsumerBoundMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASConsumerKey;", "d", "Ljava/lang/Object;", "consumerKey", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASKey;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PAState;", "e", "Ljava/util/Map;", "previouslyConsumedStatesByKey", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinatorImpl;Ljava/lang/Object;Ljava/util/Map;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ConsumerBoundMutator extends Mutator<PlatformActionsCoordinator.CoordinatorState> {
        public final Object d;
        public final Map<Object, PlatformActionsState> e;
        public final /* synthetic */ PlatformActionsCoordinatorImpl f;

        public static final class a extends Lambda implements Function0<Map<Object, Map<Object, ? extends Long>>> {
            public final /* synthetic */ Ref.BooleanRef a;
            public final /* synthetic */ PlatformActionsCoordinator.CoordinatorState b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Ref.BooleanRef booleanRef, PlatformActionsCoordinator.CoordinatorState coordinatorState) {
                super(0);
                this.a = booleanRef;
                this.b = coordinatorState;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Map<Object, Map<Object, ? extends Long>> invoke() {
                this.a.element = true;
                return r.toMutableMap(this.b.getConsumedStateIdsByKey());
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<java.lang.Object, ? extends com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsState> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ConsumerBoundMutator(@NotNull PlatformActionsCoordinatorImpl platformActionsCoordinatorImpl, @NotNull Object obj, Map<Object, ? extends PlatformActionsState> map) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(obj, "consumerKey");
            Intrinsics.checkNotNullParameter(map, "previouslyConsumedStatesByKey");
            this.f = platformActionsCoordinatorImpl;
            this.d = obj;
            this.e = map;
        }

        @NotNull
        public PlatformActionsCoordinator.CoordinatorState invoke(@NotNull PlatformActionsCoordinator.CoordinatorState coordinatorState) {
            Intrinsics.checkNotNullParameter(coordinatorState, "oldState");
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            Lazy lazy = c.lazy(LazyThreadSafetyMode.NONE, (Function0) new a(booleanRef, coordinatorState));
            for (Map.Entry<Object, PlatformActionsState> entry : this.e.entrySet()) {
                Object key = entry.getKey();
                PlatformActionsState value = entry.getValue();
                Map<Object, Long> map = coordinatorState.getConsumedStateIdsByKey().get(key);
                long j = -1;
                Long l = null;
                if (map == null) {
                    Map map2 = (Map) lazy.getValue();
                    Object obj = this.d;
                    if (value != null) {
                        l = Long.valueOf(value.getId());
                    }
                    if (l != null) {
                        j = l.longValue();
                    }
                    map2.put(key, q.mapOf(TuplesKt.to(obj, Long.valueOf(j))));
                } else {
                    Long l2 = map.get(this.d);
                    Long valueOf = value != null ? Long.valueOf(value.getId()) : null;
                    long longValue = valueOf != null ? valueOf.longValue() : -1;
                    if (l2 == null || l2.longValue() != longValue) {
                        Map map3 = (Map) lazy.getValue();
                        Object obj2 = this.d;
                        if (value != null) {
                            l = Long.valueOf(value.getId());
                        }
                        if (l != null) {
                            j = l.longValue();
                        }
                        map3.put(key, r.plus(map, TuplesKt.to(obj2, Long.valueOf(j))));
                    }
                }
            }
            if (!booleanRef.element) {
                return coordinatorState;
            }
            this.f.getReducerQueue().plusAssign(new ProcessMutator());
            return PlatformActionsCoordinator.CoordinatorState.copy$default(coordinatorState, null, null, null, PlatformActionsCoordinator.CoordinatorState.ProcessingStep.IncompatibleConsumersAreNotReady.INSTANCE, null, null, (Map) lazy.getValue(), 55, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007\u0012\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\n\u001a\u00060\u0006j\u0002`\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR \u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinatorImpl$ConsumerUnboundMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASConsumerKey;", "d", "Ljava/lang/Object;", "consumerKey", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASKey;", "e", "Ljava/util/Set;", "consumerStateKeys", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinatorImpl;Ljava/lang/Object;Ljava/util/Set;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ConsumerUnboundMutator extends Mutator<PlatformActionsCoordinator.CoordinatorState> {
        public final Object d;
        public final Set<Object> e;
        public final /* synthetic */ PlatformActionsCoordinatorImpl f;

        public static final class a extends Lambda implements Function0<Map<Object, Map<Object, ? extends Long>>> {
            public final /* synthetic */ Ref.BooleanRef a;
            public final /* synthetic */ PlatformActionsCoordinator.CoordinatorState b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Ref.BooleanRef booleanRef, PlatformActionsCoordinator.CoordinatorState coordinatorState) {
                super(0);
                this.a = booleanRef;
                this.b = coordinatorState;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Map<Object, Map<Object, ? extends Long>> invoke() {
                this.a.element = true;
                return r.toMutableMap(this.b.getConsumedStateIdsByKey());
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ConsumerUnboundMutator(@NotNull PlatformActionsCoordinatorImpl platformActionsCoordinatorImpl, @NotNull Object obj, Set<? extends Object> set) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(obj, "consumerKey");
            Intrinsics.checkNotNullParameter(set, "consumerStateKeys");
            this.f = platformActionsCoordinatorImpl;
            this.d = obj;
            this.e = set;
        }

        @NotNull
        public PlatformActionsCoordinator.CoordinatorState invoke(@NotNull PlatformActionsCoordinator.CoordinatorState coordinatorState) {
            Intrinsics.checkNotNullParameter(coordinatorState, "oldState");
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            Lazy lazy = c.lazy(LazyThreadSafetyMode.NONE, (Function0) new a(booleanRef, coordinatorState));
            for (T t : this.e) {
                Map<Object, Long> map = coordinatorState.getConsumedStateIdsByKey().get(t);
                if (map != null && map.containsKey(this.d)) {
                    ((Map) lazy.getValue()).put(t, r.minus(map, this.d));
                }
            }
            if (!booleanRef.element) {
                return coordinatorState;
            }
            this.f.getReducerQueue().plusAssign(new ProcessMutator());
            return PlatformActionsCoordinator.CoordinatorState.copy$default(coordinatorState, null, null, null, PlatformActionsCoordinator.CoordinatorState.ProcessingStep.IncompatibleConsumersAreNotReady.INSTANCE, null, null, (Map) lazy.getValue(), 55, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinatorImpl$NewChannelDataMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;", "d", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;", "newChannelData", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinatorImpl;Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class NewChannelDataMutator extends Mutator<PlatformActionsCoordinator.CoordinatorState> {
        public final ChannelData d;
        public final /* synthetic */ PlatformActionsCoordinatorImpl e;

        public static final class a extends Lambda implements Function0<Map<Object, Long>> {
            public final /* synthetic */ Ref.BooleanRef a;
            public final /* synthetic */ PlatformActionsCoordinator.CoordinatorState b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Ref.BooleanRef booleanRef, PlatformActionsCoordinator.CoordinatorState coordinatorState) {
                super(0);
                this.a = booleanRef;
                this.b = coordinatorState;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Map<Object, Long> invoke() {
                this.a.element = true;
                return r.toMutableMap(this.b.getProducedStateIdsByKey());
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NewChannelDataMutator(@NotNull PlatformActionsCoordinatorImpl platformActionsCoordinatorImpl, ChannelData channelData) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(channelData, "newChannelData");
            this.e = platformActionsCoordinatorImpl;
            this.d = channelData;
        }

        @NotNull
        public PlatformActionsCoordinator.CoordinatorState invoke(@NotNull PlatformActionsCoordinator.CoordinatorState coordinatorState) {
            PlatformActionsCoordinator.CoordinatorState.ProcessingStep processingStep;
            Intrinsics.checkNotNullParameter(coordinatorState, "oldState");
            if (!(!Intrinsics.areEqual(coordinatorState.getChannelData(), this.d))) {
                return coordinatorState;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Set set = this.e.t;
            ArrayList arrayList = new ArrayList();
            for (Object obj : set) {
                Set<Object> compatibleKeys = ((PlatformActionsStateProducer.Factory) obj).getCompatibleKeys(this.d);
                linkedHashSet.addAll(compatibleKeys);
                if (!compatibleKeys.isEmpty()) {
                    arrayList.add(obj);
                }
            }
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            Lazy lazy = c.lazy(LazyThreadSafetyMode.NONE, (Function0) new a(booleanRef, coordinatorState));
            Map<Object, Long> producedStateIdsByKey = coordinatorState.getProducedStateIdsByKey();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Object, Long> entry : producedStateIdsByKey.entrySet()) {
                Object key = entry.getKey();
                long longValue = entry.getValue().longValue();
                if ((linkedHashSet.contains(key) || longValue == this.d.id || longValue == -1) ? false : true) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                Object key2 = entry2.getKey();
                PlatformActionsStateProducer<?> platformActionsStateProducer = coordinatorState.getStateProducersByKey().get(key2);
                if (platformActionsStateProducer != null) {
                    platformActionsStateProducer.reset(this.d.id);
                }
                ((Map) lazy.getValue()).put(key2, Long.valueOf(this.d.id));
            }
            if (true ^ arrayList.isEmpty()) {
                this.e.getReducerQueue().plusAssign(new ProcessMutator());
                processingStep = PlatformActionsCoordinator.CoordinatorState.ProcessingStep.IncompatibleConsumersAreNotReady.INSTANCE;
            } else {
                processingStep = PlatformActionsCoordinator.CoordinatorState.ProcessingStep.Finished.INSTANCE;
            }
            return PlatformActionsCoordinator.CoordinatorState.copy$default(coordinatorState, this.d, linkedHashSet, arrayList, processingStep, null, booleanRef.element ? (Map) lazy.getValue() : coordinatorState.getProducedStateIdsByKey(), null, 80, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinatorImpl$ProcessMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinatorImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ProcessMutator extends Mutator<PlatformActionsCoordinator.CoordinatorState> {

        public static final class a extends Lambda implements Function0<Map<Object, Long>> {
            public final /* synthetic */ Ref.BooleanRef a;
            public final /* synthetic */ PlatformActionsCoordinator.CoordinatorState b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Ref.BooleanRef booleanRef, PlatformActionsCoordinator.CoordinatorState coordinatorState) {
                super(0);
                this.a = booleanRef;
                this.b = coordinatorState;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Map<Object, Long> invoke() {
                this.a.element = true;
                return r.toMutableMap(this.b.getProducedStateIdsByKey());
            }
        }

        public static final class b extends Lambda implements Function0<Map<Object, PlatformActionsStateProducer<?>>> {
            public final /* synthetic */ Ref.BooleanRef a;
            public final /* synthetic */ PlatformActionsCoordinator.CoordinatorState b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Ref.BooleanRef booleanRef, PlatformActionsCoordinator.CoordinatorState coordinatorState) {
                super(0);
                this.a = booleanRef;
                this.b = coordinatorState;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Map<Object, PlatformActionsStateProducer<?>> invoke() {
                this.a.element = true;
                return r.toMutableMap(this.b.getStateProducersByKey());
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public ProcessMutator() {
            super(null, null, 3, null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:59:0x008c A[SYNTHETIC] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator.CoordinatorState invoke(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator.CoordinatorState r16) {
            /*
            // Method dump skipped, instructions count: 432
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinatorImpl.ProcessMutator.invoke(com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator$CoordinatorState):com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator$CoordinatorState");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\n\u0010\u000f\u001a\u00060\u000bj\u0002`\f\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\n\u001a\u00060\u0006j\u0002`\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000f\u001a\u00060\u000bj\u0002`\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinatorImpl$StateConsumedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PAState;", "e", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;", "state", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASConsumerKey;", "d", "Ljava/lang/Object;", "consumerKey", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinatorImpl;Ljava/lang/Object;Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class StateConsumedMutator extends Mutator<PlatformActionsCoordinator.CoordinatorState> {
        public final Object d;
        public final PlatformActionsState e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StateConsumedMutator(@NotNull PlatformActionsCoordinatorImpl platformActionsCoordinatorImpl, @NotNull Object obj, PlatformActionsState platformActionsState) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(obj, "consumerKey");
            Intrinsics.checkNotNullParameter(platformActionsState, "state");
            this.d = obj;
            this.e = platformActionsState;
        }

        @NotNull
        public PlatformActionsCoordinator.CoordinatorState invoke(@NotNull PlatformActionsCoordinator.CoordinatorState coordinatorState) {
            Intrinsics.checkNotNullParameter(coordinatorState, "oldState");
            Map<Object, Long> map = coordinatorState.getConsumedStateIdsByKey().get(this.e.getKey());
            Long l = map != null ? map.get(this.d) : null;
            long id = this.e.getId();
            if (l != null && l.longValue() == id) {
                return coordinatorState;
            }
            Map mutableMap = r.toMutableMap(coordinatorState.getConsumedStateIdsByKey());
            Map<Object, Long> map2 = coordinatorState.getConsumedStateIdsByKey().get(this.e.getKey());
            if (map2 != null) {
                mutableMap.put(this.e.getKey(), r.plus(map2, TuplesKt.to(this.d, Long.valueOf(this.e.getId()))));
            } else {
                mutableMap.put(this.e.getKey(), q.mapOf(TuplesKt.to(this.d, Long.valueOf(this.e.getId()))));
            }
            return PlatformActionsCoordinator.CoordinatorState.copy$default(coordinatorState, null, null, null, PlatformActionsCoordinator.CoordinatorState.ProcessingStep.IncompatibleConsumersAreNotReady.INSTANCE, null, null, mutableMap, 55, null);
        }
    }

    public static final class a implements ShouldCancelChecker<PlatformActionsCoordinator.CoordinatorState> {
        @NotNull
        public static final a a = new a();

        @Override // com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker
        public boolean aShouldCancelB(@NotNull Reducible<PlatformActionsCoordinator.CoordinatorState> reducible, @NotNull Reducible<PlatformActionsCoordinator.CoordinatorState> reducible2) {
            Intrinsics.checkNotNullParameter(reducible, AuthSource.SEND_ABUSE);
            Intrinsics.checkNotNullParameter(reducible2, AuthSource.BOOKING_ORDER);
            if (!(reducible instanceof NewChannelDataMutator)) {
                return false;
            }
            if (!(reducible2 instanceof NewChannelDataMutator) && !(reducible2 instanceof ProcessMutator)) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlatformActionsCoordinatorImpl(@NotNull ChannelContextInteractor channelContextInteractor, @NotNull MessageListInteractor messageListInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull Features features, @NotNull Set<PlatformActionsStateProducer.Factory<?>> set, @NotNull ReducerQueue<PlatformActionsCoordinator.CoordinatorState> reducerQueue) {
        super("PlatformActionsCoordinator", PlatformActionsCoordinator.CoordinatorState.Companion.getDEFAULT(), schedulersFactory, a.a, reducerQueue, null, null, null, 224, null);
        Intrinsics.checkNotNullParameter(channelContextInteractor, "channelContextInteractor");
        Intrinsics.checkNotNullParameter(messageListInteractor, "messageListInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(set, "stateProducerFactories");
        Intrinsics.checkNotNullParameter(reducerQueue, "reducerQueue");
        this.r = channelContextInteractor;
        this.s = messageListInteractor;
        this.t = set;
        this.p = new CompositeDisposable();
        this.q = new AtomicLong(-1);
        if (features.getMessengerPlatformActionsCoordinator().invoke().booleanValue()) {
            Observable observeOn = this.s.getStateObservable().observeOn(getSchedulers().computation());
            Intrinsics.checkNotNullExpressionValue(observeOn, "messageListInteractor.st…schedulers.computation())");
            Observable ofType = observeOn.ofType(MessageListInteractor.State.FirstPageLoaded.class);
            Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
            Observable take = ofType.take(1);
            Observable map = this.r.getStateObservable().observeOn(getSchedulers().computation()).map(PlatformActionsCoordinatorImpl$setupInitSubscriptions$1.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(map, "channelContextInteractor…e -> state.channelState }");
            Observable ofType2 = map.ofType(Loading.Success.class);
            Intrinsics.checkExpressionValueIsNotNull(ofType2, "ofType(R::class.java)");
            Intrinsics.checkNotNullExpressionValue(take, "messagesLoaded");
            Observable combineLatest = Observable.combineLatest(ofType2, take, new BiFunction<T1, T2, R>() { // from class: com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinatorImpl$setupInitSubscriptions$$inlined$combineLatestWith$2
                /* JADX WARN: Type inference failed for: r2v1, types: [com.avito.android.messenger.channels.mvi.common.Loading$Success, R] */
                @Override // io.reactivex.functions.BiFunction
                @NotNull
                public final R apply(@NotNull T1 t1, @NotNull T2 t2) {
                    Intrinsics.checkNotNullParameter(t1, "t1");
                    Intrinsics.checkNotNullParameter(t2, "t2");
                    return t1;
                }
            });
            Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
            Disposable subscribe = combineLatest.map(new Function<Loading.Success<Channel>, ChannelData>() { // from class: com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinatorImpl$setupInitSubscriptions$3
                public final ChannelData apply(@NotNull Loading.Success<Channel> success) {
                    Intrinsics.checkNotNullParameter(success, "channelState");
                    Channel value = success.getValue();
                    PlatformActions contextActions = value.getContextActions();
                    if (contextActions == null) {
                        contextActions = new PlatformActions.None(null);
                    }
                    return new ChannelData(PlatformActionsCoordinatorImpl.this.q.incrementAndGet(), value.getChannelId(), value.getUpdated(), value.getFlow(), contextActions);
                }
            }).distinctUntilChanged().subscribe(new Consumer<ChannelData>() { // from class: com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinatorImpl$setupInitSubscriptions$4
                public final void accept(ChannelData channelData) {
                    ReducerQueue reducerQueue2 = PlatformActionsCoordinatorImpl.this.getReducerQueue();
                    PlatformActionsCoordinatorImpl platformActionsCoordinatorImpl = PlatformActionsCoordinatorImpl.this;
                    Intrinsics.checkNotNullExpressionValue(channelData, "channelData");
                    reducerQueue2.plusAssign(new PlatformActionsCoordinatorImpl.NewChannelDataMutator(platformActionsCoordinatorImpl, channelData));
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe, "channelContextInteractor…hannelData)\n            }");
            DisposableKt.addTo(subscribe, this.p);
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator
    public void consumerBound(@NotNull Object obj, @NotNull Map<Object, ? extends PlatformActionsState> map) {
        Intrinsics.checkNotNullParameter(obj, "consumerKey");
        Intrinsics.checkNotNullParameter(map, "previouslyConsumedStatesByKey");
        getReducerQueue().plusAssign(new ConsumerBoundMutator(this, obj, map));
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator
    public void consumerUnbound(@NotNull Object obj, @NotNull Set<? extends Object> set) {
        Intrinsics.checkNotNullParameter(obj, "consumerKey");
        Intrinsics.checkNotNullParameter(set, "consumedStateKeys");
        getReducerQueue().plusAssign(new ConsumerUnboundMutator(this, obj, set));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.p.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator
    public void stateConsumed(@NotNull Object obj, @NotNull PlatformActionsState platformActionsState) {
        Intrinsics.checkNotNullParameter(obj, "consumerKey");
        Intrinsics.checkNotNullParameter(platformActionsState, "state");
        getReducerQueue().plusAssign(new StateConsumedMutator(this, obj, platformActionsState));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public PlatformActionsCoordinatorImpl(@NotNull ChannelContextInteractor channelContextInteractor, @NotNull MessageListInteractor messageListInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull Features features, @NotNull Set<PlatformActionsStateProducer.Factory<?>> set) {
        this(channelContextInteractor, messageListInteractor, schedulersFactory, features, set, new SimpleReducerQueue(schedulersFactory.io(), null, 2, null));
        Intrinsics.checkNotNullParameter(channelContextInteractor, "channelContextInteractor");
        Intrinsics.checkNotNullParameter(messageListInteractor, "messageListInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(set, "stateProducerFactories");
    }
}
