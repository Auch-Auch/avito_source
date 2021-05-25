package com.avito.android.advert_core.discount.item.contact;

import a2.b.a.a.a;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.photo_gallery.LegacyPhotoGalleryActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000b¨\u0006%"}, d2 = {"Lcom/avito/android/advert_core/discount/item/contact/ContactItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "component2", "()Ljava/util/List;", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "component3", "()Lcom/avito/android/remote/model/advert_details/ContactBarData;", "stringId", "actions", LegacyPhotoGalleryActivityKt.LEGACY_PHOTO_GALLERY_KEY_CONTACT_DATA, "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/advert_details/ContactBarData;)Lcom/avito/android/advert_core/discount/item/contact/ContactItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getActions", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "c", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "getContactBarData", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/advert_details/ContactBarData;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class ContactItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final List<ContactBar.Action> b;
    @Nullable
    public final ContactBarData c;

    public ContactItem() {
        this(null, null, null, 7, null);
    }

    public ContactItem(@NotNull String str, @NotNull List<ContactBar.Action> list, @Nullable ContactBarData contactBarData) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(list, "actions");
        this.a = str;
        this.b = list;
        this.c = contactBarData;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.advert_core.discount.item.contact.ContactItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContactItem copy$default(ContactItem contactItem, String str, List list, ContactBarData contactBarData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contactItem.getStringId();
        }
        if ((i & 2) != 0) {
            list = contactItem.b;
        }
        if ((i & 4) != 0) {
            contactBarData = contactItem.c;
        }
        return contactItem.copy(str, list, contactBarData);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final List<ContactBar.Action> component2() {
        return this.b;
    }

    @Nullable
    public final ContactBarData component3() {
        return this.c;
    }

    @NotNull
    public final ContactItem copy(@NotNull String str, @NotNull List<ContactBar.Action> list, @Nullable ContactBarData contactBarData) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(list, "actions");
        return new ContactItem(str, list, contactBarData);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactItem)) {
            return false;
        }
        ContactItem contactItem = (ContactItem) obj;
        return Intrinsics.areEqual(getStringId(), contactItem.getStringId()) && Intrinsics.areEqual(this.b, contactItem.b) && Intrinsics.areEqual(this.c, contactItem.c);
    }

    @NotNull
    public final List<ContactBar.Action> getActions() {
        return this.b;
    }

    @Nullable
    public final ContactBarData getContactBarData() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        List<ContactBar.Action> list = this.b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        ContactBarData contactBarData = this.c;
        if (contactBarData != null) {
            i = contactBarData.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ContactItem(stringId=");
        L.append(getStringId());
        L.append(", actions=");
        L.append(this.b);
        L.append(", contactBarData=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ContactItem(java.lang.String r2, java.util.List r3, com.avito.android.remote.model.advert_details.ContactBarData r4, int r5, t6.r.a.j r6) {
        /*
            r1 = this;
            r6 = r5 & 1
            r0 = 4
            if (r6 == 0) goto L_0x000b
            com.avito.android.advert_core.discount.item.AdvertDiscountItem r2 = com.avito.android.advert_core.discount.item.AdvertDiscountItem.CONTACT
            java.lang.String r2 = java.lang.String.valueOf(r0)
        L_0x000b:
            r6 = r5 & 2
            if (r6 == 0) goto L_0x0013
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0013:
            r5 = r5 & r0
            if (r5 == 0) goto L_0x0017
            r4 = 0
        L_0x0017:
            r1.<init>(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert_core.discount.item.contact.ContactItem.<init>(java.lang.String, java.util.List, com.avito.android.remote.model.advert_details.ContactBarData, int, t6.r.a.j):void");
    }
}
