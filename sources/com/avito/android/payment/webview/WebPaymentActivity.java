package com.avito.android.payment.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegate;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.payment.R;
import com.avito.android.payment.WebPaymentResourceProvider;
import com.avito.android.payment.WebPaymentResourceProviderImpl;
import com.avito.android.payment.di.component.DaggerWebPaymentComponent;
import com.avito.android.payment.di.component.PaymentDependencies;
import com.avito.android.payment.di.component.WebPaymentComponent;
import com.avito.android.payment.di.module.WebPaymentModule;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.payment.webview.WebPaymentResult;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui.view.PowerWebViewWrapperImpl;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Keyboards;
import com.yatatsu.powerwebview.PowerWebView;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b6\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\bR\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0019\u00105\u001a\u0002008\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/avito/android/payment/webview/WebPaymentActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "getContentLayoutId", "()I", "setUpCustomToolbar", "()Z", "onDestroy", "onBackPressed", "Lcom/avito/android/payment/webview/WebPaymentPresenter;", "presenter", "Lcom/avito/android/payment/webview/WebPaymentPresenter;", "getPresenter", "()Lcom/avito/android/payment/webview/WebPaymentPresenter;", "setPresenter", "(Lcom/avito/android/payment/webview/WebPaymentPresenter;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/payment/webview/WebViewStatePresenter;", "webViewPresenterState", "Lcom/avito/android/payment/webview/WebViewStatePresenter;", "getWebViewPresenterState", "()Lcom/avito/android/payment/webview/WebViewStatePresenter;", "setWebViewPresenterState", "(Lcom/avito/android/payment/webview/WebViewStatePresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$payment_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$payment_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/payment/webview/WebPaymentRouter;", "k", "Lcom/avito/android/payment/webview/WebPaymentRouter;", "getRouter", "()Lcom/avito/android/payment/webview/WebPaymentRouter;", "router", "<init>", "IntentFactory", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class WebPaymentActivity extends BaseActivity {
    @Inject
    public Analytics analytics;
    @Inject
    public DialogRouter dialogRouter;
    @NotNull
    public final WebPaymentRouter k = new WebPaymentRouter(this) { // from class: com.avito.android.payment.webview.WebPaymentActivity$router$1
        public final /* synthetic */ WebPaymentActivity a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        {
            this.a = r1;
        }

        @Override // com.avito.android.payment.webview.WebPaymentRouter
        public void closeScreenWithResult(@NotNull WebPaymentResult webPaymentResult) {
            Intrinsics.checkNotNullParameter(webPaymentResult, "result");
            if (webPaymentResult instanceof WebPaymentResult.Cancelled) {
                this.a.setResult(0);
            } else if (webPaymentResult instanceof WebPaymentResult.Error) {
                this.a.setResult(0);
            } else if (webPaymentResult instanceof WebPaymentResult.Finished) {
                Intent intent = new Intent();
                intent.putExtra(PaymentProcessingConstants.EXTRA_FINAL_DEEPLINK, ((WebPaymentResult.Finished) webPaymentResult).getDeeplink());
                this.a.setResult(-1, intent);
            }
            this.a.finish();
        }
    };
    @Inject
    public WebPaymentPresenter presenter;
    @Inject
    public WebViewStatePresenter webViewPresenterState;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/payment/webview/WebPaymentActivity$IntentFactory;", "", "Landroid/content/Context;", "context", "", "startUrl", "Lcom/avito/android/payment/WebPaymentResourceProviderImpl;", "resourceProvider", "Landroid/content/Intent;", "create", "(Landroid/content/Context;Ljava/lang/String;Lcom/avito/android/payment/WebPaymentResourceProviderImpl;)Landroid/content/Intent;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class IntentFactory {
        public static /* synthetic */ Intent create$default(IntentFactory intentFactory, Context context, String str, WebPaymentResourceProviderImpl webPaymentResourceProviderImpl, int i, Object obj) {
            if ((i & 4) != 0) {
                webPaymentResourceProviderImpl = null;
            }
            return intentFactory.create(context, str, webPaymentResourceProviderImpl);
        }

        @NotNull
        public final Intent create(@NotNull Context context, @NotNull String str, @Nullable WebPaymentResourceProviderImpl webPaymentResourceProviderImpl) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "startUrl");
            Intent intent = new Intent(context, WebPaymentActivity.class);
            intent.putExtra("web_payment_start_url_extra", str);
            if (webPaymentResourceProviderImpl != null) {
                intent.putExtra("web_payment_resource_provider_extra", webPaymentResourceProviderImpl);
            }
            return intent;
        }
    }

    @NotNull
    public final Analytics getAnalytics$payment_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.web_payment_layout;
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
    public final WebPaymentPresenter getPresenter() {
        WebPaymentPresenter webPaymentPresenter = this.presenter;
        if (webPaymentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return webPaymentPresenter;
    }

    @NotNull
    public final WebPaymentRouter getRouter() {
        return this.k;
    }

    @NotNull
    public final WebViewStatePresenter getWebViewPresenterState() {
        WebViewStatePresenter webViewStatePresenter = this.webViewPresenterState;
        if (webViewStatePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webViewPresenterState");
        }
        return webViewStatePresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        WebPaymentPresenter webPaymentPresenter = this.presenter;
        if (webPaymentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        if (!webPaymentPresenter.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        if (bundle == null) {
            AppCompatDelegate delegate = getDelegate();
            Intrinsics.checkNotNullExpressionValue(delegate, "delegate");
            delegate.setLocalNightMode(1);
        }
        super.onCreate(bundle);
        setResult(0);
        View containerView = getContainerView();
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        WebPaymentResourceProvider webPaymentResourceProvider = (WebPaymentResourceProvider) getIntent().getParcelableExtra("web_payment_resource_provider_extra");
        if (webPaymentResourceProvider == null) {
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            webPaymentResourceProvider = new DefaultWebPaymentResourceProvider(resources);
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        WebPaymentViewImpl webPaymentViewImpl = new WebPaymentViewImpl(containerView, dialogRouter2, webPaymentResourceProvider, analytics2);
        WebViewStatePresenter webViewStatePresenter = this.webViewPresenterState;
        if (webViewStatePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webViewPresenterState");
        }
        View findViewById = getContainerView().findViewById(R.id.web_payment_webview);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.yatatsu.powerwebview.PowerWebView");
        webViewStatePresenter.attachView(new PowerWebViewWrapperImpl((PowerWebView) findViewById));
        WebPaymentPresenter webPaymentPresenter = this.presenter;
        if (webPaymentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        webPaymentPresenter.attachView(webPaymentViewImpl);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        WebPaymentPresenter webPaymentPresenter = this.presenter;
        if (webPaymentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        webPaymentPresenter.detachView();
        WebPaymentPresenter webPaymentPresenter2 = this.presenter;
        if (webPaymentPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        webPaymentPresenter2.dispose();
        WebViewStatePresenter webViewStatePresenter = this.webViewPresenterState;
        if (webViewStatePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webViewPresenterState");
        }
        webViewStatePresenter.detachView();
        Keyboards.hideKeyboard(this);
        super.onDestroy();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        WebPaymentPresenter webPaymentPresenter = this.presenter;
        if (webPaymentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        webPaymentPresenter.attachRouter(this.k);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        WebPaymentPresenter webPaymentPresenter = this.presenter;
        if (webPaymentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        webPaymentPresenter.detachRouter();
        super.onStop();
    }

    public final void setAnalytics$payment_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setPresenter(@NotNull WebPaymentPresenter webPaymentPresenter) {
        Intrinsics.checkNotNullParameter(webPaymentPresenter, "<set-?>");
        this.presenter = webPaymentPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        WebPaymentComponent.Builder builder = DaggerWebPaymentComponent.builder();
        String stringExtra = getIntent().getStringExtra("web_payment_start_url_extra");
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(EXTRA_START_URL)");
        builder.webPaymentModule(new WebPaymentModule(stringExtra, bundle)).paymentDependencies((PaymentDependencies) ComponentDependenciesKt.getDependencies(PaymentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withActivity(this).build().inject(this);
        return true;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpCustomToolbar() {
        return true;
    }

    public final void setWebViewPresenterState(@NotNull WebViewStatePresenter webViewStatePresenter) {
        Intrinsics.checkNotNullParameter(webViewStatePresenter, "<set-?>");
        this.webViewPresenterState = webViewStatePresenter;
    }
}
