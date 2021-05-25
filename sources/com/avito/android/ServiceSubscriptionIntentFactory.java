package com.avito.android;

import android.content.Intent;
import com.avito.android.remote.model.shop_settings.ShopSettingsSelectData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/ServiceSubscriptionIntentFactory;", "", "Landroid/content/Intent;", "shopSettingsActivityIntent", "()Landroid/content/Intent;", "Lcom/avito/android/remote/model/shop_settings/ShopSettingsSelectData;", "data", "shopSettingsSelectActivityIntent", "(Lcom/avito/android/remote/model/shop_settings/ShopSettingsSelectData;)Landroid/content/Intent;", "serviceSubscriptionActivityIntent", "lfPackagesActivityIntent", "core_release"}, k = 1, mv = {1, 4, 2})
public interface ServiceSubscriptionIntentFactory {
    @NotNull
    Intent lfPackagesActivityIntent();

    @NotNull
    Intent serviceSubscriptionActivityIntent();

    @NotNull
    Intent shopSettingsActivityIntent();

    @NotNull
    Intent shopSettingsSelectActivityIntent(@NotNull ShopSettingsSelectData shopSettingsSelectData);
}
