package com.avito.android.serp.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/serp/adapter/SerpSpanProviderImpl;", "Lcom/avito/android/serp/adapter/BaseSerpSpanProvider;", "Lcom/avito/android/serp/adapter/SpannedItem;", "item", "", "getSpanCount", "(Lcom/avito/android/serp/adapter/SpannedItem;)I", "d", "I", "getColumnsCount", "()I", "setColumnsCount", "(I)V", "columnsCount", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "<init>", "(ILcom/avito/android/serp/adapter/SpannedGridPositionProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpSpanProviderImpl extends BaseSerpSpanProvider {
    public int d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SerpSpanProviderImpl(int i, @NotNull SpannedGridPositionProvider spannedGridPositionProvider) {
        super(spannedGridPositionProvider);
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        this.d = i;
    }

    @Override // com.avito.android.serp.adapter.SerpSpanProvider
    public int getColumnsCount() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.BaseSerpSpanProvider
    public int getSpanCount(@NotNull SpannedItem spannedItem) {
        Intrinsics.checkNotNullParameter(spannedItem, "item");
        return spannedItem.getSpanCount();
    }

    @Override // com.avito.android.serp.adapter.SerpSpanProvider
    public void setColumnsCount(int i) {
        this.d = i;
    }
}
