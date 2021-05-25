package com.avito.android.analytics.event;

import com.avito.android.analytics.provider.api.ApiEvent;
import com.avito.android.analytics.provider.api.ApiEventTracker;
import com.avito.android.analytics.remote.AnalyticsApi;
import com.avito.android.analytics_adjust.AdjustEvent;
import com.avito.android.analytics_adjust.AdjustEventTracker;
import com.avito.android.analytics_firebase.FirebaseEvent;
import com.avito.android.analytics_firebase.FirebaseEventTracker;
import com.avito.android.analytics_firebase.SimpleFirebaseEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B7\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0007\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0007\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0016\u0010\u0019\u001a\u00020\u000f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0011R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/analytics/event/CallToSellerEvent;", "Lcom/avito/android/analytics_adjust/AdjustEvent;", "Lcom/avito/android/analytics/provider/api/ApiEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_adjust/AdjustEventTracker;)V", "Lcom/avito/android/analytics/provider/api/ApiEventTracker;", "Lcom/avito/android/analytics/remote/AnalyticsApi;", "api", "(Lcom/avito/android/analytics/provider/api/ApiEventTracker;Lcom/avito/android/analytics/remote/AnalyticsApi;)V", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "d", "source", AuthSource.BOOKING_ORDER, "email", "getName", "()Ljava/lang/String;", "name", "c", "context", "", "e", "Ljava/lang/Integer;", BookingInfoActivity.EXTRA_FROM_BLOCK, "", "", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class CallToSellerEvent implements AdjustEvent, ApiEvent, FirebaseEvent {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Integer e;
    public final /* synthetic */ SimpleFirebaseEvent f = new SimpleFirebaseEvent(CallToSellerEventKt.access$getAdjustTokenWithFirebaseName$p().getFirebaseName(), null, 2, null);

    public static final class a<T, R> implements Function<SuccessResult, Unit> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(SuccessResult successResult) {
            Intrinsics.checkNotNullParameter(successResult, "it");
            return Unit.INSTANCE;
        }
    }

    public CallToSellerEvent(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = num;
    }

    @Override // com.avito.android.analytics_adjust.AdjustEvent
    public void accept(@NotNull AdjustEventTracker adjustEventTracker) {
        Intrinsics.checkNotNullParameter(adjustEventTracker, "tracker");
        com.adjust.sdk.AdjustEvent adjustEvent = new com.adjust.sdk.AdjustEvent(CallToSellerEventKt.access$getAdjustTokenWithFirebaseName$p().getAdjustToken());
        adjustEventTracker.injectCriteoEmail(this.b);
        AdjustEventTracker.DefaultImpls.injectCriteoTransactionConfirmed$default(adjustEventTracker, adjustEvent, this.a, 0.0f, 0, null, null, 60, null);
        adjustEventTracker.trackEvent(adjustEvent);
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    public void accept(@NotNull FirebaseEventTracker firebaseEventTracker) {
        Intrinsics.checkNotNullParameter(firebaseEventTracker, "tracker");
        this.f.accept(firebaseEventTracker);
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @Nullable
    public Map<String, Object> getFirebaseEventParams() {
        return this.f.getFirebaseEventParams();
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @NotNull
    public String getName() {
        return this.f.getName();
    }

    @Override // com.avito.android.analytics.provider.api.ApiEvent
    public void accept(@NotNull ApiEventTracker apiEventTracker, @NotNull AnalyticsApi analyticsApi) {
        Intrinsics.checkNotNullParameter(apiEventTracker, "tracker");
        Intrinsics.checkNotNullParameter(analyticsApi, "api");
        Observable<Unit> map = InteropKt.toV2(analyticsApi.advertCall(this.a, this.c, this.d, this.e)).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.advertCall(advertId,…lock).toV2().map { Unit }");
        apiEventTracker.trackEvent(map);
    }
}
