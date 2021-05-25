package com.avito.android.help_center;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.help_center.HelpCenterPresenter;
import com.avito.android.help_center.di.DaggerHelpCenterComponent;
import com.avito.android.help_center.di.HelpCenterComponentDependencies;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui_components.R;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Views;
import com.facebook.share.internal.ShareConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bI\u0010\u0012J-\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00182\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u0012J\u000f\u0010\u001c\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b?\u0010@R\"\u0010C\u001a\u00020B8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006J"}, d2 = {"Lcom/avito/android/help_center/HelpCenterFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/help_center/HelpCenterPresenter$Router;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroyView", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "closeActivity", "onBackPressed", "()Z", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "openUriViewIntent", "(Landroid/net/Uri;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/help_center/HelpCenterPresenter;", "presenter", "Lcom/avito/android/help_center/HelpCenterPresenter;", "getPresenter", "()Lcom/avito/android/help_center/HelpCenterPresenter;", "setPresenter", "(Lcom/avito/android/help_center/HelpCenterPresenter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeeplinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeeplinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/help_center/HelpCenterView;", "c", "Lcom/avito/android/help_center/HelpCenterView;", "hcView", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deeplinkFactory", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "getDeeplinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "setDeeplinkFactory", "(Lcom/avito/android/deep_linking/DeepLinkFactory;)V", "<init>", "help-center_release"}, k = 1, mv = {1, 4, 2})
public final class HelpCenterFragment extends BaseFragment implements HelpCenterPresenter.Router, OnBackPressedListener {
    @Inject
    public Analytics analytics;
    public HelpCenterView c;
    @Inject
    public DeepLinkFactory deeplinkFactory;
    @Inject
    public DeepLinkIntentFactory deeplinkIntentFactory;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public HelpCenterPresenter presenter;

    public static final class a extends Lambda implements Function1<Exception, Unit> {
        public final /* synthetic */ HelpCenterFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(HelpCenterFragment helpCenterFragment) {
            super(1);
            this.a = helpCenterFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            View view = this.a.getView();
            if (view != null) {
                Views.showSnackBar$default(view, R.string.no_application_installed_to_perform_this_action, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.help_center.HelpCenterPresenter.Router
    public void closeActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final DeepLinkFactory getDeeplinkFactory() {
        DeepLinkFactory deepLinkFactory = this.deeplinkFactory;
        if (deepLinkFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deeplinkFactory");
        }
        return deepLinkFactory;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeeplinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory = this.deeplinkIntentFactory;
        if (deepLinkIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deeplinkIntentFactory");
        }
        return deepLinkIntentFactory;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final HelpCenterPresenter getPresenter() {
        HelpCenterPresenter helpCenterPresenter = this.presenter;
        if (helpCenterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return helpCenterPresenter;
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        HelpCenterPresenter helpCenterPresenter = this.presenter;
        if (helpCenterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return helpCenterPresenter.handleBack();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.help_center_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        HelpCenterPresenter helpCenterPresenter = this.presenter;
        if (helpCenterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        helpCenterPresenter.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        HelpCenterPresenter helpCenterPresenter = this.presenter;
        if (helpCenterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("key_presenter_state", helpCenterPresenter.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        HelpCenterPresenter helpCenterPresenter = this.presenter;
        if (helpCenterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        helpCenterPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        HelpCenterPresenter helpCenterPresenter = this.presenter;
        if (helpCenterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        helpCenterPresenter.detachRouter();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        this.c = new HelpCenterViewImpl(view, analytics2);
        HelpCenterPresenter helpCenterPresenter = this.presenter;
        if (helpCenterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        HelpCenterView helpCenterView = this.c;
        if (helpCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hcView");
        }
        helpCenterPresenter.attachView(helpCenterView);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (r0 != null) goto L_0x0037;
     */
    @Override // com.avito.android.help_center.HelpCenterPresenter.Router
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openUriViewIntent(@org.jetbrains.annotations.NotNull android.net.Uri r4) {
        /*
            r3 = this;
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.avito.android.deep_linking.DeepLinkFactory r0 = r3.deeplinkFactory
            if (r0 != 0) goto L_0x000e
            java.lang.String r1 = "deeplinkFactory"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x000e:
            com.avito.android.deep_linking.links.DeepLink r0 = r0.createFromUri(r4)
            boolean r1 = r0 instanceof com.avito.android.deep_linking.links.SupportChatFormLink
            if (r1 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x002a
            com.avito.android.deep_linking.DeepLinkIntentFactory r1 = r3.deeplinkIntentFactory
            if (r1 != 0) goto L_0x0023
            java.lang.String r2 = "deeplinkIntentFactory"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0023:
            android.content.Intent r0 = r1.getIntent(r0)
            if (r0 == 0) goto L_0x002a
            goto L_0x0037
        L_0x002a:
            com.avito.android.util.ImplicitIntentFactory r0 = r3.implicitIntentFactory
            if (r0 != 0) goto L_0x0033
            java.lang.String r1 = "implicitIntentFactory"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0033:
            android.content.Intent r0 = r0.uriIntent(r4)
        L_0x0037:
            com.avito.android.help_center.HelpCenterFragment$a r4 = new com.avito.android.help_center.HelpCenterFragment$a
            r4.<init>(r3)
            com.avito.android.util.FragmentsKt.startActivitySafely(r3, r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.help_center.HelpCenterFragment.openUriViewIntent(android.net.Uri):void");
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeeplinkFactory(@NotNull DeepLinkFactory deepLinkFactory) {
        Intrinsics.checkNotNullParameter(deepLinkFactory, "<set-?>");
        this.deeplinkFactory = deepLinkFactory;
    }

    public final void setDeeplinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "<set-?>");
        this.deeplinkIntentFactory = deepLinkIntentFactory;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setPresenter(@NotNull HelpCenterPresenter helpCenterPresenter) {
        Intrinsics.checkNotNullParameter(helpCenterPresenter, "<set-?>");
        this.presenter = helpCenterPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        HelpCenterPresenterState helpCenterPresenterState = null;
        String string = arguments != null ? arguments.getString("key_url") : null;
        if (bundle != null) {
            helpCenterPresenterState = (HelpCenterPresenterState) bundle.getParcelable("key_presenter_state");
        }
        DaggerHelpCenterComponent.builder().dependencies((HelpCenterComponentDependencies) ComponentDependenciesKt.getDependencies(HelpCenterComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).url(string).state(helpCenterPresenterState).build().inject(this);
        return true;
    }
}
