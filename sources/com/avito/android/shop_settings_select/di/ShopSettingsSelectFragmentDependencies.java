package com.avito.android.shop_settings_select.di;

import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.remote.ShopSettingsApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/shop_settings_select/di/ShopSettingsSelectFragmentDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/remote/ShopSettingsApi;", "shopSettingsApi", "()Lcom/avito/android/remote/ShopSettingsApi;", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public interface ShopSettingsSelectFragmentDependencies extends CoreComponentDependencies {
    @NotNull
    ShopSettingsApi shopSettingsApi();
}
