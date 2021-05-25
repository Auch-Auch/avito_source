package com.avito.android.vas_discount;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "appContext", "", "discountContext", "Landroid/content/Intent;", "createVasDiscountActivityIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "vas-discount_release"}, k = 2, mv = {1, 4, 2})
public final class VasDiscountActivityKt {
    @NotNull
    public static final Intent createVasDiscountActivityIntent(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intent putExtra = new Intent(context, VasDiscountActivity.class).putExtra("discount_context", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "appContext.createActivit…CONTEXT, discountContext)");
        return putExtra;
    }
}
