package com.avito.android.search.map.view.advert;

import com.avito.android.analytics.event.ContactSource;
import com.avito.android.async_phone.AsyncPhoneItem;
import com.avito.android.async_phone.AsyncPhoneRequestData;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.search.map.view.advert.AdvertItemEvent;
import com.avito.android.search.map.view.advert.AdvertItemEventListener;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItem;
import com.avito.android.serp.adapter.promo_card.PromoCardItem;
import com.avito.android.serp.adapter.warning.SerpWarningItem;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\bG\u0010HJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\"\u0010!J\u0017\u0010#\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b#\u0010!J\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0019H\u0016¢\u0006\u0004\b%\u0010&J3\u0010(\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010'\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b(\u0010)J3\u0010*\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010'\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b*\u0010+J'\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u0017\u0010\u001fJ\u001f\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020,2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016¢\u0006\u0004\b0\u0010!J\u0017\u00101\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016¢\u0006\u0004\b1\u0010!J'\u00105\u001a\u00020\b2\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\b2\u0006\u00103\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020\b2\u0006\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b<\u0010=J\u001f\u0010@\u001a\u00020\b2\u0006\u0010?\u001a\u00020>2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016¢\u0006\u0004\bB\u0010!R\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006I"}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEventListenerImpl;", "Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent;", "events", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/serp/adapter/FavorableItem;", "favorableItem", "", "onFavoriteButtonClicked", "(Lcom/avito/android/serp/adapter/FavorableItem;)V", "Lcom/avito/android/serp/adapter/AdvertItem;", "advert", "", VKApiConst.POSITION, "Lcom/avito/android/remote/model/Image;", "image", "onAdvertClicked", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;)V", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;ILcom/avito/android/remote/model/Image;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "onCallActionClicked", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;Lcom/avito/android/deep_linking/links/DeepLink;)V", "", BookingInfoActivity.EXTRA_ITEM_ID, "deepLink", "Lcom/avito/android/analytics/event/ContactSource;", "contactSource", "onWriteActionClicked", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/event/ContactSource;)V", "onDeepLinkActionClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onFollowDeeplinkFromEmpty", "onSellerItemClick", "itemId", "onItemClose", "(Ljava/lang/String;)V", "galleryPosition", "onRichAdvertXlClicked", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;ILcom/avito/android/remote/model/Image;Ljava/lang/Integer;)V", "onRichAdvertClicked", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;Ljava/lang/Integer;)V", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "onAdBannerOpened", "(Lcom/avito/android/serp/ad/BannerInfo;I)V", "onWitcherSearchButtonClicked", "onSearchOnMapClicked", "Lcom/avito/android/async_phone/AsyncPhoneItem;", "item", "src", "showAuth", "(Lcom/avito/android/async_phone/AsyncPhoneItem;Ljava/lang/String;Lcom/avito/android/analytics/event/ContactSource;)V", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;", "onBannerClicked", "(Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;)V", "Lcom/avito/android/remote/model/Action;", "action", "onSerpWarningAction", "(Lcom/avito/android/remote/model/Action;)V", "Lcom/avito/android/serp/adapter/warning/SerpWarningItem;", "warning", "onSerpWarningClosed", "(Lcom/avito/android/serp/adapter/warning/SerpWarningItem;I)V", "onAdditionalActionClicked", "Lcom/jakewharton/rxrelay3/Relay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/Relay;", "relay", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertItemEventListenerImpl implements AdvertItemEventListener {
    public final Relay<AdvertItemEvent> a;

    @Inject
    public AdvertItemEventListenerImpl() {
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
    }

    @Override // com.avito.android.search.map.view.advert.AdvertItemEventProvider
    @NotNull
    public Observable<AdvertItemEvent> events() {
        Observable<AdvertItemEvent> hide = this.a.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "relay.hide()");
        return hide;
    }

    @Override // com.avito.android.serp.adapter.AdBannerEventListener
    public void onAdBannerOpened(@NotNull BannerInfo bannerInfo, int i) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        this.a.accept(new AdvertItemEvent.AdBannerOpened(bannerInfo, i));
    }

    @Override // com.avito.android.serp.adapter.GroupingListener
    public void onAdditionalActionClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.a.accept(new AdvertItemEvent.GroupClicked(deepLink));
    }

    @Override // com.avito.android.serp.adapter.AdvertItemListener
    public void onAdvertClicked(@NotNull AdvertItem advertItem, int i, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(advertItem, "advert");
        this.a.accept(new AdvertItemEvent.AdvertClicked(advertItem, i, image));
    }

    @Override // com.avito.android.serp.adapter.promo_card.PromoCardItemPresenter.Router
    public void onBannerClicked(@NotNull PromoCardItem promoCardItem) {
        Intrinsics.checkNotNullParameter(promoCardItem, "item");
        this.a.accept(new AdvertItemEvent.DeepLinkClicked(promoCardItem.getAction()));
    }

    @Override // com.avito.android.serp.adapter.advert_xl.AdvertXlItemListener
    public void onCallActionClicked(@NotNull AdvertXlItem advertXlItem, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(advertXlItem, "advert");
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        this.a.accept(new AdvertItemEvent.AdvertCall(advertXlItem.getStringId(), deepLink, ContactSource.CONTACT_XL));
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener
    public void onDeepLinkActionClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.a.accept(new AdvertItemEvent.DeepLinkClicked(deepLink));
    }

    @Override // com.avito.android.favorite.FavoriteButtonClickListener
    public void onFavoriteButtonClicked(@NotNull FavorableItem favorableItem) {
        Intrinsics.checkNotNullParameter(favorableItem, "favorableItem");
        this.a.accept(new AdvertItemEvent.FavoriteButtonClicked(favorableItem));
    }

    @Override // com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemListener
    public void onFollowDeeplinkFromEmpty(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.a.accept(new AdvertItemEvent.EmptyPlaceholderActionClicked(deepLink));
    }

    @Override // com.avito.android.serp.adapter.OnCloseItemListener
    public void onItemClose(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
    }

    @Override // com.avito.android.advert.actions.MoreActionsClickListener
    public void onMoreActionsClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        AdvertItemEventListener.DefaultImpls.onMoreActionsClicked(this, str);
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener
    public void onRichAdvertClicked(@NotNull AdvertItem advertItem, int i, @Nullable Image image, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(advertItem, "advert");
        this.a.accept(new AdvertItemEvent.AdvertClicked(advertItem, i, image));
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener
    public void onRichAdvertXlClicked(@NotNull AdvertXlItem advertXlItem, int i, @Nullable Image image, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(advertXlItem, "advert");
        this.a.accept(new AdvertItemEvent.AdvertXlClicked(advertXlItem, i, image));
    }

    @Override // com.avito.android.serp.adapter.map_banner.MapBannerItemListener
    public void onSearchOnMapClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.a.accept(new AdvertItemEvent.MapBannerItemSearchOnMapClicked(deepLink));
    }

    @Override // com.avito.android.serp.adapter.SellerItemListener
    public void onSellerItemClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        this.a.accept(new AdvertItemEvent.DeepLinkClicked(deepLink));
    }

    @Override // com.avito.android.serp.adapter.warning.SerpWarningItemListener
    public void onSerpWarningAction(@NotNull Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.a.accept(new AdvertItemEvent.WarningItemActionClicked(action.getDeepLink()));
    }

    @Override // com.avito.android.serp.adapter.warning.SerpWarningItemListener
    public void onSerpWarningClosed(@NotNull SerpWarningItem serpWarningItem, int i) {
        Intrinsics.checkNotNullParameter(serpWarningItem, "warning");
        this.a.accept(new AdvertItemEvent.WarningItemCloseClicked(serpWarningItem, i));
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemListener
    public void onWitcherSearchButtonClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.a.accept(new AdvertItemEvent.WitcherItemSearchButtonClicked(deepLink));
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener
    public void onWriteActionClicked(@NotNull String str, @NotNull DeepLink deepLink, @NotNull ContactSource contactSource) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(contactSource, "contactSource");
        this.a.accept(new AdvertItemEvent.AdvertWrite(str, deepLink, contactSource));
    }

    @Override // com.avito.android.async_phone.AsyncPhoneAuthRouter
    public void showAuth(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "src");
        AdvertItemEventListener.DefaultImpls.showAuth(this, str);
    }

    @Override // com.avito.android.serp.adapter.advert_xl.AdvertXlItemListener
    public void onAdvertClicked(@NotNull AdvertXlItem advertXlItem, int i, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(advertXlItem, "advert");
        this.a.accept(new AdvertItemEvent.AdvertXlClicked(advertXlItem, i, image));
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener
    public void onCallActionClicked(@NotNull String str, @NotNull DeepLink deepLink, @NotNull ContactSource contactSource) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(contactSource, "contactSource");
        this.a.accept(new AdvertItemEvent.AdvertCall(str, deepLink, contactSource));
    }

    @Override // com.avito.android.async_phone.AsyncPhoneAuthRouter
    public void showAuth(@NotNull AsyncPhoneItem asyncPhoneItem, @NotNull String str, @NotNull ContactSource contactSource) {
        Intrinsics.checkNotNullParameter(asyncPhoneItem, "item");
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(contactSource, "contactSource");
        this.a.accept(new AdvertItemEvent.AuthForPhoneRequest(new AsyncPhoneRequestData(asyncPhoneItem, contactSource)));
    }
}
