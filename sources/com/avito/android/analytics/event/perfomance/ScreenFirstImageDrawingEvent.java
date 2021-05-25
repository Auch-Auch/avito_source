package com.avito.android.analytics.event.perfomance;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\u0013¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/avito/android/analytics/event/perfomance/ScreenFirstImageDrawingEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getEventId", "()I", "eventId", "getVersion", "version", "screenName", "networkType", "contentType", "", "screenTouchTime", "startupTime", "imageUrl", "imageError", "", "imageStatus", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "imageDrawTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ZIIJ)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class ScreenFirstImageDrawingEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    public ScreenFirstImageDrawingEvent(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, long j2, @NotNull String str4, @Nullable String str5, boolean z, int i, int i2, long j3) {
        a.b1(str, "screenName", str2, "networkType", str3, "contentType", str4, "imageUrl");
        boolean z2 = false;
        Map mutableMapOf = r.mutableMapOf(TuplesKt.to("network_type", str2), TuplesKt.to(VKApiUserFull.SCREEN_NAME, str), TuplesKt.to(FirebaseAnalytics.Param.CONTENT_TYPE, str3), TuplesKt.to("app_startup_time", Long.valueOf(j2)), TuplesKt.to("image_url", str4), TuplesKt.to("image_status", Boolean.valueOf(z)), TuplesKt.to("image_draw_time", Long.valueOf(j3)));
        if (i != 0) {
            mutableMapOf.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, Integer.valueOf(i));
        }
        if (i2 != 0) {
            mutableMapOf.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, Integer.valueOf(i2));
        }
        if (j != 0 ? true : z2) {
            mutableMapOf.put("screen_touch_time", Long.valueOf(j));
        }
        if (str5 != null) {
            mutableMapOf.put("image_error", str5);
        }
        this.a = new ParametrizedClickStreamEvent(4204, 5, mutableMapOf, null, 8, null);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.a.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.a.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.a.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.a.getVersion();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScreenFirstImageDrawingEvent(String str, String str2, String str3, long j, long j2, String str4, String str5, boolean z, int i, int i2, long j3, int i3, j jVar) {
        this(str, str2, str3, (i3 & 8) != 0 ? 0 : j, j2, str4, (i3 & 64) != 0 ? null : str5, z, (i3 & 256) != 0 ? 0 : i, (i3 & 512) != 0 ? 0 : i2, j3);
    }
}
