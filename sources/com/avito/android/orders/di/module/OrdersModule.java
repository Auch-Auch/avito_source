package com.avito.android.orders.di.module;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.di.PerFragment;
import com.avito.android.orders.feature.common.converter.OrdersItemConverter;
import com.avito.android.orders.feature.common.converter.OrdersItemConverterImpl;
import com.avito.android.orders.feature.common.converter.OrdersTabItemConverter;
import com.avito.android.orders.feature.common.converter.OrdersTabItemConverterImpl;
import com.avito.android.orders.feature.host.OrdersRepository;
import com.avito.android.orders.feature.host.OrdersRepositoryImpl;
import com.avito.android.orders.feature.host.OrdersView;
import com.avito.android.orders.feature.host.OrdersViewImpl;
import com.avito.android.orders.feature.host.OrdersViewModel;
import com.avito.android.orders.feature.host.OrdersViewModelFactory;
import com.avito.android.orders.feature.host.viewpager.OrdersInitialDataProvider;
import com.avito.android.orders.feature.host.viewpager.OrdersInitialDataProviderImpl;
import com.avito.android.orders.feature.host.viewpager.OrdersTabItem;
import com.avito.android.orders.feature.host.viewpager.OrdersTabPagerAdapter;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.ui_components.R;
import com.avito.android.util.text.AttributedTextFormatterModule;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/avito/android/orders/di/module/OrdersModule;", "", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/orders/feature/host/viewpager/OrdersTabItem;", "provideTabsDataProvider", "()Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/orders/feature/host/OrdersViewModelFactory;", "viewModelFactory", "Lcom/avito/android/orders/feature/host/OrdersViewModel;", "provideViewModel$orders_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/orders/feature/host/OrdersViewModelFactory;)Lcom/avito/android/orders/feature/host/OrdersViewModel;", "provideViewModel", "tabsDataProvider", "Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "provideTabLayoutAdapter$orders_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/ui/adapter/tab/TabsDataProvider;)Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "provideTabLayoutAdapter", "<init>", "()V", "Dependencies", "orders_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AttributedTextFormatterModule.class, Dependencies.class})
public final class OrdersModule {
    @NotNull
    public static final OrdersModule INSTANCE = new OrdersModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/avito/android/orders/di/module/OrdersModule$Dependencies;", "", "Lcom/avito/android/orders/feature/host/OrdersRepositoryImpl;", "ordersRepository", "Lcom/avito/android/orders/feature/host/OrdersRepository;", "bindsOrdersRepository", "(Lcom/avito/android/orders/feature/host/OrdersRepositoryImpl;)Lcom/avito/android/orders/feature/host/OrdersRepository;", "Lcom/avito/android/orders/feature/host/OrdersViewImpl;", "ordersView", "Lcom/avito/android/orders/feature/host/OrdersView;", "bindsOrdersView", "(Lcom/avito/android/orders/feature/host/OrdersViewImpl;)Lcom/avito/android/orders/feature/host/OrdersView;", "Lcom/avito/android/orders/feature/common/converter/OrdersTabItemConverterImpl;", "ordersTabItemConverter", "Lcom/avito/android/orders/feature/common/converter/OrdersTabItemConverter;", "bindsOrdersTabItemConverter", "(Lcom/avito/android/orders/feature/common/converter/OrdersTabItemConverterImpl;)Lcom/avito/android/orders/feature/common/converter/OrdersTabItemConverter;", "Lcom/avito/android/orders/feature/common/converter/OrdersItemConverterImpl;", "ordersItemConverterItem", "Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;", "bindsOrdersItemConverter", "(Lcom/avito/android/orders/feature/common/converter/OrdersItemConverterImpl;)Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;", "Lcom/avito/android/orders/feature/host/viewpager/OrdersInitialDataProviderImpl;", "ordersInitialDataProviderImpl", "Lcom/avito/android/orders/feature/host/viewpager/OrdersInitialDataProvider;", "bindsOrdersInitialDataProvider", "(Lcom/avito/android/orders/feature/host/viewpager/OrdersInitialDataProviderImpl;)Lcom/avito/android/orders/feature/host/viewpager/OrdersInitialDataProvider;", "Lcom/avito/android/orders/feature/host/viewpager/OrdersTabPagerAdapter;", "ordersTabPagerAdapter", "Landroidx/viewpager/widget/PagerAdapter;", "bindsOrdersTabPagerAdapter", "(Lcom/avito/android/orders/feature/host/viewpager/OrdersTabPagerAdapter;)Landroidx/viewpager/widget/PagerAdapter;", "orders_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        OrdersInitialDataProvider bindsOrdersInitialDataProvider(@NotNull OrdersInitialDataProviderImpl ordersInitialDataProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        OrdersItemConverter bindsOrdersItemConverter(@NotNull OrdersItemConverterImpl ordersItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        OrdersRepository bindsOrdersRepository(@NotNull OrdersRepositoryImpl ordersRepositoryImpl);

        @PerFragment
        @Binds
        @NotNull
        OrdersTabItemConverter bindsOrdersTabItemConverter(@NotNull OrdersTabItemConverterImpl ordersTabItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        PagerAdapter bindsOrdersTabPagerAdapter(@NotNull OrdersTabPagerAdapter ordersTabPagerAdapter);

        @PerFragment
        @Binds
        @NotNull
        OrdersView bindsOrdersView(@NotNull OrdersViewImpl ordersViewImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final TabsDataProvider<OrdersTabItem> provideTabsDataProvider() {
        return new TabsDataProvider<>();
    }

    @Provides
    @NotNull
    @PerFragment
    public final TabLayoutAdapter<OrdersTabItem> provideTabLayoutAdapter$orders_release(@NotNull Fragment fragment, @NotNull TabsDataProvider<OrdersTabItem> tabsDataProvider) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabsDataProvider");
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
        return new TabLayoutAdapter<>(tabsDataProvider, requireContext, R.layout.tab_shortcut);
    }

    @Provides
    @NotNull
    public final OrdersViewModel provideViewModel$orders_release(@NotNull Fragment fragment, @NotNull OrdersViewModelFactory ordersViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(ordersViewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, ordersViewModelFactory).get(OrdersViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…ersViewModel::class.java)");
        return (OrdersViewModel) viewModel;
    }
}
