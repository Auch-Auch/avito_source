package com.avito.android.advert.item.spare_parts;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SparePartsParameters;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BG\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010/\u001a\u00020*\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u00103\u001a\u00020\u0004\u0012\b\b\u0002\u0010)\u001a\u00020\"\u0012\b\b\u0002\u00109\u001a\u000204¢\u0006\u0004\b:\u0010;J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010!\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0019\u0010/\u001a\u00020*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u00103\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\tR\u001c\u00109\u001a\u0002048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/avito/android/advert/item/spare_parts/SparePartsItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/remote/model/SparePartsParameters;", "d", "Lcom/avito/android/remote/model/SparePartsParameters;", "getParams", "()Lcom/avito/android/remote/model/SparePartsParameters;", "params", "Lcom/avito/android/remote/model/SerpDisplayType;", "f", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "Lcom/avito/android/advert/item/spare_parts/SparePartsItemType;", "c", "Lcom/avito/android/advert/item/spare_parts/SparePartsItemType;", "getType", "()Lcom/avito/android/advert/item/spare_parts/SparePartsItemType;", "type", "e", "I", "getSpanCount", "spanCount", "Lcom/avito/android/serp/adapter/SerpViewType;", g.a, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "<init>", "(JLjava/lang/String;Lcom/avito/android/advert/item/spare_parts/SparePartsItemType;Lcom/avito/android/remote/model/SparePartsParameters;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SparePartsItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<SparePartsItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final SparePartsItemType c;
    @NotNull
    public final SparePartsParameters d;
    public final int e;
    @NotNull
    public SerpDisplayType f;
    @NotNull
    public final SerpViewType g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SparePartsItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SparePartsItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SparePartsItem(parcel.readLong(), parcel.readString(), (SparePartsItemType) Enum.valueOf(SparePartsItemType.class, parcel.readString()), (SparePartsParameters) parcel.readParcelable(SparePartsItem.class.getClassLoader()), parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SparePartsItem[] newArray(int i) {
            return new SparePartsItem[i];
        }
    }

    public SparePartsItem(long j, @NotNull String str, @NotNull SparePartsItemType sparePartsItemType, @NotNull SparePartsParameters sparePartsParameters, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(sparePartsItemType, "type");
        Intrinsics.checkNotNullParameter(sparePartsParameters, "params");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j;
        this.b = str;
        this.c = sparePartsItemType;
        this.d = sparePartsParameters;
        this.e = i;
        this.f = serpDisplayType;
        this.g = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return new SparePartsItem(getId(), getStringId(), this.c, this.d, i, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    @NotNull
    public final SparePartsParameters getParams() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @NotNull
    public final SparePartsItemType getType() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.f = serpDisplayType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c.name());
        parcel.writeParcelable(this.d, i);
        parcel.writeInt(this.e);
        parcel.writeString(this.f.name());
        parcel.writeString(this.g.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SparePartsItem(long r14, java.lang.String r16, com.avito.android.advert.item.spare_parts.SparePartsItemType r17, com.avito.android.remote.model.SparePartsParameters r18, int r19, com.avito.android.remote.model.SerpDisplayType r20, com.avito.android.serp.adapter.SerpViewType r21, int r22, t6.r.a.j r23) {
        /*
            r13 = this;
            r0 = r22 & 1
            r1 = 64
            if (r0 == 0) goto L_0x000b
            com.avito.android.advert_core.advert.AdvertDetailsItem r0 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_SPARE_PARTS
            long r2 = (long) r1
            r5 = r2
            goto L_0x000c
        L_0x000b:
            r5 = r14
        L_0x000c:
            r0 = r22 & 2
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = java.lang.String.valueOf(r5)
            r7 = r0
            goto L_0x0018
        L_0x0016:
            r7 = r16
        L_0x0018:
            r0 = r22 & 32
            if (r0 == 0) goto L_0x0020
            com.avito.android.remote.model.SerpDisplayType r0 = com.avito.android.remote.model.SerpDisplayType.Grid
            r11 = r0
            goto L_0x0022
        L_0x0020:
            r11 = r20
        L_0x0022:
            r0 = r22 & 64
            if (r0 == 0) goto L_0x002a
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r12 = r0
            goto L_0x002c
        L_0x002a:
            r12 = r21
        L_0x002c:
            r4 = r13
            r8 = r17
            r9 = r18
            r10 = r19
            r4.<init>(r5, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.spare_parts.SparePartsItem.<init>(long, java.lang.String, com.avito.android.advert.item.spare_parts.SparePartsItemType, com.avito.android.remote.model.SparePartsParameters, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}
