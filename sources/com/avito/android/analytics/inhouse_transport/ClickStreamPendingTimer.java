package com.avito.android.analytics.inhouse_transport;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010#J%\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\r\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/ClickStreamPendingTimer;", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsTimer;", "", "timeInMillis", "Lkotlin/Function0;", "", "onTimeElapsed", "set", "(JLkotlin/jvm/functions/Function0;)V", "reset", "()V", "shutdown", "", "isRunning", "()Z", "Lio/reactivex/disposables/Disposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/Disposable;", "subscription", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "Lio/reactivex/Observable;", "e", "Lio/reactivex/Observable;", "intervalObservable", "c", "J", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lcom/avito/android/util/SchedulersFactory;", "f", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/util/SchedulersFactory;)V", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
public final class ClickStreamPendingTimer implements InHouseAnalyticsTimer {
    public Disposable a;
    public Function0<Unit> b;
    public long c = TimeUnit.SECONDS.toMillis(60);
    public final AtomicBoolean d = new AtomicBoolean(false);
    public Observable<Long> e;
    public final SchedulersFactory f;

    public static final class a<T> implements Consumer<Long> {
        public final /* synthetic */ ClickStreamPendingTimer a;

        public a(ClickStreamPendingTimer clickStreamPendingTimer) {
            this.a = clickStreamPendingTimer;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Long l) {
            Function0 function0 = this.a.b;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ ClickStreamPendingTimer a;

        public b(ClickStreamPendingTimer clickStreamPendingTimer) {
            this.a = clickStreamPendingTimer;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            String simpleName = this.a.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            Logs.error(simpleName, th);
        }
    }

    public static final class c<T> implements Consumer<Long> {
        public final /* synthetic */ ClickStreamPendingTimer a;

        public c(ClickStreamPendingTimer clickStreamPendingTimer) {
            this.a = clickStreamPendingTimer;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Long l) {
            Function0 function0 = this.a.b;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ ClickStreamPendingTimer a;

        public d(ClickStreamPendingTimer clickStreamPendingTimer) {
            this.a = clickStreamPendingTimer;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            String simpleName = this.a.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            Logs.error(simpleName, th);
        }
    }

    @Inject
    public ClickStreamPendingTimer(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.f = schedulersFactory;
        Observable<Long> empty = Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "empty()");
        this.e = empty;
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseAnalyticsTimer
    public boolean isRunning() {
        return this.d.get();
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseAnalyticsTimer
    public void reset() {
        if (this.b != null) {
            Disposable disposable = this.a;
            if (disposable != null) {
                disposable.dispose();
            }
            this.a = this.e.startWith((Observable<Long>) 0L).delay(this.c, TimeUnit.MILLISECONDS).subscribe(new a(this), new b(this));
            this.d.set(true);
        }
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseAnalyticsTimer
    public void set(long j, @NotNull Function0<Unit> function0) {
        Disposable disposable;
        Intrinsics.checkNotNullParameter(function0, "onTimeElapsed");
        if (this.d.get() && (disposable = this.a) != null) {
            disposable.dispose();
        }
        this.d.set(true);
        this.b = function0;
        this.c = j;
        Observable<Long> subscribeOn = Observable.interval(j, j, TimeUnit.MILLISECONDS, this.f.computation()).subscribeOn(this.f.computation());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Observable\n            .…schedulers.computation())");
        this.e = subscribeOn;
        this.a = subscribeOn.subscribe(new c(this), new d(this));
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseAnalyticsTimer
    public void shutdown() {
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d.set(false);
    }
}
