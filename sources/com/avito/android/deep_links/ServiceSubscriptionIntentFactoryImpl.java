package com.avito.android.deep_links;

import android.app.Application;
import android.content.Intent;
import com.avito.android.ServiceSubscriptionIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.shop_settings.ShopSettingsSelectData;
import com.avito.android.service_subscription.LfPackagesActivityKt;
import com.avito.android.service_subscription.ServiceSubscriptionActivityKt;
import com.avito.android.shop_settings.ShopSettingsActivityKt;
import com.avito.android.shop_settings_select.ShopSettingsSelectActivityKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/deep_links/ServiceSubscriptionIntentFactoryImpl;", "Lcom/avito/android/ServiceSubscriptionIntentFactory;", "Landroid/content/Intent;", "shopSettingsActivityIntent", "()Landroid/content/Intent;", "Lcom/avito/android/remote/model/shop_settings/ShopSettingsSelectData;", "data", "shopSettingsSelectActivityIntent", "(Lcom/avito/android/remote/model/shop_settings/ShopSettingsSelectData;)Landroid/content/Intent;", "serviceSubscriptionActivityIntent", "lfPackagesActivityIntent", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceSubscriptionIntentFactoryImpl implements ServiceSubscriptionIntentFactory {
    public final Application a;

    @Inject
    public ServiceSubscriptionIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @Override // com.avito.android.ServiceSubscriptionIntentFactory
    @NotNull
    public Intent lfPackagesActivityIntent() {
        return LfPackagesActivityKt.createLfPackagesIntent(this.a);
    }

    @Override // com.avito.android.ServiceSubscriptionIntentFactory
    @NotNull
    public Intent serviceSubscriptionActivityIntent() {
        return ServiceSubscriptionActivityKt.createSubscriptionIntent(this.a);
    }

    @Override // com.avito.android.ServiceSubscriptionIntentFactory
    @NotNull
    public Intent shopSettingsActivityIntent() {
        return ShopSettingsActivityKt.createShopSettingsIntent(this.a);
    }

    @Override // com.avito.android.ServiceSubscriptionIntentFactory
    @NotNull
    public Intent shopSettingsSelectActivityIntent(@NotNull ShopSettingsSelectData shopSettingsSelectData) {
        Intrinsics.checkNotNullParameter(shopSettingsSelectData, "data");
        return ShopSettingsSelectActivityKt.createShopSettingsSelectIntent(this.a, shopSettingsSelectData);
    }
}
