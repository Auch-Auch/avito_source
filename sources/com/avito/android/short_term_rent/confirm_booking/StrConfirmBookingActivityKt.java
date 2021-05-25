package com.avito.android.short_term_rent.confirm_booking;

import android.content.Context;
import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.str.StrCalendarActivityInteractionConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aA\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroid/content/Context;", "context", "", BookingInfoActivity.EXTRA_ITEM_ID, "checkInDate", "checkOutDate", "", "guestsCount", "workflow", "Landroid/content/Intent;", "createConfirmBookingIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Landroid/content/Intent;", "short-term-rent_release"}, k = 2, mv = {1, 4, 2})
public final class StrConfirmBookingActivityKt {
    @NotNull
    public static final Intent createConfirmBookingIntent(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, int i, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "checkInDate");
        Intrinsics.checkNotNullParameter(str3, "checkOutDate");
        Intent putExtra = new Intent(context, StrConfirmBookingActivity.class).putExtra("advert_id", str).putExtra("check_int_date", str2).putExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_OUT_DATE, str3).putExtra("guests_count", i).putExtra("workflow", str4);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…EXTRA_WORKFLOW, workflow)");
        return putExtra;
    }

    public static /* synthetic */ Intent createConfirmBookingIntent$default(Context context, String str, String str2, String str3, int i, String str4, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            str4 = null;
        }
        return createConfirmBookingIntent(context, str, str2, str3, i, str4);
    }
}
