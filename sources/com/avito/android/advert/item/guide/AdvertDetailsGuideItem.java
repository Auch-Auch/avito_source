package com.avito.android.advert.item.guide;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.guide.GuideLink;
import com.avito.android.remote.model.guide.GuideSection;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 K2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001KBk\u0012\b\b\u0002\u0010'\u001a\u00020\"\u0012\b\b\u0002\u0010H\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\b\u0010E\u001a\u0004\u0018\u00010\u001c\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020)0(\u0012\b\u00104\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u0010B\u001a\u00020;\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010:\u001a\u000205¢\u0006\u0004\bI\u0010JJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00108\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u0019\u0010!\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010'\u001a\u00020\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020)0(8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00104\u001a\u0004\u0018\u00010/8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001c\u0010:\u001a\u0002058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\"\u0010B\u001a\u00020;8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001b\u0010E\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010\u001e\u001a\u0004\bD\u0010 R\u001c\u0010H\u001a\u00020\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bF\u0010\u001e\u001a\u0004\bG\u0010 ¨\u0006L"}, d2 = {"Lcom/avito/android/advert/item/guide/AdvertDetailsGuideItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/SerpDisplayType;", "i", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "h", "I", "getSpanCount", "spanCount", "", "c", "Ljava/lang/String;", "getIid", "()Ljava/lang/String;", "iid", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "", "Lcom/avito/android/remote/model/guide/GuideSection;", "e", "Ljava/util/List;", "getSections", "()Ljava/util/List;", "sections", "Lcom/avito/android/remote/model/guide/GuideLink;", "f", "Lcom/avito/android/remote/model/guide/GuideLink;", "getLink", "()Lcom/avito/android/remote/model/guide/GuideLink;", "link", "Lcom/avito/android/serp/adapter/SerpViewType;", "j", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "", g.a, "Z", "getShowTopDivider", "()Z", "setShowTopDivider", "(Z)V", "showTopDivider", "d", "getTitle", "title", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/guide/GuideLink;ZILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsGuideItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertDetailsGuideItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    @NotNull
    public final List<GuideSection> e;
    @Nullable
    public final GuideLink f;
    public boolean g;
    public final int h;
    @NotNull
    public SerpDisplayType i;
    @NotNull
    public final SerpViewType j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/item/guide/AdvertDetailsGuideItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuideItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AdvertDetailsGuideItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AdvertDetailsGuideItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            long readLong = parcel2.readLong();
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String u22 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String readString = parcel2.readString();
            Intrinsics.checkNotNull(readString);
            List createParcelableList = ParcelsKt.createParcelableList(parcel2, GuideSection.class);
            if (createParcelableList == null) {
                createParcelableList = CollectionsKt__CollectionsKt.emptyList();
            }
            return new AdvertDetailsGuideItem(readLong, u2, u22, readString, createParcelableList, (GuideLink) a2.b.a.a.a.z1(GuideLink.class, parcel2), ParcelsKt.readBool(parcel2), parcel2.readInt(), (SerpDisplayType) ParcelsKt.readEnum(parcel2, SerpDisplayType.values()), (SerpViewType) ParcelsKt.readEnum(parcel2, SerpViewType.values()));
        }
    }

    public AdvertDetailsGuideItem(long j2, @NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull List<GuideSection> list, @Nullable GuideLink guideLink, boolean z, int i2, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "iid");
        Intrinsics.checkNotNullParameter(list, "sections");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j2;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = list;
        this.f = guideLink;
        this.g = z;
        this.h = i2;
        this.i = serpDisplayType;
        this.j = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i2) {
        return new AdvertDetailsGuideItem(getId(), getStringId(), this.c, this.d, this.e, this.f, this.g, i2, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    @NotNull
    public final String getIid() {
        return this.c;
    }

    @Nullable
    public final GuideLink getLink() {
        return this.f;
    }

    @NotNull
    public final List<GuideSection> getSections() {
        return this.e;
    }

    public final boolean getShowTopDivider() {
        return this.g;
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

    @Nullable
    public final String getTitle() {
        return this.d;
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

    public final void setShowTopDivider(boolean z) {
        this.g = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(getId());
        parcel.writeString(getStringId());
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.e, i2);
        parcel.writeParcelable(this.f, i2);
        ParcelsKt.writeBool(parcel, this.g);
        parcel.writeInt(getSpanCount());
        ParcelsKt.writeEnum(parcel, getDisplayType());
        ParcelsKt.writeEnum(parcel, getViewType());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsGuideItem(long r16, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.util.List r21, com.avito.android.remote.model.guide.GuideLink r22, boolean r23, int r24, com.avito.android.remote.model.SerpDisplayType r25, com.avito.android.serp.adapter.SerpViewType r26, int r27, t6.r.a.j r28) {
        /*
            r15 = this;
            r0 = r27
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_GUIDE
            r1 = 44
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
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0022
            r1 = 1
            r11 = 1
            goto L_0x0024
        L_0x0022:
            r11 = r23
        L_0x0024:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x002c
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r13 = r1
            goto L_0x002e
        L_0x002c:
            r13 = r25
        L_0x002e:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0036
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r14 = r0
            goto L_0x0038
        L_0x0036:
            r14 = r26
        L_0x0038:
            r3 = r15
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r12 = r24
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.guide.AdvertDetailsGuideItem.<init>(long, java.lang.String, java.lang.String, java.lang.String, java.util.List, com.avito.android.remote.model.guide.GuideLink, boolean, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}
