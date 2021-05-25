package com.avito.android.advert.item.similars_button;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b \b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BS\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000e\u0012\b\b\u0002\u0010 \u001a\u00020\u0011\u0012\b\b\u0002\u0010!\u001a\u00020\b\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u0017\u0012\b\b\u0002\u0010$\u001a\u00020\u001a¢\u0006\u0004\bO\u0010PJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJb\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00172\b\b\u0002\u0010$\u001a\u00020\u001aHÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b'\u0010\nJ\u0010\u0010(\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b(\u0010\u0016J\u001a\u0010+\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b-\u0010\u0016J \u00102\u001a\u0002012\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b2\u00103R\u0019\u0010\u001d\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\nR\"\u0010#\u001a\u00020\u00178\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010\u0019\"\u0004\b:\u0010;R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\rR\u001c\u0010\"\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\u0016R\u001c\u0010!\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bB\u00105\u001a\u0004\bC\u0010\nR\u001c\u0010$\u001a\u00020\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\u001cR\u001c\u0010 \u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010\u0013R\"\u0010\u001f\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010\u0010\"\u0004\bM\u0010N¨\u0006Q"}, d2 = {"Lcom/avito/android/advert/item/similars_button/AdvertDetailsSimilarsButtonItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component2", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "component3", "()Z", "", "component4", "()J", "component5", "component6", "()I", "Lcom/avito/android/remote/model/SerpDisplayType;", "component7", "()Lcom/avito/android/remote/model/SerpDisplayType;", "Lcom/avito/android/serp/adapter/SerpViewType;", "component8", "()Lcom/avito/android/serp/adapter/SerpViewType;", "text", "deepLink", "withBigTopOffset", "id", "stringId", "spanCount", "displayType", "viewType", "copy", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;ZJLjava/lang/String;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)Lcom/avito/android/advert/item/similars_button/AdvertDetailsSimilarsButtonItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", g.a, "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "f", "I", "getSpanCount", "e", "getStringId", "h", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "d", "J", "getId", "c", "Z", "getWithBigTopOffset", "setWithBigTopOffset", "(Z)V", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;ZJLjava/lang/String;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSimilarsButtonItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<AdvertDetailsSimilarsButtonItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @Nullable
    public final DeepLink b;
    public boolean c;
    public final long d;
    @NotNull
    public final String e;
    public final int f;
    @NotNull
    public SerpDisplayType g;
    @NotNull
    public final SerpViewType h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsSimilarsButtonItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsSimilarsButtonItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertDetailsSimilarsButtonItem(parcel.readString(), (DeepLink) parcel.readParcelable(AdvertDetailsSimilarsButtonItem.class.getClassLoader()), parcel.readInt() != 0, parcel.readLong(), parcel.readString(), parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsSimilarsButtonItem[] newArray(int i) {
            return new AdvertDetailsSimilarsButtonItem[i];
        }
    }

    public AdvertDetailsSimilarsButtonItem(@NotNull String str, @Nullable DeepLink deepLink, boolean z, long j, @NotNull String str2, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = str;
        this.b = deepLink;
        this.c = z;
        this.d = j;
        this.e = str2;
        this.f = i;
        this.g = serpDisplayType;
        this.h = serpViewType;
    }

    public static /* synthetic */ AdvertDetailsSimilarsButtonItem copy$default(AdvertDetailsSimilarsButtonItem advertDetailsSimilarsButtonItem, String str, DeepLink deepLink, boolean z, long j, String str2, int i, SerpDisplayType serpDisplayType, SerpViewType serpViewType, int i2, Object obj) {
        return advertDetailsSimilarsButtonItem.copy((i2 & 1) != 0 ? advertDetailsSimilarsButtonItem.a : str, (i2 & 2) != 0 ? advertDetailsSimilarsButtonItem.b : deepLink, (i2 & 4) != 0 ? advertDetailsSimilarsButtonItem.c : z, (i2 & 8) != 0 ? advertDetailsSimilarsButtonItem.getId() : j, (i2 & 16) != 0 ? advertDetailsSimilarsButtonItem.getStringId() : str2, (i2 & 32) != 0 ? advertDetailsSimilarsButtonItem.getSpanCount() : i, (i2 & 64) != 0 ? advertDetailsSimilarsButtonItem.getDisplayType() : serpDisplayType, (i2 & 128) != 0 ? advertDetailsSimilarsButtonItem.getViewType() : serpViewType);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final DeepLink component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    public final long component4() {
        return getId();
    }

    @NotNull
    public final String component5() {
        return getStringId();
    }

    public final int component6() {
        return getSpanCount();
    }

    @NotNull
    public final SerpDisplayType component7() {
        return getDisplayType();
    }

    @NotNull
    public final SerpViewType component8() {
        return getViewType();
    }

    @NotNull
    public final AdvertDetailsSimilarsButtonItem copy(@NotNull String str, @Nullable DeepLink deepLink, boolean z, long j, @NotNull String str2, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        return new AdvertDetailsSimilarsButtonItem(str, deepLink, z, j, str2, i, serpDisplayType, serpViewType);
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return copy$default(this, null, null, false, 0, null, i, null, null, 223, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdvertDetailsSimilarsButtonItem)) {
            return false;
        }
        AdvertDetailsSimilarsButtonItem advertDetailsSimilarsButtonItem = (AdvertDetailsSimilarsButtonItem) obj;
        return Intrinsics.areEqual(this.a, advertDetailsSimilarsButtonItem.a) && Intrinsics.areEqual(this.b, advertDetailsSimilarsButtonItem.b) && this.c == advertDetailsSimilarsButtonItem.c && getId() == advertDetailsSimilarsButtonItem.getId() && Intrinsics.areEqual(getStringId(), advertDetailsSimilarsButtonItem.getStringId()) && getSpanCount() == advertDetailsSimilarsButtonItem.getSpanCount() && Intrinsics.areEqual(getDisplayType(), advertDetailsSimilarsButtonItem.getDisplayType()) && Intrinsics.areEqual(getViewType(), advertDetailsSimilarsButtonItem.getViewType());
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.e;
    }

    @NotNull
    public final String getText() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.h;
    }

    public final boolean getWithBigTopOffset() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        DeepLink deepLink = this.b;
        int hashCode2 = (hashCode + (deepLink != null ? deepLink.hashCode() : 0)) * 31;
        boolean z = this.c;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int a3 = (((hashCode2 + i2) * 31) + c.a(getId())) * 31;
        String stringId = getStringId();
        int spanCount = (getSpanCount() + ((a3 + (stringId != null ? stringId.hashCode() : 0)) * 31)) * 31;
        SerpDisplayType displayType = getDisplayType();
        int hashCode3 = (spanCount + (displayType != null ? displayType.hashCode() : 0)) * 31;
        SerpViewType viewType = getViewType();
        if (viewType != null) {
            i = viewType.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.g = serpDisplayType;
    }

    public final void setWithBigTopOffset(boolean z) {
        this.c = z;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AdvertDetailsSimilarsButtonItem(text=");
        L.append(this.a);
        L.append(", deepLink=");
        L.append(this.b);
        L.append(", withBigTopOffset=");
        L.append(this.c);
        L.append(", id=");
        L.append(getId());
        L.append(", stringId=");
        L.append(getStringId());
        L.append(", spanCount=");
        L.append(getSpanCount());
        L.append(", displayType=");
        L.append(getDisplayType());
        L.append(", viewType=");
        L.append(getViewType());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeLong(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g.name());
        parcel.writeString(this.h.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsSimilarsButtonItem(java.lang.String r13, com.avito.android.deep_linking.links.DeepLink r14, boolean r15, long r16, java.lang.String r18, int r19, com.avito.android.remote.model.SerpDisplayType r20, com.avito.android.serp.adapter.SerpViewType r21, int r22, t6.r.a.j r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r5 = 0
            goto L_0x000a
        L_0x0009:
            r5 = r15
        L_0x000a:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0015
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_SIMILARS_BUTTON
            r1 = 38
            long r1 = (long) r1
            r6 = r1
            goto L_0x0017
        L_0x0015:
            r6 = r16
        L_0x0017:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0021
            java.lang.String r1 = java.lang.String.valueOf(r6)
            r8 = r1
            goto L_0x0023
        L_0x0021:
            r8 = r18
        L_0x0023:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002b
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r10 = r1
            goto L_0x002d
        L_0x002b:
            r10 = r20
        L_0x002d:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0035
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r11 = r0
            goto L_0x0037
        L_0x0035:
            r11 = r21
        L_0x0037:
            r2 = r12
            r3 = r13
            r4 = r14
            r9 = r19
            r2.<init>(r3, r4, r5, r6, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.similars_button.AdvertDetailsSimilarsButtonItem.<init>(java.lang.String, com.avito.android.deep_linking.links.DeepLink, boolean, long, java.lang.String, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}
