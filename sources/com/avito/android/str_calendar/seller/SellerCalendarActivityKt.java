package com.avito.android.str_calendar.seller;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "", BookingInfoActivity.EXTRA_ITEM_ID, "Landroid/content/Intent;", "createManageCalendarIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "str-calendar_release"}, k = 2, mv = {1, 4, 2})
public final class SellerCalendarActivityKt {
    @NotNull
    public static final Intent createManageCalendarIntent(@NotNull Context context, @NotNull String str) {
        return a.j1(context, "context", str, BookingInfoActivity.EXTRA_ITEM_ID, context, SellerCalendarActivity.class, "advert_id", str, "context.createActivityIn…XTRA_ADVERT_ID, advertId)");
    }
}
