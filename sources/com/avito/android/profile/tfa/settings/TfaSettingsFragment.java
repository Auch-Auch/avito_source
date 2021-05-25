package com.avito.android.profile.tfa.settings;

import android.content.Context;
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
import com.avito.android.profile.tfa.settings.TfaSettingsPresenter;
import com.avito.android.profile.tfa.settings.di.DaggerTfaSettingsComponent;
import com.avito.android.profile.tfa.settings.di.TfaSettingsDependencies;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.ui_components.R;
import com.avito.android.util.Bundles;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.Kundle;
import com.avito.android.util.ToastsKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBarImpl;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u0007¢\u0006\u0004\b8\u0010\u0011J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001c\u0010\u0011J\u0017\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000fH\u0016¢\u0006\u0004\b!\u0010\u0011J\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\"\u0010\u0011R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/avito/android/profile/tfa/settings/TfaSettingsFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/profile/tfa/settings/TfaSettingsPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onDestroyView", "()V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "navigateToAuth", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "leaveScreen", "setOkResult", "Lcom/avito/android/profile/tfa/settings/TfaSettingsPresenter;", "presenter", "Lcom/avito/android/profile/tfa/settings/TfaSettingsPresenter;", "getPresenter", "()Lcom/avito/android/profile/tfa/settings/TfaSettingsPresenter;", "setPresenter", "(Lcom/avito/android/profile/tfa/settings/TfaSettingsPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "<init>", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class TfaSettingsFragment extends BaseFragment implements TfaSettingsPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public TfaSettingsPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/profile/tfa/settings/TfaSettingsFragment$Companion;", "", "", "isEnabled", "", "warning", "Lcom/avito/android/profile/tfa/settings/TfaSettingsFragment;", "newInstance", "(ZLjava/lang/String;)Lcom/avito/android/profile/tfa/settings/TfaSettingsFragment;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final TfaSettingsFragment newInstance(boolean z, @Nullable String str) {
            TfaSettingsFragment tfaSettingsFragment = new TfaSettingsFragment();
            Bundle bundle = new Bundle();
            Bundles.putKundle(bundle, "presenter_state", new Kundle().putBoolean(TfaSettingsActivity.EXTRA_IS_ENABLED, Boolean.valueOf(z)).putString("warning", str));
            tfaSettingsFragment.setArguments(bundle);
            return tfaSettingsFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Exception, Unit> {
        public final /* synthetic */ TfaSettingsFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TfaSettingsFragment tfaSettingsFragment) {
            super(1);
            this.a = tfaSettingsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            TfaSettingsFragment tfaSettingsFragment = this.a;
            int i = R.string.no_application_installed_to_perform_this_action;
            Context context = tfaSettingsFragment.getContext();
            if (context != null) {
                ToastsKt.showToast(context, i, 0);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            FragmentsKt.startActivitySafely(this, intent, new a(this));
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
    public final TfaSettingsPresenter getPresenter() {
        TfaSettingsPresenter tfaSettingsPresenter = this.presenter;
        if (tfaSettingsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return tfaSettingsPresenter;
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsPresenter.Router
    public void leaveScreen() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsPresenter.Router
    public void navigateToAuth() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, "tfa_settings", null, 5, null), 1577);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1577) {
            TfaSettingsPresenter tfaSettingsPresenter = this.presenter;
            if (tfaSettingsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            tfaSettingsPresenter.onAuthResult(i2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(com.avito.android.profile.R.layout.tfa_settings_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        View findViewById = inflate.findViewById(com.avito.android.profile.R.id.scroll_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        TfaSettingsViewImpl tfaSettingsViewImpl = new TfaSettingsViewImpl(inflate, new AppBarImpl(inflate, findViewById, true));
        TfaSettingsPresenter tfaSettingsPresenter = this.presenter;
        if (tfaSettingsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        tfaSettingsPresenter.attachView(tfaSettingsViewImpl);
        TfaSettingsPresenter tfaSettingsPresenter2 = this.presenter;
        if (tfaSettingsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        tfaSettingsPresenter2.attachRouter(this);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        TfaSettingsPresenter tfaSettingsPresenter = this.presenter;
        if (tfaSettingsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        tfaSettingsPresenter.detachView();
        TfaSettingsPresenter tfaSettingsPresenter2 = this.presenter;
        if (tfaSettingsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        tfaSettingsPresenter2.detachRouter();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        TfaSettingsPresenter tfaSettingsPresenter = this.presenter;
        if (tfaSettingsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", tfaSettingsPresenter.onSaveState());
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsPresenter.Router
    public void setOkResult() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1);
        }
    }

    public final void setPresenter(@NotNull TfaSettingsPresenter tfaSettingsPresenter) {
        Intrinsics.checkNotNullParameter(tfaSettingsPresenter, "<set-?>");
        this.presenter = tfaSettingsPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Kundle kundle;
        if (bundle == null || (kundle = Bundles.getKundle(bundle, "presenter_state")) == null) {
            Bundle arguments = getArguments();
            kundle = arguments != null ? Bundles.getKundle(arguments, "presenter_state") : null;
        }
        if (kundle != null) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            DaggerTfaSettingsComponent.factory().create(requireActivity, resources, kundle, (TfaSettingsDependencies) ComponentDependenciesKt.getDependencies(TfaSettingsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
            return true;
        }
        throw new IllegalStateException("State must be initialized");
    }
}
