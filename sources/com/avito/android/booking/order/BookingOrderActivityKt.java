package com.avito.android.booking.order;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/content/Context;", "context", "", "itemId", "Landroid/content/Intent;", "createBookingOrderIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "EXTRA_ITEM_ID", "Ljava/lang/String;", "booking_release"}, k = 2, mv = {1, 4, 2})
public final class BookingOrderActivityKt {
    @NotNull
    public static final String EXTRA_ITEM_ID = "item_id";

    @NotNull
    public static final Intent createBookingOrderIntent(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intent intent = new Intent(context, BookingOrderActivity.class);
        intent.putExtra("item_id", str);
        return intent;
    }
}
