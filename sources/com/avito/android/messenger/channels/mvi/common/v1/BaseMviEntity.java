package com.avito.android.messenger.channels.mvi.common.v1;

import a2.a.a.o1.b.b.a.a.b;
import a2.a.a.o1.b.b.a.a.c;
import a2.a.a.o1.b.b.a.a.d;
import a2.g.r.g;
import androidx.annotation.CallSuper;
import androidx.lifecycle.ViewModel;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B\u0017\u0012\u0006\u0010,\u001a\u00028\u0000\u0012\u0006\u0010'\u001a\u00020\"¢\u0006\u0004\b?\u0010@JV\u0010\u000f\u001aI\u0012E\u0012C\u0012/\u0012-\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\f\u0012\u0004\u0012\u00020\r0\u0006j\b\u0012\u0004\u0012\u00028\u0000`\u000e0\u0005H$¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0015¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\rH\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0001\u0010\u0019\u001aC\u0012/\u0012-\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\f\u0012\u0004\u0012\u00020\r0\u0006j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\t\u001a\u00020\r23\b\b\u0010\u0018\u001a-\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\fH\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0001\u0010\u001d\u001aC\u0012/\u0012-\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\f\u0012\u0004\u0012\u00020\r0\u0006j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\t\u001a\u00020\r2-\b\u0004\u0010\u001c\u001a'\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00028\u00000\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u001bH\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001aR\"\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0010R\u001c\u0010'\u001a\u00020\"8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010,\u001a\u00028\u00008\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u0010.\u001a\u00028\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b-\u0010+R\u0016\u00101\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\"\u00106\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000203028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=\u0002\u0007\n\u0005\b20\u0001¨\u0006A"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v1/BaseMviEntity;", "", "StateT", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Landroidx/lifecycle/ViewModel;", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "oldState", "Lio/reactivex/Single;", "Lcom/avito/android/messenger/channels/mvi/common/v1/MutatorSingle;", "", "Lcom/avito/android/messenger/channels/mvi/common/v1/NamedMutatorSingle;", "mutatorsObservable", "()Lio/reactivex/Observable;", "", "initialize", "()V", "onCleared", "", "generateMutatorId", "(Ljava/lang/String;)J", "mutatorSingle", "namedMutatorSingle", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lkotlin/Pair;", "Lcom/avito/android/messenger/channels/mvi/common/v1/Mutator;", "mutator", "namedMutatorSingleFromMutator", "d", "Lio/reactivex/Observable;", "getStateObservable", "stateObservable", "Lio/reactivex/Scheduler;", "h", "Lio/reactivex/Scheduler;", "getSchedulerForMutators", "()Lio/reactivex/Scheduler;", "schedulerForMutators", g.a, "Ljava/lang/Object;", "getDefaultState", "()Ljava/lang/Object;", "defaultState", "getStateBlocking", "stateBlocking", "getTAG", "()Ljava/lang/String;", "TAG", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicLong;", "f", "Ljava/util/concurrent/ConcurrentHashMap;", "mutatorIds", "Lio/reactivex/disposables/Disposable;", "e", "Lio/reactivex/disposables/Disposable;", "reducerDisposable", "Lcom/jakewharton/rxrelay2/Relay;", "c", "Lcom/jakewharton/rxrelay2/Relay;", "stateRelay", "<init>", "(Ljava/lang/Object;Lio/reactivex/Scheduler;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseMviEntity<StateT> extends ViewModel implements MviEntity<StateT> {
    public final Relay<StateT> c;
    @NotNull
    public final Observable<StateT> d;
    public Disposable e;
    public final ConcurrentHashMap<String, AtomicLong> f = new ConcurrentHashMap<>();
    @NotNull
    public final StateT g;
    @NotNull
    public final Scheduler h;

    public static final class a<T, R> implements Function<Pair<? extends Function1<? super StateT, ? extends Single<StateT>>, ? extends String>, ObservableSource<? extends Unit>> {
        public final /* synthetic */ BaseMviEntity a;

        public a(BaseMviEntity baseMviEntity) {
            this.a = baseMviEntity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Unit> apply(Object obj) {
            Pair pair = (Pair) obj;
            Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
            return this.a.c.take(1).flatMapSingle(new b(this, (String) pair.component2(), (Function1) pair.component1())).observeOn(this.a.getSchedulerForMutators()).filter(c.a).map(new d(this)).subscribeOn(this.a.getSchedulerForMutators());
        }
    }

    public BaseMviEntity(@NotNull StateT statet, @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(statet, "defaultState");
        Intrinsics.checkNotNullParameter(scheduler, "schedulerForMutators");
        this.g = statet;
        this.h = scheduler;
        Relay<StateT> serialized = BehaviorRelay.createDefault(statet).toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized, "BehaviorRelay.createDefa…aultValue).toSerialized()");
        this.c = serialized;
        this.d = serialized;
    }

    public final long generateMutatorId(@NotNull String str) {
        AtomicLong putIfAbsent;
        Intrinsics.checkNotNullParameter(str, "name");
        ConcurrentHashMap<String, AtomicLong> concurrentHashMap = this.f;
        AtomicLong atomicLong = concurrentHashMap.get(str);
        if (atomicLong == null && (putIfAbsent = concurrentHashMap.putIfAbsent(str, (atomicLong = new AtomicLong(0)))) != null) {
            atomicLong = putIfAbsent;
        }
        return atomicLong.getAndIncrement();
    }

    @NotNull
    public final StateT getDefaultState() {
        return this.g;
    }

    @NotNull
    public final Scheduler getSchedulerForMutators() {
        return this.h;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.MviEntity
    @NotNull
    public StateT getStateBlocking() {
        StateT blockingGet = this.c.first(this.g).blockingGet();
        Intrinsics.checkNotNullExpressionValue(blockingGet, "stateRelay.first(defaultState).blockingGet()");
        return blockingGet;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.MviEntity
    @NotNull
    public Observable<StateT> getStateObservable() {
        return this.d;
    }

    @NotNull
    public abstract String getTAG();

    public final void initialize() {
        this.e = mutatorsObservable().observeOn(this.h).concatMap(new a(this)).subscribeOn(this.h).subscribe();
    }

    @NotNull
    public abstract Observable<Pair<Function1<StateT, Single<StateT>>, String>> mutatorsObservable();

    @NotNull
    public final Pair<Function1<StateT, Single<StateT>>, String> namedMutatorSingle(@NotNull String str, @NotNull Function1<? super StateT, ? extends Single<StateT>> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "mutatorSingle");
        return TuplesKt.to(function1, "Mutator." + str + '#' + generateMutatorId(str));
    }

    @NotNull
    public final Pair<Function1<StateT, Single<StateT>>, String> namedMutatorSingleFromMutator(@NotNull String str, @NotNull Function1<? super StateT, ? extends StateT> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "mutator");
        BaseMviEntitiesKt$mutatorSingle$1 baseMviEntitiesKt$mutatorSingle$1 = new BaseMviEntitiesKt$mutatorSingle$1(function1);
        return TuplesKt.to(baseMviEntitiesKt$mutatorSingle$1, "Mutator." + str + '#' + generateMutatorId(str));
    }

    @Override // androidx.lifecycle.ViewModel
    @CallSuper
    public void onCleared() {
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.e = null;
    }
}
