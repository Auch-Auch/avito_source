package com.avito.android.delivery.summary;

import a2.a.a.k0.e.b;
import a2.a.a.k0.e.c;
import a2.a.a.k0.e.d;
import a2.a.a.k0.e.e;
import a2.g.r.g;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.SummaryState;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.delivery.R;
import com.avito.android.delivery.di.component.DaggerDeliveryRdsSummaryComponent;
import com.avito.android.delivery.di.component.DeliveryRdsSummaryComponent;
import com.avito.android.delivery.di.component.DeliverySummaryDependencies;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingActivityKt;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u0001kB\u0007¢\u0006\u0004\bi\u0010jJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010&\u001a\u00020%8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0016\u00106\u001a\u0002038\u0002@\u0002X.¢\u0006\u0006\n\u0004\b4\u00105R\"\u00108\u001a\u0002078\u0006@\u0006X.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010#R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\"\u0010S\u001a\u00020R8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0018\u0010Z\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010 R\"\u0010\\\u001a\u00020[8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010c\u001a\u00020b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010h¨\u0006l"}, d2 = {"Lcom/avito/android/delivery/summary/DeliveryRdsSummaryFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/delivery/summary/EditContactsListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/delivery/summary/ChangeAction;", "action", "editContacts", "(Lcom/avito/android/delivery/summary/ChangeAction;)V", "", "e", "Ljava/lang/String;", "searchContext", "f", "Z", "isCart", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryViewModel;", "viewModel", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryViewModel;", "getViewModel$delivery_release", "()Lcom/avito/android/delivery/summary/DeliveryRdsSummaryViewModel;", "setViewModel$delivery_release", "(Lcom/avito/android/delivery/summary/DeliveryRdsSummaryViewModel;)V", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryView;", "c", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryView;", "summaryView", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", g.a, "isMarketplace", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "setAttributedTextFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Landroidx/fragment/app/DialogFragment;", "d", "Landroidx/fragment/app/DialogFragment;", "dialogFragment", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "h", "source", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "getTracker", "()Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "setTracker", "(Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "<init>", "()V", "Factory", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsSummaryFragment extends BaseFragment implements EditContactsListener {
    @Inject
    public DataAwareAdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public AttributedTextFormatter attributedTextFormatter;
    public DeliveryRdsSummaryView c;
    public DialogFragment d;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    public String e;
    public boolean f;
    public boolean g;
    public String h;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public BaseScreenPerformanceTracker tracker;
    @Inject
    public DeliveryRdsSummaryViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/delivery/summary/DeliveryRdsSummaryFragment$Factory;", "", "", "searchContext", "Lcom/avito/android/SummaryState;", "summaryState", "", "isCart", "isMarketplace", "source", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryFragment;", "createInstance", "(Ljava/lang/String;Lcom/avito/android/SummaryState;ZZLjava/lang/String;)Lcom/avito/android/delivery/summary/DeliveryRdsSummaryFragment;", "payOrderId", "(Ljava/lang/String;)Lcom/avito/android/delivery/summary/DeliveryRdsSummaryFragment;", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ SummaryState a;
            public final /* synthetic */ String b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ String e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(SummaryState summaryState, String str, boolean z, boolean z2, String str2) {
                super(1);
                this.a = summaryState;
                this.b = str;
                this.c = z;
                this.d = z2;
                this.e = str2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable(DeliveryRdsSummaryActivityKt.EXTRA_SUMMARY_STATE, this.a);
                String str = this.b;
                if (str != null) {
                    bundle2.putString("search_context", str);
                }
                bundle2.putBoolean(DeliveryRdsStartOrderingActivityKt.EXTRA_CART_FLAG, this.c);
                bundle2.putBoolean(DeliveryRdsStartOrderingActivityKt.EXTRA_MARKETPLACE_FLAG, this.d);
                bundle2.putString("source", this.e);
                return Unit.INSTANCE;
            }
        }

        public static final class b extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.a = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putString(DeliveryRdsSummaryActivityKt.EXTRA_PAY_ORDER_ID, this.a);
                return Unit.INSTANCE;
            }
        }

        @NotNull
        public final DeliveryRdsSummaryFragment createInstance(@Nullable String str, @NotNull SummaryState summaryState, boolean z, boolean z2, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(summaryState, "summaryState");
            return (DeliveryRdsSummaryFragment) FragmentsKt.arguments(new DeliveryRdsSummaryFragment(), 3, new a(summaryState, str, z, z2, str2));
        }

        @NotNull
        public final DeliveryRdsSummaryFragment createInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "payOrderId");
            return (DeliveryRdsSummaryFragment) FragmentsKt.arguments(new DeliveryRdsSummaryFragment(), 1, new b(str));
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DeliveryRdsSummaryFragment a;

        public a(DeliveryRdsSummaryFragment deliveryRdsSummaryFragment) {
            this.a = deliveryRdsSummaryFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = this.a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    @Override // com.avito.android.delivery.summary.EditContactsListener
    public void editContacts(@NotNull ChangeAction changeAction) {
        Intrinsics.checkNotNullParameter(changeAction, "action");
        DeliveryRdsSummaryViewModel deliveryRdsSummaryViewModel = this.viewModel;
        if (deliveryRdsSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryRdsSummaryViewModel.getEditActionConsumer().accept(changeAction);
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
    public final AttributedTextFormatter getAttributedTextFormatter() {
        AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        return attributedTextFormatter2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
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
    public final SimpleRecyclerAdapter getRecyclerAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return simpleRecyclerAdapter;
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
    public final DeliveryRdsSummaryViewModel getViewModel$delivery_release() {
        DeliveryRdsSummaryViewModel deliveryRdsSummaryViewModel = this.viewModel;
        if (deliveryRdsSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return deliveryRdsSummaryViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        DeepLink deepLink = null;
        SummaryState summaryState = null;
        boolean z = true;
        if (i == 1) {
            if (intent != null) {
                deepLink = (DeepLink) intent.getParcelableExtra(PaymentProcessingConstants.EXTRA_FINAL_DEEPLINK);
            }
            DeliveryRdsSummaryViewModel deliveryRdsSummaryViewModel = this.viewModel;
            if (deliveryRdsSummaryViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (i2 != -1) {
                z = false;
            }
            deliveryRdsSummaryViewModel.onCompletePaymentResult(z, deepLink);
        } else if (i == 2) {
            if (intent != null) {
                summaryState = (SummaryState) intent.getParcelableExtra(DeliveryRdsSummaryActivityKt.EXTRA_SUMMARY_STATE);
            }
            if (summaryState != null) {
                DeliveryRdsSummaryViewModel deliveryRdsSummaryViewModel2 = this.viewModel;
                if (deliveryRdsSummaryViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                deliveryRdsSummaryViewModel2.updatePoint(summaryState.getMarkerId(), summaryState.getFiasGuid(), summaryState.getServiceId());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        baseScreenPerformanceTracker.startInit();
        View inflate = layoutInflater.inflate(R.layout.delivery_rds_fragment_summary, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ummary, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        DeliveryRdsSummaryViewModel deliveryRdsSummaryViewModel = this.viewModel;
        if (deliveryRdsSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryRdsSummaryViewModel.getDeepLinkChanges().observe(getViewLifecycleOwner(), new a2.a.a.k0.e.a(this));
        deliveryRdsSummaryViewModel.getPayUrlChanges().observe(getViewLifecycleOwner(), new b(this));
        deliveryRdsSummaryViewModel.getCloseScreenChanges().observe(getViewLifecycleOwner(), new c(this));
        deliveryRdsSummaryViewModel.getEditContactsChanges().observe(getViewLifecycleOwner(), new d(this));
        deliveryRdsSummaryViewModel.getEditPointChanges().observe(getViewLifecycleOwner(), new e(this, deliveryRdsSummaryViewModel));
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.header_toolbar);
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
        toolbar.setNavigationOnClickListener(new a(this));
        DeliveryRdsSummaryViewModel deliveryRdsSummaryViewModel2 = this.viewModel;
        if (deliveryRdsSummaryViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        deliveryRdsSummaryViewModel2.setAdapterPresenter(dataAwareAdapterPresenter);
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl = new DeliveryRdsSummaryViewImpl(view, analytics2, viewLifecycleOwner, simpleRecyclerAdapter, attributedTextFormatter2);
        this.c = deliveryRdsSummaryViewImpl;
        if (deliveryRdsSummaryViewImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryView");
        }
        DeliveryRdsSummaryViewModel deliveryRdsSummaryViewModel3 = this.viewModel;
        if (deliveryRdsSummaryViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryRdsSummaryViewImpl.bindTo(deliveryRdsSummaryViewModel3);
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

    public final void setAttributedTextFormatter(@NotNull AttributedTextFormatter attributedTextFormatter2) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter2, "<set-?>");
        this.attributedTextFormatter = attributedTextFormatter2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setTracker(@NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "<set-?>");
        this.tracker = baseScreenPerformanceTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: throw Illeg…tion(\"Arguments not set\")");
            String string = arguments.getString(DeliveryRdsSummaryActivityKt.EXTRA_PAY_ORDER_ID);
            this.e = arguments.getString("search_context");
            SummaryState summaryState = (SummaryState) arguments.getParcelable(DeliveryRdsSummaryActivityKt.EXTRA_SUMMARY_STATE);
            this.f = arguments.getBoolean(DeliveryRdsStartOrderingActivityKt.EXTRA_CART_FLAG);
            this.g = arguments.getBoolean(DeliveryRdsStartOrderingActivityKt.EXTRA_MARKETPLACE_FLAG);
            this.h = arguments.getString("source");
            Timer B1 = a2.b.a.a.a.B1();
            DeliveryRdsSummaryComponent.Factory factory = DaggerDeliveryRdsSummaryComponent.factory();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            String str = this.e;
            boolean z = this.f;
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            factory.create(requireActivity, resources, this, str, string, summaryState, z, (DeliverySummaryDependencies) ComponentDependenciesKt.getDependencies(DeliverySummaryDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
            BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
            if (baseScreenPerformanceTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            baseScreenPerformanceTracker.trackDiInject(B1.elapsed());
            return true;
        }
        throw new IllegalStateException("Arguments not set");
    }

    public final void setViewModel$delivery_release(@NotNull DeliveryRdsSummaryViewModel deliveryRdsSummaryViewModel) {
        Intrinsics.checkNotNullParameter(deliveryRdsSummaryViewModel, "<set-?>");
        this.viewModel = deliveryRdsSummaryViewModel;
    }
}
