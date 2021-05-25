package com.avito.android.module.serp.adapter.ad.mytarget;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.ad.BannerInfoContainer;
import com.avito.android.serp.ad.MyTargetBanner;
import com.avito.android.serp.adapter.AdjustableSerpItem;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010)\u001a\u00020$\u0012\u0006\u00107\u001a\u000202\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b8\u00109R\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001d\u001a\u00020\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010#\u001a\u00020\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010)\u001a\u00020$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00107\u001a\u0002028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallBannerItem;", "Lcom/avito/android/serp/adapter/AdjustableSerpItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/ad/BannerInfoContainer;", "Lcom/avito/android/serp/ad/MyTargetBanner$MyTargetAppInstallBanner;", "d", "Lcom/avito/android/serp/ad/MyTargetBanner$MyTargetAppInstallBanner;", "getBanner", "()Lcom/avito/android/serp/ad/MyTargetBanner$MyTargetAppInstallBanner;", "banner", "Lcom/avito/android/serp/ad/BannerInfo;", "h", "Lcom/avito/android/serp/ad/BannerInfo;", "getBannerInfo", "()Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "Lcom/avito/android/remote/model/SerpDisplayType;", g.a, "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "", "c", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", AuthSource.BOOKING_ORDER, "J", "getId", "()J", "id", "", "e", "I", "getSpanCount", "()I", "spanCount", "", AuthSource.SEND_ABUSE, "Z", "getFullSize", "()Z", "setFullSize", "(Z)V", "fullSize", "Lcom/avito/android/serp/adapter/SerpViewType;", "f", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "<init>", "(JLjava/lang/String;Lcom/avito/android/serp/ad/MyTargetBanner$MyTargetAppInstallBanner;ILcom/avito/android/serp/adapter/SerpViewType;Lcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/ad/BannerInfo;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class MyTargetAppInstallBannerItem implements AdjustableSerpItem, DisplayTypeAwareItem, BannerInfoContainer {
    public boolean a;
    public final long b;
    @NotNull
    public final String c;
    @NotNull
    public final MyTargetBanner.MyTargetAppInstallBanner d;
    public final int e;
    @NotNull
    public final SerpViewType f;
    @NotNull
    public SerpDisplayType g;
    @NotNull
    public final BannerInfo h;

    public MyTargetAppInstallBannerItem(long j, @NotNull String str, @NotNull MyTargetBanner.MyTargetAppInstallBanner myTargetAppInstallBanner, int i, @NotNull SerpViewType serpViewType, @NotNull SerpDisplayType serpDisplayType, @NotNull BannerInfo bannerInfo) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(myTargetAppInstallBanner, "banner");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        this.b = j;
        this.c = str;
        this.d = myTargetAppInstallBanner;
        this.e = i;
        this.f = serpViewType;
        this.g = serpDisplayType;
        this.h = bannerInfo;
    }

    @NotNull
    public final MyTargetBanner.MyTargetAppInstallBanner getBanner() {
        return this.d;
    }

    @Override // com.avito.android.serp.ad.BannerInfoContainer
    @NotNull
    public BannerInfo getBannerInfo() {
        return this.h;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.AdjustableSerpItem
    public boolean getFullSize() {
        return this.a;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @Override // com.avito.android.serp.ad.BannerInfoContainer, com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item
    public long getTrackId() {
        return BannerInfoContainer.DefaultImpls.getTrackId(this);
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.g = serpDisplayType;
    }

    @Override // com.avito.android.serp.adapter.AdjustableSerpItem
    public void setFullSize(boolean z) {
        this.a = z;
    }
}
