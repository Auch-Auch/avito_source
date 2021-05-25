package com.avito.android.publish.edit_advert_request;

import a2.a.a.e2.u.a;
import a2.a.a.e2.u.b;
import a2.a.a.e2.u.c;
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
import com.avito.android.FeesIntentFactory;
import com.avito.android.UserAdvertIntentFactory;
import com.avito.android.UserAdvertsIntentFactory;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.publish.PublishActivity;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.R;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.edit_advert_request.di.DaggerEditAdvertRequestComponent;
import com.avito.android.publish.edit_advert_request.di.EditAdvertRequestComponent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.user_advert.UserAdvertConstantsKt;
import com.avito.android.util.Constants;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.FragmentsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bJ\u0010\u0018J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\"\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020G8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0007\u0010H¨\u0006K"}, d2 = {"Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "", "message", BookingInfoActivity.EXTRA_ITEM_ID, "", AuthSource.SEND_ABUSE, "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "onActivityCreated", "", "onBackPressed", "()Z", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "loadingProgress", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "getLoadingProgress", "()Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "setLoadingProgress", "(Lcom/avito/android/progress_overlay/LoadingProgressOverlay;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModelFactory;", "viewModelFactory", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModelFactory;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel;", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel;", "viewModel", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class EditAdvertRequestFragment extends Fragment implements OnBackPressedListener {
    public EditAdvertRequestViewModel a;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public LoadingProgressOverlay loadingProgress;
    @Inject
    public EditAdvertRequestViewModelFactory viewModelFactory;

    public static final /* synthetic */ EditAdvertRequestViewModel access$getViewModel$p(EditAdvertRequestFragment editAdvertRequestFragment) {
        EditAdvertRequestViewModel editAdvertRequestViewModel = editAdvertRequestFragment.a;
        if (editAdvertRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return editAdvertRequestViewModel;
    }

    public static final void access$openDeepLinkAndFinishEdit(EditAdvertRequestFragment editAdvertRequestFragment, DeepLink deepLink, String str) {
        editAdvertRequestFragment.a(null, str);
        DeepLinkIntentFactory deepLinkIntentFactory2 = editAdvertRequestFragment.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            editAdvertRequestFragment.startActivity(intent);
        }
    }

    public static final void access$showActionDialog(EditAdvertRequestFragment editAdvertRequestFragment, Action.Confirmation confirmation, Function0 function0) {
        DialogRouter dialogRouter2 = editAdvertRequestFragment.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        DialogRouter.DefaultImpls.showCancelableNotifyingDialog$default(dialogRouter2, null, true, confirmation.getDescription(), confirmation.getCancel(), new c(editAdvertRequestFragment), confirmation.getOk(), function0, 1, null);
    }

    public static final void access$showFees(EditAdvertRequestFragment editAdvertRequestFragment, DeepLink deepLink, String str) {
        DeepLinkIntentFactory deepLinkIntentFactory2 = editAdvertRequestFragment.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            ActivityIntentFactory activityIntentFactory = editAdvertRequestFragment.intentFactory;
            if (activityIntentFactory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
            }
            Intent myAdvertDetailsIntent$default = UserAdvertIntentFactory.DefaultImpls.myAdvertDetailsIntent$default(activityIntentFactory, str, null, null, false, 14, null);
            ActivityIntentFactory activityIntentFactory2 = editAdvertRequestFragment.intentFactory;
            if (activityIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
            }
            Intent flags = myAdvertDetailsIntent$default.putExtra(Constants.UP_INTENT, UserAdvertsIntentFactory.DefaultImpls.createUserAdvertsIntent$default(activityIntentFactory2, null, null, false, 7, null)).setFlags(603979776);
            Intrinsics.checkNotNullExpressionValue(flags, "intentFactory.myAdvertDe…FLAG_ACTIVITY_SINGLE_TOP)");
            intent.putExtra(Constants.UP_INTENT, flags);
            editAdvertRequestFragment.startActivityForResult(intent, 1);
        }
    }

    public static final void access$showFeesLegacy(EditAdvertRequestFragment editAdvertRequestFragment, String str) {
        ActivityIntentFactory activityIntentFactory = editAdvertRequestFragment.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        editAdvertRequestFragment.startActivityForResult(FeesIntentFactory.DefaultImpls.feesIntent$default(activityIntentFactory, str, false, false, 6, null), 1);
    }

    public final void a(String str, String str2) {
        Intent putExtra = new Intent().putExtra("status_message", str).putExtra("edited_advert_id", str2);
        EditAdvertRequestViewModel editAdvertRequestViewModel = this.a;
        if (editAdvertRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Intent putExtra2 = putExtra.putExtra(UserAdvertConstantsKt.EDITED_ADVERT_POST_ACTION, editAdvertRequestViewModel.getPostAction());
        Intrinsics.checkNotNullExpressionValue(putExtra2, "Intent().putExtra(RESULT…ON, viewModel.postAction)");
        FragmentActivity activity = getActivity();
        if (!(activity instanceof PublishActivity)) {
            activity = null;
        }
        PublishActivity publishActivity = (PublishActivity) activity;
        if (publishActivity != null) {
            publishActivity.leavePublish(putExtra2);
        }
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
    public final DialogRouter getDialogRouter() {
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        return dialogRouter2;
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
    public final LoadingProgressOverlay getLoadingProgress() {
        LoadingProgressOverlay loadingProgressOverlay = this.loadingProgress;
        if (loadingProgressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        return loadingProgressOverlay;
    }

    @NotNull
    public final EditAdvertRequestViewModelFactory getViewModelFactory() {
        EditAdvertRequestViewModelFactory editAdvertRequestViewModelFactory = this.viewModelFactory;
        if (editAdvertRequestViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return editAdvertRequestViewModelFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = ViewModelProviders.of(requireActivity, (ViewModelProvider.Factory) null).get(PublishViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        PublishViewModel publishViewModel = (PublishViewModel) viewModel;
        EditAdvertRequestViewModel editAdvertRequestViewModel = this.a;
        if (editAdvertRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        editAdvertRequestViewModel.initScreen(publishViewModel);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == 1) {
            EditAdvertRequestViewModel editAdvertRequestViewModel = this.a;
            if (editAdvertRequestViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            editAdvertRequestViewModel.onFeesSuccess();
        }
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        EditAdvertRequestViewModel editAdvertRequestViewModel = this.a;
        if (editAdvertRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        editAdvertRequestViewModel.goPrevious();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        EditAdvertRequestComponent.Builder publishComponent = DaggerEditAdvertRequestComponent.builder().publishComponent((PublishComponent) FragmentsKt.activityComponent(this));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        publishComponent.resources(resources).build().inject(this);
        EditAdvertRequestViewModelFactory editAdvertRequestViewModelFactory = this.viewModelFactory;
        if (editAdvertRequestViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, editAdvertRequestViewModelFactory).get(EditAdvertRequestViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.a = (EditAdvertRequestViewModel) viewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.edit_advert_request_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        EditAdvertRequestViewModel editAdvertRequestViewModel = this.a;
        if (editAdvertRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        editAdvertRequestViewModel.screenState().removeObservers(getViewLifecycleOwner());
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
        loadingProgressOverlay.setup((ViewGroup) view, R.id.content);
        LoadingProgressOverlay loadingProgressOverlay2 = this.loadingProgress;
        if (loadingProgressOverlay2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        loadingProgressOverlay2.showFullScreenLoading();
        EditAdvertRequestViewModel editAdvertRequestViewModel = this.a;
        if (editAdvertRequestViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        editAdvertRequestViewModel.screenState().observe(getViewLifecycleOwner(), new a(this));
        EditAdvertRequestViewModel editAdvertRequestViewModel2 = this.a;
        if (editAdvertRequestViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LoadingProgressOverlay loadingProgressOverlay3 = this.loadingProgress;
        if (loadingProgressOverlay3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        loadingProgressOverlay3.setOnRefreshListener(new b(editAdvertRequestViewModel2));
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setLoadingProgress(@NotNull LoadingProgressOverlay loadingProgressOverlay) {
        Intrinsics.checkNotNullParameter(loadingProgressOverlay, "<set-?>");
        this.loadingProgress = loadingProgressOverlay;
    }

    public final void setViewModelFactory(@NotNull EditAdvertRequestViewModelFactory editAdvertRequestViewModelFactory) {
        Intrinsics.checkNotNullParameter(editAdvertRequestViewModelFactory, "<set-?>");
        this.viewModelFactory = editAdvertRequestViewModelFactory;
    }
}
