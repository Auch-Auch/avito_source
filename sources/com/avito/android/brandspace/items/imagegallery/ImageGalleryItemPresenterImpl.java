package com.avito.android.brandspace.items.imagegallery;

import com.avito.android.brandspace.presenter.BrandspaceResourcesProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DeviceMetrics;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryItemPresenterImpl;", "Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryItemPresenter;", "Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryItemView;", "view", "Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryItemView;Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryItem;I)V", "Lcom/avito/android/util/DeviceMetrics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "resources", "<init>", "(Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class ImageGalleryItemPresenterImpl implements ImageGalleryItemPresenter {
    public final DeviceMetrics a;
    public final BrandspaceResourcesProvider b;

    @Inject
    public ImageGalleryItemPresenterImpl(@NotNull DeviceMetrics deviceMetrics, @NotNull BrandspaceResourcesProvider brandspaceResourcesProvider) {
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(brandspaceResourcesProvider, "resources");
        this.a = deviceMetrics;
        this.b = brandspaceResourcesProvider;
    }

    public void bindView(@NotNull ImageGalleryItemView imageGalleryItemView, @NotNull ImageGalleryItem imageGalleryItem, int i) {
        Intrinsics.checkNotNullParameter(imageGalleryItemView, "view");
        Intrinsics.checkNotNullParameter(imageGalleryItem, "item");
        imageGalleryItemView.bind(imageGalleryItem.getImage(), this.a.getDisplayWidth() - (this.b.getContentHorizontalPadding() * 2));
    }
}
