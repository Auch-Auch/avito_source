package com.avito.android.deep_linking;

import a2.a.a.j0.a;
import a2.a.a.j0.b;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.di.AppLinkDependencies;
import com.avito.android.deep_linking.di.DaggerAppLinkComponent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.ui_components.R;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.ToastsKt;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b2\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\tR\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/avito/android/deep_linking/AppLinkActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/avito/android/deep_linking/AppLinkRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)Z", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "openUri", "(Landroid/net/Uri;)V", "close", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/deep_linking/AppLinkPresenter;", "presenter", "Lcom/avito/android/deep_linking/AppLinkPresenter;", "getPresenter", "()Lcom/avito/android/deep_linking/AppLinkPresenter;", "setPresenter", "(Lcom/avito/android/deep_linking/AppLinkPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
public final class AppLinkActivity extends AppCompatActivity implements AppLinkRouter {
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public AppLinkPresenter presenter;

    public static final void access$initializePresenterParams(AppLinkActivity appLinkActivity, Uri uri, Uri uri2) {
        AppLinkPresenter appLinkPresenter = appLinkActivity.presenter;
        if (appLinkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        appLinkPresenter.setDeepLinkUriParams(uri, uri2);
        View findViewById = appLinkActivity.findViewById(16908290);
        AppLinkPresenter appLinkPresenter2 = appLinkActivity.presenter;
        if (appLinkPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Analytics analytics2 = appLinkActivity.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        Intrinsics.checkNotNullExpressionValue(findViewById, "container");
        appLinkPresenter2.attachView(new AppLinkViewImpl(analytics2, findViewById));
        AppLinkPresenter appLinkPresenter3 = appLinkActivity.presenter;
        if (appLinkPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        appLinkPresenter3.attachRouter(appLinkActivity);
    }

    @Override // com.avito.android.deep_linking.AppLinkRouter
    public void close() {
        finish();
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
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
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
    public final AppLinkPresenter getPresenter() {
        AppLinkPresenter appLinkPresenter = this.presenter;
        if (appLinkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return appLinkPresenter;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_link);
        DaggerAppLinkComponent.builder().dependencies((AppLinkDependencies) ComponentDependenciesKt.getDependencies(AppLinkDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).locationDependencies((LocationDependencies) ComponentDependenciesKt.getDependencies(LocationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this);
        FirebaseDynamicLinks.getInstance().getDynamicLink(getIntent()).addOnCompleteListener(new a(this)).addOnFailureListener(new b(this));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AppLinkPresenter appLinkPresenter = this.presenter;
        if (appLinkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        appLinkPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        AppLinkPresenter appLinkPresenter = this.presenter;
        if (appLinkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        appLinkPresenter.attachRouter(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        AppLinkPresenter appLinkPresenter = this.presenter;
        if (appLinkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        appLinkPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.deep_linking.AppLinkRouter
    public boolean openDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent == null) {
            return false;
        }
        startActivity(intent);
        return true;
    }

    @Override // com.avito.android.deep_linking.AppLinkRouter
    public void openUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        List<Intent> externalIntentsForUrl = implicitIntentFactory2.getExternalIntentsForUrl(uri);
        int size = externalIntentsForUrl.size();
        if (size == 0) {
            ToastsKt.showToast$default(this, R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
        } else if (size != 1) {
            String string = getResources().getString(R.string.open_with);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.open_with)");
            List<? extends Intent> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) externalIntentsForUrl);
            Intent intent = (Intent) mutableList.remove(0);
            ImplicitIntentFactory implicitIntentFactory3 = this.implicitIntentFactory;
            if (implicitIntentFactory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
            }
            startActivity(implicitIntentFactory3.chooserIntent(string, intent, mutableList));
        } else {
            startActivity((Intent) CollectionsKt___CollectionsKt.first((List<? extends Object>) externalIntentsForUrl));
        }
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setPresenter(@NotNull AppLinkPresenter appLinkPresenter) {
        Intrinsics.checkNotNullParameter(appLinkPresenter, "<set-?>");
        this.presenter = appLinkPresenter;
    }
}
