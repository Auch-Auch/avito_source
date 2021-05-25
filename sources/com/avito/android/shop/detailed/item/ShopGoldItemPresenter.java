package com.avito.android.shop.detailed.item;

import com.avito.android.util.Kundle;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopGoldItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/shop/detailed/item/ShopGoldItemView;", "Lcom/avito/android/shop/detailed/item/ShopGoldItem;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopGoldItemPresenter extends ItemPresenter<ShopGoldItemView, ShopGoldItem> {
    @NotNull
    Kundle onSaveState();
}
