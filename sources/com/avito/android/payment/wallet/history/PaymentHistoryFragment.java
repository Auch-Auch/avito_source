package com.avito.android.payment.wallet.history;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.payment.R;
import com.avito.android.payment.di.component.DaggerPaymentHistoryComponent;
import com.avito.android.payment.di.component.PaymentDependencies;
import com.avito.android.payment.di.module.PaymentHistoryModule;
import com.avito.android.payment.wallet.history.HistoryLoadingState;
import com.avito.android.payment.wallet.history.details.PaymentDetailsType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.history.PaymentHistoryListElement;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b%\u0010&R:\u0010-\u001a&\u0012\f\u0012\n **\u0004\u0018\u00010)0) **\u0012\u0012\f\u0012\n **\u0004\u0018\u00010)0)\u0018\u00010(0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R:\u00100\u001a&\u0012\f\u0012\n **\u0004\u0018\u00010.0. **\u0012\u0012\f\u0012\n **\u0004\u0018\u00010.0.\u0018\u00010(0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010,R:\u00102\u001a&\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u0004 **\u0012\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u0004\u0018\u00010(0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010,R\"\u00104\u001a\u0002038\u0006@\u0006X.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006;"}, d2 = {"Lcom/avito/android/payment/wallet/history/PaymentHistoryFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDetach", "()V", "Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModelFactory;", "paymentHistoryViewModelFactory", "Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModelFactory;", "getPaymentHistoryViewModelFactory", "()Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModelFactory;", "setPaymentHistoryViewModelFactory", "(Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModelFactory;)V", "Lio/reactivex/disposables/CompositeDisposable;", "e", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/payment/wallet/history/PaymentHistoryAdapter;", "f", "Lcom/avito/android/payment/wallet/history/PaymentHistoryAdapter;", "paymentHistoryAdapter", "Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModel;", "d", "Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModel;", "paymentHistoryViewModel", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement$Order;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "orderClicksRelay", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement$Operation;", AuthSource.SEND_ABUSE, "operationsClickRelay", "c", "refreshClicksRelay", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentHistoryFragment extends Fragment {
    public final PublishRelay<PaymentHistoryListElement.Operation> a = PublishRelay.create();
    public final PublishRelay<PaymentHistoryListElement.Order> b = PublishRelay.create();
    public final PublishRelay<Unit> c = PublishRelay.create();
    public PaymentHistoryViewModel d;
    public final CompositeDisposable e = new CompositeDisposable();
    public final PaymentHistoryAdapter f = new PaymentHistoryAdapter(new j(this), new k(this), new l(this));
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public PaymentHistoryViewModelFactory paymentHistoryViewModelFactory;

    public static final class a<T> implements Consumer<PaymentHistoryListElement.Operation> {
        public final /* synthetic */ PaymentHistoryFragment a;

        public a(PaymentHistoryFragment paymentHistoryFragment) {
            this.a = paymentHistoryFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(PaymentHistoryListElement.Operation operation) {
            PaymentHistoryFragment paymentHistoryFragment = this.a;
            paymentHistoryFragment.startActivity(paymentHistoryFragment.getIntentFactory().paymentHistoryDetailsIntent(PaymentDetailsType.OPERATION, operation.getOperationId()));
        }
    }

    public static final class b<T> implements Consumer<PaymentHistoryListElement.Order> {
        public final /* synthetic */ PaymentHistoryFragment a;

        public b(PaymentHistoryFragment paymentHistoryFragment) {
            this.a = paymentHistoryFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(PaymentHistoryListElement.Order order) {
            PaymentHistoryFragment paymentHistoryFragment = this.a;
            paymentHistoryFragment.startActivity(paymentHistoryFragment.getIntentFactory().paymentHistoryDetailsIntent(PaymentDetailsType.OPERATION, order.getOrderId()));
        }
    }

    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ PaymentHistoryFragment a;

        public c(PaymentHistoryFragment paymentHistoryFragment) {
            this.a = paymentHistoryFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            PaymentHistoryFragment.access$getPaymentHistoryViewModel$p(this.a).retry();
        }
    }

    public static final class d implements SwipeRefreshLayout.OnRefreshListener {
        public final /* synthetic */ PaymentHistoryFragment a;

        public d(PaymentHistoryFragment paymentHistoryFragment) {
            this.a = paymentHistoryFragment;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            PaymentHistoryFragment.access$getPaymentHistoryViewModel$p(this.a).refresh();
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ PaymentHistoryFragment a;

        public e(PaymentHistoryFragment paymentHistoryFragment) {
            this.a = paymentHistoryFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PaymentHistoryFragment.access$getPaymentHistoryViewModel$p(this.a).refresh();
        }
    }

    public static final class f<T> implements Observer<PagedList<PaymentHistoryListElement>> {
        public final /* synthetic */ PaymentHistoryFragment a;

        public f(PaymentHistoryFragment paymentHistoryFragment) {
            this.a = paymentHistoryFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.payment.wallet.history.PaymentHistoryAdapter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public void onChanged(PagedList<PaymentHistoryListElement> pagedList) {
            PagedList<PaymentHistoryListElement> pagedList2 = pagedList;
            if (pagedList2 != null) {
                this.a.f.submitList(pagedList2);
            }
        }
    }

    public static final class g<T> implements Observer<Boolean> {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ RecyclerView b;

        public g(TextView textView, RecyclerView recyclerView) {
            this.a = textView;
            this.b = recyclerView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Boolean bool) {
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                Views.show(this.a);
                Views.hide(this.b);
                return;
            }
            Views.hide(this.a);
            Views.show(this.b);
        }
    }

    public static final class h<T> implements Observer<HistoryLoadingState> {
        public final /* synthetic */ PaymentHistoryFragment a;
        public final /* synthetic */ SwipeRefreshLayout b;
        public final /* synthetic */ FrameLayout c;
        public final /* synthetic */ LinearLayout d;
        public final /* synthetic */ TextView e;

        public h(PaymentHistoryFragment paymentHistoryFragment, SwipeRefreshLayout swipeRefreshLayout, FrameLayout frameLayout, LinearLayout linearLayout, TextView textView) {
            this.a = paymentHistoryFragment;
            this.b = swipeRefreshLayout;
            this.c = frameLayout;
            this.d = linearLayout;
            this.e = textView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(HistoryLoadingState historyLoadingState) {
            HistoryLoadingState historyLoadingState2 = historyLoadingState;
            if (historyLoadingState2 instanceof HistoryLoadingState.Loaded) {
                Views.show(this.b);
                Views.hide(this.c);
                Views.hide(this.d);
                SwipeRefreshLayout swipeRefreshLayout = this.b;
                Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
                swipeRefreshLayout.setRefreshing(false);
                this.a.f.setNetworkState(historyLoadingState2);
            } else if (historyLoadingState2 instanceof HistoryLoadingState.Loading) {
                Views.hide(this.b);
                Views.show(this.c);
                Views.hide(this.d);
            } else if (historyLoadingState2 instanceof HistoryLoadingState.Error) {
                Views.hide(this.b);
                Views.hide(this.c);
                Views.show(this.d);
                TextView textView = this.e;
                Intrinsics.checkNotNullExpressionValue(textView, "errorTextView");
                textView.setText(((HistoryLoadingState.Error) historyLoadingState2).getErrorResult().getMessage());
            }
        }
    }

    public static final class i<T> implements Observer<HistoryLoadingState> {
        public final /* synthetic */ PaymentHistoryFragment a;

        public i(PaymentHistoryFragment paymentHistoryFragment) {
            this.a = paymentHistoryFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(HistoryLoadingState historyLoadingState) {
            HistoryLoadingState historyLoadingState2 = historyLoadingState;
            if (historyLoadingState2 != null) {
                this.a.f.setNetworkState(historyLoadingState2);
            }
        }
    }

    public static final class j extends Lambda implements Function1<PaymentHistoryListElement.Order, Unit> {
        public final /* synthetic */ PaymentHistoryFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(PaymentHistoryFragment paymentHistoryFragment) {
            super(1);
            this.a = paymentHistoryFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(PaymentHistoryListElement.Order order) {
            PaymentHistoryListElement.Order order2 = order;
            Intrinsics.checkNotNullParameter(order2, "order");
            this.a.b.accept(order2);
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function1<PaymentHistoryListElement.Operation, Unit> {
        public final /* synthetic */ PaymentHistoryFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(PaymentHistoryFragment paymentHistoryFragment) {
            super(1);
            this.a = paymentHistoryFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(PaymentHistoryListElement.Operation operation) {
            PaymentHistoryListElement.Operation operation2 = operation;
            Intrinsics.checkNotNullParameter(operation2, "operation");
            this.a.a.accept(operation2);
            return Unit.INSTANCE;
        }
    }

    public static final class l extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PaymentHistoryFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(PaymentHistoryFragment paymentHistoryFragment) {
            super(0);
            this.a = paymentHistoryFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            PublishRelay publishRelay = this.a.c;
            Unit unit = Unit.INSTANCE;
            publishRelay.accept(unit);
            return unit;
        }
    }

    public static final /* synthetic */ PaymentHistoryViewModel access$getPaymentHistoryViewModel$p(PaymentHistoryFragment paymentHistoryFragment) {
        PaymentHistoryViewModel paymentHistoryViewModel = paymentHistoryFragment.d;
        if (paymentHistoryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentHistoryViewModel");
        }
        return paymentHistoryViewModel;
    }

    @NotNull
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final PaymentHistoryViewModelFactory getPaymentHistoryViewModelFactory() {
        PaymentHistoryViewModelFactory paymentHistoryViewModelFactory2 = this.paymentHistoryViewModelFactory;
        if (paymentHistoryViewModelFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentHistoryViewModelFactory");
        }
        return paymentHistoryViewModelFactory2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        String string = requireArguments().getString("history_id");
        if (string != null) {
            Intrinsics.checkNotNullExpressionValue(string, "requireArguments().getSt…ory_id must not be null\")");
            DaggerPaymentHistoryComponent.builder().paymentDependencies((PaymentDependencies) ComponentDependenciesKt.getDependencies(PaymentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).paymentHistoryModule(new PaymentHistoryModule(string)).build().inject(this);
            PaymentHistoryViewModelFactory paymentHistoryViewModelFactory2 = this.paymentHistoryViewModelFactory;
            if (paymentHistoryViewModelFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paymentHistoryViewModelFactory");
            }
            ViewModel viewModel = ViewModelProviders.of(this, paymentHistoryViewModelFactory2).get(PaymentHistoryViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…oryViewModel::class.java]");
            this.d = (PaymentHistoryViewModel) viewModel;
            CompositeDisposable compositeDisposable = this.e;
            PublishRelay<PaymentHistoryListElement.Operation> publishRelay = this.a;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Disposable subscribe = publishRelay.throttleFirst(300, timeUnit).subscribe(new a(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "operationsClickRelay\n   …          )\n            }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            CompositeDisposable compositeDisposable2 = this.e;
            Disposable subscribe2 = this.b.throttleFirst(300, timeUnit).subscribe(new b(this));
            Intrinsics.checkNotNullExpressionValue(subscribe2, "orderClicksRelay\n       …r.orderId))\n            }");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            CompositeDisposable compositeDisposable3 = this.e;
            Disposable subscribe3 = this.c.throttleFirst(300, timeUnit).subscribe(new c(this));
            Intrinsics.checkNotNullExpressionValue(subscribe3, "refreshClicksRelay\n     …del.retry()\n            }");
            DisposableKt.plusAssign(compositeDisposable3, subscribe3);
            return;
        }
        throw new IllegalArgumentException("history_id must not be null");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.payment_history_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        this.e.dispose();
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        TextView textView = (TextView) view.findViewById(R.id.empty_view);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.loading_indicator);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.error);
        TextView textView2 = (TextView) view.findViewById(R.id.error_text_view);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(requireContext, com.avito.android.lib.design.R.attr.white));
        swipeRefreshLayout.setOnRefreshListener(new d(this));
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setAdapter(this.f);
        ((Button) view.findViewById(R.id.error_refresh_button)).setOnClickListener(new e(this));
        PaymentHistoryViewModel paymentHistoryViewModel = this.d;
        if (paymentHistoryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentHistoryViewModel");
        }
        paymentHistoryViewModel.getPaymentHistory().observe(getViewLifecycleOwner(), new f(this));
        PaymentHistoryViewModel paymentHistoryViewModel2 = this.d;
        if (paymentHistoryViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentHistoryViewModel");
        }
        paymentHistoryViewModel2.getListIsEmpty().observe(getViewLifecycleOwner(), new g(textView, recyclerView));
        PaymentHistoryViewModel paymentHistoryViewModel3 = this.d;
        if (paymentHistoryViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentHistoryViewModel");
        }
        paymentHistoryViewModel3.getLoadingState().observe(getViewLifecycleOwner(), new h(this, swipeRefreshLayout, frameLayout, linearLayout, textView2));
        PaymentHistoryViewModel paymentHistoryViewModel4 = this.d;
        if (paymentHistoryViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentHistoryViewModel");
        }
        paymentHistoryViewModel4.getPageLoadingState().observe(getViewLifecycleOwner(), new i(this));
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPaymentHistoryViewModelFactory(@NotNull PaymentHistoryViewModelFactory paymentHistoryViewModelFactory2) {
        Intrinsics.checkNotNullParameter(paymentHistoryViewModelFactory2, "<set-?>");
        this.paymentHistoryViewModelFactory = paymentHistoryViewModelFactory2;
    }
}
