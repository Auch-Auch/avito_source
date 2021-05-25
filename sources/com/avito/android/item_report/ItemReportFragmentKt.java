package com.avito.android.item_report;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "itemId", "Lcom/avito/android/item_report/ItemReportFragment;", "createItemReportFragment", "(Ljava/lang/String;)Lcom/avito/android/item_report/ItemReportFragment;", "item-report_release"}, k = 2, mv = {1, 4, 2})
public final class ItemReportFragmentKt {
    @NotNull
    public static final ItemReportFragment createItemReportFragment(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        ItemReportFragment itemReportFragment = new ItemReportFragment();
        Bundle bundle = new Bundle();
        bundle.putString("item_id", str);
        itemReportFragment.setArguments(bundle);
        return itemReportFragment;
    }
}
