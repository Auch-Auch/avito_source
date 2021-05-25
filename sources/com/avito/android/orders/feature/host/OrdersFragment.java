package com.avito.android.orders.feature.host;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.orders.R;
import com.avito.android.orders.di.component.DaggerOrdersHostComponent;
import com.avito.android.orders.di.component.OrdersDependencies;
import com.avito.android.orders.di.component.OrdersHostComponentKt;
import com.avito.android.orders.feature.common.OnRefreshListener;
import com.avito.android.orders.feature.common.TypedErrorsKt;
import com.avito.android.orders.feature.common.UtilKt;
import com.avito.android.orders.feature.host.OrdersViewModel;
import com.avito.android.orders.feature.host.viewpager.OrdersInitialDataProvider;
import com.avito.android.orders.feature.host.viewpager.OrdersTabItem;
import com.avito.android.remote.error.TypedError;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.ui.fragments.TabBaseFragment;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bG\u0010\u0011J+\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0011R\u001f\u0010\u001b\u001a\u0004\u0018\u00010\u00168B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001f\u0010\u001e\u001a\u0004\u0018\u00010\u00168B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\"\u0010 \u001a\u00020\u001f8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\"\u00109\u001a\u0002088\u0000@\u0000X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R(\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006H"}, d2 = {"Lcom/avito/android/orders/feature/host/OrdersFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/orders/feature/common/OnRefreshListener;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "onPause", "onDestroyView", "onRefresh", "c", "", "j", "Lkotlin/Lazy;", "getTabToOpen", "()Ljava/lang/String;", "tabToOpen", "k", "getOrdersToPrefetch", "ordersToPrefetch", "Lcom/avito/android/orders/feature/host/OrdersViewModel;", "ordersViewModel", "Lcom/avito/android/orders/feature/host/OrdersViewModel;", "getOrdersViewModel$orders_release", "()Lcom/avito/android/orders/feature/host/OrdersViewModel;", "setOrdersViewModel$orders_release", "(Lcom/avito/android/orders/feature/host/OrdersViewModel;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory$orders_release", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory$orders_release", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/orders/feature/host/viewpager/OrdersInitialDataProvider;", "initialDataProvider", "Lcom/avito/android/orders/feature/host/viewpager/OrdersInitialDataProvider;", "getInitialDataProvider$orders_release", "()Lcom/avito/android/orders/feature/host/viewpager/OrdersInitialDataProvider;", "setInitialDataProvider$orders_release", "(Lcom/avito/android/orders/feature/host/viewpager/OrdersInitialDataProvider;)V", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "l", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/orders/feature/host/OrdersView;", "ordersView", "Lcom/avito/android/orders/feature/host/OrdersView;", "getOrdersView$orders_release", "()Lcom/avito/android/orders/feature/host/OrdersView;", "setOrdersView$orders_release", "(Lcom/avito/android/orders/feature/host/OrdersView;)V", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/orders/feature/host/viewpager/OrdersTabItem;", "tabsDataProvider", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "getTabsDataProvider$orders_release", "()Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "setTabsDataProvider$orders_release", "(Lcom/avito/android/ui/adapter/tab/TabsDataProvider;)V", "<init>", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersFragment extends TabBaseFragment implements OnRefreshListener {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public OrdersInitialDataProvider initialDataProvider;
    public final Lazy j = t6.c.lazy(new c(1, this));
    public final Lazy k = t6.c.lazy(new c(0, this));
    public final CompositeDisposable l = new CompositeDisposable();
    @Inject
    public OrdersView ordersView;
    @Inject
    public OrdersViewModel ordersViewModel;
    @Inject
    public TabsDataProvider<OrdersTabItem> tabsDataProvider;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                return;
            }
            if (i != 1) {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((OrdersFragment) this.b).requireActivity().onBackPressed();
            } else if (i == 1) {
                ((OrdersFragment) this.b).getOrdersViewModel$orders_release().onRetry();
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class c extends Lambda implements Function0<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            int i = this.a;
            if (i == 0) {
                Bundle arguments = ((OrdersFragment) this.b).getArguments();
                if (arguments != null) {
                    return arguments.getString(OrdersHostComponentKt.ORDERS_TO_PREFETCH);
                }
                return null;
            } else if (i == 1) {
                Bundle arguments2 = ((OrdersFragment) this.b).getArguments();
                if (arguments2 != null) {
                    return arguments2.getString("orders_tab");
                }
                return null;
            } else {
                throw null;
            }
        }
    }

    public static final class d<T> implements Observer<OrdersViewModel.OrdersLoadingState> {
        public final /* synthetic */ OrdersFragment a;

        public d(OrdersFragment ordersFragment) {
            this.a = ordersFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(OrdersViewModel.OrdersLoadingState ordersLoadingState) {
            OrdersViewModel.OrdersLoadingState ordersLoadingState2 = ordersLoadingState;
            OrdersFragment ordersFragment = this.a;
            Intrinsics.checkNotNullExpressionValue(ordersLoadingState2, "it");
            OrdersFragment.access$changeScreenState(ordersFragment, ordersLoadingState2);
        }
    }

    public static final class e<T> implements Observer<Integer> {
        public final /* synthetic */ OrdersFragment a;

        public e(OrdersFragment ordersFragment) {
            this.a = ordersFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Integer num) {
            Integer num2 = num;
            OrdersView ordersView$orders_release = this.a.getOrdersView$orders_release();
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            ordersView$orders_release.setActiveTab(num2.intValue());
        }
    }

    public static final void access$changeScreenState(OrdersFragment ordersFragment, OrdersViewModel.OrdersLoadingState ordersLoadingState) {
        Objects.requireNonNull(ordersFragment);
        if (Intrinsics.areEqual(ordersLoadingState, OrdersViewModel.OrdersLoadingState.Loading.INSTANCE)) {
            OrdersView ordersView2 = ordersFragment.ordersView;
            if (ordersView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ordersView");
            }
            ordersView2.showLoading();
        } else if (ordersLoadingState instanceof OrdersViewModel.OrdersLoadingState.Loaded) {
            ordersFragment.c();
        } else if (ordersLoadingState instanceof OrdersViewModel.OrdersLoadingState.ErrorFullScreen) {
            OrdersViewModel.OrdersLoadingState.ErrorFullScreen errorFullScreen = (OrdersViewModel.OrdersLoadingState.ErrorFullScreen) ordersLoadingState;
            if (errorFullScreen.getError() instanceof TypedError.UnauthorizedError) {
                ActivityIntentFactory activityIntentFactory2 = ordersFragment.activityIntentFactory;
                if (activityIntentFactory2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
                }
                UtilKt.navigateToAuth(ordersFragment, activityIntentFactory2);
                return;
            }
            OrdersView ordersView3 = ordersFragment.ordersView;
            if (ordersView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ordersView");
            }
            ordersView3.showFullScreenError(TypedErrorsKt.toErrorMessage(errorFullScreen.getError()));
        } else if (ordersLoadingState instanceof OrdersViewModel.OrdersLoadingState.ErrorPartScreen) {
            TypedError contentIfNotHandled = ((OrdersViewModel.OrdersLoadingState.ErrorPartScreen) ordersLoadingState).getError().getContentIfNotHandled();
            if (contentIfNotHandled instanceof TypedError.UnauthorizedError) {
                ActivityIntentFactory activityIntentFactory3 = ordersFragment.activityIntentFactory;
                if (activityIntentFactory3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
                }
                UtilKt.navigateToAuth(ordersFragment, activityIntentFactory3);
                return;
            }
            if (contentIfNotHandled != null) {
                OrdersView ordersView4 = ordersFragment.ordersView;
                if (ordersView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ordersView");
                }
                ordersView4.showPartScreenError(TypedErrorsKt.toErrorMessage(contentIfNotHandled));
            }
            ordersFragment.c();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void c() {
        TabsDataProvider<OrdersTabItem> tabsDataProvider2 = this.tabsDataProvider;
        if (tabsDataProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabsDataProvider");
        }
        OrdersViewModel ordersViewModel2 = this.ordersViewModel;
        if (ordersViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersViewModel");
        }
        List<OrdersViewModel.TabData> initialData = ordersViewModel2.getInitialData();
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(initialData, 10));
        Iterator<T> it = initialData.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getTab());
        }
        tabsDataProvider2.updateItems(arrayList);
        OrdersInitialDataProvider ordersInitialDataProvider = this.initialDataProvider;
        if (ordersInitialDataProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialDataProvider");
        }
        OrdersViewModel ordersViewModel3 = this.ordersViewModel;
        if (ordersViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersViewModel");
        }
        List<OrdersViewModel.TabData> initialData2 = ordersViewModel3.getInitialData();
        ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(initialData2, 10));
        for (T t : initialData2) {
            arrayList2.add(TuplesKt.to(t.getTab().getShortcut(), t.getOrderPage()));
        }
        ordersInitialDataProvider.updateItems(r.toMap(arrayList2));
        OrdersView ordersView2 = this.ordersView;
        if (ordersView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersView");
        }
        ordersView2.showContent();
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory$orders_release() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final OrdersInitialDataProvider getInitialDataProvider$orders_release() {
        OrdersInitialDataProvider ordersInitialDataProvider = this.initialDataProvider;
        if (ordersInitialDataProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialDataProvider");
        }
        return ordersInitialDataProvider;
    }

    @NotNull
    public final OrdersView getOrdersView$orders_release() {
        OrdersView ordersView2 = this.ordersView;
        if (ordersView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersView");
        }
        return ordersView2;
    }

    @NotNull
    public final OrdersViewModel getOrdersViewModel$orders_release() {
        OrdersViewModel ordersViewModel2 = this.ordersViewModel;
        if (ordersViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersViewModel");
        }
        return ordersViewModel2;
    }

    @NotNull
    public final TabsDataProvider<OrdersTabItem> getTabsDataProvider$orders_release() {
        TabsDataProvider<OrdersTabItem> tabsDataProvider2 = this.tabsDataProvider;
        if (tabsDataProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabsDataProvider");
        }
        return tabsDataProvider2;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.orders_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…agment, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.l.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        OrdersViewModel ordersViewModel2 = this.ordersViewModel;
        if (ordersViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersViewModel");
        }
        OrdersView ordersView2 = this.ordersView;
        if (ordersView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersView");
        }
        ordersViewModel2.onInvisible(ordersView2.getTabIndex());
        super.onPause();
    }

    @Override // com.avito.android.orders.feature.common.OnRefreshListener
    public void onRefresh() {
        OrdersViewModel ordersViewModel2 = this.ordersViewModel;
        if (ordersViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersViewModel");
        }
        OrdersView ordersView2 = this.ordersView;
        if (ordersView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersView");
        }
        ordersViewModel2.onRefresh(ordersView2.getTabIndex());
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        OrdersViewModel ordersViewModel2 = this.ordersViewModel;
        if (ordersViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersViewModel");
        }
        ordersViewModel2.onVisible();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        DaggerOrdersHostComponent.factory().create(this, view, (String) this.j.getValue(), (String) this.k.getValue(), (OrdersDependencies) ComponentDependenciesKt.getDependencies(OrdersDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        OrdersView ordersView2 = this.ordersView;
        if (ordersView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersView");
        }
        Disposable subscribe = ordersView2.getBackClicks().subscribe(new b(0, this), a.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "ordersView.backClicks.su…().onBackPressed() }, {})");
        DisposableKt.addTo(subscribe, this.l);
        OrdersView ordersView3 = this.ordersView;
        if (ordersView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersView");
        }
        Disposable subscribe2 = ordersView3.getRetryClicks().subscribe(new b(1, this), a.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "ordersView.retryClicks.s…iewModel.onRetry() }, {})");
        DisposableKt.addTo(subscribe2, this.l);
        OrdersViewModel ordersViewModel2 = this.ordersViewModel;
        if (ordersViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersViewModel");
        }
        ordersViewModel2.getScreenStateChanges().observe(getViewLifecycleOwner(), new d(this));
        ordersViewModel2.getSelectedTabIndexChanges().observe(getViewLifecycleOwner(), new e(this));
    }

    public final void setActivityIntentFactory$orders_release(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setInitialDataProvider$orders_release(@NotNull OrdersInitialDataProvider ordersInitialDataProvider) {
        Intrinsics.checkNotNullParameter(ordersInitialDataProvider, "<set-?>");
        this.initialDataProvider = ordersInitialDataProvider;
    }

    public final void setOrdersView$orders_release(@NotNull OrdersView ordersView2) {
        Intrinsics.checkNotNullParameter(ordersView2, "<set-?>");
        this.ordersView = ordersView2;
    }

    public final void setOrdersViewModel$orders_release(@NotNull OrdersViewModel ordersViewModel2) {
        Intrinsics.checkNotNullParameter(ordersViewModel2, "<set-?>");
        this.ordersViewModel = ordersViewModel2;
    }

    public final void setTabsDataProvider$orders_release(@NotNull TabsDataProvider<OrdersTabItem> tabsDataProvider2) {
        Intrinsics.checkNotNullParameter(tabsDataProvider2, "<set-?>");
        this.tabsDataProvider = tabsDataProvider2;
    }
}
