package com.avito.android.serp.adapter.location_notification;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItem;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/serp/adapter/location_notification/LocationNotificationActionData;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getGeoSessionId", "()Ljava/lang/String;", "geoSessionId", "", AuthSource.BOOKING_ORDER, "Z", "isChange", "()Z", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItem$TooltipType;", "c", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItem$TooltipType;", "getType", "()Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItem$TooltipType;", "type", "", "d", "I", "getPosition", "()I", VKApiConst.POSITION, "<init>", "(Ljava/lang/String;ZLcom/avito/android/serp/adapter/location_notification/LocationNotificationItem$TooltipType;I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class LocationNotificationActionData {
    @Nullable
    public final String a;
    public final boolean b;
    @Nullable
    public final LocationNotificationItem.TooltipType c;
    public final int d;

    public LocationNotificationActionData(@Nullable String str, boolean z, @Nullable LocationNotificationItem.TooltipType tooltipType, int i) {
        this.a = str;
        this.b = z;
        this.c = tooltipType;
        this.d = i;
    }

    @Nullable
    public final String getGeoSessionId() {
        return this.a;
    }

    public final int getPosition() {
        return this.d;
    }

    @Nullable
    public final LocationNotificationItem.TooltipType getType() {
        return this.c;
    }

    public final boolean isChange() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocationNotificationActionData(String str, boolean z, LocationNotificationItem.TooltipType tooltipType, int i, int i2, j jVar) {
        this((i2 & 1) != 0 ? null : str, z, (i2 & 4) != 0 ? null : tooltipType, (i2 & 8) != 0 ? 0 : i);
    }
}
