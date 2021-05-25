package com.avito.android.tariff.edit_info.item.tabs;

import android.content.Context;
import android.view.View;
import com.avito.android.tariff.R;
import com.avito.android.ui.adapter.tab.TabAdapter;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.text.AttributedTextFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTabAdapter;", "Lcom/avito/android/ui/adapter/tab/TabAdapter;", "Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTab;", "Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTabView;", "Landroid/view/View;", "view", "createTabItemView", "(Landroid/view/View;)Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTabView;", "tabItemView", "item", "", "bind", "(Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTabView;Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTab;)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "e", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabs", "Landroid/content/Context;", "context", "<init>", "(Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Landroid/content/Context;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class PeriodTabAdapter extends TabAdapter<PeriodTab, PeriodTabView> {
    public final AttributedTextFormatter e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeriodTabAdapter(@NotNull TabsDataProvider<PeriodTab> tabsDataProvider, @NotNull Context context, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(tabsDataProvider, context, R.layout.period_tab);
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabs");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.e = attributedTextFormatter;
    }

    public void bind(@NotNull PeriodTabView periodTabView, @NotNull PeriodTab periodTab) {
        Intrinsics.checkNotNullParameter(periodTabView, "tabItemView");
        Intrinsics.checkNotNullParameter(periodTab, "item");
        periodTabView.bind(periodTab.getAttributedTitle(), periodTab.getHasRedBadge());
    }

    @Override // com.avito.android.ui.adapter.tab.TabAdapter
    @NotNull
    public PeriodTabView createTabItemView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return new PeriodTabViewImpl(view, this.e);
    }
}
