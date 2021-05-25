package com.avito.android.messenger.channels.mvi.common.v3;

import a2.b.a.a.a;
import a2.g.r.g;
import android.annotation.SuppressLint;
import androidx.annotation.CallSuper;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.channels.mvi.common.v3.BaseEntityDeps;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.Singles;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u0001*\b\b\u0002\u0010\u0004*\u00028\u0003*\b\b\u0003\u0010\u0005*\u00020\u0001*\u000e\b\u0004\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00010\u00062\u00020\b2\b\u0012\u0004\u0012\u00028\u00030\tB=\u0012\u0006\u0010F\u001a\u00020A\u0012\u0006\u0010X\u001a\u00028\u0002\u0012\u001c\u0010Z\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0002\b\u0003050Y\u0012\u0006\u0010\u0013\u001a\u00028\u0004¢\u0006\u0004\b[\u0010\\J!\u0010\f\u001a\u00028\u0002*\u00028\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\nH&¢\u0006\u0004\b\f\u0010\rJq\u0010\u0017\u001a\u00020\u0016*`\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0015\b\u0000\u0012\u00118\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0006\b\u0000\u0012\u00028\u00040\u00140\u000ej\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0006\b\u0000\u0012\u00028\u0004`\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0015¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0013\u001a\u00028\u00048\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\u00020\u001f8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R1\u0010*\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00140%8B@\u0002X\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010-\u001a\u00028\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\"\u00103\u001a\b\u0012\u0004\u0012\u00028\u00020.8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R,\u00108\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0002\b\u000305048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R(\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00030.8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b9\u00100\u0012\u0004\b;\u0010\u001a\u001a\u0004\b:\u00102R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0019\u0010F\u001a\u00020A8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER6\u0010L\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00140G0\n8\u0014@\u0014X\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001c\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u001c\u0010X\u001a\u00028\u00028\u0004@\u0004X\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010,¨\u0006]"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/BaseMviEntityWithEvents;", "", "EventT", "PartialStateT", "AggregatedStateT", "ViewStateT", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEntityDeps;", "DepsT", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "", "partialStates", "applyPartialStates", "(Ljava/lang/Object;Ljava/util/Set;)Ljava/lang/Object;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "id", "deps", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventDispatchable;", "", "dispatchCommand", "(Lkotlin/jvm/functions/Function2;)V", "onCleared", "()V", "n", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEntityDeps;", "getDeps", "()Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEntityDeps;", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventQueue;", "f", "Lkotlin/Lazy;", "getEventQueue", "()Lcom/avito/android/messenger/channels/mvi/common/v3/EventQueue;", "eventQueue", "getStateBlocking", "()Ljava/lang/Object;", "stateBlocking", "Lio/reactivex/Observable;", "j", "Lio/reactivex/Observable;", "getInternalStateObservable", "()Lio/reactivex/Observable;", "internalStateObservable", "Lcom/avito/android/messenger/channels/mvi/common/v3/CommandQueue;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventCommand;", "e", "Lcom/avito/android/messenger/channels/mvi/common/v3/CommandQueue;", "commandQueue", "i", "getStateObservable", "getStateObservable$annotations", "stateObservable", "Ljava/util/concurrent/atomic/AtomicLong;", g.a, "Ljava/util/concurrent/atomic/AtomicLong;", "eventId", "", "l", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEffect;", "c", "Ljava/util/Set;", "getEffects", "()Ljava/util/Set;", "effects", "Ljava/util/concurrent/atomic/AtomicBoolean;", "k", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitialized", "Lcom/jakewharton/rxrelay2/Relay;", "h", "Lcom/jakewharton/rxrelay2/Relay;", "stateRelay", AuthSource.OPEN_CHANNEL_LIST, "Ljava/lang/Object;", "getDefaultState", "defaultState", "Lcom/avito/android/messenger/channels/mvi/common/v3/ShouldCancelChecker;", "commandCancelChecker", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Lcom/avito/android/messenger/channels/mvi/common/v3/ShouldCancelChecker;Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEntityDeps;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseMviEntityWithEvents<EventT, PartialStateT, AggregatedStateT extends ViewStateT, ViewStateT, DepsT extends BaseEntityDeps<PartialStateT>> extends ViewModel implements MviEntity<ViewStateT> {
    @NotNull
    public final Set<BaseEffect<EventInstance<EventT, ?, ?>>> c = y.emptySet();
    @NotNull
    public final CompositeDisposable d;
    public final CommandQueue<EventCommand<? extends EventT, ?, ?>> e;
    public final Lazy f;
    public final AtomicLong g;
    public final Relay<AggregatedStateT> h;
    @NotNull
    public final Observable<ViewStateT> i;
    @NotNull
    public final Observable<AggregatedStateT> j;
    public final AtomicBoolean k;
    @NotNull
    public final String l;
    @NotNull
    public final AggregatedStateT m;
    @NotNull
    public final DepsT n;

    public static final class a extends Lambda implements Function0<EventQueue<EventInstance<EventT, ?, ?>>> {
        public final /* synthetic */ BaseMviEntityWithEvents a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BaseMviEntityWithEvents baseMviEntityWithEvents) {
            super(0);
            this.a = baseMviEntityWithEvents;
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            EventQueue eventQueue = new EventQueue(this.a.getDeps().getSchedulers().io(), this.a.getDeps().getSchedulers().io(), this.a.getEffects());
            DisposableKt.addTo(eventQueue, this.a.getDisposables());
            return eventQueue;
        }
    }

    public BaseMviEntityWithEvents(@NotNull String str, @NotNull AggregatedStateT aggregatedstatet, @NotNull ShouldCancelChecker<EventCommand<? extends EventT, ?, ?>> shouldCancelChecker, @NotNull DepsT depst) {
        Intrinsics.checkNotNullParameter(str, "TAG");
        Intrinsics.checkNotNullParameter(aggregatedstatet, "defaultState");
        Intrinsics.checkNotNullParameter(shouldCancelChecker, "commandCancelChecker");
        Intrinsics.checkNotNullParameter(depst, "deps");
        this.l = str;
        this.m = aggregatedstatet;
        this.n = depst;
        CompositeDisposable compositeDisposable = new CompositeDisposable(depst);
        this.d = compositeDisposable;
        CommandQueue<EventCommand<? extends EventT, ?, ?>> commandQueue = new CommandQueue<>(depst.getSchedulers().io(), shouldCancelChecker);
        DisposableKt.addTo(commandQueue, compositeDisposable);
        Unit unit = Unit.INSTANCE;
        this.e = commandQueue;
        this.f = c.lazy(new a(this));
        this.g = new AtomicLong(0);
        Relay<AggregatedStateT> serialized = BehaviorRelay.createDefault(aggregatedstatet).toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized, "BehaviorRelay.createDefa…aultValue).toSerialized()");
        this.h = serialized;
        Objects.requireNonNull(serialized, "null cannot be cast to non-null type io.reactivex.Observable<ViewStateT>");
        this.i = serialized;
        this.j = serialized;
        this.k = new AtomicBoolean(false);
    }

    public static final EventQueue access$getEventQueue$p(BaseMviEntityWithEvents baseMviEntityWithEvents) {
        return (EventQueue) baseMviEntityWithEvents.f.getValue();
    }

    public static /* synthetic */ void getStateObservable$annotations() {
    }

    @NotNull
    public abstract AggregatedStateT applyPartialStates(@NotNull AggregatedStateT aggregatedstatet, @NotNull Set<? extends PartialStateT> set);

    @SuppressLint({"CheckResult"})
    @VisibleForTesting(otherwise = 4)
    public final void dispatchCommand(@NotNull Function2<? super Long, ? super DepsT, ? extends EventInstance<EventT, PartialStateT, ? super DepsT>> function2) {
        Single single;
        Intrinsics.checkNotNullParameter(function2, "$this$dispatchCommand");
        EventInstance eventInstance = (EventInstance) function2.invoke(Long.valueOf(this.g.getAndIncrement()), this.n);
        if (this.k.compareAndSet(false, true)) {
            single = Single.create(new BaseMviEntityWithEvents$initialize$1(this));
            Intrinsics.checkNotNullExpressionValue(single, "Single.create<Boolean> {…          }\n            }");
        } else {
            single = Singles.toSingle(Boolean.FALSE);
        }
        Single subscribeOn = single.subscribeOn(this.n.getSchedulers().io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "if (isInitialized.compar…eOn(deps.schedulers.io())");
        subscribeOn.blockingGet();
        this.e.add(new EventCommand<EventT, PartialStateT, DepsT>(this, eventInstance, eventInstance.getTypeObj(), eventInstance.getId(), eventInstance.getParamsString(), this.n) { // from class: com.avito.android.messenger.channels.mvi.common.v3.BaseMviEntityWithEvents$dispatchCommand$command$1
            public final /* synthetic */ BaseMviEntityWithEvents e;
            public final /* synthetic */ EventInstance f;

            {
                this.e = r7;
                this.f = r8;
            }

            @Override // kotlin.jvm.functions.Function0
            public void invoke() {
                String tag = this.e.getTAG();
                StringBuilder sb = new StringBuilder();
                StringBuilder I = a.I('[');
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                I.append(currentThread.getName());
                I.append(']');
                sb.append(I.toString());
                sb.append(" Executing ");
                sb.append(this);
                Logs.verbose$default(tag, sb.toString(), null, 4, null);
                BaseMviEntityWithEvents.access$getEventQueue$p(this.e).add(this.f);
            }
        });
    }

    @NotNull
    public final AggregatedStateT getDefaultState() {
        return this.m;
    }

    @NotNull
    public final DepsT getDeps() {
        return this.n;
    }

    @NotNull
    public final CompositeDisposable getDisposables() {
        return this.d;
    }

    @NotNull
    public Set<BaseEffect<EventInstance<EventT, ?, ?>>> getEffects() {
        return this.c;
    }

    @NotNull
    public final Observable<AggregatedStateT> getInternalStateObservable() {
        return this.j;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.MviEntity
    @NotNull
    public ViewStateT getStateBlocking() {
        ViewStateT blockingFirst = getStateObservable().blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "stateObservable.blockingFirst()");
        return blockingFirst;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.MviEntity
    @NotNull
    public Observable<ViewStateT> getStateObservable() {
        return this.i;
    }

    @NotNull
    public final String getTAG() {
        return this.l;
    }

    @Override // androidx.lifecycle.ViewModel
    @CallSuper
    public void onCleared() {
        this.d.dispose();
        super.onCleared();
    }
}
