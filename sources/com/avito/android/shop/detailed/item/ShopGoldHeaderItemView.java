package com.avito.android.shop.detailed.item;

import com.avito.android.image_loader.Picture;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopGoldHeaderItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/image_loader/Picture;", "logo", "", "setLogo", "(Lcom/avito/android/image_loader/Picture;)V", "hideLogo", "()V", "background", "setBackground", "hideBackground", "", "imageHeightPx", "setImageHeightPx", "(I)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopGoldHeaderItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ShopGoldHeaderItemView shopGoldHeaderItemView) {
            ItemView.DefaultImpls.onUnbind(shopGoldHeaderItemView);
        }
    }

    void hideBackground();

    void hideLogo();

    void setBackground(@NotNull Picture picture);

    void setImageHeightPx(int i);

    void setLogo(@NotNull Picture picture);
}
