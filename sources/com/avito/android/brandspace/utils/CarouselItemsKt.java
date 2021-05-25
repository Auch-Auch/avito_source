package com.avito.android.brandspace.utils;

import com.avito.android.brandspace.items.carousel.CarouselItem;
import com.avito.android.brandspace.presenter.virtualitems.SnippetCarouselLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/brandspace/items/carousel/CarouselItem;", "Lcom/avito/android/brandspace/presenter/virtualitems/SnippetCarouselLoader;", "toSnippetCarouselLoader", "(Lcom/avito/android/brandspace/items/carousel/CarouselItem;)Lcom/avito/android/brandspace/presenter/virtualitems/SnippetCarouselLoader;", "brandspace_release"}, k = 2, mv = {1, 4, 2})
public final class CarouselItemsKt {
    @NotNull
    public static final SnippetCarouselLoader toSnippetCarouselLoader(@NotNull CarouselItem carouselItem) {
        Intrinsics.checkNotNullParameter(carouselItem, "$this$toSnippetCarouselLoader");
        return new SnippetCarouselLoader(carouselItem.getId(), carouselItem.getType(), carouselItem);
    }
}
