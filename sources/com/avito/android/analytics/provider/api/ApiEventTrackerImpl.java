package com.avito.android.analytics.provider.api;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/analytics/provider/api/ApiEventTrackerImpl;", "Lcom/avito/android/analytics/provider/api/ApiEventTracker;", "Lio/reactivex/Observable;", "", "apiMethod", "trackEvent", "(Lio/reactivex/Observable;)V", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/util/SchedulersFactory;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class ApiEventTrackerImpl implements ApiEventTracker {
    public final SchedulersFactory a;

    public static final class a<T, R> implements Function<Throwable, Unit> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return Unit.INSTANCE;
        }
    }

    public ApiEventTrackerImpl(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = schedulersFactory;
    }

    @Override // com.avito.android.analytics.provider.api.ApiEventTracker
    public void trackEvent(@NotNull Observable<Unit> observable) {
        Intrinsics.checkNotNullParameter(observable, "apiMethod");
        observable.subscribeOn(this.a.io()).onErrorReturn(a.a).subscribe();
    }
}
