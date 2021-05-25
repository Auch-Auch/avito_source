package com.avito.android.autodeal_details;

import a2.a.a.n.e;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.autodeal_details.di.AutoDealDetailsDependencies;
import com.avito.android.autodeal_details.di.DaggerAutoDealDetailsComponent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui.view.PowerWebViewWrapperImpl;
import com.avito.android.ui_components.R;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.google.android.material.snackbar.Snackbar;
import com.yatatsu.powerwebview.PowerWebView;
import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bJ\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bR%\u0010\u0011\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001d\u001a\u00020\u00198B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001d\u00104\u001a\u0002008B@\u0002X\u0002¢\u0006\f\n\u0004\b1\u0010\u000e\u001a\u0004\b2\u00103R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006K"}, d2 = {"Lcom/avito/android/autodeal_details/AutoDealDetailsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onBackPressed", "Landroid/view/View;", "kotlin.jvm.PlatformType", "k", "Lkotlin/Lazy;", "getContainer", "()Landroid/view/View;", "container", "Lcom/avito/android/autodeal_details/AutoDealDetailsViewModel;", "viewModel", "Lcom/avito/android/autodeal_details/AutoDealDetailsViewModel;", "getViewModel", "()Lcom/avito/android/autodeal_details/AutoDealDetailsViewModel;", "setViewModel", "(Lcom/avito/android/autodeal_details/AutoDealDetailsViewModel;)V", "Lcom/avito/android/ui/view/PowerWebViewWrapperImpl;", "l", AuthSource.SEND_ABUSE, "()Lcom/avito/android/ui/view/PowerWebViewWrapperImpl;", "webView", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory;)V", "Lio/reactivex/disposables/Disposable;", "n", "Lio/reactivex/disposables/Disposable;", "webViewStateDisposable", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.OPEN_CHANNEL_LIST, "getProgressOverlay", "()Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/autodeal_details/AutoDealDetailsJSInterface;", "jsInterface", "Lcom/avito/android/autodeal_details/AutoDealDetailsJSInterface;", "getJsInterface", "()Lcom/avito/android/autodeal_details/AutoDealDetailsJSInterface;", "setJsInterface", "(Lcom/avito/android/autodeal_details/AutoDealDetailsJSInterface;)V", "Lcom/avito/android/autodeal_details/AutoDealDetailsInterceptor;", "autoDealDetailsInterceptor", "Lcom/avito/android/autodeal_details/AutoDealDetailsInterceptor;", "getAutoDealDetailsInterceptor", "()Lcom/avito/android/autodeal_details/AutoDealDetailsInterceptor;", "setAutoDealDetailsInterceptor", "(Lcom/avito/android/autodeal_details/AutoDealDetailsInterceptor;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "autodeal-details_release"}, k = 1, mv = {1, 4, 2})
public final class AutoDealDetailsActivity extends BaseActivity {
    @Inject
    public Analytics analytics;
    @Inject
    public AutoDealDetailsInterceptor autoDealDetailsInterceptor;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public AutoDealDetailsJSInterface jsInterface;
    public final Lazy k = t6.c.lazy(new a(this));
    public final Lazy l = t6.c.lazy(new d(this));
    public final Lazy m = t6.c.lazy(new c(this));
    public Disposable n;
    @Inject
    public SchedulersFactory schedulers;
    @Inject
    public AutoDealDetailsViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PowerWebViewStateChangeEvent.State.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[3] = 3;
        }
    }

    public static final class a extends Lambda implements Function0<View> {
        public final /* synthetic */ AutoDealDetailsActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AutoDealDetailsActivity autoDealDetailsActivity) {
            super(0);
            this.a = autoDealDetailsActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return this.a.findViewById(R.id.container);
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AutoDealDetailsActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AutoDealDetailsActivity autoDealDetailsActivity) {
            super(0);
            this.a = autoDealDetailsActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a().reloadPage();
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<ProgressOverlay> {
        public final /* synthetic */ AutoDealDetailsActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AutoDealDetailsActivity autoDealDetailsActivity) {
            super(0);
            this.a = autoDealDetailsActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ProgressOverlay invoke() {
            View findViewById = this.a.findViewById(R.id.container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.container)");
            return new ProgressOverlay((ViewGroup) findViewById, R.id.web_view, this.a.getAnalytics(), false, 0, 24, null);
        }
    }

    public static final class d extends Lambda implements Function0<PowerWebViewWrapperImpl> {
        public final /* synthetic */ AutoDealDetailsActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(AutoDealDetailsActivity autoDealDetailsActivity) {
            super(0);
            this.a = autoDealDetailsActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public PowerWebViewWrapperImpl invoke() {
            View findViewById = this.a.findViewById(R.id.web_view);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.web_view)");
            return new PowerWebViewWrapperImpl((PowerWebView) findViewById);
        }
    }

    public static final ProgressOverlay access$getProgressOverlay$p(AutoDealDetailsActivity autoDealDetailsActivity) {
        return (ProgressOverlay) autoDealDetailsActivity.m.getValue();
    }

    public static final void access$openImplicitIntent(AutoDealDetailsActivity autoDealDetailsActivity, Uri uri) {
        ImplicitIntentFactory implicitIntentFactory2 = autoDealDetailsActivity.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        try {
            autoDealDetailsActivity.startActivity(IntentsKt.makeSafeForExternalApps(implicitIntentFactory2.uriIntent(uri)));
        } catch (Exception unused) {
            String string = autoDealDetailsActivity.getString(R.string.no_application_installed_to_perform_this_action);
            Intrinsics.checkNotNullExpressionValue(string, "getString(ui_R.string.no…d_to_perform_this_action)");
            access$showToast(autoDealDetailsActivity, string);
        }
    }

    public static final Snackbar access$showToast(AutoDealDetailsActivity autoDealDetailsActivity, String str) {
        View view = (View) autoDealDetailsActivity.k.getValue();
        if (view != null) {
            return Views.showSnackBar$default(view, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
        }
        return null;
    }

    public final PowerWebViewWrapperImpl a() {
        return (PowerWebViewWrapperImpl) this.l.getValue();
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
    public final AutoDealDetailsInterceptor getAutoDealDetailsInterceptor() {
        AutoDealDetailsInterceptor autoDealDetailsInterceptor2 = this.autoDealDetailsInterceptor;
        if (autoDealDetailsInterceptor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoDealDetailsInterceptor");
        }
        return autoDealDetailsInterceptor2;
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
    public final AutoDealDetailsJSInterface getJsInterface() {
        AutoDealDetailsJSInterface autoDealDetailsJSInterface = this.jsInterface;
        if (autoDealDetailsJSInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jsInterface");
        }
        return autoDealDetailsJSInterface;
    }

    @NotNull
    public final SchedulersFactory getSchedulers() {
        SchedulersFactory schedulersFactory = this.schedulers;
        if (schedulersFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory;
    }

    @NotNull
    public final AutoDealDetailsViewModel getViewModel() {
        AutoDealDetailsViewModel autoDealDetailsViewModel = this.viewModel;
        if (autoDealDetailsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return autoDealDetailsViewModel;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!a().goBack()) {
            super.onBackPressed();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.auto_deal_details);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Bundle extras = intent.getExtras();
        Intrinsics.checkNotNull(extras);
        String string = extras.getString("key_url");
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "intent.extras!!.getString(KEY_URL)!!");
        DaggerAutoDealDetailsComponent.builder().dependentOn((AutoDealDetailsDependencies) ComponentDependenciesKt.getDependencies(AutoDealDetailsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withFragmentActivity(this).withUrl(string).build().inject(this);
        AutoDealDetailsViewModel autoDealDetailsViewModel = this.viewModel;
        if (autoDealDetailsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        autoDealDetailsViewModel.getUrlChanges().observe(this, new a2.a.a.n.a(this));
        AutoDealDetailsViewModel autoDealDetailsViewModel2 = this.viewModel;
        if (autoDealDetailsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        autoDealDetailsViewModel2.getWebViewAction().observe(this, new a2.a.a.n.b(this));
        ((ProgressOverlay) this.m.getValue()).setOnRefreshListener(new b(this));
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        PowerWebViewWrapperImpl a3 = a();
        AutoDealDetailsJSInterface autoDealDetailsJSInterface = this.jsInterface;
        if (autoDealDetailsJSInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jsInterface");
        }
        a3.addJavascriptInterface(autoDealDetailsJSInterface, "android");
        PowerWebViewWrapperImpl a4 = a();
        AutoDealDetailsInterceptor autoDealDetailsInterceptor2 = this.autoDealDetailsInterceptor;
        if (autoDealDetailsInterceptor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoDealDetailsInterceptor");
        }
        autoDealDetailsInterceptor2.setOpenThirdPartyUriCallBack(new a2.a.a.n.c(this));
        a4.addInterceptor(autoDealDetailsInterceptor2);
        Observable v2 = InteropKt.toV2(a().getStateChangeEvents());
        SchedulersFactory schedulersFactory = this.schedulers;
        if (schedulersFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        this.n = v2.observeOn(schedulersFactory.mainThread()).subscribe(new a2.a.a.n.d(this), new e(this));
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        a().removeJavascriptInterface("android");
        PowerWebViewWrapperImpl a3 = a();
        AutoDealDetailsInterceptor autoDealDetailsInterceptor2 = this.autoDealDetailsInterceptor;
        if (autoDealDetailsInterceptor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoDealDetailsInterceptor");
        }
        a3.removeInterceptor(autoDealDetailsInterceptor2);
        Disposable disposable = this.n;
        if (disposable != null) {
            disposable.dispose();
        }
        this.n = null;
        super.onStop();
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAutoDealDetailsInterceptor(@NotNull AutoDealDetailsInterceptor autoDealDetailsInterceptor2) {
        Intrinsics.checkNotNullParameter(autoDealDetailsInterceptor2, "<set-?>");
        this.autoDealDetailsInterceptor = autoDealDetailsInterceptor2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setJsInterface(@NotNull AutoDealDetailsJSInterface autoDealDetailsJSInterface) {
        Intrinsics.checkNotNullParameter(autoDealDetailsJSInterface, "<set-?>");
        this.jsInterface = autoDealDetailsJSInterface;
    }

    public final void setSchedulers(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "<set-?>");
        this.schedulers = schedulersFactory;
    }

    public final void setViewModel(@NotNull AutoDealDetailsViewModel autoDealDetailsViewModel) {
        Intrinsics.checkNotNullParameter(autoDealDetailsViewModel, "<set-?>");
        this.viewModel = autoDealDetailsViewModel;
    }
}
