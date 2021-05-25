package com.avito.android.brandspace.items.categories;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.design.widget.tab.Tab;
import com.avito.android.design.widget.tab.TabView;
import com.avito.android.design.widget.tab.TabViewImpl;
import com.avito.android.ui.adapter.tab.TabAdapter;
import com.avito.android.ui.adapter.tab.TabItemView;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003B\u001d\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/avito/android/brandspace/items/categories/BrandspaceTabLayoutAdapter;", "Lcom/avito/android/design/widget/tab/Tab;", "T", "Lcom/avito/android/ui/adapter/tab/TabAdapter;", "Lcom/avito/android/design/widget/tab/TabView;", "Landroid/view/View;", "view", "Lcom/avito/android/design/widget/tab/TabViewImpl;", "createTabItemView", "(Landroid/view/View;)Lcom/avito/android/design/widget/tab/TabViewImpl;", "tabItemView", "item", "", "bind", "(Lcom/avito/android/design/widget/tab/TabView;Lcom/avito/android/design/widget/tab/Tab;)V", "Lcom/avito/android/ui/adapter/tab/TabItemView;", "", VKApiConst.POSITION, "updateItem", "(Lcom/avito/android/ui/adapter/tab/TabItemView;I)Lcom/avito/android/ui/adapter/tab/TabItemView;", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabs", "Landroid/content/Context;", "context", "<init>", "(Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Landroid/content/Context;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceTabLayoutAdapter<T extends Tab> extends TabAdapter<T, TabView> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrandspaceTabLayoutAdapter(@NotNull TabsDataProvider<T> tabsDataProvider, @NotNull Context context) {
        super(tabsDataProvider, context, R.layout.tab_shortcut);
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabs");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.android.ui.adapter.tab.TabItemView, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.brandspace.items.categories.BrandspaceTabLayoutAdapter<T extends com.avito.android.design.widget.tab.Tab> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.ui.adapter.tab.TabAdapter
    public /* bridge */ /* synthetic */ void bind(TabView tabView, Object obj) {
        bind(tabView, (TabView) ((Tab) obj));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.avito.android.brandspace.items.categories.BrandspaceTabLayoutAdapter<T extends com.avito.android.design.widget.tab.Tab> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.ui.adapter.tab.TabAdapter
    @NotNull
    public TabItemView updateItem(@NotNull TabItemView tabItemView, int i) {
        Intrinsics.checkNotNullParameter(tabItemView, "view");
        if (!(tabItemView instanceof TabViewImpl)) {
            tabItemView = null;
        }
        TabViewImpl tabViewImpl = (TabViewImpl) tabItemView;
        if (tabViewImpl == null) {
            return getItem(i);
        }
        bind((TabView) tabViewImpl, (TabViewImpl) ((Tab) getTabs().getItem(i)));
        return tabViewImpl;
    }

    public void bind(@NotNull TabView tabView, @NotNull T t) {
        Intrinsics.checkNotNullParameter(tabView, "tabItemView");
        Intrinsics.checkNotNullParameter(t, "item");
        tabView.bind(t.getTitle(), t.getLabel());
    }

    /* Return type fixed from 'com.avito.android.design.widget.tab.TabViewImpl' to match base method */
    @Override // com.avito.android.ui.adapter.tab.TabAdapter
    @NotNull
    public TabView createTabItemView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        TabViewImpl tabViewImpl = new TabViewImpl(view);
        Drawable drawable = Views.getDrawable(view, com.avito.android.brandspace.R.drawable.brandspace_tab_bubble_selector);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.tab_bg);
        if (viewGroup != null) {
            viewGroup.setBackground(drawable);
        }
        return tabViewImpl;
    }
}
