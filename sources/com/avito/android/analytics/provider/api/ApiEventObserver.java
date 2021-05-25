package com.avito.android.analytics.provider.api;

import com.avito.android.analytics.Event;
import com.avito.android.analytics.EventObserver;
import com.avito.android.analytics.remote.AnalyticsApi;
import com.avito.android.remote.auth.AuthSource;
import dagger.Lazy;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0018\u0010\u0019J@\u0010\r\u001a\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/analytics/provider/api/ApiEventObserver;", "Lcom/avito/android/analytics/EventObserver;", "Lio/reactivex/Observable;", "Lcom/avito/android/analytics/Event;", "events", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "throwable", "", "onError", "Lio/reactivex/disposables/Disposable;", "observe", "(Lio/reactivex/Observable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/disposables/Disposable;", "Ldagger/Lazy;", "Lcom/avito/android/analytics/remote/AnalyticsApi;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", "apiLazy", "Lcom/avito/android/analytics/provider/api/ApiEventTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/provider/api/ApiEventTracker;", "tracker", "<init>", "(Lcom/avito/android/analytics/provider/api/ApiEventTracker;Ldagger/Lazy;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class ApiEventObserver implements EventObserver {
    public final ApiEventTracker a;
    public final Lazy<AnalyticsApi> b;

    public static final class a<T> implements Consumer<ApiEvent> {
        public final /* synthetic */ ApiEventObserver a;

        public a(ApiEventObserver apiEventObserver) {
            this.a = apiEventObserver;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ApiEvent apiEvent) {
            ApiEventTracker apiEventTracker = this.a.a;
            Object obj = this.a.b.get();
            Intrinsics.checkNotNullExpressionValue(obj, "apiLazy.get()");
            apiEvent.accept(apiEventTracker, (AnalyticsApi) obj);
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

    public ApiEventObserver(@NotNull ApiEventTracker apiEventTracker, @NotNull Lazy<AnalyticsApi> lazy) {
        Intrinsics.checkNotNullParameter(apiEventTracker, "tracker");
        Intrinsics.checkNotNullParameter(lazy, "apiLazy");
        this.a = apiEventTracker;
        this.b = lazy;
    }

    @Override // com.avito.android.analytics.EventObserver
    @NotNull
    public Disposable observe(@NotNull Observable<Event> observable, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(observable, "events");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Disposable subscribe = observable.ofType(ApiEvent.class).subscribe(new a(this), new b(function1));
        Intrinsics.checkNotNullExpressionValue(subscribe, "events.ofType(ApiEvent::…hrowable) }\n            )");
        return subscribe;
    }
}
