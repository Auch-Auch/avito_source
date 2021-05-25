package com.avito.android.safedeal.delivery_courier.summary;

import a2.a.a.i2.a.b.b;
import a2.a.a.i2.a.b.c;
import a2.a.a.i2.a.b.d;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.location_picker.di.LocationPickerModuleKt;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.safedeal.R;
import com.avito.android.safedeal.delivery_courier.di.component.DaggerDeliveryCourierSummaryComponent;
import com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierSummaryComponent;
import com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierSummaryDependencies;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001^B\u0007¢\u0006\u0004\b\\\u0010]J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bK\u0010LR\"\u0010O\u001a\u00020N8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010V\u001a\u00020U8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[¨\u0006_"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "getDeepLinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "setDeepLinkFactory", "(Lcom/avito/android/deep_linking/DeepLinkFactory;)V", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryResourceProvider;", "resourceProvider", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryResourceProvider;", "getResourceProvider", "()Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryResourceProvider;", "setResourceProvider", "(Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryResourceProvider;)V", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;", "viewModel", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;", "getViewModel", "()Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;", "setViewModel", "(Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "getTracker", "()Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "setTracker", "(Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryView;", "c", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryView;", "summaryView", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "<init>", "()V", "Factory", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierSummaryFragment extends BaseFragment {
    @Inject
    public DataAwareAdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public DeliveryCourierSummaryView c;
    @Inject
    public DeepLinkFactory deepLinkFactory;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public DeliveryCourierSummaryResourceProvider resourceProvider;
    @Inject
    public BaseScreenPerformanceTracker tracker;
    @Inject
    public DeliveryCourierSummaryViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryFragment$Factory;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "searchContext", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryFragment;", "createInstance", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryFragment;", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final DeliveryCourierSummaryFragment createInstance(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            Bundle bundle = new Bundle(1);
            bundle.putString("advert_id", str);
            bundle.putString("search_context", str2);
            DeliveryCourierSummaryFragment deliveryCourierSummaryFragment = new DeliveryCourierSummaryFragment();
            deliveryCourierSummaryFragment.setArguments(bundle);
            return deliveryCourierSummaryFragment;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DeliveryCourierSummaryFragment a;

        public a(DeliveryCourierSummaryFragment deliveryCourierSummaryFragment) {
            this.a = deliveryCourierSummaryFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = this.a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
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
    public final DeepLinkFactory getDeepLinkFactory() {
        DeepLinkFactory deepLinkFactory2 = this.deepLinkFactory;
        if (deepLinkFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkFactory");
        }
        return deepLinkFactory2;
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
    public final DeliveryCourierSummaryResourceProvider getResourceProvider() {
        DeliveryCourierSummaryResourceProvider deliveryCourierSummaryResourceProvider = this.resourceProvider;
        if (deliveryCourierSummaryResourceProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
        }
        return deliveryCourierSummaryResourceProvider;
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
    public final DeliveryCourierSummaryViewModel getViewModel() {
        DeliveryCourierSummaryViewModel deliveryCourierSummaryViewModel = this.viewModel;
        if (deliveryCourierSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return deliveryCourierSummaryViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        AddressParameter.Value value;
        super.onActivityResult(i, i2, intent);
        boolean z = true;
        if (i == 1) {
            DeepLink deepLink = intent != null ? (DeepLink) intent.getParcelableExtra(PaymentProcessingConstants.EXTRA_FINAL_DEEPLINK) : null;
            DeliveryCourierSummaryViewModel deliveryCourierSummaryViewModel = this.viewModel;
            if (deliveryCourierSummaryViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (i2 != -1) {
                z = false;
            }
            deliveryCourierSummaryViewModel.onCompletePaymentResult(z, deepLink);
        } else if (i == 2 && intent != null && (value = (AddressParameter.Value) intent.getParcelableExtra(LocationPickerModuleKt.EXTRA_ADDRESS_RESULT)) != null) {
            DeliveryCourierSummaryViewModel deliveryCourierSummaryViewModel2 = this.viewModel;
            if (deliveryCourierSummaryViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            deliveryCourierSummaryViewModel2.onLocationSelected(value);
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
        View inflate = layoutInflater.inflate(R.layout.fragment_delivery_courier_summary, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ummary, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        DeliveryCourierSummaryViewModel deliveryCourierSummaryViewModel = this.viewModel;
        if (deliveryCourierSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryCourierSummaryViewModel.getDeepLinkChanges().observe(getViewLifecycleOwner(), new a2.a.a.i2.a.b.a(this));
        deliveryCourierSummaryViewModel.getSelectDeepLinkChanges().observe(getViewLifecycleOwner(), new b(this, deliveryCourierSummaryViewModel));
        deliveryCourierSummaryViewModel.getPayUrlChanges().observe(getViewLifecycleOwner(), new c(this));
        deliveryCourierSummaryViewModel.getCloseScreenChanges().observe(getViewLifecycleOwner(), new d(this));
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
        toolbar.setNavigationOnClickListener(new a(this));
        DeliveryCourierSummaryViewModel deliveryCourierSummaryViewModel2 = this.viewModel;
        if (deliveryCourierSummaryViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        deliveryCourierSummaryViewModel2.setAdapterPresenter(dataAwareAdapterPresenter);
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
        DeliveryCourierSummaryViewImpl deliveryCourierSummaryViewImpl = new DeliveryCourierSummaryViewImpl(view, analytics2, viewLifecycleOwner, simpleRecyclerAdapter);
        this.c = deliveryCourierSummaryViewImpl;
        if (deliveryCourierSummaryViewImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryView");
        }
        DeliveryCourierSummaryViewModel deliveryCourierSummaryViewModel3 = this.viewModel;
        if (deliveryCourierSummaryViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryCourierSummaryViewImpl.bindTo(deliveryCourierSummaryViewModel3);
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

    public final void setDeepLinkFactory(@NotNull DeepLinkFactory deepLinkFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkFactory2, "<set-?>");
        this.deepLinkFactory = deepLinkFactory2;
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

    public final void setResourceProvider(@NotNull DeliveryCourierSummaryResourceProvider deliveryCourierSummaryResourceProvider) {
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryResourceProvider, "<set-?>");
        this.resourceProvider = deliveryCourierSummaryResourceProvider;
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
            String string = arguments.getString("advert_id");
            String string2 = arguments.getString("search_context");
            Timer B1 = a2.b.a.a.a.B1();
            DeliveryCourierSummaryComponent.Factory factory = DaggerDeliveryCourierSummaryComponent.factory();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            factory.create(requireActivity, resources, this, string, string2, (DeliveryCourierSummaryDependencies) ComponentDependenciesKt.getDependencies(DeliveryCourierSummaryDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
            BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
            if (baseScreenPerformanceTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            baseScreenPerformanceTracker.trackDiInject(B1.elapsed());
            return true;
        }
        throw new IllegalStateException("Arguments not set");
    }

    public final void setViewModel(@NotNull DeliveryCourierSummaryViewModel deliveryCourierSummaryViewModel) {
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryViewModel, "<set-?>");
        this.viewModel = deliveryCourierSummaryViewModel;
    }
}
