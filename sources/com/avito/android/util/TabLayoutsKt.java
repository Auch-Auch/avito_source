package com.avito.android.util;

import android.database.DataSetObserver;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener;
import com.avito.android.ui.adapter.tab.TabAdapter;
import com.avito.android.ui.adapter.tab.TabItemView;
import com.google.android.material.tabs.TabLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\"<\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0004*\u00020\u00002\u0010\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/google/android/material/tabs/TabLayout;", "", AuthSource.SEND_ABUSE, "(Lcom/google/android/material/tabs/TabLayout;)V", "Lcom/avito/android/ui/adapter/tab/TabAdapter;", "adapter", "getAdapter", "(Lcom/google/android/material/tabs/TabLayout;)Lcom/avito/android/ui/adapter/tab/TabAdapter;", "setAdapter", "(Lcom/google/android/material/tabs/TabLayout;Lcom/avito/android/ui/adapter/tab/TabAdapter;)V", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class TabLayoutsKt {
    public static final void a(TabLayout tabLayout) {
        TabItemView tabItemView;
        TabAdapter<?, ?> adapter = getAdapter(tabLayout);
        if (adapter != null) {
            int tabCount = tabLayout.getTabCount();
            for (int count = adapter.getCount(); count < tabCount; count++) {
                try {
                    tabLayout.removeTabAt(count);
                } catch (NullPointerException unused) {
                }
            }
            int count2 = adapter.getCount();
            for (int i = 0; i < count2; i++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                Object obj = null;
                Object tag = tabAt != null ? tabAt.getTag() : null;
                if (tag instanceof TabItemView) {
                    obj = tag;
                }
                TabItemView tabItemView2 = (TabItemView) obj;
                if (tabItemView2 == null || (tabItemView = adapter.updateItem(tabItemView2, i)) == null) {
                    tabItemView = adapter.getItem(i);
                }
                if (!Intrinsics.areEqual(tabItemView, tabItemView2)) {
                    if (tabAt != null) {
                        tabLayout.removeTab(tabAt);
                    }
                    TabLayout.Tab newTab = tabLayout.newTab();
                    Intrinsics.checkNotNullExpressionValue(newTab, "newTab()");
                    newTab.setCustomView(tabItemView.getView());
                    newTab.setTag(tabItemView);
                    tabLayout.addTab(newTab, i);
                }
            }
        }
    }

    @Nullable
    public static final TabAdapter<?, ?> getAdapter(@NotNull TabLayout tabLayout) {
        Intrinsics.checkNotNullParameter(tabLayout, "$this$adapter");
        Object tag = tabLayout.getTag();
        Objects.requireNonNull(tag, "null cannot be cast to non-null type com.avito.android.ui.adapter.tab.TabAdapter<*, *>");
        return (TabAdapter) tag;
    }

    public static final void setAdapter(@NotNull TabLayout tabLayout, @Nullable TabAdapter<?, ?> tabAdapter) {
        Intrinsics.checkNotNullParameter(tabLayout, "$this$adapter");
        tabLayout.setTag(tabAdapter);
        TabAdapter<?, ?> adapter = getAdapter(tabLayout);
        if (adapter != null) {
            adapter.registerDataSetObserver(new DataSetObserver() { // from class: com.avito.android.util.TabLayoutsKt$onAdapterChanged$1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    TabLayoutsKt.a(TabLayout.this);
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    TabLayoutsKt.a(TabLayout.this);
                }
            });
            tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new SimpleOnTabSelectedListener() { // from class: com.avito.android.util.TabLayoutsKt$onAdapterChanged$2
                @Override // com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabSelected(@NotNull TabLayout.Tab tab) {
                    Intrinsics.checkNotNullParameter(tab, "tab");
                    setTabSelected(tab, true);
                }

                @Override // com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabUnselected(@NotNull TabLayout.Tab tab) {
                    Intrinsics.checkNotNullParameter(tab, "tab");
                    setTabSelected(tab, false);
                }

                public final void setTabSelected(@NotNull TabLayout.Tab tab, boolean z) {
                    Intrinsics.checkNotNullParameter(tab, "tab");
                    Object tag = tab.getTag();
                    if (!(tag instanceof TabItemView)) {
                        tag = null;
                    }
                    TabItemView tabItemView = (TabItemView) tag;
                    if (tabItemView != null) {
                        tabItemView.setSelected(tab.getPosition(), TabAdapter.this.getCount(), z);
                    }
                }
            });
            tabLayout.removeAllTabs();
            a(tabLayout);
        }
    }
}
