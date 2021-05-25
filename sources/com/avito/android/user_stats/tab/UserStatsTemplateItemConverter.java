package com.avito.android.user_stats.tab;

import com.avito.conveyor_item.Item;
import com.avito.user_stats.model.StatsData;
import com.avito.user_stats.model.TemplateUnit;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J9\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsTemplateItemConverter;", "", "", "Lcom/avito/user_stats/model/TemplateUnit;", "template", "Lcom/avito/user_stats/model/StatsData;", "chartData", "", "selectedBarIndex", "Lcom/avito/conveyor_item/Item;", "convert", "(Ljava/util/List;Ljava/util/List;I)Ljava/util/List;", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public interface UserStatsTemplateItemConverter {
    @NotNull
    List<Item> convert(@NotNull List<? extends TemplateUnit> list, @NotNull List<StatsData> list2, int i);
}
