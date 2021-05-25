package com.avito.android.orders.feature.list;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.orders.R;
import com.avito.android.orders.di.component.DaggerOrdersListFragmentComponent;
import com.avito.android.orders.di.component.OrdersDependencies;
import com.avito.android.orders.di.component.OrdersListFragmentComponent;
import com.avito.android.orders.feature.common.OnRefreshListener;
import com.avito.android.orders.feature.common.TypedErrorsKt;
import com.avito.android.orders.feature.common.UtilKt;
import com.avito.android.orders.feature.common.viewmodel.OrderItem;
import com.avito.android.orders.feature.common.viewmodel.OrderPage;
import com.avito.android.orders.feature.list.OrdersListViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedError;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.CompressedParcelable;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.architecture_components.Event;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\bA\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0006R\"\u0010\u0018\u001a\u00020\u00178\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u00020\u001e8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010-\u001a\u00020,8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0000@\u0000X.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lcom/avito/android/orders/feature/list/OrdersListFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "onDestroyView", "onDestroy", "outState", "onSaveInstanceState", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory$orders_release", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory$orders_release", "(Lcom/avito/android/ActivityIntentFactory;)V", "", "d", "Lkotlin/Lazy;", AuthSource.SEND_ABUSE, "()Ljava/lang/String;", "tabId", "Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;", "c", "Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;", "initialData", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "e", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory$orders_release", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory$orders_release", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/orders/feature/list/OrdersListViewModel;", "ordersListViewModel", "Lcom/avito/android/orders/feature/list/OrdersListViewModel;", "getOrdersListViewModel$orders_release", "()Lcom/avito/android/orders/feature/list/OrdersListViewModel;", "setOrdersListViewModel$orders_release", "(Lcom/avito/android/orders/feature/list/OrdersListViewModel;)V", "Lcom/avito/android/orders/feature/list/OrdersListView;", "ordersListView", "Lcom/avito/android/orders/feature/list/OrdersListView;", "getOrdersListView$orders_release", "()Lcom/avito/android/orders/feature/list/OrdersListView;", "setOrdersListView$orders_release", "(Lcom/avito/android/orders/feature/list/OrdersListView;)V", "<init>", "Companion", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersListFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    public OrderPage c;
    public final Lazy d = t6.c.lazy(new f(this));
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    public final CompositeDisposable e = new CompositeDisposable();
    @Inject
    public OrdersListView ordersListView;
    @Inject
    public OrdersListViewModel ordersListViewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/orders/feature/list/OrdersListFragment$Companion;", "", "", "tabId", "Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;", "orderPage", "Lcom/avito/android/orders/feature/list/OrdersListFragment;", "create", "(Ljava/lang/String;Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;)Lcom/avito/android/orders/feature/list/OrdersListFragment;", "<init>", "()V", "orders_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.a = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putString("tab_id", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final OrdersListFragment create(@NotNull String str, @NotNull OrderPage orderPage) {
            Intrinsics.checkNotNullParameter(str, "tabId");
            Intrinsics.checkNotNullParameter(orderPage, "orderPage");
            OrdersListFragment ordersListFragment = new OrdersListFragment();
            ordersListFragment.c = orderPage;
            return (OrdersListFragment) FragmentsKt.arguments(ordersListFragment, 1, new a(str));
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<OrderItem> {
        public final /* synthetic */ OrdersListFragment a;

        public a(OrdersListFragment ordersListFragment) {
            this.a = ordersListFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(OrderItem orderItem) {
            OrderItem orderItem2 = orderItem;
            OrdersListViewModel ordersListViewModel$orders_release = this.a.getOrdersListViewModel$orders_release();
            Intrinsics.checkNotNullExpressionValue(orderItem2, "it");
            ordersListViewModel$orders_release.onOrderClick(orderItem2);
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ OrdersListFragment a;

        public b(OrdersListFragment ordersListFragment) {
            this.a = ordersListFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            OrdersListFragment.access$getOnRefreshListener$p(this.a).onRefresh();
        }
    }

    public static final class c<T> implements Consumer<DeepLink> {
        public final /* synthetic */ OrdersListFragment a;

        public c(OrdersListFragment ordersListFragment) {
            this.a = ordersListFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            OrdersListFragment ordersListFragment = this.a;
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            OrdersListFragment.access$followDeeplink(ordersListFragment, deepLink2);
        }
    }

    public static final class d<T> implements Observer<OrdersListViewModel.OrderListState> {
        public final /* synthetic */ OrdersListFragment a;

        public d(OrdersListFragment ordersListFragment) {
            this.a = ordersListFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(OrdersListViewModel.OrderListState orderListState) {
            OrdersListViewModel.OrderListState orderListState2 = orderListState;
            OrdersListFragment ordersListFragment = this.a;
            Intrinsics.checkNotNullExpressionValue(orderListState2, "it");
            OrdersListFragment.access$changeScreenState(ordersListFragment, orderListState2);
        }
    }

    public static final class e<T> implements Observer<Event<? extends DeepLink>> {
        public final /* synthetic */ OrdersListFragment a;

        public e(OrdersListFragment ordersListFragment) {
            this.a = ordersListFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Event<? extends DeepLink> event) {
            DeepLink deepLink = (DeepLink) event.getContentIfNotHandled();
            if (deepLink != null) {
                OrdersListFragment.access$followDeeplink(this.a, deepLink);
            }
        }
    }

    public static final class f extends Lambda implements Function0<String> {
        public final /* synthetic */ OrdersListFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(OrdersListFragment ordersListFragment) {
            super(0);
            this.a = ordersListFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            String string = this.a.requireArguments().getString("tab_id");
            Intrinsics.checkNotNull(string);
            return string;
        }
    }

    public static final void access$changeScreenState(OrdersListFragment ordersListFragment, OrdersListViewModel.OrderListState orderListState) {
        Objects.requireNonNull(ordersListFragment);
        if (orderListState instanceof OrdersListViewModel.OrderListState.Content) {
            OrdersListView ordersListView2 = ordersListFragment.ordersListView;
            if (ordersListView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ordersListView");
            }
            ordersListView2.showContent(((OrdersListViewModel.OrderListState.Content) orderListState).getOrderItems());
            Unit unit = Unit.INSTANCE;
        } else if (orderListState instanceof OrdersListViewModel.OrderListState.Empty) {
            OrdersListView ordersListView3 = ordersListFragment.ordersListView;
            if (ordersListView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ordersListView");
            }
            ordersListView3.showEmptyState(((OrdersListViewModel.OrderListState.Empty) orderListState).getPlaceholder());
            Unit unit2 = Unit.INSTANCE;
        } else if (orderListState instanceof OrdersListViewModel.OrderListState.Error) {
            OrdersListViewModel.OrderListState.Error error = (OrdersListViewModel.OrderListState.Error) orderListState;
            TypedError contentIfNotHandled = error.getError().getContentIfNotHandled();
            if (contentIfNotHandled instanceof TypedError.UnauthorizedError) {
                ActivityIntentFactory activityIntentFactory2 = ordersListFragment.activityIntentFactory;
                if (activityIntentFactory2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
                }
                UtilKt.navigateToAuth(ordersListFragment, activityIntentFactory2);
                Unit unit3 = Unit.INSTANCE;
            } else if (contentIfNotHandled != null) {
                OrdersListView ordersListView4 = ordersListFragment.ordersListView;
                if (ordersListView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ordersListView");
                }
                ordersListView4.showContent(error.getOrderItems());
                OrdersListView ordersListView5 = ordersListFragment.ordersListView;
                if (ordersListView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ordersListView");
                }
                ordersListView5.showPartScreenError(TypedErrorsKt.toErrorMessage(contentIfNotHandled));
                Unit unit4 = Unit.INSTANCE;
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final void access$followDeeplink(OrdersListFragment ordersListFragment, DeepLink deepLink) {
        DeepLinkIntentFactory deepLinkIntentFactory2 = ordersListFragment.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            ordersListFragment.startActivity(intent);
        }
    }

    public static final /* synthetic */ OrderPage access$getInitialData$p(OrdersListFragment ordersListFragment) {
        OrderPage orderPage = ordersListFragment.c;
        if (orderPage == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialData");
        }
        return orderPage;
    }

    public static final OnRefreshListener access$getOnRefreshListener$p(OrdersListFragment ordersListFragment) {
        Fragment parentFragment = ordersListFragment.getParentFragment();
        Objects.requireNonNull(parentFragment, "null cannot be cast to non-null type com.avito.android.orders.feature.common.OnRefreshListener");
        return (OnRefreshListener) parentFragment;
    }

    public final String a() {
        return (String) this.d.getValue();
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
    public final DeepLinkIntentFactory getDeepLinkIntentFactory$orders_release() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final OrdersListView getOrdersListView$orders_release() {
        OrdersListView ordersListView2 = this.ordersListView;
        if (ordersListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersListView");
        }
        return ordersListView2;
    }

    @NotNull
    public final OrdersListViewModel getOrdersListViewModel$orders_release() {
        OrdersListViewModel ordersListViewModel2 = this.ordersListViewModel;
        if (ordersListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersListViewModel");
        }
        return ordersListViewModel2;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!(this.c != null)) {
            Intrinsics.checkNotNull(bundle);
            Parcelable parcelable = bundle.getParcelable("initial_data");
            Intrinsics.checkNotNull(parcelable);
            Intrinsics.checkNotNullExpressionValue(parcelable, "savedInstanceState!!.get…able>(KEY_INITIAL_DATA)!!");
            OrderPage orderPage = (OrderPage) ((CompressedParcelable) parcelable).restore(OrderPage.class);
            Intrinsics.checkNotNull(orderPage);
            this.c = orderPage;
        }
        Map access$getLoadMoreRelaysCache$p = OrdersListFragmentKt.access$getLoadMoreRelaysCache$p();
        String a3 = a();
        Intrinsics.checkNotNullExpressionValue(a3, "tabId");
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        if (access$getLoadMoreRelaysCache$p.get(a3) == null) {
            access$getLoadMoreRelaysCache$p.put(a3, create);
        }
        Map access$getItemClicksRelayCache$p = OrdersListFragmentKt.access$getItemClicksRelayCache$p();
        String a4 = a();
        Intrinsics.checkNotNullExpressionValue(a4, "tabId");
        PublishRelay create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        if (access$getItemClicksRelayCache$p.get(a4) == null) {
            access$getItemClicksRelayCache$p.put(a4, create2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.orders_list_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…agment, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        if (!requireActivity.isChangingConfigurations()) {
            OrdersListFragmentKt.access$getLoadMoreRelaysCache$p().clear();
            OrdersListFragmentKt.access$getItemClicksRelayCache$p().clear();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.e.clear();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        OrdersListViewModel ordersListViewModel2 = this.ordersListViewModel;
        if (ordersListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersListViewModel");
        }
        ordersListViewModel2.onListVisible();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        OrderPage orderPage = this.c;
        if (orderPage == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialData");
        }
        bundle.putParcelable("initial_data", new CompressedParcelable(orderPage));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        OrdersListFragmentComponent.Factory factory = DaggerOrdersListFragmentComponent.factory();
        OrderPage orderPage = this.c;
        if (orderPage == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialData");
        }
        Object obj = OrdersListFragmentKt.access$getLoadMoreRelaysCache$p().get(a());
        Intrinsics.checkNotNull(obj);
        PublishRelay<Unit> publishRelay = (PublishRelay) obj;
        Object obj2 = OrdersListFragmentKt.access$getItemClicksRelayCache$p().get(a());
        Intrinsics.checkNotNull(obj2);
        factory.create(this, view, orderPage, publishRelay, (PublishRelay) obj2, (OrdersDependencies) ComponentDependenciesKt.getDependencies(OrdersDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        OrdersListView ordersListView2 = this.ordersListView;
        if (ordersListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersListView");
        }
        Disposable subscribe = ordersListView2.getOrderClicks().subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "ordersListView.orderClic…wModel.onOrderClick(it) }");
        DisposableKt.addTo(subscribe, this.e);
        OrdersListView ordersListView3 = this.ordersListView;
        if (ordersListView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersListView");
        }
        Disposable subscribe2 = ordersListView3.getRefreshSwipes().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "ordersListView.refreshSw…eshListener.onRefresh() }");
        DisposableKt.addTo(subscribe2, this.e);
        OrdersListView ordersListView4 = this.ordersListView;
        if (ordersListView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersListView");
        }
        Disposable subscribe3 = ordersListView4.getEmptyStateClicks().subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "ordersListView.emptyStat…be { followDeeplink(it) }");
        DisposableKt.addTo(subscribe3, this.e);
        OrdersListViewModel ordersListViewModel2 = this.ordersListViewModel;
        if (ordersListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersListViewModel");
        }
        ordersListViewModel2.getDataLiveData().observe(getViewLifecycleOwner(), new d(this));
        OrdersListViewModel ordersListViewModel3 = this.ordersListViewModel;
        if (ordersListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ordersListViewModel");
        }
        ordersListViewModel3.getOrderLiveData().observe(getViewLifecycleOwner(), new e(this));
    }

    public final void setActivityIntentFactory$orders_release(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setDeepLinkIntentFactory$orders_release(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setOrdersListView$orders_release(@NotNull OrdersListView ordersListView2) {
        Intrinsics.checkNotNullParameter(ordersListView2, "<set-?>");
        this.ordersListView = ordersListView2;
    }

    public final void setOrdersListViewModel$orders_release(@NotNull OrdersListViewModel ordersListViewModel2) {
        Intrinsics.checkNotNullParameter(ordersListViewModel2, "<set-?>");
        this.ordersListViewModel = ordersListViewModel2;
    }
}
