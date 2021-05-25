package com.avito.android.account.analytics.event;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0005\u0010\bR$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/account/analytics/event/SuccessfulAuthenticationEvent;", "Lcom/avito/android/analytics_adjust/AdjustFirebaseWrappedEvent;", "Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_adjust/AdjustEventTracker;)V", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", "", "", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public final class SuccessfulAuthenticationEvent implements AdjustFirebaseWrappedEvent {
    public final /* synthetic */ SimpleAdjustFirebaseWrappedEvent a = new SimpleAdjustFirebaseWrappedEvent(AdjustTokenWithFirebaseName.SUCCESSFUL_AUTHENTICATION, null, 2, null);

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
