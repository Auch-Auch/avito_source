package com.avito.android.items;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b%\u0010&J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0018\u0010\fR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\fR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0014\u0010\u000f\"\u0004\b!\u0010\"R\u0019\u0010\u0013\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\f¨\u0006'"}, d2 = {"Lcom/avito/android/items/SelectableItem;", "Lcom/avito/conveyor_item/Item;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "component1", "()Ljava/lang/String;", "component2", "component3", "()Z", "component4", "()Ljava/lang/Integer;", "stringId", "title", "isSelected", "color", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;)Lcom/avito/android/items/SelectableItem;", "toString", "d", "Ljava/lang/Integer;", "getColor", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "c", "Z", "setSelected", "(Z)V", AuthSource.BOOKING_ORDER, "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class SelectableItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public boolean c;
    @Nullable
    public final Integer d;

    public SelectableItem(@NotNull String str, @NotNull String str2, boolean z, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = num;
    }

    public static /* synthetic */ SelectableItem copy$default(SelectableItem selectableItem, String str, String str2, boolean z, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = selectableItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = selectableItem.b;
        }
        if ((i & 4) != 0) {
            z = selectableItem.c;
        }
        if ((i & 8) != 0) {
            num = selectableItem.d;
        }
        return selectableItem.copy(str, str2, z, num);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    @Nullable
    public final Integer component4() {
        return this.d;
    }

    @NotNull
    public final SelectableItem copy(@NotNull String str, @NotNull String str2, boolean z, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new SelectableItem(str, str2, z, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(SelectableItem.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.items.SelectableItem");
        return !(Intrinsics.areEqual(getStringId(), ((SelectableItem) obj).getStringId()) ^ true);
    }

    @Nullable
    public final Integer getColor() {
        return this.d;
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
    public final String getTitle() {
        return this.b;
    }

    public int hashCode() {
        return getStringId().hashCode();
    }

    public final boolean isSelected() {
        return this.c;
    }

    public final void setSelected(boolean z) {
        this.c = z;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SelectableItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.b);
        L.append(", isSelected=");
        L.append(this.c);
        L.append(", color=");
        return a.p(L, this.d, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectableItem(String str, String str2, boolean z, Integer num, int i, j jVar) {
        this(str, str2, z, (i & 8) != 0 ? null : num);
    }
}
