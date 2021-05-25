package com.avito.android.short_term_rent.analytics;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;", "", "", "source", "", "trackShowStartBookingScreenEvent", "(Ljava/lang/String;)V", "trackShowCalendarEvent", "()V", "trackSelectCalendarEvent", "trackSelectGuestsCountEvent", "trackShowConfirmBookingScreenEvent", "trackConfirmBookingSubmitEvent", AnalyticFieldsName.orderId, "trackBookingCreateEvent", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public interface StrAnalyticsTracker {
    void trackBookingCreateEvent(@NotNull String str);

    void trackConfirmBookingSubmitEvent();

    void trackSelectCalendarEvent();

    void trackSelectGuestsCountEvent();

    void trackShowCalendarEvent();

    void trackShowConfirmBookingScreenEvent();

    void trackShowStartBookingScreenEvent(@NotNull String str);
}
