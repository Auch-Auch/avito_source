package com.avito.android.advert.item.contactbar;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.photo_gallery.LegacyPhotoGalleryActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.android.remote.model.advert_details.SellerOnlineStatus;
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
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B_\u0012\b\b\u0002\u00107\u001a\u000202\u0012\b\b\u0002\u0010=\u001a\u000208\u0012\u000e\b\u0002\u0010F\u001a\b\u0012\u0004\u0012\u00020?0>\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u00101\u001a\u00020\u0004\u0012\b\b\u0002\u0010-\u001a\u00020&\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001a¢\u0006\u0004\bG\u0010HJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001f\u001a\u00020\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u00101\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\rR\u001c\u00107\u001a\u0002028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001c\u0010=\u001a\u0002088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R(\u0010F\u001a\b\u0012\u0004\u0012\u00020?0>8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006I"}, d2 = {"Lcom/avito/android/advert/item/contactbar/AdvertDetailsContactBarItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "", "isNotContactAccess", "()Z", "isEmptyOfflineStatus", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/AdvertPrice;", "e", "Lcom/avito/android/remote/model/AdvertPrice;", "getAdvertPrice", "()Lcom/avito/android/remote/model/AdvertPrice;", "advertPrice", "Lcom/avito/android/serp/adapter/SerpViewType;", "h", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "d", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "getContactBarData", "()Lcom/avito/android/remote/model/advert_details/ContactBarData;", LegacyPhotoGalleryActivityKt.LEGACY_PHOTO_GALLERY_KEY_CONTACT_DATA, "Lcom/avito/android/remote/model/SerpDisplayType;", g.a, "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "f", "I", "getSpanCount", "spanCount", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "c", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "actions", "<init>", "(JLjava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/advert_details/ContactBarData;Lcom/avito/android/remote/model/AdvertPrice;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsContactBarItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<AdvertDetailsContactBarItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public List<ContactBar.Action> c;
    @Nullable
    public final ContactBarData d;
    @Nullable
    public final AdvertPrice e;
    public final int f;
    @NotNull
    public SerpDisplayType g;
    @NotNull
    public final SerpViewType h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsContactBarItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsContactBarItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((ContactBar.Action) parcel.readParcelable(AdvertDetailsContactBarItem.class.getClassLoader()));
                readInt--;
            }
            return new AdvertDetailsContactBarItem(readLong, readString, arrayList, (ContactBarData) parcel.readParcelable(AdvertDetailsContactBarItem.class.getClassLoader()), (AdvertPrice) parcel.readParcelable(AdvertDetailsContactBarItem.class.getClassLoader()), parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsContactBarItem[] newArray(int i) {
            return new AdvertDetailsContactBarItem[i];
        }
    }

    public AdvertDetailsContactBarItem(long j, @NotNull String str, @NotNull List<ContactBar.Action> list, @Nullable ContactBarData contactBarData, @Nullable AdvertPrice advertPrice, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(list, "actions");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j;
        this.b = str;
        this.c = list;
        this.d = contactBarData;
        this.e = advertPrice;
        this.f = i;
        this.g = serpDisplayType;
        this.h = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return new AdvertDetailsContactBarItem(getId(), getStringId(), this.c, this.d, this.e, i, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<ContactBar.Action> getActions() {
        return this.c;
    }

    @Nullable
    public final AdvertPrice getAdvertPrice() {
        return this.e;
    }

    @Nullable
    public final ContactBarData getContactBarData() {
        return this.d;
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

    public final boolean isEmptyOfflineStatus() {
        SellerOnlineStatus onlineStatus;
        ContactBarData contactBarData = this.d;
        if (contactBarData == null || (onlineStatus = contactBarData.getOnlineStatus()) == null) {
            return true;
        }
        if (!onlineStatus.isOnline()) {
            String replySpeed = onlineStatus.getReplySpeed();
            if (replySpeed == null || replySpeed.length() == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean isNotContactAccess() {
        boolean z = false;
        if (this.c.size() == 1 && this.c.get(0).getType() == ContactBar.ActionType.ACCESS) {
            z = true;
        }
        return !z;
    }

    public final void setActions(@NotNull List<ContactBar.Action> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.c = list;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.g = serpDisplayType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        Iterator n0 = a.n0(this.c, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((ContactBar.Action) n0.next(), i);
        }
        parcel.writeParcelable(this.d, i);
        parcel.writeParcelable(this.e, i);
        parcel.writeInt(this.f);
        parcel.writeString(this.g.name());
        parcel.writeString(this.h.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsContactBarItem(long r14, java.lang.String r16, java.util.List r17, com.avito.android.remote.model.advert_details.ContactBarData r18, com.avito.android.remote.model.AdvertPrice r19, int r20, com.avito.android.remote.model.SerpDisplayType r21, com.avito.android.serp.adapter.SerpViewType r22, int r23, t6.r.a.j r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_CONTACT_BAR
            r1 = 30
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
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0024
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r7 = r1
            goto L_0x0026
        L_0x0024:
            r7 = r17
        L_0x0026:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x002d
            r8 = r2
            goto L_0x002f
        L_0x002d:
            r8 = r18
        L_0x002f:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0035
            r9 = r2
            goto L_0x0037
        L_0x0035:
            r9 = r19
        L_0x0037:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x003f
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r11 = r1
            goto L_0x0041
        L_0x003f:
            r11 = r21
        L_0x0041:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0049
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r12 = r0
            goto L_0x004b
        L_0x0049:
            r12 = r22
        L_0x004b:
            r3 = r13
            r10 = r20
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.contactbar.AdvertDetailsContactBarItem.<init>(long, java.lang.String, java.util.List, com.avito.android.remote.model.advert_details.ContactBarData, com.avito.android.remote.model.AdvertPrice, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}
