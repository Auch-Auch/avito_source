package com.avito.android.advert.badge_details;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.advert.badge_details.BadgeDetailsPresenter;
import com.avito.android.advert.badge_details.di.BadgeDetailsComponent;
import com.avito.android.advert.badge_details.di.BadgeDetailsDependencies;
import com.avito.android.advert.badge_details.di.DaggerBadgeDetailsComponent;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Bundles;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Kundle;
import com.avito.android.util.ToastsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b*\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\f\u0010\u0007J\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\tJ\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/avito/android/advert/badge_details/BadgeDetailsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/advert/badge_details/BadgeDetailsPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "outState", "onSaveInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "getContentLayoutId", "()I", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeeplink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "close", "", "message", "closeWithError", "(Ljava/lang/String;)V", "Lcom/avito/android/advert/badge_details/BadgeDetailsPresenter;", "presenter", "Lcom/avito/android/advert/badge_details/BadgeDetailsPresenter;", "getPresenter", "()Lcom/avito/android/advert/badge_details/BadgeDetailsPresenter;", "setPresenter", "(Lcom/avito/android/advert/badge_details/BadgeDetailsPresenter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "<init>", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeDetailsActivity extends BaseActivity implements BadgeDetailsPresenter.Router {
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public BadgeDetailsPresenter presenter;

    @Override // com.avito.android.advert.badge_details.BadgeDetailsPresenter.Router
    public void close() {
        finish();
    }

    @Override // com.avito.android.advert.badge_details.BadgeDetailsPresenter.Router
    public void closeWithError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intent intent = new Intent();
        intent.putExtra("message", str);
        setResult(-1, intent);
        finish();
    }

    @Override // com.avito.android.advert.badge_details.BadgeDetailsPresenter.Router
    public void followDeeplink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            try {
                startActivity(IntentsKt.makeSafeForExternalApps(intent));
            } catch (Exception unused) {
                ToastsKt.showToast$default(this, R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
            }
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return com.avito.android.advert_details.R.layout.activity_badge_details;
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
    public final BadgeDetailsPresenter getPresenter() {
        BadgeDetailsPresenter badgeDetailsPresenter = this.presenter;
        if (badgeDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return badgeDetailsPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        BadgeDetailsViewImpl badgeDetailsViewImpl = new BadgeDetailsViewImpl(getContainerView());
        BadgeDetailsPresenter badgeDetailsPresenter = this.presenter;
        if (badgeDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        badgeDetailsPresenter.attachView(badgeDetailsViewImpl);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        BadgeDetailsPresenter badgeDetailsPresenter = this.presenter;
        if (badgeDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenterState", badgeDetailsPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        BadgeDetailsPresenter badgeDetailsPresenter = this.presenter;
        if (badgeDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        badgeDetailsPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        BadgeDetailsPresenter badgeDetailsPresenter = this.presenter;
        if (badgeDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        badgeDetailsPresenter.detachRouter();
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setPresenter(@NotNull BadgeDetailsPresenter badgeDetailsPresenter) {
        Intrinsics.checkNotNullParameter(badgeDetailsPresenter, "<set-?>");
        this.presenter = badgeDetailsPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        String stringExtra;
        String stringExtra2;
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("objectId")) == null) {
            throw new RuntimeException("objectId must be set");
        }
        Intent intent2 = getIntent();
        if (intent2 == null || (stringExtra2 = intent2.getStringExtra("objectEntity")) == null) {
            throw new RuntimeException("objectEntity id must be set");
        }
        Intent intent3 = getIntent();
        if (intent3 != null) {
            int intExtra = intent3.getIntExtra("badgeId", -1);
            Kundle kundle = bundle != null ? Bundles.getKundle(bundle, "presenterState") : null;
            BadgeDetailsComponent.Factory factory = DaggerBadgeDetailsComponent.factory();
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            factory.create(intExtra, stringExtra, stringExtra2, kundle, resources, (BadgeDetailsDependencies) ComponentDependenciesKt.getDependencies(BadgeDetailsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).inject(this);
            return true;
        }
        throw new RuntimeException("badge id must be set");
    }
}
