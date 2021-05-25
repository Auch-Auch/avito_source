package com.avito.android.publish.infomodel_request;

import a2.a.a.e2.v.b;
import a2.a.a.e2.v.c;
import a2.b.a.a.a;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.R;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.infomodel_request.di.DaggerInfomodelRequestComponent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.FragmentsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b5\u0010\u0013J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0007J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/avito/android/publish/infomodel_request/InfomodelRequestFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "onActivityCreated", "", "onBackPressed", "()Z", "Lcom/avito/android/analytics/screens/Timer;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/Timer;", "initTracker", "Lcom/avito/android/publish/infomodel_request/InfomodelRequestViewModel;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/infomodel_request/InfomodelRequestViewModel;", "viewModel", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "performanceTracker", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "getPerformanceTracker", "()Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "setPerformanceTracker", "(Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;)V", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "loadingProgress", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "getLoadingProgress", "()Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "setLoadingProgress", "(Lcom/avito/android/progress_overlay/LoadingProgressOverlay;)V", "Lcom/avito/android/publish/infomodel_request/InfomodelRequestViewModelFactory;", "viewModelFactory", "Lcom/avito/android/publish/infomodel_request/InfomodelRequestViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/publish/infomodel_request/InfomodelRequestViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/publish/infomodel_request/InfomodelRequestViewModelFactory;)V", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class InfomodelRequestFragment extends Fragment implements OnBackPressedListener {
    public InfomodelRequestViewModel a;
    public Timer b;
    @Inject
    public LoadingProgressOverlay loadingProgress;
    @Inject
    public UnknownScreenTracker performanceTracker;
    @Inject
    public InfomodelRequestViewModelFactory viewModelFactory;

    @NotNull
    public final LoadingProgressOverlay getLoadingProgress() {
        LoadingProgressOverlay loadingProgressOverlay = this.loadingProgress;
        if (loadingProgressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        return loadingProgressOverlay;
    }

    @NotNull
    public final UnknownScreenTracker getPerformanceTracker() {
        UnknownScreenTracker unknownScreenTracker = this.performanceTracker;
        if (unknownScreenTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTracker");
        }
        return unknownScreenTracker;
    }

    @NotNull
    public final InfomodelRequestViewModelFactory getViewModelFactory() {
        InfomodelRequestViewModelFactory infomodelRequestViewModelFactory = this.viewModelFactory;
        if (infomodelRequestViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return infomodelRequestViewModelFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = ViewModelProviders.of(requireActivity, (ViewModelProvider.Factory) null).get(PublishViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        PublishViewModel publishViewModel = (PublishViewModel) viewModel;
        Bundle arguments = getArguments();
        boolean z = arguments != null ? arguments.getBoolean("is_initial_request") : true;
        Bundle arguments2 = getArguments();
        boolean z2 = arguments2 != null ? arguments2.getBoolean("track_draft_resumed") : false;
        InfomodelRequestViewModel infomodelRequestViewModel = this.a;
        if (infomodelRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        infomodelRequestViewModel.initScreen(publishViewModel, z, z2);
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        InfomodelRequestViewModel infomodelRequestViewModel = this.a;
        if (infomodelRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        infomodelRequestViewModel.onBackPressed();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Timer B1 = a.B1();
        DaggerInfomodelRequestComponent.builder().publishComponent((PublishComponent) FragmentsKt.activityComponent(this)).build().inject(this);
        UnknownScreenTracker unknownScreenTracker = this.performanceTracker;
        if (unknownScreenTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTracker");
        }
        unknownScreenTracker.trackDiInject(B1.elapsed());
        InfomodelRequestViewModelFactory infomodelRequestViewModelFactory = this.viewModelFactory;
        if (infomodelRequestViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, infomodelRequestViewModelFactory).get(InfomodelRequestViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.a = (InfomodelRequestViewModel) viewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Timer timer = new TimerFactory().timer();
        timer.start();
        Unit unit = Unit.INSTANCE;
        this.b = timer;
        return layoutInflater.inflate(R.layout.loading_progress_overlay_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        InfomodelRequestViewModel infomodelRequestViewModel = this.a;
        if (infomodelRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        infomodelRequestViewModel.screenState().removeObservers(getViewLifecycleOwner());
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LoadingProgressOverlay loadingProgressOverlay = this.loadingProgress;
        if (loadingProgressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        loadingProgressOverlay.setup((ViewGroup) view, R.id.progress_overlay_container);
        LoadingProgressOverlay loadingProgressOverlay2 = this.loadingProgress;
        if (loadingProgressOverlay2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        loadingProgressOverlay2.showFullScreenLoading();
        InfomodelRequestViewModel infomodelRequestViewModel = this.a;
        if (infomodelRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        infomodelRequestViewModel.screenState().observe(getViewLifecycleOwner(), new b(this));
        InfomodelRequestViewModel infomodelRequestViewModel2 = this.a;
        if (infomodelRequestViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LoadingProgressOverlay loadingProgressOverlay3 = this.loadingProgress;
        if (loadingProgressOverlay3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        loadingProgressOverlay3.setOnRefreshListener(new c(infomodelRequestViewModel2));
        UnknownScreenTracker unknownScreenTracker = this.performanceTracker;
        if (unknownScreenTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTracker");
        }
        Timer timer = this.b;
        if (timer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initTracker");
        }
        unknownScreenTracker.trackInit(timer.elapsed());
    }

    public final void setLoadingProgress(@NotNull LoadingProgressOverlay loadingProgressOverlay) {
        Intrinsics.checkNotNullParameter(loadingProgressOverlay, "<set-?>");
        this.loadingProgress = loadingProgressOverlay;
    }

    public final void setPerformanceTracker(@NotNull UnknownScreenTracker unknownScreenTracker) {
        Intrinsics.checkNotNullParameter(unknownScreenTracker, "<set-?>");
        this.performanceTracker = unknownScreenTracker;
    }

    public final void setViewModelFactory(@NotNull InfomodelRequestViewModelFactory infomodelRequestViewModelFactory) {
        Intrinsics.checkNotNullParameter(infomodelRequestViewModelFactory, "<set-?>");
        this.viewModelFactory = infomodelRequestViewModelFactory;
    }
}
