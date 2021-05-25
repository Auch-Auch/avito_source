package com.avito.android.notification_center.landing.recommends.item.advert;

import android.net.Uri;
import android.view.View;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.expected.badge_bar.BadgeViewListener;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.RadiusInfo;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.server_time.TimeSource;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.SerpAdvertListCard;
import ru.avito.component.serp.SerpAdvertListCardImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010w\u001a\u00020v\u0012\u0006\u0010y\u001a\u00020x\u0012\u0006\u0010{\u001a\u00020z\u0012\u0006\u0010}\u001a\u00020|¢\u0006\u0004\b~\u0010J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u000eJ\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u000eJ\u0019\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u000eJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001cJ\u001f\u0010!\u001a\u00020\u00042\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\u00042\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b#\u0010\"J\u001f\u0010$\u001a\u00020\u00042\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b$\u0010\"J*\u0010*\u001a\u00020\u00042\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%2\b\u0010)\u001a\u0004\u0018\u00010(H\u0001¢\u0006\u0004\b*\u0010+J\u0018\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0004H\u0001¢\u0006\u0004\b1\u0010\u0006J\u0018\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0019H\u0001¢\u0006\u0004\b3\u0010\u001cJ\u001a\u00105\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\b5\u0010\u000eJ\u001a\u00106\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\b6\u0010\u000eJ\u001a\u00107\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\b7\u0010\u000eJ\u0018\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0001¢\u0006\u0004\b:\u0010;J\u001a\u0010=\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\b=\u0010\u000eJ \u0010>\u001a\u00020\u00042\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0004\b>\u0010\"J\u0018\u0010A\u001a\u00020\u00042\u0006\u0010@\u001a\u00020?H\u0001¢\u0006\u0004\bA\u0010BJ\u0018\u0010D\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0019H\u0001¢\u0006\u0004\bD\u0010\u001cJ\u001a\u0010E\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\bE\u0010\u000eJ\u0018\u0010G\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0019H\u0001¢\u0006\u0004\bG\u0010\u001cJ\u0018\u0010I\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0019H\u0001¢\u0006\u0004\bI\u0010\u001cJ\u0018\u0010K\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u0019H\u0001¢\u0006\u0004\bK\u0010\u001cJ\u0010\u0010L\u001a\u00020\u0004H\u0001¢\u0006\u0004\bL\u0010\u0006J\u0018\u0010N\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0019H\u0001¢\u0006\u0004\bN\u0010\u001cJ\u001a\u0010P\u001a\u00020\u00042\b\u0010O\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\bP\u0010\u000eJ\u001a\u0010Q\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\bQ\u0010\u000eJ$\u0010T\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010S\u001a\u0004\u0018\u00010RH\u0001¢\u0006\u0004\bT\u0010UJ$\u0010W\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010\u000b2\b\u0010V\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\bW\u0010XJ \u0010Y\u001a\u00020\u00042\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0004\bY\u0010\"J \u0010Z\u001a\u00020\u00042\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0004\bZ\u0010\"J$\u0010\\\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\b\\\u0010]J\"\u0010_\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010^\u001a\u00020\u0019H\u0001¢\u0006\u0004\b_\u0010`J\u001a\u0010a\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\ba\u0010\u000eJ\"\u0010b\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010S\u001a\u00020RH\u0001¢\u0006\u0004\bb\u0010UJ\"\u0010c\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010S\u001a\u00020RH\u0001¢\u0006\u0004\bc\u0010UJ\u001a\u0010e\u001a\u00020\u00042\b\u0010d\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\be\u0010\u000eJ\u001a\u0010g\u001a\u00020\u00042\b\u0010f\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\bg\u0010\u000eJ\u0018\u0010h\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\bh\u0010\u000eJ\u0018\u0010i\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0019H\u0001¢\u0006\u0004\bi\u0010\u001cJ\u001a\u0010j\u001a\u00020\u00042\b\u0010O\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\bj\u0010\u000eJ\u0018\u0010l\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u0019H\u0001¢\u0006\u0004\bl\u0010\u001cJ\u0018\u0010n\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u0019H\u0001¢\u0006\u0004\bn\u0010\u001cJ\u0018\u0010q\u001a\u00020\u00042\u0006\u0010p\u001a\u00020oH\u0001¢\u0006\u0004\bq\u0010rR\u001e\u0010u\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bs\u0010t¨\u0006\u0001"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItemView;", "Lru/avito/component/serp/SerpAdvertListCard;", "", "onUnbind", "()V", "Lcom/avito/android/remote/model/Image;", "image", "setAdvertImage", "(Lcom/avito/android/remote/model/Image;)V", "", "title", "setAdvertTitle", "(Ljava/lang/String;)V", "price", "setAdvertPrice", "priceWithoutDiscount", "setAdvertPriceWithoutDiscount", "location", "setAdvertLocation", Sort.DISTANCE, "setAdvertDistance", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAdvertAddress", "", "isFavorite", "setAdvertIsFavorite", "(Z)V", "isViewed", "setAdvertIsViewed", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAdvertClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setAdvertFavoriteClickListener", "setAdvertUnbindListener", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "bindBadgeBar", "(Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "hideBadge", "active", "setActive", "text", "setAdditionalActionText", "setAdditionalName", "setAddress", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "oldPrice", "setClassifiedDiscount", "setClickListener", "", "time", "setDate", "(J)V", "isShowDelivery", "setDeliveryVisible", "setDistance", "favorite", "setFavorite", "enabled", "setFavoriteButtonEnabled", "visible", "setFavoriteVisible", "setFavoritesButtonImageResource", "hasVideo", "setHasVideo", "value", "setInStock", "setLocation", "Lcom/avito/android/remote/model/RadiusInfo;", "radiusInfo", "setLocationPostponed", "(Ljava/lang/String;Lcom/avito/android/remote/model/RadiusInfo;)V", "discountPercentage", "setMarketplaceDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "setOnAdditionalActionClickListener", "setOnFavoriteButtonClickListener", BookingInfoActivity.EXTRA_ITEM_ID, "setPicture", "(Lcom/avito/android/image_loader/Picture;Ljava/lang/String;)V", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "setPriceWithoutDiscount", "setRadiusAddress", "setRadiusLocation", "shopName", "setShopName", "tag", "setShortTermRentTag", "setTitle", "setTitleRightMarginEnabled", "setTrustFactor", "enlarged", "setVideoIconEnlarged", "viewed", "setViewed", "", "widthPx", "setWidth", "(I)V", "s", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/View;", "view", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "<init>", "(Landroid/view/View;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingRecommendsAdvertItemViewImpl extends BaseViewHolder implements NotificationCenterLandingRecommendsAdvertItemView, SerpAdvertListCard {
    public Function0<Unit> s;
    public final /* synthetic */ SerpAdvertListCardImpl t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationCenterLandingRecommendsAdvertItemViewImpl(@NotNull View view, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull ConnectivityProvider connectivityProvider) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        this.t = new SerpAdvertListCardImpl(view, timeSource, locale, null, connectivityProvider, 8, null);
        setFavoriteVisible(true);
        setTitleRightMarginEnabled(true);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void bindBadgeBar(@Nullable List<SerpBadge> list, @Nullable BadgeViewListener badgeViewListener) {
        this.t.bindBadgeBar(list, badgeViewListener);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        return this.t.getPictureUri(picture);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void hideBadge() {
        this.t.hideBadge();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.s;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setActive(boolean z) {
        this.t.setActive(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setAdditionalActionText(@Nullable String str) {
        this.t.setAdditionalActionText(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setAdditionalName(@Nullable String str) {
        this.t.setAdditionalName(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setAddress(@Nullable String str) {
        this.t.setAddress(str);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemView
    public void setAdvertAddress(@Nullable String str) {
        setAddress(str);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemView
    public void setAdvertClickListener(@Nullable Function0<Unit> function0) {
        setClickListener(function0);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemView
    public void setAdvertDistance(@Nullable String str) {
        setDistance(str);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemView
    public void setAdvertFavoriteClickListener(@Nullable Function0<Unit> function0) {
        setOnFavoriteButtonClickListener(function0);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemView
    public void setAdvertImage(@NotNull Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        SerpAdvertListCard.DefaultImpls.setPicture$default(this, AvitoPictureKt.pictureOf$default(image, false, 0.0f, 0.0f, null, 28, null), null, 2, null);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemView
    public void setAdvertIsFavorite(boolean z) {
        setFavorite(z);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemView
    public void setAdvertIsViewed(boolean z) {
        setViewed(z);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemView
    public void setAdvertLocation(@Nullable String str) {
        setLocation(str);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemView
    public void setAdvertPrice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "price");
        setPrice(str, false);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemView
    public void setAdvertPriceWithoutDiscount(@Nullable String str) {
        setPriceWithoutDiscount(str);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemView
    public void setAdvertTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        setTitle(str);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemView
    public void setAdvertUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setBadge(@NotNull Badge badge) {
        Intrinsics.checkNotNullParameter(badge, "badge");
        this.t.setBadge(badge);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setClassifiedDiscount(@Nullable String str) {
        this.t.setClassifiedDiscount(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setClickListener(@Nullable Function0<Unit> function0) {
        this.t.setClickListener(function0);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setDate(long j) {
        this.t.setDate(j);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setDeliveryVisible(boolean z) {
        this.t.setDeliveryVisible(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setDistance(@Nullable String str) {
        this.t.setDistance(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setFavorite(boolean z) {
        this.t.setFavorite(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setFavoriteButtonEnabled(boolean z) {
        this.t.setFavoriteButtonEnabled(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setFavoriteVisible(boolean z) {
        this.t.setFavoriteVisible(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setFavoritesButtonImageResource() {
        this.t.setFavoritesButtonImageResource();
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setHasVideo(boolean z) {
        this.t.setHasVideo(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setInStock(@Nullable String str) {
        this.t.setInStock(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setLocation(@Nullable String str) {
        this.t.setLocation(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setLocationPostponed(@Nullable String str, @Nullable RadiusInfo radiusInfo) {
        this.t.setLocationPostponed(str, radiusInfo);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setMarketplaceDiscount(@Nullable String str, @Nullable String str2) {
        this.t.setMarketplaceDiscount(str, str2);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setOnAdditionalActionClickListener(@Nullable Function0<Unit> function0) {
        this.t.setOnAdditionalActionClickListener(function0);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setOnFavoriteButtonClickListener(@Nullable Function0<Unit> function0) {
        this.t.setOnFavoriteButtonClickListener(function0);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setPicture(@NotNull Picture picture, @Nullable String str) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        this.t.setPicture(picture, str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setPrice(@Nullable String str, boolean z) {
        this.t.setPrice(str, z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setPriceWithoutDiscount(@Nullable String str) {
        this.t.setPriceWithoutDiscount(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setRadiusAddress(@Nullable String str, @NotNull RadiusInfo radiusInfo) {
        Intrinsics.checkNotNullParameter(radiusInfo, "radiusInfo");
        this.t.setRadiusAddress(str, radiusInfo);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setRadiusLocation(@Nullable String str, @NotNull RadiusInfo radiusInfo) {
        Intrinsics.checkNotNullParameter(radiusInfo, "radiusInfo");
        this.t.setRadiusLocation(str, radiusInfo);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setShopName(@Nullable String str) {
        this.t.setShopName(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setShortTermRentTag(@Nullable String str) {
        this.t.setShortTermRentTag(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setTitle(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setTitleRightMarginEnabled(boolean z) {
        this.t.setTitleRightMarginEnabled(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setTrustFactor(@Nullable String str) {
        this.t.setTrustFactor(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setVideoIconEnlarged(boolean z) {
        this.t.setVideoIconEnlarged(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setViewed(boolean z) {
        this.t.setViewed(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setWidth(int i) {
        this.t.setWidth(i);
    }
}
