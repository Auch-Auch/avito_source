package com.avito.android.order.feature.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import com.avito.android.beduin.ui.fragment.BeduinFragment;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.order.R;
import com.avito.android.order.di.component.DaggerOrderComponent;
import com.avito.android.order.di.component.OrderComponent;
import com.avito.android.order.di.component.OrderDependencies;
import com.avito.android.ui.fragments.TabBaseFragment;
import java.util.Calendar;
import java.util.TimeZone;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b&\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR%\u0010\"\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010%\u001a\u00020\u001c8B@\u0002X\u0002¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!¨\u0006("}, d2 = {"Lcom/avito/android/order/feature/order/OrderFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "onPause", "Lcom/avito/android/order/feature/order/OrderViewModel;", "viewModel", "Lcom/avito/android/order/feature/order/OrderViewModel;", "getViewModel", "()Lcom/avito/android/order/feature/order/OrderViewModel;", "setViewModel", "(Lcom/avito/android/order/feature/order/OrderViewModel;)V", "", "kotlin.jvm.PlatformType", "k", "Lkotlin/Lazy;", "getTimezoneId", "()Ljava/lang/String;", "timezoneId", "j", "getOrderId", AnalyticFieldsName.orderId, "<init>", "Companion", "order_release"}, k = 1, mv = {1, 4, 2})
public final class OrderFragment extends TabBaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final Lazy j = t6.c.lazy(new b(this));
    public final Lazy k = t6.c.lazy(c.a);
    @Inject
    public OrderViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/order/feature/order/OrderFragment$Companion;", "", "", AnalyticFieldsName.orderId, "Lcom/avito/android/order/feature/order/OrderFragment;", "newInstance$order_release", "(Ljava/lang/String;)Lcom/avito/android/order/feature/order/OrderFragment;", "newInstance", "<init>", "()V", "order_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final OrderFragment newInstance$order_release(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
            OrderFragment orderFragment = new OrderFragment();
            Bundle bundle = new Bundle(1);
            bundle.putString("key_order_id", str);
            Unit unit = Unit.INSTANCE;
            orderFragment.setArguments(bundle);
            return orderFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T> implements Observer<Unit> {
        public final /* synthetic */ OrderFragment a;

        public a(OrderFragment orderFragment) {
            this.a = orderFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Unit unit) {
            OrderFragment.access$setBeduinFragment(this.a);
        }
    }

    public static final class b extends Lambda implements Function0<String> {
        public final /* synthetic */ OrderFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(OrderFragment orderFragment) {
            super(0);
            this.a = orderFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            String string = this.a.requireArguments().getString("key_order_id");
            Intrinsics.checkNotNull(string);
            return string;
        }
    }

    public static final class c extends Lambda implements Function0<String> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            Calendar instance = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
            TimeZone timeZone = instance.getTimeZone();
            Intrinsics.checkNotNullExpressionValue(timeZone, "Calendar.getInstance().timeZone");
            return timeZone.getID();
        }
    }

    public static final void access$setBeduinFragment(OrderFragment orderFragment) {
        FragmentTransaction beginTransaction = orderFragment.getChildFragmentManager().beginTransaction();
        int i = R.id.fragment_container;
        BeduinFragment.Companion companion = BeduinFragment.Companion;
        StringBuilder L = a2.b.a.a.a.L("1/profile/order?orderId=");
        L.append((String) orderFragment.j.getValue());
        L.append("&location=");
        L.append((String) orderFragment.k.getValue());
        beginTransaction.replace(i, companion.create(new BeduinFragment.Params(L.toString(), Integer.valueOf(com.avito.android.ui_components.R.drawable.ic_back_24)))).commit();
    }

    @NotNull
    public final OrderViewModel getViewModel() {
        OrderViewModel orderViewModel = this.viewModel;
        if (orderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return orderViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.order_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…agment, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        OrderViewModel orderViewModel = this.viewModel;
        if (orderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        orderViewModel.onScreenInvisible();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        OrderViewModel orderViewModel = this.viewModel;
        if (orderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        orderViewModel.onScreenVisible();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        OrderViewModel orderViewModel = this.viewModel;
        if (orderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        orderViewModel.getFetchOrderEvent().observe(getViewLifecycleOwner(), new a(this));
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        OrderComponent.Factory factory = DaggerOrderComponent.factory();
        String str = (String) this.j.getValue();
        Intrinsics.checkNotNullExpressionValue(str, AnalyticFieldsName.orderId);
        factory.create(this, str, (OrderDependencies) ComponentDependenciesKt.getDependencies(OrderDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        return true;
    }

    public final void setViewModel(@NotNull OrderViewModel orderViewModel) {
        Intrinsics.checkNotNullParameter(orderViewModel, "<set-?>");
        this.viewModel = orderViewModel;
    }
}
