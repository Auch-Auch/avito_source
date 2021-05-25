package com.avito.android.publish.wizard;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.publish.PublishActivityKt;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.R;
import com.avito.android.publish.wizard.WizardPresenter;
import com.avito.android.publish.wizard.analytics.CategoriesWizardTracker;
import com.avito.android.publish.wizard.di.DaggerWizardComponent;
import com.avito.android.publish.wizard.di.WizardComponent;
import com.avito.android.publish.wizard.di.WizardDependencies;
import com.avito.android.publish.wizard.di.WizardModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b]\u0010#J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u000bH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010#J\u000f\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010#R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010;\u001a\u00020:8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010B\u001a\u00020A8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010I\u001a\u00020H8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010P\u001a\u00020O8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\¨\u0006^"}, d2 = {"Lcom/avito/android/publish/wizard/WizardFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Lcom/avito/android/publish/wizard/WizardPresenter$Router;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onDestroyView", "()V", "onBackPressed", "()Z", "onDetach", "navigateToAuth", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/publish/wizard/WizardRouter;", "c", "Lcom/avito/android/publish/wizard/WizardRouter;", "router", "Lcom/avito/android/publish/wizard/analytics/CategoriesWizardTracker;", "tracker", "Lcom/avito/android/publish/wizard/analytics/CategoriesWizardTracker;", "getTracker", "()Lcom/avito/android/publish/wizard/analytics/CategoriesWizardTracker;", "setTracker", "(Lcom/avito/android/publish/wizard/analytics/CategoriesWizardTracker;)V", "Lcom/avito/android/publish/wizard/WizardPresenter;", "presenter", "Lcom/avito/android/publish/wizard/WizardPresenter;", "getPresenter", "()Lcom/avito/android/publish/wizard/WizardPresenter;", "setPresenter", "(Lcom/avito/android/publish/wizard/WizardPresenter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/publish/wizard/WizardInteractor;", "interactor", "Lcom/avito/android/publish/wizard/WizardInteractor;", "getInteractor", "()Lcom/avito/android/publish/wizard/WizardInteractor;", "setInteractor", "(Lcom/avito/android/publish/wizard/WizardInteractor;)V", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class WizardFragment extends BaseFragment implements OnBackPressedListener, WizardPresenter.Router {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public WizardRouter c;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public WizardInteractor interactor;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public WizardPresenter presenter;
    @Inject
    public CategoriesWizardTracker tracker;

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
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final WizardInteractor getInteractor() {
        WizardInteractor wizardInteractor = this.interactor;
        if (wizardInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return wizardInteractor;
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
    public final WizardPresenter getPresenter() {
        WizardPresenter wizardPresenter = this.presenter;
        if (wizardPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return wizardPresenter;
    }

    @NotNull
    public final CategoriesWizardTracker getTracker() {
        CategoriesWizardTracker categoriesWizardTracker = this.tracker;
        if (categoriesWizardTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return categoriesWizardTracker;
    }

    @Override // com.avito.android.publish.wizard.WizardPresenter.Router
    public void navigateToAuth() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory, null, AuthSource.CREATE_ADVERT, null, 5, null), 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        WizardPresenter wizardPresenter = this.presenter;
        if (wizardPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        if (!wizardPresenter.onResult(i, i2)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WizardRouter)) {
            parentFragment = null;
        }
        WizardRouter wizardRouter = (WizardRouter) parentFragment;
        if (wizardRouter == null) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.avito.android.publish.wizard.WizardRouter");
            wizardRouter = (WizardRouter) activity;
        }
        this.c = wizardRouter;
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        WizardPresenter wizardPresenter = this.presenter;
        if (wizardPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return wizardPresenter.onBackPressed();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        CategoriesWizardTracker categoriesWizardTracker = this.tracker;
        if (categoriesWizardTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        categoriesWizardTracker.startInit();
        return layoutInflater.inflate(R.layout.wizard, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        WizardPresenter wizardPresenter = this.presenter;
        if (wizardPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        wizardPresenter.detachView();
        WizardPresenter wizardPresenter2 = this.presenter;
        if (wizardPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        wizardPresenter2.detachRouter();
        WizardPresenter wizardPresenter3 = this.presenter;
        if (wizardPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        wizardPresenter3.detachWizardRouter();
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        this.c = null;
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        WizardPresenter wizardPresenter = this.presenter;
        if (wizardPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putBundle("key_presenter", wizardPresenter.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = ViewModelProviders.of(requireActivity, (ViewModelProvider.Factory) null).get(PublishViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        PublishViewModel publishViewModel = (PublishViewModel) viewModel;
        ViewGroup viewGroup = (ViewGroup) view;
        WizardPresenter wizardPresenter = this.presenter;
        if (wizardPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
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
        WizardViewImpl wizardViewImpl = new WizardViewImpl(viewGroup, wizardPresenter, adapterPresenter2, itemBinder2, analytics2, publishViewModel.getShouldSaveDraft());
        WizardPresenter wizardPresenter2 = this.presenter;
        if (wizardPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        wizardPresenter2.attachPublishViewModel(publishViewModel);
        WizardPresenter wizardPresenter3 = this.presenter;
        if (wizardPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        wizardPresenter3.attachRouter(this);
        WizardPresenter wizardPresenter4 = this.presenter;
        if (wizardPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        wizardPresenter4.attachWizardRouter(this.c);
        WizardPresenter wizardPresenter5 = this.presenter;
        if (wizardPresenter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            wizardPresenter5.attachView(wizardViewImpl, arguments.getInt(PublishActivityKt.KEY_STEP_INDEX));
            CategoriesWizardTracker categoriesWizardTracker = this.tracker;
            if (categoriesWizardTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            categoriesWizardTracker.trackInit();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setInteractor(@NotNull WizardInteractor wizardInteractor) {
        Intrinsics.checkNotNullParameter(wizardInteractor, "<set-?>");
        this.interactor = wizardInteractor;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull WizardPresenter wizardPresenter) {
        Intrinsics.checkNotNullParameter(wizardPresenter, "<set-?>");
        this.presenter = wizardPresenter;
    }

    public final void setTracker(@NotNull CategoriesWizardTracker categoriesWizardTracker) {
        Intrinsics.checkNotNullParameter(categoriesWizardTracker, "<set-?>");
        this.tracker = categoriesWizardTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        List list;
        Bundle arguments = getArguments();
        boolean z = arguments != null ? arguments.getBoolean("key_always_arrow") : true;
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("key_item_id") : null;
        Bundle arguments3 = getArguments();
        Navigation navigation = arguments3 != null ? (Navigation) arguments3.getParcelable("key_navigation") : null;
        Bundle arguments4 = getArguments();
        int i = arguments4 != null ? arguments4.getInt("key_root_level") : 0;
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (list = arguments5.getParcelableArrayList("key_leaves")) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Bundle arguments6 = getArguments();
        String string2 = arguments6 != null ? arguments6.getString("key_step_id") : null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("key_presenter") : null;
        Timer B1 = a.B1();
        WizardComponent.Builder dependencies = DaggerWizardComponent.builder().dependencies((WizardDependencies) ComponentDependenciesKt.getDependencies(WizardDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        dependencies.wizardModule(new WizardModule(bundle2, string, navigation, resources, z, i, list, string2)).build().inject(this);
        CategoriesWizardTracker categoriesWizardTracker = this.tracker;
        if (categoriesWizardTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        categoriesWizardTracker.trackDiInject(B1.elapsed());
        return true;
    }
}
