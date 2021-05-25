package com.avito.android.profile.password_setting;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.profile.ProfileConstants;
import com.avito.android.profile.R;
import com.avito.android.profile.password_setting.PasswordSettingPresenter;
import com.avito.android.profile.password_setting.di.DaggerPasswordSettingComponent;
import com.avito.android.profile.password_setting.di.PasswordSettingComponent;
import com.avito.android.profile.password_setting.di.PasswordSettingDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.Bundles;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0007¢\u0006\u0004\b;\u0010\u0011J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010 \u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/avito/android/profile/password_setting/PasswordSettingFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/profile/password_setting/PasswordSettingPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onDestroyView", "()V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "leaveScreen", "navigateToAuth", "", "message", "leaveWithSuccessMessage", "(Ljava/lang/String;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "followDeeplink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/profile/password_setting/PasswordSettingPresenter;", "presenter", "Lcom/avito/android/profile/password_setting/PasswordSettingPresenter;", "getPresenter", "()Lcom/avito/android/profile/password_setting/PasswordSettingPresenter;", "setPresenter", "(Lcom/avito/android/profile/password_setting/PasswordSettingPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "<init>", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PasswordSettingFragment extends BaseFragment implements PasswordSettingPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public PasswordSettingPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/profile/password_setting/PasswordSettingFragment$Companion;", "", "Lcom/avito/android/profile/password_setting/PasswordSettingFragment;", "newInstance", "()Lcom/avito/android/profile/password_setting/PasswordSettingFragment;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final PasswordSettingFragment newInstance() {
            PasswordSettingFragment passwordSettingFragment = new PasswordSettingFragment();
            passwordSettingFragment.setArguments(new Bundle());
            return passwordSettingFragment;
        }

        public Companion(j jVar) {
        }
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingPresenter.Router
    public void followDeeplink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivity(intent);
        }
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
    public final PasswordSettingPresenter getPresenter() {
        PasswordSettingPresenter passwordSettingPresenter = this.presenter;
        if (passwordSettingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return passwordSettingPresenter;
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingPresenter.Router
    public void leaveScreen() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingPresenter.Router
    public void leaveWithSuccessMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra(ProfileConstants.PASSWORD_CHANGE_RESULT, str);
            intent.putExtra(ProfileConstants.PASSWORD_CHANGE_UPDATE_PROFILE, true);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingPresenter.Router
    public void navigateToAuth() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, AuthSource.PASSWORD_SETTING, null, 5, null), 1505);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1505) {
            PasswordSettingPresenter passwordSettingPresenter = this.presenter;
            if (passwordSettingPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            passwordSettingPresenter.onAuthResult(i2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.password_setting_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        PasswordSettingViewImpl passwordSettingViewImpl = new PasswordSettingViewImpl(inflate);
        PasswordSettingPresenter passwordSettingPresenter = this.presenter;
        if (passwordSettingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        passwordSettingPresenter.attachView(passwordSettingViewImpl);
        PasswordSettingPresenter passwordSettingPresenter2 = this.presenter;
        if (passwordSettingPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        passwordSettingPresenter2.attachRouter(this);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        PasswordSettingPresenter passwordSettingPresenter = this.presenter;
        if (passwordSettingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        passwordSettingPresenter.detachView();
        PasswordSettingPresenter passwordSettingPresenter2 = this.presenter;
        if (passwordSettingPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        passwordSettingPresenter2.detachRouter();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        PasswordSettingPresenter passwordSettingPresenter = this.presenter;
        if (passwordSettingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", passwordSettingPresenter.onSaveState());
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setPresenter(@NotNull PasswordSettingPresenter passwordSettingPresenter) {
        Intrinsics.checkNotNullParameter(passwordSettingPresenter, "<set-?>");
        this.presenter = passwordSettingPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        PasswordSettingComponent.Factory factory = DaggerPasswordSettingComponent.factory();
        PasswordSettingDependencies passwordSettingDependencies = (PasswordSettingDependencies) ComponentDependenciesKt.getDependencies(PasswordSettingDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this));
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        factory.create(passwordSettingDependencies, requireActivity, resources, bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null).inject(this);
        return true;
    }
}
