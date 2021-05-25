package com.avito.android.advert.item.auto_catalog;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003Bg\u0012\b\b\u0002\u0010#\u001a\u00020\u001e\u0012\b\b\u0002\u00105\u001a\u00020\u0010\u0012\u0006\u0010,\u001a\u00020\u0010\u0012\b\u00108\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010)\u001a\u0004\u0018\u00010$\u0012\u0006\u0010?\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0016\u0012\b\b\u0002\u00102\u001a\u00020-¢\u0006\u0004\b@\u0010AJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010#\u001a\u00020\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010)\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010,\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010\u0014R\u001c\u00102\u001a\u00020-8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001c\u00105\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u0010\u0012\u001a\u0004\b4\u0010\u0014R\u001b\u00108\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u0012\u001a\u0004\b7\u0010\u0014R\u001b\u0010;\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0012\u001a\u0004\b:\u0010\u0014R\u001c\u0010?\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\t¨\u0006B"}, d2 = {"Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "e", "Ljava/lang/String;", "getMcid", "()Ljava/lang/String;", "mcid", "Lcom/avito/android/remote/model/SerpDisplayType;", "i", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "Lcom/avito/android/deep_linking/links/DeepLink;", g.a, "Lcom/avito/android/deep_linking/links/DeepLink;", "getAutoCatalogLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "autoCatalogLink", "c", "getAdvertId", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/serp/adapter/SerpViewType;", "j", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "d", "getSearchContext", "searchContext", "f", "getLocationId", "locationId", "h", "I", "getSpanCount", "spanCount", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAutoCatalogItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<AdvertDetailsAutoCatalogItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final DeepLink g;
    public final int h;
    @NotNull
    public SerpDisplayType i;
    @NotNull
    public final SerpViewType j;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsAutoCatalogItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsAutoCatalogItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertDetailsAutoCatalogItem(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (DeepLink) parcel.readParcelable(AdvertDetailsAutoCatalogItem.class.getClassLoader()), parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsAutoCatalogItem[] newArray(int i) {
            return new AdvertDetailsAutoCatalogItem[i];
        }
    }

    public AdvertDetailsAutoCatalogItem(long j2, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable DeepLink deepLink, int i2, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j2;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = deepLink;
        this.h = i2;
        this.i = serpDisplayType;
        this.j = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i2) {
        return new AdvertDetailsAutoCatalogItem(getId(), getStringId(), this.c, this.d, this.e, this.f, this.g, i2, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getAdvertId() {
        return this.c;
    }

    @Nullable
    public final DeepLink getAutoCatalogLink() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.i;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Nullable
    public final String getLocationId() {
        return this.f;
    }

    @Nullable
    public final String getMcid() {
        return this.e;
    }

    @Nullable
    public final String getSearchContext() {
        return this.d;
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
        parcel.writeString(this.f);
        parcel.writeParcelable(this.g, i2);
        parcel.writeInt(this.h);
        parcel.writeString(this.i.name());
        parcel.writeString(this.j.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsAutoCatalogItem(long r16, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, com.avito.android.deep_linking.links.DeepLink r23, int r24, com.avito.android.remote.model.SerpDisplayType r25, com.avito.android.serp.adapter.SerpViewType r26, int r27, t6.r.a.j r28) {
        /*
            r15 = this;
            r0 = r27
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_AUTO_CATALOG
            r1 = 15
            long r1 = (long) r1
            r4 = r1
            goto L_0x000f
        L_0x000d:
            r4 = r16
        L_0x000f:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0019
            java.lang.String r1 = java.lang.String.valueOf(r4)
            r6 = r1
            goto L_0x001b
        L_0x0019:
            r6 = r18
        L_0x001b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0023
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r13 = r1
            goto L_0x0025
        L_0x0023:
            r13 = r25
        L_0x0025:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x002d
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r14 = r0
            goto L_0x002f
        L_0x002d:
            r14 = r26
        L_0x002f:
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
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.auto_catalog.AdvertDetailsAutoCatalogItem.<init>(long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.avito.android.deep_linking.links.DeepLink, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}
