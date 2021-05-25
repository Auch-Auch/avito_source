package com.avito.android.advert_core.advert_badge_bar;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.component.badge_bar.badge.BadgeItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.advert_badge_bar.BadgeBarOrientation;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003Bo\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u00104\u001a\u00020\u0013\u0012\f\u0010;\u001a\b\u0012\u0004\u0012\u00020605\u0012\u0006\u00101\u001a\u00020,\u0012\u0006\u0010C\u001a\u00020\u0004\u0012\u0006\u0010+\u001a\u00020\u0013\u0012\b\b\u0002\u0010>\u001a\u00020\b\u0012\u0006\u0010(\u001a\u00020\u0004\u0012\b\b\u0002\u0010K\u001a\u00020D\u0012\b\b\u0002\u0010$\u001a\u00020\u001f¢\u0006\u0004\bL\u0010MJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\u00020\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001e\u001a\u00020\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010$\u001a\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010(\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\fR\u0019\u0010+\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0015\u001a\u0004\b*\u0010\u0017R\u0019\u00101\u001a\u00020,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0019\u00104\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0015\u001a\u0004\b3\u0010\u0017R\u001f\u0010;\u001a\b\u0012\u0004\u0012\u000206058\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\"\u0010>\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\n\"\u0004\b?\u0010@R\u0019\u0010C\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010&\u001a\u0004\bB\u0010\fR\"\u0010K\u001a\u00020D8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "", "isVertical", "()Z", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "Lcom/avito/android/serp/adapter/SerpViewType;", "k", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "i", "I", "getSpanCount", "spanCount", g.a, "getShowMoreTitle", "showMoreTitle", "Lcom/avito/android/remote/model/advert_badge_bar/BadgeBarOrientation;", "e", "Lcom/avito/android/remote/model/advert_badge_bar/BadgeBarOrientation;", "getOrientation", "()Lcom/avito/android/remote/model/advert_badge_bar/BadgeBarOrientation;", "orientation", "c", "getAdvertId", BookingInfoActivity.EXTRA_ITEM_ID, "", "Lcom/avito/android/component/badge_bar/badge/BadgeItem;", "d", "Ljava/util/List;", "getBadges", "()Ljava/util/List;", "badges", "h", "Z", "isExpanded", "setExpanded", "(Z)V", "f", "getPreloadCount", "preloadCount", "Lcom/avito/android/remote/model/SerpDisplayType;", "j", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/advert_badge_bar/BadgeBarOrientation;ILjava/lang/String;ZILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertBadgeBarItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<AdvertBadgeBarItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final List<BadgeItem> d;
    @NotNull
    public final BadgeBarOrientation e;
    public final int f;
    @NotNull
    public final String g;
    public boolean h;
    public final int i;
    @NotNull
    public SerpDisplayType j;
    @NotNull
    public final SerpViewType k;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertBadgeBarItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertBadgeBarItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((BadgeItem) parcel.readParcelable(AdvertBadgeBarItem.class.getClassLoader()));
                readInt--;
            }
            return new AdvertBadgeBarItem(readLong, readString, readString2, arrayList, (BadgeBarOrientation) Enum.valueOf(BadgeBarOrientation.class, parcel.readString()), parcel.readInt(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertBadgeBarItem[] newArray(int i) {
            return new AdvertBadgeBarItem[i];
        }
    }

    public AdvertBadgeBarItem(long j2, @NotNull String str, @NotNull String str2, @NotNull List<BadgeItem> list, @NotNull BadgeBarOrientation badgeBarOrientation, int i2, @NotNull String str3, boolean z, int i3, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(list, "badges");
        Intrinsics.checkNotNullParameter(badgeBarOrientation, "orientation");
        Intrinsics.checkNotNullParameter(str3, "showMoreTitle");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j2;
        this.b = str;
        this.c = str2;
        this.d = list;
        this.e = badgeBarOrientation;
        this.f = i2;
        this.g = str3;
        this.h = z;
        this.i = i3;
        this.j = serpDisplayType;
        this.k = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i2) {
        return new AdvertBadgeBarItem(getId(), getStringId(), this.c, this.d, this.e, this.f, this.g, this.h, i2, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getAdvertId() {
        return this.c;
    }

    @NotNull
    public final List<BadgeItem> getBadges() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.j;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final BadgeBarOrientation getOrientation() {
        return this.e;
    }

    public final int getPreloadCount() {
        return this.f;
    }

    @NotNull
    public final String getShowMoreTitle() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.i;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.k;
    }

    public final boolean isExpanded() {
        return this.h;
    }

    public final boolean isVertical() {
        return this.e == BadgeBarOrientation.VERTICAL;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.j = serpDisplayType;
    }

    public final void setExpanded(boolean z) {
        this.h = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        Iterator n0 = a.n0(this.d, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((BadgeItem) n0.next(), i2);
        }
        parcel.writeString(this.e.name());
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i);
        parcel.writeString(this.j.name());
        parcel.writeString(this.k.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertBadgeBarItem(long r17, java.lang.String r19, java.lang.String r20, java.util.List r21, com.avito.android.remote.model.advert_badge_bar.BadgeBarOrientation r22, int r23, java.lang.String r24, boolean r25, int r26, com.avito.android.remote.model.SerpDisplayType r27, com.avito.android.serp.adapter.SerpViewType r28, int r29, t6.r.a.j r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_BADGE_BAR
            r1 = 66
            long r1 = (long) r1
            r4 = r1
            goto L_0x000f
        L_0x000d:
            r4 = r17
        L_0x000f:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0019
            java.lang.String r1 = java.lang.String.valueOf(r4)
            r6 = r1
            goto L_0x001b
        L_0x0019:
            r6 = r19
        L_0x001b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0022
            r1 = 0
            r12 = 0
            goto L_0x0024
        L_0x0022:
            r12 = r25
        L_0x0024:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x002c
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r14 = r1
            goto L_0x002e
        L_0x002c:
            r14 = r27
        L_0x002e:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0036
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r15 = r0
            goto L_0x0038
        L_0x0036:
            r15 = r28
        L_0x0038:
            r3 = r16
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r13 = r26
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarItem.<init>(long, java.lang.String, java.lang.String, java.util.List, com.avito.android.remote.model.advert_badge_bar.BadgeBarOrientation, int, java.lang.String, boolean, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}
