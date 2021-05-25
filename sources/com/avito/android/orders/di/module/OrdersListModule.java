package com.avito.android.orders.di.module;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.di.PerFragment;
import com.avito.android.orders.feature.common.converter.OrdersItemConverter;
import com.avito.android.orders.feature.common.converter.OrdersItemConverterImpl;
import com.avito.android.orders.feature.common.viewmodel.OrderItem;
import com.avito.android.orders.feature.list.OrdersListRepository;
import com.avito.android.orders.feature.list.OrdersListRepositoryImpl;
import com.avito.android.orders.feature.list.OrdersListView;
import com.avito.android.orders.feature.list.OrdersListViewImpl;
import com.avito.android.orders.feature.list.OrdersListViewModel;
import com.avito.android.orders.feature.list.OrdersListViewModelFactory;
import com.avito.android.orders.feature.list.adapter.OrdersContentsComparator;
import com.avito.android.orders.feature.list.adapter.loading.OrderLoadingItemBlueprint;
import com.avito.android.orders.feature.list.adapter.order.OrderItemBlueprint;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.recycler.data_aware.SimpleEqualityComparator;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001:\u00010B\t\b\u0002¢\u0006\u0004\b.\u0010/J*\u0010\t\u001a\u00020\u00062\u0019\u0010\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\b\u00040\u0002H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u001d\u001a\u00020\u001a2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\"\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001eH\u0001¢\u0006\u0004\b \u0010!J\u001f\u0010%\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0006H\u0001¢\u0006\u0004\b#\u0010$J\u001f\u0010-\u001a\u00020*2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0001¢\u0006\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/avito/android/orders/di/module/OrdersListModule;", "", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$orders_release", "(Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroidx/recyclerview/widget/ListUpdateCallback;", "provideListUpdateCallback$orders_release", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "provideListUpdateCallback", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "provideAdapterPresenter$orders_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "provideAdapterPresenter", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideDataAwareAdapterPresenterImpl$orders_release", "(Ldagger/Lazy;Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideDataAwareAdapterPresenterImpl", "Lcom/avito/android/orders/feature/list/adapter/OrdersContentsComparator;", "contentsComparator", "provideDiffCalculator$orders_release", "(Lcom/avito/android/orders/feature/list/adapter/OrdersContentsComparator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "provideRecyclerAdapter$orders_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/orders/feature/list/OrdersListViewModelFactory;", "viewModelFactory", "Lcom/avito/android/orders/feature/list/OrdersListViewModel;", "provideViewModel$orders_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/orders/feature/list/OrdersListViewModelFactory;)Lcom/avito/android/orders/feature/list/OrdersListViewModel;", "provideViewModel", "<init>", "()V", "Dependencies", "orders_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AttributedTextFormatterModule.class, Dependencies.class})
public final class OrdersListModule {
    @NotNull
    public static final OrdersListModule INSTANCE = new OrdersListModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0016\u001a\f\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u00152\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u00110\u0010j\u0002`\u0012H'¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u001a\u001a\f\u0012\u0004\u0012\u00020\u00110\u0018j\u0002`\u00192\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u00110\u0010j\u0002`\u0012H'¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001f\u001a\f\u0012\u0004\u0012\u00020\u001c0\u0014j\u0002`\u001e2\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u001c0\u0010j\u0002`\u001dH'¢\u0006\u0004\b\u001f\u0010\u0017J+\u0010!\u001a\f\u0012\u0004\u0012\u00020\u001c0\u0018j\u0002` 2\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u001c0\u0010j\u0002`\u001dH'¢\u0006\u0004\b!\u0010\u001bJ\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H'¢\u0006\u0004\b%\u0010&J\u0017\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020'H'¢\u0006\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/avito/android/orders/di/module/OrdersListModule$Dependencies;", "", "Lcom/avito/android/orders/feature/list/OrdersListViewImpl;", "ordersListView", "Lcom/avito/android/orders/feature/list/OrdersListView;", "bindsOrdersListView", "(Lcom/avito/android/orders/feature/list/OrdersListViewImpl;)Lcom/avito/android/orders/feature/list/OrdersListView;", "Lcom/avito/android/orders/feature/list/adapter/order/OrderItemBlueprint;", "orderItemBlueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindsOrderItemBlueprint", "(Lcom/avito/android/orders/feature/list/adapter/order/OrderItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/orders/feature/list/adapter/loading/OrderLoadingItemBlueprint;", "orderLoadingItemBlueprint", "bindsOrderLoadingItemBlueprint", "(Lcom/avito/android/orders/feature/list/adapter/loading/OrderLoadingItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/orders/feature/common/viewmodel/OrderItem;", "Lcom/avito/android/orders/feature/list/adapter/OrderItemClicksRelay;", "relay", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/orders/feature/list/adapter/OrderItemClicksConsumer;", "bindsOrderItemClicksConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/orders/feature/list/adapter/OrderItemClicksObservable;", "bindsOrderItemClicksObservable", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/orders/feature/list/adapter/OrdersLoadMoreRelay;", "Lcom/avito/android/orders/feature/list/adapter/OrdersLoadMoreConsumer;", "bindsOrdersLoadMoreConsumer", "Lcom/avito/android/orders/feature/list/adapter/OrdersLoadMoreObservable;", "bindsOrdersLoadMoreObservable", "Lcom/avito/android/orders/feature/common/converter/OrdersItemConverterImpl;", "ordersItemConverter", "Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;", "bindsOrdersItemConverter", "(Lcom/avito/android/orders/feature/common/converter/OrdersItemConverterImpl;)Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;", "Lcom/avito/android/orders/feature/list/OrdersListRepositoryImpl;", "ordersListRepository", "Lcom/avito/android/orders/feature/list/OrdersListRepository;", "bindsOrdersListRepositoryImpl", "(Lcom/avito/android/orders/feature/list/OrdersListRepositoryImpl;)Lcom/avito/android/orders/feature/list/OrdersListRepository;", "orders_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindsOrderItemBlueprint(@NotNull OrderItemBlueprint orderItemBlueprint);

        @Binds
        @NotNull
        @PerFragment
        Consumer<OrderItem> bindsOrderItemClicksConsumer(@NotNull PublishRelay<OrderItem> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Observable<OrderItem> bindsOrderItemClicksObservable(@NotNull PublishRelay<OrderItem> publishRelay);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindsOrderLoadingItemBlueprint(@NotNull OrderLoadingItemBlueprint orderLoadingItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        OrdersItemConverter bindsOrdersItemConverter(@NotNull OrdersItemConverterImpl ordersItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        OrdersListRepository bindsOrdersListRepositoryImpl(@NotNull OrdersListRepositoryImpl ordersListRepositoryImpl);

        @PerFragment
        @Binds
        @NotNull
        OrdersListView bindsOrdersListView(@NotNull OrdersListViewImpl ordersListViewImpl);

        @Binds
        @NotNull
        @PerFragment
        Consumer<Unit> bindsOrdersLoadMoreConsumer(@NotNull PublishRelay<Unit> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Observable<Unit> bindsOrdersLoadMoreObservable(@NotNull PublishRelay<Unit> publishRelay);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SimpleAdapterPresenter provideAdapterPresenter$orders_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @NotNull
    @PerFragment
    public final AdapterPresenter provideDataAwareAdapterPresenterImpl$orders_release(@NotNull Lazy<ListUpdateCallback> lazy, @NotNull SimpleAdapterPresenter simpleAdapterPresenter, @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(simpleAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        return new DataAwareAdapterPresenterImpl(lazy, simpleAdapterPresenter, diffCalculator);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DiffCalculator provideDiffCalculator$orders_release(@NotNull OrdersContentsComparator ordersContentsComparator) {
        Intrinsics.checkNotNullParameter(ordersContentsComparator, "contentsComparator");
        return new SimpleDiffCalculator(ordersContentsComparator, new SimpleEqualityComparator(), false, null, 8, null);
    }

    @Provides
    @NotNull
    @PerFragment
    public final ItemBinder provideItemBinder$orders_release(@NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            builder.registerItem(it.next());
        }
        return builder.build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final ListUpdateCallback provideListUpdateCallback$orders_release(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        return simpleRecyclerAdapter;
    }

    @Provides
    @PerFragment
    @NotNull
    public final SimpleRecyclerAdapter provideRecyclerAdapter$orders_release(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final OrdersListViewModel provideViewModel$orders_release(@NotNull Fragment fragment, @NotNull OrdersListViewModelFactory ordersListViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(ordersListViewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, ordersListViewModelFactory).get(OrdersListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…istViewModel::class.java)");
        return (OrdersListViewModel) viewModel;
    }
}
