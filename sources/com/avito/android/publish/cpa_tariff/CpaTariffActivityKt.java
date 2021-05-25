package com.avito.android.publish.cpa_tariff;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/Context;", "context", "", "categoryId", "Landroid/content/Intent;", "createCpaTariffActivityIntent", "(Landroid/content/Context;I)Landroid/content/Intent;", "", "EXTRA_CATEGORY_ID", "Ljava/lang/String;", "publish_release"}, k = 2, mv = {1, 4, 2})
public final class CpaTariffActivityKt {
    @NotNull
    public static final String EXTRA_CATEGORY_ID = "category_id";

    @NotNull
    public static final Intent createCpaTariffActivityIntent(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent putExtra = new Intent(context, CpaTariffActivity.class).putExtra("category_id", i);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…_CATEGORY_ID, categoryId)");
        return putExtra;
    }
}
