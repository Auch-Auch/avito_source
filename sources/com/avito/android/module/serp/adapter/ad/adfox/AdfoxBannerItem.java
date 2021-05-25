package com.avito.android.module.serp.adapter.ad.adfox;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.ad.BannerInfoContainer;
import com.avito.android.serp.adapter.ClosableSerpItem;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\"\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BO\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\u0006\u0010 \u001a\u00020\u000b\u0012\u0006\u0010!\u001a\u00020\u000e\u0012\u0006\u0010\"\u001a\u00020\u0011\u0012\u0006\u0010#\u001a\u00020\u0014\u0012\u0006\u0010$\u001a\u00020\u0017\u0012\u0006\u0010%\u001a\u00020\u001a\u0012\u0006\u0010&\u001a\u00020\u0017¢\u0006\u0004\bK\u0010LJ\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0019Jj\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u00172\b\b\u0002\u0010%\u001a\u00020\u001a2\b\b\u0002\u0010&\u001a\u00020\u0017HÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b)\u0010\nJ\u0010\u0010*\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b*\u0010\u0010J\u001a\u0010-\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003¢\u0006\u0004\b-\u0010.R\u001c\u0010\u001e\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0007R\u0019\u0010&\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b&\u0010\u0019R\u001c\u0010!\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0010R\"\u0010$\u001a\u00020\u00178\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b7\u00103\u001a\u0004\b$\u0010\u0019\"\u0004\b8\u00109R\u0019\u0010 \u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\rR\u001c\u0010\"\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\u0013R\"\u0010#\u001a\u00020\u00148\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010\u0016\"\u0004\bC\u0010DR\u001c\u0010\u001f\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010\nR\u001c\u0010%\u001a\u00020\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010\u001c¨\u0006M"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxBannerItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ClosableSerpItem;", "Lcom/avito/android/serp/ad/BannerInfoContainer;", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxImageBanner;", "component3", "()Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxImageBanner;", "", "component4", "()I", "Lcom/avito/android/serp/adapter/SerpViewType;", "component5", "()Lcom/avito/android/serp/adapter/SerpViewType;", "Lcom/avito/android/remote/model/SerpDisplayType;", "component6", "()Lcom/avito/android/remote/model/SerpDisplayType;", "", "component7", "()Z", "Lcom/avito/android/serp/ad/BannerInfo;", "component8", "()Lcom/avito/android/serp/ad/BannerInfo;", "component9", "id", "stringId", "banner", "spanCount", "viewType", "displayType", "isClosed", "bannerInfo", "isRedesign", "copy", "(JLjava/lang/String;Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxImageBanner;ILcom/avito/android/serp/adapter/SerpViewType;Lcom/avito/android/remote/model/SerpDisplayType;ZLcom/avito/android/serp/ad/BannerInfo;Z)Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxBannerItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "J", "getId", "i", "Z", "d", "I", "getSpanCount", g.a, "setClosed", "(Z)V", "c", "Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxImageBanner;", "getBanner", "e", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "f", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "h", "Lcom/avito/android/serp/ad/BannerInfo;", "getBannerInfo", "<init>", "(JLjava/lang/String;Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxImageBanner;ILcom/avito/android/serp/adapter/SerpViewType;Lcom/avito/android/remote/model/SerpDisplayType;ZLcom/avito/android/serp/ad/BannerInfo;Z)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdfoxBannerItem implements ViewTypeSerpItem, DisplayTypeAwareItem, ClosableSerpItem, BannerInfoContainer {
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final AdfoxImageBanner c;
    public final int d;
    @NotNull
    public final SerpViewType e;
    @NotNull
    public SerpDisplayType f;
    public boolean g;
    @NotNull
    public final BannerInfo h;
    public final boolean i;

    public AdfoxBannerItem(long j, @NotNull String str, @NotNull AdfoxImageBanner adfoxImageBanner, int i2, @NotNull SerpViewType serpViewType, @NotNull SerpDisplayType serpDisplayType, boolean z, @NotNull BannerInfo bannerInfo, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(adfoxImageBanner, "banner");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        this.a = j;
        this.b = str;
        this.c = adfoxImageBanner;
        this.d = i2;
        this.e = serpViewType;
        this.f = serpDisplayType;
        this.g = z;
        this.h = bannerInfo;
        this.i = z2;
    }

    public static /* synthetic */ AdfoxBannerItem copy$default(AdfoxBannerItem adfoxBannerItem, long j, String str, AdfoxImageBanner adfoxImageBanner, int i2, SerpViewType serpViewType, SerpDisplayType serpDisplayType, boolean z, BannerInfo bannerInfo, boolean z2, int i3, Object obj) {
        return adfoxBannerItem.copy((i3 & 1) != 0 ? adfoxBannerItem.getId() : j, (i3 & 2) != 0 ? adfoxBannerItem.getStringId() : str, (i3 & 4) != 0 ? adfoxBannerItem.c : adfoxImageBanner, (i3 & 8) != 0 ? adfoxBannerItem.getSpanCount() : i2, (i3 & 16) != 0 ? adfoxBannerItem.getViewType() : serpViewType, (i3 & 32) != 0 ? adfoxBannerItem.getDisplayType() : serpDisplayType, (i3 & 64) != 0 ? adfoxBannerItem.isClosed() : z, (i3 & 128) != 0 ? adfoxBannerItem.getBannerInfo() : bannerInfo, (i3 & 256) != 0 ? adfoxBannerItem.i : z2);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final String component2() {
        return getStringId();
    }

    @NotNull
    public final AdfoxImageBanner component3() {
        return this.c;
    }

    public final int component4() {
        return getSpanCount();
    }

    @NotNull
    public final SerpViewType component5() {
        return getViewType();
    }

    @NotNull
    public final SerpDisplayType component6() {
        return getDisplayType();
    }

    public final boolean component7() {
        return isClosed();
    }

    @NotNull
    public final BannerInfo component8() {
        return getBannerInfo();
    }

    public final boolean component9() {
        return this.i;
    }

    @NotNull
    public final AdfoxBannerItem copy(long j, @NotNull String str, @NotNull AdfoxImageBanner adfoxImageBanner, int i2, @NotNull SerpViewType serpViewType, @NotNull SerpDisplayType serpDisplayType, boolean z, @NotNull BannerInfo bannerInfo, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(adfoxImageBanner, "banner");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        return new AdfoxBannerItem(j, str, adfoxImageBanner, i2, serpViewType, serpDisplayType, z, bannerInfo, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdfoxBannerItem)) {
            return false;
        }
        AdfoxBannerItem adfoxBannerItem = (AdfoxBannerItem) obj;
        return getId() == adfoxBannerItem.getId() && Intrinsics.areEqual(getStringId(), adfoxBannerItem.getStringId()) && Intrinsics.areEqual(this.c, adfoxBannerItem.c) && getSpanCount() == adfoxBannerItem.getSpanCount() && Intrinsics.areEqual(getViewType(), adfoxBannerItem.getViewType()) && Intrinsics.areEqual(getDisplayType(), adfoxBannerItem.getDisplayType()) && isClosed() == adfoxBannerItem.isClosed() && Intrinsics.areEqual(getBannerInfo(), adfoxBannerItem.getBannerInfo()) && this.i == adfoxBannerItem.i;
    }

    @NotNull
    public final AdfoxImageBanner getBanner() {
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

    public int hashCode() {
        int a3 = c.a(getId()) * 31;
        String stringId = getStringId();
        int i2 = 0;
        int hashCode = (a3 + (stringId != null ? stringId.hashCode() : 0)) * 31;
        AdfoxImageBanner adfoxImageBanner = this.c;
        int spanCount = (getSpanCount() + ((hashCode + (adfoxImageBanner != null ? adfoxImageBanner.hashCode() : 0)) * 31)) * 31;
        SerpViewType viewType = getViewType();
        int hashCode2 = (spanCount + (viewType != null ? viewType.hashCode() : 0)) * 31;
        SerpDisplayType displayType = getDisplayType();
        int hashCode3 = (hashCode2 + (displayType != null ? displayType.hashCode() : 0)) * 31;
        boolean isClosed = isClosed();
        int i3 = 1;
        if (isClosed) {
            isClosed = true;
        }
        int i4 = isClosed ? 1 : 0;
        int i5 = isClosed ? 1 : 0;
        int i6 = isClosed ? 1 : 0;
        int i7 = (hashCode3 + i4) * 31;
        BannerInfo bannerInfo = getBannerInfo();
        if (bannerInfo != null) {
            i2 = bannerInfo.hashCode();
        }
        int i8 = (i7 + i2) * 31;
        boolean z = this.i;
        if (!z) {
            i3 = z ? 1 : 0;
        }
        return i8 + i3;
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

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AdfoxBannerItem(id=");
        L.append(getId());
        L.append(", stringId=");
        L.append(getStringId());
        L.append(", banner=");
        L.append(this.c);
        L.append(", spanCount=");
        L.append(getSpanCount());
        L.append(", viewType=");
        L.append(getViewType());
        L.append(", displayType=");
        L.append(getDisplayType());
        L.append(", isClosed=");
        L.append(isClosed());
        L.append(", bannerInfo=");
        L.append(getBannerInfo());
        L.append(", isRedesign=");
        return a.B(L, this.i, ")");
    }
}
