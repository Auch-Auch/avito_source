package com.avito.android.user_stats.tab;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_stats.tab.list.items.ChartItem;
import com.avito.android.user_stats.tab.list.items.DescriptionItem;
import com.avito.android.user_stats.tab.list.items.HeaderItem;
import com.avito.android.user_stats.tab.list.items.SpaceItem;
import com.avito.android.user_stats.tab.list.items.TwoColumnsItem;
import com.avito.android.util.RandomKeyProvider;
import com.avito.conveyor_item.Item;
import com.avito.user_stats.model.ColumnsTemplate;
import com.avito.user_stats.model.DescriptionTemplate;
import com.avito.user_stats.model.HeaderTemplate;
import com.avito.user_stats.model.InfographicsTemplate;
import com.avito.user_stats.model.SpaceTemplate;
import com.avito.user_stats.model.StatsData;
import com.avito.user_stats.model.TemplateUnit;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsTemplateItemConverterImpl;", "Lcom/avito/android/user_stats/tab/UserStatsTemplateItemConverter;", "", "Lcom/avito/user_stats/model/TemplateUnit;", "template", "Lcom/avito/user_stats/model/StatsData;", "chartData", "", "selectedBarIndex", "Lcom/avito/conveyor_item/Item;", "convert", "(Ljava/util/List;Ljava/util/List;I)Ljava/util/List;", "Lcom/avito/android/util/RandomKeyProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/RandomKeyProvider;", "randomKeyProvider", "Lcom/avito/android/user_stats/tab/UserStatsChartBarItemConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/user_stats/tab/UserStatsChartBarItemConverter;", "chartBarItemConverter", "<init>", "(Lcom/avito/android/util/RandomKeyProvider;Lcom/avito/android/user_stats/tab/UserStatsChartBarItemConverter;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsTemplateItemConverterImpl implements UserStatsTemplateItemConverter {
    public final RandomKeyProvider a;
    public final UserStatsChartBarItemConverter b;

    @Inject
    public UserStatsTemplateItemConverterImpl(@NotNull RandomKeyProvider randomKeyProvider, @NotNull UserStatsChartBarItemConverter userStatsChartBarItemConverter) {
        Intrinsics.checkNotNullParameter(randomKeyProvider, "randomKeyProvider");
        Intrinsics.checkNotNullParameter(userStatsChartBarItemConverter, "chartBarItemConverter");
        this.a = randomKeyProvider;
        this.b = userStatsChartBarItemConverter;
    }

    @Override // com.avito.android.user_stats.tab.UserStatsTemplateItemConverter
    @NotNull
    public List<Item> convert(@NotNull List<? extends TemplateUnit> list, @NotNull List<StatsData> list2, int i) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "template");
        Intrinsics.checkNotNullParameter(list2, "chartData");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t instanceof DescriptionTemplate) {
                T t2 = t;
                obj = new DescriptionItem(this.a.generateKey(), t2.getDescription(), t2.getFromType());
            } else if (t instanceof HeaderTemplate) {
                T t3 = t;
                obj = new HeaderItem(this.a.generateKey(), t3.getTitle(), t3.getValue(), t3.getRelativeValue());
            } else if (t instanceof SpaceTemplate) {
                obj = new SpaceItem(this.a.generateKey(), t.getValue());
            } else if (t instanceof ColumnsTemplate) {
                T t4 = t;
                obj = new TwoColumnsItem(this.a.generateKey(), t4.getLeft(), t4.getRight());
            } else if (t instanceof InfographicsTemplate) {
                T t5 = t;
                obj = new ChartItem("chart_id", this.b.convert(list2, i, t5.getColor(), t5.getActiveColor()));
            } else {
                obj = null;
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
