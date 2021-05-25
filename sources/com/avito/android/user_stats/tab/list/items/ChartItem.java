package com.avito.android.user_stats.tab.list.items;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.UniversalColor;
import com.avito.conveyor_item.Item;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001:\u0001\u001eB\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/ChartItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/user_stats/tab/list/items/ChartItem$BarItem;", "component2", "()Ljava/util/List;", "stringId", "barList", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/user_stats/tab/list/items/ChartItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getBarList", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "BarItem", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class ChartItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final List<BarItem> b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JL\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0007J\u001a\u0010\u001e\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0016\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u0016\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\nR\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0007R\u001c\u0010\u0012\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010#\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0011¨\u00062"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/ChartItem$BarItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "", "component3", "()F", "component4", "", "component5", "()Z", "Lcom/avito/android/remote/model/UniversalColor;", "component6", "()Lcom/avito/android/remote/model/UniversalColor;", "stringId", FirebaseAnalytics.Param.INDEX, "value", "label", "isSelected", "color", "copy", "(Ljava/lang/String;IFLjava/lang/String;ZLcom/avito/android/remote/model/UniversalColor;)Lcom/avito/android/user_stats/tab/list/items/ChartItem$BarItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "e", "Z", "d", "Ljava/lang/String;", "getLabel", "c", "F", "getValue", AuthSource.BOOKING_ORDER, "I", "getIndex", AuthSource.SEND_ABUSE, "getStringId", "f", "Lcom/avito/android/remote/model/UniversalColor;", "getColor", "<init>", "(Ljava/lang/String;IFLjava/lang/String;ZLcom/avito/android/remote/model/UniversalColor;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
    public static final class BarItem implements Item {
        @NotNull
        public final String a;
        public final int b;
        public final float c;
        @NotNull
        public final String d;
        public final boolean e;
        @NotNull
        public final UniversalColor f;

        public BarItem(@NotNull String str, int i, float f2, @NotNull String str2, boolean z, @NotNull UniversalColor universalColor) {
            Intrinsics.checkNotNullParameter(str, "stringId");
            Intrinsics.checkNotNullParameter(str2, "label");
            Intrinsics.checkNotNullParameter(universalColor, "color");
            this.a = str;
            this.b = i;
            this.c = f2;
            this.d = str2;
            this.e = z;
            this.f = universalColor;
        }

        public static /* synthetic */ BarItem copy$default(BarItem barItem, String str, int i, float f2, String str2, boolean z, UniversalColor universalColor, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = barItem.getStringId();
            }
            if ((i2 & 2) != 0) {
                i = barItem.b;
            }
            if ((i2 & 4) != 0) {
                f2 = barItem.c;
            }
            if ((i2 & 8) != 0) {
                str2 = barItem.d;
            }
            if ((i2 & 16) != 0) {
                z = barItem.e;
            }
            if ((i2 & 32) != 0) {
                universalColor = barItem.f;
            }
            return barItem.copy(str, i, f2, str2, z, universalColor);
        }

        @NotNull
        public final String component1() {
            return getStringId();
        }

        public final int component2() {
            return this.b;
        }

        public final float component3() {
            return this.c;
        }

        @NotNull
        public final String component4() {
            return this.d;
        }

        public final boolean component5() {
            return this.e;
        }

        @NotNull
        public final UniversalColor component6() {
            return this.f;
        }

        @NotNull
        public final BarItem copy(@NotNull String str, int i, float f2, @NotNull String str2, boolean z, @NotNull UniversalColor universalColor) {
            Intrinsics.checkNotNullParameter(str, "stringId");
            Intrinsics.checkNotNullParameter(str2, "label");
            Intrinsics.checkNotNullParameter(universalColor, "color");
            return new BarItem(str, i, f2, str2, z, universalColor);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BarItem)) {
                return false;
            }
            BarItem barItem = (BarItem) obj;
            return Intrinsics.areEqual(getStringId(), barItem.getStringId()) && this.b == barItem.b && Float.compare(this.c, barItem.c) == 0 && Intrinsics.areEqual(this.d, barItem.d) && this.e == barItem.e && Intrinsics.areEqual(this.f, barItem.f);
        }

        @NotNull
        public final UniversalColor getColor() {
            return this.f;
        }

        @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
        public long getId() {
            return Item.DefaultImpls.getId(this);
        }

        public final int getIndex() {
            return this.b;
        }

        @NotNull
        public final String getLabel() {
            return this.d;
        }

        @Override // com.avito.conveyor_item.Item
        @NotNull
        public String getStringId() {
            return this.a;
        }

        public final float getValue() {
            return this.c;
        }

        public int hashCode() {
            String stringId = getStringId();
            int i = 0;
            int i1 = a.i1(this.c, (((stringId != null ? stringId.hashCode() : 0) * 31) + this.b) * 31, 31);
            String str = this.d;
            int hashCode = (i1 + (str != null ? str.hashCode() : 0)) * 31;
            boolean z = this.e;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = (hashCode + i2) * 31;
            UniversalColor universalColor = this.f;
            if (universalColor != null) {
                i = universalColor.hashCode();
            }
            return i5 + i;
        }

        public final boolean isSelected() {
            return this.e;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("BarItem(stringId=");
            L.append(getStringId());
            L.append(", index=");
            L.append(this.b);
            L.append(", value=");
            L.append(this.c);
            L.append(", label=");
            L.append(this.d);
            L.append(", isSelected=");
            L.append(this.e);
            L.append(", color=");
            L.append(this.f);
            L.append(")");
            return L.toString();
        }
    }

    public ChartItem(@NotNull String str, @NotNull List<BarItem> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(list, "barList");
        this.a = str;
        this.b = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.user_stats.tab.list.items.ChartItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChartItem copy$default(ChartItem chartItem, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chartItem.getStringId();
        }
        if ((i & 2) != 0) {
            list = chartItem.b;
        }
        return chartItem.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final List<BarItem> component2() {
        return this.b;
    }

    @NotNull
    public final ChartItem copy(@NotNull String str, @NotNull List<BarItem> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(list, "barList");
        return new ChartItem(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChartItem)) {
            return false;
        }
        ChartItem chartItem = (ChartItem) obj;
        return Intrinsics.areEqual(getStringId(), chartItem.getStringId()) && Intrinsics.areEqual(this.b, chartItem.b);
    }

    @NotNull
    public final List<BarItem> getBarList() {
        return this.b;
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
        List<BarItem> list = this.b;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChartItem(stringId=");
        L.append(getStringId());
        L.append(", barList=");
        return a.w(L, this.b, ")");
    }
}
