package com.avito.android.advert.item.icebreakers;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.IceBreakers;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\b\b\u0002\u0010!\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010-\u001a\u00020&\u0012\b\b\u0002\u00103\u001a\u00020.¢\u0006\u0004\b4\u00105J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010!\u001a\u00020\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\tR\"\u0010-\u001a\u00020&8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u00103\u001a\u00020.8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/remote/model/IceBreakers;", "c", "Lcom/avito/android/remote/model/IceBreakers;", "getIcebreakers", "()Lcom/avito/android/remote/model/IceBreakers;", "icebreakers", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "d", "I", "getSpanCount", "spanCount", "Lcom/avito/android/remote/model/SerpDisplayType;", "e", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "Lcom/avito/android/serp/adapter/SerpViewType;", "f", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "<init>", "(JLjava/lang/String;Lcom/avito/android/remote/model/IceBreakers;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsIceBreakersItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<AdvertDetailsIceBreakersItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final IceBreakers c;
    public final int d;
    @NotNull
    public SerpDisplayType e;
    @NotNull
    public final SerpViewType f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsIceBreakersItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsIceBreakersItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertDetailsIceBreakersItem(parcel.readLong(), parcel.readString(), (IceBreakers) parcel.readParcelable(AdvertDetailsIceBreakersItem.class.getClassLoader()), parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsIceBreakersItem[] newArray(int i) {
            return new AdvertDetailsIceBreakersItem[i];
        }
    }

    public AdvertDetailsIceBreakersItem(long j, @NotNull String str, @NotNull IceBreakers iceBreakers, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(iceBreakers, "icebreakers");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j;
        this.b = str;
        this.c = iceBreakers;
        this.d = i;
        this.e = serpDisplayType;
        this.f = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return new AdvertDetailsIceBreakersItem(getId(), getStringId(), this.c, i, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.e;
    }

    @NotNull
    public final IceBreakers getIcebreakers() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.e = serpDisplayType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeInt(this.d);
        parcel.writeString(this.e.name());
        parcel.writeString(this.f.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsIceBreakersItem(long r11, java.lang.String r13, com.avito.android.remote.model.IceBreakers r14, int r15, com.avito.android.remote.model.SerpDisplayType r16, com.avito.android.serp.adapter.SerpViewType r17, int r18, t6.r.a.j r19) {
        /*
            r10 = this;
            r0 = r18 & 1
            if (r0 == 0) goto L_0x000b
            com.avito.android.advert_core.advert.AdvertDetailsItem r0 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_ICE_BREAKERS
            r0 = 46
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
            r6 = r14
            r7 = r15
            r2.<init>(r3, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.icebreakers.AdvertDetailsIceBreakersItem.<init>(long, java.lang.String, com.avito.android.remote.model.IceBreakers, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}
