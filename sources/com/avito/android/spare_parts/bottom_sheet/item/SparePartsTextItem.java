package com.avito.android.spare_parts.bottom_sheet.item;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/avito/android/spare_parts/bottom_sheet/item/SparePartsTextItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/CharSequence;", "", "component3", "()Z", "stringId", "text", "hasChildNodes", "copy", "(Ljava/lang/String;Ljava/lang/CharSequence;Z)Lcom/avito/android/spare_parts/bottom_sheet/item/SparePartsTextItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getText", "c", "Z", "getHasChildNodes", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Z)V", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
public final class SparePartsTextItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final CharSequence b;
    public final boolean c;

    public SparePartsTextItem(@NotNull String str, @NotNull CharSequence charSequence, boolean z) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.a = str;
        this.b = charSequence;
        this.c = z;
    }

    public static /* synthetic */ SparePartsTextItem copy$default(SparePartsTextItem sparePartsTextItem, String str, CharSequence charSequence, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sparePartsTextItem.getStringId();
        }
        if ((i & 2) != 0) {
            charSequence = sparePartsTextItem.b;
        }
        if ((i & 4) != 0) {
            z = sparePartsTextItem.c;
        }
        return sparePartsTextItem.copy(str, charSequence, z);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final CharSequence component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    @NotNull
    public final SparePartsTextItem copy(@NotNull String str, @NotNull CharSequence charSequence, boolean z) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        return new SparePartsTextItem(str, charSequence, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SparePartsTextItem)) {
            return false;
        }
        SparePartsTextItem sparePartsTextItem = (SparePartsTextItem) obj;
        return Intrinsics.areEqual(getStringId(), sparePartsTextItem.getStringId()) && Intrinsics.areEqual(this.b, sparePartsTextItem.b) && this.c == sparePartsTextItem.c;
    }

    public final boolean getHasChildNodes() {
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

    @NotNull
    public final CharSequence getText() {
        return this.b;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        CharSequence charSequence = this.b;
        if (charSequence != null) {
            i = charSequence.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.c;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SparePartsTextItem(stringId=");
        L.append(getStringId());
        L.append(", text=");
        L.append(this.b);
        L.append(", hasChildNodes=");
        return a.B(L, this.c, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SparePartsTextItem(String str, CharSequence charSequence, boolean z, int i, j jVar) {
        this((i & 1) != 0 ? "spare_parts_item_id" : str, charSequence, (i & 4) != 0 ? true : z);
    }
}
