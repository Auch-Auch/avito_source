package com.avito.android.analytics.provider.pixel;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Response;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/analytics/provider/pixel/PixelInteractorImpl;", "Lcom/avito/android/analytics/provider/pixel/PixelInteractor;", "", "", "queryMap", "Lio/reactivex/Observable;", "", "sendAd", "(Ljava/util/Map;)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/analytics/provider/pixel/PixelApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/provider/pixel/PixelApi;", "pixelApi", "<init>", "(Lcom/avito/android/analytics/provider/pixel/PixelApi;Lcom/avito/android/util/SchedulersFactory;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class PixelInteractorImpl implements PixelInteractor {
    public final PixelApi a;
    public final SchedulersFactory b;

    public static final class a<T, R> implements Function<Response<ResponseBody>, Unit> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(Response<ResponseBody> response) {
            Intrinsics.checkNotNullParameter(response, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class b<T, R> implements Function<Throwable, Unit> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return Unit.INSTANCE;
        }
    }

    @Inject
    public PixelInteractorImpl(@NotNull PixelApi pixelApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(pixelApi, "pixelApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = pixelApi;
        this.b = schedulersFactory;
    }

    @Override // com.avito.android.analytics.provider.pixel.PixelInteractor
    @NotNull
    public Observable<Unit> sendAd(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "queryMap");
        return a2.b.a.a.a.S1(this.b, this.a.sendAd(map).map(a.a).onErrorReturn(b.a), "pixelApi\n            .se…scribeOn(schedulers.io())");
    }
}
