package com.avito.android.advert_stats.item;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.advert_stats.item.SelectablePlotItem;
import com.avito.android.db.FavoritesContract;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010#\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b'\u0010(R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010#\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000fR\u001e\u0010&\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b%\u0010\u000f¨\u0006)"}, d2 = {"Lcom/avito/android/advert_stats/item/WeekItem;", "Lcom/avito/android/advert_stats/item/SelectablePlotItem;", "", g.a, "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "status", AuthSource.SEND_ABUSE, "getStringId", "stringId", "", "e", "Ljava/lang/Integer;", "getContacts", "()Ljava/lang/Integer;", "contacts", "", "h", "Z", "getShowLegend", "()Z", "showLegend", "c", "getPeriod", "period", "", "Lcom/avito/android/advert_stats/item/BarItem;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getDays", "()Ljava/util/List;", "days", "f", "getFavorites", FavoritesContract.TABLE_NAME, "d", "getViews", "views", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Z)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class WeekItem implements SelectablePlotItem {
    @NotNull
    public final String a;
    @NotNull
    public final List<BarItem> b;
    @NotNull
    public final String c;
    @Nullable
    public final Integer d;
    @Nullable
    public final Integer e;
    @Nullable
    public final Integer f;
    @Nullable
    public final String g;
    public final boolean h;

    public WeekItem(@NotNull String str, @NotNull List<BarItem> list, @NotNull String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str3, boolean z) {
        a.d1(str, "stringId", list, "days", str2, "period");
        this.a = str;
        this.b = list;
        this.c = str2;
        this.d = num;
        this.e = num2;
        this.f = num3;
        this.g = str3;
        this.h = z;
    }

    @Override // com.avito.android.advert_stats.item.SelectablePlotItem
    @Nullable
    public Integer getContacts() {
        return this.e;
    }

    @NotNull
    public final List<BarItem> getDays() {
        return this.b;
    }

    @Override // com.avito.android.advert_stats.item.SelectablePlotItem
    @Nullable
    public Integer getFavorites() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SelectablePlotItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.advert_stats.item.SelectablePlotItem
    @NotNull
    public String getPeriod() {
        return this.c;
    }

    public final boolean getShowLegend() {
        return this.h;
    }

    @Override // com.avito.android.advert_stats.item.SelectablePlotItem
    @Nullable
    public String getStatus() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Override // com.avito.android.advert_stats.item.SelectablePlotItem
    @Nullable
    public Integer getViews() {
        return this.d;
    }
}
