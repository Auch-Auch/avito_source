package com.avito.android.safedeal.delivery_courier.analytics.adjust;

import com.avito.android.analytics_adjust.AdjustEventTracker;
import com.avito.android.analytics_adjust.AdjustFirebaseWrappedEvent;
import com.avito.android.analytics_adjust.AdjustTokenWithFirebaseName;
import com.avito.android.analytics_adjust.SimpleAdjustFirebaseWrappedEvent;
import com.avito.android.analytics_firebase.FirebaseEventTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0005\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/analytics/adjust/OpenCourierSummaryAdjustEvent;", "Lcom/avito/android/analytics_adjust/AdjustFirebaseWrappedEvent;", "Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_adjust/AdjustEventTracker;)V", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", "getName", "()Ljava/lang/String;", "name", "", "", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class OpenCourierSummaryAdjustEvent implements AdjustFirebaseWrappedEvent {
    public final /* synthetic */ SimpleAdjustFirebaseWrappedEvent a = new SimpleAdjustFirebaseWrappedEvent(AdjustTokenWithFirebaseName.OPEN_COURIER_SUMMARY, null, 2, null);

    @Override // com.avito.android.analytics_adjust.AdjustEvent
    public void accept(@NotNull AdjustEventTracker adjustEventTracker) {
        Intrinsics.checkNotNullParameter(adjustEventTracker, "tracker");
        this.a.accept(adjustEventTracker);
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    public void accept(@NotNull FirebaseEventTracker firebaseEventTracker) {
        Intrinsics.checkNotNullParameter(firebaseEventTracker, "tracker");
        this.a.accept(firebaseEventTracker);
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @Nullable
    public Map<String, Object> getFirebaseEventParams() {
        return this.a.getFirebaseEventParams();
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @NotNull
    public String getName() {
        return this.a.getName();
    }
}
