package com.avito.android.analytics.statsd;

import com.avito.android.analytics.Event;
import com.avito.android.analytics.EventObservablesKt;
import com.avito.android.analytics.EventObserver;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/avito/android/analytics/statsd/StatsdEventObserver;", "Lcom/avito/android/analytics/EventObserver;", "Lio/reactivex/Observable;", "Lcom/avito/android/analytics/Event;", "events", "Lkotlin/Function1;", "", "", "onError", "Lio/reactivex/disposables/Disposable;", "observe", "(Lio/reactivex/Observable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/disposables/Disposable;", "Lio/reactivex/Scheduler;", AuthSource.SEND_ABUSE, "Lio/reactivex/Scheduler;", "scheduler", "Lcom/avito/android/analytics/statsd/StatsdEventTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/statsd/StatsdEventTracker;", "tracker", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/analytics/statsd/StatsdEventTracker;Lcom/avito/android/util/SchedulersFactory;)V", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
public class StatsdEventObserver implements EventObserver {
    public final Scheduler a;
    public final StatsdEventTracker b;

    public static final class a<T> implements Consumer<StatsdEvent> {
        public final /* synthetic */ StatsdEventObserver a;

        public a(StatsdEventObserver statsdEventObserver) {
            this.a = statsdEventObserver;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(StatsdEvent statsdEvent) {
            StatsdEvent statsdEvent2 = statsdEvent;
            StatsdEventTracker statsdEventTracker = this.a.b;
            Intrinsics.checkNotNullExpressionValue(statsdEvent2, "event");
            statsdEventTracker.trackEvent(statsdEvent2);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ Function1 a;

        public b(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Function1 function1 = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "throwable");
            function1.invoke(th2);
        }
    }

    public static final class c implements ThreadFactory {
        public static final c a = new c();

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "StatsdEventObserver");
        }
    }

    public StatsdEventObserver(@NotNull StatsdEventTracker statsdEventTracker, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(statsdEventTracker, "tracker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.b = statsdEventTracker;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(c.a);
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "Executors.newSingleThrea… \"StatsdEventObserver\") }");
        this.a = schedulersFactory.from(newSingleThreadExecutor);
    }

    @Override // com.avito.android.analytics.EventObserver
    @NotNull
    public Disposable observe(@NotNull Observable<Event> observable, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(observable, "events");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Observable<U> ofType = observable.ofType(StatsdEvent.class);
        Intrinsics.checkNotNullExpressionValue(ofType, "events.ofType(StatsdEvent::class.java)");
        Disposable subscribe = EventObservablesKt.initialize(ofType, this.b).observeOn(this.a).subscribe(new a(this), new b(function1));
        Intrinsics.checkNotNullExpressionValue(subscribe, "events.ofType(StatsdEven…hrowable) }\n            )");
        return subscribe;
    }
}
