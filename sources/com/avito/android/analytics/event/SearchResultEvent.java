package com.avito.android.analytics.event;

import com.avito.android.analytics_adjust.AdjustEvent;
import com.avito.android.analytics_adjust.AdjustEventTracker;
import com.avito.android.analytics_firebase.FirebaseEvent;
import com.avito.android.analytics_firebase.FirebaseEventTracker;
import com.avito.android.analytics_firebase.SimpleFirebaseEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0006\u0010\tR$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/analytics/event/SearchResultEvent;", "Lcom/avito/android/analytics_adjust/AdjustEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_adjust/AdjustEventTracker;)V", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", "", "", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "email", "", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "advertIds", "getName", "()Ljava/lang/String;", "name", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SearchResultEvent implements AdjustEvent, FirebaseEvent {
    public final String a;
    public final List<String> b;
    public final /* synthetic */ SimpleFirebaseEvent c = new SimpleFirebaseEvent(SearchResultEventKt.a.getFirebaseName(), null, 2, null);

    public SearchResultEvent(@Nullable String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "advertIds");
        this.a = str;
        this.b = list;
    }

    @Override // com.avito.android.analytics_adjust.AdjustEvent
    public void accept(@NotNull AdjustEventTracker adjustEventTracker) {
        Intrinsics.checkNotNullParameter(adjustEventTracker, "tracker");
        com.adjust.sdk.AdjustEvent adjustEvent = new com.adjust.sdk.AdjustEvent(SearchResultEventKt.a.getAdjustToken());
        adjustEventTracker.injectCriteoEmail(this.a);
        adjustEventTracker.injectCriteoViewListing(adjustEvent, this.b);
        adjustEventTracker.trackEvent(adjustEvent);
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    public void accept(@NotNull FirebaseEventTracker firebaseEventTracker) {
        Intrinsics.checkNotNullParameter(firebaseEventTracker, "tracker");
        this.c.accept(firebaseEventTracker);
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @Nullable
    public Map<String, Object> getFirebaseEventParams() {
        return this.c.getFirebaseEventParams();
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @NotNull
    public String getName() {
        return this.c.getName();
    }
}
