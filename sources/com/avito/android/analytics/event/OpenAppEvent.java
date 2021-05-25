package com.avito.android.analytics.event;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.analytics_adjust.AdjustEventTracker;
import com.avito.android.analytics_adjust.AdjustFirebaseWrappedEvent;
import com.avito.android.analytics_adjust.AdjustTokenWithFirebaseName;
import com.avito.android.analytics_adjust.SimpleAdjustFirebaseWrappedEvent;
import com.avito.android.analytics_firebase.FirebaseEventTracker;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0005J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\fH\u0001¢\u0006\u0004\b\n\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00038\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0005R%\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\"\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u00148\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u0016\u0010 \u001a\u00020\u000e8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/avito/android/analytics/event/OpenAppEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "Lcom/avito/android/analytics_adjust/AdjustFirebaseWrappedEvent;", "", "toString", "()Ljava/lang/String;", "description", "Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_adjust/AdjustEventTracker;)V", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", "getVersion", "()I", "version", "getName", "name", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getMetrics", "()Ljava/util/Map;", "metrics", "getFirebaseEventParams", "firebaseEventParams", "getParams", "params", "getEventId", "eventId", "<init>", "(Ljava/util/Map;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class OpenAppEvent implements ClickStreamEvent, AdjustFirebaseWrappedEvent {
    @NotNull
    public final Map<String, Object> a;
    public final /* synthetic */ ParametrizedClickStreamEvent b;
    public final /* synthetic */ SimpleAdjustFirebaseWrappedEvent c = new SimpleAdjustFirebaseWrappedEvent(AdjustTokenWithFirebaseName.OPEN_APP, null, 2, null);

    public OpenAppEvent(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "metrics");
        this.b = new ParametrizedClickStreamEvent(2330, 8, map, null, 8, null);
        this.a = map;
    }

    @Override // com.avito.android.analytics_adjust.AdjustEvent
    public void accept(@NotNull AdjustEventTracker adjustEventTracker) {
        Intrinsics.checkNotNullParameter(adjustEventTracker, "tracker");
        this.c.accept(adjustEventTracker);
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    public void accept(@NotNull FirebaseEventTracker firebaseEventTracker) {
        Intrinsics.checkNotNullParameter(firebaseEventTracker, "tracker");
        this.c.accept(firebaseEventTracker);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.b.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.b.getEventId();
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @Nullable
    public Map<String, Object> getFirebaseEventParams() {
        return this.c.getFirebaseEventParams();
    }

    @NotNull
    public final Map<String, Object> getMetrics() {
        return this.a;
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEvent
    @NotNull
    public String getName() {
        return this.c.getName();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.b.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.b.getVersion();
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OpenApp ");
        L.append(this.a);
        return L.toString();
    }
}
