package com.avito.android.serp.adapter.location_notification;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.location_notification.LocationNotification;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItem;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0005\u001a\u00020\b*\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemConvertImpl;", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemConverter;", "Lcom/avito/android/remote/model/location_notification/LocationNotification;", "entity", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItem;", "convert", "(Lcom/avito/android/remote/model/location_notification/LocationNotification;)Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItem;", "Lcom/avito/android/remote/model/location_notification/LocationNotification$TooltipType;", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItem$TooltipType;", "(Lcom/avito/android/remote/model/location_notification/LocationNotification$TooltipType;)Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItem$TooltipType;", "", AuthSource.SEND_ABUSE, "I", "columnsCount", "<init>", "(I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class LocationNotificationItemConvertImpl implements LocationNotificationItemConverter {
    public final int a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            LocationNotification.TooltipType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            LocationNotification.TooltipType tooltipType = LocationNotification.TooltipType.CHANGE;
            iArr[0] = 1;
            LocationNotification.TooltipType tooltipType2 = LocationNotification.TooltipType.REGULAR;
            iArr[1] = 2;
        }
    }

    public LocationNotificationItemConvertImpl(int i) {
        this.a = i;
    }

    @Override // com.avito.android.serp.adapter.location_notification.LocationNotificationItemConverter
    @NotNull
    public LocationNotificationItem convert(@NotNull LocationNotification locationNotification) {
        Intrinsics.checkNotNullParameter(locationNotification, "entity");
        int i = this.a;
        String title = locationNotification.getTitle();
        String confirmText = locationNotification.getConfirmText();
        String changeText = locationNotification.getChangeText();
        LocationNotification.TooltipType tooltipType = locationNotification.getTooltipType();
        return new LocationNotificationItem(null, i, title, confirmText, changeText, tooltipType != null ? convert(tooltipType) : null, locationNotification.getGeoSessionId(), 1, null);
    }

    @NotNull
    public final LocationNotificationItem.TooltipType convert(@NotNull LocationNotification.TooltipType tooltipType) {
        Intrinsics.checkNotNullParameter(tooltipType, "$this$convert");
        int ordinal = tooltipType.ordinal();
        if (ordinal == 0) {
            return LocationNotificationItem.TooltipType.CHANGE;
        }
        if (ordinal == 1) {
            return LocationNotificationItem.TooltipType.REGULAR;
        }
        throw new NoWhenBranchMatchedException();
    }
}
