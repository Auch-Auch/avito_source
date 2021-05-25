package com.avito.android.serp.adapter;

import android.net.Uri;
import android.view.View;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.badge_bar.SerpBadge;
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
import ru.avito.component.serp.RdsSerpAdvertCard;
import ru.avito.component.serp.RdsSerpAdvertCardSinglePictures;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010M\u001a\u00020L\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010Q\u001a\u00020P\u0012\u0006\u0010S\u001a\u00020R¢\u0006\u0004\bT\u0010UJ \u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b\u001a\u0010\u0018J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001e\u0010!\u001a\u00020\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001fH\u0001¢\u0006\u0004\b!\u0010\"J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0001¢\u0006\u0004\b%\u0010&J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0011H\u0001¢\u0006\u0004\b(\u0010\u0014J\u001a\u0010*\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b*\u0010\u0018J\u0018\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0011H\u0001¢\u0006\u0004\b,\u0010\u0014J\u0018\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0011H\u0001¢\u0006\u0004\b.\u0010\u0014J\u001a\u00100\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b0\u0010\u0018J\u001a\u00102\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b2\u0010\u0018J$\u00105\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u00010\u00152\b\u00104\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b5\u00106J\u001e\u00107\u001a\u00020\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001fH\u0001¢\u0006\u0004\b7\u0010\"J2\u0010;\u001a\u00020\u00072\f\u00108\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u00109\u001a\u00020\u00112\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b;\u0010<J\"\u0010?\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010\u00152\u0006\u0010>\u001a\u00020\u0011H\u0001¢\u0006\u0004\b?\u0010@J\u001a\u0010B\u001a\u00020\u00072\b\u0010A\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\bB\u0010\u0018J\u0018\u0010D\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0011H\u0001¢\u0006\u0004\bD\u0010\u0014J\u001a\u0010F\u001a\u00020\u00072\b\u0010E\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\bF\u0010\u0018J\u0018\u0010H\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0015H\u0001¢\u0006\u0004\bH\u0010\u0018J\u001a\u0010I\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\bI\u0010\u0018J\u0018\u0010K\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0011H\u0001¢\u0006\u0004\bK\u0010\u0014¨\u0006V"}, d2 = {"Lcom/avito/android/serp/adapter/RdsAdvertItemViewImpl;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lcom/avito/android/serp/adapter/RdsAdvertItemView;", "Lru/avito/component/serp/RdsSerpAdvertCard;", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "", "bindBadges", "(Ljava/util/List;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "hideBadge", "()V", "", "active", "setActive", "(Z)V", "", "text", "setAdditionalName", "(Ljava/lang/String;)V", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "time", "setDate", "(J)V", "isShowDelivery", "setDeliveryVisible", Sort.DISTANCE, "setDistance", "favorite", "setFavorite", "visible", "setFavoriteVisible", "value", "setInStock", "location", "setLocation", "oldPrice", "discountPercentage", "setMarketplaceDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "setOnFavoriteButtonClickListener", "pictures", "cancelOnDetach", BookingInfoActivity.EXTRA_ITEM_ID, "setPictures", "(Ljava/util/List;ZLjava/lang/String;)V", "price", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "priceWithoutDiscount", "setPriceWithoutDiscount", "isSafeDeal", "setSafeDealVisible", "shopName", "setShopName", "title", "setTitle", "setTrustFactor", "viewed", "setViewed", "Landroid/view/View;", "view", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "<init>", "(Landroid/view/View;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class RdsAdvertItemViewImpl extends BaseSerpViewHolder implements RdsAdvertItemView, RdsSerpAdvertCard {
    public final /* synthetic */ RdsSerpAdvertCardSinglePictures s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RdsAdvertItemViewImpl(@NotNull View view, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull ConnectivityProvider connectivityProvider) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        this.s = new RdsSerpAdvertCardSinglePictures(view, timeSource, locale, connectivityProvider);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void bindBadges(@Nullable List<SerpBadge> list) {
        this.s.bindBadges(list);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        return this.s.getPictureUri(picture);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void hideBadge() {
        this.s.hideBadge();
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setActive(boolean z) {
        this.s.setActive(z);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setAdditionalName(@Nullable String str) {
        this.s.setAdditionalName(str);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setAddress(@Nullable String str) {
        this.s.setAddress(str);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setBadge(@NotNull Badge badge) {
        Intrinsics.checkNotNullParameter(badge, "badge");
        this.s.setBadge(badge);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setClickListener(function0);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setDate(long j) {
        this.s.setDate(j);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setDeliveryVisible(boolean z) {
        this.s.setDeliveryVisible(z);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setDistance(@Nullable String str) {
        this.s.setDistance(str);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setFavorite(boolean z) {
        this.s.setFavorite(z);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setFavoriteVisible(boolean z) {
        this.s.setFavoriteVisible(z);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setInStock(@Nullable String str) {
        this.s.setInStock(str);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setLocation(@Nullable String str) {
        this.s.setLocation(str);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setMarketplaceDiscount(@Nullable String str, @Nullable String str2) {
        this.s.setMarketplaceDiscount(str, str2);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setOnFavoriteButtonClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnFavoriteButtonClickListener(function0);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setPictures(@NotNull List<? extends Picture> list, boolean z, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, "pictures");
        this.s.setPictures(list, z, str);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setPrice(@Nullable String str, boolean z) {
        this.s.setPrice(str, z);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setPriceWithoutDiscount(@Nullable String str) {
        this.s.setPriceWithoutDiscount(str);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setSafeDealVisible(boolean z) {
        this.s.setSafeDealVisible(z);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setShopName(@Nullable String str) {
        this.s.setShopName(str);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setTrustFactor(@Nullable String str) {
        this.s.setTrustFactor(str);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setViewed(boolean z) {
        this.s.setViewed(z);
    }
}
