package com.avito.android.notification_center.landing.unified;

import com.avito.android.remote.model.notification_center.landing.unified.NotificationCenterLandingUnified;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/NotificationsCenterLandingUnifiedConverter;", "", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingUnified;", "data", "Lio/reactivex/Observable;", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingUnified;)Lio/reactivex/Observable;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationsCenterLandingUnifiedConverter {
    @NotNull
    Observable<List<Item>> convert(@NotNull NotificationCenterLandingUnified notificationCenterLandingUnified);
}
