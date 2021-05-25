package com.avito.android.shop_settings.blueprints;

import com.avito.conveyor_item.ParcelableItem;
import com.jakewharton.rxrelay2.BehaviorRelay;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/ShopSettingsItem;", "Lcom/avito/conveyor_item/ParcelableItem;", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "", "getDidChange", "()Lcom/jakewharton/rxrelay2/BehaviorRelay;", "didChange", "getShouldScrollTo", "()Z", "shouldScrollTo", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public interface ShopSettingsItem extends ParcelableItem {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getId(@NotNull ShopSettingsItem shopSettingsItem) {
            return ParcelableItem.DefaultImpls.getId(shopSettingsItem);
        }
    }

    @NotNull
    BehaviorRelay<Boolean> getDidChange();

    boolean getShouldScrollTo();
}
