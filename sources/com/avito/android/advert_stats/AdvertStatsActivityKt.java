package com.avito.android.advert_stats;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/content/Context;", "context", "", BookingInfoActivity.EXTRA_ITEM_ID, "Landroid/content/Intent;", "createAdvertStatsActivityIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "STAT_ITEM_ID", "Ljava/lang/String;", "advert-stats_release"}, k = 2, mv = {1, 4, 2})
public final class AdvertStatsActivityKt {
    @NotNull
    public static final String STAT_ITEM_ID = "item_id";

    @NotNull
    public static final Intent createAdvertStatsActivityIntent(@NotNull Context context, @NotNull String str) {
        return a.j1(context, "context", str, BookingInfoActivity.EXTRA_ITEM_ID, context, AdvertStatsActivity.class, "item_id", str, "context.createActivityIn…a(STAT_ITEM_ID, advertId)");
    }
}
