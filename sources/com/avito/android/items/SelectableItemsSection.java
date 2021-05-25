package com.avito.android.items;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J,\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0015\u0010\fR\u001c\u0010\u0019\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\fR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0010¨\u0006!"}, d2 = {"Lcom/avito/android/items/SelectableItemsSection;", "Lcom/avito/conveyor_item/Item;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/items/SelectableItem;", "component2", "()Ljava/util/List;", "title", "items", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/items/SelectableItemsSection;", "toString", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "stringId", AuthSource.BOOKING_ORDER, "getTitle", "c", "Ljava/util/List;", "getItems", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class SelectableItemsSection implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @NotNull
    public final List<SelectableItem> c;

    public SelectableItemsSection(@Nullable String str, @NotNull List<SelectableItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.b = str;
        this.c = list;
        this.a = str == null ? "" : str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.items.SelectableItemsSection */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SelectableItemsSection copy$default(SelectableItemsSection selectableItemsSection, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = selectableItemsSection.b;
        }
        if ((i & 2) != 0) {
            list = selectableItemsSection.c;
        }
        return selectableItemsSection.copy(str, list);
    }

    @Nullable
    public final String component1() {
        return this.b;
    }

    @NotNull
    public final List<SelectableItem> component2() {
        return this.c;
    }

    @NotNull
    public final SelectableItemsSection copy(@Nullable String str, @NotNull List<SelectableItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new SelectableItemsSection(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(SelectableItemsSection.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.items.SelectableItemsSection");
        return !(Intrinsics.areEqual(getStringId(), ((SelectableItemsSection) obj).getStringId()) ^ true);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final List<SelectableItem> getItems() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final String getTitle() {
        return this.b;
    }

    public int hashCode() {
        return getStringId().hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SelectableItemsSection(title=");
        L.append(this.b);
        L.append(", items=");
        return a.w(L, this.c, ")");
    }
}
