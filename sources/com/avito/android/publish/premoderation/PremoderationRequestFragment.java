package com.avito.android.publish.premoderation;

import a2.a.a.e2.y.b;
import a2.a.a.e2.y.c;
import a2.a.a.e2.y.d;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.UserAdvertIntentFactory;
import com.avito.android.UserAdvertsIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.MyAdvertLink;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.R;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.premoderation.di.AdvertProactiveModerationModule;
import com.avito.android.publish.premoderation.di.DaggerPremoderationRequestComponent;
import com.avito.android.publish.premoderation.di.PremoderationRequestModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertDuplicateResult;
import com.avito.android.remote.model.adverts.AdvertProactiveModerationResult;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.Constants;
import com.avito.android.util.FragmentsKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b?\u0010\u0014J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\bJ\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0014J\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u0014J\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006@"}, d2 = {"Lcom/avito/android/publish/premoderation/PremoderationRequestFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/avito/android/publish/premoderation/AdvertDuplicateDialogListener;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "onActivityCreated", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onActionClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onContinueClicked", "onLeaveScreen", "", "onBackPressed", "()Z", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "loadingProgress", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "getLoadingProgress", "()Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "setLoadingProgress", "(Lcom/avito/android/progress_overlay/LoadingProgressOverlay;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/publish/premoderation/PremoderationRequestViewModelFactory;", "viewModelFactory", "Lcom/avito/android/publish/premoderation/PremoderationRequestViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/publish/premoderation/PremoderationRequestViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/publish/premoderation/PremoderationRequestViewModelFactory;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/publish/premoderation/PremoderationRequestViewModel;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/premoderation/PremoderationRequestViewModel;", "viewModel", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PremoderationRequestFragment extends Fragment implements AdvertDuplicateDialogListener, OnBackPressedListener {
    public PremoderationRequestViewModel a;
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public LoadingProgressOverlay loadingProgress;
    @Inject
    public PremoderationRequestViewModelFactory viewModelFactory;

    public static final void access$showAdvertDuplicateScreen(PremoderationRequestFragment premoderationRequestFragment, AdvertDuplicateResult advertDuplicateResult) {
        FragmentManager supportFragmentManager;
        FragmentActivity activity = premoderationRequestFragment.getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity?.supportFragmentManager ?: return");
            AdvertDuplicateFragment createAdvertDuplicateFragment = AdvertDuplicateFragmentKt.createAdvertDuplicateFragment(advertDuplicateResult);
            createAdvertDuplicateFragment.setTargetFragment(premoderationRequestFragment, 4);
            createAdvertDuplicateFragment.show(supportFragmentManager, "tag_advert_duplicate_dialog");
        }
    }

    public static final void access$showAdvertWrongCategoryScreen(PremoderationRequestFragment premoderationRequestFragment, AdvertProactiveModerationResult.WrongCategory wrongCategory) {
        Objects.requireNonNull(premoderationRequestFragment);
        premoderationRequestFragment.getChildFragmentManager().beginTransaction().replace(R.id.progress_overlay_container, WrongCategoryFragmentKt.createWrongCategoryFragment(wrongCategory.getWrongCategorySuggest())).addToBackStack(null).commit();
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
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
    public final LoadingProgressOverlay getLoadingProgress() {
        LoadingProgressOverlay loadingProgressOverlay = this.loadingProgress;
        if (loadingProgressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        return loadingProgressOverlay;
    }

    @NotNull
    public final PremoderationRequestViewModelFactory getViewModelFactory() {
        PremoderationRequestViewModelFactory premoderationRequestViewModelFactory = this.viewModelFactory;
        if (premoderationRequestViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return premoderationRequestViewModelFactory;
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicateDialogListener
    public void onActionClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            if (deepLink instanceof MyAdvertLink.Edit) {
                ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
                if (activityIntentFactory2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
                }
                intent.putExtra(Constants.UP_INTENT, UserAdvertIntentFactory.DefaultImpls.myAdvertDetailsIntent$default(activityIntentFactory2, ((MyAdvertLink.Edit) deepLink).getItemId(), null, null, false, 14, null));
            }
            if (deepLink instanceof MyAdvertLink.Activate) {
                ActivityIntentFactory activityIntentFactory3 = this.activityIntentFactory;
                if (activityIntentFactory3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
                }
                intent.putExtra(Constants.UP_INTENT, UserAdvertsIntentFactory.DefaultImpls.createUserAdvertsIntent$default(activityIntentFactory3, null, null, false, 7, null));
                intent.putExtra("key_should_finish_after_activation", false);
            }
            startActivity(intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = ViewModelProviders.of(requireActivity, (ViewModelProvider.Factory) null).get(PublishViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        PublishViewModel publishViewModel = (PublishViewModel) viewModel;
        PremoderationRequestViewModel premoderationRequestViewModel = this.a;
        if (premoderationRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        premoderationRequestViewModel.initScreen(publishViewModel);
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        PremoderationRequestViewModel premoderationRequestViewModel = this.a;
        if (premoderationRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        premoderationRequestViewModel.goPrevious();
        return true;
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicateDialogListener
    public void onContinueClicked() {
        PremoderationRequestViewModel premoderationRequestViewModel = this.a;
        if (premoderationRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        premoderationRequestViewModel.goNext();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerPremoderationRequestComponent.builder().publishComponent((PublishComponent) FragmentsKt.activityComponent(this)).premoderationRequestModule(new PremoderationRequestModule()).advertProactiveModerationModule(new AdvertProactiveModerationModule()).build().inject(this);
        PremoderationRequestViewModelFactory premoderationRequestViewModelFactory = this.viewModelFactory;
        if (premoderationRequestViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, premoderationRequestViewModelFactory).get(PremoderationRequestViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.a = (PremoderationRequestViewModel) viewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.loading_progress_overlay_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        PremoderationRequestViewModel premoderationRequestViewModel = this.a;
        if (premoderationRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        premoderationRequestViewModel.screenState().removeObservers(getViewLifecycleOwner());
        super.onDestroyView();
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicateDialogListener
    public void onLeaveScreen() {
        PremoderationRequestViewModel premoderationRequestViewModel = this.a;
        if (premoderationRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        premoderationRequestViewModel.goPrevious();
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
        PremoderationRequestViewModel premoderationRequestViewModel = this.a;
        if (premoderationRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        premoderationRequestViewModel.screenState().observe(getViewLifecycleOwner(), new c(this));
        PremoderationRequestViewModel premoderationRequestViewModel2 = this.a;
        if (premoderationRequestViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        premoderationRequestViewModel2.routingActions().observe(getViewLifecycleOwner(), new b(this));
        PremoderationRequestViewModel premoderationRequestViewModel3 = this.a;
        if (premoderationRequestViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LoadingProgressOverlay loadingProgressOverlay3 = this.loadingProgress;
        if (loadingProgressOverlay3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        loadingProgressOverlay3.setOnRefreshListener(new d(premoderationRequestViewModel3));
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setLoadingProgress(@NotNull LoadingProgressOverlay loadingProgressOverlay) {
        Intrinsics.checkNotNullParameter(loadingProgressOverlay, "<set-?>");
        this.loadingProgress = loadingProgressOverlay;
    }

    public final void setViewModelFactory(@NotNull PremoderationRequestViewModelFactory premoderationRequestViewModelFactory) {
        Intrinsics.checkNotNullParameter(premoderationRequestViewModelFactory, "<set-?>");
        this.viewModelFactory = premoderationRequestViewModelFactory;
    }
}
