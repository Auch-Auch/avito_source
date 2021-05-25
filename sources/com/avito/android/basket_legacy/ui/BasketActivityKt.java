package com.avito.android.basket_legacy.ui;

import android.content.Context;
import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aI\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroid/content/Context;", "context", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "feesRequired", "vasContext", "vasType", "openedFrom", "Landroid/content/Intent;", "createBasketActivityIntent", "(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "basket_release"}, k = 2, mv = {1, 4, 2})
public final class BasketActivityKt {
    @NotNull
    public static final Intent createBasketActivityIntent(@NotNull Context context, @NotNull String str, boolean z, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intent putExtra = new Intent(context, BasketActivity.class).putExtra("item_id", str).putExtra(BasketActivity.KEY_FEES, z).putExtra(BasketActivity.KEY_VAS_CONTEXT, str2).putExtra(BasketActivity.KEY_VAS_TYPE, str3).putExtra(BasketActivity.KEY_OPENED_FROM, str4);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…_OPENED_FROM, openedFrom)");
        return putExtra;
    }

    public static /* synthetic */ Intent createBasketActivityIntent$default(Context context, String str, boolean z, String str2, String str3, String str4, int i, Object obj) {
        boolean z2 = (i & 4) != 0 ? true : z;
        if ((i & 8) != 0) {
            str2 = "default";
        }
        if ((i & 16) != 0) {
            str3 = "performance";
        }
        return createBasketActivityIntent(context, str, z2, str2, str3, str4);
    }
}
