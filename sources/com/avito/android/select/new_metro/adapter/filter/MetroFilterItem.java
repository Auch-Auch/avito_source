package com.avito.android.select.new_metro.adapter.filter;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.new_metro.adapter.ComparableContent;
import com.avito.conveyor_item.Item;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b#\b\b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b-\u0010.J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u0010\u0010\u0010\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J>\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\b2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u0010\u0010\u0019\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0011J\u001a\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\nR\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010 \u001a\u0004\b)\u0010\nR\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u000e¨\u0006/"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/select/new_metro/adapter/ComparableContent;", "", "second", "", "hasSameContentAs", "(Ljava/lang/Object;)Z", "", "component1", "()Ljava/lang/String;", "", "", "component2", "()Ljava/util/Set;", "component3", "component4", "()I", "stringId", "stationIds", "name", "filterId", "copy", "(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;I)Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItem;", "toString", "hashCode", "other", "equals", "e", "I", "getFilterId", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", AuthSource.SEND_ABUSE, "Z", "isChecked", "()Z", "setChecked", "(Z)V", "d", "getName", "c", "Ljava/util/Set;", "getStationIds", "<init>", "(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;I)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroFilterItem implements Item, ComparableContent {
    public boolean a;
    @NotNull
    public final String b;
    @NotNull
    public final Set<Integer> c;
    @NotNull
    public final String d;
    public final int e;

    public MetroFilterItem(@NotNull String str, @NotNull Set<Integer> set, @NotNull String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(set, "stationIds");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.b = str;
        this.c = set;
        this.d = str2;
        this.e = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.select.new_metro.adapter.filter.MetroFilterItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetroFilterItem copy$default(MetroFilterItem metroFilterItem, String str, Set set, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = metroFilterItem.getStringId();
        }
        if ((i2 & 2) != 0) {
            set = metroFilterItem.c;
        }
        if ((i2 & 4) != 0) {
            str2 = metroFilterItem.d;
        }
        if ((i2 & 8) != 0) {
            i = metroFilterItem.e;
        }
        return metroFilterItem.copy(str, set, str2, i);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final Set<Integer> component2() {
        return this.c;
    }

    @NotNull
    public final String component3() {
        return this.d;
    }

    public final int component4() {
        return this.e;
    }

    @NotNull
    public final MetroFilterItem copy(@NotNull String str, @NotNull Set<Integer> set, @NotNull String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(set, "stationIds");
        Intrinsics.checkNotNullParameter(str2, "name");
        return new MetroFilterItem(str, set, str2, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetroFilterItem)) {
            return false;
        }
        MetroFilterItem metroFilterItem = (MetroFilterItem) obj;
        return Intrinsics.areEqual(getStringId(), metroFilterItem.getStringId()) && Intrinsics.areEqual(this.c, metroFilterItem.c) && Intrinsics.areEqual(this.d, metroFilterItem.d) && this.e == metroFilterItem.e;
    }

    public final int getFilterId() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final String getName() {
        return this.d;
    }

    @NotNull
    public final Set<Integer> getStationIds() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // com.avito.android.select.new_metro.adapter.ComparableContent
    public boolean hasSameContentAs(@Nullable Object obj) {
        if (Intrinsics.areEqual(this, obj)) {
            boolean z = this.a;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.select.new_metro.adapter.filter.MetroFilterItem");
            if (z == ((MetroFilterItem) obj).a) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        Set<Integer> set = this.c;
        int hashCode2 = (hashCode + (set != null ? set.hashCode() : 0)) * 31;
        String str = this.d;
        if (str != null) {
            i = str.hashCode();
        }
        return ((hashCode2 + i) * 31) + this.e;
    }

    public final boolean isChecked() {
        return this.a;
    }

    public final void setChecked(boolean z) {
        this.a = z;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MetroFilterItem(stringId=");
        L.append(getStringId());
        L.append(", stationIds=");
        L.append(this.c);
        L.append(", name=");
        L.append(this.d);
        L.append(", filterId=");
        return a.j(L, this.e, ")");
    }
}
