package com.avito.android.serp.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/serp/adapter/SerpItemSizeAdjusterImpl;", "Lcom/avito/android/serp/adapter/BaseSerpItemSizeAdjuster;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "item", "", "getSpanCount", "(Lcom/avito/android/serp/adapter/ViewTypeSerpItem;)I", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpItemSizeAdjusterImpl extends BaseSerpItemSizeAdjuster {
    @Override // com.avito.android.serp.adapter.BaseSerpItemSizeAdjuster
    public int getSpanCount(@NotNull ViewTypeSerpItem viewTypeSerpItem) {
        Intrinsics.checkNotNullParameter(viewTypeSerpItem, "item");
        return viewTypeSerpItem.getSpanCount();
    }
}
