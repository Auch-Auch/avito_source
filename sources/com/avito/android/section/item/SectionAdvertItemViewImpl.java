package com.avito.android.section.item;

import android.net.Uri;
import android.view.View;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.expected.badge_bar.BadgeViewListener;
import com.avito.android.remote.model.RadiusInfo;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.serp.adapter.AdvertListItemView;
import com.avito.android.serp.adapter.AdvertListItemViewImpl;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010c\u001a\u00020b\u0012\u0006\u0010e\u001a\u00020d\u0012\u0006\u0010g\u001a\u00020f\u0012\u0006\u0010i\u001a\u00020h¢\u0006\u0004\bj\u0010kJ*\u0010\n\u001a\u00020\t2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0013\u0010\u0012J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0004\b\u001c\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0004\b\u001e\u0010\u001bJ\u0018\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0004\b$\u0010\u001bJ \u0010'\u001a\u00020\t2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010%H\u0001¢\u0006\u0004\b'\u0010(J\u0018\u0010+\u001a\u00020\t2\u0006\u0010*\u001a\u00020)H\u0001¢\u0006\u0004\b+\u0010,J\u0018\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0014H\u0001¢\u0006\u0004\b.\u0010\u0017J\u001a\u00100\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0004\b0\u0010\u001bJ\u0018\u00102\u001a\u00020\t2\u0006\u00101\u001a\u00020\u0014H\u0001¢\u0006\u0004\b2\u0010\u0017J\u0018\u00104\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0014H\u0001¢\u0006\u0004\b4\u0010\u0017J\u0018\u00106\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0014H\u0001¢\u0006\u0004\b6\u0010\u0017J\u0010\u00107\u001a\u00020\tH\u0001¢\u0006\u0004\b7\u0010\u0012J\u0018\u00109\u001a\u00020\t2\u0006\u00108\u001a\u00020\u0014H\u0001¢\u0006\u0004\b9\u0010\u0017J\u001a\u0010;\u001a\u00020\t2\b\u0010:\u001a\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0004\b;\u0010\u001bJ\u001a\u0010=\u001a\u00020\t2\b\u0010<\u001a\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0004\b=\u0010\u001bJ$\u0010@\u001a\u00020\t2\b\u0010<\u001a\u0004\u0018\u00010\u00182\b\u0010?\u001a\u0004\u0018\u00010>H\u0001¢\u0006\u0004\b@\u0010AJ$\u0010C\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u00182\b\u0010B\u001a\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0004\bC\u0010DJ \u0010E\u001a\u00020\t2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010%H\u0001¢\u0006\u0004\bE\u0010(J \u0010F\u001a\u00020\t2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010%H\u0001¢\u0006\u0004\bF\u0010(J\"\u0010H\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010G\u001a\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0004\bH\u0010IJ\"\u0010L\u001a\u00020\t2\b\u0010J\u001a\u0004\u0018\u00010\u00182\u0006\u0010K\u001a\u00020\u0014H\u0001¢\u0006\u0004\bL\u0010MJ\u001a\u0010O\u001a\u00020\t2\b\u0010N\u001a\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0004\bO\u0010\u001bJ\"\u0010P\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00182\u0006\u0010?\u001a\u00020>H\u0001¢\u0006\u0004\bP\u0010AJ\"\u0010Q\u001a\u00020\t2\b\u0010<\u001a\u0004\u0018\u00010\u00182\u0006\u0010?\u001a\u00020>H\u0001¢\u0006\u0004\bQ\u0010AJ\u001a\u0010S\u001a\u00020\t2\b\u0010R\u001a\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0004\bS\u0010\u001bJ\u001a\u0010U\u001a\u00020\t2\b\u0010T\u001a\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0004\bU\u0010\u001bJ\u0018\u0010W\u001a\u00020\t2\u0006\u0010V\u001a\u00020\u0018H\u0001¢\u0006\u0004\bW\u0010\u001bJ\u0018\u0010X\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0014H\u0001¢\u0006\u0004\bX\u0010\u0017J\u001a\u0010Y\u001a\u00020\t2\b\u0010:\u001a\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0004\bY\u0010\u001bJ\u0018\u0010[\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\u0014H\u0001¢\u0006\u0004\b[\u0010\u0017J\u0018\u0010]\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\u0014H\u0001¢\u0006\u0004\b]\u0010\u0017J\u0018\u0010`\u001a\u00020\t2\u0006\u0010_\u001a\u00020^H\u0001¢\u0006\u0004\b`\u0010a¨\u0006l"}, d2 = {"Lcom/avito/android/section/item/SectionAdvertItemViewImpl;", "Lcom/avito/android/section/item/SectionAdvertItemView;", "Lcom/avito/android/serp/adapter/AdvertListItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "", "bindBadgeBar", "(Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "hideBadge", "()V", "onUnbind", "", "active", "setActive", "(Z)V", "", "text", "setAdditionalActionText", "(Ljava/lang/String;)V", "setAdditionalName", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "oldPrice", "setClassifiedDiscount", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "time", "setDate", "(J)V", "isShowDelivery", "setDeliveryVisible", Sort.DISTANCE, "setDistance", "favorite", "setFavorite", "enabled", "setFavoriteButtonEnabled", "visible", "setFavoriteVisible", "setFavoritesButtonImageResource", "hasVideo", "setHasVideo", "value", "setInStock", "location", "setLocation", "Lcom/avito/android/remote/model/RadiusInfo;", "radiusInfo", "setLocationPostponed", "(Ljava/lang/String;Lcom/avito/android/remote/model/RadiusInfo;)V", "discountPercentage", "setMarketplaceDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "setOnAdditionalActionClickListener", "setOnFavoriteButtonClickListener", BookingInfoActivity.EXTRA_ITEM_ID, "setPicture", "(Lcom/avito/android/image_loader/Picture;Ljava/lang/String;)V", "price", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "priceWithoutDiscount", "setPriceWithoutDiscount", "setRadiusAddress", "setRadiusLocation", "shopName", "setShopName", "tag", "setShortTermRentTag", "title", "setTitle", "setTitleRightMarginEnabled", "setTrustFactor", "enlarged", "setVideoIconEnlarged", "viewed", "setViewed", "", "widthPx", "setWidth", "(I)V", "Landroid/view/View;", "view", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "<init>", "(Landroid/view/View;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SectionAdvertItemViewImpl extends BaseViewHolder implements SectionAdvertItemView, AdvertListItemView {
    public final /* synthetic */ AdvertListItemViewImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SectionAdvertItemViewImpl(@NotNull View view, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull ConnectivityProvider connectivityProvider) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        this.s = new AdvertListItemViewImpl(view, timeSource, locale, null, connectivityProvider, 8, null);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void bindBadgeBar(@Nullable List<SerpBadge> list, @Nullable BadgeViewListener badgeViewListener) {
        this.s.bindBadgeBar(list, badgeViewListener);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        return this.s.getPictureUri(picture);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void hideBadge() {
        this.s.hideBadge();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.s.onUnbind();
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setActive(boolean z) {
        this.s.setActive(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setAdditionalActionText(@Nullable String str) {
        this.s.setAdditionalActionText(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setAdditionalName(@Nullable String str) {
        this.s.setAdditionalName(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setAddress(@Nullable String str) {
        this.s.setAddress(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setBadge(@NotNull Badge badge) {
        Intrinsics.checkNotNullParameter(badge, "badge");
        this.s.setBadge(badge);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setClassifiedDiscount(@Nullable String str) {
        this.s.setClassifiedDiscount(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setClickListener(@Nullable Function0<Unit> function0) {
        this.s.setClickListener(function0);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setDate(long j) {
        this.s.setDate(j);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setDeliveryVisible(boolean z) {
        this.s.setDeliveryVisible(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setDistance(@Nullable String str) {
        this.s.setDistance(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setFavorite(boolean z) {
        this.s.setFavorite(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setFavoriteButtonEnabled(boolean z) {
        this.s.setFavoriteButtonEnabled(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setFavoriteVisible(boolean z) {
        this.s.setFavoriteVisible(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setFavoritesButtonImageResource() {
        this.s.setFavoritesButtonImageResource();
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setHasVideo(boolean z) {
        this.s.setHasVideo(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setInStock(@Nullable String str) {
        this.s.setInStock(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setLocation(@Nullable String str) {
        this.s.setLocation(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setLocationPostponed(@Nullable String str, @Nullable RadiusInfo radiusInfo) {
        this.s.setLocationPostponed(str, radiusInfo);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setMarketplaceDiscount(@Nullable String str, @Nullable String str2) {
        this.s.setMarketplaceDiscount(str, str2);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setOnAdditionalActionClickListener(@Nullable Function0<Unit> function0) {
        this.s.setOnAdditionalActionClickListener(function0);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setOnFavoriteButtonClickListener(@Nullable Function0<Unit> function0) {
        this.s.setOnFavoriteButtonClickListener(function0);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setPicture(@NotNull Picture picture, @Nullable String str) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        this.s.setPicture(picture, str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setPrice(@Nullable String str, boolean z) {
        this.s.setPrice(str, z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setPriceWithoutDiscount(@Nullable String str) {
        this.s.setPriceWithoutDiscount(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setRadiusAddress(@Nullable String str, @NotNull RadiusInfo radiusInfo) {
        Intrinsics.checkNotNullParameter(radiusInfo, "radiusInfo");
        this.s.setRadiusAddress(str, radiusInfo);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setRadiusLocation(@Nullable String str, @NotNull RadiusInfo radiusInfo) {
        Intrinsics.checkNotNullParameter(radiusInfo, "radiusInfo");
        this.s.setRadiusLocation(str, radiusInfo);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setShopName(@Nullable String str) {
        this.s.setShopName(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setShortTermRentTag(@Nullable String str) {
        this.s.setShortTermRentTag(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setTitleRightMarginEnabled(boolean z) {
        this.s.setTitleRightMarginEnabled(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setTrustFactor(@Nullable String str) {
        this.s.setTrustFactor(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setVideoIconEnlarged(boolean z) {
        this.s.setVideoIconEnlarged(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setViewed(boolean z) {
        this.s.setViewed(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    public void setWidth(int i) {
        this.s.setWidth(i);
    }
}
