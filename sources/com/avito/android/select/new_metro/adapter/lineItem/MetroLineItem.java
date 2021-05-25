package com.avito.android.select.new_metro.adapter.lineItem;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.new_metro.adapter.ComparableContent;
import com.avito.conveyor_item.Item;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b$\b\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f\u0012\u0006\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b1\u00102J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\nJH\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001b\u0010\rJ\u001a\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u0007R\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\nR\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0011R\u0019\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\rR\u001c\u0010\u0017\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010\nR\u0019\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010\rR\"\u0010-\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/select/new_metro/adapter/ComparableContent;", "", "second", "", "hasSameContentAs", "(Ljava/lang/Object;)Z", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "", "component4", "()Ljava/util/List;", "component5", "name", "lineColor", "lineId", "stationIds", "stringId", "copy", "(Ljava/lang/String;IILjava/util/List;Ljava/lang/String;)Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItem;", "toString", "hashCode", "other", "equals", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getName", "e", "Ljava/util/List;", "getStationIds", "d", "I", "getLineId", "f", "getStringId", "c", "getLineColor", AuthSource.SEND_ABUSE, "Z", "isExpanded", "()Z", "setExpanded", "(Z)V", "<init>", "(Ljava/lang/String;IILjava/util/List;Ljava/lang/String;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroLineItem implements Item, ComparableContent {
    public boolean a;
    @NotNull
    public final String b;
    public final int c;
    public final int d;
    @NotNull
    public final List<Integer> e;
    @NotNull
    public final String f;

    public MetroLineItem(@NotNull String str, int i, int i2, @NotNull List<Integer> list, @NotNull String str2) {
        a.d1(str, "name", list, "stationIds", str2, "stringId");
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = list;
        this.f = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetroLineItem copy$default(MetroLineItem metroLineItem, String str, int i, int i2, List list, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = metroLineItem.b;
        }
        if ((i3 & 2) != 0) {
            i = metroLineItem.c;
        }
        if ((i3 & 4) != 0) {
            i2 = metroLineItem.d;
        }
        if ((i3 & 8) != 0) {
            list = metroLineItem.e;
        }
        if ((i3 & 16) != 0) {
            str2 = metroLineItem.getStringId();
        }
        return metroLineItem.copy(str, i, i2, list, str2);
    }

    @NotNull
    public final String component1() {
        return this.b;
    }

    public final int component2() {
        return this.c;
    }

    public final int component3() {
        return this.d;
    }

    @NotNull
    public final List<Integer> component4() {
        return this.e;
    }

    @NotNull
    public final String component5() {
        return getStringId();
    }

    @NotNull
    public final MetroLineItem copy(@NotNull String str, int i, int i2, @NotNull List<Integer> list, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "stationIds");
        Intrinsics.checkNotNullParameter(str2, "stringId");
        return new MetroLineItem(str, i, i2, list, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetroLineItem)) {
            return false;
        }
        MetroLineItem metroLineItem = (MetroLineItem) obj;
        return Intrinsics.areEqual(this.b, metroLineItem.b) && this.c == metroLineItem.c && this.d == metroLineItem.d && Intrinsics.areEqual(this.e, metroLineItem.e) && Intrinsics.areEqual(getStringId(), metroLineItem.getStringId());
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    public final int getLineColor() {
        return this.c;
    }

    public final int getLineId() {
        return this.d;
    }

    @NotNull
    public final String getName() {
        return this.b;
    }

    @NotNull
    public final List<Integer> getStationIds() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.f;
    }

    @Override // com.avito.android.select.new_metro.adapter.ComparableContent
    public boolean hasSameContentAs(@Nullable Object obj) {
        if (Intrinsics.areEqual(this, obj)) {
            boolean z = this.a;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem");
            if (z == ((MetroLineItem) obj).a) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.b;
        int i = 0;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.c) * 31) + this.d) * 31;
        List<Integer> list = this.e;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String stringId = getStringId();
        if (stringId != null) {
            i = stringId.hashCode();
        }
        return hashCode2 + i;
    }

    public final boolean isExpanded() {
        return this.a;
    }

    public final void setExpanded(boolean z) {
        this.a = z;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MetroLineItem(name=");
        L.append(this.b);
        L.append(", lineColor=");
        L.append(this.c);
        L.append(", lineId=");
        L.append(this.d);
        L.append(", stationIds=");
        L.append(this.e);
        L.append(", stringId=");
        L.append(getStringId());
        L.append(")");
        return L.toString();
    }
}
