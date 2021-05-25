package com.avito.android.location_list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.location_list.di.DaggerLocationListComponent;
import com.avito.android.location_list.di.LocationListComponent;
import com.avito.android.location_list.di.LocationListDependencies;
import com.avito.android.location_list.di.LocationListModule;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.remote.model.Location;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\bb\u0010\rJ\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010\rJ\u000f\u0010!\u001a\u00020\tH\u0016¢\u0006\u0004\b!\u0010\rJ\u000f\u0010\"\u001a\u00020\tH\u0016¢\u0006\u0004\b\"\u0010\rJ\u000f\u0010#\u001a\u00020\tH\u0016¢\u0006\u0004\b#\u0010\rJ\u0017\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u000fH\u0016¢\u0006\u0004\b%\u0010\u0015J\u000f\u0010&\u001a\u00020\tH\u0016¢\u0006\u0004\b&\u0010\rJ\u000f\u0010'\u001a\u00020\tH\u0016¢\u0006\u0004\b'\u0010\rJ\u000f\u0010(\u001a\u00020\u0011H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b*\u0010\rJ\u000f\u0010+\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010\rJ\u0019\u0010.\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\tH\u0016¢\u0006\u0004\b0\u0010\rR\"\u00102\u001a\u0002018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010N\u001a\u00020M8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010U\u001a\u00020T8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\\\u001a\u00020[8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010a¨\u0006c"}, d2 = {"Lcom/avito/android/location_list/LocationListFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/location_list/LocationListRouter;", "Lcom/avito/android/ui/ActivityInteractor;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Router;", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Subscriber;", "Lcom/avito/android/remote/model/Location;", "location", "", "showLocationConfirmDialog", "(Lcom/avito/android/remote/model/Location;)V", "showLocationSettings", "()V", "showApplicationPermissionsSettings", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "onStop", "onResume", "onPause", "outState", "onSaveInstanceState", "onDestroyView", "finish", "onBackPressed", "()Z", "findLocation", "onClickLocationSnackbar", "", "error", "onLocationNotFound", "(Ljava/lang/String;)V", "onNotPermissionGranted", "Lcom/avito/android/location_list/LocationListPresenter;", "presenter", "Lcom/avito/android/location_list/LocationListPresenter;", "getPresenter", "()Lcom/avito/android/location_list/LocationListPresenter;", "setPresenter", "(Lcom/avito/android/location_list/LocationListPresenter;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "locationPermissionDialogPresenter", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "getLocationPermissionDialogPresenter", "()Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "setLocationPermissionDialogPresenter", "(Lcom/avito/android/permissions/LocationPermissionDialogPresenter;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/location_list/LocationListInteractor;", "interactor", "Lcom/avito/android/location_list/LocationListInteractor;", "getInteractor", "()Lcom/avito/android/location_list/LocationListInteractor;", "setInteractor", "(Lcom/avito/android/location_list/LocationListInteractor;)V", "<init>", "location-list_release"}, k = 1, mv = {1, 4, 2})
public class LocationListFragment extends BaseFragment implements LocationListRouter, ActivityInteractor, OnBackPressedListener, LocationPermissionDialogPresenter.Router, LocationPermissionDialogPresenter.Subscriber {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public LocationListInteractor interactor;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public LocationPermissionDialogPresenter locationPermissionDialogPresenter;
    @Inject
    public LocationListPresenter presenter;

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Router
    public void findLocation() {
        LocationListPresenter locationListPresenter = this.presenter;
        if (locationListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        locationListPresenter.findLocation(requireActivity);
    }

    @Override // com.avito.android.location_list.LocationListRouter
    public void finish() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
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
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final LocationListInteractor getInteractor() {
        LocationListInteractor locationListInteractor = this.interactor;
        if (locationListInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return locationListInteractor;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final LocationPermissionDialogPresenter getLocationPermissionDialogPresenter() {
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        return locationPermissionDialogPresenter2;
    }

    @NotNull
    public final LocationListPresenter getPresenter() {
        LocationListPresenter locationListPresenter = this.presenter;
        if (locationListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return locationListPresenter;
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        requireActivity().onBackPressed();
        return true;
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Subscriber
    public void onClickLocationSnackbar() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.createAppSettingsIntent());
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.region_list, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        LocationListPresenter locationListPresenter = this.presenter;
        if (locationListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        locationListPresenter.handleDetach();
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Subscriber
    public void onLocationNotFound(@Nullable String str) {
        LocationListPresenter locationListPresenter = this.presenter;
        if (locationListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        locationListPresenter.onLocationNotFound(str);
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Subscriber
    public void onNotPermissionGranted() {
        LocationListPresenter locationListPresenter = this.presenter;
        if (locationListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        locationListPresenter.subscribeOnNotPermissionGranted();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LocationListPresenter locationListPresenter = this.presenter;
        if (locationListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        locationListPresenter.sendScreenExitAfterCoordinatesResolve();
        LocationListPresenter locationListPresenter2 = this.presenter;
        if (locationListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        locationListPresenter2.unregisterLocationReceiver(requireContext);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LocationListPresenter locationListPresenter = this.presenter;
        if (locationListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        locationListPresenter.registerLocationReceiver(requireContext);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        LocationListPresenter locationListPresenter = this.presenter;
        if (locationListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("scroll_state", locationListPresenter.getState());
        LocationListInteractor locationListInteractor = this.interactor;
        if (locationListInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        bundle.putParcelable("state", locationListInteractor.getState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        locationPermissionDialogPresenter2.attachRouter(this);
        LocationPermissionDialogPresenter locationPermissionDialogPresenter3 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        locationPermissionDialogPresenter3.setSubscriber(this);
        LocationListPresenter locationListPresenter = this.presenter;
        if (locationListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        locationListPresenter.handleAttachRouter(this);
        LocationListPresenter locationListPresenter2 = this.presenter;
        if (locationListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        locationListPresenter2.handleOnShow();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        locationPermissionDialogPresenter2.detachRouter();
        LocationPermissionDialogPresenter locationPermissionDialogPresenter3 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        locationPermissionDialogPresenter3.detachSubscriber();
        LocationListPresenter locationListPresenter = this.presenter;
        if (locationListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        locationListPresenter.handleOnHide();
        LocationListPresenter locationListPresenter2 = this.presenter;
        if (locationListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        locationListPresenter2.handleDetachRouter();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewGroup viewGroup = (ViewGroup) view;
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        LocationListViewImpl locationListViewImpl = new LocationListViewImpl(viewGroup, adapterPresenter2, itemBinder2, analytics2);
        LocationListPresenter locationListPresenter = this.presenter;
        if (locationListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        locationListPresenter.handleAttachView(locationListViewImpl);
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setInteractor(@NotNull LocationListInteractor locationListInteractor) {
        Intrinsics.checkNotNullParameter(locationListInteractor, "<set-?>");
        this.interactor = locationListInteractor;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setLocationPermissionDialogPresenter(@NotNull LocationPermissionDialogPresenter locationPermissionDialogPresenter2) {
        Intrinsics.checkNotNullParameter(locationPermissionDialogPresenter2, "<set-?>");
        this.locationPermissionDialogPresenter = locationPermissionDialogPresenter2;
    }

    public final void setPresenter(@NotNull LocationListPresenter locationListPresenter) {
        Intrinsics.checkNotNullParameter(locationListPresenter, "<set-?>");
        this.presenter = locationListPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        String str;
        boolean z = requireArguments().getBoolean("has_region");
        boolean z2 = requireArguments().getBoolean("show_whole", false);
        Location location = (Location) requireArguments().getParcelable("selected_location");
        Location location2 = (Location) requireArguments().getParcelable("parent_location");
        Bundle arguments = getArguments();
        boolean z3 = arguments != null ? arguments.getBoolean("has_search_area", false) : false;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str = arguments2.getString("extra_category_id")) == null) {
            str = "";
        }
        Bundle arguments3 = getArguments();
        boolean z4 = arguments3 != null ? arguments3.getBoolean("track_location_events", false) : false;
        LocationListActivity locationListActivity = null;
        Bundle bundle2 = bundle != null ? (Bundle) bundle.getParcelable("state") : null;
        Bundle bundle3 = bundle != null ? (Bundle) bundle.getParcelable("scroll_state") : null;
        FragmentActivity activity = getActivity();
        if (activity instanceof LocationListActivity) {
            locationListActivity = activity;
        }
        LocationListActivity locationListActivity2 = locationListActivity;
        if (locationListActivity2 != null) {
            LocationListComponent.Builder dependentOn = DaggerLocationListComponent.builder().dependentOn((LocationListDependencies) ComponentDependenciesKt.getDependencies(LocationListDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
            String string = getResources().getString(R.string.not_important);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.not_important)");
            dependentOn.locationListModule(new LocationListModule(bundle2, locationListActivity2, this, bundle3, string, this, z, z2, location, location2, z3, str, z4)).withFragment(this).withActivity(locationListActivity2).withActivityInteractor(this).build().inject(this);
            LocationConfirmDialog locationConfirmDialog = (LocationConfirmDialog) getChildFragmentManager().findFragmentByTag("tag_dialog_location");
            if (locationConfirmDialog == null) {
                return true;
            }
            LocationListPresenter locationListPresenter = this.presenter;
            if (locationListPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            locationConfirmDialog.setLocationListener(locationListPresenter);
            return true;
        }
        throw new IllegalArgumentException((this + " requires LocationListActivity").toString());
    }

    @Override // com.avito.android.location_list.LocationListRouter
    public void showApplicationPermissionsSettings() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.createAppSettingsIntent());
    }

    @Override // com.avito.android.location_list.LocationListRouter
    public void showLocationConfirmDialog(@Nullable Location location) {
        LocationListPresenter locationListPresenter = this.presenter;
        if (locationListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        LocationConfirmDialogKt.newLocationDialogInstance(location, locationListPresenter).show(getChildFragmentManager(), "tag_dialog_location");
    }

    @Override // com.avito.android.location_list.LocationListRouter
    public void showLocationSettings() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.locationSettingsIntent());
    }
}
