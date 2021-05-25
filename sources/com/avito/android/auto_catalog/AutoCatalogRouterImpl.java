package com.avito.android.auto_catalog;

import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.SerpIntentFactory;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.ItemsSearchLink;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.util.Constants;
import com.avito.android.util.ImplicitIntentFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010,\u001a\u00020)¢\u0006\u0004\b5\u00106J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJG\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014JW\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/avito/android/auto_catalog/AutoCatalogRouterImpl;", "Lcom/avito/android/auto_catalog/AutoCatalogRouter;", "", "closeScreen", "()V", "", "url", "title", "openNativeShareDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "id", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "selectedValue", ResidentialComplexModuleKt.VALUES, "openSelectScreen", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "itemId", "context", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "", "isMarketplace", "openFastAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Z)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "c", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Landroid/content/res/Resources;", "d", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/auto_catalog/AutoCatalogFragmentDelegate;", "e", "Lcom/avito/android/auto_catalog/AutoCatalogFragmentDelegate;", "fragmentDelegate", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "<init>", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/util/ImplicitIntentFactory;Landroid/content/res/Resources;Lcom/avito/android/auto_catalog/AutoCatalogFragmentDelegate;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class AutoCatalogRouterImpl implements AutoCatalogRouter {
    public final DeepLinkIntentFactory a;
    public final ActivityIntentFactory b;
    public final ImplicitIntentFactory c;
    public final Resources d;
    public final AutoCatalogFragmentDelegate e;

    public AutoCatalogRouterImpl(@NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Resources resources, @NotNull AutoCatalogFragmentDelegate autoCatalogFragmentDelegate) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "implicitIntentFactory");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(autoCatalogFragmentDelegate, "fragmentDelegate");
        this.a = deepLinkIntentFactory;
        this.b = activityIntentFactory;
        this.c = implicitIntentFactory;
        this.d = resources;
        this.e = autoCatalogFragmentDelegate;
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogRouter
    public void closeScreen() {
        this.e.closeScreen();
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogRouter
    public void followDeepLink(@Nullable DeepLink deepLink) {
        Intent intent;
        if (deepLink instanceof ItemsSearchLink) {
            this.e.launchActivity(SerpIntentFactory.DefaultImpls.itemsListIntent$default(this.b, ((ItemsSearchLink) deepLink).getSearchParams(), null, null, null, true, false, 46, null));
        } else if (deepLink != null && (intent = this.a.getIntent(deepLink)) != null) {
            intent.removeExtra(Constants.UP_INTENT);
            this.e.launchActivity(intent);
        }
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogRouter
    public void openFastAdvertDetails(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, @NotNull TreeClickStreamParent treeClickStreamParent, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(treeClickStreamParent, "treeParent");
        Intent advertDetailsIntent$default = AdvertDetailsIntentFactory.DefaultImpls.advertDetailsIntent$default(this.b, str, str2, str3, str4, str5, image, z, treeClickStreamParent, SystemClock.elapsedRealtime(), null, this.e.tab(), null, 2560, null);
        advertDetailsIntent$default.removeExtra(Constants.UP_INTENT);
        this.e.launchActivity(advertDetailsIntent$default);
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogRouter
    public void openNativeShareDialog(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.e.launchActivityForResult(Intent.createChooser(this.c.shareItemIntent(str, str2), this.d.getString(R.string.menu_share)), 1);
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogRouter
    public void openSelectScreen(@NotNull String str, @NotNull String str2, @NotNull List<? extends ParcelableEntity<String>> list, @NotNull List<? extends ParcelableEntity<String>> list2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, "selectedValue");
        Intrinsics.checkNotNullParameter(list2, ResidentialComplexModuleKt.VALUES);
        this.e.launchSelectScreenForResult(str, str2, list, list2);
    }
}
