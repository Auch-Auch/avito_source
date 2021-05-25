package com.avito.android.messenger.channels.mvi.common.v3;

import com.avito.android.messenger.channels.mvi.common.v3.BaseEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.rx.concurrent.RxExecutor;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.jakewharton.rxrelay2.Relay;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.y;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B-\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u0014\b\u0002\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!0 ¢\u0006\u0004\b#\u0010$J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/EventQueue;", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEvent;", "EventT", "Lio/reactivex/disposables/Disposable;", "event", "", ProductAction.ACTION_ADD, "(Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEvent;)V", "", "isDisposed", "()Z", "dispose", "()V", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/util/rx/concurrent/RxExecutor;", "c", "Lcom/avito/android/util/rx/concurrent/RxExecutor;", "queueExecutor", "Lcom/jakewharton/rxrelay2/Relay;", "d", "Lcom/jakewharton/rxrelay2/Relay;", "eventStream", "Ljava/util/LinkedList;", AuthSource.BOOKING_ORDER, "Ljava/util/LinkedList;", "queue", "Lio/reactivex/Scheduler;", "queueOperationsScheduler", "handlersScheduler", "", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEffect;", "effects", "<init>", "(Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;Ljava/util/Set;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public final class EventQueue<EventT extends BaseEvent> implements Disposable {
    public final CompositeDisposable a;
    public final LinkedList<EventT> b;
    public final RxExecutor c;
    public final Relay<EventT> d;

    public static final class a<T, R> implements Function<EventT, CompletableSource> {
        public final /* synthetic */ EventQueue a;
        public final /* synthetic */ Relay b;

        public a(EventQueue eventQueue, Relay relay) {
            this.a = eventQueue;
            this.b = relay;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(Object obj) {
            BaseEvent baseEvent = (BaseEvent) obj;
            Intrinsics.checkNotNullParameter(baseEvent, "event");
            return baseEvent.handle().doOnComplete(new a2.a.a.o1.b.b.a.c.a(this, baseEvent));
        }
    }

    public static final class b<T, R> implements Function<Observable<EventT>, ObservableSource<Unit>> {
        public final /* synthetic */ Set a;

        public b(Set set) {
            this.a = set;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // io.reactivex.functions.Function
        public ObservableSource<Unit> apply(Object obj) {
            Observable<EventT> observable = (Observable) obj;
            Intrinsics.checkNotNullParameter(observable, "handledEventObservable");
            Set<T> set = this.a;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(set, 10));
            for (T t : set) {
                arrayList.add(t.reactTo(observable));
            }
            return Observable.merge(arrayList);
        }
    }

    public static final class c<T, R> implements Function<EventT, CompletableSource> {
        public final /* synthetic */ EventQueue a;

        public c(EventQueue eventQueue) {
            this.a = eventQueue;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(Object obj) {
            BaseEvent baseEvent = (BaseEvent) obj;
            Intrinsics.checkNotNullParameter(baseEvent, "event");
            return baseEvent.handle().doOnComplete(new a2.a.a.o1.b.b.a.c.b(this, baseEvent));
        }
    }

    public EventQueue(@NotNull Scheduler scheduler, @NotNull Scheduler scheduler2, @NotNull Set<? extends BaseEffect<EventT>> set) {
        Intrinsics.checkNotNullParameter(scheduler, "queueOperationsScheduler");
        Intrinsics.checkNotNullParameter(scheduler2, "handlersScheduler");
        Intrinsics.checkNotNullParameter(set, "effects");
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.a = compositeDisposable;
        this.b = new LinkedList<>();
        RxExecutor rxExecutor = new RxExecutor(new SharedScheduler(scheduler));
        DisposableKt.addTo(rxExecutor, compositeDisposable);
        this.c = rxExecutor;
        Relay<EventT> J1 = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
        this.d = J1;
        if (!set.isEmpty()) {
            Relay J12 = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
            Disposable subscribe = J1.observeOn(scheduler2).flatMapCompletable(new a(this, J12)).subscribe();
            Intrinsics.checkNotNullExpressionValue(subscribe, "eventStream\n            …             .subscribe()");
            DisposableKt.addTo(subscribe, compositeDisposable);
            Disposable subscribe2 = J12.publish(new b(set)).subscribe();
            Intrinsics.checkNotNullExpressionValue(subscribe2, "handledEventStream\n     …             .subscribe()");
            DisposableKt.addTo(subscribe2, compositeDisposable);
            return;
        }
        Disposable subscribe3 = J1.observeOn(scheduler2).flatMapCompletable(new c(this)).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe3, "eventStream\n            …             .subscribe()");
        DisposableKt.addTo(subscribe3, compositeDisposable);
    }

    public static final void access$remove(EventQueue eventQueue, BaseEvent baseEvent) {
        eventQueue.c.execute(new Runnable(baseEvent) { // from class: com.avito.android.messenger.channels.mvi.common.v3.EventQueue$remove$$inlined$invoke$1
            public final /* synthetic */ BaseEvent b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                EventQueue.this.b.remove(this.b);
            }
        });
    }

    public final void add(@NotNull EventT eventt) {
        Intrinsics.checkNotNullParameter(eventt, "event");
        this.c.execute(new Runnable(this, eventt) { // from class: com.avito.android.messenger.channels.mvi.common.v3.EventQueue$add$$inlined$invoke$1
            public final /* synthetic */ EventQueue a;
            public final /* synthetic */ BaseEvent b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b.add(this.b);
                this.a.d.accept(this.b);
            }
        });
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.a.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.a.isDisposed();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EventQueue(Scheduler scheduler, Scheduler scheduler2, Set set, int i, j jVar) {
        this(scheduler, scheduler2, (i & 4) != 0 ? y.emptySet() : set);
    }
}
