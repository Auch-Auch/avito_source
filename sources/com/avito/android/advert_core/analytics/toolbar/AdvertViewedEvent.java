package com.avito.android.advert_core.analytics.toolbar;

import androidx.annotation.VisibleForTesting;
import com.avito.android.analytics_adjust.AdjustEvent;
import com.avito.android.analytics_adjust.AdjustEventTracker;
import com.avito.android.analytics_adjust.utils.AdjustContentType;
import com.avito.android.analytics_adjust.utils.AdjustEventsKt;
import com.avito.android.analytics_firebase.FirebaseEvent;
import com.avito.android.analytics_firebase.FirebaseEventTracker;
import com.avito.android.analytics_firebase.SimpleFirebaseEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\b\b\u0001\u0010\r\u001a\u00020\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0018¢\u0006\u0004\b \u0010!J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0006\u0010\tR\u0019\u0010\r\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0017\u001a\u00020\u000f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00188\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/advert_core/analytics/toolbar/AdvertViewedEvent;", "Lcom/avito/android/analytics_adjust/AdjustEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_adjust/AdjustEventTracker;)V", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", AuthSource.SEND_ABUSE, "Z", "isLogged", "()Z", "", "c", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, AuthSource.BOOKING_ORDER, "email", "getName", "()Ljava/lang/String;", "name", "", "d", "Ljava/util/Map;", "params", "", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertViewedEvent implements AdjustEvent, FirebaseEvent {
    public final boolean a;
    public final String b;
    public final String c;
    public final Map<String, String> d;
    public final /* synthetic */ SimpleFirebaseEvent e;

    public AdvertViewedEvent(@VisibleForTesting boolean z, @Nullable String str, @NotNull String str2, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_ITEM_ID);
        this.e = new SimpleFirebaseEvent(AdvertViewedEventKt.access$getAdjustTokenWithFirebaseName$p().getFirebaseName(), map);
        this.a = z;
        this.b = str;
        this.c = str2;
        this.d = map;
    }

    @Override // com.avito.android.analytics_adjust.AdjustEvent
    public void accept(@NotNull AdjustEventTracker adjustEventTracker) {
        Intrinsics.checkNotNullParameter(adjustEventTracker, "tracker");
        com.adjust.sdk.AdjustEvent withParams = AdjustEventsKt.withParams(AdjustEventsKt.withContentIds(AdjustEventsKt.withContentType(new com.adjust.sdk.AdjustEvent(AdvertViewedEventKt.access$getAdjustTokenWithFirebaseName$p().getAdjustToken()), AdjustContentType.PRODUCT), this.c), this.d);
        adjustEventTracker.injectCriteoEmail(this.b);
        adjustEventTracker.injectCriteoViewProduct(withParams, this.c);
        adjustEventTracker.trackEvent(withParams);
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    public void accept(@NotNull FirebaseEventTracker firebaseEventTracker) {
        Intrinsics.checkNotNullParameter(firebaseEventTracker, "tracker");
        this.e.accept(firebaseEventTracker);
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @Nullable
    public Map<String, Object> getFirebaseEventParams() {
        return this.e.getFirebaseEventParams();
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @NotNull
    public String getName() {
        return this.e.getName();
    }

    public final boolean isLogged() {
        return this.a;
    }
}
