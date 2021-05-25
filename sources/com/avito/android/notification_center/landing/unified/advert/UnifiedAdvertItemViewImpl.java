package com.avito.android.notification_center.landing.unified.advert;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010q\u001a\u00020p\u0012\u0006\u0010s\u001a\u00020r\u0012\u0006\u0010u\u001a\u00020t\u0012\u0006\u0010w\u001a\u00020v¢\u0006\u0004\bx\u0010yJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00042\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00042\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ*\u0010!\u001a\u00020\u00042\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0004\b!\u0010\"J\u0018\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0004H\u0001¢\u0006\u0004\b(\u0010\u0006J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u000bH\u0001¢\u0006\u0004\b*\u0010\u000eJ\u001a\u0010,\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b,\u0010\u0014J\u001a\u0010-\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b-\u0010\u0014J\u001a\u0010/\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b/\u0010\u0014J\u0018\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u000200H\u0001¢\u0006\u0004\b2\u00103J\u001a\u00105\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b5\u0010\u0014J \u00106\u001a\u00020\u00042\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\b6\u0010\u001aJ\u0018\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u000207H\u0001¢\u0006\u0004\b9\u0010:J\u0018\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u000bH\u0001¢\u0006\u0004\b<\u0010\u000eJ\u001a\u0010>\u001a\u00020\u00042\b\u0010=\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b>\u0010\u0014J\u0018\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u000bH\u0001¢\u0006\u0004\b@\u0010\u000eJ\u0018\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u000bH\u0001¢\u0006\u0004\bB\u0010\u000eJ\u0018\u0010D\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u000bH\u0001¢\u0006\u0004\bD\u0010\u000eJ\u0010\u0010E\u001a\u00020\u0004H\u0001¢\u0006\u0004\bE\u0010\u0006J\u0018\u0010G\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u000bH\u0001¢\u0006\u0004\bG\u0010\u000eJ\u001a\u0010I\u001a\u00020\u00042\b\u0010H\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\bI\u0010\u0014J\u001a\u0010K\u001a\u00020\u00042\b\u0010J\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\bK\u0010\u0014J$\u0010N\u001a\u00020\u00042\b\u0010J\u001a\u0004\u0018\u00010\u00112\b\u0010M\u001a\u0004\u0018\u00010LH\u0001¢\u0006\u0004\bN\u0010OJ$\u0010Q\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u00010\u00112\b\u0010P\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\bQ\u0010RJ \u0010S\u001a\u00020\u00042\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\bS\u0010\u001aJ \u0010T\u001a\u00020\u00042\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\bT\u0010\u001aJ$\u0010V\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\bV\u0010WJ\"\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010X\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u0013\u0010YJ\u001a\u0010Z\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\bZ\u0010\u0014J\"\u0010[\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\u00112\u0006\u0010M\u001a\u00020LH\u0001¢\u0006\u0004\b[\u0010OJ\"\u0010\\\u001a\u00020\u00042\b\u0010J\u001a\u0004\u0018\u00010\u00112\u0006\u0010M\u001a\u00020LH\u0001¢\u0006\u0004\b\\\u0010OJ\u001a\u0010^\u001a\u00020\u00042\b\u0010]\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b^\u0010\u0014J\u001a\u0010`\u001a\u00020\u00042\b\u0010_\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b`\u0010\u0014J\u0018\u0010b\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u0011H\u0001¢\u0006\u0004\bb\u0010\u0014J\u0018\u0010c\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u000bH\u0001¢\u0006\u0004\bc\u0010\u000eJ\u001a\u0010d\u001a\u00020\u00042\b\u0010H\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\bd\u0010\u0014J\u0018\u0010f\u001a\u00020\u00042\u0006\u0010e\u001a\u00020\u000bH\u0001¢\u0006\u0004\bf\u0010\u000eJ\u0018\u0010h\u001a\u00020\u00042\u0006\u0010g\u001a\u00020\u000bH\u0001¢\u0006\u0004\bh\u0010\u000eJ\u0018\u0010k\u001a\u00020\u00042\u0006\u0010j\u001a\u00020iH\u0001¢\u0006\u0004\bk\u0010lR\u001e\u0010o\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bm\u0010n¨\u0006z"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertItemView;", "Lru/avito/component/serp/SerpAdvertListCard;", "", "onUnbind", "()V", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "", "isFavorite", "setIsFavorite", "(Z)V", "isViewed", "setIsViewed", "", "price", "setPrice", "(Ljava/lang/String;)V", "priceWithoutDiscount", "setAdvertPriceWithoutDiscount", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setFavoriteClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setUnbindListener", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "bindBadgeBar", "(Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "hideBadge", "active", "setActive", "text", "setAdditionalActionText", "setAdditionalName", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "oldPrice", "setClassifiedDiscount", "setClickListener", "", "time", "setDate", "(J)V", "isShowDelivery", "setDeliveryVisible", Sort.DISTANCE, "setDistance", "favorite", "setFavorite", "enabled", "setFavoriteButtonEnabled", "visible", "setFavoriteVisible", "setFavoritesButtonImageResource", "hasVideo", "setHasVideo", "value", "setInStock", "location", "setLocation", "Lcom/avito/android/remote/model/RadiusInfo;", "radiusInfo", "setLocationPostponed", "(Ljava/lang/String;Lcom/avito/android/remote/model/RadiusInfo;)V", "discountPercentage", "setMarketplaceDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "setOnAdditionalActionClickListener", "setOnFavoriteButtonClickListener", BookingInfoActivity.EXTRA_ITEM_ID, "setPicture", "(Lcom/avito/android/image_loader/Picture;Ljava/lang/String;)V", "isHighlighted", "(Ljava/lang/String;Z)V", "setPriceWithoutDiscount", "setRadiusAddress", "setRadiusLocation", "shopName", "setShopName", "tag", "setShortTermRentTag", "title", "setTitle", "setTitleRightMarginEnabled", "setTrustFactor", "enlarged", "setVideoIconEnlarged", "viewed", "setViewed", "", "widthPx", "setWidth", "(I)V", "s", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/View;", "view", "Ljava/util/Locale;", "locale", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "<init>", "(Landroid/view/View;Ljava/util/Locale;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class UnifiedAdvertItemViewImpl extends BaseViewHolder implements UnifiedAdvertItemView, SerpAdvertListCard {
    public Function0<Unit> s;
    public final /* synthetic */ SerpAdvertListCardImpl t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnifiedAdvertItemViewImpl(@NotNull View view, @NotNull Locale locale, @NotNull TimeSource timeSource, @NotNull ConnectivityProvider connectivityProvider) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
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

    @Override // com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItemView, ru.avito.component.serp.SerpAdvertListCard
    public void setAddress(@Nullable String str) {
        this.t.setAddress(str);
    }

    @Override // com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItemView
    public void setAdvertPriceWithoutDiscount(@Nullable String str) {
        setPriceWithoutDiscount(str);
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

    @Override // com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItemView, ru.avito.component.serp.SerpAdvertListCard
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

    @Override // com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItemView, ru.avito.component.serp.SerpAdvertListCard
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

    @Override // com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItemView
    public void setFavoriteClickListener(@Nullable Function0<Unit> function0) {
        setOnFavoriteButtonClickListener(function0);
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

    @Override // com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItemView
    public void setImage(@NotNull Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        SerpAdvertListCard.DefaultImpls.setPicture$default(this, AvitoPictureKt.pictureOf$default(image, false, 0.0f, 0.0f, null, 28, null), null, 2, null);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setInStock(@Nullable String str) {
        this.t.setInStock(str);
    }

    @Override // com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItemView
    public void setIsFavorite(boolean z) {
        setFavorite(z);
    }

    @Override // com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItemView
    public void setIsViewed(boolean z) {
        setViewed(z);
    }

    @Override // com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItemView, ru.avito.component.serp.SerpAdvertListCard
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

    @Override // com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItemView
    public void setPrice(@Nullable String str) {
        setPrice(str, false);
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

    @Override // com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItemView, ru.avito.component.serp.SerpAdvertListCard
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

    @Override // com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
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
