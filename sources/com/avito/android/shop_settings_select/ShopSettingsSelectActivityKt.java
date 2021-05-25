package com.avito.android.shop_settings_select;

import android.content.Context;
import android.content.Intent;
import com.avito.android.remote.model.shop_settings.ShopSettingsSelectData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\t\"\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/remote/model/shop_settings/ShopSettingsSelectData;", "data", "Landroid/content/Intent;", "createShopSettingsSelectIntent", "(Landroid/content/Context;Lcom/avito/android/remote/model/shop_settings/ShopSettingsSelectData;)Landroid/content/Intent;", "", "EXTRA_DATA", "Ljava/lang/String;", "EXTRA_RESULT", "service-subscription_release"}, k = 2, mv = {1, 4, 2})
public final class ShopSettingsSelectActivityKt {
    @NotNull
    public static final String EXTRA_DATA = "data";
    @NotNull
    public static final String EXTRA_RESULT = "result";

    @NotNull
    public static final Intent createShopSettingsSelectIntent(@NotNull Context context, @NotNull ShopSettingsSelectData shopSettingsSelectData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(shopSettingsSelectData, "data");
        Intent putExtra = new Intent(context, ShopSettingsSelectActivity.class).putExtra("data", shopSettingsSelectData);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…utExtra(EXTRA_DATA, data)");
        return putExtra;
    }
}
