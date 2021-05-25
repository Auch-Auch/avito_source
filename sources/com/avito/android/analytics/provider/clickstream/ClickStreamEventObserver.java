package com.avito.android.analytics.provider.clickstream;

import com.avito.android.ClickstreamToggles;
import com.avito.android.analytics.ErrorEvent;
import com.avito.android.analytics.ErrorSummary;
import com.avito.android.analytics.Event;
import com.avito.android.analytics.EventObserver;
import com.avito.android.analytics.clickstream.ClickStreamEventTracker;
import com.avito.android.analytics.clickstream.event.ClickstreamFatalEvent;
import com.avito.android.analytics.clickstream.event.ClickstreamNonFatalEvent;
import com.avito.android.analytics.clickstream.event.OldClickstreamNonFatalEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ1\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/avito/android/analytics/provider/clickstream/ClickStreamEventObserver;", "Lcom/avito/android/analytics/EventObserver;", "Lio/reactivex/Observable;", "Lcom/avito/android/analytics/Event;", "events", "Lkotlin/Function1;", "", "", "onError", "Lio/reactivex/disposables/Disposable;", "observe", "(Lio/reactivex/Observable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/disposables/Disposable;", "Lcom/avito/android/ClickstreamToggles;", "c", "Lcom/avito/android/ClickstreamToggles;", "features", "Lio/reactivex/Scheduler;", AuthSource.SEND_ABUSE, "Lio/reactivex/Scheduler;", "scheduler", "Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker;", "tracker", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker;Lcom/avito/android/ClickstreamToggles;Lcom/avito/android/util/SchedulersFactory;)V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public class ClickStreamEventObserver implements EventObserver {
    public final Scheduler a;
    public final ClickStreamEventTracker b;
    public final ClickstreamToggles c;

    public static final class a<T> implements Consumer<ClickStreamEvent> {
        public final /* synthetic */ ClickStreamEventObserver a;

        public a(ClickStreamEventObserver clickStreamEventObserver) {
            this.a = clickStreamEventObserver;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ClickStreamEvent clickStreamEvent) {
            ClickStreamEvent clickStreamEvent2 = clickStreamEvent;
            ClickStreamEventTracker clickStreamEventTracker = this.a.b;
            Intrinsics.checkNotNullExpressionValue(clickStreamEvent2, "event");
            clickStreamEventTracker.trackEvent(clickStreamEvent2);
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
            return new Thread(runnable, "ClickStreamEventObserver");
        }
    }

    public ClickStreamEventObserver(@NotNull ClickStreamEventTracker clickStreamEventTracker, @NotNull ClickstreamToggles clickstreamToggles, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(clickStreamEventTracker, "tracker");
        Intrinsics.checkNotNullParameter(clickstreamToggles, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.b = clickStreamEventTracker;
        this.c = clickstreamToggles;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(c.a);
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "Executors.newSingleThrea…ckStreamEventObserver\") }");
        this.a = schedulersFactory.from(newSingleThreadExecutor);
    }

    public static final ClickStreamEvent access$convertErrorEvent(ClickStreamEventObserver clickStreamEventObserver, ErrorEvent errorEvent) {
        Objects.requireNonNull(clickStreamEventObserver);
        ErrorSummary summary = errorEvent.getSummary();
        Throwable error = summary.getError();
        if (error == null) {
            return null;
        }
        if (summary.getType() != 1 || !clickStreamEventObserver.c.getReportNonFatalsToClickstream().invoke().booleanValue()) {
            if (summary.getType() == 2) {
                return new ClickstreamFatalEvent(error);
            }
            return null;
        } else if (clickStreamEventObserver.c.getSendNonfatalWithStacktrace().invoke().booleanValue()) {
            return new ClickstreamNonFatalEvent(error, summary.getMessage());
        } else {
            return new OldClickstreamNonFatalEvent(error, summary.getMessage());
        }
    }

    @Override // com.avito.android.analytics.EventObserver
    @NotNull
    public Disposable observe(@NotNull Observable<Event> observable, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(observable, "events");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Observable<U> ofType = observable.ofType(ClickStreamEvent.class);
        Observable<R> map = observable.ofType(ErrorEvent.class).map(new a2.a.a.i.h.a.a(this)).filter(a2.a.a.i.h.a.b.a).map(a2.a.a.i.h.a.c.a);
        Intrinsics.checkNotNullExpressionValue(map, "ofType(ErrorEvent::class…        .map { it.get() }");
        Disposable subscribe = ofType.mergeWith(map).observeOn(this.a).subscribe(new a(this), new b(function1));
        Intrinsics.checkNotNullExpressionValue(subscribe, "events.ofType(ClickStrea…hrowable) }\n            )");
        return subscribe;
    }
}
