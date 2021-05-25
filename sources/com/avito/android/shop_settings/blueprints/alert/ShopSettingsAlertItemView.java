package com.avito.android.shop_settings.blueprints.alert;

import com.avito.android.shop_settings.blueprints.alert.ShopSettingsAlertItem;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/alert/ShopSettingsAlertItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "setSubtitle", "Lcom/avito/android/shop_settings/blueprints/alert/ShopSettingsAlertItem$Style;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "setStyle", "(Lcom/avito/android/shop_settings/blueprints/alert/ShopSettingsAlertItem$Style;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public interface ShopSettingsAlertItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ShopSettingsAlertItemView shopSettingsAlertItemView) {
            ItemView.DefaultImpls.onUnbind(shopSettingsAlertItemView);
        }
    }

    void setStyle(@NotNull ShopSettingsAlertItem.Style style);

    void setSubtitle(@Nullable String str);

    void setTitle(@NotNull String str);
}
