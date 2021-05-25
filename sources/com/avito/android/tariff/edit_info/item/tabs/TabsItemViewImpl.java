package com.avito.android.tariff.edit_info.item.tabs;

import android.content.Context;
import android.view.View;
import com.avito.android.tariff.R;
import com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.TabLayoutsKt;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.data_source.ListDataSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.tabs.TabLayout;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u00020\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemView;", "", "Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTab;", "tabs", "", "bindTabs", "(Ljava/util/List;)V", "", VKApiConst.POSITION, "setSelectedTab", "(I)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnTabSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "unbindListener", "()V", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "t", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "dataProvider", VKApiConst.VERSION, "Lkotlin/jvm/functions/Function1;", "Lcom/google/android/material/tabs/TabLayout;", "s", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTabAdapter;", "u", "Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTabAdapter;", "adapter", "Landroid/view/View;", "view", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TabsItemViewImpl extends BaseViewHolder implements TabsItemView {
    public final TabLayout s;
    public final TabsDataProvider<PeriodTab> t;
    public final PeriodTabAdapter u;
    public Function1<? super Integer, Unit> v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabsItemViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        View findViewById = view.findViewById(R.id.tabs_item);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tabs_item)");
        TabLayout tabLayout = (TabLayout) findViewById;
        this.s = tabLayout;
        TabsDataProvider<PeriodTab> tabsDataProvider = new TabsDataProvider<>();
        this.t = tabsDataProvider;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        PeriodTabAdapter periodTabAdapter = new PeriodTabAdapter(tabsDataProvider, context, attributedTextFormatter);
        this.u = periodTabAdapter;
        TabLayoutsKt.setAdapter(tabLayout, periodTabAdapter);
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new SimpleOnTabSelectedListener(this) { // from class: com.avito.android.tariff.edit_info.item.tabs.TabsItemViewImpl.1
            public final /* synthetic */ TabsItemViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(@NotNull TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                Function1 function1 = this.a.v;
                if (function1 != null) {
                    Unit unit = (Unit) function1.invoke(Integer.valueOf(tab.getPosition()));
                }
            }
        });
    }

    @Override // com.avito.android.tariff.edit_info.item.tabs.TabsItemView
    public void bindTabs(@NotNull List<PeriodTab> list) {
        Intrinsics.checkNotNullParameter(list, "tabs");
        this.t.onDataSourceChanged(new ListDataSource(list));
        this.u.notifyDataSetChanged();
    }

    @Override // com.avito.android.tariff.edit_info.item.tabs.TabsItemView
    public void setOnTabSelectedListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.v = function1;
    }

    @Override // com.avito.android.tariff.edit_info.item.tabs.TabsItemView
    public void setSelectedTab(int i) {
        TabLayout.Tab tabAt = this.s.getTabAt(i);
        if (tabAt != null) {
            tabAt.select();
        }
    }

    @Override // com.avito.android.tariff.edit_info.item.tabs.TabsItemView
    public void unbindListener() {
        this.v = null;
    }
}
