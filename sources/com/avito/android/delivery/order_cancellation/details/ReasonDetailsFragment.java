package com.avito.android.delivery.order_cancellation.details;

import android.app.Activity;
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
import com.avito.android.delivery.R;
import com.avito.android.delivery.di.component.DaggerReasonDetailsComponent;
import com.avito.android.delivery.di.component.DeliveryDependencies;
import com.avito.android.delivery.di.component.ReasonDetailsComponent;
import com.avito.android.delivery.order_cancellation.OrderCancellationResourceProvider;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationRouter;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.model.ReasonRds;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.KeyboardSubscription;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b@\u0010\u0017J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationRouter;", "d", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationRouter;", "router", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsViewModel;", "viewModel", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsViewModel;", "getViewModel", "()Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsViewModel;", "setViewModel", "(Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsViewModel;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/util/KeyboardSubscription;", "c", "Lcom/avito/android/util/KeyboardSubscription;", "keyboardSubscription", "Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", "resourceProvider", "Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", "getResourceProvider", "()Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", "setResourceProvider", "(Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;)V", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "Lcom/avito/android/lib/design/button/Button;", "e", "Lcom/avito/android/lib/design/button/Button;", "cancelButton", "<init>", "Factory", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class ReasonDetailsFragment extends BaseFragment {
    @Inject
    public DataAwareAdapterPresenter adapterPresenter;
    public KeyboardSubscription c;
    public RdsOrderCancellationRouter d;
    public Button e;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public OrderCancellationResourceProvider resourceProvider;
    @Inject
    public ReasonDetailsViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsFragment$Factory;", "", "Lcom/avito/android/remote/model/ReasonRds;", "reason", "", AnalyticFieldsName.orderId, "", "commentMaxLength", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsFragment;", "createInstance", "(Lcom/avito/android/remote/model/ReasonRds;Ljava/lang/String;I)Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsFragment;", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final ReasonDetailsFragment createInstance(@NotNull ReasonRds reasonRds, @NotNull String str, int i) {
            Intrinsics.checkNotNullParameter(reasonRds, "reason");
            Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
            Bundle bundle = new Bundle(3);
            bundle.putParcelable(ReasonDetailsFragmentKt.EXTRA_REASON, reasonRds);
            bundle.putString("EXTRA_ORDER_ID", str);
            bundle.putInt(ReasonDetailsFragmentKt.EXTRA_COMMENT_MAX_LENGTH, i);
            ReasonDetailsFragment reasonDetailsFragment = new ReasonDetailsFragment();
            reasonDetailsFragment.setArguments(bundle);
            return reasonDetailsFragment;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ReasonDetailsFragment a;

        public a(ReasonDetailsFragment reasonDetailsFragment) {
            this.a = reasonDetailsFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.getViewModel().getCancelOrderButtonClickConsumer().accept(Unit.INSTANCE);
        }
    }

    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ ReasonDetailsFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ReasonDetailsFragment reasonDetailsFragment) {
            super(1);
            this.a = reasonDetailsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            if (bool.booleanValue()) {
                Views.hide(ReasonDetailsFragment.access$getCancelButton$p(this.a));
                ReasonDetailsFragment.access$getCancelButton$p(this.a).setAlpha(0.0f);
            } else {
                Views.show(ReasonDetailsFragment.access$getCancelButton$p(this.a));
                ReasonDetailsFragment.access$getCancelButton$p(this.a).animate().alpha(1.0f).setDuration(350);
            }
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ Button access$getCancelButton$p(ReasonDetailsFragment reasonDetailsFragment) {
        Button button = reasonDetailsFragment.e;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
        }
        return button;
    }

    public static final /* synthetic */ RdsOrderCancellationRouter access$getRouter$p(ReasonDetailsFragment reasonDetailsFragment) {
        RdsOrderCancellationRouter rdsOrderCancellationRouter = reasonDetailsFragment.d;
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
    public final ReasonDetailsViewModel getViewModel() {
        ReasonDetailsViewModel reasonDetailsViewModel = this.viewModel;
        if (reasonDetailsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return reasonDetailsViewModel;
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
            this.d = rdsOrderCancellationRouter;
            return;
        }
        throw new IllegalStateException("Parent activity must implement RdsOrderCancellationRouter");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.delivery_rds_reason_details_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        KeyboardSubscription keyboardSubscription = this.c;
        if (keyboardSubscription != null) {
            keyboardSubscription.dispose();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24_black);
        toolbar.setNavigationOnClickListener(new a2.a.a.k0.b.b.a(this));
        ReasonDetailsViewModel reasonDetailsViewModel = this.viewModel;
        if (reasonDetailsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        reasonDetailsViewModel.setAdapterPresenter(dataAwareAdapterPresenter);
        View findViewById2 = view.findViewById(R.id.reason_details_recycler);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        recyclerView.setAdapter(simpleRecyclerAdapter);
        View findViewById3 = view.findViewById(R.id.button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById3;
        OrderCancellationResourceProvider orderCancellationResourceProvider = this.resourceProvider;
        if (orderCancellationResourceProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
        }
        button.setText(orderCancellationResourceProvider.getCancelOrderButtonTitle());
        button.setOnClickListener(new a(this));
        this.e = button;
        FragmentActivity activity = getActivity();
        KeyboardSubscription keyboardSubscription = null;
        if (activity != null) {
            keyboardSubscription = Keyboards.addSoftKeyboardVisibilityListener$default((Activity) activity, false, (Function1) new b(this), 1, (Object) null);
        }
        this.c = keyboardSubscription;
        ReasonDetailsViewModel reasonDetailsViewModel2 = this.viewModel;
        if (reasonDetailsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        reasonDetailsViewModel2.getSnackbarChanges().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.delivery.order_cancellation.details.ReasonDetailsFragment$bindTo$$inlined$observeNotNull$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    View view2 = ReasonDetailsFragment.this.getView();
                    if (view2 != null) {
                        Views.showSnackBar$default(view2, t2, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
                    }
                }
            }
        });
        reasonDetailsViewModel2.getCloseScreenChanges().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.delivery.order_cancellation.details.ReasonDetailsFragment$bindTo$$inlined$observeNotNull$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    ReasonDetailsFragment.access$getRouter$p(ReasonDetailsFragment.this).forceLeaveScreen(t.intValue());
                }
            }
        });
        reasonDetailsViewModel2.getButtonStateChanges().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.delivery.order_cancellation.details.ReasonDetailsFragment$bindTo$$inlined$observeNotNull$3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    ReasonDetailsFragment.access$getCancelButton$p(ReasonDetailsFragment.this).setLoading(t.booleanValue());
                }
            }
        });
    }

    public final void setAdapterPresenter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "<set-?>");
        this.adapterPresenter = dataAwareAdapterPresenter;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setResourceProvider(@NotNull OrderCancellationResourceProvider orderCancellationResourceProvider) {
        Intrinsics.checkNotNullParameter(orderCancellationResourceProvider, "<set-?>");
        this.resourceProvider = orderCancellationResourceProvider;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: throw Illeg…uments must not be null\")");
            ReasonRds reasonRds = (ReasonRds) arguments.getParcelable(ReasonDetailsFragmentKt.EXTRA_REASON);
            if (reasonRds != null) {
                Intrinsics.checkNotNullExpressionValue(reasonRds, "args.getParcelable<Reaso…Reason must not be null\")");
                String string = arguments.getString("EXTRA_ORDER_ID");
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "args.getString(EXTRA_ORD…der id must not be null\")");
                    arguments.getInt(ReasonDetailsFragmentKt.EXTRA_COMMENT_MAX_LENGTH, 1000);
                    ReasonDetailsComponent.Builder viewModelFragment = DaggerReasonDetailsComponent.builder().viewModelFragment(this);
                    Resources resources = getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "resources");
                    viewModelFragment.resources(resources).reason(reasonRds).orderId(string).deliveryDependencies((DeliveryDependencies) ComponentDependenciesKt.getDependencies(DeliveryDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).build().inject(this);
                    return true;
                }
                throw new IllegalStateException("Order id must not be null");
            }
            throw new IllegalStateException("Reason must not be null");
        }
        throw new IllegalStateException("Arguments must not be null");
    }

    public final void setViewModel(@NotNull ReasonDetailsViewModel reasonDetailsViewModel) {
        Intrinsics.checkNotNullParameter(reasonDetailsViewModel, "<set-?>");
        this.viewModel = reasonDetailsViewModel;
    }
}
