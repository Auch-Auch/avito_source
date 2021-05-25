package com.avito.android.str_calendar.booking;

import android.content.Context;
import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.str.StrCalendarActivityInteractionConstants;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a5\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroid/content/Context;", "context", "", BookingInfoActivity.EXTRA_ITEM_ID, "Ljava/util/Date;", "checkInDate", "checkOutDate", "Landroid/content/Intent;", "createBookingCalendarIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)Landroid/content/Intent;", "createSelectDatesCalendarIntent", "(Landroid/content/Context;Ljava/util/Date;Ljava/util/Date;)Landroid/content/Intent;", "str-calendar_release"}, k = 2, mv = {1, 4, 2})
public final class CalendarActivityKt {
    @NotNull
    public static final Intent createBookingCalendarIntent(@NotNull Context context, @NotNull String str, @Nullable Date date, @Nullable Date date2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intent putExtra = new Intent(context, CalendarActivity.class).putExtra("advert_id", str).putExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_IN_DATE, date).putExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_OUT_DATE, date2);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…K_OUT_DATE, checkOutDate)");
        return putExtra;
    }

    public static /* synthetic */ Intent createBookingCalendarIntent$default(Context context, String str, Date date, Date date2, int i, Object obj) {
        if ((i & 4) != 0) {
            date = null;
        }
        if ((i & 8) != 0) {
            date2 = null;
        }
        return createBookingCalendarIntent(context, str, date, date2);
    }

    @NotNull
    public static final Intent createSelectDatesCalendarIntent(@NotNull Context context, @Nullable Date date, @Nullable Date date2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent putExtra = new Intent(context, CalendarActivity.class).putExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_IN_DATE, date).putExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_OUT_DATE, date2);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…K_OUT_DATE, checkOutDate)");
        return putExtra;
    }

    public static /* synthetic */ Intent createSelectDatesCalendarIntent$default(Context context, Date date, Date date2, int i, Object obj) {
        if ((i & 2) != 0) {
            date = null;
        }
        if ((i & 4) != 0) {
            date2 = null;
        }
        return createSelectDatesCalendarIntent(context, date, date2);
    }
}
