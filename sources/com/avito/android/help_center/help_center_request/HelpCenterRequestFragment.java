package com.avito.android.help_center.help_center_request;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.help_center.help_center_request.HelpCenterRequestPresenter;
import com.avito.android.help_center.help_center_request.di.DaggerHelpCenterRequestComponent;
import com.avito.android.help_center.help_center_request.di.HelpCenterRequestDependencies;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui_components.R;
import com.avito.android.util.FragmentsKt;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00019B\u0007¢\u0006\u0004\b8\u0010\u0012J-\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u0012J\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00107\u001a\u0002048\u0002@\u0002X.¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/avito/android/help_center/help_center_request/HelpCenterRequestFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenter$Router;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroyView", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "onBackPressed", "()Z", "closeActivity", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "openUriViewIntent", "(Landroid/net/Uri;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenter;", "presenter", "Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenter;", "getPresenter", "()Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenter;", "setPresenter", "(Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenter;)V", "Lcom/avito/android/help_center/help_center_request/HelpCenterRequestView;", "c", "Lcom/avito/android/help_center/help_center_request/HelpCenterRequestView;", "helpCenterView", "<init>", "Factory", "help-center_release"}, k = 1, mv = {1, 4, 2})
public final class HelpCenterRequestFragment extends BaseFragment implements HelpCenterRequestPresenter.Router, OnBackPressedListener {
    @Inject
    public Analytics analytics;
    public HelpCenterRequestView c;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public HelpCenterRequestPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/help_center/help_center_request/HelpCenterRequestFragment$Factory;", "", "", "theme", "advertisementId", "contextId", "Lcom/avito/android/help_center/help_center_request/HelpCenterRequestFragment;", "createInstance", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/help_center/help_center_request/HelpCenterRequestFragment;", "<init>", "()V", "help-center_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, String str3) {
                super(1);
                this.a = str;
                this.b = str2;
                this.c = str3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putString("key_theme", this.a);
                bundle2.putString("key_advertisement_id", this.b);
                bundle2.putString("key_context_id", this.c);
                return Unit.INSTANCE;
            }
        }

        @NotNull
        public final HelpCenterRequestFragment createInstance(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            return (HelpCenterRequestFragment) FragmentsKt.arguments(new HelpCenterRequestFragment(), 3, new a(str, str2, str3));
        }
    }

    public static final class a extends Lambda implements Function1<Exception, Unit> {
        public final /* synthetic */ HelpCenterRequestFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(HelpCenterRequestFragment helpCenterRequestFragment) {
            super(1);
            this.a = helpCenterRequestFragment;
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

    @Override // com.avito.android.help_center.help_center_request.HelpCenterRequestPresenter.Router
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
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final HelpCenterRequestPresenter getPresenter() {
        HelpCenterRequestPresenter helpCenterRequestPresenter = this.presenter;
        if (helpCenterRequestPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return helpCenterRequestPresenter;
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        HelpCenterRequestPresenter helpCenterRequestPresenter = this.presenter;
        if (helpCenterRequestPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return helpCenterRequestPresenter.handleBack();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(com.avito.android.help_center.R.layout.help_center_request_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        HelpCenterRequestPresenter helpCenterRequestPresenter = this.presenter;
        if (helpCenterRequestPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        helpCenterRequestPresenter.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        HelpCenterRequestPresenter helpCenterRequestPresenter = this.presenter;
        if (helpCenterRequestPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        helpCenterRequestPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        HelpCenterRequestPresenter helpCenterRequestPresenter = this.presenter;
        if (helpCenterRequestPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        helpCenterRequestPresenter.detachRouter();
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
        this.c = new HelpCenterRequestViewImpl(view, analytics2);
        HelpCenterRequestPresenter helpCenterRequestPresenter = this.presenter;
        if (helpCenterRequestPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        HelpCenterRequestView helpCenterRequestView = this.c;
        if (helpCenterRequestView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helpCenterView");
        }
        helpCenterRequestPresenter.attachView(helpCenterRequestView);
    }

    @Override // com.avito.android.help_center.help_center_request.HelpCenterRequestPresenter.Router
    public void openUriViewIntent(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        FragmentsKt.startActivitySafely(this, implicitIntentFactory2.uriIntent(uri), new a(this));
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setPresenter(@NotNull HelpCenterRequestPresenter helpCenterRequestPresenter) {
        Intrinsics.checkNotNullParameter(helpCenterRequestPresenter, "<set-?>");
        this.presenter = helpCenterRequestPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        String string = requireArguments().getString("key_theme");
        String string2 = requireArguments().getString("key_advertisement_id");
        DaggerHelpCenterRequestComponent.builder().dependencies((HelpCenterRequestDependencies) ComponentDependenciesKt.getDependencies(HelpCenterRequestDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).theme(string).advertisementId(string2).contextId(requireArguments().getString("key_context_id")).build().inject(this);
        return true;
    }
}
