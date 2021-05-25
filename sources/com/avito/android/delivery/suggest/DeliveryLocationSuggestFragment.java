package com.avito.android.delivery.suggest;

import a2.a.a.k0.d.a;
import a2.a.a.k0.d.b;
import a2.a.a.k0.d.c;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.delivery.R;
import com.avito.android.delivery.di.component.DaggerDeliveryLocationSuggestComponent;
import com.avito.android.delivery.di.component.DeliveryLocationSuggestComponent;
import com.avito.android.delivery.di.component.DeliveryLocationSuggestDependencies;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\bN\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b/\u00100R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006P"}, d2 = {"Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "d", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "getTracker", "()Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "setTracker", "(Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestView;", "c", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestView;", "locationSuggestView", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/SchedulersFactory3;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory3;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory3;)V", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModel;", "viewModel", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModel;", "getViewModel", "()Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModel;", "setViewModel", "(Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModel;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "Factory", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryLocationSuggestFragment extends BaseFragment {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public DeliveryLocationSuggestView c;
    public final CompositeDisposable d = new CompositeDisposable();
    @Inject
    public Features features;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public SchedulersFactory3 schedulers;
    @Inject
    public BaseScreenPerformanceTracker tracker;
    @Inject
    public DeliveryLocationSuggestViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestFragment$Factory;", "", "Lcom/avito/android/avito_map/AvitoMapBounds;", "visibleRegion", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestFragment;", "createInstance", "(Lcom/avito/android/avito_map/AvitoMapBounds;)Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestFragment;", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ AvitoMapBounds a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(AvitoMapBounds avitoMapBounds) {
                super(1);
                this.a = avitoMapBounds;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable(DeliveryLocationSuggestActivityKt.EXTRA_VISIBLE_REGION, this.a);
                return Unit.INSTANCE;
            }
        }

        @NotNull
        public final DeliveryLocationSuggestFragment createInstance(@NotNull AvitoMapBounds avitoMapBounds) {
            Intrinsics.checkNotNullParameter(avitoMapBounds, "visibleRegion");
            return (DeliveryLocationSuggestFragment) FragmentsKt.arguments(new DeliveryLocationSuggestFragment(), 1, new a(avitoMapBounds));
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
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
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
    public final SchedulersFactory3 getSchedulers() {
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory3;
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
    public final DeliveryLocationSuggestViewModel getViewModel() {
        DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel = this.viewModel;
        if (deliveryLocationSuggestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return deliveryLocationSuggestViewModel;
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
        return layoutInflater.inflate(R.layout.delivery_suggest_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        DeliveryLocationSuggestView deliveryLocationSuggestView = this.c;
        if (deliveryLocationSuggestView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationSuggestView");
        }
        Observable<Unit> navigationClicks = deliveryLocationSuggestView.getNavigationClicks();
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        Disposable subscribe = navigationClicks.observeOn(schedulersFactory3.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "locationSuggestView.navi…          }\n            )");
        DisposableKt.addTo(subscribe, this.d);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.d.clear();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        DeliveryLocationSuggestView deliveryLocationSuggestView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getAddressInputOnMapRedesign().invoke().booleanValue()) {
            AdapterPresenter adapterPresenter2 = this.adapterPresenter;
            if (adapterPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
            }
            ItemBinder itemBinder2 = this.itemBinder;
            if (itemBinder2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
            }
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            SchedulersFactory3 schedulersFactory3 = this.schedulers;
            if (schedulersFactory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("schedulers");
            }
            deliveryLocationSuggestView = new DeliveryLocationSuggestViewWithRedesignedInputImpl(view, adapterPresenter2, itemBinder2, viewLifecycleOwner, analytics2, schedulersFactory3);
        } else {
            AdapterPresenter adapterPresenter3 = this.adapterPresenter;
            if (adapterPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
            }
            ItemBinder itemBinder3 = this.itemBinder;
            if (itemBinder3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
            }
            LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
            Analytics analytics3 = this.analytics;
            if (analytics3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            deliveryLocationSuggestView = new DeliveryLocationSuggestViewImpl(view, adapterPresenter3, itemBinder3, viewLifecycleOwner2, analytics3);
        }
        this.c = deliveryLocationSuggestView;
        if (deliveryLocationSuggestView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationSuggestView");
        }
        DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel = this.viewModel;
        if (deliveryLocationSuggestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryLocationSuggestView.bindTo(deliveryLocationSuggestViewModel);
        DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel2 = this.viewModel;
        if (deliveryLocationSuggestViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryLocationSuggestViewModel2.getCoordinatesChanges().observe(getViewLifecycleOwner(), new c(this));
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        baseScreenPerformanceTracker.trackInit();
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setSchedulers(@NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "<set-?>");
        this.schedulers = schedulersFactory3;
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
            AvitoMapBounds avitoMapBounds = (AvitoMapBounds) arguments.getParcelable(DeliveryLocationSuggestActivityKt.EXTRA_VISIBLE_REGION);
            if (avitoMapBounds != null) {
                Timer B1 = a2.b.a.a.a.B1();
                DeliveryLocationSuggestComponent.Builder deliveryLocationSuggestDependencies = DaggerDeliveryLocationSuggestComponent.builder().deliveryLocationSuggestDependencies((DeliveryLocationSuggestDependencies) ComponentDependenciesKt.getDependencies(DeliveryLocationSuggestDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
                FragmentActivity activity = getActivity();
                Objects.requireNonNull(activity, "null cannot be cast to non-null type android.app.Activity");
                DeliveryLocationSuggestComponent.Builder visibleRegion = deliveryLocationSuggestDependencies.activity(activity).visibleRegion(avitoMapBounds);
                Resources resources = getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                visibleRegion.resources(resources).viewModelFragment(this).build().inject(this);
                BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
                if (baseScreenPerformanceTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tracker");
                }
                baseScreenPerformanceTracker.trackDiInject(B1.elapsed());
                return true;
            }
            throw new IllegalArgumentException("Visible region not found");
        }
        throw new IllegalStateException("Arguments not set");
    }

    public final void setViewModel(@NotNull DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel) {
        Intrinsics.checkNotNullParameter(deliveryLocationSuggestViewModel, "<set-?>");
        this.viewModel = deliveryLocationSuggestViewModel;
    }
}
