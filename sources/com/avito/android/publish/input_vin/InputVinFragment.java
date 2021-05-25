package com.avito.android.publish.input_vin;

import a2.a.a.e2.w.b;
import a2.a.a.e2.w.c;
import a2.a.a.e2.w.d;
import a2.a.a.e2.w.e;
import a2.a.a.e2.w.f;
import a2.g.r.g;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.blueprints.input.MultiStateInputItemPresenter;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.publish.PublishActivityKt;
import com.avito.android.publish.PublishAppbarView;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.R;
import com.avito.android.publish.analytics.PublishInputsAnalyticTracker;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.input_vin.di.DaggerInputVinComponent;
import com.avito.android.publish.input_vin.di.InputVinComponent;
import com.avito.android.publish.input_vin.items.scan_button.ScanVinButtonItemPresenter;
import com.avito.android.publish.view.publish_button.PublishButton;
import com.avito.android.publish.view.publish_button.PublishButtonImpl;
import com.avito.android.recycler.layout_manager.UnpredictiveLinearLayoutManager;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.CategoryPublishStep;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.KeyboardSubscription;
import com.avito.android.util.Keyboards;
import com.avito.android.validation.ParametersListModule;
import com.avito.android.validation.ParametersListPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bg\u0010\u0013J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0007R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR5\u0010\"\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030 ¢\u0006\u0002\b!0\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00102\u001a\u00020/8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b0\u00101R\"\u00104\u001a\u0002038\u0006@\u0006X.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\"\u0010G\u001a\u00020F8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bN\u0010OR&\u0010R\u001a\u0006\u0012\u0002\b\u00030Q8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\"\u0010a\u001a\u00020`8\u0006@\u0006X.¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010f¨\u0006h"}, d2 = {"Lcom/avito/android/publish/input_vin/InputVinFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "", "onBackPressed", "()Z", "onActivityCreated", "Lcom/avito/android/publish/input_vin/InputVinViewModelFactory;", "viewModelFactory", "Lcom/avito/android/publish/input_vin/InputVinViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/publish/input_vin/InputVinViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/publish/input_vin/InputVinViewModelFactory;)V", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntent", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntent", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntent", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "loadingProgress", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "getLoadingProgress", "()Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "setLoadingProgress", "(Lcom/avito/android/progress_overlay/LoadingProgressOverlay;)V", "Lcom/avito/android/publish/input_vin/InputVinViewModel;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/input_vin/InputVinViewModel;", "viewModel", "Lcom/avito/android/publish/PublishAppbarView;", "c", "Lcom/avito/android/publish/PublishAppbarView;", "appbarView", "Lcom/avito/android/util/KeyboardSubscription;", g.a, "Lcom/avito/android/util/KeyboardSubscription;", "keyboardSubscription", "Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;", "inputsAnalyticTracker", "Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;", "getInputsAnalyticTracker", "()Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;", "setInputsAnalyticTracker", "(Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;)V", "Lcom/avito/android/publish/view/publish_button/PublishButton;", "d", "Lcom/avito/android/publish/view/publish_button/PublishButton;", "mainActionButton", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Lcom/avito/android/publish/input_vin/InputVinRouter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/input_vin/InputVinRouter;", "router", "Lio/reactivex/disposables/CompositeDisposable;", "f", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/validation/ParametersListPresenter;", "paramsPresenter", "Lcom/avito/android/validation/ParametersListPresenter;", "getParamsPresenter", "()Lcom/avito/android/validation/ParametersListPresenter;", "setParamsPresenter", "(Lcom/avito/android/validation/ParametersListPresenter;)V", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class InputVinFragment extends Fragment implements OnBackPressedListener {
    public InputVinViewModel a;
    @Inject
    public RecyclerView.Adapter<?> adapter;
    public InputVinRouter b;
    public PublishAppbarView c;
    public PublishButton d;
    public RecyclerView e;
    public final CompositeDisposable f = new CompositeDisposable();
    public KeyboardSubscription g;
    @Inject
    public ImplicitIntentFactory implicitIntent;
    @Inject
    public PublishInputsAnalyticTracker inputsAnalyticTracker;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    @Inject
    public LoadingProgressOverlay loadingProgress;
    @Inject
    public ParametersListPresenter paramsPresenter;
    @Inject
    public InputVinViewModelFactory viewModelFactory;

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ InputVinFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InputVinFragment inputVinFragment) {
            super(1);
            this.a = inputVinFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            InputVinFragment.access$getAppbarView$p(this.a).setExpanded(!bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ PublishAppbarView access$getAppbarView$p(InputVinFragment inputVinFragment) {
        PublishAppbarView publishAppbarView = inputVinFragment.c;
        if (publishAppbarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appbarView");
        }
        return publishAppbarView;
    }

    public static final /* synthetic */ InputVinRouter access$getRouter$p(InputVinFragment inputVinFragment) {
        InputVinRouter inputVinRouter = inputVinFragment.b;
        if (inputVinRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        return inputVinRouter;
    }

    public static final void access$openLink(InputVinFragment inputVinFragment, Uri uri) {
        ImplicitIntentFactory implicitIntentFactory = inputVinFragment.implicitIntent;
        if (implicitIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntent");
        }
        FragmentsKt.startActivitySafely(inputVinFragment, ImplicitIntentFactory.DefaultImpls.uriIntentCustomChromeTabs$default(implicitIntentFactory, uri, false, 2, null), new c(inputVinFragment));
    }

    @NotNull
    public final RecyclerView.Adapter<?> getAdapter() {
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return adapter2;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntent() {
        ImplicitIntentFactory implicitIntentFactory = this.implicitIntent;
        if (implicitIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntent");
        }
        return implicitIntentFactory;
    }

    @NotNull
    public final PublishInputsAnalyticTracker getInputsAnalyticTracker() {
        PublishInputsAnalyticTracker publishInputsAnalyticTracker = this.inputsAnalyticTracker;
        if (publishInputsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputsAnalyticTracker");
        }
        return publishInputsAnalyticTracker;
    }

    @NotNull
    public final Set<ItemPresenter<?, ?>> getItemPresenterSet() {
        Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
        }
        return set;
    }

    @NotNull
    public final LoadingProgressOverlay getLoadingProgress() {
        LoadingProgressOverlay loadingProgressOverlay = this.loadingProgress;
        if (loadingProgressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        return loadingProgressOverlay;
    }

    @NotNull
    public final ParametersListPresenter getParamsPresenter() {
        ParametersListPresenter parametersListPresenter = this.paramsPresenter;
        if (parametersListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paramsPresenter");
        }
        return parametersListPresenter;
    }

    @NotNull
    public final InputVinViewModelFactory getViewModelFactory() {
        InputVinViewModelFactory inputVinViewModelFactory = this.viewModelFactory;
        if (inputVinViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return inputVinViewModelFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = ViewModelProviders.of(requireActivity, (ViewModelProvider.Factory) null).get(PublishViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        PublishViewModel publishViewModel = (PublishViewModel) viewModel;
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
        this.c = new PublishAppbarView(requireView, publishViewModel.getShouldSaveDraft());
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = arguments.getInt(PublishActivityKt.KEY_STEP_INDEX);
            CategoryPublishStep step = publishViewModel.getStep(Integer.valueOf(i));
            if (step != null) {
                PublishAppbarView publishAppbarView = this.c;
                if (publishAppbarView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appbarView");
                }
                publishAppbarView.setTitle(step.getTitle());
                PublishAppbarView publishAppbarView2 = this.c;
                if (publishAppbarView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appbarView");
                }
                String shortTitle = step.getShortTitle();
                if (shortTitle == null) {
                    shortTitle = step.getTitle();
                }
                publishAppbarView2.setShortTitle(shortTitle);
                PublishAppbarView publishAppbarView3 = this.c;
                if (publishAppbarView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appbarView");
                }
                publishAppbarView3.setSubtitle(step.getSubtitle());
            }
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
            this.g = Keyboards.addSoftKeyboardVisibilityListener$default((Activity) requireActivity2, false, (Function1) new a(this), 1, (Object) null);
            PublishInputsAnalyticTracker publishInputsAnalyticTracker = this.inputsAnalyticTracker;
            if (publishInputsAnalyticTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputsAnalyticTracker");
            }
            publishInputsAnalyticTracker.setNavigationProvider(publishViewModel);
            InputVinViewModel inputVinViewModel = this.a;
            if (inputVinViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            ParametersListPresenter parametersListPresenter = this.paramsPresenter;
            if (parametersListPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paramsPresenter");
            }
            inputVinViewModel.initScreen(publishViewModel, parametersListPresenter, i);
            InputVinViewModel inputVinViewModel2 = this.a;
            if (inputVinViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            PublishButton publishButton = this.d;
            if (publishButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainActionButton");
            }
            publishButton.setClickListener(new z4(0, inputVinViewModel2));
            PublishAppbarView publishAppbarView4 = this.c;
            if (publishAppbarView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appbarView");
            }
            publishAppbarView4.setActionsListener(new z4(1, inputVinViewModel2), new z4(2, inputVinViewModel2));
            Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
            if (set == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
            }
            for (T t : set) {
                if (t instanceof ScanVinButtonItemPresenter) {
                    CompositeDisposable compositeDisposable = this.f;
                    Disposable subscribe = t.getScanButtonObservable().subscribe(new d(this, inputVinViewModel2));
                    Intrinsics.checkNotNullExpressionValue(subscribe, "it.scanButtonObservable.….onVinScanButtonClick() }");
                    DisposableKt.plusAssign(compositeDisposable, subscribe);
                } else if (t instanceof MultiStateInputItemPresenter) {
                    CompositeDisposable compositeDisposable2 = this.f;
                    T t2 = t;
                    Disposable subscribe2 = t2.getRightIconClickObservable().subscribe(new e(this, inputVinViewModel2));
                    Intrinsics.checkNotNullExpressionValue(subscribe2, "it.rightIconClickObserva…tionalButtonClick(item) }");
                    DisposableKt.plusAssign(compositeDisposable2, subscribe2);
                    CompositeDisposable compositeDisposable3 = this.f;
                    Disposable subscribe3 = t2.getValueChangesObservable().map(f.a).subscribe(inputVinViewModel2.getVinTextChangedRelay());
                    Intrinsics.checkNotNullExpressionValue(subscribe3, "it.valueChangesObservabl…odel.vinTextChangedRelay)");
                    DisposableKt.plusAssign(compositeDisposable3, subscribe3);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        InputVinViewModel inputVinViewModel = this.a;
        if (inputVinViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        inputVinViewModel.onLeaveClicked();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        InputVinComponent.Builder publishComponent = DaggerInputVinComponent.builder().publishComponent((PublishComponent) FragmentsKt.activityComponent(this));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        InputVinComponent.Builder bindResources = publishComponent.bindResources(resources);
        Resources resources2 = getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        bindResources.parametersListModule(new ParametersListModule(resources2, 150, null, null, 12, null)).build().inject(this);
        InputVinViewModelFactory inputVinViewModelFactory = this.viewModelFactory;
        if (inputVinViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, inputVinViewModelFactory).get(InputVinViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.a = (InputVinViewModel) viewModel;
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.avito.android.publish.input_vin.InputVinRouter");
        this.b = (InputVinRouter) activity;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.input_vin_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f.clear();
        KeyboardSubscription keyboardSubscription = this.g;
        if (keyboardSubscription != null) {
            keyboardSubscription.dispose();
        }
        InputVinViewModel inputVinViewModel = this.a;
        if (inputVinViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        inputVinViewModel.screenData().removeObservers(getViewLifecycleOwner());
        ParametersListPresenter parametersListPresenter = this.paramsPresenter;
        if (parametersListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paramsPresenter");
        }
        parametersListPresenter.unsubscribe();
        PublishInputsAnalyticTracker publishInputsAnalyticTracker = this.inputsAnalyticTracker;
        if (publishInputsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputsAnalyticTracker");
        }
        publishInputsAnalyticTracker.unsubscribe();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        int i = R.id.recycler_view;
        View findViewById = view.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.e = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycler");
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        recyclerView.setLayoutManager(new UnpredictiveLinearLayoutManager(context));
        RecyclerView recyclerView2 = this.e;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycler");
        }
        RecyclerView.ItemAnimator itemAnimator = recyclerView2.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setAddDuration(500);
        }
        RecyclerView recyclerView3 = this.e;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycler");
        }
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView3.setAdapter(adapter2);
        PublishButtonImpl publishButtonImpl = new PublishButtonImpl(view);
        this.d = publishButtonImpl;
        if (publishButtonImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainActionButton");
        }
        String string = getString(com.avito.android.ui_components.R.string.continue_string);
        Intrinsics.checkNotNullExpressionValue(string, "getString(ui_R.string.continue_string)");
        publishButtonImpl.setText(string);
        LoadingProgressOverlay loadingProgressOverlay = this.loadingProgress;
        if (loadingProgressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        loadingProgressOverlay.setup((ViewGroup) view, i);
        ParametersListPresenter parametersListPresenter = this.paramsPresenter;
        if (parametersListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paramsPresenter");
        }
        parametersListPresenter.subscribe();
        PublishInputsAnalyticTracker publishInputsAnalyticTracker = this.inputsAnalyticTracker;
        if (publishInputsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputsAnalyticTracker");
        }
        publishInputsAnalyticTracker.subscribe();
        InputVinViewModel inputVinViewModel = this.a;
        if (inputVinViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        inputVinViewModel.inputVinEvents().observe(getViewLifecycleOwner(), new b(this));
        InputVinViewModel inputVinViewModel2 = this.a;
        if (inputVinViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            inputVinViewModel2.routingActions().observe(getViewLifecycleOwner(), new a2.a.a.e2.w.a(this, arguments.getInt(PublishActivityKt.KEY_STEP_INDEX)));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void setAdapter(@NotNull RecyclerView.Adapter<?> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "<set-?>");
        this.adapter = adapter2;
    }

    public final void setImplicitIntent(@NotNull ImplicitIntentFactory implicitIntentFactory) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "<set-?>");
        this.implicitIntent = implicitIntentFactory;
    }

    public final void setInputsAnalyticTracker(@NotNull PublishInputsAnalyticTracker publishInputsAnalyticTracker) {
        Intrinsics.checkNotNullParameter(publishInputsAnalyticTracker, "<set-?>");
        this.inputsAnalyticTracker = publishInputsAnalyticTracker;
    }

    public final void setItemPresenterSet(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenterSet = set;
    }

    public final void setLoadingProgress(@NotNull LoadingProgressOverlay loadingProgressOverlay) {
        Intrinsics.checkNotNullParameter(loadingProgressOverlay, "<set-?>");
        this.loadingProgress = loadingProgressOverlay;
    }

    public final void setParamsPresenter(@NotNull ParametersListPresenter parametersListPresenter) {
        Intrinsics.checkNotNullParameter(parametersListPresenter, "<set-?>");
        this.paramsPresenter = parametersListPresenter;
    }

    public final void setViewModelFactory(@NotNull InputVinViewModelFactory inputVinViewModelFactory) {
        Intrinsics.checkNotNullParameter(inputVinViewModelFactory, "<set-?>");
        this.viewModelFactory = inputVinViewModelFactory;
    }
}
