package com.avito.android.advert.item.safedeal.button;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SafeDeal;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B[\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\b\u00105\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010$\u001a\u00020\u001f\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u00109\u001a\u00020\u0004\u0012\b\b\u0002\u00102\u001a\u00020+\u0012\b\b\u0002\u0010*\u001a\u00020%¢\u0006\u0004\b?\u0010@J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u001c\u0010\u001e\u001a\u00020\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010$\u001a\u00020\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010*\u001a\u00020%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\"\u00102\u001a\u00020+8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001b\u00105\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0012\u001a\u0004\b4\u0010\u0014R\u001c\u00109\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\tR\u0019\u0010=\u001a\u00020:8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lcom/avito/android/advert/item/safedeal/button/AdvertDetailsSafeDealButtonItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "c", "Ljava/lang/String;", "getCategoryId", "()Ljava/lang/String;", "categoryId", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "Lcom/avito/android/remote/model/SafeDeal;", "e", "Lcom/avito/android/remote/model/SafeDeal;", "getSafeDeal", "()Lcom/avito/android/remote/model/SafeDeal;", "safeDeal", "Lcom/avito/android/serp/adapter/SerpViewType;", "i", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "Lcom/avito/android/remote/model/SerpDisplayType;", "h", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "d", "getUserHashId", "userHashId", g.a, "I", "getSpanCount", "spanCount", "", "f", "Z", "isMarketplace", "()Z", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SafeDeal;ZILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSafeDealButtonItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<AdvertDetailsSafeDealButtonItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @NotNull
    public final SafeDeal e;
    public final boolean f;
    public final int g;
    @NotNull
    public SerpDisplayType h;
    @NotNull
    public final SerpViewType i;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsSafeDealButtonItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsSafeDealButtonItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertDetailsSafeDealButtonItem(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), (SafeDeal) parcel.readParcelable(AdvertDetailsSafeDealButtonItem.class.getClassLoader()), parcel.readInt() != 0, parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsSafeDealButtonItem[] newArray(int i) {
            return new AdvertDetailsSafeDealButtonItem[i];
        }
    }

    public AdvertDetailsSafeDealButtonItem(long j, @NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull SafeDeal safeDeal, boolean z, int i2, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(safeDeal, "safeDeal");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = safeDeal;
        this.f = z;
        this.g = i2;
        this.h = serpDisplayType;
        this.i = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i2) {
        return new AdvertDetailsSafeDealButtonItem(getId(), getStringId(), this.c, this.d, this.e, this.f, i2, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getCategoryId() {
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

    @NotNull
    public final SafeDeal getSafeDeal() {
        return this.e;
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

    @Nullable
    public final String getUserHashId() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.i;
    }

    public final boolean isMarketplace() {
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.h = serpDisplayType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeParcelable(this.e, i2);
        parcel.writeInt(this.f ? 1 : 0);
        parcel.writeInt(this.g);
        parcel.writeString(this.h.name());
        parcel.writeString(this.i.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsSafeDealButtonItem(long r15, java.lang.String r17, java.lang.String r18, java.lang.String r19, com.avito.android.remote.model.SafeDeal r20, boolean r21, int r22, com.avito.android.remote.model.SerpDisplayType r23, com.avito.android.serp.adapter.SerpViewType r24, int r25, t6.r.a.j r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_SAFEDEAL_BUTTON
            r1 = 23
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
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0022
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r12 = r1
            goto L_0x0024
        L_0x0022:
            r12 = r23
        L_0x0024:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x002c
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r13 = r0
            goto L_0x002e
        L_0x002c:
            r13 = r24
        L_0x002e:
            r3 = r14
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r22
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.safedeal.button.AdvertDetailsSafeDealButtonItem.<init>(long, java.lang.String, java.lang.String, java.lang.String, com.avito.android.remote.model.SafeDeal, boolean, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}
