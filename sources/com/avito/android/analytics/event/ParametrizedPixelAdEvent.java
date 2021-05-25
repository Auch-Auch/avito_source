package com.avito.android.analytics.event;

import com.avito.android.analytics.provider.pixel.PixelEvent;
import com.avito.android.analytics.provider.pixel.PixelEventTracker;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/analytics/event/ParametrizedPixelAdEvent;", "Lcom/avito/android/analytics/provider/pixel/PixelEvent;", "Lcom/avito/android/analytics/provider/pixel/PixelEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics/provider/pixel/PixelEventTracker;)V", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", "<init>", "(Ljava/util/Map;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ParametrizedPixelAdEvent implements PixelEvent {
    @NotNull
    public final Map<String, String> a;

    public ParametrizedPixelAdEvent(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "params");
        this.a = map;
    }

    @Override // com.avito.android.analytics.provider.pixel.PixelEvent
    public void accept(@NotNull PixelEventTracker pixelEventTracker) {
        Intrinsics.checkNotNullParameter(pixelEventTracker, "tracker");
        pixelEventTracker.trackAdEvent(this.a);
    }

    @NotNull
    public final Map<String, String> getParams() {
        return this.a;
    }
}
