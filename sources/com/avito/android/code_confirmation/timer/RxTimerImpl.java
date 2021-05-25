package com.avito.android.code_confirmation.timer;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/code_confirmation/timer/RxTimerImpl;", "Lcom/avito/android/code_confirmation/timer/RxTimer;", "", "stopTime", "Lio/reactivex/Observable;", Tracker.Events.CREATIVE_START, "(J)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", AuthSource.SEND_ABUSE, "J", "period", "<init>", "(Lcom/avito/android/util/SchedulersFactory;)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class RxTimerImpl implements RxTimer {
    public final long a = 300;
    public final SchedulersFactory b;

    public static final class a<T, R> implements Function<Long, Long> {
        public final /* synthetic */ RxTimerImpl a;
        public final /* synthetic */ long b;

        public a(RxTimerImpl rxTimerImpl, long j) {
            this.a = rxTimerImpl;
            this.b = j;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Long apply(Long l) {
            Intrinsics.checkNotNullParameter(l, "it");
            return Long.valueOf(this.b - RxTimerImpl.access$getCurrentTime$p(this.a));
        }
    }

    public static final class b<T> implements Predicate<Long> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Long l) {
            Long l2 = l;
            Intrinsics.checkNotNullParameter(l2, "it");
            return l2.longValue() > 0;
        }
    }

    @Inject
    public RxTimerImpl(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.b = schedulersFactory;
    }

    public static final long access$getCurrentTime$p(RxTimerImpl rxTimerImpl) {
        Objects.requireNonNull(rxTimerImpl);
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
        return instance.getTimeInMillis();
    }

    @Override // com.avito.android.code_confirmation.timer.RxTimer
    @NotNull
    public Observable<Long> start(long j) {
        Observable<R> observable = Observable.interval(this.a, TimeUnit.MILLISECONDS).subscribeOn(this.b.computation()).startWith((Observable<Long>) 0L).toFlowable(BackpressureStrategy.DROP).map(new a(this, j)).takeWhile(b.a).toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "Observable.interval(peri…          .toObservable()");
        return observable;
    }
}
