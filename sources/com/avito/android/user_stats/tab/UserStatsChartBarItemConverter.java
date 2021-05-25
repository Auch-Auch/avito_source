package com.avito.android.user_stats.tab;

import com.avito.android.remote.model.UniversalColor;
import com.avito.android.user_stats.tab.list.items.ChartItem;
import com.avito.user_stats.model.StatsData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J;\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsChartBarItemConverter;", "", "", "Lcom/avito/user_stats/model/StatsData;", "data", "", "selectedIndex", "Lcom/avito/android/remote/model/UniversalColor;", "color", "activeColor", "Lcom/avito/android/user_stats/tab/list/items/ChartItem$BarItem;", "convert", "(Ljava/util/List;ILcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;)Ljava/util/List;", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public interface UserStatsChartBarItemConverter {
    @NotNull
    List<ChartItem.BarItem> convert(@NotNull List<StatsData> list, int i, @NotNull UniversalColor universalColor, @NotNull UniversalColor universalColor2);
}
