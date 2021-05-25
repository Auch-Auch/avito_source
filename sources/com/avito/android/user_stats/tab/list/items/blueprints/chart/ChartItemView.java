package com.avito.android.user_stats.tab.list.items.blueprints.chart;

import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemView;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "Lcom/avito/conveyor_item/Item;", "items", "", "setItems", "(Ljava/util/List;)V", "", "selectedColumnIndex", "scrollIfNeeded", "(I)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public interface ChartItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ChartItemView chartItemView) {
            ItemView.DefaultImpls.onUnbind(chartItemView);
        }
    }

    void scrollIfNeeded(int i);

    void setItems(@NotNull List<? extends Item> list);
}
