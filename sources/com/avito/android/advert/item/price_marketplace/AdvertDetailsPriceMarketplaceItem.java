package com.avito.android.advert.item.price_marketplace;

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
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B_\u0012\b\b\u0002\u0010$\u001a\u00020\u001f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010\u0012\u0006\u0010\u001e\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u00106\u001a\u000201\u0012\u0006\u00109\u001a\u000201\u0012\u0006\u0010(\u001a\u00020\u0004\u0012\b\b\u0002\u00100\u001a\u00020)\u0012\b\b\u0002\u0010?\u001a\u00020:¢\u0006\u0004\b@\u0010AJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0018\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u0019\u0010\u001e\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R\u001c\u0010$\u001a\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010(\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\tR\"\u00100\u001a\u00020)8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0019\u00106\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0019\u00109\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b7\u00103\u001a\u0004\b8\u00105R\u001c\u0010?\u001a\u00020:8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/avito/android/advert/item/price_marketplace/AdvertDetailsPriceMarketplaceItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "e", "Ljava/lang/String;", "getDiscountPercentage", "()Ljava/lang/String;", "discountPercentage", "d", "getOldPrice", "oldPrice", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "c", "getPrice", "price", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "h", "I", "getSpanCount", "spanCount", "Lcom/avito/android/remote/model/SerpDisplayType;", "i", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "", "f", "Z", "getClosedAdvert", "()Z", "closedAdvert", g.a, "getHideDiscountPercent", "hideDiscountPercent", "Lcom/avito/android/serp/adapter/SerpViewType;", "j", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsPriceMarketplaceItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<AdvertDetailsPriceMarketplaceItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    public final boolean f;
    public final boolean g;
    public final int h;
    @NotNull
    public SerpDisplayType i;
    @NotNull
    public final SerpViewType j;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsPriceMarketplaceItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsPriceMarketplaceItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            boolean z = false;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            return new AdvertDetailsPriceMarketplaceItem(readLong, readString, readString2, readString3, readString4, z2, z, parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsPriceMarketplaceItem[] newArray(int i) {
            return new AdvertDetailsPriceMarketplaceItem[i];
        }
    }

    public AdvertDetailsPriceMarketplaceItem(long j2, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, boolean z2, int i2, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "price");
        Intrinsics.checkNotNullParameter(str3, "oldPrice");
        Intrinsics.checkNotNullParameter(str4, "discountPercentage");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j2;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = z;
        this.g = z2;
        this.h = i2;
        this.i = serpDisplayType;
        this.j = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i2) {
        return new AdvertDetailsPriceMarketplaceItem(getId(), getStringId(), this.c, this.d, this.e, this.f, this.g, i2, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean getClosedAdvert() {
        return this.f;
    }

    @NotNull
    public final String getDiscountPercentage() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.i;
    }

    public final boolean getHideDiscountPercent() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final String getOldPrice() {
        return this.d;
    }

    @NotNull
    public final String getPrice() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.h;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.j;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.i = serpDisplayType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f ? 1 : 0);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h);
        parcel.writeString(this.i.name());
        parcel.writeString(this.j.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsPriceMarketplaceItem(long r16, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, boolean r22, boolean r23, int r24, com.avito.android.remote.model.SerpDisplayType r25, com.avito.android.serp.adapter.SerpViewType r26, int r27, t6.r.a.j r28) {
        /*
            r15 = this;
            r0 = r27
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_PRICE
            r1 = 2
            long r1 = (long) r1
            r4 = r1
            goto L_0x000e
        L_0x000c:
            r4 = r16
        L_0x000e:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = java.lang.String.valueOf(r4)
            r6 = r1
            goto L_0x001a
        L_0x0018:
            r6 = r18
        L_0x001a:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0022
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r13 = r1
            goto L_0x0024
        L_0x0022:
            r13 = r25
        L_0x0024:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x002c
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r14 = r0
            goto L_0x002e
        L_0x002c:
            r14 = r26
        L_0x002e:
            r3 = r15
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r11 = r23
            r12 = r24
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.price_marketplace.AdvertDetailsPriceMarketplaceItem.<init>(long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}
