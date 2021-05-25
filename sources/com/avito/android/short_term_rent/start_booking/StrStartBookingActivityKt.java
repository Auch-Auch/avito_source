package com.avito.android.short_term_rent.start_booking;

import android.content.Context;
import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.str.StrCalendarActivityInteractionConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aS\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroid/content/Context;", "context", "", BookingInfoActivity.EXTRA_ITEM_ID, "source", "checkInDate", "checkOutDate", "", "showCalendar", "workflow", "Landroid/content/Intent;", "createStartBookingIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Landroid/content/Intent;", "short-term-rent_release"}, k = 2, mv = {1, 4, 2})
public final class StrStartBookingActivityKt {
    @NotNull
    public static final Intent createStartBookingIntent(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, boolean z, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "source");
        Intent putExtra = new Intent(context, StrStartBookingActivity.class).putExtra("advert_id", str).putExtra("source", str2).putExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_IN_DATE, str3).putExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_OUT_DATE, str4).putExtra("show_calendar", z).putExtra("workflow", str5);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…EXTRA_WORKFLOW, workflow)");
        return putExtra;
    }

    public static /* synthetic */ Intent createStartBookingIntent$default(Context context, String str, String str2, String str3, String str4, boolean z, String str5, int i, Object obj) {
        return createStartBookingIntent(context, str, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? false : z, (i & 64) != 0 ? null : str5);
    }
}
