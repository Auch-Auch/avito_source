package com.avito.android;

import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import java.util.Date;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001JM\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0013\u001a\u00020\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/StrBookingIntentFactory;", "", "", "itemId", "source", "checkInDate", "checkOutDate", "", "showCalendar", "workflow", "Landroid/content/Intent;", "shortTermRentStartBookingIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Landroid/content/Intent;", BookingInfoActivity.EXTRA_ITEM_ID, "Ljava/util/Date;", "calendarBookingIntent", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)Landroid/content/Intent;", "startDate", "endDate", "calendarSelectDatesIntent", "(Ljava/util/Date;Ljava/util/Date;)Landroid/content/Intent;", "manageCalendarIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "marker", "hotelsLandingIntent", "core_release"}, k = 1, mv = {1, 4, 2})
public interface StrBookingIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent calendarBookingIntent$default(StrBookingIntentFactory strBookingIntentFactory, String str, Date date, Date date2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    date = null;
                }
                if ((i & 4) != 0) {
                    date2 = null;
                }
                return strBookingIntentFactory.calendarBookingIntent(str, date, date2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calendarBookingIntent");
        }

        public static /* synthetic */ Intent calendarSelectDatesIntent$default(StrBookingIntentFactory strBookingIntentFactory, Date date, Date date2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    date = null;
                }
                if ((i & 2) != 0) {
                    date2 = null;
                }
                return strBookingIntentFactory.calendarSelectDatesIntent(date, date2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calendarSelectDatesIntent");
        }

        public static /* synthetic */ Intent shortTermRentStartBookingIntent$default(StrBookingIntentFactory strBookingIntentFactory, String str, String str2, String str3, String str4, boolean z, String str5, int i, Object obj) {
            if (obj == null) {
                return strBookingIntentFactory.shortTermRentStartBookingIntent(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : str5);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: shortTermRentStartBookingIntent");
        }
    }

    @NotNull
    Intent calendarBookingIntent(@NotNull String str, @Nullable Date date, @Nullable Date date2);

    @NotNull
    Intent calendarSelectDatesIntent(@Nullable Date date, @Nullable Date date2);

    @NotNull
    Intent hotelsLandingIntent(@Nullable String str);

    @NotNull
    Intent manageCalendarIntent(@NotNull String str);

    @NotNull
    Intent shortTermRentStartBookingIntent(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, boolean z, @Nullable String str5);
}
