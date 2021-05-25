package com.avito.android.analytics_adjust;

import com.avito.android.analytics_firebase.FirebaseEvent;
import com.avito.android.analytics_firebase.FirebaseEventTracker;
import com.avito.android.analytics_firebase.SimpleFirebaseEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0007\u0010\nR*\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/avito/android/analytics_adjust/SimpleAdjustFirebaseWrappedEvent;", "Lcom/avito/android/analytics_adjust/AdjustFirebaseWrappedEvent;", "Lcom/avito/android/analytics_adjust/AdjustEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_adjust/AdjustEventTracker;)V", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", "getName", "()Ljava/lang/String;", "name", "Lcom/avito/android/analytics_adjust/AdjustTokenWithFirebaseName;", "adjustTokenWithFirebaseName", "<init>", "(Lcom/avito/android/analytics_adjust/AdjustTokenWithFirebaseName;Ljava/util/Map;)V", "analytics-adjust_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleAdjustFirebaseWrappedEvent implements AdjustFirebaseWrappedEvent, AdjustEvent, FirebaseEvent {
    @Nullable
    public final Map<String, String> a;
    public final /* synthetic */ SimpleAdjustEvent b;
    public final /* synthetic */ SimpleFirebaseEvent c;

    public SimpleAdjustFirebaseWrappedEvent(@NotNull AdjustTokenWithFirebaseName adjustTokenWithFirebaseName, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(adjustTokenWithFirebaseName, "adjustTokenWithFirebaseName");
        this.b = new SimpleAdjustEvent(adjustTokenWithFirebaseName.getAdjustToken());
        this.c = new SimpleFirebaseEvent(adjustTokenWithFirebaseName.getFirebaseName(), null, 2, null);
        this.a = map;
    }

    @Override // com.avito.android.analytics_adjust.AdjustEvent
    public void accept(@NotNull AdjustEventTracker adjustEventTracker) {
        Intrinsics.checkNotNullParameter(adjustEventTracker, "tracker");
        this.b.accept(adjustEventTracker);
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    public void accept(@NotNull FirebaseEventTracker firebaseEventTracker) {
        Intrinsics.checkNotNullParameter(firebaseEventTracker, "tracker");
        this.c.accept(firebaseEventTracker);
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @Nullable
    public Map<String, String> getFirebaseEventParams() {
        return this.a;
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @NotNull
    public String getName() {
        return this.c.getName();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleAdjustFirebaseWrappedEvent(AdjustTokenWithFirebaseName adjustTokenWithFirebaseName, Map map, int i, j jVar) {
        this(adjustTokenWithFirebaseName, (i & 2) != 0 ? null : map);
    }
}
