package com.avito.android.advert_core.analytics;

import com.avito.android.advert_core.analytics.delivery.DeliveryEventTracker;
import com.avito.android.advert_core.analytics.delivery.DeliveryEventTrackerImpl;
import com.avito.android.advert_core.analytics.sharing.AdvertSharingEventTracker;
import com.avito.android.advert_core.analytics.sharing.AdvertSharingEventTrackerImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert_core/analytics/AdvertAnalyticsModule;", "", "Lcom/avito/android/advert_core/analytics/sharing/AdvertSharingEventTrackerImpl;", "tracker", "Lcom/avito/android/advert_core/analytics/sharing/AdvertSharingEventTracker;", "bindAdvertSharingEventTracker", "(Lcom/avito/android/advert_core/analytics/sharing/AdvertSharingEventTrackerImpl;)Lcom/avito/android/advert_core/analytics/sharing/AdvertSharingEventTracker;", "Lcom/avito/android/advert_core/analytics/delivery/DeliveryEventTrackerImpl;", "Lcom/avito/android/advert_core/analytics/delivery/DeliveryEventTracker;", "bindDeliveryEventTracker", "(Lcom/avito/android/advert_core/analytics/delivery/DeliveryEventTrackerImpl;)Lcom/avito/android/advert_core/analytics/delivery/DeliveryEventTracker;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AdvertAnalyticsModule {
    @Reusable
    @Binds
    @NotNull
    AdvertSharingEventTracker bindAdvertSharingEventTracker(@NotNull AdvertSharingEventTrackerImpl advertSharingEventTrackerImpl);

    @Reusable
    @Binds
    @NotNull
    DeliveryEventTracker bindDeliveryEventTracker(@NotNull DeliveryEventTrackerImpl deliveryEventTrackerImpl);
}
