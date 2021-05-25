package com.avito.android.shop.detailed;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import com.avito.android.FilterAnalyticsData;
import com.avito.android.PhoneRequestDeepLinkAnalyticsData;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.public_profile.ui.SubscriptionStateListener;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SellerVerification;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.shop.detailed.item.ShopDetailedRedesignView;
import com.avito.android.util.Kundle;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001#J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH&¢\u0006\u0004\b\u0015\u0010\fJ\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH&¢\u0006\u0004\b\u001a\u0010\fJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/avito/android/shop/detailed/ShopDetailedPresenter;", "Lcom/avito/android/shop/detailed/ShopDetailedViewPresenter;", "Lcom/avito/android/shop/detailed/ShopHeaderListener;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/public_profile/ui/SubscriptionStateListener;", "Lcom/avito/android/shop/detailed/AwardsClickListener;", "Lcom/avito/android/shop/detailed/item/ShopDetailedRedesignView;", "view", "", "attachView", "(Lcom/avito/android/shop/detailed/item/ShopDetailedRedesignView;)V", "detachView", "()V", "Lcom/avito/android/shop/detailed/ShopDetailedPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/shop/detailed/ShopDetailedPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onCallFailed", "", "message", "showMessage", "(Ljava/lang/String;)V", "setIsRestored", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onSearchClarified", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Landroidx/lifecycle/LiveData;", "getMakeCallStream", "()Landroidx/lifecycle/LiveData;", "makeCallStream", "Router", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopDetailedPresenter extends ShopDetailedViewPresenter, ShopHeaderListener, AdvertItemListener, SubscriptionStateListener, AwardsClickListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onMoreActionsClicked(@NotNull ShopDetailedPresenter shopDetailedPresenter, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            AdvertItemListener.DefaultImpls.onMoreActionsClicked(shopDetailedPresenter, str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJY\u0010\u0015\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\u0004J-\u0010\u001f\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b#\u0010$J!\u0010)\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010'H&¢\u0006\u0004\b)\u0010*J\u001f\u0010/\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-H&¢\u0006\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/avito/android/shop/detailed/ShopDetailedPresenter$Router;", "", "", "onBackClicked", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "itemId", "context", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "", "isMarketplace", "openFastAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Z)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "openUrl", "(Landroid/net/Uri;)V", "closeShop", "description", "Lcom/avito/android/remote/model/Action;", "action", "showPopup", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "awards", "openAwards", "(Lcom/avito/android/remote/model/SellerVerification$AwardsItem;)V", "Lcom/avito/android/deep_linking/links/PhoneRequestLink;", "link", "Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;", "analyticsData", "openPhoneRequest", "(Lcom/avito/android/deep_linking/links/PhoneRequestLink;Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;)V", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/FilterAnalyticsData;", "analyticsParams", "openFilters", "(Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/FilterAnalyticsData;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void closeShop();

        void followDeepLink(@NotNull DeepLink deepLink);

        void onBackClicked();

        void openAwards(@NotNull SellerVerification.AwardsItem awardsItem);

        void openFastAdvertDetails(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, @Nullable TreeClickStreamParent treeClickStreamParent, boolean z);

        void openFilters(@NotNull SearchParams searchParams, @NotNull FilterAnalyticsData filterAnalyticsData);

        void openPhoneRequest(@NotNull PhoneRequestLink phoneRequestLink, @Nullable PhoneRequestDeepLinkAnalyticsData phoneRequestDeepLinkAnalyticsData);

        void openUrl(@NotNull Uri uri);

        void showPopup(@Nullable String str, @Nullable String str2, @Nullable Action action);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull ShopDetailedRedesignView shopDetailedRedesignView);

    void detachRouter();

    void detachView();

    @NotNull
    LiveData<String> getMakeCallStream();

    void onCallFailed();

    @NotNull
    Kundle onSaveState();

    void onSearchClarified(@NotNull DeepLink deepLink);

    void setIsRestored();

    void showMessage(@NotNull String str);
}
