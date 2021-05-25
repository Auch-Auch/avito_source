package com.avito.android.advert_stats.item;

import com.avito.konveyor.blueprint.ItemView;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/advert_stats/item/WeekItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "Lcom/avito/android/advert_stats/item/BarItem;", "items", "", "setItems", "(Ljava/util/List;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public interface WeekItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull WeekItemView weekItemView) {
            ItemView.DefaultImpls.onUnbind(weekItemView);
        }
    }

    void setItems(@NotNull List<BarItem> list);
}
