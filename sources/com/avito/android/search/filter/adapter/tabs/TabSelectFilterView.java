package com.avito.android.search.filter.adapter.tabs;

import com.avito.android.items.SelectableItem;
import com.avito.android.ui.adapter.tab.TabItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/search/filter/adapter/tabs/TabSelectFilterView;", "Lcom/avito/android/ui/adapter/tab/TabItemView;", "Lcom/avito/android/items/SelectableItem;", "item", "", "bind", "(Lcom/avito/android/items/SelectableItem;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public interface TabSelectFilterView extends TabItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void setSelected(@NotNull TabSelectFilterView tabSelectFilterView, int i, int i2, boolean z) {
            TabItemView.DefaultImpls.setSelected(tabSelectFilterView, i, i2, z);
        }

        public static void setSelected(@NotNull TabSelectFilterView tabSelectFilterView, boolean z) {
            TabItemView.DefaultImpls.setSelected(tabSelectFilterView, z);
        }
    }

    void bind(@NotNull SelectableItem selectableItem);
}
