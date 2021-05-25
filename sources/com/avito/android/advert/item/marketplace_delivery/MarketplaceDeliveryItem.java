package com.avito.android.advert.item.marketplace_delivery;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.marketplace.Delivery;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SimpleAdvertAction;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B_\u0012\b\b\u0002\u0010:\u001a\u000205\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u00104\u001a\u00020/\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010@\u001a\u0004\u0018\u00010;\u0012\u0006\u0010D\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u001e\u0012\b\b\u0002\u0010+\u001a\u00020&¢\u0006\u0004\bE\u0010FJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001d\u001a\u00020\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010+\u001a\u00020&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010.\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u001a\u001a\u0004\b-\u0010\u001cR\u0019\u00104\u001a\u00020/8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001c\u0010:\u001a\u0002058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001b\u0010@\u001a\u0004\u0018\u00010;8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001c\u0010D\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010\t¨\u0006G"}, d2 = {"Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Location;", "d", "Lcom/avito/android/remote/model/Location;", "getLocationTo", "()Lcom/avito/android/remote/model/Location;", "setLocationTo", "(Lcom/avito/android/remote/model/Location;)V", "locationTo", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/remote/model/SerpDisplayType;", "h", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "Lcom/avito/android/serp/adapter/SerpViewType;", "i", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "e", "getDeliveryInfo", "deliveryInfo", "Lcom/avito/android/remote/marketplace/Delivery;", "c", "Lcom/avito/android/remote/marketplace/Delivery;", "getDeliveryStatic", "()Lcom/avito/android/remote/marketplace/Delivery;", "deliveryStatic", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "Lcom/avito/android/remote/model/SimpleAdvertAction;", "f", "Lcom/avito/android/remote/model/SimpleAdvertAction;", "getDeliveryAction", "()Lcom/avito/android/remote/model/SimpleAdvertAction;", "deliveryAction", g.a, "I", "getSpanCount", "spanCount", "<init>", "(JLjava/lang/String;Lcom/avito/android/remote/marketplace/Delivery;Lcom/avito/android/remote/model/Location;Ljava/lang/String;Lcom/avito/android/remote/model/SimpleAdvertAction;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceDeliveryItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<MarketplaceDeliveryItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final Delivery c;
    @Nullable
    public Location d;
    @Nullable
    public final String e;
    @Nullable
    public final SimpleAdvertAction f;
    public final int g;
    @NotNull
    public SerpDisplayType h;
    @NotNull
    public final SerpViewType i;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MarketplaceDeliveryItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceDeliveryItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new MarketplaceDeliveryItem(parcel.readLong(), parcel.readString(), (Delivery) parcel.readParcelable(MarketplaceDeliveryItem.class.getClassLoader()), (Location) parcel.readParcelable(MarketplaceDeliveryItem.class.getClassLoader()), parcel.readString(), (SimpleAdvertAction) parcel.readParcelable(MarketplaceDeliveryItem.class.getClassLoader()), parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceDeliveryItem[] newArray(int i) {
            return new MarketplaceDeliveryItem[i];
        }
    }

    public MarketplaceDeliveryItem(long j, @NotNull String str, @NotNull Delivery delivery, @Nullable Location location, @Nullable String str2, @Nullable SimpleAdvertAction simpleAdvertAction, int i2, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(delivery, "deliveryStatic");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j;
        this.b = str;
        this.c = delivery;
        this.d = location;
        this.e = str2;
        this.f = simpleAdvertAction;
        this.g = i2;
        this.h = serpDisplayType;
        this.i = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i2) {
        return new MarketplaceDeliveryItem(getId(), getStringId(), this.c, this.d, this.e, this.f, i2, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final SimpleAdvertAction getDeliveryAction() {
        return this.f;
    }

    @Nullable
    public final String getDeliveryInfo() {
        return this.e;
    }

    @NotNull
    public final Delivery getDeliveryStatic() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.h;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Nullable
    public final Location getLocationTo() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.i;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.h = serpDisplayType;
    }

    public final void setLocationTo(@Nullable Location location) {
        this.d = location;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i2);
        parcel.writeParcelable(this.d, i2);
        parcel.writeString(this.e);
        parcel.writeParcelable(this.f, i2);
        parcel.writeInt(this.g);
        parcel.writeString(this.h.name());
        parcel.writeString(this.i.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MarketplaceDeliveryItem(long r15, java.lang.String r17, com.avito.android.remote.marketplace.Delivery r18, com.avito.android.remote.model.Location r19, java.lang.String r20, com.avito.android.remote.model.SimpleAdvertAction r21, int r22, com.avito.android.remote.model.SerpDisplayType r23, com.avito.android.serp.adapter.SerpViewType r24, int r25, t6.r.a.j r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_MARKETPLACE_DELIVERY
            r1 = 54
            long r1 = (long) r1
            r4 = r1
            goto L_0x000e
        L_0x000d:
            r4 = r15
        L_0x000e:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = java.lang.String.valueOf(r4)
            r6 = r1
            goto L_0x001a
        L_0x0018:
            r6 = r17
        L_0x001a:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0021
            r1 = 0
            r8 = r1
            goto L_0x0023
        L_0x0021:
            r8 = r19
        L_0x0023:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x002b
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r12 = r1
            goto L_0x002d
        L_0x002b:
            r12 = r23
        L_0x002d:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0035
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r13 = r0
            goto L_0x0037
        L_0x0035:
            r13 = r24
        L_0x0037:
            r3 = r14
            r7 = r18
            r9 = r20
            r10 = r21
            r11 = r22
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryItem.<init>(long, java.lang.String, com.avito.android.remote.marketplace.Delivery, com.avito.android.remote.model.Location, java.lang.String, com.avito.android.remote.model.SimpleAdvertAction, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}
