package com.avito.android.publish_limits_info.history;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.publish_limits_info.R;
import com.avito.android.publish_limits_info.history.tab.HistoryTabItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.adapter.tab.TabAdapter;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.TabLayoutsKt;
import com.google.android.material.tabs.TabLayout;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b.\u0010/J\u001f\u0010\u0007\u001a\u00020\u00062\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u00060"}, d2 = {"Lcom/avito/android/publish_limits_info/history/PublishAdvertsHistoryHostView;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "Lcom/avito/android/publish_limits_info/history/tab/HistoryTabItem;", "Lcom/avito/android/publish_limits_info/history/Tabs;", "tabs", "", "updateTabs", "(Ljava/util/List;)V", "", VKApiConst.POSITION, "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/FragmentManager;", "supportFragmentManager", "Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "e", "Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "tabsAdapter", "Landroidx/viewpager/widget/ViewPager;", "c", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Lcom/avito/android/publish_limits_info/history/TabPagerAdapter;", "d", "Lcom/avito/android/publish_limits_info/history/TabPagerAdapter;", "pagerAdapter", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabsDataProvider", "Lcom/google/android/material/tabs/TabLayout;", AuthSource.BOOKING_ORDER, "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Landroidx/fragment/app/FragmentManager;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class PublishAdvertsHistoryHostView implements ViewPager.OnPageChangeListener {
    public final TabsDataProvider<HistoryTabItem> a;
    public final TabLayout b;
    public final ViewPager c;
    public final TabPagerAdapter d;
    public final TabLayoutAdapter<HistoryTabItem> e;
    public final FragmentManager f;

    public PublishAdvertsHistoryHostView(@NotNull View view, @NotNull FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(fragmentManager, "supportFragmentManager");
        this.f = fragmentManager;
        TabsDataProvider<HistoryTabItem> tabsDataProvider = new TabsDataProvider<>();
        this.a = tabsDataProvider;
        View findViewById = view.findViewById(R.id.tabs);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.google.android.material.tabs.TabLayout");
        TabLayout tabLayout = (TabLayout) findViewById;
        this.b = tabLayout;
        View findViewById2 = view.findViewById(R.id.pager);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
        ViewPager viewPager = (ViewPager) findViewById2;
        this.c = viewPager;
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(fragmentManager, tabsDataProvider);
        this.d = tabPagerAdapter;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        TabLayoutAdapter<HistoryTabItem> tabLayoutAdapter = new TabLayoutAdapter<>(tabsDataProvider, context, com.avito.android.ui_components.R.layout.tab_shortcut_with_static_counter);
        this.e = tabLayoutAdapter;
        TabLayoutsKt.setAdapter(tabLayout, tabLayoutAdapter);
        viewPager.setAdapter(tabPagerAdapter);
        viewPager.addOnPageChangeListener(this);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    public final void updateTabs(@NotNull List<HistoryTabItem> list) {
        Intrinsics.checkNotNullParameter(list, "tabs");
        this.a.updateItems(list);
        PagerAdapter adapter = this.c.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        TabAdapter<?, ?> adapter2 = TabLayoutsKt.getAdapter(this.b);
        if (adapter2 != null) {
            adapter2.notifyDataSetChanged();
        }
    }
}
