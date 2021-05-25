package com.avito.android.brandspace.items.marketplace.carouselLoader;

import com.avito.android.brandspace.items.marketplace.skeleton.SkeletonItem;
import com.avito.android.brandspace.presenter.BrandspaceResourcesProvider;
import com.avito.android.brandspace.presenter.virtualitems.AddableItemsWithLoadingBrandspaceItem;
import com.avito.android.brandspace.presenter.virtualitems.SnippetCarouselLoader;
import com.avito.android.brandspace.presenter.virtualitems.SnippetGridLoader;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderPresenterImpl;", "Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderPresenter;", "Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderItemView;", "view", "Lcom/avito/android/brandspace/presenter/virtualitems/AddableItemsWithLoadingBrandspaceItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderItemView;Lcom/avito/android/brandspace/presenter/virtualitems/AddableItemsWithLoadingBrandspaceItem;I)V", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "brandspaceResourcesProvider", "Lcom/avito/android/brandspace/items/marketplace/skeleton/SkeletonItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/marketplace/skeleton/SkeletonItem;", "skeletonItem", "<init>", "(Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;Lcom/avito/android/brandspace/items/marketplace/skeleton/SkeletonItem;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class CarouselLoaderPresenterImpl implements CarouselLoaderPresenter {
    public final BrandspaceResourcesProvider a;
    public final SkeletonItem b;

    @Inject
    public CarouselLoaderPresenterImpl(@NotNull BrandspaceResourcesProvider brandspaceResourcesProvider, @NotNull SkeletonItem skeletonItem) {
        Intrinsics.checkNotNullParameter(brandspaceResourcesProvider, "brandspaceResourcesProvider");
        Intrinsics.checkNotNullParameter(skeletonItem, "skeletonItem");
        this.a = brandspaceResourcesProvider;
        this.b = skeletonItem;
    }

    public void bindView(@NotNull CarouselLoaderItemView carouselLoaderItemView, @NotNull AddableItemsWithLoadingBrandspaceItem addableItemsWithLoadingBrandspaceItem, int i) {
        Intrinsics.checkNotNullParameter(carouselLoaderItemView, "view");
        Intrinsics.checkNotNullParameter(addableItemsWithLoadingBrandspaceItem, "item");
        int brandspaceColumnCount = this.a.getBrandspaceColumnCount();
        int i2 = this.a.isTablet() ? 2 : 1;
        boolean z = addableItemsWithLoadingBrandspaceItem instanceof SnippetCarouselLoader;
        if (z) {
            brandspaceColumnCount = brandspaceColumnCount * brandspaceColumnCount * i2;
        } else if (addableItemsWithLoadingBrandspaceItem instanceof SnippetGridLoader) {
            brandspaceColumnCount *= 3;
        }
        ArrayList arrayList = new ArrayList(brandspaceColumnCount);
        for (int i3 = 0; i3 < brandspaceColumnCount; i3++) {
            arrayList.add(this.b);
        }
        if (z) {
            carouselLoaderItemView.bindHorizontal(arrayList);
        } else if (addableItemsWithLoadingBrandspaceItem instanceof SnippetGridLoader) {
            carouselLoaderItemView.bindGrid(arrayList);
        }
    }
}
