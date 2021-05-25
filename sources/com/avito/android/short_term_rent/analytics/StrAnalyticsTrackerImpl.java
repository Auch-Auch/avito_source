package com.avito.android.short_term_rent.analytics;

import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.short_term_rent.analytics.event.StrBookingCreateEvent;
import com.avito.android.short_term_rent.analytics.event.StrConfirmBookingSubmitEvent;
import com.avito.android.short_term_rent.analytics.event.StrSelectCalendarEvent;
import com.avito.android.short_term_rent.analytics.event.StrSelectGuestsCountEvent;
import com.avito.android.short_term_rent.analytics.event.StrShowCalendarEvent;
import com.avito.android.short_term_rent.analytics.event.StrShowConfirmBookingScreenEvent;
import com.avito.android.short_term_rent.analytics.event.StrShowStartBookingScreenEvent;
import com.avito.android.short_term_rent.di.qualifier.AdvertId;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/short_term_rent/analytics/StrAnalyticsTrackerImpl;", "Lcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;", "", "source", "", "trackShowStartBookingScreenEvent", "(Ljava/lang/String;)V", "trackShowCalendarEvent", "()V", "trackSelectCalendarEvent", "trackSelectGuestsCountEvent", "trackShowConfirmBookingScreenEvent", "trackConfirmBookingSubmitEvent", AnalyticFieldsName.orderId, "trackBookingCreateEvent", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Ljava/lang/String;Lcom/avito/android/analytics/Analytics;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrAnalyticsTrackerImpl implements StrAnalyticsTracker {
    public final String a;
    public final Analytics b;

    @Inject
    public StrAnalyticsTrackerImpl(@AdvertId @NotNull String str, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = str;
        this.b = analytics;
    }

    @Override // com.avito.android.short_term_rent.analytics.StrAnalyticsTracker
    public void trackBookingCreateEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        this.b.track(new StrBookingCreateEvent(this.a, str));
    }

    @Override // com.avito.android.short_term_rent.analytics.StrAnalyticsTracker
    public void trackConfirmBookingSubmitEvent() {
        this.b.track(new StrConfirmBookingSubmitEvent(this.a));
    }

    @Override // com.avito.android.short_term_rent.analytics.StrAnalyticsTracker
    public void trackSelectCalendarEvent() {
        this.b.track(new StrSelectCalendarEvent(this.a));
    }

    @Override // com.avito.android.short_term_rent.analytics.StrAnalyticsTracker
    public void trackSelectGuestsCountEvent() {
        this.b.track(new StrSelectGuestsCountEvent(this.a));
    }

    @Override // com.avito.android.short_term_rent.analytics.StrAnalyticsTracker
    public void trackShowCalendarEvent() {
        this.b.track(new StrShowCalendarEvent(this.a));
    }

    @Override // com.avito.android.short_term_rent.analytics.StrAnalyticsTracker
    public void trackShowConfirmBookingScreenEvent() {
        this.b.track(new StrShowConfirmBookingScreenEvent(this.a));
    }

    @Override // com.avito.android.short_term_rent.analytics.StrAnalyticsTracker
    public void trackShowStartBookingScreenEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        this.b.track(new StrShowStartBookingScreenEvent(this.a, str));
    }
}
