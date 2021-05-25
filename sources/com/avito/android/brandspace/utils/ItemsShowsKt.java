package com.avito.android.brandspace.utils;

import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.items.carousel.CarouselItem;
import com.avito.android.brandspace.presenter.virtualitems.AddableItemsWithLoadingBrandspaceItem;
import com.avito.android.brandspace.presenter.virtualitems.SnippetGridLoader;
import com.avito.android.brandspace.remote.model.ItemsShow;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/brandspace/remote/model/ItemsShow;", "", "id", "Lcom/avito/android/brandspace/items/BlockType;", "blockType", "Lcom/avito/android/brandspace/presenter/virtualitems/AddableItemsWithLoadingBrandspaceItem;", "generateAddableSnippetsItem", "(Lcom/avito/android/brandspace/remote/model/ItemsShow;JLcom/avito/android/brandspace/items/BlockType;)Lcom/avito/android/brandspace/presenter/virtualitems/AddableItemsWithLoadingBrandspaceItem;", "brandspace_release"}, k = 2, mv = {1, 4, 2})
public final class ItemsShowsKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ItemsShow.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    @Nullable
    public static final AddableItemsWithLoadingBrandspaceItem generateAddableSnippetsItem(@Nullable ItemsShow itemsShow, long j, @NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "blockType");
        if (itemsShow != null) {
            int ordinal = itemsShow.ordinal();
            if (ordinal == 0) {
                return CarouselItemsKt.toSnippetCarouselLoader(new CarouselItem(j, blockType, CollectionsKt__CollectionsKt.emptyList(), 0, false, 0, 56, null));
            }
            if (ordinal == 1) {
                return new SnippetGridLoader(j, blockType);
            }
        }
        return null;
    }
}
