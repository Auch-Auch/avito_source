package com.avito.android.advert.item.status_badge;

import a2.b.a.a.a;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0014¢\u0006\u0004\b@\u0010AJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016JL\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u0014HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001f\u0010\nJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b \u0010\u0010J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b&\u0010\u0010J \u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b+\u0010,R\"\u0010\u001b\u001a\u00020\u00118\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0013\"\u0004\b0\u00101R\u001c\u0010\u001c\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0016R\u001c\u0010\u001a\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u0010R\u001c\u0010\u0019\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010\nR\u0019\u0010\u0017\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b;\u00109\u001a\u0004\b<\u0010\nR\u001c\u0010\u0018\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\r¨\u0006B"}, d2 = {"Lcom/avito/android/advert/item/status_badge/AdvertDetailsClosingReasonItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "component3", "component4", "()I", "Lcom/avito/android/remote/model/SerpDisplayType;", "component5", "()Lcom/avito/android/remote/model/SerpDisplayType;", "Lcom/avito/android/serp/adapter/SerpViewType;", "component6", "()Lcom/avito/android/serp/adapter/SerpViewType;", "reason", "id", "stringId", "spanCount", "displayType", "viewType", "copy", "(Ljava/lang/String;JLjava/lang/String;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)Lcom/avito/android/advert/item/status_badge/AdvertDetailsClosingReasonItem;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "e", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "f", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "d", "I", "getSpanCount", "c", "Ljava/lang/String;", "getStringId", AuthSource.SEND_ABUSE, "getReason", AuthSource.BOOKING_ORDER, "J", "getId", "<init>", "(Ljava/lang/String;JLjava/lang/String;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsClosingReasonItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<AdvertDetailsClosingReasonItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    public final long b;
    @NotNull
    public final String c;
    public final int d;
    @NotNull
    public SerpDisplayType e;
    @NotNull
    public final SerpViewType f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsClosingReasonItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsClosingReasonItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertDetailsClosingReasonItem(parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsClosingReasonItem[] newArray(int i) {
            return new AdvertDetailsClosingReasonItem[i];
        }
    }

    public AdvertDetailsClosingReasonItem(@NotNull String str, long j, @NotNull String str2, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "reason");
        Intrinsics.checkNotNullParameter(str2, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = str;
        this.b = j;
        this.c = str2;
        this.d = i;
        this.e = serpDisplayType;
        this.f = serpViewType;
    }

    public static /* synthetic */ AdvertDetailsClosingReasonItem copy$default(AdvertDetailsClosingReasonItem advertDetailsClosingReasonItem, String str, long j, String str2, int i, SerpDisplayType serpDisplayType, SerpViewType serpViewType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = advertDetailsClosingReasonItem.a;
        }
        if ((i2 & 2) != 0) {
            j = advertDetailsClosingReasonItem.getId();
        }
        if ((i2 & 4) != 0) {
            str2 = advertDetailsClosingReasonItem.getStringId();
        }
        if ((i2 & 8) != 0) {
            i = advertDetailsClosingReasonItem.getSpanCount();
        }
        if ((i2 & 16) != 0) {
            serpDisplayType = advertDetailsClosingReasonItem.getDisplayType();
        }
        if ((i2 & 32) != 0) {
            serpViewType = advertDetailsClosingReasonItem.getViewType();
        }
        return advertDetailsClosingReasonItem.copy(str, j, str2, i, serpDisplayType, serpViewType);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final long component2() {
        return getId();
    }

    @NotNull
    public final String component3() {
        return getStringId();
    }

    public final int component4() {
        return getSpanCount();
    }

    @NotNull
    public final SerpDisplayType component5() {
        return getDisplayType();
    }

    @NotNull
    public final SerpViewType component6() {
        return getViewType();
    }

    @NotNull
    public final AdvertDetailsClosingReasonItem copy(@NotNull String str, long j, @NotNull String str2, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "reason");
        Intrinsics.checkNotNullParameter(str2, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        return new AdvertDetailsClosingReasonItem(str, j, str2, i, serpDisplayType, serpViewType);
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return copy$default(this, null, 0, null, i, null, null, 55, null);
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
        if (!(obj instanceof AdvertDetailsClosingReasonItem)) {
            return false;
        }
        AdvertDetailsClosingReasonItem advertDetailsClosingReasonItem = (AdvertDetailsClosingReasonItem) obj;
        return Intrinsics.areEqual(this.a, advertDetailsClosingReasonItem.a) && getId() == advertDetailsClosingReasonItem.getId() && Intrinsics.areEqual(getStringId(), advertDetailsClosingReasonItem.getStringId()) && getSpanCount() == advertDetailsClosingReasonItem.getSpanCount() && Intrinsics.areEqual(getDisplayType(), advertDetailsClosingReasonItem.getDisplayType()) && Intrinsics.areEqual(getViewType(), advertDetailsClosingReasonItem.getViewType());
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.b;
    }

    @NotNull
    public final String getReason() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.f;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + c.a(getId())) * 31;
        String stringId = getStringId();
        int spanCount = (getSpanCount() + ((hashCode + (stringId != null ? stringId.hashCode() : 0)) * 31)) * 31;
        SerpDisplayType displayType = getDisplayType();
        int hashCode2 = (spanCount + (displayType != null ? displayType.hashCode() : 0)) * 31;
        SerpViewType viewType = getViewType();
        if (viewType != null) {
            i = viewType.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.e = serpDisplayType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AdvertDetailsClosingReasonItem(reason=");
        L.append(this.a);
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
        parcel.writeLong(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e.name());
        parcel.writeString(this.f.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsClosingReasonItem(java.lang.String r11, long r12, java.lang.String r14, int r15, com.avito.android.remote.model.SerpDisplayType r16, com.avito.android.serp.adapter.SerpViewType r17, int r18, t6.r.a.j r19) {
        /*
            r10 = this;
            r0 = r18 & 2
            if (r0 == 0) goto L_0x000b
            com.avito.android.advert_core.advert.AdvertDetailsItem r0 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_STATUS_BADGE
            r0 = 37
            long r0 = (long) r0
            r4 = r0
            goto L_0x000c
        L_0x000b:
            r4 = r12
        L_0x000c:
            r0 = r18 & 4
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = java.lang.String.valueOf(r4)
            r6 = r0
            goto L_0x0017
        L_0x0016:
            r6 = r14
        L_0x0017:
            r0 = r18 & 16
            if (r0 == 0) goto L_0x001f
            com.avito.android.remote.model.SerpDisplayType r0 = com.avito.android.remote.model.SerpDisplayType.Grid
            r8 = r0
            goto L_0x0021
        L_0x001f:
            r8 = r16
        L_0x0021:
            r0 = r18 & 32
            if (r0 == 0) goto L_0x0029
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r9 = r0
            goto L_0x002b
        L_0x0029:
            r9 = r17
        L_0x002b:
            r2 = r10
            r3 = r11
            r7 = r15
            r2.<init>(r3, r4, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.status_badge.AdvertDetailsClosingReasonItem.<init>(java.lang.String, long, java.lang.String, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}
