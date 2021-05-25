package com.avito.android.extended_profile.adapter.contact_bar;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.extended_profile.adapter.ExtendedProfileListItem;
import com.avito.android.extended_profile.adapter.ExtendedProfileSpanLookup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.advert_details.SellerOnlineStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJH\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b \u0010\u001aJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0004R\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u000bR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010\u0004R\u001c\u0010\u0011\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u000f¨\u00067"}, d2 = {"Lcom/avito/android/extended_profile/adapter/contact_bar/ContactBarItem;", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileListItem;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "component2", "()Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "component3", "()Ljava/util/List;", "component4", "Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;", "component5", "()Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;", "stringId", "gridItemType", "contactActions", "name", "onlineStatus", "copy", "(Ljava/lang/String;Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;)Lcom/avito/android/extended_profile/adapter/contact_bar/ContactBarItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "c", "Ljava/util/List;", "getContactActions", "d", "getName", AuthSource.BOOKING_ORDER, "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "getGridItemType", "e", "Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;", "getOnlineStatus", "<init>", "(Ljava/lang/String;Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ContactBarItem implements ExtendedProfileListItem {
    public static final Parcelable.Creator<ContactBarItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final ExtendedProfileSpanLookup.GridItemType b;
    @NotNull
    public final List<ContactBar.Action> c;
    @NotNull
    public final String d;
    @NotNull
    public final SellerOnlineStatus e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ContactBarItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactBarItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            ExtendedProfileSpanLookup.GridItemType gridItemType = (ExtendedProfileSpanLookup.GridItemType) Enum.valueOf(ExtendedProfileSpanLookup.GridItemType.class, parcel.readString());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((ContactBar.Action) parcel.readParcelable(ContactBarItem.class.getClassLoader()));
                readInt--;
            }
            return new ContactBarItem(readString, gridItemType, arrayList, parcel.readString(), (SellerOnlineStatus) parcel.readParcelable(ContactBarItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactBarItem[] newArray(int i) {
            return new ContactBarItem[i];
        }
    }

    public ContactBarItem(@NotNull String str, @NotNull ExtendedProfileSpanLookup.GridItemType gridItemType, @NotNull List<ContactBar.Action> list, @NotNull String str2, @NotNull SellerOnlineStatus sellerOnlineStatus) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(gridItemType, "gridItemType");
        Intrinsics.checkNotNullParameter(list, "contactActions");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(sellerOnlineStatus, "onlineStatus");
        this.a = str;
        this.b = gridItemType;
        this.c = list;
        this.d = str2;
        this.e = sellerOnlineStatus;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.extended_profile.adapter.contact_bar.ContactBarItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContactBarItem copy$default(ContactBarItem contactBarItem, String str, ExtendedProfileSpanLookup.GridItemType gridItemType, List list, String str2, SellerOnlineStatus sellerOnlineStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contactBarItem.getStringId();
        }
        if ((i & 2) != 0) {
            gridItemType = contactBarItem.getGridItemType();
        }
        if ((i & 4) != 0) {
            list = contactBarItem.c;
        }
        if ((i & 8) != 0) {
            str2 = contactBarItem.d;
        }
        if ((i & 16) != 0) {
            sellerOnlineStatus = contactBarItem.e;
        }
        return contactBarItem.copy(str, gridItemType, list, str2, sellerOnlineStatus);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final ExtendedProfileSpanLookup.GridItemType component2() {
        return getGridItemType();
    }

    @NotNull
    public final List<ContactBar.Action> component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final SellerOnlineStatus component5() {
        return this.e;
    }

    @NotNull
    public final ContactBarItem copy(@NotNull String str, @NotNull ExtendedProfileSpanLookup.GridItemType gridItemType, @NotNull List<ContactBar.Action> list, @NotNull String str2, @NotNull SellerOnlineStatus sellerOnlineStatus) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(gridItemType, "gridItemType");
        Intrinsics.checkNotNullParameter(list, "contactActions");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(sellerOnlineStatus, "onlineStatus");
        return new ContactBarItem(str, gridItemType, list, str2, sellerOnlineStatus);
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
        if (!(obj instanceof ContactBarItem)) {
            return false;
        }
        ContactBarItem contactBarItem = (ContactBarItem) obj;
        return Intrinsics.areEqual(getStringId(), contactBarItem.getStringId()) && Intrinsics.areEqual(getGridItemType(), contactBarItem.getGridItemType()) && Intrinsics.areEqual(this.c, contactBarItem.c) && Intrinsics.areEqual(this.d, contactBarItem.d) && Intrinsics.areEqual(this.e, contactBarItem.e);
    }

    @NotNull
    public final List<ContactBar.Action> getContactActions() {
        return this.c;
    }

    @Override // com.avito.android.extended_profile.adapter.ExtendedProfileListItem
    @NotNull
    public ExtendedProfileSpanLookup.GridItemType getGridItemType() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ExtendedProfileListItem.DefaultImpls.getId(this);
    }

    @NotNull
    public final String getName() {
        return this.d;
    }

    @NotNull
    public final SellerOnlineStatus getOnlineStatus() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        ExtendedProfileSpanLookup.GridItemType gridItemType = getGridItemType();
        int hashCode2 = (hashCode + (gridItemType != null ? gridItemType.hashCode() : 0)) * 31;
        List<ContactBar.Action> list = this.c;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.d;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        SellerOnlineStatus sellerOnlineStatus = this.e;
        if (sellerOnlineStatus != null) {
            i = sellerOnlineStatus.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ContactBarItem(stringId=");
        L.append(getStringId());
        L.append(", gridItemType=");
        L.append(getGridItemType());
        L.append(", contactActions=");
        L.append(this.c);
        L.append(", name=");
        L.append(this.d);
        L.append(", onlineStatus=");
        L.append(this.e);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b.name());
        Iterator n0 = a.n0(this.c, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((ContactBar.Action) n0.next(), i);
        }
        parcel.writeString(this.d);
        parcel.writeParcelable(this.e, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContactBarItem(String str, ExtendedProfileSpanLookup.GridItemType gridItemType, List list, String str2, SellerOnlineStatus sellerOnlineStatus, int i, j jVar) {
        this((i & 1) != 0 ? "contact_bar_item" : str, (i & 2) != 0 ? ExtendedProfileSpanLookup.GridItemType.FULL_WIDTH : gridItemType, list, str2, sellerOnlineStatus);
    }
}
