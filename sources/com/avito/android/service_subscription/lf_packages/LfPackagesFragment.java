package com.avito.android.service_subscription.lf_packages;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.service_subscription.R;
import com.avito.android.service_subscription.di.DaggerSubscriptionFragmentComponent;
import com.avito.android.service_subscription.di.LfPresenter;
import com.avito.android.service_subscription.di.SubscriptionFragmentComponent;
import com.avito.android.service_subscription.di.SubscriptionFragmentDependencies;
import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionPresenter;
import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionViewImpl;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.Kundle;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b(\u0010\u0014J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/avito/android/service_subscription/lf_packages/LfPackagesFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onBackPressed", "()Z", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionPresenter;", "presenter", "Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionPresenter;", "getPresenter", "()Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionPresenter;", "setPresenter", "(Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionPresenter;)V", "<init>", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class LfPackagesFragment extends BaseFragment implements OnBackPressedListener {
    @Inject
    public Analytics analytics;
    @Inject
    @LfPresenter
    public ServiceSubscriptionPresenter presenter;

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final ServiceSubscriptionPresenter getPresenter() {
        ServiceSubscriptionPresenter serviceSubscriptionPresenter = this.presenter;
        if (serviceSubscriptionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return serviceSubscriptionPresenter;
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        requireActivity().onBackPressed();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.service_subscription_fragment, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ServiceSubscriptionPresenter serviceSubscriptionPresenter = this.presenter;
        if (serviceSubscriptionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        serviceSubscriptionPresenter.detachView();
        ServiceSubscriptionPresenter serviceSubscriptionPresenter2 = this.presenter;
        if (serviceSubscriptionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        serviceSubscriptionPresenter2.detachBackPressedListener();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ServiceSubscriptionPresenter serviceSubscriptionPresenter = this.presenter;
        if (serviceSubscriptionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("subscription_state", serviceSubscriptionPresenter.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        ServiceSubscriptionViewImpl serviceSubscriptionViewImpl = new ServiceSubscriptionViewImpl(view, analytics2);
        ServiceSubscriptionPresenter serviceSubscriptionPresenter = this.presenter;
        if (serviceSubscriptionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        serviceSubscriptionPresenter.attachView(serviceSubscriptionViewImpl);
        ServiceSubscriptionPresenter serviceSubscriptionPresenter2 = this.presenter;
        if (serviceSubscriptionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        serviceSubscriptionPresenter2.attachBackPressedListener(this);
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setPresenter(@NotNull ServiceSubscriptionPresenter serviceSubscriptionPresenter) {
        Intrinsics.checkNotNullParameter(serviceSubscriptionPresenter, "<set-?>");
        this.presenter = serviceSubscriptionPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Kundle kundle = bundle != null ? (Kundle) bundle.getParcelable("subscription_state") : null;
        SubscriptionFragmentComponent.Builder dependentOn = DaggerSubscriptionFragmentComponent.builder().dependentOn((SubscriptionFragmentDependencies) ComponentDependenciesKt.getDependencies(SubscriptionFragmentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        SubscriptionFragmentComponent.Builder withState = dependentOn.withResources(resources).withState(kundle);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        withState.withContext(requireContext).build().inject(this);
        return true;
    }
}
