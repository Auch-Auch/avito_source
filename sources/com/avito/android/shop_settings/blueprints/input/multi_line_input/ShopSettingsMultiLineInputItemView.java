package com.avito.android.shop_settings.blueprints.input.multi_line_input;

import com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/input/multi_line_input/ShopSettingsMultiLineInputItemView;", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItemView;", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public interface ShopSettingsMultiLineInputItemView extends ShopSettingsInputItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ShopSettingsMultiLineInputItemView shopSettingsMultiLineInputItemView) {
            ShopSettingsInputItemView.DefaultImpls.onUnbind(shopSettingsMultiLineInputItemView);
        }
    }
}
