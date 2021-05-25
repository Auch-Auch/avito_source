package com.avito.android.safedeal.profile_settings;

import a2.a.a.i2.c.b;
import a2.a.a.i2.c.d;
import a2.a.a.i2.c.e;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.safedeal.R;
import com.avito.android.safedeal.profile_settings.di.DaggerProfileDeliverySettingsComponent;
import com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsComponent;
import com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies;
import com.avito.android.safedeal.shared.item_decorations.MarginItemDecorationAtPositions;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.ViewSizeKt;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.x;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b?\u0010@J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00103\u001a\u0002008\u0002@\u0002X.¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X.¢\u0006\u0006\n\u0004\b5\u00106R\"\u00109\u001a\u0002088\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "onActivityCreated", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerViewAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerViewAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerViewAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsViewModel;", "viewModel", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsViewModel;", "getViewModel", "()Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsViewModel;", "setViewModel", "(Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsViewModel;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Landroidx/appcompat/widget/Toolbar;", "c", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "d", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "getTracker", "()Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "setTracker", "(Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "<init>", "()V", "Factory", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileDeliverySettingsFragment extends BaseFragment {
    @NotNull
    public static final Factory Factory = new Factory(null);
    @Inject
    public DataAwareAdapterPresenter adapterPresenter;
    public Toolbar c;
    public ProgressOverlay d;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public SimpleRecyclerAdapter recyclerViewAdapter;
    @Inject
    public BaseScreenPerformanceTracker tracker;
    @Inject
    public ProfileDeliverySettingsViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsFragment$Factory;", "", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsFragment;", "create", "()Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsFragment;", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        public Factory() {
        }

        @NotNull
        public final ProfileDeliverySettingsFragment create() {
            return new ProfileDeliverySettingsFragment();
        }

        public Factory(j jVar) {
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ProfileDeliverySettingsFragment a;

        public a(ProfileDeliverySettingsFragment profileDeliverySettingsFragment) {
            this.a = profileDeliverySettingsFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = this.a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public static final /* synthetic */ ProgressOverlay access$getProgressOverlay$p(ProfileDeliverySettingsFragment profileDeliverySettingsFragment) {
        ProgressOverlay progressOverlay = profileDeliverySettingsFragment.d;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        return progressOverlay;
    }

    public static final /* synthetic */ Toolbar access$getToolbar$p(ProfileDeliverySettingsFragment profileDeliverySettingsFragment) {
        Toolbar toolbar = profileDeliverySettingsFragment.c;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        return toolbar;
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
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final SimpleRecyclerAdapter getRecyclerViewAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerViewAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
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
    public final ProfileDeliverySettingsViewModel getViewModel() {
        ProfileDeliverySettingsViewModel profileDeliverySettingsViewModel = this.viewModel;
        if (profileDeliverySettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return profileDeliverySettingsViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        ProfileDeliverySettingsViewModel profileDeliverySettingsViewModel = this.viewModel;
        if (profileDeliverySettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        profileDeliverySettingsViewModel.setAdapterPresenter(dataAwareAdapterPresenter);
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
        return layoutInflater.inflate(R.layout.fragment_profile_delivery_settings, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ProfileDeliverySettingsViewModel profileDeliverySettingsViewModel = this.viewModel;
        if (profileDeliverySettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        profileDeliverySettingsViewModel.getDeepLinkChanges().observe(getViewLifecycleOwner(), new a2.a.a.i2.c.a(this));
        ProfileDeliverySettingsViewModel profileDeliverySettingsViewModel2 = this.viewModel;
        if (profileDeliverySettingsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        profileDeliverySettingsViewModel2.getToolbarTitleChanges().observe(getViewLifecycleOwner(), new b(this));
        ProfileDeliverySettingsViewModel profileDeliverySettingsViewModel3 = this.viewModel;
        if (profileDeliverySettingsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        profileDeliverySettingsViewModel3.getFullScreenErrorChanges().observe(getViewLifecycleOwner(), new d(this));
        ProfileDeliverySettingsViewModel profileDeliverySettingsViewModel4 = this.viewModel;
        if (profileDeliverySettingsViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        profileDeliverySettingsViewModel4.getActivityResultChanges().observe(getViewLifecycleOwner(), new e(this));
        View findViewById = requireActivity().findViewById(R.id.toolbar);
        Toolbar toolbar = (Toolbar) findViewById;
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24_black);
        toolbar.setNavigationOnClickListener(new a(this));
        Intrinsics.checkNotNullExpressionValue(findViewById, "requireActivity().findVi…ity?.finish() }\n        }");
        this.c = toolbar;
        View findViewById2 = view.findViewById(R.id.recycler_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerViewAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
        }
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.addItemDecoration(new MarginItemDecorationAtPositions(ViewSizeKt.getDp(10), ViewSizeKt.getDp(20), ViewSizeKt.getDp(16), ViewSizeKt.getDp(16), x.setOf(0)));
        View findViewById3 = requireActivity().findViewById(R.id.fragment_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "requireActivity().findVi…(R.id.fragment_container)");
        this.d = new ProgressOverlay((ViewGroup) findViewById3, 0, null, false, 0, 30, null);
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

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setRecyclerViewAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerViewAdapter = simpleRecyclerAdapter;
    }

    public final void setTracker(@NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "<set-?>");
        this.tracker = baseScreenPerformanceTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Timer B1 = a2.b.a.a.a.B1();
        ProfileDeliverySettingsComponent.Builder deliveryProfileSettingsDependencies = DaggerProfileDeliverySettingsComponent.builder().deliveryProfileSettingsDependencies((ProfileDeliverySettingsDependencies) ComponentDependenciesKt.getDependencies(ProfileDeliverySettingsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type android.app.Activity");
        ProfileDeliverySettingsComponent.Builder activity2 = deliveryProfileSettingsDependencies.activity(activity);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        activity2.resources(resources).viewModelFragment(this).build().inject(this);
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        baseScreenPerformanceTracker.trackDiInject(B1.elapsed());
        return true;
    }

    public final void setViewModel(@NotNull ProfileDeliverySettingsViewModel profileDeliverySettingsViewModel) {
        Intrinsics.checkNotNullParameter(profileDeliverySettingsViewModel, "<set-?>");
        this.viewModel = profileDeliverySettingsViewModel;
    }
}
