package com.avito.android.search.filter.adapter.tabs;

import android.view.View;
import android.widget.TextView;
import com.avito.android.items.SelectableItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.filter.adapter.tabs.TabSelectFilterView;
import com.avito.android.ui_components.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u000e\u001a\u00020\u00078\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/search/filter/adapter/tabs/TabSelectFilterViewImpl;", "Lcom/avito/android/search/filter/adapter/tabs/TabSelectFilterView;", "Lcom/avito/android/items/SelectableItem;", "item", "", "bind", "(Lcom/avito/android/items/SelectableItem;)V", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "view", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "title", "<init>", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class TabSelectFilterViewImpl implements TabSelectFilterView {
    public final TextView a;
    @NotNull
    public View b;

    public TabSelectFilterViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.b = view;
        View findViewById = getView().findViewById(R.id.tab_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
    }

    @Override // com.avito.android.search.filter.adapter.tabs.TabSelectFilterView
    public void bind(@NotNull SelectableItem selectableItem) {
        Intrinsics.checkNotNullParameter(selectableItem, "item");
        this.a.setText(selectableItem.getTitle());
    }

    @Override // com.avito.android.ui.adapter.tab.TabItemView
    @NotNull
    public View getView() {
        return this.b;
    }

    @Override // com.avito.android.ui.adapter.tab.TabItemView
    public void setSelected(int i, int i2, boolean z) {
        TabSelectFilterView.DefaultImpls.setSelected(this, i, i2, z);
    }

    @Override // com.avito.android.ui.adapter.tab.TabItemView
    public void setView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.b = view;
    }

    @Override // com.avito.android.ui.adapter.tab.TabItemView
    public void setSelected(boolean z) {
        TabSelectFilterView.DefaultImpls.setSelected(this, z);
    }
}
