package com.avito.android.brandspace.items.carousel;

import com.avito.android.brandspace.items.categories.categoryitem.CategoryItem;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a \u0010\u0006\u001a\u00020\u0001\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0004*\u00020\u0000H\b¢\u0006\u0004\b\u0006\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/avito/android/brandspace/items/carousel/CarouselItem;", "", "isCategoryItemCarousel", "(Lcom/avito/android/brandspace/items/carousel/CarouselItem;)Z", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "T", "isAllItemsTypeOf", "brandspace_release"}, k = 2, mv = {1, 4, 2})
public final class CarouselItemKt {
    public static final /* synthetic */ <T extends BrandspaceItem> boolean isAllItemsTypeOf(CarouselItem carouselItem) {
        boolean z;
        Intrinsics.checkNotNullParameter(carouselItem, "$this$isAllItemsTypeOf");
        if (!carouselItem.getItems().isEmpty()) {
            List<BrandspaceItem> items = carouselItem.getItems();
            if (!(items instanceof Collection) || !items.isEmpty()) {
                Iterator<T> it = items.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (!(it.next() instanceof BrandspaceItem)) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isCategoryItemCarousel(@NotNull CarouselItem carouselItem) {
        Intrinsics.checkNotNullParameter(carouselItem, "$this$isCategoryItemCarousel");
        return (carouselItem.getItems().isEmpty() ^ true) && (CollectionsKt___CollectionsKt.first(carouselItem.getItems()) instanceof CategoryItem);
    }
}
