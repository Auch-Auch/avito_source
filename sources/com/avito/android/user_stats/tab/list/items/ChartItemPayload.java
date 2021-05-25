package com.avito.android.user_stats.tab.list.items;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_stats.tab.list.items.ChartItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/ChartItemPayload;", "", "", "Lcom/avito/android/user_stats/tab/list/items/ChartItem$BarItem;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "<init>", "(Ljava/util/List;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class ChartItemPayload {
    @NotNull
    public final List<ChartItem.BarItem> a;

    public ChartItemPayload(@NotNull List<ChartItem.BarItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.a = list;
    }

    @NotNull
    public final List<ChartItem.BarItem> getItems() {
        return this.a;
    }
}
