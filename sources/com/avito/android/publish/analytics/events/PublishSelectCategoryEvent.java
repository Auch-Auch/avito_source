package com.avito.android.publish.analytics.events;

import com.avito.android.analytics_adjust.AdjustEvent;
import com.avito.android.analytics_adjust.AdjustEventTracker;
import com.avito.android.analytics_adjust.AdjustTokenWithFirebaseName;
import com.avito.android.analytics_firebase.FirebaseEvent;
import com.avito.android.analytics_firebase.FirebaseEventTracker;
import com.avito.android.analytics_firebase.SimpleFirebaseEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u0006\u0010\fR\u0016\u0010\u000e\u001a\u00020\b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R$\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/publish/analytics/events/PublishSelectCategoryEvent;", "Lcom/avito/android/analytics_adjust/AdjustEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_adjust/AdjustEventTracker;)V", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "getName", "name", "", AuthSource.SEND_ABUSE, "I", "categoryId", "", "", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", "<init>", "(I)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishSelectCategoryEvent implements AdjustEvent, FirebaseEvent {
    public final int a;
    public final /* synthetic */ SimpleFirebaseEvent b = new SimpleFirebaseEvent(AdjustTokenWithFirebaseName.SELECT_CATEGORY.getFirebaseName(), null, 2, null);

    public PublishSelectCategoryEvent(int i) {
        this.a = i;
    }

    @Override // com.avito.android.analytics_adjust.AdjustEvent
    public void accept(@NotNull AdjustEventTracker adjustEventTracker) {
        Intrinsics.checkNotNullParameter(adjustEventTracker, "tracker");
        com.adjust.sdk.AdjustEvent adjustEvent = new com.adjust.sdk.AdjustEvent(AdjustTokenWithFirebaseName.SELECT_CATEGORY.getAdjustToken());
        adjustEvent.addPartnerParameter("category", String.valueOf(this.a));
        adjustEventTracker.trackEvent(adjustEvent);
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    public void accept(@NotNull FirebaseEventTracker firebaseEventTracker) {
        Intrinsics.checkNotNullParameter(firebaseEventTracker, "tracker");
        this.b.accept(firebaseEventTracker);
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @Nullable
    public Map<String, Object> getFirebaseEventParams() {
        return this.b.getFirebaseEventParams();
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @NotNull
    public String getName() {
        return this.b.getName();
    }

    @NotNull
    public String toString() {
        return PublishSelectCategoryEvent.class.getSimpleName() + " with category: " + this.a;
    }
}
