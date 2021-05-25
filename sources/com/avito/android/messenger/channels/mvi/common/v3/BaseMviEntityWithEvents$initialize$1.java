package com.avito.android.messenger.channels.mvi.common.v3;

import a2.b.a.a.a;
import com.avito.android.util.Logs;
import com.avito.android.util.Singles;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000e\u001a\u00020\u000b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00028\u0003\"\b\b\u0003\u0010\u0004*\u00020\u0000\"\u000e\b\u0004\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00010\u00052\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007H\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"", "EventT", "PartialStateT", "AggregatedStateT", "ViewStateT", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEntityDeps;", "DepsT", "Lio/reactivex/SingleEmitter;", "", "kotlin.jvm.PlatformType", "emitter", "", "subscribe", "(Lio/reactivex/SingleEmitter;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class BaseMviEntityWithEvents$initialize$1<T> implements SingleOnSubscribe<Boolean> {
    public final /* synthetic */ BaseMviEntityWithEvents a;

    public BaseMviEntityWithEvents$initialize$1(BaseMviEntityWithEvents baseMviEntityWithEvents) {
        this.a = baseMviEntityWithEvents;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(@NotNull SingleEmitter<Boolean> singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        if (!singleEmitter.isDisposed()) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            Scheduler io2 = this.a.getDeps().getSchedulers().io();
            CompositeDisposable disposables = this.a.getDisposables();
            final SharedScheduler sharedScheduler = new SharedScheduler(io2);
            disposables.add(Disposables.fromAction(new Action() { // from class: com.avito.android.messenger.channels.mvi.common.v3.BaseMviEntityWithEvents$initialize$1$inlined$sam$i$io_reactivex_functions_Action$0
                @Override // io.reactivex.functions.Action
                public final /* synthetic */ void run() {
                    Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
                }
            }));
            Disposable subscribe = this.a.getDeps().getPartialStatesStream().mergeWith(Observable.fromCallable(new Callable<Set<? extends PartialStateT>>(this) { // from class: com.avito.android.messenger.channels.mvi.common.v3.BaseMviEntityWithEvents$initialize$1.1
                public final /* synthetic */ BaseMviEntityWithEvents$initialize$1 a;

                {
                    this.a = r1;
                }

                @Override // java.util.concurrent.Callable
                public final Set<PartialStateT> call() {
                    Logs.verbose$default(this.a.a.getTAG(), a.g("Thread.currentThread()", a.I('['), ']', new StringBuilder(), " initialize() - State Aggregator Subscribed"), null, 4, null);
                    countDownLatch.countDown();
                    return y.emptySet();
                }
            })).observeOn(sharedScheduler).concatMap(new Function<Set<? extends PartialStateT>, ObservableSource<? extends Unit>>(this) { // from class: com.avito.android.messenger.channels.mvi.common.v3.BaseMviEntityWithEvents$initialize$1.2
                public final /* synthetic */ BaseMviEntityWithEvents$initialize$1 a;

                {
                    this.a = r1;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // io.reactivex.functions.Function
                public /* bridge */ /* synthetic */ ObservableSource<? extends Unit> apply(Object obj) {
                    return apply((Set) ((Set) obj));
                }

                public final ObservableSource<? extends Unit> apply(@NotNull final Set<? extends PartialStateT> set) {
                    Intrinsics.checkNotNullParameter(set, "newPartialStates");
                    return this.a.a.h.take(1).flatMapSingle(new Function<AggregatedStateT, SingleSource<? extends Pair<? extends AggregatedStateT, ? extends AggregatedStateT>>>(this) { // from class: com.avito.android.messenger.channels.mvi.common.v3.BaseMviEntityWithEvents.initialize.1.2.1
                        public final /* synthetic */ AnonymousClass2 a;

                        {
                            this.a = r1;
                        }

                        @Override // io.reactivex.functions.Function
                        public final SingleSource<? extends Pair<AggregatedStateT, AggregatedStateT>> apply(@NotNull AggregatedStateT aggregatedstatet) {
                            Intrinsics.checkNotNullParameter(aggregatedstatet, "prevAgState");
                            String tag = this.a.a.a.getTAG();
                            StringBuilder sb = new StringBuilder();
                            a.f1("Thread.currentThread()", a.I('['), ']', sb, " New Partial States: ");
                            sb.append(set);
                            Logs.debug$default(tag, sb.toString(), null, 4, null);
                            BaseMviEntityWithEvents baseMviEntityWithEvents = this.a.a.a;
                            Set set2 = set;
                            Intrinsics.checkNotNullExpressionValue(set2, "newPartialStates");
                            return Singles.toSingle(TuplesKt.to(aggregatedstatet, baseMviEntityWithEvents.applyPartialStates(aggregatedstatet, set2)));
                        }
                    }).observeOn(sharedScheduler).filter(AnonymousClass2.INSTANCE).map(new Function<Pair<? extends AggregatedStateT, ? extends AggregatedStateT>, Unit>(this) { // from class: com.avito.android.messenger.channels.mvi.common.v3.BaseMviEntityWithEvents.initialize.1.2.3
                        public final /* synthetic */ AnonymousClass2 a;

                        {
                            this.a = r1;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // io.reactivex.functions.Function
                        public /* bridge */ /* synthetic */ Unit apply(Object obj) {
                            apply((Pair) ((Pair) obj));
                            return Unit.INSTANCE;
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.jakewharton.rxrelay2.Relay */
                        /* JADX WARN: Multi-variable type inference failed */
                        public final void apply(@NotNull Pair<? extends AggregatedStateT, ? extends AggregatedStateT> pair) {
                            Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
                            Object component2 = pair.component2();
                            String tag = this.a.a.a.getTAG();
                            StringBuilder sb = new StringBuilder();
                            StringBuilder I = a.I('[');
                            Thread currentThread = Thread.currentThread();
                            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                            I.append(currentThread.getName());
                            I.append(']');
                            sb.append(I.toString());
                            sb.append(" New Aggregated State: ");
                            sb.append(component2);
                            Logs.info$default(tag, sb.toString(), null, 4, null);
                            this.a.a.a.h.accept(component2);
                        }
                    }).subscribeOn(sharedScheduler);
                }
            }).subscribeOn(sharedScheduler).subscribe();
            Intrinsics.checkNotNullExpressionValue(subscribe, "deps.partialStatesStream…             .subscribe()");
            DisposableKt.addTo(subscribe, this.a.getDisposables());
            countDownLatch.await();
            singleEmitter.onSuccess(Boolean.TRUE);
        }
    }
}
