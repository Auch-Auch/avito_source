package com.avito.android.verification.verification_status;

import a2.a.a.r3.a.d;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.verification.R;
import com.avito.android.verification.VerificationActivityKt;
import com.avito.android.verification.di.DaggerVerificationStatusComponent;
import com.avito.android.verification.di.VerificationStatusComponent;
import com.avito.android.verification.di.VerificationStatusDependencies;
import com.avito.android.verification.verification_status.VerificationStatusViewModel;
import com.avito.android.verification.verification_status.actions.VerificationActionActivityKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001(\u0018\u0000 M2\u00020\u0001:\u0002MNB\u0007¢\u0006\u0004\bL\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u00020!8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010-\u001a\u00020,8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0006@\u0006X.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010B\u001a\u00020A8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020H8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bI\u0010J¨\u0006O"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Lcom/avito/android/verification/verification_status/VerificationStatusView;", "d", "Lcom/avito/android/verification/verification_status/VerificationStatusView;", "verificationView", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$verification_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$verification_release", "(Lcom/avito/android/analytics/Analytics;)V", "com/avito/android/verification/verification_status/VerificationStatusFragment$actionResultReceiver$1", "c", "Lcom/avito/android/verification/verification_status/VerificationStatusFragment$actionResultReceiver$1;", "actionResultReceiver", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory$verification_release", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory$verification_release", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModel;", "viewModel", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModel;", "getViewModel$verification_release", "()Lcom/avito/android/verification/verification_status/VerificationStatusViewModel;", "setViewModel$verification_release", "(Lcom/avito/android/verification/verification_status/VerificationStatusViewModel;)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "getTextFormatter$verification_release", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "setTextFormatter$verification_release", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "", AuthSource.SEND_ABUSE, "()Ljava/lang/String;", "verificationType", "<init>", "Companion", "VerificationsStatusRouter", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationStatusFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public Analytics analytics;
    public final VerificationStatusFragment$actionResultReceiver$1 c = new VerificationStatusFragment$actionResultReceiver$1(this);
    public VerificationStatusView d;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public AttributedTextFormatter textFormatter;
    @Inject
    public VerificationStatusViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusFragment$Companion;", "", "", "type", "Lcom/avito/android/verification/verification_status/VerificationStatusFragment;", "newInstance", "(Ljava/lang/String;)Lcom/avito/android/verification/verification_status/VerificationStatusFragment;", "<init>", "()V", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final VerificationStatusFragment newInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "type");
            VerificationStatusFragment verificationStatusFragment = new VerificationStatusFragment();
            Bundle bundle = new Bundle();
            bundle.putString(VerificationActivityKt.KEY_VERIFICATION_TYPE, str);
            verificationStatusFragment.setArguments(bundle);
            return verificationStatusFragment;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusFragment$VerificationsStatusRouter;", "", "", "closeActivity", "()V", "verification_release"}, k = 1, mv = {1, 4, 2})
    public interface VerificationsStatusRouter {
        void closeActivity();
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((VerificationStatusFragment) this.b).requireActivity().onBackPressed();
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((VerificationStatusFragment) this.b).getViewModel$verification_release().refreshVerificationStatus(((VerificationStatusFragment) this.b).a());
                return Unit.INSTANCE;
            } else if (i == 2) {
                VerificationStatusViewModel.loadVerificationStatus$default(((VerificationStatusFragment) this.b).getViewModel$verification_release(), ((VerificationStatusFragment) this.b).a(), null, 2, null);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<DeepLink, Unit> {
        public final /* synthetic */ VerificationStatusFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(VerificationStatusFragment verificationStatusFragment) {
            super(1);
            this.a = verificationStatusFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
            this.a.getViewModel$verification_release().onDeepLinkClicked(deepLink2);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ VerificationStatusFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(VerificationStatusFragment verificationStatusFragment) {
            super(1);
            this.a = verificationStatusFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "url");
            this.a.getViewModel$verification_release().onUrlClicked(str2);
            return Unit.INSTANCE;
        }
    }

    public static final Function0 access$createRetryCallback(VerificationStatusFragment verificationStatusFragment, DeepLink deepLink) {
        Objects.requireNonNull(verificationStatusFragment);
        return new a2.a.a.r3.a.a(verificationStatusFragment, deepLink);
    }

    public static final /* synthetic */ VerificationStatusView access$getVerificationView$p(VerificationStatusFragment verificationStatusFragment) {
        VerificationStatusView verificationStatusView = verificationStatusFragment.d;
        if (verificationStatusView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verificationView");
        }
        return verificationStatusView;
    }

    public final String a() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(VerificationActivityKt.KEY_VERIFICATION_TYPE) : null;
        Intrinsics.checkNotNull(string);
        return string;
    }

    @NotNull
    public final Analytics getAnalytics$verification_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory$verification_release() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
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
    public final AttributedTextFormatter getTextFormatter$verification_release() {
        AttributedTextFormatter attributedTextFormatter = this.textFormatter;
        if (attributedTextFormatter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textFormatter");
        }
        return attributedTextFormatter;
    }

    @NotNull
    public final VerificationStatusViewModel getViewModel$verification_release() {
        VerificationStatusViewModel verificationStatusViewModel = this.viewModel;
        if (verificationStatusViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return verificationStatusViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String stringExtra;
        super.onActivityResult(i, i2, intent);
        if (intent != null && (stringExtra = intent.getStringExtra("result_message")) != null) {
            VerificationStatusViewModel verificationStatusViewModel = this.viewModel;
            if (verificationStatusViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            verificationStatusViewModel.loadVerificationStatus(a(), new VerificationStatusViewModel.Message(true ^ intent.getBooleanExtra("result_success", true), stringExtra, null, 4, null));
        }
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        VerificationStatusViewModel verificationStatusViewModel = this.viewModel;
        if (verificationStatusViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        VerificationStatusViewModel.loadVerificationStatus$default(verificationStatusViewModel, a(), null, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.verification_status, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…status, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        requireActivity().unregisterReceiver(this.c);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        AttributedTextFormatter attributedTextFormatter = this.textFormatter;
        if (attributedTextFormatter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textFormatter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        this.d = new VerificationStatusViewImpl(view, attributedTextFormatter, analytics2, new a(0, this), new a(1, this), new a(2, this), new b(this), new c(this));
        VerificationStatusViewModel verificationStatusViewModel = this.viewModel;
        if (verificationStatusViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        verificationStatusViewModel.getScreenState().observe(getViewLifecycleOwner(), new a2.a.a.r3.a.b(this));
        verificationStatusViewModel.getRouterAction().observe(getViewLifecycleOwner(), new a2.a.a.r3.a.c(this));
        verificationStatusViewModel.getMessage().observe(getViewLifecycleOwner(), new d(this));
        requireActivity().registerReceiver(this.c, new IntentFilter(VerificationActionActivityKt.INTENT_FILTER_ACTION_VERIFICATION_ACTION));
    }

    public final void setAnalytics$verification_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory$verification_release(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setTextFormatter$verification_release(@NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "<set-?>");
        this.textFormatter = attributedTextFormatter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        VerificationStatusComponent.Factory factory = DaggerVerificationStatusComponent.factory();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        factory.create(this, resources, (VerificationStatusDependencies) ComponentDependenciesKt.getDependencies(VerificationStatusDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        return true;
    }

    public final void setViewModel$verification_release(@NotNull VerificationStatusViewModel verificationStatusViewModel) {
        Intrinsics.checkNotNullParameter(verificationStatusViewModel, "<set-?>");
        this.viewModel = verificationStatusViewModel;
    }
}
