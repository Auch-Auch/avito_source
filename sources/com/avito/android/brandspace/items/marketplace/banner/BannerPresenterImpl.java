package com.avito.android.brandspace.items.marketplace.banner;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/banner/BannerPresenterImpl;", "Lcom/avito/android/brandspace/items/marketplace/banner/BannerPresenter;", "Lcom/avito/android/brandspace/items/marketplace/banner/BannerItemView;", "view", "Lcom/avito/android/brandspace/items/marketplace/banner/BannerItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/brandspace/items/marketplace/banner/BannerItemView;Lcom/avito/android/brandspace/items/marketplace/banner/BannerItem;I)V", "<init>", "()V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BannerPresenterImpl implements BannerPresenter {
    public void bindView(@NotNull BannerItemView bannerItemView, @NotNull BannerItem bannerItem, int i) {
        Intrinsics.checkNotNullParameter(bannerItemView, "view");
        Intrinsics.checkNotNullParameter(bannerItem, "item");
        bannerItemView.setImage(bannerItem.getImage());
        bannerItemView.setTitle(bannerItem.getTitle());
        bannerItemView.setDescription(bannerItem.getDescription());
        bannerItemView.setUptitle(bannerItem.getUptitle());
        bannerItemView.setBackground(bannerItem.getBgColor());
    }
}
