package com.avito.android.advert.item.verification;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.component.badge_bar.badge.BadgeItem;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\b\b\u0018\u0000 M2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001MBO\u0012\b\b\u0002\u0010\"\u001a\u00020\u0010\u0012\b\b\u0002\u0010#\u001a\u00020\u0013\u0012\u0006\u0010$\u001a\u00020\u0013\u0012\u0006\u0010%\u001a\u00020\u0013\u0012\u0006\u0010&\u001a\u00020\u0018\u0012\u0006\u0010'\u001a\u00020\u0004\u0012\b\b\u0002\u0010(\u001a\u00020\u001c\u0012\b\b\u0002\u0010)\u001a\u00020\u001f¢\u0006\u0004\bK\u0010LJ\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0015J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u000fJ\u0010\u0010\u001d\u001a\u00020\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÆ\u0003¢\u0006\u0004\b \u0010!J`\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\u00102\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010$\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020\u00132\b\b\u0002\u0010&\u001a\u00020\u00182\b\b\u0002\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u001c2\b\b\u0002\u0010)\u001a\u00020\u001fHÆ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b,\u0010\u0015J\u0010\u0010-\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b-\u0010\u000fJ\u001a\u00101\u001a\u0002002\b\u0010/\u001a\u0004\u0018\u00010.HÖ\u0003¢\u0006\u0004\b1\u00102R\u001c\u0010\"\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0012R\u0019\u0010%\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u0015R\u001c\u0010)\u001a\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010!R\u0019\u0010&\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\u001aR\u001c\u0010'\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\u000fR\"\u0010(\u001a\u00020\u001c8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010\u001e\"\u0004\bE\u0010FR\u001c\u0010#\u001a\u00020\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bG\u00107\u001a\u0004\bH\u0010\u0015R\u0019\u0010$\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\bI\u00107\u001a\u0004\bJ\u0010\u0015¨\u0006N"}, d2 = {"Lcom/avito/android/advert/item/verification/AdvertVerificationItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert/item/verification/AdvertVerificationItem;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "component4", "Lcom/avito/android/component/badge_bar/badge/BadgeItem;", "component5", "()Lcom/avito/android/component/badge_bar/badge/BadgeItem;", "component6", "Lcom/avito/android/remote/model/SerpDisplayType;", "component7", "()Lcom/avito/android/remote/model/SerpDisplayType;", "Lcom/avito/android/serp/adapter/SerpViewType;", "component8", "()Lcom/avito/android/serp/adapter/SerpViewType;", "id", "stringId", "descriptionTitle", "description", "badgeItem", "spanCount", "displayType", "viewType", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/component/badge_bar/badge/BadgeItem;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)Lcom/avito/android/advert/item/verification/AdvertVerificationItem;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "J", "getId", "d", "Ljava/lang/String;", "getDescription", "h", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "e", "Lcom/avito/android/component/badge_bar/badge/BadgeItem;", "getBadgeItem", "f", "I", "getSpanCount", g.a, "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", AuthSource.BOOKING_ORDER, "getStringId", "c", "getDescriptionTitle", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/component/badge_bar/badge/BadgeItem;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertVerificationItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertVerificationItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final BadgeItem e;
    public final int f;
    @NotNull
    public SerpDisplayType g;
    @NotNull
    public final SerpViewType h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/item/verification/AdvertVerificationItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/advert/item/verification/AdvertVerificationItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AdvertVerificationItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AdvertVerificationItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new AdvertVerificationItem(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), (BadgeItem) a2.b.a.a.a.z1(BadgeItem.class, parcel2), parcel2.readInt(), (SerpDisplayType) ParcelsKt.readEnum(parcel2, SerpDisplayType.values()), (SerpViewType) ParcelsKt.readEnum(parcel2, SerpViewType.values()));
        }
    }

    public AdvertVerificationItem(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull BadgeItem badgeItem, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "descriptionTitle");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(badgeItem, "badgeItem");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = badgeItem;
        this.f = i;
        this.g = serpDisplayType;
        this.h = serpViewType;
    }

    public static /* synthetic */ AdvertVerificationItem copy$default(AdvertVerificationItem advertVerificationItem, long j, String str, String str2, String str3, BadgeItem badgeItem, int i, SerpDisplayType serpDisplayType, SerpViewType serpViewType, int i2, Object obj) {
        return advertVerificationItem.copy((i2 & 1) != 0 ? advertVerificationItem.getId() : j, (i2 & 2) != 0 ? advertVerificationItem.getStringId() : str, (i2 & 4) != 0 ? advertVerificationItem.c : str2, (i2 & 8) != 0 ? advertVerificationItem.d : str3, (i2 & 16) != 0 ? advertVerificationItem.e : badgeItem, (i2 & 32) != 0 ? advertVerificationItem.getSpanCount() : i, (i2 & 64) != 0 ? advertVerificationItem.getDisplayType() : serpDisplayType, (i2 & 128) != 0 ? advertVerificationItem.getViewType() : serpViewType);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final String component2() {
        return getStringId();
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final BadgeItem component5() {
        return this.e;
    }

    public final int component6() {
        return getSpanCount();
    }

    @NotNull
    public final SerpDisplayType component7() {
        return getDisplayType();
    }

    @NotNull
    public final SerpViewType component8() {
        return getViewType();
    }

    @NotNull
    public final AdvertVerificationItem copy(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull BadgeItem badgeItem, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "descriptionTitle");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(badgeItem, "badgeItem");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        return new AdvertVerificationItem(j, str, str2, str3, badgeItem, i, serpDisplayType, serpViewType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdvertVerificationItem)) {
            return false;
        }
        AdvertVerificationItem advertVerificationItem = (AdvertVerificationItem) obj;
        return getId() == advertVerificationItem.getId() && Intrinsics.areEqual(getStringId(), advertVerificationItem.getStringId()) && Intrinsics.areEqual(this.c, advertVerificationItem.c) && Intrinsics.areEqual(this.d, advertVerificationItem.d) && Intrinsics.areEqual(this.e, advertVerificationItem.e) && getSpanCount() == advertVerificationItem.getSpanCount() && Intrinsics.areEqual(getDisplayType(), advertVerificationItem.getDisplayType()) && Intrinsics.areEqual(getViewType(), advertVerificationItem.getViewType());
    }

    @NotNull
    public final BadgeItem getBadgeItem() {
        return this.e;
    }

    @NotNull
    public final String getDescription() {
        return this.d;
    }

    @NotNull
    public final String getDescriptionTitle() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.h;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int a3 = c.a(getId()) * 31;
        String stringId = getStringId();
        int i = 0;
        int hashCode = (a3 + (stringId != null ? stringId.hashCode() : 0)) * 31;
        String str = this.c;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        BadgeItem badgeItem = this.e;
        int spanCount = (getSpanCount() + ((hashCode3 + (badgeItem != null ? badgeItem.hashCode() : 0)) * 31)) * 31;
        SerpDisplayType displayType = getDisplayType();
        int hashCode4 = (spanCount + (displayType != null ? displayType.hashCode() : 0)) * 31;
        SerpViewType viewType = getViewType();
        if (viewType != null) {
            i = viewType.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.g = serpDisplayType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("AdvertVerificationItem(id=");
        L.append(getId());
        L.append(", stringId=");
        L.append(getStringId());
        L.append(", descriptionTitle=");
        L.append(this.c);
        L.append(", description=");
        L.append(this.d);
        L.append(", badgeItem=");
        L.append(this.e);
        L.append(", spanCount=");
        L.append(getSpanCount());
        L.append(", displayType=");
        L.append(getDisplayType());
        L.append(", viewType=");
        L.append(getViewType());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(getId());
        parcel.writeString(getStringId());
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeParcelable(this.e, i);
        parcel.writeInt(getSpanCount());
        ParcelsKt.writeEnum(parcel, getDisplayType());
        ParcelsKt.writeEnum(parcel, getViewType());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertVerificationItem(long r14, java.lang.String r16, java.lang.String r17, java.lang.String r18, com.avito.android.component.badge_bar.badge.BadgeItem r19, int r20, com.avito.android.remote.model.SerpDisplayType r21, com.avito.android.serp.adapter.SerpViewType r22, int r23, t6.r.a.j r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_ADVERT_VERIFICATION
            r1 = 45
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
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0022
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r11 = r1
            goto L_0x0024
        L_0x0022:
            r11 = r21
        L_0x0024:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x002c
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r12 = r0
            goto L_0x002e
        L_0x002c:
            r12 = r22
        L_0x002e:
            r3 = r13
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.verification.AdvertVerificationItem.<init>(long, java.lang.String, java.lang.String, java.lang.String, com.avito.android.component.badge_bar.badge.BadgeItem, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public AdvertVerificationItem copyWithSpanCount(int i) {
        return copy$default(this, 0, null, null, null, null, i, null, null, 223, null);
    }
}
