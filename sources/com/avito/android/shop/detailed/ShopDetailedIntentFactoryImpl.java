package com.avito.android.shop.detailed;

import android.app.Application;
import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ShopDetailedIntentFactory;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.navigation.NavigationTabProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ3\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/shop/detailed/ShopDetailedIntentFactoryImpl;", "Lcom/avito/android/ShopDetailedIntentFactory;", "", "shopId", "pageFrom", "shopContext", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Landroid/content/Intent;", "shopDetailedIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;)Landroid/content/Intent;", "Lcom/avito/android/navigation/NavigationTabProvider;", "c", "Lcom/avito/android/navigation/NavigationTabProvider;", "tabProvider", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "Lcom/avito/android/CoreActivityIntentFactory;", "d", "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "<init>", "(Landroid/app/Application;Lcom/avito/android/Features;Lcom/avito/android/navigation/NavigationTabProvider;Lcom/avito/android/CoreActivityIntentFactory;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopDetailedIntentFactoryImpl implements ShopDetailedIntentFactory {
    public final Application a;
    public final Features b;
    public final NavigationTabProvider c;
    public final CoreActivityIntentFactory d;

    @Inject
    public ShopDetailedIntentFactoryImpl(@NotNull Application application, @NotNull Features features, @NotNull NavigationTabProvider navigationTabProvider, @NotNull CoreActivityIntentFactory coreActivityIntentFactory) {
        Intrinsics.checkNotNullParameter(application, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(navigationTabProvider, "tabProvider");
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        this.a = application;
        this.b = features;
        this.c = navigationTabProvider;
        this.d = coreActivityIntentFactory;
    }

    @Override // com.avito.android.ShopDetailedIntentFactory
    @NotNull
    public Intent shopDetailedIntent(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull SearchParams searchParams) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        NavigationTab currentTab = this.c.currentTab();
        if (!this.b.getShopDetailedWithoutActivity().invoke().booleanValue() || currentTab == null) {
            return ShopDetailedActivityKt.createShopDetailedActivityIntent(this.a, str, str2, str3, searchParams);
        }
        return this.d.mainScreenWithTab(new ShopDetailedFragmentData(new ShopDetailedArguments(str, str2, str3, searchParams, null), currentTab));
    }
}
