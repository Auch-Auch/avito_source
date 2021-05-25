package com.avito.android.publish.pretend;

import a2.a.a.e2.z.a;
import a2.a.a.e2.z.b;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.R;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.pretend.di.DaggerPretendComponent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.FragmentsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b*\u0010\u0013J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0007J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/avito/android/publish/pretend/PretendFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "onActivityCreated", "", "onBackPressed", "()Z", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "loadingProgress", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "getLoadingProgress", "()Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "setLoadingProgress", "(Lcom/avito/android/progress_overlay/LoadingProgressOverlay;)V", "Lcom/avito/android/publish/pretend/PretendViewModelFactory;", "viewModelFactory", "Lcom/avito/android/publish/pretend/PretendViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/publish/pretend/PretendViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/publish/pretend/PretendViewModelFactory;)V", "Lcom/avito/android/publish/pretend/PretendViewModel;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/pretend/PretendViewModel;", "viewModel", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PretendFragment extends Fragment implements OnBackPressedListener {
    public PretendViewModel a;
    @Inject
    public LoadingProgressOverlay loadingProgress;
    @Inject
    public PretendViewModelFactory viewModelFactory;

    @NotNull
    public final LoadingProgressOverlay getLoadingProgress() {
        LoadingProgressOverlay loadingProgressOverlay = this.loadingProgress;
        if (loadingProgressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        return loadingProgressOverlay;
    }

    @NotNull
    public final PretendViewModelFactory getViewModelFactory() {
        PretendViewModelFactory pretendViewModelFactory = this.viewModelFactory;
        if (pretendViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return pretendViewModelFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = ViewModelProviders.of(requireActivity, (ViewModelProvider.Factory) null).get(PublishViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        PublishViewModel publishViewModel = (PublishViewModel) viewModel;
        PretendViewModel pretendViewModel = this.a;
        if (pretendViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        pretendViewModel.initScreen(publishViewModel);
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        PretendViewModel pretendViewModel = this.a;
        if (pretendViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        pretendViewModel.onBackPressed();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerPretendComponent.builder().publishComponent((PublishComponent) FragmentsKt.activityComponent(this)).build().inject(this);
        PretendViewModelFactory pretendViewModelFactory = this.viewModelFactory;
        if (pretendViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, pretendViewModelFactory).get(PretendViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.a = (PretendViewModel) viewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.loading_progress_overlay_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…agment, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        PretendViewModel pretendViewModel = this.a;
        if (pretendViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        pretendViewModel.screenState().removeObservers(getViewLifecycleOwner());
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
        PretendViewModel pretendViewModel = this.a;
        if (pretendViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        pretendViewModel.screenState().observe(getViewLifecycleOwner(), new a(this));
        PretendViewModel pretendViewModel2 = this.a;
        if (pretendViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LoadingProgressOverlay loadingProgressOverlay3 = this.loadingProgress;
        if (loadingProgressOverlay3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        loadingProgressOverlay3.setOnRefreshListener(new b(pretendViewModel2));
    }

    public final void setLoadingProgress(@NotNull LoadingProgressOverlay loadingProgressOverlay) {
        Intrinsics.checkNotNullParameter(loadingProgressOverlay, "<set-?>");
        this.loadingProgress = loadingProgressOverlay;
    }

    public final void setViewModelFactory(@NotNull PretendViewModelFactory pretendViewModelFactory) {
        Intrinsics.checkNotNullParameter(pretendViewModelFactory, "<set-?>");
        this.viewModelFactory = pretendViewModelFactory;
    }
}
