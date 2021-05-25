package com.avito.android.advert.item.dfpcreditinfo;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001DBA\u0012\b\b\u0002\u0010>\u001a\u000209\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010(\u001a\u00020!\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u00100\u001a\u00020)\u0012\b\b\u0002\u0010 \u001a\u00020\u001b¢\u0006\u0004\bB\u0010CJ\u0017\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0010R\u001c\u0010\u001a\u001a\u00020\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010 \u001a\u00020\u001b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u00100\u001a\u00020)8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00108\u001a\u0004\u0018\u0001018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u0010>\u001a\u0002098\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010A\u001a\u0002098\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010;\u001a\u0004\b@\u0010=¨\u0006E"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker$Item;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "f", "I", "getSpanCount", "spanCount", "", "d", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/serp/adapter/SerpViewType;", "h", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "", "e", "Z", "getShowDivider", "()Z", "setShowDivider", "(Z)V", "showDivider", "Lcom/avito/android/remote/model/SerpDisplayType;", g.a, "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;", "getCreditInfo", "()Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;", "setCreditInfo", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;)V", "creditInfo", "", "c", "J", "getId", "()J", "id", AuthSource.SEND_ABUSE, "getTrackId", "trackId", "<init>", "(JLjava/lang/String;ZILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsCreditInfoItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem, ItemVisibilityTracker.Item {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertDetailsCreditInfoItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    @Nullable
    public DfpCreditInfo b;
    public final long c;
    @NotNull
    public final String d;
    public boolean e;
    public final int f;
    @NotNull
    public SerpDisplayType g;
    @NotNull
    public final SerpViewType h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AdvertDetailsCreditInfoItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AdvertDetailsCreditInfoItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new AdvertDetailsCreditInfoItem(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"), ParcelsKt.readBool(parcel2), parcel2.readInt(), (SerpDisplayType) ParcelsKt.readEnum(parcel2, SerpDisplayType.values()), (SerpViewType) ParcelsKt.readEnum(parcel2, SerpViewType.values()));
        }
    }

    public AdvertDetailsCreditInfoItem(long j, @NotNull String str, boolean z, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.c = j;
        this.d = str;
        this.e = z;
        this.f = i;
        this.g = serpDisplayType;
        this.h = serpViewType;
        this.a = getId();
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return new AdvertDetailsCreditInfoItem(getId(), getStringId(), this.e, i, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final DfpCreditInfo getCreditInfo() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.c;
    }

    public final boolean getShowDivider() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.d;
    }

    @Override // com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item
    public long getTrackId() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.h;
    }

    public final void setCreditInfo(@Nullable DfpCreditInfo dfpCreditInfo) {
        this.b = dfpCreditInfo;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.g = serpDisplayType;
    }

    public final void setShowDivider(boolean z) {
        this.e = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(getId());
        parcel.writeString(getStringId());
        ParcelsKt.writeBool(parcel, this.e);
        parcel.writeInt(getSpanCount());
        ParcelsKt.writeEnum(parcel, getDisplayType());
        ParcelsKt.writeEnum(parcel, getViewType());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsCreditInfoItem(long r11, java.lang.String r13, boolean r14, int r15, com.avito.android.remote.model.SerpDisplayType r16, com.avito.android.serp.adapter.SerpViewType r17, int r18, t6.r.a.j r19) {
        /*
            r10 = this;
            r0 = r18 & 1
            if (r0 == 0) goto L_0x000b
            com.avito.android.advert_core.advert.AdvertDetailsItem r0 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_CREDIT_INFO
            r0 = 16
            long r0 = (long) r0
            r3 = r0
            goto L_0x000c
        L_0x000b:
            r3 = r11
        L_0x000c:
            r0 = r18 & 2
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = java.lang.String.valueOf(r3)
            r5 = r0
            goto L_0x0017
        L_0x0016:
            r5 = r13
        L_0x0017:
            r0 = r18 & 4
            if (r0 == 0) goto L_0x001e
            r0 = 1
            r6 = 1
            goto L_0x001f
        L_0x001e:
            r6 = r14
        L_0x001f:
            r0 = r18 & 16
            if (r0 == 0) goto L_0x0027
            com.avito.android.remote.model.SerpDisplayType r0 = com.avito.android.remote.model.SerpDisplayType.Grid
            r8 = r0
            goto L_0x0029
        L_0x0027:
            r8 = r16
        L_0x0029:
            r0 = r18 & 32
            if (r0 == 0) goto L_0x0031
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r9 = r0
            goto L_0x0033
        L_0x0031:
            r9 = r17
        L_0x0033:
            r2 = r10
            r7 = r15
            r2.<init>(r3, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoItem.<init>(long, java.lang.String, boolean, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}
