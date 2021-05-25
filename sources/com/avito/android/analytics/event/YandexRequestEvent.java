package com.avito.android.analytics.event;

import com.avito.android.analytics.provider.pixel.PixelEvent;
import com.avito.android.analytics.provider.pixel.PixelEventTracker;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/avito/android/analytics/event/YandexRequestEvent;", "Lcom/avito/android/analytics/provider/pixel/PixelEvent;", "Lcom/avito/android/analytics/provider/pixel/PixelEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics/provider/pixel/PixelEventTracker;)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", AuthSource.BOOKING_ORDER, "getStatId", "statId", "", "isFallback", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class YandexRequestEvent implements PixelEvent {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final /* synthetic */ ParametrizedYandexPixelEvent c;

    public YandexRequestEvent(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "statId");
        this.c = new ParametrizedYandexPixelEvent(str, str2, "r", z);
        this.a = str;
        this.b = str2;
    }

    @Override // com.avito.android.analytics.provider.pixel.PixelEvent
    public void accept(@NotNull PixelEventTracker pixelEventTracker) {
        Intrinsics.checkNotNullParameter(pixelEventTracker, "tracker");
        this.c.accept(pixelEventTracker);
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final String getStatId() {
        return this.b;
    }
}
