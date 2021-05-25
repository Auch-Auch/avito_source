package com.avito.android.serp.adapter;

import android.net.Uri;
import android.view.View;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.expected.badge_bar.BadgeViewListener;
import com.avito.android.remote.model.RadiusInfo;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.serp.BaseSerpViewHolder;
import com.avito.android.server_time.TimeSource;
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
import ru.avito.component.serp.SerpAdvertTileCard;
import ru.avito.component.serp.SerpAdvertTileCardImpl;
import ru.avito.component.serp.SerpItemViewConfig;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B/\u0012\u0006\u0010b\u001a\u00020a\u0012\u0006\u0010d\u001a\u00020c\u0012\u0006\u0010f\u001a\u00020e\u0012\u0006\u0010h\u001a\u00020g\u0012\u0006\u0010j\u001a\u00020i¢\u0006\u0004\bk\u0010lJ*\u0010\n\u001a\u00020\t2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\b\u001b\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\b\u001d\u0010\u001aJ\u0018\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\b#\u0010\u001aJ\u001e\u0010&\u001a\u00020\t2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0$H\u0001¢\u0006\u0004\b&\u0010'J\u0018\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020(H\u0001¢\u0006\u0004\b*\u0010+J\u0018\u0010-\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0013H\u0001¢\u0006\u0004\b-\u0010\u0016J \u00101\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u00132\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0004\b1\u00102J\u0018\u00104\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0013H\u0001¢\u0006\u0004\b4\u0010\u0016J\u0018\u00106\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0013H\u0001¢\u0006\u0004\b6\u0010\u0016J\u001a\u00108\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\b8\u0010\u001aJ\u0018\u0010:\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0013H\u0001¢\u0006\u0004\b:\u0010\u0016J\u001a\u0010<\u001a\u00020\t2\b\u0010;\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\b<\u0010\u001aJ$\u0010?\u001a\u00020\t2\b\u0010=\u001a\u0004\u0018\u00010\u00172\b\u0010>\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\b?\u0010@J(\u0010B\u001a\u00020\t2\u0006\u00103\u001a\u00020\u00132\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020\t0$H\u0001¢\u0006\u0004\bB\u0010CJ \u0010D\u001a\u00020\t2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010$H\u0001¢\u0006\u0004\bD\u0010'J\u001e\u0010E\u001a\u00020\t2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0$H\u0001¢\u0006\u0004\bE\u0010'J$\u0010G\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\bG\u0010HJ\"\u0010K\u001a\u00020\t2\b\u0010I\u001a\u0004\u0018\u00010\u00172\u0006\u0010J\u001a\u00020\u0013H\u0001¢\u0006\u0004\bK\u0010LJ\u001a\u0010N\u001a\u00020\t2\b\u0010M\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\bN\u0010\u001aJ\"\u0010Q\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00172\u0006\u0010P\u001a\u00020OH\u0001¢\u0006\u0004\bQ\u0010RJ\"\u0010S\u001a\u00020\t2\b\u0010;\u001a\u0004\u0018\u00010\u00172\u0006\u0010P\u001a\u00020OH\u0001¢\u0006\u0004\bS\u0010RJ\u001a\u0010U\u001a\u00020\t2\b\u0010T\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\bU\u0010\u001aJ\u0018\u0010W\u001a\u00020\t2\u0006\u0010V\u001a\u00020\u0017H\u0001¢\u0006\u0004\bW\u0010\u001aJ\u001a\u0010X\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\bX\u0010\u001aJ\u0018\u0010Z\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\u0013H\u0001¢\u0006\u0004\bZ\u0010\u0016J\u0018\u0010\\\u001a\u00020\t2\u0006\u0010[\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\\\u0010\u0016J \u0010_\u001a\u00020\t2\u0006\u0010]\u001a\u00020\u00132\u0006\u0010^\u001a\u00020\u0013H\u0001¢\u0006\u0004\b_\u0010`¨\u0006m"}, d2 = {"Lcom/avito/android/serp/adapter/AdvertGridItemViewImpl;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lcom/avito/android/serp/adapter/AdvertGridItemView;", "Lru/avito/component/serp/SerpAdvertTileCard;", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "", "bindBadges", "(Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "hideBadge", "()V", "", "active", "setActive", "(Z)V", "", "text", "setAdditionalActionText", "(Ljava/lang/String;)V", "setAdditionalName", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "newPrice", "setClassifiedDiscount", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "time", "setDate", "(J)V", "isShowDelivery", "setDeliveryVisible", "favorite", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "setFavorite", "(ZLcom/avito/android/remote/model/SerpDisplayType;)V", "visible", "setFavoriteVisible", "hasVideo", "setHasVideo", "value", "setInStock", "isDoubleItem", "setIsDoubleItem", "location", "setLocation", "oldPrice", "discountPercentage", "setMarketplaceDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "setMoreActions", "(ZLkotlin/jvm/functions/Function0;)V", "setOnAdditionalActionClickListener", "setOnFavoriteButtonClickListener", BookingInfoActivity.EXTRA_ITEM_ID, "setPicture", "(Lcom/avito/android/image_loader/Picture;Ljava/lang/String;)V", "price", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "priceWithoutDiscount", "setPriceWithoutDiscount", "Lcom/avito/android/remote/model/RadiusInfo;", "radiusInfo", "setRadiusAddress", "(Ljava/lang/String;Lcom/avito/android/remote/model/RadiusInfo;)V", "setRadiusLocation", "shopName", "setShopName", "title", "setTitle", "setTrustFactor", "enlarged", "setVideoIconEnlarged", "viewed", "setViewed", PanelStateKt.PANEL_HIDDEN, "animated", "showHiddenStub", "(ZZ)V", "Landroid/view/View;", "view", "Lru/avito/component/serp/SerpItemViewConfig;", "viewConfig", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "<init>", "(Landroid/view/View;Lru/avito/component/serp/SerpItemViewConfig;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public class AdvertGridItemViewImpl extends BaseSerpViewHolder implements AdvertGridItemView, SerpAdvertTileCard {
    public final /* synthetic */ SerpAdvertTileCardImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertGridItemViewImpl(@NotNull View view, @NotNull SerpItemViewConfig serpItemViewConfig, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull ConnectivityProvider connectivityProvider) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(serpItemViewConfig, "viewConfig");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        this.s = new SerpAdvertTileCardImpl(view, serpItemViewConfig, timeSource, locale, connectivityProvider);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void bindBadges(@Nullable List<SerpBadge> list, @Nullable BadgeViewListener badgeViewListener) {
        this.s.bindBadges(list, badgeViewListener);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        return this.s.getPictureUri(picture);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void hideBadge() {
        this.s.hideBadge();
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setActive(boolean z) {
        this.s.setActive(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setAdditionalActionText(@Nullable String str) {
        this.s.setAdditionalActionText(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setAdditionalName(@Nullable String str) {
        this.s.setAdditionalName(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setAddress(@Nullable String str) {
        this.s.setAddress(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setBadge(@NotNull Badge badge) {
        Intrinsics.checkNotNullParameter(badge, "badge");
        this.s.setBadge(badge);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setClassifiedDiscount(@Nullable String str) {
        this.s.setClassifiedDiscount(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setClickListener(function0);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setDate(long j) {
        this.s.setDate(j);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setDeliveryVisible(boolean z) {
        this.s.setDeliveryVisible(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setFavorite(boolean z, @NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        this.s.setFavorite(z, serpDisplayType);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setFavoriteVisible(boolean z) {
        this.s.setFavoriteVisible(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setHasVideo(boolean z) {
        this.s.setHasVideo(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setInStock(@Nullable String str) {
        this.s.setInStock(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setIsDoubleItem(boolean z) {
        this.s.setIsDoubleItem(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setLocation(@Nullable String str) {
        this.s.setLocation(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setMarketplaceDiscount(@Nullable String str, @Nullable String str2) {
        this.s.setMarketplaceDiscount(str, str2);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setMoreActions(boolean z, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.s.setMoreActions(z, function0);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setOnAdditionalActionClickListener(@Nullable Function0<Unit> function0) {
        this.s.setOnAdditionalActionClickListener(function0);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setOnFavoriteButtonClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnFavoriteButtonClickListener(function0);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setPicture(@NotNull Picture picture, @Nullable String str) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        this.s.setPicture(picture, str);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setPrice(@Nullable String str, boolean z) {
        this.s.setPrice(str, z);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setPriceWithoutDiscount(@Nullable String str) {
        this.s.setPriceWithoutDiscount(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setRadiusAddress(@Nullable String str, @NotNull RadiusInfo radiusInfo) {
        Intrinsics.checkNotNullParameter(radiusInfo, "radiusInfo");
        this.s.setRadiusAddress(str, radiusInfo);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setRadiusLocation(@Nullable String str, @NotNull RadiusInfo radiusInfo) {
        Intrinsics.checkNotNullParameter(radiusInfo, "radiusInfo");
        this.s.setRadiusLocation(str, radiusInfo);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setShopName(@Nullable String str) {
        this.s.setShopName(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setTrustFactor(@Nullable String str) {
        this.s.setTrustFactor(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setVideoIconEnlarged(boolean z) {
        this.s.setVideoIconEnlarged(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void setViewed(boolean z) {
        this.s.setViewed(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertTileCard
    public void showHiddenStub(boolean z, boolean z2) {
        this.s.showHiddenStub(z, z2);
    }
}
