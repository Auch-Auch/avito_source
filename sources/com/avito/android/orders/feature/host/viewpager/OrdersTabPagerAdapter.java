package com.avito.android.orders.feature.host.viewpager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.avito.android.orders.feature.list.OrdersListFragment;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/avito/android/orders/feature/host/viewpager/OrdersTabPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", VKApiConst.POSITION, "Landroidx/fragment/app/Fragment;", "getItem", "(I)Landroidx/fragment/app/Fragment;", "getCount", "()I", "", "getPageTitle", "(I)Ljava/lang/CharSequence;", "", "obj", "getItemPosition", "(Ljava/lang/Object;)I", "Lcom/avito/android/orders/feature/host/viewpager/OrdersInitialDataProvider;", "k", "Lcom/avito/android/orders/feature/host/viewpager/OrdersInitialDataProvider;", "initialDataProvider", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/orders/feature/host/viewpager/OrdersTabItem;", "j", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabsDataProvider", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Lcom/avito/android/orders/feature/host/viewpager/OrdersInitialDataProvider;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersTabPagerAdapter extends FragmentStatePagerAdapter {
    public final TabsDataProvider<OrdersTabItem> j;
    public final OrdersInitialDataProvider k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public OrdersTabPagerAdapter(@NotNull Fragment fragment, @NotNull TabsDataProvider<OrdersTabItem> tabsDataProvider, @NotNull OrdersInitialDataProvider ordersInitialDataProvider) {
        super(fragment.getChildFragmentManager(), 1);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabsDataProvider");
        Intrinsics.checkNotNullParameter(ordersInitialDataProvider, "initialDataProvider");
        this.j = tabsDataProvider;
        this.k = ordersInitialDataProvider;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.j.getCount();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @NotNull
    public Fragment getItem(int i) {
        String shortcut = this.j.getItem(i).getShortcut();
        return OrdersListFragment.Companion.create(shortcut, this.k.getTabListDataSource(shortcut));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public CharSequence getPageTitle(int i) {
        return this.j.getItem(i).getTitle();
    }
}
