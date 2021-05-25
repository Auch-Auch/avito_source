package com.avito.android.social.esia;

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
import com.avito.android.social.EsiaSignInManagerKt;
import com.avito.android.social.R;
import com.avito.android.social.di.esia.DaggerEsiaAuthComponent;
import com.avito.android.social.di.esia.EsiaAuthDependencies;
import com.avito.android.social.esia.EsiaAuthPresenter;
import com.avito.android.social.esia.EsiaAuthResult;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0007¢\u0006\u0004\b$\u0010\u0011J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0011J\u0019\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u0011R\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/avito/android/social/esia/EsiaAuthFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/avito/android/social/esia/EsiaAuthPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onActivityCreated", "onStart", "()V", "onDestroyView", "Landroid/content/DialogInterface;", "dialog", "onCancel", "(Landroid/content/DialogInterface;)V", "onStop", "Lcom/avito/android/social/esia/EsiaAuthResult;", "result", "sendResult", "(Lcom/avito/android/social/esia/EsiaAuthResult;)V", "onBackPressed", "Lcom/avito/android/social/esia/EsiaAuthPresenter;", "presenter", "Lcom/avito/android/social/esia/EsiaAuthPresenter;", "getPresenter", "()Lcom/avito/android/social/esia/EsiaAuthPresenter;", "setPresenter", "(Lcom/avito/android/social/esia/EsiaAuthPresenter;)V", "<init>", "Companion", "social_release"}, k = 1, mv = {1, 4, 2})
public final class EsiaAuthFragment extends DialogFragment implements EsiaAuthPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public EsiaAuthPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/social/esia/EsiaAuthFragment$Companion;", "", "Lcom/avito/android/social/esia/EsiaAuthFragment;", "newInstance", "()Lcom/avito/android/social/esia/EsiaAuthFragment;", "<init>", "()V", "social_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final EsiaAuthFragment newInstance() {
            return new EsiaAuthFragment();
        }

        public Companion(j jVar) {
        }
    }

    @NotNull
    public final EsiaAuthPresenter getPresenter() {
        EsiaAuthPresenter esiaAuthPresenter = this.presenter;
        if (esiaAuthPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return esiaAuthPresenter;
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

    public final void onBackPressed() {
        EsiaAuthPresenter esiaAuthPresenter = this.presenter;
        if (esiaAuthPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        esiaAuthPresenter.onBackPressed();
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
        DaggerEsiaAuthComponent.factory().create((EsiaAuthDependencies) ComponentDependenciesKt.getDependencies(EsiaAuthDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_esia_auth, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        EsiaAuthViewImpl esiaAuthViewImpl = new EsiaAuthViewImpl(inflate, new EsiaWebViewClient());
        EsiaAuthPresenter esiaAuthPresenter = this.presenter;
        if (esiaAuthPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        esiaAuthPresenter.attachView(esiaAuthViewImpl);
        Unit unit = Unit.INSTANCE;
        EsiaAuthPresenter esiaAuthPresenter2 = this.presenter;
        if (esiaAuthPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        esiaAuthPresenter2.attachRouter(this);
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        EsiaAuthPresenter esiaAuthPresenter = this.presenter;
        if (esiaAuthPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        esiaAuthPresenter.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        EsiaAuthPresenter esiaAuthPresenter = this.presenter;
        if (esiaAuthPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        esiaAuthPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        EsiaAuthPresenter esiaAuthPresenter = this.presenter;
        if (esiaAuthPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        esiaAuthPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.social.esia.EsiaAuthPresenter.Router
    public void sendResult(@Nullable EsiaAuthResult esiaAuthResult) {
        if (esiaAuthResult instanceof EsiaAuthResult.Success) {
            Intent intent = new Intent();
            EsiaAuthResult.Success success = (EsiaAuthResult.Success) esiaAuthResult;
            intent.putExtra(EsiaSignInManagerKt.EXTRA_ESIA_CODE, success.getCode());
            intent.putExtra(EsiaSignInManagerKt.EXTRA_ESIA_STATE, success.getState());
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(-1, intent);
            }
        } else if (esiaAuthResult instanceof EsiaAuthResult.Failure) {
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

    public final void setPresenter(@NotNull EsiaAuthPresenter esiaAuthPresenter) {
        Intrinsics.checkNotNullParameter(esiaAuthPresenter, "<set-?>");
        this.presenter = esiaAuthPresenter;
    }
}
