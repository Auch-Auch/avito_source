package com.avito.android.advert.item.price_discount;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.photo_gallery.LegacyPhotoGalleryActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertDiscounts;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.advert_details.ContactBarData;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 O2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001OBw\u0012\b\b\u0002\u00107\u001a\u000202\u0012\b\b\u0002\u0010@\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0010\u0012\b\u0010L\u001a\u0004\u0018\u00010G\u0012\u0006\u0010&\u001a\u00020!\u0012\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020(0'\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u000108\u0012\u0006\u00101\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0016\u0012\b\b\u0002\u0010F\u001a\u00020A¢\u0006\u0004\bM\u0010NJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014R\u0019\u0010&\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001f\u0010-\u001a\b\u0012\u0004\u0012\u00020(0'8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001c\u00101\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u000fR\u001c\u00107\u001a\u0002028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u0010=\u001a\u0004\u0018\u0001088\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001c\u0010@\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b>\u0010\u0012\u001a\u0004\b?\u0010\u0014R\u001c\u0010F\u001a\u00020A8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001b\u0010L\u001a\u0004\u0018\u00010G8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K¨\u0006P"}, d2 = {"Lcom/avito/android/advert/item/price_discount/PriceWithDiscountItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "c", "Ljava/lang/String;", "getPrice", "()Ljava/lang/String;", "price", "Lcom/avito/android/remote/model/SerpDisplayType;", "j", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "d", "getPriceWithoutDiscount", "priceWithoutDiscount", "", "f", "Z", "getClosedAdvert", "()Z", "closedAdvert", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", g.a, "Ljava/util/List;", "getActions", "()Ljava/util/List;", "actions", "i", "I", "getSpanCount", "spanCount", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "h", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "getContactBarData", "()Lcom/avito/android/remote/model/advert_details/ContactBarData;", LegacyPhotoGalleryActivityKt.LEGACY_PHOTO_GALLERY_KEY_CONTACT_DATA, AuthSource.BOOKING_ORDER, "getStringId", "stringId", "Lcom/avito/android/serp/adapter/SerpViewType;", "k", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "Lcom/avito/android/remote/model/AdvertDiscounts;", "e", "Lcom/avito/android/remote/model/AdvertDiscounts;", "getDiscounts", "()Lcom/avito/android/remote/model/AdvertDiscounts;", "discounts", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/AdvertDiscounts;ZLjava/util/List;Lcom/avito/android/remote/model/advert_details/ContactBarData;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class PriceWithDiscountItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<PriceWithDiscountItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final AdvertDiscounts e;
    public final boolean f;
    @NotNull
    public final List<ContactBar.Action> g;
    @Nullable
    public final ContactBarData h;
    public final int i;
    @NotNull
    public SerpDisplayType j;
    @NotNull
    public final SerpViewType k;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/item/price_discount/PriceWithDiscountItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/advert/item/price_discount/PriceWithDiscountItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, PriceWithDiscountItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PriceWithDiscountItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            long readLong = parcel2.readLong();
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String u22 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String readString = parcel2.readString();
            AdvertDiscounts advertDiscounts = (AdvertDiscounts) parcel2.readParcelable(AdvertDiscounts.class.getClassLoader());
            boolean readBool = ParcelsKt.readBool(parcel2);
            List createParcelableList = ParcelsKt.createParcelableList(parcel2, ContactBar.Action.class);
            if (createParcelableList == null) {
                createParcelableList = CollectionsKt__CollectionsKt.emptyList();
            }
            return new PriceWithDiscountItem(readLong, u2, u22, readString, advertDiscounts, readBool, createParcelableList, (ContactBarData) parcel2.readParcelable(ContactBarData.class.getClassLoader()), parcel2.readInt(), (SerpDisplayType) ParcelsKt.readEnum(parcel2, SerpDisplayType.values()), (SerpViewType) ParcelsKt.readEnum(parcel2, SerpViewType.values()));
        }
    }

    public PriceWithDiscountItem(long j2, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable AdvertDiscounts advertDiscounts, boolean z, @NotNull List<ContactBar.Action> list, @Nullable ContactBarData contactBarData, int i2, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "price");
        Intrinsics.checkNotNullParameter(list, "actions");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j2;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = advertDiscounts;
        this.f = z;
        this.g = list;
        this.h = contactBarData;
        this.i = i2;
        this.j = serpDisplayType;
        this.k = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i2) {
        return new PriceWithDiscountItem(getId(), getStringId(), this.c, this.d, this.e, this.f, this.g, this.h, i2, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<ContactBar.Action> getActions() {
        return this.g;
    }

    public final boolean getClosedAdvert() {
        return this.f;
    }

    @Nullable
    public final ContactBarData getContactBarData() {
        return this.h;
    }

    @Nullable
    public final AdvertDiscounts getDiscounts() {
        return this.e;
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
    public final String getPrice() {
        return this.c;
    }

    @Nullable
    public final String getPriceWithoutDiscount() {
        return this.d;
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

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.j = serpDisplayType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(getId());
        parcel.writeString(getStringId());
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeParcelable(this.e, i2);
        ParcelsKt.writeBool(parcel, this.f);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.g, i2);
        parcel.writeParcelable(this.h, i2);
        parcel.writeInt(getSpanCount());
        ParcelsKt.writeEnum(parcel, getDisplayType());
        ParcelsKt.writeEnum(parcel, getViewType());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PriceWithDiscountItem(long r17, java.lang.String r19, java.lang.String r20, java.lang.String r21, com.avito.android.remote.model.AdvertDiscounts r22, boolean r23, java.util.List r24, com.avito.android.remote.model.advert_details.ContactBarData r25, int r26, com.avito.android.remote.model.SerpDisplayType r27, com.avito.android.serp.adapter.SerpViewType r28, int r29, t6.r.a.j r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_PRICE_WITH_DISCOUNT
            r1 = 50
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
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0025
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r11 = r1
            goto L_0x0027
        L_0x0025:
            r11 = r24
        L_0x0027:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x002e
            r1 = 0
            r12 = r1
            goto L_0x0030
        L_0x002e:
            r12 = r25
        L_0x0030:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0038
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r14 = r1
            goto L_0x003a
        L_0x0038:
            r14 = r27
        L_0x003a:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0042
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r15 = r0
            goto L_0x0044
        L_0x0042:
            r15 = r28
        L_0x0044:
            r3 = r16
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r13 = r26
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.price_discount.PriceWithDiscountItem.<init>(long, java.lang.String, java.lang.String, java.lang.String, com.avito.android.remote.model.AdvertDiscounts, boolean, java.util.List, com.avito.android.remote.model.advert_details.ContactBarData, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}
