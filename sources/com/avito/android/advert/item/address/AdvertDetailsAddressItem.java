package com.avito.android.advert.item.address;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.appevents.integrity.IntegrityManager;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001EBc\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0018\u0012\b\b\u0002\u00100\u001a\u00020\u001e\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\b\u0010)\u001a\u0004\u0018\u00010$\u0012\u0006\u0010?\u001a\u00020\u001e\u0012\b\b\u0002\u0010B\u001a\u000201\u0012\u0006\u00106\u001a\u000201\u0012\u0006\u0010-\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010<\u001a\u000207¢\u0006\u0004\bC\u0010DJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00108\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001d\u001a\u00020\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010#\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010)\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010-\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u000fR\u001c\u00100\u001a\u00020\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010 \u001a\u0004\b/\u0010\"R\u0019\u00106\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001c\u0010<\u001a\u0002078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0019\u0010?\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010 \u001a\u0004\b>\u0010\"R\u0019\u0010B\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b@\u00103\u001a\u0004\bA\u00105¨\u0006F"}, d2 = {"Lcom/avito/android/advert/item/address/AdvertDetailsAddressItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/SerpDisplayType;", "i", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "", "c", "Ljava/lang/String;", "getAddress", "()Ljava/lang/String;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Coordinates;", "d", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "()Lcom/avito/android/remote/model/Coordinates;", "coordinates", "h", "I", "getSpanCount", "spanCount", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "", g.a, "Z", "getHideArrow", "()Z", "hideArrow", "Lcom/avito/android/serp/adapter/SerpViewType;", "j", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "e", "getAdvertTitle", "advertTitle", "f", "getHasReducedPadding", "hasReducedPadding", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;ZZILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAddressItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertDetailsAddressItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @Nullable
    public final Coordinates d;
    @NotNull
    public final String e;
    public final boolean f;
    public final boolean g;
    public final int h;
    @NotNull
    public SerpDisplayType i;
    @NotNull
    public final SerpViewType j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/item/address/AdvertDetailsAddressItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/advert/item/address/AdvertDetailsAddressItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AdvertDetailsAddressItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AdvertDetailsAddressItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new AdvertDetailsAddressItem(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), (Coordinates) parcel2.readParcelable(Coordinates.class.getClassLoader()), a2.b.a.a.a.u2(parcel2, "readString()!!"), ParcelsKt.readBool(parcel2), ParcelsKt.readBool(parcel2), parcel2.readInt(), (SerpDisplayType) ParcelsKt.readEnum(parcel2, SerpDisplayType.values()), (SerpViewType) ParcelsKt.readEnum(parcel2, SerpViewType.values()));
        }
    }

    public AdvertDetailsAddressItem(long j2, @NotNull String str, @NotNull String str2, @Nullable Coordinates coordinates, @NotNull String str3, boolean z, boolean z2, int i2, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        Intrinsics.checkNotNullParameter(str3, "advertTitle");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j2;
        this.b = str;
        this.c = str2;
        this.d = coordinates;
        this.e = str3;
        this.f = z;
        this.g = z2;
        this.h = i2;
        this.i = serpDisplayType;
        this.j = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i2) {
        return new AdvertDetailsAddressItem(getId(), getStringId(), this.c, this.d, this.e, this.f, this.g, i2, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getAddress() {
        return this.c;
    }

    @NotNull
    public final String getAdvertTitle() {
        return this.e;
    }

    @Nullable
    public final Coordinates getCoordinates() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.i;
    }

    public final boolean getHasReducedPadding() {
        return this.f;
    }

    public final boolean getHideArrow() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
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
        parcel.writeLong(getId());
        parcel.writeString(getStringId());
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i2);
        parcel.writeString(this.e);
        ParcelsKt.writeBool(parcel, this.f);
        ParcelsKt.writeBool(parcel, this.g);
        parcel.writeInt(getSpanCount());
        ParcelsKt.writeEnum(parcel, getDisplayType());
        ParcelsKt.writeEnum(parcel, getViewType());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsAddressItem(long r16, java.lang.String r18, java.lang.String r19, com.avito.android.remote.model.Coordinates r20, java.lang.String r21, boolean r22, boolean r23, int r24, com.avito.android.remote.model.SerpDisplayType r25, com.avito.android.serp.adapter.SerpViewType r26, int r27, t6.r.a.j r28) {
        /*
            r15 = this;
            r0 = r27
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_ADDRESS
            r1 = 6
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
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0021
            r1 = 0
            r10 = 0
            goto L_0x0023
        L_0x0021:
            r10 = r22
        L_0x0023:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x002b
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r13 = r1
            goto L_0x002d
        L_0x002b:
            r13 = r25
        L_0x002d:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0035
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r14 = r0
            goto L_0x0037
        L_0x0035:
            r14 = r26
        L_0x0037:
            r3 = r15
            r7 = r19
            r8 = r20
            r9 = r21
            r11 = r23
            r12 = r24
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.address.AdvertDetailsAddressItem.<init>(long, java.lang.String, java.lang.String, com.avito.android.remote.model.Coordinates, java.lang.String, boolean, boolean, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}
