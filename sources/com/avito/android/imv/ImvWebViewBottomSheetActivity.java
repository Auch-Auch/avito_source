package com.avito.android.imv;

import a2.a.a.e1.a;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.imv.di.DaggerImvWebViewBottomSheetComponent;
import com.avito.android.imv.widget.BottomSheetWebView;
import com.avito.android.imv_webview_bottomsheet.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.android.webview.WebViewPresenter;
import com.avito.android.webview.WebViewViewImpl;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractor;
import com.avito.android.webview.di.WebViewDependencies;
import com.facebook.share.internal.ShareConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b?\u0010\u0013J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001e\u0010\u0011R\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006@"}, d2 = {"Lcom/avito/android/imv/ImvWebViewBottomSheetActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/webview/WebViewPresenter$Router;", "", "getContentLayoutId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "Landroid/content/Intent;", "intent", "", "onNewIntent", "(Landroid/content/Intent;)V", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "()V", "leaveScreen", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "openUrl", "(Landroid/net/Uri;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "outState", "onSaveInstanceState", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "intentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$imv_webview_bottomsheet_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$imv_webview_bottomsheet_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;", "getAnalyticsInteractor", "()Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;", "setAnalyticsInteractor", "(Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;)V", "Lcom/avito/android/webview/WebViewPresenter;", "presenter", "Lcom/avito/android/webview/WebViewPresenter;", "getPresenter", "()Lcom/avito/android/webview/WebViewPresenter;", "setPresenter", "(Lcom/avito/android/webview/WebViewPresenter;)V", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "k", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "dialog", "<init>", "imv-webview-bottomsheet_release"}, k = 1, mv = {1, 4, 2})
public final class ImvWebViewBottomSheetActivity extends BaseActivity implements WebViewPresenter.Router {
    @Inject
    public Analytics analytics;
    @Inject
    public WebViewAnalyticsInteractor analyticsInteractor;
    @Inject
    public DeepLinkIntentFactory intentFactory;
    public BottomSheetDialog k;
    @Inject
    public WebViewPresenter presenter;

    @NotNull
    public final Analytics getAnalytics$imv_webview_bottomsheet_release() {
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

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.activity_imv_webview_bottomsheet;
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

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        WebViewAnalyticsInteractor webViewAnalyticsInteractor = this.analyticsInteractor;
        if (webViewAnalyticsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
        }
        webViewAnalyticsInteractor.onRestore(bundle != null ? bundle.getBundle("key_analytics_interactor_state") : null);
        if (bundle == null) {
            BottomSheetWebView bottomSheetWebView = new BottomSheetWebView(this, 0, 2, null);
            View inflate = LayoutInflater.from(bottomSheetWebView.getContext()).inflate(R.layout.bottom_sheet_webview, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            bottomSheetWebView.setContentView(inflate, true);
            ViewGroup viewGroup = (ViewGroup) inflate;
            WebViewPresenter webViewPresenter = this.presenter;
            if (webViewPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            WebViewViewImpl webViewViewImpl = new WebViewViewImpl(viewGroup, webViewPresenter, analytics2);
            bottomSheetWebView.setupWebView(webViewViewImpl.getWebView());
            WebViewPresenter webViewPresenter2 = this.presenter;
            if (webViewPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            webViewPresenter2.onAttachView(webViewViewImpl);
            bottomSheetWebView.setCancelable(true);
            bottomSheetWebView.setCanceledOnTouchOutside(true);
            bottomSheetWebView.setHeaderParams(null, null, false, true);
            bottomSheetWebView.setOnDismissListener(new a(this));
            bottomSheetWebView.setPeekHeight(Views.dpToPx(this, 420));
            bottomSheetWebView.show();
            this.k = bottomSheetWebView;
            return;
        }
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BottomSheetDialog bottomSheetDialog = this.k;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.setOnDismissListener(null);
            boolean z = true;
            if (!bottomSheetDialog.isShowing()) {
                z = false;
            }
            if (z) {
                bottomSheetDialog.dismiss();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        Parcelable parcelableExtra = intent.getParcelableExtra("key_uri");
        Intrinsics.checkNotNull(parcelableExtra);
        Uri uri = (Uri) parcelableExtra;
        WebViewPresenter webViewPresenter = this.presenter;
        if (webViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
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
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(Activi…XTRA_DEEP_LINK, deepLink)");
        setResult(-1, putExtra);
    }

    @Override // com.avito.android.webview.WebViewPresenter.Router
    public void openUrl(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Contexts.startActivitySafely(this, new Intent("android.intent.action.VIEW", uri));
    }

    public final void setAnalytics$imv_webview_bottomsheet_release(@NotNull Analytics analytics2) {
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
        Parcelable parcelableExtra = getIntent().getParcelableExtra("key_uri");
        Intrinsics.checkNotNull(parcelableExtra);
        DaggerImvWebViewBottomSheetComponent.builder().dependencies((WebViewDependencies) ComponentDependenciesKt.getDependencies(WebViewDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withUri((Uri) parcelableExtra).withAuthorization(false).withCalledFrom(null).withFullScreen(false).build().inject(this);
        return true;
    }
}
