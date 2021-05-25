package com.avito.android.brandspace.router;

import android.content.Intent;
import android.os.SystemClock;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.PlayerIntentFactory;
import com.avito.android.SerpIntentFactory;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.ItemsSearchLink;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.ui.fragments.TabBaseFragment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010-\u001a\u00020*¢\u0006\u0004\b.\u0010/J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016JW\u0010 \u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/avito/android/brandspace/router/BrandspaceRouterImpl;", "Lcom/avito/android/brandspace/router/BrandspaceRouter;", "", "id", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "source", "", "openBrandspace", "(Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;)V", "closeScreen", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "url", "slug", "blockType", "Lcom/avito/android/rec/ScreenSource;", "screenSource", "openMedia", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/rec/ScreenSource;)V", "itemId", "context", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "", "isMarketplace", "openAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Z)V", "Lcom/avito/android/ActivityIntentFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ui/fragments/TabBaseFragment;", AuthSource.SEND_ABUSE, "Lcom/avito/android/ui/fragments/TabBaseFragment;", "fragment", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "c", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "<init>", "(Lcom/avito/android/ui/fragments/TabBaseFragment;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceRouterImpl implements BrandspaceRouter {
    public final TabBaseFragment a;
    public final ActivityIntentFactory b;
    public final DeepLinkIntentFactory c;

    @Inject
    public BrandspaceRouterImpl(@NotNull TabBaseFragment tabBaseFragment, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(tabBaseFragment, "fragment");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        this.a = tabBaseFragment;
        this.b = activityIntentFactory;
        this.c = deepLinkIntentFactory;
    }

    @Override // com.avito.android.brandspace.router.BrandspaceRouter
    public void closeScreen() {
        this.a.finish();
    }

    @Override // com.avito.android.brandspace.router.BrandspaceRouter
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intent intent;
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (deepLink instanceof ItemsSearchLink) {
            ItemsSearchLink itemsSearchLink = (ItemsSearchLink) deepLink;
            intent = SerpIntentFactory.DefaultImpls.itemsListIntent$default(this.b, itemsSearchLink.getSearchParams(), itemsSearchLink.getContext(), null, ScreenSource.BRANDSPACE.INSTANCE.getSource(), true, false, 36, null);
        } else {
            intent = this.c.getIntent(deepLink);
        }
        if (intent != null) {
            this.a.startActivity(intent);
        }
    }

    @Override // com.avito.android.brandspace.router.BrandspaceRouter
    public void openAdvertDetails(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, @NotNull TreeClickStreamParent treeClickStreamParent, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(treeClickStreamParent, "treeParent");
        this.a.startActivity(AdvertDetailsIntentFactory.DefaultImpls.advertDetailsIntent$default(this.b, str, str2, str3, str4, str5, image, z, treeClickStreamParent, SystemClock.elapsedRealtime(), null, this.a.currentTab(), ScreenSource.BRANDSPACE.INSTANCE, 512, null));
    }

    @Override // com.avito.android.brandspace.router.BrandspaceRouter
    public void openBrandspace(@NotNull String str, @NotNull TreeClickStreamParent treeClickStreamParent, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(treeClickStreamParent, "treeParent");
        this.a.startActivity(this.b.brandspaceIntent(str, treeClickStreamParent, str2, this.a.currentTab()));
    }

    @Override // com.avito.android.brandspace.router.BrandspaceRouter
    public void openMedia(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull TreeClickStreamParent treeClickStreamParent, @NotNull ScreenSource screenSource) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(treeClickStreamParent, "treeParent");
        Intrinsics.checkNotNullParameter(screenSource, "screenSource");
        this.a.startActivity(PlayerIntentFactory.DefaultImpls.playerIntent$default(this.b, str, str2, str3, treeClickStreamParent, screenSource, null, 32, null));
    }
}
