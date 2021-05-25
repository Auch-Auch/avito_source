package com.avito.android.module.serp.adapter.ad.yandex.app_install;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.ad.BannerInfoContainer;
import com.avito.android.serp.ad.YandexAppInstallBanner;
import com.avito.android.serp.adapter.AdjustableSerpItem;
import com.avito.android.serp.adapter.ClosableSerpItem;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BQ\u0012\u0006\u0010;\u001a\u000206\u0012\u0006\u0010$\u001a\u00020\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010*\u001a\u00020%\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u00102\u001a\u00020+\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\u0006\u00104\u001a\u00020\u0011\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b<\u0010=R\u001c\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001e\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010$\u001a\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010*\u001a\u00020%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\"\u00102\u001a\u00020+8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00104\u001a\u00020\u00118\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0013\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017R\u001c\u0010;\u001a\u0002068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallBannerItem;", "Lcom/avito/android/serp/adapter/AdjustableSerpItem;", "Lcom/avito/android/serp/adapter/ClosableSerpItem;", "Lcom/avito/android/serp/ad/BannerInfoContainer;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/ad/BannerInfo;", "i", "Lcom/avito/android/serp/ad/BannerInfo;", "getBannerInfo", "()Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "Lcom/avito/android/serp/adapter/SerpViewType;", "e", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "", g.a, "Z", "getFullSize", "()Z", "setFullSize", "(Z)V", "fullSize", "Lcom/avito/android/serp/ad/YandexAppInstallBanner;", "c", "Lcom/avito/android/serp/ad/YandexAppInstallBanner;", "getBanner", "()Lcom/avito/android/serp/ad/YandexAppInstallBanner;", "banner", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", "d", "I", "getSpanCount", "()I", "spanCount", "Lcom/avito/android/remote/model/SerpDisplayType;", "f", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "h", "isClosed", "setClosed", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "<init>", "(JLjava/lang/String;Lcom/avito/android/serp/ad/YandexAppInstallBanner;ILcom/avito/android/serp/adapter/SerpViewType;Lcom/avito/android/remote/model/SerpDisplayType;ZZLcom/avito/android/serp/ad/BannerInfo;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class YandexAppInstallBannerItem implements AdjustableSerpItem, ClosableSerpItem, BannerInfoContainer, DisplayTypeAwareItem {
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final YandexAppInstallBanner c;
    public final int d;
    @NotNull
    public final SerpViewType e;
    @NotNull
    public SerpDisplayType f;
    public boolean g;
    public boolean h;
    @NotNull
    public final BannerInfo i;

    public YandexAppInstallBannerItem(long j, @NotNull String str, @NotNull YandexAppInstallBanner yandexAppInstallBanner, int i2, @NotNull SerpViewType serpViewType, @NotNull SerpDisplayType serpDisplayType, boolean z, boolean z2, @NotNull BannerInfo bannerInfo) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(yandexAppInstallBanner, "banner");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        this.a = j;
        this.b = str;
        this.c = yandexAppInstallBanner;
        this.d = i2;
        this.e = serpViewType;
        this.f = serpDisplayType;
        this.g = z;
        this.h = z2;
        this.i = bannerInfo;
    }

    @NotNull
    public final YandexAppInstallBanner getBanner() {
        return this.c;
    }

    @Override // com.avito.android.serp.ad.BannerInfoContainer
    @NotNull
    public BannerInfo getBannerInfo() {
        return this.i;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.AdjustableSerpItem
    public boolean getFullSize() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // com.avito.android.serp.ad.BannerInfoContainer, com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item
    public long getTrackId() {
        return BannerInfoContainer.DefaultImpls.getTrackId(this);
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.ClosableSerpItem
    public boolean isClosed() {
        return this.h;
    }

    @Override // com.avito.android.serp.adapter.ClosableSerpItem
    public void setClosed(boolean z) {
        this.h = z;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.f = serpDisplayType;
    }

    @Override // com.avito.android.serp.adapter.AdjustableSerpItem
    public void setFullSize(boolean z) {
        this.g = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ YandexAppInstallBannerItem(long j, String str, YandexAppInstallBanner yandexAppInstallBanner, int i2, SerpViewType serpViewType, SerpDisplayType serpDisplayType, boolean z, boolean z2, BannerInfo bannerInfo, int i3, j jVar) {
        this(j, str, yandexAppInstallBanner, i2, serpViewType, serpDisplayType, (i3 & 64) != 0 ? false : z, z2, bannerInfo);
    }
}
