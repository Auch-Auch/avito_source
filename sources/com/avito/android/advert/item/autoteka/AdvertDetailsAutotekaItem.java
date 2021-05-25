package com.avito.android.advert.item.autoteka;

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
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u00018BA\u0012\b\b\u0002\u00105\u001a\u000200\u0012\b\b\u0002\u0010#\u001a\u00020\u001e\u0012\u0006\u0010/\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010+\u001a\u00020$¢\u0006\u0004\b6\u00107J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010#\u001a\u00020\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010/\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u000fR\u001c\u00105\u001a\u0002008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00069"}, d2 = {"Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/serp/adapter/SerpViewType;", "e", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "Lcom/avito/android/remote/model/SerpDisplayType;", "d", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", "f", "Z", "getNeedToShowTopDivider", "()Z", "setNeedToShowTopDivider", "(Z)V", "needToShowTopDivider", "c", "I", "getSpanCount", "spanCount", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "<init>", "(JLjava/lang/String;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;Z)V", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAutotekaItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertDetailsAutotekaItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    @NotNull
    public final String b;
    public final int c;
    @NotNull
    public SerpDisplayType d;
    @NotNull
    public final SerpViewType e;
    public boolean f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AdvertDetailsAutotekaItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AdvertDetailsAutotekaItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new AdvertDetailsAutotekaItem(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readInt(), (SerpDisplayType) ParcelsKt.readEnum(parcel2, SerpDisplayType.values()), (SerpViewType) ParcelsKt.readEnum(parcel2, SerpViewType.values()), Parcels.readBool(parcel2));
        }
    }

    public AdvertDetailsAutotekaItem(long j, @NotNull String str, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType, boolean z) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j;
        this.b = str;
        this.c = i;
        this.d = serpDisplayType;
        this.e = serpViewType;
        this.f = z;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return new AdvertDetailsAutotekaItem(getId(), getStringId(), i, getDisplayType(), getViewType(), this.f);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    public final boolean getNeedToShowTopDivider() {
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.d = serpDisplayType;
    }

    public final void setNeedToShowTopDivider(boolean z) {
        this.f = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(getId());
        parcel.writeString(getStringId());
        parcel.writeInt(getSpanCount());
        ParcelsKt.writeEnum(parcel, getDisplayType());
        ParcelsKt.writeEnum(parcel, getViewType());
        Parcels.writeBool(parcel, this.f);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsAutotekaItem(long r11, java.lang.String r13, int r14, com.avito.android.remote.model.SerpDisplayType r15, com.avito.android.serp.adapter.SerpViewType r16, boolean r17, int r18, t6.r.a.j r19) {
        /*
            r10 = this;
            r0 = r18 & 1
            if (r0 == 0) goto L_0x000b
            com.avito.android.advert_core.advert.AdvertDetailsItem r0 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_AUTOTEKA
            r0 = 11
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
            r0 = r18 & 8
            if (r0 == 0) goto L_0x001f
            com.avito.android.remote.model.SerpDisplayType r0 = com.avito.android.remote.model.SerpDisplayType.Grid
            r7 = r0
            goto L_0x0020
        L_0x001f:
            r7 = r15
        L_0x0020:
            r0 = r18 & 16
            if (r0 == 0) goto L_0x0028
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r8 = r0
            goto L_0x002a
        L_0x0028:
            r8 = r16
        L_0x002a:
            r0 = r18 & 32
            if (r0 == 0) goto L_0x0031
            r0 = 1
            r9 = 1
            goto L_0x0033
        L_0x0031:
            r9 = r17
        L_0x0033:
            r2 = r10
            r6 = r14
            r2.<init>(r3, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaItem.<init>(long, java.lang.String, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, boolean, int, t6.r.a.j):void");
    }
}
