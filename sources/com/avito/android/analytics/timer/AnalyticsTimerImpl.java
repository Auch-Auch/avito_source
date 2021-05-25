package com.avito.android.analytics.timer;

import com.avito.android.analytics.timer.AnalyticsTimer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e8\b@\bX\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0011¨\u0006 "}, d2 = {"Lcom/avito/android/analytics/timer/AnalyticsTimerImpl;", "T", "Lcom/avito/android/analytics/timer/AnalyticsTimer;", "", "trackStart", "()V", "result", "trackEnd", "(Ljava/lang/Object;)V", "dispose", "Lio/reactivex/disposables/Disposable;", "c", "Lio/reactivex/disposables/Disposable;", "disposable", "Lio/reactivex/subjects/PublishSubject;", "Lcom/avito/android/analytics/timer/End;", AuthSource.BOOKING_ORDER, "Lio/reactivex/subjects/PublishSubject;", "ends", "Lcom/avito/android/server_time/TimeSource;", "d", "Lcom/avito/android/server_time/TimeSource;", "getTimeSource", "()Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/analytics/timer/Start;", AuthSource.SEND_ABUSE, "starts", "Lcom/avito/android/analytics/timer/AnalyticsTimer$TimingHandler;", "handler", "<init>", "(Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/analytics/timer/AnalyticsTimer$TimingHandler;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class AnalyticsTimerImpl<T> implements AnalyticsTimer<T> {
    public final PublishSubject<Start> a;
    public final PublishSubject<End<T>> b;
    public final Disposable c;
    @NotNull
    public final TimeSource d;

    public static final class a<T1, T2, R> implements BiFunction<Start, End<? extends T>, Pair<? extends Integer, ? extends T>> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.functions.BiFunction
        public Object apply(Start start, Object obj) {
            Start start2 = start;
            End end = (End) obj;
            Intrinsics.checkNotNullParameter(start2, Tracker.Events.CREATIVE_START);
            Intrinsics.checkNotNullParameter(end, "end");
            return TuplesKt.to(Integer.valueOf((int) (end.getTimestamp() - start2.getTimestamp())), end.getResult());
        }
    }

    public static final class b<T> implements Consumer<Pair<? extends Integer, ? extends T>> {
        public final /* synthetic */ AnalyticsTimer.TimingHandler a;

        public b(AnalyticsTimer.TimingHandler timingHandler) {
            this.a = timingHandler;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.avito.android.analytics.timer.AnalyticsTimer$TimingHandler */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
            Pair pair = (Pair) obj;
            this.a.handle(((Number) pair.component1()).intValue(), pair.component2());
        }
    }

    public AnalyticsTimerImpl(@NotNull TimeSource timeSource, @NotNull AnalyticsTimer.TimingHandler<? super T> timingHandler) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(timingHandler, "handler");
        this.d = timeSource;
        PublishSubject<Start> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.a = create;
        PublishSubject<End<T>> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishSubject.create()");
        this.b = create2;
        Disposable subscribe = create.zipWith(create2, a.a).subscribe(new b(timingHandler));
        Intrinsics.checkNotNullExpressionValue(subscribe, "starts.zipWith(ends,\n   …ng, result)\n            }");
        this.c = subscribe;
    }

    @Override // com.avito.android.analytics.timer.AnalyticsTimer
    public void dispose() {
        this.c.dispose();
    }

    @NotNull
    public final TimeSource getTimeSource() {
        return this.d;
    }

    @Override // com.avito.android.analytics.timer.AnalyticsTimer
    public void trackEnd(T t) {
        this.b.onNext(new End<>(this.d.now(), t));
    }

    @Override // com.avito.android.analytics.timer.AnalyticsTimer
    public void trackStart() {
        this.a.onNext(new Start(this.d.now()));
    }
}
