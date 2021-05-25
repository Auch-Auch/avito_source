package com.avito.android.delivery.order_cancellation;

import a2.a.a.k0.b.a;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.delivery.R;
import com.avito.android.delivery.di.component.DaggerRdsOrderCancellationComponent;
import com.avito.android.delivery.di.component.DeliveryDependencies;
import com.avito.android.delivery.di.component.RdsOrderCancellationComponent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\bH\u0010IJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b,\u0010-R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010>\u001a\u00020=8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006K"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "getTracker", "()Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "setTracker", "(Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsViewModel;", "viewModel", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsViewModel;", "getViewModel", "()Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsViewModel;", "setViewModel", "(Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsViewModel;)V", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "d", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", "resourceProvider", "Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", "getResourceProvider", "()Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", "setResourceProvider", "(Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationRouter;", "c", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationRouter;", "router", "<init>", "()V", "Factory", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class RdsOrderCancellationReasonsFragment extends BaseFragment {
    @Inject
    public DataAwareAdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public RdsOrderCancellationRouter c;
    public ProgressOverlay d;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public OrderCancellationResourceProvider resourceProvider;
    @Inject
    public BaseScreenPerformanceTracker tracker;
    @Inject
    public RdsOrderCancellationReasonsViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsFragment$Factory;", "", "", AnalyticFieldsName.orderId, "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsFragment;", "createInstance", "(Ljava/lang/String;)Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsFragment;", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final RdsOrderCancellationReasonsFragment createInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
            Bundle bundle = new Bundle(1);
            bundle.putString("EXTRA_ORDER_ID", str);
            RdsOrderCancellationReasonsFragment rdsOrderCancellationReasonsFragment = new RdsOrderCancellationReasonsFragment();
            rdsOrderCancellationReasonsFragment.setArguments(bundle);
            return rdsOrderCancellationReasonsFragment;
        }
    }

    public static final /* synthetic */ ProgressOverlay access$getProgressOverlay$p(RdsOrderCancellationReasonsFragment rdsOrderCancellationReasonsFragment) {
        ProgressOverlay progressOverlay = rdsOrderCancellationReasonsFragment.d;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        return progressOverlay;
    }

    public static final /* synthetic */ RdsOrderCancellationRouter access$getRouter$p(RdsOrderCancellationReasonsFragment rdsOrderCancellationReasonsFragment) {
        RdsOrderCancellationRouter rdsOrderCancellationRouter = rdsOrderCancellationReasonsFragment.c;
        if (rdsOrderCancellationRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        return rdsOrderCancellationRouter;
    }

    @NotNull
    public final DataAwareAdapterPresenter getAdapterPresenter() {
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return dataAwareAdapterPresenter;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final SimpleRecyclerAdapter getRecyclerAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final OrderCancellationResourceProvider getResourceProvider() {
        OrderCancellationResourceProvider orderCancellationResourceProvider = this.resourceProvider;
        if (orderCancellationResourceProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
        }
        return orderCancellationResourceProvider;
    }

    @NotNull
    public final BaseScreenPerformanceTracker getTracker() {
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return baseScreenPerformanceTracker;
    }

    @NotNull
    public final RdsOrderCancellationReasonsViewModel getViewModel() {
        RdsOrderCancellationReasonsViewModel rdsOrderCancellationReasonsViewModel = this.viewModel;
        if (rdsOrderCancellationReasonsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return rdsOrderCancellationReasonsViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof RdsOrderCancellationRouter)) {
            activity = null;
        }
        RdsOrderCancellationRouter rdsOrderCancellationRouter = (RdsOrderCancellationRouter) activity;
        if (rdsOrderCancellationRouter != null) {
            this.c = rdsOrderCancellationRouter;
            return;
        }
        throw new IllegalStateException("Parent activity must implement RdsOrderCancellationRouter");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        baseScreenPerformanceTracker.startInit();
        return layoutInflater.inflate(R.layout.delivery_rds_order_cancellation_reasons_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24_black);
        toolbar.setNavigationOnClickListener(new a(this));
        RdsOrderCancellationReasonsViewModel rdsOrderCancellationReasonsViewModel = this.viewModel;
        if (rdsOrderCancellationReasonsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        rdsOrderCancellationReasonsViewModel.setAdapterPresenter(dataAwareAdapterPresenter);
        int i = R.id.reasons_recycler;
        View findViewById2 = view.findViewById(i);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        recyclerView.setAdapter(simpleRecyclerAdapter);
        View findViewById3 = view.findViewById(R.id.content_holder);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById3;
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        this.d = new ProgressOverlay(viewGroup, i, analytics2, false, 0, 24, null);
        RdsOrderCancellationReasonsViewModel rdsOrderCancellationReasonsViewModel2 = this.viewModel;
        if (rdsOrderCancellationReasonsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        rdsOrderCancellationReasonsViewModel2.getProgressChanges().observe(getViewLifecycleOwner(), new RdsOrderCancellationReasonsFragment$bindTo$$inlined$observeNotNull$1(this, rdsOrderCancellationReasonsViewModel2));
        rdsOrderCancellationReasonsViewModel2.getReasonDetailsChanges().observe(getViewLifecycleOwner(), new Observer<T>(rdsOrderCancellationReasonsViewModel2) { // from class: com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsFragment$bindTo$$inlined$observe$1
            public final /* synthetic */ RdsOrderCancellationReasonsViewModel b;

            {
                this.b = r2;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                T t2 = t;
                if (t2 == null) {
                    View view2 = RdsOrderCancellationReasonsFragment.this.getView();
                    if (view2 != null) {
                        Views.showSnackBar$default(view2, RdsOrderCancellationReasonsFragment.this.getResourceProvider().getErrorOccurred(), 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
                        return;
                    }
                    return;
                }
                RdsOrderCancellationReasonsFragment.access$getRouter$p(RdsOrderCancellationReasonsFragment.this).openReasonDetailsScreen(t2, this.b.getCommentMaxLength());
            }
        });
        rdsOrderCancellationReasonsViewModel2.getSnackbarChanges().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsFragment$bindTo$$inlined$observeNotNull$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    View view2 = RdsOrderCancellationReasonsFragment.this.getView();
                    if (view2 != null) {
                        Views.showSnackBar$default(view2, t2, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
                    }
                }
            }
        });
        rdsOrderCancellationReasonsViewModel2.getCloseScreenChanges().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsFragment$bindTo$$inlined$observeNotNull$3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    RdsOrderCancellationReasonsFragment.access$getRouter$p(RdsOrderCancellationReasonsFragment.this).forceLeaveScreen(t.intValue());
                }
            }
        });
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        baseScreenPerformanceTracker.trackInit();
    }

    public final void setAdapterPresenter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "<set-?>");
        this.adapterPresenter = dataAwareAdapterPresenter;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setResourceProvider(@NotNull OrderCancellationResourceProvider orderCancellationResourceProvider) {
        Intrinsics.checkNotNullParameter(orderCancellationResourceProvider, "<set-?>");
        this.resourceProvider = orderCancellationResourceProvider;
    }

    public final void setTracker(@NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "<set-?>");
        this.tracker = baseScreenPerformanceTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("EXTRA_ORDER_ID")) == null) {
            throw new IllegalStateException("Order id must not be null");
        }
        Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(EXT…der id must not be null\")");
        Timer timer = new TimerFactory().timer();
        timer.start();
        RdsOrderCancellationComponent.Factory factory = DaggerRdsOrderCancellationComponent.factory();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        factory.create(resources, this, string, (DeliveryDependencies) ComponentDependenciesKt.getDependencies(DeliveryDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        baseScreenPerformanceTracker.trackDiInject(timer.elapsed());
        return true;
    }

    public final void setViewModel(@NotNull RdsOrderCancellationReasonsViewModel rdsOrderCancellationReasonsViewModel) {
        Intrinsics.checkNotNullParameter(rdsOrderCancellationReasonsViewModel, "<set-?>");
        this.viewModel = rdsOrderCancellationReasonsViewModel;
    }
}
