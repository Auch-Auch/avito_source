package com.avito.android.analytics.provider.pixel;

import com.avito.android.analytics.Event;
import com.avito.android.analytics.EventObserver;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/analytics/provider/pixel/PixelEventObserver;", "Lcom/avito/android/analytics/EventObserver;", "Lio/reactivex/Observable;", "Lcom/avito/android/analytics/Event;", "events", "Lkotlin/Function1;", "", "", "onError", "Lio/reactivex/disposables/Disposable;", "observe", "(Lio/reactivex/Observable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/disposables/Disposable;", "Lcom/avito/android/analytics/provider/pixel/PixelEventTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/provider/pixel/PixelEventTracker;", "tracker", "<init>", "(Lcom/avito/android/analytics/provider/pixel/PixelEventTracker;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public class PixelEventObserver implements EventObserver {
    public final PixelEventTracker a;

    public static final class a<T> implements Consumer<PixelEvent> {
        public final /* synthetic */ PixelEventObserver a;

        public a(PixelEventObserver pixelEventObserver) {
            this.a = pixelEventObserver;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(PixelEvent pixelEvent) {
            pixelEvent.accept(this.a.a);
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

    @Inject
    public PixelEventObserver(@NotNull PixelEventTracker pixelEventTracker) {
        Intrinsics.checkNotNullParameter(pixelEventTracker, "tracker");
        this.a = pixelEventTracker;
    }

    @Override // com.avito.android.analytics.EventObserver
    @NotNull
    public Disposable observe(@NotNull Observable<Event> observable, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(observable, "events");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Disposable subscribe = observable.ofType(PixelEvent.class).subscribe(new a(this), new b(function1));
        Intrinsics.checkNotNullExpressionValue(subscribe, "events\n                .…able) }\n                )");
        return subscribe;
    }
}
