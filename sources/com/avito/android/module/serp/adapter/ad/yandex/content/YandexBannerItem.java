package com.avito.android.module.serp.adapter.ad.yandex.content;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.ad.BannerInfoContainer;
import com.avito.android.serp.ad.YandexContentBanner;
import com.avito.android.serp.adapter.ClosableSerpItem;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BO\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u00109\u001a\u000204\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010)\u001a\u00020$\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u00101\u001a\u00020*\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u00103\u001a\u00020\u0005¢\u0006\u0004\b:\u0010;R\"\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001d\u001a\u00020\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010#\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010)\u001a\u00020$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0019\u00103\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0007\u001a\u0004\b3\u0010\tR\u001c\u00109\u001a\u0002048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexBannerItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ClosableSerpItem;", "Lcom/avito/android/serp/ad/BannerInfoContainer;", "", g.a, "Z", "isClosed", "()Z", "setClosed", "(Z)V", "Lcom/avito/android/serp/adapter/SerpViewType;", "e", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "Lcom/avito/android/serp/ad/BannerInfo;", "h", "Lcom/avito/android/serp/ad/BannerInfo;", "getBannerInfo", "()Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "Lcom/avito/android/serp/ad/YandexContentBanner;", "c", "Lcom/avito/android/serp/ad/YandexContentBanner;", "getBanner", "()Lcom/avito/android/serp/ad/YandexContentBanner;", "banner", "", "d", "I", "getSpanCount", "()I", "spanCount", "Lcom/avito/android/remote/model/SerpDisplayType;", "f", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "i", "isRedesign", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "<init>", "(JLjava/lang/String;Lcom/avito/android/serp/ad/YandexContentBanner;ILcom/avito/android/serp/adapter/SerpViewType;Lcom/avito/android/remote/model/SerpDisplayType;ZLcom/avito/android/serp/ad/BannerInfo;Z)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class YandexBannerItem implements ViewTypeSerpItem, DisplayTypeAwareItem, ClosableSerpItem, BannerInfoContainer {
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final YandexContentBanner c;
    public final int d;
    @NotNull
    public final SerpViewType e;
    @NotNull
    public SerpDisplayType f;
    public boolean g;
    @NotNull
    public final BannerInfo h;
    public final boolean i;

    public YandexBannerItem(long j, @NotNull String str, @NotNull YandexContentBanner yandexContentBanner, int i2, @NotNull SerpViewType serpViewType, @NotNull SerpDisplayType serpDisplayType, boolean z, @NotNull BannerInfo bannerInfo, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(yandexContentBanner, "banner");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        this.a = j;
        this.b = str;
        this.c = yandexContentBanner;
        this.d = i2;
        this.e = serpViewType;
        this.f = serpDisplayType;
        this.g = z;
        this.h = bannerInfo;
        this.i = z2;
    }

    @NotNull
    public final YandexContentBanner getBanner() {
        return this.c;
    }

    @Override // com.avito.android.serp.ad.BannerInfoContainer
    @NotNull
    public BannerInfo getBannerInfo() {
        return this.h;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.f;
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
        return this.g;
    }

    public final boolean isRedesign() {
        return this.i;
    }

    @Override // com.avito.android.serp.adapter.ClosableSerpItem
    public void setClosed(boolean z) {
        this.g = z;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.f = serpDisplayType;
    }
}
