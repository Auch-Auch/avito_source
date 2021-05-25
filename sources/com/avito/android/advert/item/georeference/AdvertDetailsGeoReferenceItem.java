package com.avito.android.advert.item.georeference;

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
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001HBa\u0012\b\b\u0002\u0010?\u001a\u00020:\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0016\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0016\u0012\b\u00103\u001a\u0004\u0018\u00010\u0016\u0012\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u000104\u0012\u0006\u0010E\u001a\u00020\u0016\u0012\b\u0010-\u001a\u0004\u0018\u00010(\u0012\u0006\u00100\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\bF\u0010GJ\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u000fR\"\u0010'\u001a\u00020 8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010-\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u00100\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0018\u001a\u0004\b/\u0010\u001aR\u001b\u00103\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0018\u001a\u0004\b2\u0010\u001aR!\u00109\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001048\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001c\u0010?\u001a\u00020:8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001b\u0010B\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\u0018\u001a\u0004\bA\u0010\u001aR\u0019\u0010E\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010\u0018\u001a\u0004\bD\u0010\u001a¨\u0006I"}, d2 = {"Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceItem;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/serp/adapter/SerpViewType;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "", "d", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "k", "I", "getSpanCount", "spanCount", "Lcom/avito/android/remote/model/SerpDisplayType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "Lcom/avito/android/remote/model/Coordinates;", "i", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "()Lcom/avito/android/remote/model/Coordinates;", "coordinates", "j", "getAdvertTitle", "advertTitle", "f", "getAfter", "after", "", g.a, "Ljava/util/List;", "getColors", "()Ljava/util/List;", "colors", "", "c", "J", "getId", "()J", "id", "e", "getContent", "content", "h", "getAddress", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;I)V", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsGeoReferenceItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertDetailsGeoReferenceItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public SerpDisplayType a;
    @NotNull
    public final SerpViewType b;
    public final long c;
    @NotNull
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final List<String> g;
    @NotNull
    public final String h;
    @Nullable
    public final Coordinates i;
    @NotNull
    public final String j;
    public final int k;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AdvertDetailsGeoReferenceItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AdvertDetailsGeoReferenceItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new AdvertDetailsGeoReferenceItem(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readString(), parcel2.readString(), parcel2.createStringArrayList(), a2.b.a.a.a.u2(parcel2, "readString()!!"), (Coordinates) parcel2.readParcelable(Coordinates.class.getClassLoader()), a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readInt());
        }
    }

    public AdvertDetailsGeoReferenceItem(long j2, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable List<String> list, @NotNull String str4, @Nullable Coordinates coordinates, @NotNull String str5, int i2) {
        a2.b.a.a.a.Z0(str, "stringId", str4, IntegrityManager.INTEGRITY_TYPE_ADDRESS, str5, "advertTitle");
        this.c = j2;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = list;
        this.h = str4;
        this.i = coordinates;
        this.j = str5;
        this.k = i2;
        this.a = SerpDisplayType.Grid;
        this.b = SerpViewType.SINGLE;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getAddress() {
        return this.h;
    }

    @NotNull
    public final String getAdvertTitle() {
        return this.j;
    }

    @Nullable
    public final String getAfter() {
        return this.f;
    }

    @Nullable
    public final List<String> getColors() {
        return this.g;
    }

    @Nullable
    public final String getContent() {
        return this.e;
    }

    @Nullable
    public final Coordinates getCoordinates() {
        return this.i;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.a;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.k;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.a = serpDisplayType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(getId());
        parcel.writeString(getStringId());
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeStringList(this.g);
        parcel.writeString(this.h);
        parcel.writeParcelable(this.i, i2);
        parcel.writeString(this.j);
        parcel.writeInt(getSpanCount());
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public AdvertDetailsGeoReferenceItem copyWithSpanCount(int i2) {
        return new AdvertDetailsGeoReferenceItem(getId(), getStringId(), this.e, this.f, this.g, this.h, this.i, this.j, i2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsGeoReferenceItem(long r14, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.util.List r19, java.lang.String r20, com.avito.android.remote.model.Coordinates r21, java.lang.String r22, int r23, int r24, t6.r.a.j r25) {
        /*
            r13 = this;
            r0 = r24 & 1
            if (r0 == 0) goto L_0x000b
            com.avito.android.advert_core.advert.AdvertDetailsItem r0 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_GEO_REFERENCE
            r0 = 35
            long r0 = (long) r0
            r3 = r0
            goto L_0x000c
        L_0x000b:
            r3 = r14
        L_0x000c:
            r0 = r24 & 2
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = java.lang.String.valueOf(r3)
            r5 = r0
            goto L_0x0018
        L_0x0016:
            r5 = r16
        L_0x0018:
            r2 = r13
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r23
            r2.<init>(r3, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.georeference.AdvertDetailsGeoReferenceItem.<init>(long, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, com.avito.android.remote.model.Coordinates, java.lang.String, int, int, t6.r.a.j):void");
    }
}
