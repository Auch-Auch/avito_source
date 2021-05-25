package com.avito.android.analytics_firebase;

import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\r\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R*\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/analytics_firebase/SimpleFirebaseEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "analytics-firebase_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleFirebaseEvent implements FirebaseEvent {
    @NotNull
    public final String a;
    @Nullable
    public final Map<String, Object> b;

    public SimpleFirebaseEvent(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.a = str;
        this.b = map;
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    public void accept(@NotNull FirebaseEventTracker firebaseEventTracker) {
        Intrinsics.checkNotNullParameter(firebaseEventTracker, "tracker");
        firebaseEventTracker.trackEvent(this);
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @Nullable
    public Map<String, Object> getFirebaseEventParams() {
        return this.b;
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @NotNull
    public String getName() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleFirebaseEvent(String str, Map map, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : map);
    }
}
