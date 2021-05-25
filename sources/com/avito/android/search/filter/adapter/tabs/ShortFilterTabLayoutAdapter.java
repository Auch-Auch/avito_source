package com.avito.android.search.filter.adapter.tabs;

import android.content.Context;
import android.view.View;
import com.avito.android.items.SelectableItem;
import com.avito.android.ui.adapter.tab.TabAdapter;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/search/filter/adapter/tabs/ShortFilterTabLayoutAdapter;", "Lcom/avito/android/ui/adapter/tab/TabAdapter;", "Lcom/avito/android/items/SelectableItem;", "Lcom/avito/android/search/filter/adapter/tabs/TabSelectFilterView;", "Landroid/view/View;", "view", "Lcom/avito/android/search/filter/adapter/tabs/TabSelectFilterViewImpl;", "createTabItemView", "(Landroid/view/View;)Lcom/avito/android/search/filter/adapter/tabs/TabSelectFilterViewImpl;", "tabItemView", "item", "", "bind", "(Lcom/avito/android/search/filter/adapter/tabs/TabSelectFilterView;Lcom/avito/android/items/SelectableItem;)V", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabs", "Landroid/content/Context;", "context", "<init>", "(Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Landroid/content/Context;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class ShortFilterTabLayoutAdapter extends TabAdapter<SelectableItem, TabSelectFilterView> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShortFilterTabLayoutAdapter(@NotNull TabsDataProvider<SelectableItem> tabsDataProvider, @NotNull Context context) {
        super(tabsDataProvider, context, R.layout.tab_select_filter);
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabs");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void bind(@NotNull TabSelectFilterView tabSelectFilterView, @NotNull SelectableItem selectableItem) {
        Intrinsics.checkNotNullParameter(tabSelectFilterView, "tabItemView");
        Intrinsics.checkNotNullParameter(selectableItem, "item");
        tabSelectFilterView.bind(selectableItem);
    }

    /* Return type fixed from 'com.avito.android.search.filter.adapter.tabs.TabSelectFilterViewImpl' to match base method */
    @Override // com.avito.android.ui.adapter.tab.TabAdapter
    @NotNull
    public TabSelectFilterView createTabItemView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return new TabSelectFilterViewImpl(view);
    }
}
