package com.avito.android.user_stats.tab;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.user_stats.UserStatsResourcesProvider;
import com.avito.android.user_stats.tab.list.items.ChartItem;
import com.avito.user_stats.model.StatsData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J;\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsChartBarItemConverterImpl;", "Lcom/avito/android/user_stats/tab/UserStatsChartBarItemConverter;", "", "Lcom/avito/user_stats/model/StatsData;", "data", "", "selectedIndex", "Lcom/avito/android/remote/model/UniversalColor;", "color", "activeColor", "Lcom/avito/android/user_stats/tab/list/items/ChartItem$BarItem;", "convert", "(Ljava/util/List;ILcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;)Ljava/util/List;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/UniversalColor;", "emptyBarColor", "Lcom/avito/android/user_stats/UserStatsResourcesProvider;", "userStatsResourcesProvider", "<init>", "(Lcom/avito/android/user_stats/UserStatsResourcesProvider;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsChartBarItemConverterImpl implements UserStatsChartBarItemConverter {
    public final UniversalColor a;

    @Inject
    public UserStatsChartBarItemConverterImpl(@NotNull UserStatsResourcesProvider userStatsResourcesProvider) {
        Intrinsics.checkNotNullParameter(userStatsResourcesProvider, "userStatsResourcesProvider");
        this.a = userStatsResourcesProvider.getEmptyBarColor();
    }

    @Override // com.avito.android.user_stats.tab.UserStatsChartBarItemConverter
    @NotNull
    public List<ChartItem.BarItem> convert(@NotNull List<StatsData> list, int i, @NotNull UniversalColor universalColor, @NotNull UniversalColor universalColor2) {
        Intrinsics.checkNotNullParameter(list, "data");
        Intrinsics.checkNotNullParameter(universalColor, "color");
        Intrinsics.checkNotNullParameter(universalColor2, "activeColor");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(it.next().getValue()));
        }
        Float maxOrNull = CollectionsKt___CollectionsKt.m358maxOrNull((Iterable<Float>) arrayList);
        float f = 0.0f;
        float floatValue = maxOrNull != null ? maxOrNull.floatValue() : 0.0f;
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list, 10));
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            boolean z = i2 == i;
            arrayList2.add(new ChartItem.BarItem(String.valueOf(i2), i2, t2.getValue() / floatValue, t2.getLabel(), z, t2.getValue() == f ? this.a : z ? universalColor2 : universalColor));
            i2 = i3;
            f = 0.0f;
        }
        return arrayList2;
    }
}
