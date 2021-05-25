package com.avito.android.advert.item.safe_show;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.photo_gallery.LegacyPhotoGalleryActivityKt;
import com.avito.android.remote.auth.AuthSource;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 L2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001LB{\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0018\u0012\b\b\u0002\u0010,\u001a\u00020\u001e\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010B\u001a\u00020=\u0012\u0006\u0010F\u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010<\u001a\u00020\u001e\u0012\u0006\u0010I\u001a\u00020\u001e\u0012\u0006\u0010&\u001a\u00020\u001e\u0012\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020.0-\u0012\b\u00109\u001a\u0004\u0018\u000104\u0012\b\u0010)\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\bJ\u0010KJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00108\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001d\u001a\u00020\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010#\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010&\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R\u001b\u0010)\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\"R\u001c\u0010,\u001a\u00020\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010 \u001a\u0004\b+\u0010\"R\u001f\u00103\u001a\b\u0012\u0004\u0012\u00020.0-8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00109\u001a\u0004\u0018\u0001048\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0019\u0010<\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010 \u001a\u0004\b;\u0010\"R\u001c\u0010B\u001a\u00020=8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001c\u0010F\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u000fR\u0019\u0010I\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010 \u001a\u0004\bH\u0010\"¨\u0006M"}, d2 = {"Lcom/avito/android/advert/item/safe_show/SafeShowItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/SerpDisplayType;", "c", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "", "f", "Ljava/lang/String;", "getAdvertId", "()Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "i", "getBottomSheetTitle", "bottomSheetTitle", "l", "getContactBtnText", "contactBtnText", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "j", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "actions", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "k", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "getContactBarData", "()Lcom/avito/android/remote/model/advert_details/ContactBarData;", LegacyPhotoGalleryActivityKt.LEGACY_PHOTO_GALLERY_KEY_CONTACT_DATA, g.a, "getTeaserTitle", "teaserTitle", "Lcom/avito/android/serp/adapter/SerpViewType;", "d", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "e", "I", "getSpanCount", "spanCount", "h", "getBottomSheetText", "bottomSheetText", "<init>", "(JLjava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/advert_details/ContactBarData;Ljava/lang/String;)V", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SafeShowItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SafeShowItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public SerpDisplayType c;
    @NotNull
    public final SerpViewType d;
    public final int e;
    @NotNull
    public final String f;
    @NotNull
    public final String g;
    @NotNull
    public final String h;
    @NotNull
    public final String i;
    @NotNull
    public final List<ContactBar.Action> j;
    @Nullable
    public final ContactBarData k;
    @Nullable
    public final String l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/item/safe_show/SafeShowItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/advert/item/safe_show/SafeShowItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, SafeShowItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SafeShowItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            long readLong = parcel2.readLong();
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            int readInt = parcel2.readInt();
            SerpDisplayType serpDisplayType = (SerpDisplayType) ParcelsKt.readEnum(parcel2, SerpDisplayType.values());
            SerpViewType serpViewType = (SerpViewType) ParcelsKt.readEnum(parcel2, SerpViewType.values());
            String u22 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String u23 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String u24 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            List createParcelableList = ParcelsKt.createParcelableList(parcel2, ContactBar.Action.class);
            if (createParcelableList == null) {
                createParcelableList = CollectionsKt__CollectionsKt.emptyList();
            }
            return new SafeShowItem(readLong, u2, serpDisplayType, serpViewType, readInt, a2.b.a.a.a.u2(parcel2, "readString()!!"), u22, u24, u23, createParcelableList, (ContactBarData) parcel2.readParcelable(ContactBarData.class.getClassLoader()), parcel2.readString());
        }
    }

    public SafeShowItem(long j2, @NotNull String str, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType, int i2, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull List<ContactBar.Action> list, @Nullable ContactBarData contactBarData, @Nullable String str6) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str3, "teaserTitle");
        Intrinsics.checkNotNullParameter(str4, "bottomSheetText");
        Intrinsics.checkNotNullParameter(str5, "bottomSheetTitle");
        Intrinsics.checkNotNullParameter(list, "actions");
        this.a = j2;
        this.b = str;
        this.c = serpDisplayType;
        this.d = serpViewType;
        this.e = i2;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = str5;
        this.j = list;
        this.k = contactBarData;
        this.l = str6;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i2) {
        return new SafeShowItem(getId(), getStringId(), getDisplayType(), getViewType(), i2, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<ContactBar.Action> getActions() {
        return this.j;
    }

    @NotNull
    public final String getAdvertId() {
        return this.f;
    }

    @NotNull
    public final String getBottomSheetText() {
        return this.h;
    }

    @NotNull
    public final String getBottomSheetTitle() {
        return this.i;
    }

    @Nullable
    public final ContactBarData getContactBarData() {
        return this.k;
    }

    @Nullable
    public final String getContactBtnText() {
        return this.l;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @NotNull
    public final String getTeaserTitle() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.c = serpDisplayType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(getId());
        parcel.writeString(getStringId());
        parcel.writeInt(getSpanCount());
        ParcelsKt.writeEnum(parcel, getDisplayType());
        ParcelsKt.writeEnum(parcel, getViewType());
        parcel.writeString(this.g);
        parcel.writeString(this.i);
        parcel.writeString(this.h);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.j, 0, 2, null);
        parcel.writeString(this.f);
        parcel.writeParcelable(this.k, i2);
        parcel.writeString(this.l);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SafeShowItem(long r18, java.lang.String r20, com.avito.android.remote.model.SerpDisplayType r21, com.avito.android.serp.adapter.SerpViewType r22, int r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.util.List r28, com.avito.android.remote.model.advert_details.ContactBarData r29, java.lang.String r30, int r31, t6.r.a.j r32) {
        /*
            r17 = this;
            r0 = r31
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_SHOW_ONLINE
            r1 = 43
            long r1 = (long) r1
            r4 = r1
            goto L_0x000f
        L_0x000d:
            r4 = r18
        L_0x000f:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0019
            java.lang.String r1 = java.lang.String.valueOf(r4)
            r6 = r1
            goto L_0x001b
        L_0x0019:
            r6 = r20
        L_0x001b:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0023
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r7 = r1
            goto L_0x0025
        L_0x0023:
            r7 = r21
        L_0x0025:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x002d
            com.avito.android.serp.adapter.SerpViewType r1 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r8 = r1
            goto L_0x002f
        L_0x002d:
            r8 = r22
        L_0x002f:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0039
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r14 = r0
            goto L_0x003b
        L_0x0039:
            r14 = r28
        L_0x003b:
            r3 = r17
            r9 = r23
            r10 = r24
            r11 = r25
            r12 = r26
            r13 = r27
            r15 = r29
            r16 = r30
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.safe_show.SafeShowItem.<init>(long, java.lang.String, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, com.avito.android.remote.model.advert_details.ContactBarData, java.lang.String, int, t6.r.a.j):void");
    }
}
