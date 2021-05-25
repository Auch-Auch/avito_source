package com.avito.android.social.apple;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.social.R;
import com.avito.android.social.apple.AppleAuthPresenter;
import com.avito.android.social.apple.AppleAuthResult;
import com.avito.android.social.di.AppleAuthDependencies;
import com.avito.android.social.di.DaggerAppleAuthComponent;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0007¢\u0006\u0004\b*\u0010\u0011J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/avito/android/social/apple/AppleAuthFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/avito/android/social/apple/AppleAuthPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onActivityCreated", "onStart", "()V", "onDestroyView", "onStop", "Landroid/content/DialogInterface;", "dialog", "onCancel", "(Landroid/content/DialogInterface;)V", "Lcom/avito/android/social/apple/AppleAuthResult;", "result", "sendResult", "(Lcom/avito/android/social/apple/AppleAuthResult;)V", "Lcom/avito/android/social/apple/AppleAuthPresenter;", "presenter", "Lcom/avito/android/social/apple/AppleAuthPresenter;", "getPresenter", "()Lcom/avito/android/social/apple/AppleAuthPresenter;", "setPresenter", "(Lcom/avito/android/social/apple/AppleAuthPresenter;)V", "Lcom/avito/android/social/apple/AppleAuthWebViewClient;", "webViewClient", "Lcom/avito/android/social/apple/AppleAuthWebViewClient;", "getWebViewClient", "()Lcom/avito/android/social/apple/AppleAuthWebViewClient;", "setWebViewClient", "(Lcom/avito/android/social/apple/AppleAuthWebViewClient;)V", "<init>", "Companion", "social_release"}, k = 1, mv = {1, 4, 2})
public final class AppleAuthFragment extends DialogFragment implements AppleAuthPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public AppleAuthPresenter presenter;
    @Inject
    public AppleAuthWebViewClient webViewClient;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/social/apple/AppleAuthFragment$Companion;", "", "Lcom/avito/android/social/apple/AppleAuthFragment;", "newInstance", "()Lcom/avito/android/social/apple/AppleAuthFragment;", "<init>", "()V", "social_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final AppleAuthFragment newInstance() {
            return new AppleAuthFragment();
        }

        public Companion(j jVar) {
        }
    }

    @NotNull
    public final AppleAuthPresenter getPresenter() {
        AppleAuthPresenter appleAuthPresenter = this.presenter;
        if (appleAuthPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return appleAuthPresenter;
    }

    @NotNull
    public final AppleAuthWebViewClient getWebViewClient() {
        AppleAuthWebViewClient appleAuthWebViewClient = this.webViewClient;
        if (appleAuthWebViewClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webViewClient");
        }
        return appleAuthWebViewClient;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Window window;
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(0);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerAppleAuthComponent.builder().dependentOn((AppleAuthDependencies) ComponentDependenciesKt.getDependencies(AppleAuthDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).build().inject(this);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_apple_auth, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        AppleAuthWebViewClient appleAuthWebViewClient = this.webViewClient;
        if (appleAuthWebViewClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webViewClient");
        }
        AppleAuthViewImpl appleAuthViewImpl = new AppleAuthViewImpl(inflate, appleAuthWebViewClient);
        AppleAuthPresenter appleAuthPresenter = this.presenter;
        if (appleAuthPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        appleAuthPresenter.attachView(appleAuthViewImpl);
        Unit unit = Unit.INSTANCE;
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        AppleAuthPresenter appleAuthPresenter = this.presenter;
        if (appleAuthPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        appleAuthPresenter.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        AppleAuthPresenter appleAuthPresenter = this.presenter;
        if (appleAuthPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        appleAuthPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        AppleAuthPresenter appleAuthPresenter = this.presenter;
        if (appleAuthPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        appleAuthPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.social.apple.AppleAuthPresenter.Router
    public void sendResult(@Nullable AppleAuthResult appleAuthResult) {
        if (appleAuthResult instanceof AppleAuthResult.Success) {
            Intent intent = new Intent();
            AppleAuthResult.Success success = (AppleAuthResult.Success) appleAuthResult;
            intent.putExtra(AppleSignInManagerKt.EXTRA_APPLE_TOKEN, success.getCode());
            intent.putExtra("user", success.getUser());
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(-1, intent);
            }
        } else if (appleAuthResult instanceof AppleAuthResult.Failure) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.setResult(1);
            }
        } else {
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                activity3.setResult(0);
            }
        }
        FragmentActivity activity4 = getActivity();
        if (activity4 != null) {
            activity4.finish();
        }
    }

    public final void setPresenter(@NotNull AppleAuthPresenter appleAuthPresenter) {
        Intrinsics.checkNotNullParameter(appleAuthPresenter, "<set-?>");
        this.presenter = appleAuthPresenter;
    }

    public final void setWebViewClient(@NotNull AppleAuthWebViewClient appleAuthWebViewClient) {
        Intrinsics.checkNotNullParameter(appleAuthWebViewClient, "<set-?>");
        this.webViewClient = appleAuthWebViewClient;
    }
}
