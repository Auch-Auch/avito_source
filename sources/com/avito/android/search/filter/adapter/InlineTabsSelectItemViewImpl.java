package com.avito.android.search.filter.adapter;

import android.content.Context;
import android.view.View;
import com.avito.android.items.SelectableItem;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.search.filter.R;
import com.avito.android.search.filter.adapter.InlineTabsSelectItemView;
import com.avito.android.search.filter.adapter.tabs.ShortFilterTabLayoutAdapter;
import com.avito.android.serp.BaseSerpViewHolder;
import com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.TabLayoutsKt;
import com.avito.konveyor.data_source.ListDataSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J;\u0010\n\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/avito/android/search/filter/adapter/InlineTabsSelectItemViewImpl;", "Lcom/avito/android/search/filter/adapter/InlineTabsSelectItemView;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "", "Lcom/avito/android/items/SelectableItem;", ResidentialComplexModuleKt.VALUES, "selectedValue", "Lkotlin/Function1;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValues", "(Ljava/util/List;Lcom/avito/android/items/SelectableItem;Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/search/filter/adapter/tabs/ShortFilterTabLayoutAdapter;", "t", "Lcom/avito/android/search/filter/adapter/tabs/ShortFilterTabLayoutAdapter;", "tabAdapter", "Lcom/google/android/material/tabs/TabLayout;", "kotlin.jvm.PlatformType", "s", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class InlineTabsSelectItemViewImpl extends BaseSerpViewHolder implements InlineTabsSelectItemView {
    public final TabLayout s;
    public final ShortFilterTabLayoutAdapter t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InlineTabsSelectItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs_filter_select);
        this.s = tabLayout;
        TabsDataProvider tabsDataProvider = new TabsDataProvider();
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        ShortFilterTabLayoutAdapter shortFilterTabLayoutAdapter = new ShortFilterTabLayoutAdapter(tabsDataProvider, context);
        this.t = shortFilterTabLayoutAdapter;
        Intrinsics.checkNotNullExpressionValue(tabLayout, "tabLayout");
        TabLayoutsKt.setAdapter(tabLayout, shortFilterTabLayoutAdapter);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        InlineTabsSelectItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.search.filter.adapter.InlineTabsSelectItemView
    public void setValues(@NotNull List<SelectableItem> list, @Nullable SelectableItem selectableItem, @NotNull Function1<? super SelectableItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.clearOnTabSelectedListeners();
        this.t.getTabs().onDataSourceChanged(new ListDataSource(list));
        this.t.notifyDataSetChanged();
        if (!list.isEmpty()) {
            TabLayout.Tab tabAt = this.s.getTabAt(selectableItem != null ? list.indexOf(selectableItem) : 0);
            if (tabAt != null) {
                tabAt.select();
            }
            this.s.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new SimpleOnTabSelectedListener(function1, list) { // from class: com.avito.android.search.filter.adapter.InlineTabsSelectItemViewImpl$setValues$1
                public final /* synthetic */ Function1 a;
                public final /* synthetic */ List b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabSelected(@NotNull TabLayout.Tab tab) {
                    Intrinsics.checkNotNullParameter(tab, "tab");
                    super.onTabSelected(tab);
                    if (tab.getPosition() != -1) {
                        this.a.invoke(this.b.get(tab.getPosition()));
                    }
                }
            });
        }
    }
}
