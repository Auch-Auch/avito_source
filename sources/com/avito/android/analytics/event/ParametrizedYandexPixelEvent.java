package com.avito.android.analytics.event;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.pixel.PixelEvent;
import com.avito.android.analytics.provider.pixel.PixelEventTracker;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/avito/android/analytics/event/ParametrizedYandexPixelEvent;", "Lcom/avito/android/analytics/provider/pixel/PixelEvent;", "Lcom/avito/android/analytics/provider/pixel/PixelEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics/provider/pixel/PixelEventTracker;)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStatId", "()Ljava/lang/String;", "statId", AuthSource.SEND_ABUSE, "getId", "id", "event", "", "isFallback", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ParametrizedYandexPixelEvent implements PixelEvent {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final /* synthetic */ ParametrizedPixelAdEvent c;

    public ParametrizedYandexPixelEvent(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        a.Z0(str, "id", str2, "statId", str3, "event");
        this.c = new ParametrizedPixelAdEvent(ParametrizedYandexPixelEventKt.access$createParams(StringsKt__StringsKt.removePrefix(str, (CharSequence) "R-M-"), str2, str3, z));
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
