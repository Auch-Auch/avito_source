package com.avito.android.serp.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/serp/adapter/GridPositionProviderImpl;", "Lcom/avito/android/serp/adapter/BaseGridPositionProvider;", "Lcom/avito/android/serp/adapter/SpannedItem;", "item", "", "getSpanCount", "(Lcom/avito/android/serp/adapter/SpannedItem;)I", "c", "I", "getColumnsCount", "()I", "setColumnsCount", "(I)V", "columnsCount", "<init>", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class GridPositionProviderImpl extends BaseGridPositionProvider {
    public int c;

    public GridPositionProviderImpl(int i) {
        this.c = i;
    }

    @Override // com.avito.android.ui.adapter.GridPositionProvider
    public int getColumnsCount() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.BaseGridPositionProvider
    public int getSpanCount(@NotNull SpannedItem spannedItem) {
        Intrinsics.checkNotNullParameter(spannedItem, "item");
        return spannedItem.getSpanCount();
    }

    @Override // com.avito.android.ui.adapter.GridPositionProvider
    public void setColumnsCount(int i) {
        this.c = i;
    }
}
