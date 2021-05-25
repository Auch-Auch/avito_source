package com.avito.android.publish.input_vin;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.publish.analytics.PublishInputsAnalyticTracker;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.validation.ParametersListPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class InputVinFragment_MembersInjector implements MembersInjector<InputVinFragment> {
    public final Provider<InputVinViewModelFactory> a;
    public final Provider<LoadingProgressOverlay> b;
    public final Provider<ParametersListPresenter> c;
    public final Provider<ImplicitIntentFactory> d;
    public final Provider<RecyclerView.Adapter<?>> e;
    public final Provider<PublishInputsAnalyticTracker> f;
    public final Provider<Set<ItemPresenter<?, ?>>> g;

    public InputVinFragment_MembersInjector(Provider<InputVinViewModelFactory> provider, Provider<LoadingProgressOverlay> provider2, Provider<ParametersListPresenter> provider3, Provider<ImplicitIntentFactory> provider4, Provider<RecyclerView.Adapter<?>> provider5, Provider<PublishInputsAnalyticTracker> provider6, Provider<Set<ItemPresenter<?, ?>>> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<InputVinFragment> create(Provider<InputVinViewModelFactory> provider, Provider<LoadingProgressOverlay> provider2, Provider<ParametersListPresenter> provider3, Provider<ImplicitIntentFactory> provider4, Provider<RecyclerView.Adapter<?>> provider5, Provider<PublishInputsAnalyticTracker> provider6, Provider<Set<ItemPresenter<?, ?>>> provider7) {
        return new InputVinFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.publish.input_vin.InputVinFragment.adapter")
    public static void injectAdapter(InputVinFragment inputVinFragment, RecyclerView.Adapter<?> adapter) {
        inputVinFragment.adapter = adapter;
    }

    @InjectedFieldSignature("com.avito.android.publish.input_vin.InputVinFragment.implicitIntent")
    public static void injectImplicitIntent(InputVinFragment inputVinFragment, ImplicitIntentFactory implicitIntentFactory) {
        inputVinFragment.implicitIntent = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.input_vin.InputVinFragment.inputsAnalyticTracker")
    public static void injectInputsAnalyticTracker(InputVinFragment inputVinFragment, PublishInputsAnalyticTracker publishInputsAnalyticTracker) {
        inputVinFragment.inputsAnalyticTracker = publishInputsAnalyticTracker;
    }

    @InjectedFieldSignature("com.avito.android.publish.input_vin.InputVinFragment.itemPresenterSet")
    public static void injectItemPresenterSet(InputVinFragment inputVinFragment, Set<ItemPresenter<?, ?>> set) {
        inputVinFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.publish.input_vin.InputVinFragment.loadingProgress")
    public static void injectLoadingProgress(InputVinFragment inputVinFragment, LoadingProgressOverlay loadingProgressOverlay) {
        inputVinFragment.loadingProgress = loadingProgressOverlay;
    }

    @InjectedFieldSignature("com.avito.android.publish.input_vin.InputVinFragment.paramsPresenter")
    public static void injectParamsPresenter(InputVinFragment inputVinFragment, ParametersListPresenter parametersListPresenter) {
        inputVinFragment.paramsPresenter = parametersListPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.input_vin.InputVinFragment.viewModelFactory")
    public static void injectViewModelFactory(InputVinFragment inputVinFragment, InputVinViewModelFactory inputVinViewModelFactory) {
        inputVinFragment.viewModelFactory = inputVinViewModelFactory;
    }

    public void injectMembers(InputVinFragment inputVinFragment) {
        injectViewModelFactory(inputVinFragment, this.a.get());
        injectLoadingProgress(inputVinFragment, this.b.get());
        injectParamsPresenter(inputVinFragment, this.c.get());
        injectImplicitIntent(inputVinFragment, this.d.get());
        injectAdapter(inputVinFragment, this.e.get());
        injectInputsAnalyticTracker(inputVinFragment, this.f.get());
        injectItemPresenterSet(inputVinFragment, this.g.get());
    }
}
