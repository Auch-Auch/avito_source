package com.avito.android.safedeal.delivery_courier.summary;

import android.content.Context;
import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a'\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007\"\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\t\"\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Landroid/content/Context;", "context", "", BookingInfoActivity.EXTRA_ITEM_ID, "searchContext", "Landroid/content/Intent;", "createCourierDeliverySummaryIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "EXTRA_ADVERT_ID", "Ljava/lang/String;", "EXTRA_SEARCH_CONTEXT", "safedeal_release"}, k = 2, mv = {1, 4, 2})
public final class DeliveryCourierSummaryActivityKt {
    @NotNull
    public static final String EXTRA_ADVERT_ID = "advert_id";
    @NotNull
    public static final String EXTRA_SEARCH_CONTEXT = "search_context";

    @NotNull
    public static final Intent createCourierDeliverySummaryIntent(@NotNull Context context, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intent putExtra = new Intent(context, DeliveryCourierSummaryActivity.class).putExtra("advert_id", str).putExtra("search_context", str2);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…H_CONTEXT, searchContext)");
        return putExtra;
    }
}
