package com.avito.android.analytics.event;

import com.avito.android.analytics.provider.api.ApiEvent;
import com.avito.android.analytics.provider.api.ApiEventTracker;
import com.avito.android.analytics.remote.AnalyticsApi;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/analytics/event/CallToSellerConfirmedEvent;", "Lcom/avito/android/analytics/provider/api/ApiEvent;", "Lcom/avito/android/analytics/provider/api/ApiEventTracker;", "tracker", "Lcom/avito/android/analytics/remote/AnalyticsApi;", "api", "", "accept", "(Lcom/avito/android/analytics/provider/api/ApiEventTracker;Lcom/avito/android/analytics/remote/AnalyticsApi;)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "context", AuthSource.SEND_ABUSE, BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class CallToSellerConfirmedEvent implements ApiEvent {
    public final String a;
    public final String b;

    public static final class a<T, R> implements Function<SuccessResult, Unit> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Unit apply(SuccessResult successResult) {
            return Unit.INSTANCE;
        }
    }

    public CallToSellerConfirmedEvent(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.a = str;
        this.b = str2;
    }

    @Override // com.avito.android.analytics.provider.api.ApiEvent
    public void accept(@NotNull ApiEventTracker apiEventTracker, @NotNull AnalyticsApi analyticsApi) {
        Intrinsics.checkNotNullParameter(apiEventTracker, "tracker");
        Intrinsics.checkNotNullParameter(analyticsApi, "api");
        Observable<R> map = analyticsApi.advertCallConfirmed(this.a, this.b).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.advertCallConfirmed(…Id, context).map { Unit }");
        apiEventTracker.trackEvent(InteropKt.toV2(map));
    }
}
