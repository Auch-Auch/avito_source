package com.avito.android.messenger.channels.mvi.common.v2;

import a2.a.a.o1.b.b.a.b.c;
import a2.a.a.o1.b.b.a.b.d;
import a2.g.r.g;
import androidx.annotation.CallSuper;
import androidx.lifecycle.ViewModel;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B\u001f\u0012\u0006\u0010-\u001a\u00020\u0011\u0012\u0006\u0010\"\u001a\u00028\u0000\u0012\u0006\u00103\u001a\u00020.¢\u0006\u0004\bC\u0010DJ\u001b\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005H$¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0015¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\u00028\u00008\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010$\u001a\u00028\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!R\"\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\bR\u001c\u0010-\u001a\u00020\u00118\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001c\u00103\u001a\u00020.8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\"\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u000205048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001c\u0010B\u001a\u00020=8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntity;", "", "StateT", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Landroidx/lifecycle/ViewModel;", "Lio/reactivex/Observable;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "mutatorsObservable", "()Lio/reactivex/Observable;", "Lio/reactivex/Single;", "", "initialize", "()Lio/reactivex/Single;", "", "onInitialize", "()V", "onCleared", "", "name", "", "generateMutatorId", "(Ljava/lang/String;)J", "Lcom/jakewharton/rxrelay2/Relay;", "c", "Lcom/jakewharton/rxrelay2/Relay;", "stateRelay", "Lio/reactivex/disposables/Disposable;", "f", "Lio/reactivex/disposables/Disposable;", "reducerDisposable", "j", "Ljava/lang/Object;", "getDefaultState", "()Ljava/lang/Object;", "defaultState", "getStateBlocking", "stateBlocking", "d", "Lio/reactivex/Observable;", "getStateObservable", "stateObservable", "i", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Lcom/avito/android/util/SchedulersFactory;", "k", "Lcom/avito/android/util/SchedulersFactory;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicLong;", "h", "Ljava/util/concurrent/ConcurrentHashMap;", "mutatorIds", "Ljava/util/concurrent/atomic/AtomicBoolean;", g.a, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitialized", "Lhu/akarnokd/rxjava2/schedulers/SharedScheduler;", "e", "Lhu/akarnokd/rxjava2/schedulers/SharedScheduler;", "getSchedulerForMutators", "()Lhu/akarnokd/rxjava2/schedulers/SharedScheduler;", "schedulerForMutators", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Lcom/avito/android/util/SchedulersFactory;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseMviEntity<StateT> extends ViewModel implements MviEntity<StateT> {
    public final Relay<StateT> c;
    @NotNull
    public final Observable<StateT> d;
    @NotNull
    public final SharedScheduler e;
    public Disposable f;
    public final AtomicBoolean g = new AtomicBoolean(false);
    public final ConcurrentHashMap<String, AtomicLong> h = new ConcurrentHashMap<>();
    @NotNull
    public final String i;
    @NotNull
    public final StateT j;
    @NotNull
    public final SchedulersFactory k;

    public static final class a<T> implements SingleOnSubscribe<Boolean> {
        public final /* synthetic */ BaseMviEntity a;

        /* renamed from: com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity$a$a  reason: collision with other inner class name */
        public static final class C0145a extends Lambda implements Function1<StateT, Unit> {
            public final /* synthetic */ a a;
            public final /* synthetic */ CountDownLatch b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0145a(a aVar, CountDownLatch countDownLatch) {
                super(1);
                this.a = aVar;
                this.b = countDownLatch;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "it");
                Logs.verbose$default(this.a.a.getTAG(), a2.b.a.a.a.g("Thread.currentThread()", a2.b.a.a.a.I('['), ']', new StringBuilder(), " initialize() - Reducer Subscribed"), null, 4, null);
                this.b.countDown();
                return Unit.INSTANCE;
            }
        }

        public static final class b<T, R> implements Function<MutatorSingle<StateT>, ObservableSource<? extends Unit>> {
            public final /* synthetic */ a a;

            public b(a aVar) {
                this.a = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // io.reactivex.functions.Function
            public ObservableSource<? extends Unit> apply(Object obj) {
                MutatorSingle mutatorSingle = (MutatorSingle) obj;
                Intrinsics.checkNotNullParameter(mutatorSingle, "<name for destructuring parameter 0>");
                return this.a.a.c.take(1).flatMapSingle(new a2.a.a.o1.b.b.a.b.b(this, mutatorSingle.getName(), mutatorSingle.getBlock())).observeOn(this.a.a.getSchedulerForMutators()).filter(c.a).map(new d(this)).subscribeOn(this.a.a.getSchedulerForMutators());
            }
        }

        public a(BaseMviEntity baseMviEntity) {
            this.a = baseMviEntity;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(@NotNull SingleEmitter<Boolean> singleEmitter) {
            Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
            if (!singleEmitter.isDisposed()) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                BaseMviEntity baseMviEntity = this.a;
                Observable<MutatorSingle<StateT>> mutatorsObservable = baseMviEntity.mutatorsObservable();
                Action action = new Action("Reducer Initializer", new C0145a(this, countDownLatch));
                baseMviEntity.f = mutatorsObservable.mergeWith(Observable.just(new MutatorSingle(action.getName(), new BaseMviEntityKt$toMutatorSingle$2(action)))).observeOn(this.a.getSchedulerForMutators()).concatMap(new b(this)).subscribeOn(this.a.getSchedulerForMutators()).subscribe();
                countDownLatch.await();
                singleEmitter.onSuccess(Boolean.TRUE);
            }
        }
    }

    public BaseMviEntity(@NotNull String str, @NotNull StateT statet, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, "TAG");
        Intrinsics.checkNotNullParameter(statet, "defaultState");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.i = str;
        this.j = statet;
        this.k = schedulersFactory;
        Relay<StateT> serialized = BehaviorRelay.createDefault(statet).toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized, "BehaviorRelay.createDefa…aultValue).toSerialized()");
        this.c = serialized;
        this.d = serialized;
        this.e = new SharedScheduler(schedulersFactory.io());
    }

    public final long generateMutatorId(@NotNull String str) {
        AtomicLong putIfAbsent;
        Intrinsics.checkNotNullParameter(str, "name");
        ConcurrentHashMap<String, AtomicLong> concurrentHashMap = this.h;
        AtomicLong atomicLong = concurrentHashMap.get(str);
        if (atomicLong == null && (putIfAbsent = concurrentHashMap.putIfAbsent(str, (atomicLong = new AtomicLong(0)))) != null) {
            atomicLong = putIfAbsent;
        }
        return atomicLong.getAndIncrement();
    }

    @NotNull
    public final StateT getDefaultState() {
        return this.j;
    }

    @NotNull
    public final SharedScheduler getSchedulerForMutators() {
        return this.e;
    }

    @NotNull
    public final SchedulersFactory getSchedulers() {
        return this.k;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.MviEntity
    @NotNull
    public StateT getStateBlocking() {
        StateT blockingGet = this.c.first(this.j).blockingGet();
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
        return this.i;
    }

    @NotNull
    public final Single<Boolean> initialize() {
        Single single;
        if (this.g.compareAndSet(false, true)) {
            onInitialize();
            single = Single.create(new a(this));
            Intrinsics.checkNotNullExpressionValue(single, "Single.create<Boolean> {…          }\n            }");
        } else {
            single = Singles.toSingle(Boolean.FALSE);
        }
        return a2.b.a.a.a.V1(this.k, single, "if (isInitialized.compar…scribeOn(schedulers.io())");
    }

    @NotNull
    public abstract Observable<MutatorSingle<StateT>> mutatorsObservable();

    @Override // androidx.lifecycle.ViewModel
    @CallSuper
    public void onCleared() {
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f = null;
        this.e.shutdown();
    }

    public void onInitialize() {
    }
}
