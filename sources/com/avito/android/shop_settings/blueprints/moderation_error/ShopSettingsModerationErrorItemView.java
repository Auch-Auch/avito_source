package com.avito.android.shop_settings.blueprints.moderation_error;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/moderation_error/ShopSettingsModerationErrorItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "", "setSubtitle", "(Ljava/lang/CharSequence;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public interface ShopSettingsModerationErrorItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ShopSettingsModerationErrorItemView shopSettingsModerationErrorItemView) {
            ItemView.DefaultImpls.onUnbind(shopSettingsModerationErrorItemView);
        }
    }

    void setSubtitle(@Nullable CharSequence charSequence);

    void setTitle(@NotNull String str);
}
