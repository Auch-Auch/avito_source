package com.avito.android.home.tabs_item;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.HomeTabItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J>\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\"\u001a\u00020\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010$\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0007¨\u0006-"}, d2 = {"Lcom/avito/android/home/tabs_item/SectionTabsItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "", "Lcom/avito/android/remote/model/HomeTabItem;", "component3", "()Ljava/util/List;", "component4", "stringId", "spanCount", "tabs", "selectedId", "copy", "(Ljava/lang/String;ILjava/util/List;Ljava/lang/String;)Lcom/avito/android/home/tabs_item/SectionTabsItem;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/util/List;", "getTabs", "Lcom/avito/android/serp/adapter/SerpViewType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "e", "getSelectedId", "c", "I", "getSpanCount", "<init>", "(Ljava/lang/String;ILjava/util/List;Ljava/lang/String;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class SectionTabsItem implements ViewTypeSerpItem {
    @NotNull
    public final SerpViewType a = SerpViewType.SINGLE;
    @NotNull
    public final String b;
    public final int c;
    @NotNull
    public final List<HomeTabItem> d;
    @NotNull
    public final String e;

    public SectionTabsItem(@NotNull String str, int i, @NotNull List<HomeTabItem> list, @NotNull String str2) {
        a.d1(str, "stringId", list, "tabs", str2, "selectedId");
        this.b = str;
        this.c = i;
        this.d = list;
        this.e = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.home.tabs_item.SectionTabsItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SectionTabsItem copy$default(SectionTabsItem sectionTabsItem, String str, int i, List list, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sectionTabsItem.getStringId();
        }
        if ((i2 & 2) != 0) {
            i = sectionTabsItem.getSpanCount();
        }
        if ((i2 & 4) != 0) {
            list = sectionTabsItem.d;
        }
        if ((i2 & 8) != 0) {
            str2 = sectionTabsItem.e;
        }
        return sectionTabsItem.copy(str, i, list, str2);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    public final int component2() {
        return getSpanCount();
    }

    @NotNull
    public final List<HomeTabItem> component3() {
        return this.d;
    }

    @NotNull
    public final String component4() {
        return this.e;
    }

    @NotNull
    public final SectionTabsItem copy(@NotNull String str, int i, @NotNull List<HomeTabItem> list, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(list, "tabs");
        Intrinsics.checkNotNullParameter(str2, "selectedId");
        return new SectionTabsItem(str, i, list, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SectionTabsItem)) {
            return false;
        }
        SectionTabsItem sectionTabsItem = (SectionTabsItem) obj;
        return Intrinsics.areEqual(getStringId(), sectionTabsItem.getStringId()) && getSpanCount() == sectionTabsItem.getSpanCount() && Intrinsics.areEqual(this.d, sectionTabsItem.d) && Intrinsics.areEqual(this.e, sectionTabsItem.e);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ViewTypeSerpItem.DefaultImpls.getId(this);
    }

    @NotNull
    public final String getSelectedId() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @NotNull
    public final List<HomeTabItem> getTabs() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.a;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int spanCount = (getSpanCount() + ((stringId != null ? stringId.hashCode() : 0) * 31)) * 31;
        List<HomeTabItem> list = this.d;
        int hashCode = (spanCount + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.e;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SectionTabsItem(stringId=");
        L.append(getStringId());
        L.append(", spanCount=");
        L.append(getSpanCount());
        L.append(", tabs=");
        L.append(this.d);
        L.append(", selectedId=");
        return a.t(L, this.e, ")");
    }
}
