package com.avito.android.messenger.channels.mvi.common.v4;

import a2.a.a.o1.b.b.a.d.h;
import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.LogsT;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B®\u0001\u0012\u0006\u0010<\u001a\u00020\b\u0012\u0006\u0010I\u001a\u00028\u0000\u0012\u0006\u00107\u001a\u000202\u0012\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000%\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012#\b\u0002\u00101\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\r\u0012#\b\u0002\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\r\u0012#\b\u0002\u0010K\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0004\bL\u0010MJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0004¢\u0006\u0004\b\u000b\u0010\fR1\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010$\u001a\u00020\u001f8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00028\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R1\u00101\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010\u0011R\u001c\u00107\u001a\u0002028\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001c\u0010<\u001a\u00020\b8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\"\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020>0=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001c\u0010I\u001a\u00028\u00008\u0004@\u0004X\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010*R1\u0010K\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010\u0011¨\u0006N"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "", "StateT", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Landroidx/lifecycle/ViewModel;", "", "onCleared", "()V", "", "name", "", "generateReducibleId", "(Ljava/lang/String;)J", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "message", "n", "Lkotlin/jvm/functions/Function1;", "logDebug", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "l", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "getReducerQueue", "()Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "reducerQueue", "Lio/reactivex/Observable;", "d", "Lio/reactivex/Observable;", "getStateObservable", "()Lio/reactivex/Observable;", "stateObservable", "Lhu/akarnokd/rxjava2/schedulers/SharedScheduler;", "e", "Lhu/akarnokd/rxjava2/schedulers/SharedScheduler;", "getSchedulerForReducibles", "()Lhu/akarnokd/rxjava2/schedulers/SharedScheduler;", "schedulerForReducibles", "Lcom/avito/android/messenger/channels/mvi/common/v4/ShouldCancelChecker;", "k", "Lcom/avito/android/messenger/channels/mvi/common/v4/ShouldCancelChecker;", "cancelChecker", "getStateBlocking", "()Ljava/lang/Object;", "stateBlocking", "Lio/reactivex/disposables/Disposable;", "f", "Lio/reactivex/disposables/Disposable;", "reducerDisposable", AuthSource.OPEN_CHANNEL_LIST, "logVerbose", "Lcom/avito/android/util/SchedulersFactory;", "j", "Lcom/avito/android/util/SchedulersFactory;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory;", "schedulers", "h", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicLong;", g.a, "Ljava/util/concurrent/ConcurrentHashMap;", "reducibleIds", "Lcom/jakewharton/rxrelay2/Relay;", "c", "Lcom/jakewharton/rxrelay2/Relay;", "stateRelay", "i", "Ljava/lang/Object;", "getDefaultState", "defaultState", "o", "logInfo", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/channels/mvi/common/v4/ShouldCancelChecker;Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseMviEntityWithReducerQueue<StateT> extends ViewModel implements MviEntity<StateT> {
    public final Relay<StateT> c;
    @NotNull
    public final Observable<StateT> d;
    @NotNull
    public final SharedScheduler e;
    public Disposable f;
    public final ConcurrentHashMap<String, AtomicLong> g;
    @NotNull
    public final String h;
    @NotNull
    public final StateT i;
    @NotNull
    public final SchedulersFactory j;
    public final ShouldCancelChecker<StateT> k;
    @NotNull
    public final ReducerQueue<StateT> l;
    public final Function1<String, Unit> m;
    public final Function1<String, Unit> n;
    public final Function1<String, Unit> o;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(1);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String str) {
            int i = this.a;
            if (i == 0) {
                String str2 = str;
                Intrinsics.checkNotNullParameter(str2, "message");
                LogsT.verbose$default((String) this.b, str2, null, 4, null);
                return Unit.INSTANCE;
            } else if (i == 1) {
                String str3 = str;
                Intrinsics.checkNotNullParameter(str3, "message");
                LogsT.debug$default((String) this.b, str3, null, 4, null);
                return Unit.INSTANCE;
            } else if (i == 2) {
                String str4 = str;
                Intrinsics.checkNotNullParameter(str4, "message");
                LogsT.info$default((String) this.b, str4, null, 4, null);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BaseMviEntityWithReducerQueue(java.lang.String r10, java.lang.Object r11, com.avito.android.util.SchedulersFactory r12, com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker r13, com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue r14, kotlin.jvm.functions.Function1 r15, kotlin.jvm.functions.Function1 r16, kotlin.jvm.functions.Function1 r17, int r18, t6.r.a.j r19) {
        /*
            r9 = this;
            r1 = r10
            r0 = r18
            r2 = r0 & 8
            if (r2 == 0) goto L_0x0010
            com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker$Companion r2 = com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker.Companion
            com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker$Companion$dummy$1 r2 = new com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker$Companion$dummy$1
            r2.<init>()
            r4 = r2
            goto L_0x0011
        L_0x0010:
            r4 = r13
        L_0x0011:
            r2 = r0 & 16
            r3 = 2
            if (r2 == 0) goto L_0x0022
            com.avito.android.messenger.channels.mvi.common.v4.SimpleReducerQueue r2 = new com.avito.android.messenger.channels.mvi.common.v4.SimpleReducerQueue
            io.reactivex.Scheduler r5 = r12.io()
            r6 = 0
            r2.<init>(r5, r6, r3, r6)
            r5 = r2
            goto L_0x0023
        L_0x0022:
            r5 = r14
        L_0x0023:
            r2 = r0 & 32
            if (r2 == 0) goto L_0x002f
            com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue$a r2 = new com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue$a
            r6 = 0
            r2.<init>(r6, r10)
            r6 = r2
            goto L_0x0030
        L_0x002f:
            r6 = r15
        L_0x0030:
            r2 = r0 & 64
            if (r2 == 0) goto L_0x003c
            com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue$a r2 = new com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue$a
            r7 = 1
            r2.<init>(r7, r10)
            r7 = r2
            goto L_0x003e
        L_0x003c:
            r7 = r16
        L_0x003e:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0049
            com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue$a r0 = new com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue$a
            r0.<init>(r3, r10)
            r8 = r0
            goto L_0x004b
        L_0x0049:
            r8 = r17
        L_0x004b:
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue.<init>(java.lang.String, java.lang.Object, com.avito.android.util.SchedulersFactory, com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker, com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, int, t6.r.a.j):void");
    }

    public final long generateReducibleId(@NotNull String str) {
        AtomicLong putIfAbsent;
        Intrinsics.checkNotNullParameter(str, "name");
        ConcurrentHashMap<String, AtomicLong> concurrentHashMap = this.g;
        AtomicLong atomicLong = concurrentHashMap.get(str);
        if (atomicLong == null && (putIfAbsent = concurrentHashMap.putIfAbsent(str, (atomicLong = new AtomicLong(0)))) != null) {
            atomicLong = putIfAbsent;
        }
        return atomicLong.getAndIncrement();
    }

    @NotNull
    public final StateT getDefaultState() {
        return this.i;
    }

    @NotNull
    public final ReducerQueue<StateT> getReducerQueue() {
        return this.l;
    }

    @NotNull
    public final SharedScheduler getSchedulerForReducibles() {
        return this.e;
    }

    @NotNull
    public final SchedulersFactory getSchedulers() {
        return this.j;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.MviEntity
    @NotNull
    public StateT getStateBlocking() {
        StateT blockingGet = this.c.first(this.i).blockingGet();
        Intrinsics.checkNotNullExpressionValue(blockingGet, "stateRelay.first(defaultState).blockingGet()");
        return blockingGet;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.MviEntity
    @NotNull
    public Observable<StateT> getStateObservable() {
        return this.d;
    }

    @NotNull
    public final String getTAG() {
        return this.h;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.l.dispose();
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f = null;
        this.e.shutdown();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseMviEntityWithReducerQueue(@NotNull String str, @NotNull StateT statet, @NotNull SchedulersFactory schedulersFactory, @NotNull ShouldCancelChecker<StateT> shouldCancelChecker, @NotNull ReducerQueue<StateT> reducerQueue, @NotNull Function1<? super String, Unit> function1, @NotNull Function1<? super String, Unit> function12, @NotNull Function1<? super String, Unit> function13) {
        Intrinsics.checkNotNullParameter(str, "TAG");
        Intrinsics.checkNotNullParameter(statet, "defaultState");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(shouldCancelChecker, "cancelChecker");
        Intrinsics.checkNotNullParameter(reducerQueue, "reducerQueue");
        Intrinsics.checkNotNullParameter(function1, "logVerbose");
        Intrinsics.checkNotNullParameter(function12, "logDebug");
        Intrinsics.checkNotNullParameter(function13, "logInfo");
        this.h = str;
        this.i = statet;
        this.j = schedulersFactory;
        this.k = shouldCancelChecker;
        this.l = reducerQueue;
        this.m = function1;
        this.n = function12;
        this.o = function13;
        Relay<StateT> serialized = BehaviorRelay.createDefault(statet).toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized, "BehaviorRelay.createDefa…aultValue).toSerialized()");
        this.c = serialized;
        this.d = serialized;
        SharedScheduler sharedScheduler = new SharedScheduler(schedulersFactory.io());
        this.e = sharedScheduler;
        this.g = new ConcurrentHashMap<>();
        this.f = reducerQueue.getStream().observeOn(sharedScheduler).concatMap(new a2.a.a.o1.b.b.a.d.g(this)).doOnSubscribe(new h(this)).subscribe();
    }
}
