package com.avito.android.select.new_metro.adapter.selected_stations;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.new_metro.adapter.ComparableContent;
import com.avito.conveyor_item.Item;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\b\b\u0002\u0010.\u001a\u00020)\u0012\b\b\u0002\u0010$\u001a\u00020\u0011\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070/¢\u0006\u0004\b0\u00101J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\rJ\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001d\u001a\u00020\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010(R\u0019\u0010.\u001a\u00020)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/select/new_metro/adapter/ComparableContent;", "", "clear", "()V", "", "Lcom/avito/android/select/new_metro/adapter/selected_stations/SelectedStationInfo;", "items", "update", "(Ljava/util/List;)V", "station", ProductAction.ACTION_ADD, "(Lcom/avito/android/select/new_metro/adapter/selected_stations/SelectedStationInfo;)V", ProductAction.ACTION_REMOVE, "", "second", "", "hasSameContentAs", "(Ljava/lang/Object;)Z", "", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "container", "", "c", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "e", "Z", "getShowAll", "()Z", "setShowAll", "(Z)V", "showAll", "", AuthSource.BOOKING_ORDER, "getItems", "()Ljava/util/Set;", "", "d", "I", "getMinimumShowedLines", "()I", "minimumShowedLines", "", "<init>", "(Ljava/lang/String;IZLjava/util/Collection;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroSelectedStationsItem implements Item, ComparableContent {
    public final Set<SelectedStationInfo> a;
    @NotNull
    public final Set<SelectedStationInfo> b;
    @NotNull
    public final String c;
    public final int d;
    public boolean e;

    public MetroSelectedStationsItem(@NotNull String str, int i, boolean z, @NotNull Collection<SelectedStationInfo> collection) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(collection, "items");
        this.c = str;
        this.d = i;
        this.e = z;
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        this.a = linkedHashSet;
        this.b = linkedHashSet;
    }

    public final void add(@NotNull SelectedStationInfo selectedStationInfo) {
        Intrinsics.checkNotNullParameter(selectedStationInfo, "station");
        this.a.add(selectedStationInfo);
    }

    public final void clear() {
        this.a.clear();
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final Set<SelectedStationInfo> getItems() {
        return this.b;
    }

    public final int getMinimumShowedLines() {
        return this.d;
    }

    public final boolean getShowAll() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @Override // com.avito.android.select.new_metro.adapter.ComparableContent
    public boolean hasSameContentAs(@Nullable Object obj) {
        boolean z;
        if (!(obj instanceof MetroSelectedStationsItem)) {
            return false;
        }
        MetroSelectedStationsItem metroSelectedStationsItem = (MetroSelectedStationsItem) obj;
        if (this.b.size() != metroSelectedStationsItem.b.size()) {
            return false;
        }
        Set<SelectedStationInfo> set = this.b;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!metroSelectedStationsItem.b.contains(it.next())) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z && this.e == metroSelectedStationsItem.e && this.d == metroSelectedStationsItem.d) {
            return true;
        }
        return false;
    }

    public final void remove(@NotNull SelectedStationInfo selectedStationInfo) {
        Intrinsics.checkNotNullParameter(selectedStationInfo, "station");
        this.a.remove(selectedStationInfo);
    }

    public final void setShowAll(boolean z) {
        this.e = z;
    }

    public final void update(@NotNull List<SelectedStationInfo> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.a.clear();
        this.a.addAll(list);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MetroSelectedStationsItem(String str, int i, boolean z, Collection collection, int i2, j jVar) {
        this(str, (i2 & 2) != 0 ? 3 : i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : collection);
    }
}
