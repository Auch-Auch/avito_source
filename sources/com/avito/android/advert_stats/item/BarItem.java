package com.avito.android.advert_stats.item;

import a2.g.r.g;
import com.avito.android.advert_stats.item.SelectablePlotItem;
import com.avito.android.db.FavoritesContract;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u00100\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u00106\u001a\u000201\u0012\b\b\u0002\u0010#\u001a\u00020\u001c\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020%0$\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b7\u00108R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001f\u0010*\u001a\b\u0012\u0004\u0012\u00020%0$8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001e\u0010-\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001e\u00100\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010\u0012\u001a\u0004\b/\u0010\u0014R\u0019\u00106\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/avito/android/advert_stats/item/BarItem;", "Lcom/avito/android/advert_stats/item/SelectablePlotItem;", "", "f", "Ljava/lang/String;", "getPeriod", "()Ljava/lang/String;", "period", AuthSource.SEND_ABUSE, "getStringId", "stringId", "", "e", "I", "getIndex", "()I", FirebaseAnalytics.Param.INDEX, "h", "Ljava/lang/Integer;", "getFavorites", "()Ljava/lang/Integer;", FavoritesContract.TABLE_NAME, g.a, "getContacts", "contacts", "i", "getVasViews", "vasViews", "Lcom/avito/android/advert_stats/item/BarState;", "d", "Lcom/avito/android/advert_stats/item/BarState;", "getState", "()Lcom/avito/android/advert_stats/item/BarState;", "setState", "(Lcom/avito/android/advert_stats/item/BarState;)V", "state", "", "Lcom/avito/android/advert_stats/item/VasInfo;", "j", "Ljava/util/List;", "getVasList", "()Ljava/util/List;", "vasList", "k", "getStatus", "status", AuthSource.BOOKING_ORDER, "getViews", "views", "", "c", "F", "getCoefficient", "()F", "coefficient", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;FLcom/avito/android/advert_stats/item/BarState;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class BarItem implements SelectablePlotItem {
    @NotNull
    public final String a;
    @Nullable
    public final Integer b;
    public final float c;
    @NotNull
    public BarState d;
    public final int e;
    @NotNull
    public final String f;
    @Nullable
    public final Integer g;
    @Nullable
    public final Integer h;
    @Nullable
    public final Integer i;
    @NotNull
    public final List<VasInfo> j;
    @Nullable
    public final String k;

    public BarItem(@NotNull String str, @Nullable Integer num, float f2, @NotNull BarState barState, int i2, @NotNull String str2, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @NotNull List<VasInfo> list, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(barState, "state");
        Intrinsics.checkNotNullParameter(str2, "period");
        Intrinsics.checkNotNullParameter(list, "vasList");
        this.a = str;
        this.b = num;
        this.c = f2;
        this.d = barState;
        this.e = i2;
        this.f = str2;
        this.g = num2;
        this.h = num3;
        this.i = num4;
        this.j = list;
        this.k = str3;
    }

    public final float getCoefficient() {
        return this.c;
    }

    @Override // com.avito.android.advert_stats.item.SelectablePlotItem
    @Nullable
    public Integer getContacts() {
        return this.g;
    }

    @Override // com.avito.android.advert_stats.item.SelectablePlotItem
    @Nullable
    public Integer getFavorites() {
        return this.h;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SelectablePlotItem.DefaultImpls.getId(this);
    }

    public final int getIndex() {
        return this.e;
    }

    @Override // com.avito.android.advert_stats.item.SelectablePlotItem
    @NotNull
    public String getPeriod() {
        return this.f;
    }

    @NotNull
    public final BarState getState() {
        return this.d;
    }

    @Override // com.avito.android.advert_stats.item.SelectablePlotItem
    @Nullable
    public String getStatus() {
        return this.k;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final List<VasInfo> getVasList() {
        return this.j;
    }

    @Nullable
    public final Integer getVasViews() {
        return this.i;
    }

    @Override // com.avito.android.advert_stats.item.SelectablePlotItem
    @Nullable
    public Integer getViews() {
        return this.b;
    }

    public final void setState(@NotNull BarState barState) {
        Intrinsics.checkNotNullParameter(barState, "<set-?>");
        this.d = barState;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BarItem(String str, Integer num, float f2, BarState barState, int i2, String str2, Integer num2, Integer num3, Integer num4, List list, String str3, int i3, j jVar) {
        this(str, num, f2, (i3 & 8) != 0 ? BarState.DEFAULT : barState, i2, str2, num2, num3, num4, list, str3);
    }
}
