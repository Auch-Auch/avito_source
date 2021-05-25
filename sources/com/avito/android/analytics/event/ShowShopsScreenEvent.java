package com.avito.android.analytics.event;

import com.avito.android.analytics_firebase.FirebaseEvent;
import com.avito.android.analytics_firebase.FirebaseEventTracker;
import com.avito.android.analytics_firebase.SimpleFirebaseEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/avito/android/analytics/event/ShowShopsScreenEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", "getName", "()Ljava/lang/String;", "name", "", "", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", "params", "<init>", "(Ljava/util/Map;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShowShopsScreenEvent implements FirebaseEvent {
    public final /* synthetic */ SimpleFirebaseEvent a;

    public ShowShopsScreenEvent(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "params");
        this.a = new SimpleFirebaseEvent("ShopsCatalog", map);
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
