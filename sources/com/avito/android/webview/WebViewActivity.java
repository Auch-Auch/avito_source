package com.avito.android.webview;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Contexts;
import com.avito.android.util.Intents;
import com.avito.android.webview.WebViewPresenter;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractor;
import com.avito.android.webview.di.DaggerWebViewComponent;
import com.avito.android.webview.di.WebViewComponent;
import com.avito.android.webview.di.WebViewDependencies;
import com.facebook.share.internal.ShareConstants;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bA\u0010\fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0014¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0006H\u0014¢\u0006\u0004\b$\u0010\nR\"\u0010&\u001a\u00020%8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0000@\u0000X.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006B"}, d2 = {"Lcom/avito/android/webview/WebViewActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/webview/WebViewPresenter$Router;", "", "getContentLayoutId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onDestroy", "onBackPressed", "leaveScreen", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "openUrl", "(Landroid/net/Uri;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Landroid/content/res/AssetManager;", "getAssets", "()Landroid/content/res/AssetManager;", "outState", "onSaveInstanceState", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "intentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;", "getAnalyticsInteractor", "()Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;", "setAnalyticsInteractor", "(Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$webview_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$webview_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/webview/WebViewPresenter;", "presenter", "Lcom/avito/android/webview/WebViewPresenter;", "getPresenter", "()Lcom/avito/android/webview/WebViewPresenter;", "setPresenter", "(Lcom/avito/android/webview/WebViewPresenter;)V", "<init>", "webview_release"}, k = 1, mv = {1, 4, 2})
public final class WebViewActivity extends BaseActivity implements WebViewPresenter.Router {
    @Inject
    public Analytics analytics;
    @Inject
    public WebViewAnalyticsInteractor analyticsInteractor;
    @Inject
    public DeepLinkIntentFactory intentFactory;
    @Inject
    public WebViewPresenter presenter;

    @NotNull
    public final Analytics getAnalytics$webview_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final WebViewAnalyticsInteractor getAnalyticsInteractor() {
        WebViewAnalyticsInteractor webViewAnalyticsInteractor = this.analyticsInteractor;
        if (webViewAnalyticsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
        }
        return webViewAnalyticsInteractor;
    }

    @Override // android.content.Context, android.view.ContextThemeWrapper, android.content.ContextWrapper
    @NotNull
    public AssetManager getAssets() {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        AssetManager assets = resources.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "resources.assets");
        return assets;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.activity_webview;
    }

    @NotNull
    public final DeepLinkIntentFactory getIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory = this.intentFactory;
        if (deepLinkIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return deepLinkIntentFactory;
    }

    @NotNull
    public final WebViewPresenter getPresenter() {
        WebViewPresenter webViewPresenter = this.presenter;
        if (webViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return webViewPresenter;
    }

    @Override // com.avito.android.webview.WebViewPresenter.Router
    public void leaveScreen() {
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        WebViewPresenter webViewPresenter = this.presenter;
        if (webViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        webViewPresenter.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        View containerView = getContainerView();
        Objects.requireNonNull(containerView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) containerView;
        WebViewPresenter webViewPresenter = this.presenter;
        if (webViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        WebViewViewImpl webViewViewImpl = new WebViewViewImpl(viewGroup, webViewPresenter, analytics2);
        WebViewPresenter webViewPresenter2 = this.presenter;
        if (webViewPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        webViewPresenter2.onAttachView(webViewViewImpl);
        WebViewAnalyticsInteractor webViewAnalyticsInteractor = this.analyticsInteractor;
        if (webViewAnalyticsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
        }
        webViewAnalyticsInteractor.onRestore(bundle != null ? bundle.getBundle("key_analytics_interactor_state") : null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        WebViewPresenter webViewPresenter = this.presenter;
        if (webViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        webViewPresenter.onDetachView();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        Uri uri = (Uri) intent.getParcelableExtra("key_uri");
        WebViewPresenter webViewPresenter = this.presenter;
        if (webViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Intrinsics.checkNotNullExpressionValue(uri, ShareConstants.MEDIA_URI);
        webViewPresenter.onNewUri(uri);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        WebViewAnalyticsInteractor webViewAnalyticsInteractor = this.analyticsInteractor;
        if (webViewAnalyticsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
        }
        bundle.putBundle("key_analytics_interactor_state", webViewAnalyticsInteractor.onSave());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        WebViewPresenter webViewPresenter = this.presenter;
        if (webViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        webViewPresenter.onAttachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        WebViewPresenter webViewPresenter = this.presenter;
        if (webViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        webViewPresenter.onDetachRouter();
        super.onStop();
    }

    @Override // com.avito.android.webview.WebViewPresenter.Router
    public void openDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory = this.intentFactory;
        if (deepLinkIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Intent intent = deepLinkIntentFactory.getIntent(deepLink);
        if (intent != null) {
            startActivity(intent);
            return;
        }
        Intent putExtra = new Intent().putExtra("deep_link", deepLink);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(EXTRA_DEEP_LINK, deepLink)");
        setResult(-1, putExtra);
    }

    @Override // com.avito.android.webview.WebViewPresenter.Router
    public void openUrl(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Contexts.startActivitySafely(this, new Intent("android.intent.action.VIEW", uri));
    }

    public final void setAnalytics$webview_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAnalyticsInteractor(@NotNull WebViewAnalyticsInteractor webViewAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(webViewAnalyticsInteractor, "<set-?>");
        this.analyticsInteractor = webViewAnalyticsInteractor;
    }

    public final void setIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "<set-?>");
        this.intentFactory = deepLinkIntentFactory;
    }

    public final void setPresenter(@NotNull WebViewPresenter webViewPresenter) {
        Intrinsics.checkNotNullParameter(webViewPresenter, "<set-?>");
        this.presenter = webViewPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        Uri uri = (Uri) getIntent().getParcelableExtra("key_uri");
        boolean booleanExtra = getIntent().getBooleanExtra("key_fullscreen", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("key_with_authorization", false);
        WebViewComponent.Builder dependencies = DaggerWebViewComponent.builder().dependencies((WebViewDependencies) ComponentDependenciesKt.getDependencies(WebViewDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        Intrinsics.checkNotNullExpressionValue(uri, ShareConstants.MEDIA_URI);
        WebViewComponent.Builder withAuthorization = dependencies.withUri(uri).withFullScreen(booleanExtra).withAuthorization(booleanExtra2);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        withAuthorization.withCalledFrom(Intents.getCalledFrom(intent)).build().inject(this);
        return true;
    }
}
