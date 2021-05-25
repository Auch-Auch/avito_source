package com.avito.android.advert.item.show_description_button;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001c\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BK\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0014\u0012\b\b\u0002\u0010 \u001a\u00020\u0017¢\u0006\u0004\bG\u0010HJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019JV\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u0017HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b#\u0010\u0011J\u0010\u0010$\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b$\u0010\u0013J\u001a\u0010'\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b)\u0010\u0013J \u0010.\u001a\u00020-2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b.\u0010/R\u001c\u0010\u001e\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0013R\u001c\u0010 \u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0019R\"\u0010\u001f\u001a\u00020\u00148\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u0016\"\u0004\b9\u0010:R\"\u0010\u001a\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\n\"\u0004\b>\u0010?R\u001c\u0010\u001d\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010\u0011R\u0019\u0010\u001b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010<\u001a\u0004\b\u001b\u0010\nR\u001c\u0010\u001c\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\u000e¨\u0006I"}, d2 = {"Lcom/avito/android/advert/item/show_description_button/AdvertDetailsShowDescriptionItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "", "component1", "()Z", "component2", "", "component3", "()J", "", "component4", "()Ljava/lang/String;", "component5", "()I", "Lcom/avito/android/remote/model/SerpDisplayType;", "component6", "()Lcom/avito/android/remote/model/SerpDisplayType;", "Lcom/avito/android/serp/adapter/SerpViewType;", "component7", "()Lcom/avito/android/serp/adapter/SerpViewType;", "descriptionShown", "isMarketplace", "id", "stringId", "spanCount", "displayType", "viewType", "copy", "(ZZJLjava/lang/String;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)Lcom/avito/android/advert/item/show_description_button/AdvertDetailsShowDescriptionItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "e", "I", "getSpanCount", g.a, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "f", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", AuthSource.SEND_ABUSE, "Z", "getDescriptionShown", "setDescriptionShown", "(Z)V", "d", "Ljava/lang/String;", "getStringId", AuthSource.BOOKING_ORDER, "c", "J", "getId", "<init>", "(ZZJLjava/lang/String;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsShowDescriptionItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<AdvertDetailsShowDescriptionItem> CREATOR = new Creator();
    public boolean a;
    public final boolean b;
    public final long c;
    @NotNull
    public final String d;
    public final int e;
    @NotNull
    public SerpDisplayType f;
    @NotNull
    public final SerpViewType g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsShowDescriptionItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsShowDescriptionItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            boolean z = false;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            return new AdvertDetailsShowDescriptionItem(z2, z, parcel.readLong(), parcel.readString(), parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsShowDescriptionItem[] newArray(int i) {
            return new AdvertDetailsShowDescriptionItem[i];
        }
    }

    public AdvertDetailsShowDescriptionItem(boolean z, boolean z2, long j, @NotNull String str, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = z;
        this.b = z2;
        this.c = j;
        this.d = str;
        this.e = i;
        this.f = serpDisplayType;
        this.g = serpViewType;
    }

    public static /* synthetic */ AdvertDetailsShowDescriptionItem copy$default(AdvertDetailsShowDescriptionItem advertDetailsShowDescriptionItem, boolean z, boolean z2, long j, String str, int i, SerpDisplayType serpDisplayType, SerpViewType serpViewType, int i2, Object obj) {
        return advertDetailsShowDescriptionItem.copy((i2 & 1) != 0 ? advertDetailsShowDescriptionItem.a : z, (i2 & 2) != 0 ? advertDetailsShowDescriptionItem.b : z2, (i2 & 4) != 0 ? advertDetailsShowDescriptionItem.getId() : j, (i2 & 8) != 0 ? advertDetailsShowDescriptionItem.getStringId() : str, (i2 & 16) != 0 ? advertDetailsShowDescriptionItem.getSpanCount() : i, (i2 & 32) != 0 ? advertDetailsShowDescriptionItem.getDisplayType() : serpDisplayType, (i2 & 64) != 0 ? advertDetailsShowDescriptionItem.getViewType() : serpViewType);
    }

    public final boolean component1() {
        return this.a;
    }

    public final boolean component2() {
        return this.b;
    }

    public final long component3() {
        return getId();
    }

    @NotNull
    public final String component4() {
        return getStringId();
    }

    public final int component5() {
        return getSpanCount();
    }

    @NotNull
    public final SerpDisplayType component6() {
        return getDisplayType();
    }

    @NotNull
    public final SerpViewType component7() {
        return getViewType();
    }

    @NotNull
    public final AdvertDetailsShowDescriptionItem copy(boolean z, boolean z2, long j, @NotNull String str, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        return new AdvertDetailsShowDescriptionItem(z, z2, j, str, i, serpDisplayType, serpViewType);
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return copy$default(this, false, false, 0, null, i, null, null, 111, null);
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
        if (!(obj instanceof AdvertDetailsShowDescriptionItem)) {
            return false;
        }
        AdvertDetailsShowDescriptionItem advertDetailsShowDescriptionItem = (AdvertDetailsShowDescriptionItem) obj;
        return this.a == advertDetailsShowDescriptionItem.a && this.b == advertDetailsShowDescriptionItem.b && getId() == advertDetailsShowDescriptionItem.getId() && Intrinsics.areEqual(getStringId(), advertDetailsShowDescriptionItem.getStringId()) && getSpanCount() == advertDetailsShowDescriptionItem.getSpanCount() && Intrinsics.areEqual(getDisplayType(), advertDetailsShowDescriptionItem.getDisplayType()) && Intrinsics.areEqual(getViewType(), advertDetailsShowDescriptionItem.getViewType());
    }

    public final boolean getDescriptionShown() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.g;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean z = this.a;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = i2 * 31;
        boolean z2 = this.b;
        if (!z2) {
            i = z2 ? 1 : 0;
        }
        int a3 = (((i5 + i) * 31) + c.a(getId())) * 31;
        String stringId = getStringId();
        int i6 = 0;
        int spanCount = (getSpanCount() + ((a3 + (stringId != null ? stringId.hashCode() : 0)) * 31)) * 31;
        SerpDisplayType displayType = getDisplayType();
        int hashCode = (spanCount + (displayType != null ? displayType.hashCode() : 0)) * 31;
        SerpViewType viewType = getViewType();
        if (viewType != null) {
            i6 = viewType.hashCode();
        }
        return hashCode + i6;
    }

    public final boolean isMarketplace() {
        return this.b;
    }

    public final void setDescriptionShown(boolean z) {
        this.a = z;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.f = serpDisplayType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AdvertDetailsShowDescriptionItem(descriptionShown=");
        L.append(this.a);
        L.append(", isMarketplace=");
        L.append(this.b);
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
        parcel.writeInt(this.a ? 1 : 0);
        parcel.writeInt(this.b ? 1 : 0);
        parcel.writeLong(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f.name());
        parcel.writeString(this.g.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsShowDescriptionItem(boolean r12, boolean r13, long r14, java.lang.String r16, int r17, com.avito.android.remote.model.SerpDisplayType r18, com.avito.android.serp.adapter.SerpViewType r19, int r20, t6.r.a.j r21) {
        /*
            r11 = this;
            r0 = r20 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r3 = 0
            goto L_0x0008
        L_0x0007:
            r3 = r12
        L_0x0008:
            r0 = r20 & 2
            if (r0 == 0) goto L_0x000e
            r4 = 0
            goto L_0x000f
        L_0x000e:
            r4 = r13
        L_0x000f:
            r0 = r20 & 4
            if (r0 == 0) goto L_0x001a
            com.avito.android.advert_core.advert.AdvertDetailsItem r0 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_SHOW_DESCRIPTION
            r0 = 39
            long r0 = (long) r0
            r5 = r0
            goto L_0x001b
        L_0x001a:
            r5 = r14
        L_0x001b:
            r0 = r20 & 8
            if (r0 == 0) goto L_0x0025
            java.lang.String r0 = java.lang.String.valueOf(r5)
            r7 = r0
            goto L_0x0027
        L_0x0025:
            r7 = r16
        L_0x0027:
            r0 = r20 & 32
            if (r0 == 0) goto L_0x002f
            com.avito.android.remote.model.SerpDisplayType r0 = com.avito.android.remote.model.SerpDisplayType.Grid
            r9 = r0
            goto L_0x0031
        L_0x002f:
            r9 = r18
        L_0x0031:
            r0 = r20 & 64
            if (r0 == 0) goto L_0x0039
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r10 = r0
            goto L_0x003b
        L_0x0039:
            r10 = r19
        L_0x003b:
            r2 = r11
            r8 = r17
            r2.<init>(r3, r4, r5, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.show_description_button.AdvertDetailsShowDescriptionItem.<init>(boolean, boolean, long, java.lang.String, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}
