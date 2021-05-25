package com.avito.android.brandspace.items.categories;

import android.content.Context;
import android.view.View;
import com.avito.android.brandspace.R;
import com.avito.android.design.widget.tab.CommonTab;
import com.avito.android.design.widget.tab.Tab;
import com.avito.android.recycler.base.DestroyableViewHolder;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.TabLayoutsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.data_source.ListDataSource;
import com.google.android.material.tabs.TabLayout;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J/\u0010\f\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/avito/android/brandspace/items/categories/CategoriesItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/brandspace/items/categories/CategoriesItemView;", "Lcom/avito/android/recycler/base/DestroyableViewHolder;", "", "", "categories", "", "selectedIndex", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "tabListener", "", "bind", "(Ljava/util/List;ILcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;)V", "onUnbind", "()V", "destroy", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/design/widget/tab/Tab;", "s", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabsDataProvider", "com/avito/android/brandspace/items/categories/CategoriesItemViewImpl$defaultTabLayoutListener$1", VKApiConst.VERSION, "Lcom/avito/android/brandspace/items/categories/CategoriesItemViewImpl$defaultTabLayoutListener$1;", "defaultTabLayoutListener", "u", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout;", "t", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class CategoriesItemViewImpl extends BaseViewHolder implements CategoriesItemView, DestroyableViewHolder {
    public final TabsDataProvider<Tab> s = new TabsDataProvider<>();
    public final TabLayout t;
    public TabLayout.OnTabSelectedListener u;
    public final CategoriesItemViewImpl$defaultTabLayoutListener$1 v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CategoriesItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.tabs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tabs)");
        this.t = (TabLayout) findViewById;
        this.v = new CategoriesItemViewImpl$defaultTabLayoutListener$1(this);
    }

    @Override // com.avito.android.brandspace.items.categories.CategoriesItemView
    public void bind(@NotNull List<String> list, int i, @Nullable TabLayout.OnTabSelectedListener onTabSelectedListener) {
        Intrinsics.checkNotNullParameter(list, "categories");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new CommonTab(it.next(), null, 2, null));
        }
        this.s.onDataSourceChanged(new ListDataSource(arrayList));
        TabLayout tabLayout = this.t;
        TabsDataProvider<Tab> tabsDataProvider = this.s;
        Context context = tabLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "tabLayout.context");
        TabLayoutsKt.setAdapter(tabLayout, new BrandspaceTabLayoutAdapter(tabsDataProvider, context));
        this.t.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) this.v);
        TabLayout.Tab tabAt = this.t.getTabAt(i);
        if (tabAt != null) {
            tabAt.select();
        }
        this.u = onTabSelectedListener;
    }

    @Override // com.avito.android.recycler.base.DestroyableViewHolder
    public void destroy() {
        this.u = null;
        this.t.clearOnTabSelectedListeners();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.u = null;
        this.t.clearOnTabSelectedListeners();
    }
}
