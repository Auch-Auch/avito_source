package com.avito.android.publish.publish_advert_request;

import a2.a.a.e2.a0.a;
import a2.a.a.e2.a0.b;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.R;
import com.avito.android.publish.SubmissionPresenter;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.drafts.db.LocalDraftTypeAdapterKt;
import com.avito.android.publish.objects.di.ImageUploadModule;
import com.avito.android.publish.publish_advert_request.PublishAdvertRequestViewModel;
import com.avito.android.publish.publish_advert_request.di.DaggerPublishAdvertRequestComponent;
import com.avito.android.publish.publish_advert_request.di.PublishAdvertRequestComponent;
import com.avito.android.publish.publish_advert_request.di.PublishAdvertRequestModule;
import com.avito.android.publish.uploading_dialog.UploadingErrorDialogListener;
import com.avito.android.publish.uploading_dialog.UploadingErrorFragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.FragmentsKt;
import java.util.Arrays;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b@\u0010\u0014J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0014J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0014R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b/\u00100R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Lcom/avito/android/publish/uploading_dialog/UploadingErrorDialogListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "onActivityCreated", "", "onBackPressed", "()Z", "onRetryClicked", "onSkipClicked", "Lcom/avito/android/publish/SubmissionPresenter;", "submissionPresenter", "Lcom/avito/android/publish/SubmissionPresenter;", "getSubmissionPresenter", "()Lcom/avito/android/publish/SubmissionPresenter;", "setSubmissionPresenter", "(Lcom/avito/android/publish/SubmissionPresenter;)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "photoUploadInfoString", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "photoUploadInfo", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel;", "viewModel", "Landroid/widget/ProgressBar;", "d", "Landroid/widget/ProgressBar;", "progressIndicator", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "loadingProgress", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "getLoadingProgress", "()Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "setLoadingProgress", "(Lcom/avito/android/progress_overlay/LoadingProgressOverlay;)V", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModelFactory;", "viewModelFactory", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModelFactory;)V", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishAdvertRequestFragment extends Fragment implements OnBackPressedListener, UploadingErrorDialogListener {
    public PublishAdvertRequestViewModel a;
    public String b;
    public TextView c;
    public ProgressBar d;
    @Inject
    public LoadingProgressOverlay loadingProgress;
    @Inject
    public SubmissionPresenter submissionPresenter;
    @Inject
    public PublishAdvertRequestViewModelFactory viewModelFactory;

    public static final void access$showPhotoUploadErrorDialog(PublishAdvertRequestFragment publishAdvertRequestFragment) {
        FragmentManager supportFragmentManager;
        Objects.requireNonNull(publishAdvertRequestFragment);
        UploadingErrorFragment uploadingErrorFragment = new UploadingErrorFragment();
        uploadingErrorFragment.setTargetFragment(publishAdvertRequestFragment, 4);
        FragmentActivity activity = publishAdvertRequestFragment.getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity?.supportFragmentManager ?: return");
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag("tag_dialog");
            if (findFragmentByTag != null) {
                ((DialogFragment) findFragmentByTag).dismissAllowingStateLoss();
            }
            uploadingErrorFragment.show(supportFragmentManager, "tag_dialog");
        }
    }

    public static final void access$showPhotoUploadingContent(PublishAdvertRequestFragment publishAdvertRequestFragment, PublishAdvertRequestViewModel.ViewState.PhotosUploading photosUploading) {
        TextView textView = publishAdvertRequestFragment.c;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoUploadInfo");
        }
        String str = publishAdvertRequestFragment.b;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoUploadInfoString");
        }
        String format = String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(photosUploading.getCurrentLoadedCount()), Integer.valueOf(photosUploading.getAllPhotosCount())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(this, *args)");
        textView.setText(format);
        int currentLoadedCount = photosUploading.getCurrentLoadedCount();
        int allPhotosCount = photosUploading.getAllPhotosCount();
        ProgressBar progressBar = publishAdvertRequestFragment.d;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressIndicator");
        }
        progressBar.setMax(allPhotosCount * 200);
        if (currentLoadedCount > 0) {
            int i = R.id.progress_indicator;
            Object tag = progressBar.getTag(i);
            if (tag instanceof Animator) {
                ((Animator) tag).cancel();
            }
            ObjectAnimator ofInt = ObjectAnimator.ofInt(progressBar, "progress", progressBar.getProgress(), currentLoadedCount * 200);
            ofInt.setDuration(300L);
            ofInt.setInterpolator(new FastOutSlowInInterpolator());
            ofInt.start();
            progressBar.setTag(i, ofInt);
        } else {
            progressBar.setProgress(50);
        }
        LoadingProgressOverlay loadingProgressOverlay = publishAdvertRequestFragment.loadingProgress;
        if (loadingProgressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        loadingProgressOverlay.showContent();
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
    public final SubmissionPresenter getSubmissionPresenter() {
        SubmissionPresenter submissionPresenter2 = this.submissionPresenter;
        if (submissionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submissionPresenter");
        }
        return submissionPresenter2;
    }

    @NotNull
    public final PublishAdvertRequestViewModelFactory getViewModelFactory() {
        PublishAdvertRequestViewModelFactory publishAdvertRequestViewModelFactory = this.viewModelFactory;
        if (publishAdvertRequestViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return publishAdvertRequestViewModelFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = ViewModelProviders.of(requireActivity, (ViewModelProvider.Factory) null).get(PublishViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        PublishViewModel publishViewModel = (PublishViewModel) viewModel;
        PublishAdvertRequestViewModel publishAdvertRequestViewModel = this.a;
        if (publishAdvertRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SubmissionPresenter submissionPresenter2 = this.submissionPresenter;
        if (submissionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submissionPresenter");
        }
        publishAdvertRequestViewModel.initScreen(publishViewModel, submissionPresenter2);
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        PublishAdvertRequestViewModel publishAdvertRequestViewModel = this.a;
        if (publishAdvertRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        publishAdvertRequestViewModel.goPrevious();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        String string;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(LocalDraftTypeAdapterKt.DRAFT_ID)) == null) {
            throw new RuntimeException("draft_id was not passed to " + this);
        }
        Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(KEY…was not passed to $this\")");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        PublishAdvertRequestComponent.Builder imageUploadModule = DaggerPublishAdvertRequestComponent.builder().publishComponent((PublishComponent) FragmentsKt.activityComponent(this)).publishAdvertRequestModule(new PublishAdvertRequestModule()).imageUploadModule(new ImageUploadModule(requireActivity, string));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        imageUploadModule.resources(resources).build().inject(this);
        PublishAdvertRequestViewModelFactory publishAdvertRequestViewModelFactory = this.viewModelFactory;
        if (publishAdvertRequestViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, publishAdvertRequestViewModelFactory).get(PublishAdvertRequestViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.a = (PublishAdvertRequestViewModel) viewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.publish_advert_request_fragment, viewGroup, false);
        String string = getResources().getString(R.string.photo_upload_info);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.photo_upload_info)");
        this.b = string;
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        View findViewById = inflate.findViewById(R.id.image_upload_info);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.progress_indicator);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ProgressBar");
        this.d = (ProgressBar) findViewById2;
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        PublishAdvertRequestViewModel publishAdvertRequestViewModel = this.a;
        if (publishAdvertRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        publishAdvertRequestViewModel.screenState().removeObservers(getViewLifecycleOwner());
        super.onDestroyView();
    }

    @Override // com.avito.android.publish.uploading_dialog.UploadingErrorDialogListener
    public void onRetryClicked() {
        PublishAdvertRequestViewModel publishAdvertRequestViewModel = this.a;
        if (publishAdvertRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        publishAdvertRequestViewModel.retryPhotoUpload();
    }

    @Override // com.avito.android.publish.uploading_dialog.UploadingErrorDialogListener
    public void onSkipClicked() {
        PublishAdvertRequestViewModel publishAdvertRequestViewModel = this.a;
        if (publishAdvertRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        publishAdvertRequestViewModel.skipPhotoUpload();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LoadingProgressOverlay loadingProgressOverlay = this.loadingProgress;
        if (loadingProgressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        loadingProgressOverlay.setup((ViewGroup) view, R.id.image_upload_content);
        PublishAdvertRequestViewModel publishAdvertRequestViewModel = this.a;
        if (publishAdvertRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        publishAdvertRequestViewModel.screenState().observe(getViewLifecycleOwner(), new a(this));
        PublishAdvertRequestViewModel publishAdvertRequestViewModel2 = this.a;
        if (publishAdvertRequestViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LoadingProgressOverlay loadingProgressOverlay2 = this.loadingProgress;
        if (loadingProgressOverlay2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        loadingProgressOverlay2.setOnRefreshListener(new b(publishAdvertRequestViewModel2));
    }

    public final void setLoadingProgress(@NotNull LoadingProgressOverlay loadingProgressOverlay) {
        Intrinsics.checkNotNullParameter(loadingProgressOverlay, "<set-?>");
        this.loadingProgress = loadingProgressOverlay;
    }

    public final void setSubmissionPresenter(@NotNull SubmissionPresenter submissionPresenter2) {
        Intrinsics.checkNotNullParameter(submissionPresenter2, "<set-?>");
        this.submissionPresenter = submissionPresenter2;
    }

    public final void setViewModelFactory(@NotNull PublishAdvertRequestViewModelFactory publishAdvertRequestViewModelFactory) {
        Intrinsics.checkNotNullParameter(publishAdvertRequestViewModelFactory, "<set-?>");
        this.viewModelFactory = publishAdvertRequestViewModelFactory;
    }
}
