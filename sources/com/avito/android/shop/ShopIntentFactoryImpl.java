package com.avito.android.shop;

import android.content.Context;
import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.ShopIntentFactory;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.shop.filter.ShopsFilterActivityKt;
import com.avito.android.shop.info.ShopInfoActivityKt;
import com.avito.android.shop.list.ShopListFragmentData;
import com.avito.android.shop.write_seller.WriteSellerActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/shop/ShopIntentFactoryImpl;", "Lcom/avito/android/ShopIntentFactory;", "", "shopId", "Landroid/content/Intent;", "writeSellerShopIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "searchParameters", "shopsListIntent", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;)Landroid/content/Intent;", "shopsFilterIntent", "shopInfoIntent", "Lcom/avito/android/CoreActivityIntentFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/CoreActivityIntentFactory;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopIntentFactoryImpl implements ShopIntentFactory {
    public final Context a;
    public final CoreActivityIntentFactory b;

    @Inject
    public ShopIntentFactoryImpl(@NotNull Context context, @NotNull CoreActivityIntentFactory coreActivityIntentFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        this.a = context;
        this.b = coreActivityIntentFactory;
    }

    @Override // com.avito.android.ShopIntentFactory
    @NotNull
    public Intent shopInfoIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        return ShopInfoActivityKt.createShopInfoActivityIntent(this.a, str);
    }

    @Override // com.avito.android.ShopIntentFactory
    @NotNull
    public Intent shopsFilterIntent(@NotNull ShopsSearchParameters shopsSearchParameters) {
        Intrinsics.checkNotNullParameter(shopsSearchParameters, "searchParameters");
        return ShopsFilterActivityKt.createShopsFilterActivityIntent(this.a, shopsSearchParameters);
    }

    @Override // com.avito.android.ShopIntentFactory
    @NotNull
    public Intent shopsListIntent(@NotNull ShopsSearchParameters shopsSearchParameters) {
        Intrinsics.checkNotNullParameter(shopsSearchParameters, "searchParameters");
        return this.b.mainScreenWithTab(new ShopListFragmentData(shopsSearchParameters, null, NavigationTab.SEARCH.INSTANCE));
    }

    @Override // com.avito.android.ShopIntentFactory
    @NotNull
    public Intent writeSellerShopIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        return new WriteSellerActivity.IntentFactory().create(this.a, str);
    }
}
