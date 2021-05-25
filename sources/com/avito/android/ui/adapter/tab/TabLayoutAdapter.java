package com.avito.android.ui.adapter.tab;

import android.content.Context;
import android.view.View;
import com.avito.android.ui.adapter.tab.BaseTabItem;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003B\u001d\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/avito/android/ui/adapter/tab/TabLayoutAdapter;", "Lcom/avito/android/ui/adapter/tab/BaseTabItem;", "T", "Lcom/avito/android/ui/adapter/tab/TabAdapter;", "Lcom/avito/android/ui/adapter/tab/ShortcutTabView;", "Landroid/view/View;", "view", "Lcom/avito/android/ui/adapter/tab/ShortcutTabViewImpl;", "createTabItemView", "(Landroid/view/View;)Lcom/avito/android/ui/adapter/tab/ShortcutTabViewImpl;", "tabItemView", "item", "", "bind", "(Lcom/avito/android/ui/adapter/tab/ShortcutTabView;Lcom/avito/android/ui/adapter/tab/BaseTabItem;)V", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabs", "Landroid/content/Context;", "context", "<init>", "(Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Landroid/content/Context;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class TabLayoutAdapter<T extends BaseTabItem> extends TabAdapter<T, ShortcutTabView> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabLayoutAdapter(@NotNull TabsDataProvider<T> tabsDataProvider, @NotNull Context context) {
        super(tabsDataProvider, context, R.layout.tab_with_counter);
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabs");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.android.ui.adapter.tab.TabItemView, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.ui.adapter.tab.TabLayoutAdapter<T extends com.avito.android.ui.adapter.tab.BaseTabItem> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.ui.adapter.tab.TabAdapter
    public /* bridge */ /* synthetic */ void bind(ShortcutTabView shortcutTabView, Object obj) {
        bind(shortcutTabView, (ShortcutTabView) ((BaseTabItem) obj));
    }

    public void bind(@NotNull ShortcutTabView shortcutTabView, @NotNull T t) {
        Intrinsics.checkNotNullParameter(shortcutTabView, "tabItemView");
        Intrinsics.checkNotNullParameter(t, "item");
        shortcutTabView.bind(t.getTitle(), t.getCount());
    }

    /* Return type fixed from 'com.avito.android.ui.adapter.tab.ShortcutTabViewImpl' to match base method */
    @Override // com.avito.android.ui.adapter.tab.TabAdapter
    @NotNull
    public ShortcutTabView createTabItemView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return new ShortcutTabViewImpl(view);
    }
}
