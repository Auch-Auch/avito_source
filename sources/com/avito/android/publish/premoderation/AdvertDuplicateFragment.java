package com.avito.android.publish.premoderation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.publish.di.PublishDependencies;
import com.avito.android.publish.premoderation.AdvertDuplicatePresenter;
import com.avito.android.publish.premoderation.di.DaggerPublishAdvertDuplicateComponent;
import com.avito.android.publish.premoderation.di.PublishAdvertDuplicateModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertDuplicateResult;
import com.avito.android.ui_components.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b6\u0010\u0010J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0010J\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u0010R\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/avito/android/publish/premoderation/AdvertDuplicateFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/avito/android/publish/premoderation/AdvertDuplicatePresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onStart", "()V", "onStop", "Landroid/content/DialogInterface;", "dialog", "onCancel", "(Landroid/content/DialogInterface;)V", "onDismiss", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "leaveScreen", "onContinueClicked", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/publish/premoderation/AdvertDuplicateDialogListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/premoderation/AdvertDuplicateDialogListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/publish/premoderation/AdvertDuplicatePresenter;", "presenter", "Lcom/avito/android/publish/premoderation/AdvertDuplicatePresenter;", "getPresenter", "()Lcom/avito/android/publish/premoderation/AdvertDuplicatePresenter;", "setPresenter", "(Lcom/avito/android/publish/premoderation/AdvertDuplicatePresenter;)V", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDuplicateFragment extends DialogFragment implements AdvertDuplicatePresenter.Router {
    public AdvertDuplicateDialogListener a;
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public AdvertDuplicatePresenter presenter;

    @Override // com.avito.android.publish.premoderation.AdvertDuplicatePresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        AdvertDuplicateDialogListener advertDuplicateDialogListener = this.a;
        if (advertDuplicateDialogListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }
        advertDuplicateDialogListener.onActionClicked(deepLink);
        dismissAllowingStateLoss();
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
    public final AdvertDuplicatePresenter getPresenter() {
        AdvertDuplicatePresenter advertDuplicatePresenter = this.presenter;
        if (advertDuplicatePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return advertDuplicatePresenter;
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicatePresenter.Router
    public void leaveScreen() {
        AdvertDuplicateDialogListener advertDuplicateDialogListener = this.a;
        if (advertDuplicateDialogListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }
        advertDuplicateDialogListener.onLeaveScreen();
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        AdvertDuplicateDialogListener advertDuplicateDialogListener = this.a;
        if (advertDuplicateDialogListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }
        advertDuplicateDialogListener.onLeaveScreen();
        super.onCancel(dialogInterface);
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicatePresenter.Router
    public void onContinueClicked() {
        AdvertDuplicateDialogListener advertDuplicateDialogListener = this.a;
        if (advertDuplicateDialogListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }
        advertDuplicateDialogListener.onContinueClicked();
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.Theme_Avito_Dialog_FullScreen);
        Bundle arguments = getArguments();
        AdvertDuplicateResult advertDuplicateResult = arguments != null ? (AdvertDuplicateResult) arguments.getParcelable("key_advert_duplicate_data") : null;
        if (advertDuplicateResult != null) {
            DaggerPublishAdvertDuplicateComponent.builder().publishDependencies((PublishDependencies) ComponentDependenciesKt.getDependencies(PublishDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).publishAdvertDuplicateModule(new PublishAdvertDuplicateModule(advertDuplicateResult)).build().inject(this);
            return;
        }
        throw new IllegalArgumentException("AdvertDuplicateData must not be null".toString());
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(com.avito.android.publish.R.layout.advert_duplicate, (ViewGroup) null);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        AdvertDuplicateViewImpl advertDuplicateViewImpl = new AdvertDuplicateViewImpl((ViewGroup) inflate);
        AdvertDuplicatePresenter advertDuplicatePresenter = this.presenter;
        if (advertDuplicatePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        advertDuplicatePresenter.attachView(advertDuplicateViewImpl);
        Fragment targetFragment = getTargetFragment();
        Objects.requireNonNull(targetFragment, "null cannot be cast to non-null type com.avito.android.publish.premoderation.AdvertDuplicateDialogListener");
        this.a = (AdvertDuplicateDialogListener) targetFragment;
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        AdvertDuplicatePresenter advertDuplicatePresenter = this.presenter;
        if (advertDuplicatePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        advertDuplicatePresenter.detachView();
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        AdvertDuplicatePresenter advertDuplicatePresenter = this.presenter;
        if (advertDuplicatePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        advertDuplicatePresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        AdvertDuplicatePresenter advertDuplicatePresenter = this.presenter;
        if (advertDuplicatePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        advertDuplicatePresenter.detachRouter();
        super.onStop();
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setPresenter(@NotNull AdvertDuplicatePresenter advertDuplicatePresenter) {
        Intrinsics.checkNotNullParameter(advertDuplicatePresenter, "<set-?>");
        this.presenter = advertDuplicatePresenter;
    }
}
