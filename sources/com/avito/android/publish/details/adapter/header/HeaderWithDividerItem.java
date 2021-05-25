package com.avito.android.publish.details.adapter.header;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/avito/android/publish/details/adapter/header/HeaderWithDividerItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "stringId", "text", "showDividerOnTop", "copy", "(Ljava/lang/String;Ljava/lang/String;Z)Lcom/avito/android/publish/details/adapter/header/HeaderWithDividerItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", "c", "Z", "getShowDividerOnTop", AuthSource.SEND_ABUSE, "getStringId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderWithDividerItem implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    public final boolean c;

    public HeaderWithDividerItem(@NotNull String str, @Nullable String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.a = str;
        this.b = str2;
        this.c = z;
    }

    public static /* synthetic */ HeaderWithDividerItem copy$default(HeaderWithDividerItem headerWithDividerItem, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = headerWithDividerItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = headerWithDividerItem.b;
        }
        if ((i & 4) != 0) {
            z = headerWithDividerItem.c;
        }
        return headerWithDividerItem.copy(str, str2, z);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    @NotNull
    public final HeaderWithDividerItem copy(@NotNull String str, @Nullable String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        return new HeaderWithDividerItem(str, str2, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderWithDividerItem)) {
            return false;
        }
        HeaderWithDividerItem headerWithDividerItem = (HeaderWithDividerItem) obj;
        return Intrinsics.areEqual(getStringId(), headerWithDividerItem.getStringId()) && Intrinsics.areEqual(this.b, headerWithDividerItem.b) && this.c == headerWithDividerItem.c;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    public final boolean getShowDividerOnTop() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final String getText() {
        return this.b;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        String str = this.b;
        if (str != null) {
            i = str.hashCode();
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
        StringBuilder L = a.L("HeaderWithDividerItem(stringId=");
        L.append(getStringId());
        L.append(", text=");
        L.append(this.b);
        L.append(", showDividerOnTop=");
        return a.B(L, this.c, ")");
    }
}
