package com.avito.android.booking.item.picture;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/booking/item/picture/PictureItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "stringId", "copy", "(Ljava/lang/String;)Lcom/avito/android/booking/item/picture/PictureItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "<init>", "(Ljava/lang/String;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class PictureItem implements Item {
    @NotNull
    public final String a;

    public PictureItem() {
        this(null, 1, null);
    }

    public PictureItem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.a = str;
    }

    public static /* synthetic */ PictureItem copy$default(PictureItem pictureItem, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pictureItem.getStringId();
        }
        return pictureItem.copy(str);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final PictureItem copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        return new PictureItem(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof PictureItem) && Intrinsics.areEqual(getStringId(), ((PictureItem) obj).getStringId());
        }
        return true;
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
        if (stringId != null) {
            return stringId.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("PictureItem(stringId=");
        L.append(getStringId());
        L.append(")");
        return L.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PictureItem(java.lang.String r1, int r2, t6.r.a.j r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x000b
            com.avito.android.booking.item.BookingInfoItem r1 = com.avito.android.booking.item.BookingInfoItem.PICTURE
            r1 = 0
            java.lang.String r1 = java.lang.String.valueOf(r1)
        L_0x000b:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.booking.item.picture.PictureItem.<init>(java.lang.String, int, t6.r.a.j):void");
    }
}
