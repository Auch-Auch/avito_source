package com.avito.android.analytics.event;

import com.avito.android.analytics.provider.pixel.PixelEvent;
import com.avito.android.analytics.provider.pixel.PixelEventTracker;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0010\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R'\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/analytics/event/DfpRequestEvent;", "Lcom/avito/android/analytics/provider/pixel/PixelEvent;", "Lcom/avito/android/analytics/provider/pixel/PixelEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics/provider/pixel/PixelEventTracker;)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAdSlot", "()Ljava/lang/String;", "adSlot", "", "c", "Z", "isFallback", "()Z", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getNetworkExtras", "()Ljava/util/Map;", "networkExtras", "<init>", "(Ljava/lang/String;Ljava/util/Map;Z)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class DfpRequestEvent implements PixelEvent {
    @NotNull
    public final String a;
    @Nullable
    public final Map<String, Object> b;
    public final boolean c;
    public final /* synthetic */ ParametrizedDfpPixelEvent d;

    public DfpRequestEvent(@NotNull String str, @Nullable Map<String, ? extends Object> map, boolean z) {
        Intrinsics.checkNotNullParameter(str, "adSlot");
        this.d = new ParametrizedDfpPixelEvent(str, "r", z);
        this.a = str;
        this.b = map;
        this.c = z;
    }

    @Override // com.avito.android.analytics.provider.pixel.PixelEvent
    public void accept(@NotNull PixelEventTracker pixelEventTracker) {
        Intrinsics.checkNotNullParameter(pixelEventTracker, "tracker");
        this.d.accept(pixelEventTracker);
    }

    @NotNull
    public final String getAdSlot() {
        return this.a;
    }

    @Nullable
    public final Map<String, Object> getNetworkExtras() {
        return this.b;
    }

    public final boolean isFallback() {
        return this.c;
    }
}
