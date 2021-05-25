package com.avito.android.shop.filter;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.remote.model.CaseText;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.shop.R;
import com.avito.android.shop.detailed.di.ShopDetailedDependencies;
import com.avito.android.shop.filter.ShopsFilterPresenter;
import com.avito.android.shop.filter.di.DaggerShopsFilterComponent;
import com.avito.android.shop.filter.di.ShopsFilterComponent;
import com.avito.android.shop.filter.di.ShopsFilterModule;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.Constants;
import com.avito.android.util.DeviceMetrics;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bH\u0010\u0011J-\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0011J\u001f\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\rH\u0016¢\u0006\u0004\b!\u0010\u0011J)\u0010'\u001a\u00020\r2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u00020)2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0006@\u0006X.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010B\u001a\u00020A8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006I"}, d2 = {"Lcom/avito/android/shop/filter/ShopsFilterFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/shop/filter/ShopsFilterPresenter$Router;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onDestroyView", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "searchParameters", "Lcom/avito/android/remote/model/CaseText;", "locationNames", "showResults", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;Lcom/avito/android/remote/model/CaseText;)V", "Lcom/avito/android/remote/model/Location;", "location", "showLocationScreen", "(Lcom/avito/android/remote/model/Location;)V", "onBackClicked", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/util/DeviceMetrics;", "getDeviceMetrics", "()Lcom/avito/android/util/DeviceMetrics;", "setDeviceMetrics", "(Lcom/avito/android/util/DeviceMetrics;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/shop/filter/ShopsFilterPresenter;", "presenter", "Lcom/avito/android/shop/filter/ShopsFilterPresenter;", "getPresenter", "()Lcom/avito/android/shop/filter/ShopsFilterPresenter;", "setPresenter", "(Lcom/avito/android/shop/filter/ShopsFilterPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopsFilterFragment extends BaseFragment implements ShopsFilterPresenter.Router {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    @Inject
    public DeviceMetrics deviceMetrics;
    @Inject
    public ShopsFilterPresenter presenter;

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
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
    public final DeviceMetrics getDeviceMetrics() {
        DeviceMetrics deviceMetrics2 = this.deviceMetrics;
        if (deviceMetrics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceMetrics");
        }
        return deviceMetrics2;
    }

    @NotNull
    public final ShopsFilterPresenter getPresenter() {
        ShopsFilterPresenter shopsFilterPresenter = this.presenter;
        if (shopsFilterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return shopsFilterPresenter;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == 1 && i2 == -1 && intent != null) {
            Location location = (Location) intent.getParcelableExtra("location");
            ShopsFilterPresenter shopsFilterPresenter = this.presenter;
            if (shopsFilterPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            shopsFilterPresenter.onLocationSelected(location);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.avito.android.shop.filter.ShopsFilterPresenter.Router
    public void onBackClicked() {
        requireActivity().onBackPressed();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.shops_filter, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ShopsFilterPresenter shopsFilterPresenter = this.presenter;
        if (shopsFilterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopsFilterPresenter.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ShopsFilterPresenter shopsFilterPresenter = this.presenter;
        if (shopsFilterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putBundle("presenter", shopsFilterPresenter.onSaveInstanceState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ShopsFilterPresenter shopsFilterPresenter = this.presenter;
        if (shopsFilterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopsFilterPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        ShopsFilterPresenter shopsFilterPresenter = this.presenter;
        if (shopsFilterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopsFilterPresenter.detachRouter();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ShopsFilterPresenter shopsFilterPresenter = this.presenter;
        if (shopsFilterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        DeviceMetrics deviceMetrics2 = this.deviceMetrics;
        if (deviceMetrics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceMetrics");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        ShopsFilterViewImpl shopsFilterViewImpl = new ShopsFilterViewImpl(view, shopsFilterPresenter, deviceMetrics2, analytics2);
        ShopsFilterPresenter shopsFilterPresenter2 = this.presenter;
        if (shopsFilterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopsFilterPresenter2.attachView(shopsFilterViewImpl);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeviceMetrics(@NotNull DeviceMetrics deviceMetrics2) {
        Intrinsics.checkNotNullParameter(deviceMetrics2, "<set-?>");
        this.deviceMetrics = deviceMetrics2;
    }

    public final void setPresenter(@NotNull ShopsFilterPresenter shopsFilterPresenter) {
        Intrinsics.checkNotNullParameter(shopsFilterPresenter, "<set-?>");
        this.presenter = shopsFilterPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: throw Runti… not passed to fragment\")");
            Parcelable parcelable = arguments.getParcelable("category");
            Intrinsics.checkNotNull(parcelable);
            ShopsFilterComponent.Builder withSearchParams = DaggerShopsFilterComponent.builder().shopDetailedDependencies((ShopDetailedDependencies) ComponentDependenciesKt.getDependencies(ShopDetailedDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).locationDependencies((LocationDependencies) ComponentDependenciesKt.getDependencies(LocationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withPresenterState(bundle != null ? bundle.getBundle("presenter") : null).withSearchParams((ShopsSearchParameters) parcelable);
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            withSearchParams.withResources(resources).shopsFilterModule(new ShopsFilterModule()).build().inject(this);
            return true;
        }
        throw new RuntimeException("SearchParameters are not passed to fragment");
    }

    @Override // com.avito.android.shop.filter.ShopsFilterPresenter.Router
    public void showLocationScreen(@Nullable Location location) {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(activityIntentFactory2.defaultLocationIntent(location), 1);
    }

    @Override // com.avito.android.shop.filter.ShopsFilterPresenter.Router
    public void showResults(@NotNull ShopsSearchParameters shopsSearchParameters, @NotNull CaseText caseText) {
        Intrinsics.checkNotNullParameter(shopsSearchParameters, "searchParameters");
        Intrinsics.checkNotNullParameter(caseText, "locationNames");
        FragmentActivity requireActivity = requireActivity();
        Intent intent = new Intent();
        intent.putExtra("search_params", shopsSearchParameters);
        intent.putExtra(Constants.LOCATION_NAMES, (Parcelable) caseText);
        Unit unit = Unit.INSTANCE;
        requireActivity.setResult(-1, intent);
        requireActivity.finish();
    }
}
