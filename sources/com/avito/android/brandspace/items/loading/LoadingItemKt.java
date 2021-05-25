package com.avito.android.brandspace.items.loading;

import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "", "isFilteredAdvertsLoadingItem", "(Lcom/avito/android/brandspace/presenter/BrandspaceItem;)Z", "brandspace_release"}, k = 2, mv = {1, 4, 2})
public final class LoadingItemKt {
    public static final boolean isFilteredAdvertsLoadingItem(@NotNull BrandspaceItem brandspaceItem) {
        Intrinsics.checkNotNullParameter(brandspaceItem, "$this$isFilteredAdvertsLoadingItem");
        return (brandspaceItem instanceof LoadingItem) && ((LoadingItem) brandspaceItem).getType() == BlockType.BS_SERP;
    }
}
