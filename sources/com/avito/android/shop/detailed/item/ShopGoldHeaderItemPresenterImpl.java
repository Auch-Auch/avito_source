package com.avito.android.shop.detailed.item;

import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop.detailed.ShopDetailedImageHeightProvider;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopGoldHeaderItemPresenterImpl;", "Lcom/avito/android/shop/detailed/item/ShopGoldHeaderItemPresenter;", "Lcom/avito/android/shop/detailed/item/ShopGoldHeaderItemView;", "view", "Lcom/avito/android/shop/detailed/item/ShopGoldHeaderItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/shop/detailed/item/ShopGoldHeaderItemView;Lcom/avito/android/shop/detailed/item/ShopGoldHeaderItem;I)V", "Lcom/avito/android/shop/detailed/ShopDetailedImageHeightProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/shop/detailed/ShopDetailedImageHeightProvider;", "shopDetailedImageHeightProvider", "<init>", "(Lcom/avito/android/shop/detailed/ShopDetailedImageHeightProvider;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopGoldHeaderItemPresenterImpl implements ShopGoldHeaderItemPresenter {
    public final ShopDetailedImageHeightProvider a;

    @Inject
    public ShopGoldHeaderItemPresenterImpl(@NotNull ShopDetailedImageHeightProvider shopDetailedImageHeightProvider) {
        Intrinsics.checkNotNullParameter(shopDetailedImageHeightProvider, "shopDetailedImageHeightProvider");
        this.a = shopDetailedImageHeightProvider;
    }

    public void bindView(@NotNull ShopGoldHeaderItemView shopGoldHeaderItemView, @NotNull ShopGoldHeaderItem shopGoldHeaderItem, int i) {
        Intrinsics.checkNotNullParameter(shopGoldHeaderItemView, "view");
        Intrinsics.checkNotNullParameter(shopGoldHeaderItem, "item");
        shopGoldHeaderItemView.setImageHeightPx(this.a.provideImageHeightPx());
        Picture pictureOf$default = AvitoPictureKt.pictureOf$default(shopGoldHeaderItem.getLogo(), false, 0.0f, 0.0f, null, 28, null);
        Picture pictureOf$default2 = AvitoPictureKt.pictureOf$default(shopGoldHeaderItem.getBackground(), false, 0.0f, 0.0f, null, 28, null);
        if (shopGoldHeaderItem.getBackground() == null) {
            shopGoldHeaderItemView.hideLogo();
            shopGoldHeaderItemView.hideBackground();
            return;
        }
        if (shopGoldHeaderItem.getLogo() != null) {
            shopGoldHeaderItemView.setLogo(pictureOf$default);
        } else {
            shopGoldHeaderItemView.hideLogo();
        }
        shopGoldHeaderItemView.setBackground(pictureOf$default2);
    }
}
