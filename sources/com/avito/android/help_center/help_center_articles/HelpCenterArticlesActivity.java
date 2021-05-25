package com.avito.android.help_center.help_center_articles;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.help_center.R;
import com.avito.android.help_center.help_center_articles.HelpCenterArticlesPresenter;
import com.avito.android.help_center.help_center_articles.di.DaggerHelpCenterArticlesComponent;
import com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesComponent;
import com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesDependencies;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.ToastsKt;
import com.facebook.share.internal.ShareConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b'\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\tJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "onBackPressed", "leaveScreen", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "openUriViewIntent", "(Landroid/net/Uri;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesPresenter;", "presenter", "Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesPresenter;", "getPresenter", "()Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesPresenter;", "setPresenter", "(Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "help-center_release"}, k = 1, mv = {1, 4, 2})
public final class HelpCenterArticlesActivity extends BaseActivity implements HelpCenterArticlesPresenter.Router {
    @Inject
    public Analytics analytics;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public HelpCenterArticlesPresenter presenter;

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
    public final HelpCenterArticlesPresenter getPresenter() {
        HelpCenterArticlesPresenter helpCenterArticlesPresenter = this.presenter;
        if (helpCenterArticlesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return helpCenterArticlesPresenter;
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesPresenter.Router
    public void leaveScreen() {
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        HelpCenterArticlesPresenter helpCenterArticlesPresenter = this.presenter;
        if (helpCenterArticlesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        if (!helpCenterArticlesPresenter.handleBack()) {
            super.onBackPressed();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.help_center_articles_fragment);
        String stringExtra = getIntent().getStringExtra("key_articleId");
        String stringExtra2 = getIntent().getStringExtra("key_theme");
        String stringExtra3 = getIntent().getStringExtra("key_advertisement_id");
        String stringExtra4 = getIntent().getStringExtra("key_context_id");
        HelpCenterArticlesComponent.Builder dependencies = DaggerHelpCenterArticlesComponent.builder().dependencies((HelpCenterArticlesDependencies) ComponentDependenciesKt.getDependencies(HelpCenterArticlesDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        Intrinsics.checkNotNullExpressionValue(stringExtra, "articleId");
        dependencies.articleId(stringExtra).theme(stringExtra2).advertisementId(stringExtra3).contextId(stringExtra4).build().inject(this);
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(viewGroup, "contentView");
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        HelpCenterArticlesViewImpl helpCenterArticlesViewImpl = new HelpCenterArticlesViewImpl(viewGroup, analytics2);
        HelpCenterArticlesPresenter helpCenterArticlesPresenter = this.presenter;
        if (helpCenterArticlesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        helpCenterArticlesPresenter.attachView(helpCenterArticlesViewImpl);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        HelpCenterArticlesPresenter helpCenterArticlesPresenter = this.presenter;
        if (helpCenterArticlesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        helpCenterArticlesPresenter.detachView();
        super.onDestroy();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        HelpCenterArticlesPresenter helpCenterArticlesPresenter = this.presenter;
        if (helpCenterArticlesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        helpCenterArticlesPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        HelpCenterArticlesPresenter helpCenterArticlesPresenter = this.presenter;
        if (helpCenterArticlesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        helpCenterArticlesPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesPresenter.Router
    public void openUriViewIntent(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        try {
            startActivity(IntentsKt.makeSafeForExternalApps(implicitIntentFactory2.uriIntent(uri)));
        } catch (Exception unused) {
            ToastsKt.showToast$default(this, com.avito.android.ui_components.R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
        }
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setPresenter(@NotNull HelpCenterArticlesPresenter helpCenterArticlesPresenter) {
        Intrinsics.checkNotNullParameter(helpCenterArticlesPresenter, "<set-?>");
        this.presenter = helpCenterArticlesPresenter;
    }
}
