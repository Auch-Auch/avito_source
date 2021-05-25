package com.avito.android.brandspace.presenter;

import android.os.Bundle;
import com.avito.android.brandspace.items.carousel.CarouselItem;
import com.avito.android.brandspace.items.categories.CategoriesItem;
import com.avito.android.brandspace.items.marketplace.tab.MarketplaceTabsItem;
import com.avito.android.brandspace.router.BrandspaceRouter;
import com.avito.android.brandspace.view.BrandspaceView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\bJ\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001eH&¢\u0006\u0004\b\u001f\u0010 J'\u0010%\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\"2\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\"H&¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H&¢\u0006\u0004\b,\u0010-J#\u00101\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010.H&¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u000203H&¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020#2\u0006\u0010\u001b\u001a\u000203H&¢\u0006\u0004\b6\u00107¨\u00068"}, d2 = {"Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/brandspace/view/BrandspaceView;", "view", "", "onViewCreated", "(Lcom/avito/android/brandspace/view/BrandspaceView;)V", "onViewDestroyed", "()V", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "savedInstanceState", "onRestoreState", "(Landroid/os/Bundle;)V", "Lcom/avito/android/brandspace/router/BrandspaceRouter;", "router", "onViewStarted", "(Lcom/avito/android/brandspace/router/BrandspaceRouter;)V", "onViewStopped", "onViewResumed", "onViewPaused", "onUpClicked", "onRetryClicked", "", FirebaseAnalytics.Param.INDEX, "Lcom/avito/android/brandspace/items/categories/CategoriesItem;", "item", "onCategoriesClicked", "(ILcom/avito/android/brandspace/items/categories/CategoriesItem;)V", "Lcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabsItem;", "onTabCategoriesClicked", "(ILcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabsItem;)V", VKApiConst.POSITION, "Lcom/avito/android/brandspace/items/carousel/CarouselItem;", "", "isProgrammatic", "onCarouselCurrentPositionChanged", "(ILcom/avito/android/brandspace/items/carousel/CarouselItem;Z)V", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "onCarouselHeightChanged", "(ILcom/avito/android/brandspace/items/carousel/CarouselItem;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openDeeplink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "videoUrl", "blockType", "openVideoUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "onItemViewTracked", "(Lcom/avito/android/brandspace/presenter/BrandspaceItem;)V", "isLastItemInBlock", "(Lcom/avito/android/brandspace/presenter/BrandspaceItem;)Z", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface BrandspacePresenter extends AdvertItemListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onMoreActionsClicked(@NotNull BrandspacePresenter brandspacePresenter, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            AdvertItemListener.DefaultImpls.onMoreActionsClicked(brandspacePresenter, str);
        }
    }

    boolean isLastItemInBlock(@NotNull BrandspaceItem brandspaceItem);

    void onCarouselCurrentPositionChanged(int i, @NotNull CarouselItem carouselItem, boolean z);

    void onCarouselHeightChanged(int i, @NotNull CarouselItem carouselItem);

    void onCategoriesClicked(int i, @NotNull CategoriesItem categoriesItem);

    void onItemViewTracked(@NotNull BrandspaceItem brandspaceItem);

    void onRestoreState(@Nullable Bundle bundle);

    void onRetryClicked();

    @NotNull
    Bundle onSaveState();

    void onTabCategoriesClicked(int i, @NotNull MarketplaceTabsItem marketplaceTabsItem);

    void onUpClicked();

    void onViewCreated(@NotNull BrandspaceView brandspaceView);

    void onViewDestroyed();

    void onViewPaused();

    void onViewResumed();

    void onViewStarted(@NotNull BrandspaceRouter brandspaceRouter);

    void onViewStopped();

    void openDeeplink(@NotNull DeepLink deepLink);

    void openVideoUrl(@Nullable String str, @Nullable String str2);
}
