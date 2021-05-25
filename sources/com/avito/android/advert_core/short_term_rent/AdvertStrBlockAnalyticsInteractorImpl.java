package com.avito.android.advert_core.short_term_rent;

import com.avito.android.advert_core.analytics.short_time_rent.ManageCalendarEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.module.AdvertId;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockAnalyticsInteractorImpl;", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockAnalyticsInteractor;", "", "sendManageCalendarEvent", "()V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/profile/ProfileInfoStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile/ProfileInfoStorage;", "profileStorage", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Ljava/lang/String;Lcom/avito/android/profile/ProfileInfoStorage;Lcom/avito/android/analytics/Analytics;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertStrBlockAnalyticsInteractorImpl implements AdvertStrBlockAnalyticsInteractor {
    public final String a;
    public final ProfileInfoStorage b;
    public final Analytics c;

    @Inject
    public AdvertStrBlockAnalyticsInteractorImpl(@AdvertId @NotNull String str, @NotNull ProfileInfoStorage profileInfoStorage, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(profileInfoStorage, "profileStorage");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = str;
        this.b = profileInfoStorage;
        this.c = analytics;
    }

    @Override // com.avito.android.advert_core.short_term_rent.AdvertStrBlockAnalyticsInteractor
    public void sendManageCalendarEvent() {
        String userId = this.b.getProfileInfo().getUserId();
        if (userId != null) {
            if (userId.length() > 0) {
                this.c.track(new ManageCalendarEvent(this.a, userId, "item_view"));
            }
        }
    }
}
