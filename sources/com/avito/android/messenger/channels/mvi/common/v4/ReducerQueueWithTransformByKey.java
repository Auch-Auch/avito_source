package com.avito.android.messenger.channels.mvi.common.v4;

import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueueWithTransformByKey;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004:\u0002()B7\u0012\u0006\u0010!\u001a\u00020\u0015\u0012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"\u0012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010$¢\u0006\u0004\b&\u0010'J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR(\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006*"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueueWithTransformByKey;", "", "StateT", "KeyT", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "value", "", "plusAssign", "(Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;)V", "dispose", "()V", "", "isDisposed", "()Z", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "getStream", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "stream", "Lio/reactivex/Scheduler;", "d", "Lio/reactivex/Scheduler;", "qScheduler", "Lcom/jakewharton/rxrelay2/Relay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/Relay;", "qRelay", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "qDisposable", "scheduler", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueueWithTransformByKey$KeySelector;", "keySelector", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueueWithTransformByKey$Transformer;", "transformer", "<init>", "(Lio/reactivex/Scheduler;Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueueWithTransformByKey$KeySelector;Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueueWithTransformByKey$Transformer;)V", "KeySelector", "Transformer", "mvi_release"}, k = 1, mv = {1, 4, 2})
public final class ReducerQueueWithTransformByKey<StateT, KeyT> implements ReducerQueue<StateT> {
    @NotNull
    public final PublishRelay<Reducible<StateT>> a;
    public final Relay<Reducible<StateT>> b;
    public final CompositeDisposable c;
    public final Scheduler d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\u0004\b\u0003\u0010\u00032\u00020\u0001J\u001f\u0010\u0006\u001a\u0004\u0018\u00018\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueueWithTransformByKey$KeySelector;", "", "StateT", "KeyT", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "reducible", "getKey", "(Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;)Ljava/lang/Object;", "mvi_release"}, k = 1, mv = {1, 4, 2})
    public interface KeySelector<StateT, KeyT> {
        @Nullable
        KeyT getKey(@NotNull Reducible<StateT> reducible);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\u0004\b\u0003\u0010\u00032\u00020\u0001J9\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00060\u00052\b\u0010\u0004\u001a\u0004\u0018\u00018\u00032\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00060\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueueWithTransformByKey$Transformer;", "", "StateT", "KeyT", "key", "Lio/reactivex/Observable;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "obs", "transform", "(Ljava/lang/Object;Lio/reactivex/Observable;)Lio/reactivex/Observable;", "mvi_release"}, k = 1, mv = {1, 4, 2})
    public interface Transformer<StateT, KeyT> {
        @NotNull
        Observable<Reducible<StateT>> transform(@Nullable KeyT keyt, @NotNull Observable<Reducible<StateT>> observable);
    }

    public static final class a<T> implements Consumer<Reducible<StateT>> {
        public final /* synthetic */ ReducerQueueWithTransformByKey a;

        public a(ReducerQueueWithTransformByKey reducerQueueWithTransformByKey) {
            this.a = reducerQueueWithTransformByKey;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
            ((Reducible) obj).sendToReducer(this.a.getStream());
        }
    }

    public ReducerQueueWithTransformByKey(@NotNull Scheduler scheduler, @NotNull KeySelector<StateT, KeyT> keySelector, @NotNull Transformer<StateT, KeyT> transformer) {
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        PublishRelay<Reducible<StateT>> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        Relay<Reducible<StateT>> J1 = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
        this.b = J1;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.c = compositeDisposable;
        SharedScheduler sharedScheduler = new SharedScheduler(scheduler);
        compositeDisposable.add(Disposables.fromAction(new Action() { // from class: com.avito.android.messenger.channels.mvi.common.v4.ReducerQueueWithTransformByKey$inlined$sam$i$io_reactivex_functions_Action$0
            @Override // io.reactivex.functions.Action
            public final /* synthetic */ void run() {
                Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
            }
        }));
        this.d = sharedScheduler;
        Observable<Reducible<StateT>> observeOn = J1.observeOn(sharedScheduler);
        Intrinsics.checkNotNullExpressionValue(observeOn, "qRelay.observeOn(qScheduler)");
        Observable<R> flatMap = observeOn.groupBy(new Function<Reducible<StateT>, KeyT>(keySelector) { // from class: com.avito.android.messenger.channels.mvi.common.v4.ReducerQueueWithTransformByKey$$special$$inlined$transformByKey$1
            public final /* synthetic */ ReducerQueueWithTransformByKey.KeySelector a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function
            @Nullable
            public final KeyT apply(@NotNull Reducible<StateT> reducible) {
                Intrinsics.checkNotNullParameter(reducible, "event");
                return (KeyT) this.a.getKey(reducible);
            }
        }).flatMap(new Function<GroupedObservable<KeyT, Reducible<StateT>>, ObservableSource<? extends Reducible<StateT>>>(transformer) { // from class: com.avito.android.messenger.channels.mvi.common.v4.ReducerQueueWithTransformByKey$$special$$inlined$transformByKey$2
            public final /* synthetic */ ReducerQueueWithTransformByKey.Transformer a;

            {
                this.a = r1;
            }

            public final ObservableSource<? extends Reducible<StateT>> apply(@NotNull GroupedObservable<KeyT, Reducible<StateT>> groupedObservable) {
                Intrinsics.checkNotNullParameter(groupedObservable, "groupedObs");
                return this.a.transform(groupedObservable.getKey(), groupedObservable);
            }

            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((GroupedObservable) ((GroupedObservable) obj));
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "groupBy { event ->\n     …bs.key, groupedObs)\n    }");
        Disposable subscribe = flatMap.observeOn(sharedScheduler).subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "qRelay.observeOn(qSchedu…cer(stream)\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.c.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue
    public void plusAssign(@NotNull Reducible<StateT> reducible) {
        Intrinsics.checkNotNullParameter(reducible, "value");
        this.b.accept(reducible);
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue
    @NotNull
    public PublishRelay<Reducible<StateT>> getStream() {
        return this.a;
    }
}
