package com.avito.android.advert.item.divider;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001;BW\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010!\u001a\u00020\u001c\u0012\b\b\u0002\u00103\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\u0006\u00100\u001a\u00020\u0004\u0012\b\b\u0002\u0010-\u001a\u00020&\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0016\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b9\u0010:J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010!\u001a\u00020\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010%\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u000fR\"\u0010-\u001a\u00020&8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u00100\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010#\u001a\u0004\b/\u0010\u000fR\u0019\u00103\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010#\u001a\u0004\b2\u0010\u000fR\u001b\u00108\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006<"}, d2 = {"Lcom/avito/android/advert/item/divider/AdvertDetailsDividerItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "Lcom/avito/android/serp/adapter/SerpViewType;", g.a, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "d", "I", "getMarginBottomDp", "marginBottomDp", "Lcom/avito/android/remote/model/SerpDisplayType;", "f", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "e", "getSpanCount", "spanCount", "c", "getMarginTopDp", "marginTopDp", "h", "Ljava/lang/Integer;", "getHorizontalPaddingDp", "()Ljava/lang/Integer;", "horizontalPaddingDp", "<init>", "(JLjava/lang/String;IIILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;Ljava/lang/Integer;)V", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsDividerItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertDetailsDividerItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    @NotNull
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    @NotNull
    public SerpDisplayType f;
    @NotNull
    public final SerpViewType g;
    @Nullable
    public final Integer h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/item/divider/AdvertDetailsDividerItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/advert/item/divider/AdvertDetailsDividerItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AdvertDetailsDividerItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AdvertDetailsDividerItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new AdvertDetailsDividerItem(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readInt(), parcel2.readInt(), parcel2.readInt(), (SerpDisplayType) ParcelsKt.readEnum(parcel2, SerpDisplayType.values()), (SerpViewType) ParcelsKt.readEnum(parcel2, SerpViewType.values()), null, 128, null);
        }
    }

    public AdvertDetailsDividerItem(long j, @NotNull String str, int i, int i2, int i3, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = serpDisplayType;
        this.g = serpViewType;
        this.h = num;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return new AdvertDetailsDividerItem(getId(), getStringId(), this.c, this.d, i, getDisplayType(), getViewType(), null, 128, null);
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

    @Nullable
    public final Integer getHorizontalPaddingDp() {
        return this.h;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    public final int getMarginBottomDp() {
        return this.d;
    }

    public final int getMarginTopDp() {
        return this.c;
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
        parcel.writeLong(getId());
        parcel.writeString(getStringId());
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(getSpanCount());
        ParcelsKt.writeEnum(parcel, getDisplayType());
        ParcelsKt.writeEnum(parcel, getViewType());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsDividerItem(long r14, java.lang.String r16, int r17, int r18, int r19, com.avito.android.remote.model.SerpDisplayType r20, com.avito.android.serp.adapter.SerpViewType r21, java.lang.Integer r22, int r23, t6.r.a.j r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_DIVIDER
            r1 = 34
            long r1 = (long) r1
            r4 = r1
            goto L_0x000e
        L_0x000d:
            r4 = r14
        L_0x000e:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = java.lang.String.valueOf(r4)
            r6 = r1
            goto L_0x001a
        L_0x0018:
            r6 = r16
        L_0x001a:
            r1 = r0 & 4
            r2 = 24
            if (r1 == 0) goto L_0x0023
            r7 = 24
            goto L_0x0025
        L_0x0023:
            r7 = r17
        L_0x0025:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x002c
            r8 = 24
            goto L_0x002e
        L_0x002c:
            r8 = r18
        L_0x002e:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0036
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r10 = r1
            goto L_0x0038
        L_0x0036:
            r10 = r20
        L_0x0038:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0040
            com.avito.android.serp.adapter.SerpViewType r1 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r11 = r1
            goto L_0x0042
        L_0x0040:
            r11 = r21
        L_0x0042:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0049
            r0 = 0
            r12 = r0
            goto L_0x004b
        L_0x0049:
            r12 = r22
        L_0x004b:
            r3 = r13
            r9 = r19
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.divider.AdvertDetailsDividerItem.<init>(long, java.lang.String, int, int, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, java.lang.Integer, int, t6.r.a.j):void");
    }
}
