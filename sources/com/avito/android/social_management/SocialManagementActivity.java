package com.avito.android.social_management;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.social.SocialActivity;
import com.avito.android.social.SocialType;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.social_management.SocialManagementPresenter;
import com.avito.android.social_management.di.DaggerSocialManagementComponent;
import com.avito.android.social_management.di.SocialManagementComponent;
import com.avito.android.social_management.di.SocialManagementDependencies;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import com.avito.android.util.Keyboards;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.io.Serializable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bL\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000e\u0010\u0007J)\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010F\u001a\u00020E8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K¨\u0006M"}, d2 = {"Lcom/avito/android/social_management/SocialManagementActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/social_management/SocialManagementPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "onBackPressed", "outState", "onSaveInstanceState", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "type", "loginSocial", "(Ljava/lang/String;)V", "", "changed", "leaveScreen", "(Z)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/social_management/SocialManagementPresenter;", "presenter", "Lcom/avito/android/social_management/SocialManagementPresenter;", "getPresenter", "()Lcom/avito/android/social_management/SocialManagementPresenter;", "setPresenter", "(Lcom/avito/android/social_management/SocialManagementPresenter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/social/SocialTypeToStringMapper;", "socialTypeToStringMapper", "Lcom/avito/android/social/SocialTypeToStringMapper;", "getSocialTypeToStringMapper", "()Lcom/avito/android/social/SocialTypeToStringMapper;", "setSocialTypeToStringMapper", "(Lcom/avito/android/social/SocialTypeToStringMapper;)V", "<init>", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public final class SocialManagementActivity extends BaseActivity implements SocialManagementPresenter.Router {
    @Inject
    public SimpleRecyclerAdapter adapter;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public SocialManagementPresenter presenter;
    @Inject
    public SocialTypeToStringMapper socialTypeToStringMapper;

    @Override // com.avito.android.social_management.SocialManagementPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivity(intent);
        }
    }

    @NotNull
    public final SimpleRecyclerAdapter getAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return simpleRecyclerAdapter;
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
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final SocialManagementPresenter getPresenter() {
        SocialManagementPresenter socialManagementPresenter = this.presenter;
        if (socialManagementPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return socialManagementPresenter;
    }

    @NotNull
    public final SocialTypeToStringMapper getSocialTypeToStringMapper() {
        SocialTypeToStringMapper socialTypeToStringMapper2 = this.socialTypeToStringMapper;
        if (socialTypeToStringMapper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socialTypeToStringMapper");
        }
        return socialTypeToStringMapper2;
    }

    @Override // com.avito.android.social_management.SocialManagementPresenter.Router
    public void leaveScreen(boolean z) {
        setResult(z ? -1 : 0);
        Intent upIntent = getUpIntent();
        if (upIntent != null) {
            startActivity(upIntent);
        }
        finish();
    }

    @Override // com.avito.android.social_management.SocialManagementPresenter.Router
    public void loginSocial(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(activityIntentFactory.createSocialLoginIntent(str), 1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        Keyboards.hideKeyboard(this);
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            Serializable serializable = null;
            String stringExtra = intent != null ? intent.getStringExtra(SocialActivity.EXTRA_SOCIAL_TOKEN) : null;
            if (intent != null) {
                serializable = intent.getSerializableExtra(SocialActivity.EXTRA_SOCIAL_TYPE);
            }
            SocialType socialType = (SocialType) serializable;
            if (stringExtra == null || socialType == null) {
                SocialManagementPresenter socialManagementPresenter = this.presenter;
                if (socialManagementPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                socialManagementPresenter.onSocialLoginError();
                return;
            }
            SocialManagementPresenter socialManagementPresenter2 = this.presenter;
            if (socialManagementPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            SocialTypeToStringMapper socialTypeToStringMapper2 = this.socialTypeToStringMapper;
            if (socialTypeToStringMapper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("socialTypeToStringMapper");
            }
            socialManagementPresenter2.onSocialLoginResult(socialTypeToStringMapper2.mapToString(socialType), stringExtra);
        } else if (i2 == 1) {
            SocialManagementPresenter socialManagementPresenter3 = this.presenter;
            if (socialManagementPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            socialManagementPresenter3.onSocialLoginError();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        SocialManagementPresenter socialManagementPresenter = this.presenter;
        if (socialManagementPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        socialManagementPresenter.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        SocialManagementComponent.Builder dependentOn = DaggerSocialManagementComponent.builder().dependentOn((SocialManagementDependencies) ComponentDependenciesKt.getDependencies(SocialManagementDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        dependentOn.withResources(resources).withActivity(this).withPresenterState(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null).build().inject(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_social_management);
        SocialManagementPresenter socialManagementPresenter = this.presenter;
        if (socialManagementPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        socialManagementPresenter.attachView(new SocialManagementViewImpl(findViewById, simpleRecyclerAdapter, analytics2));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SocialManagementPresenter socialManagementPresenter = this.presenter;
        if (socialManagementPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        socialManagementPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        SocialManagementPresenter socialManagementPresenter = this.presenter;
        if (socialManagementPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", socialManagementPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        SocialManagementPresenter socialManagementPresenter = this.presenter;
        if (socialManagementPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        socialManagementPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        SocialManagementPresenter socialManagementPresenter = this.presenter;
        if (socialManagementPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        socialManagementPresenter.detachRouter();
        super.onStop();
    }

    public final void setAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.adapter = simpleRecyclerAdapter;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPresenter(@NotNull SocialManagementPresenter socialManagementPresenter) {
        Intrinsics.checkNotNullParameter(socialManagementPresenter, "<set-?>");
        this.presenter = socialManagementPresenter;
    }

    public final void setSocialTypeToStringMapper(@NotNull SocialTypeToStringMapper socialTypeToStringMapper2) {
        Intrinsics.checkNotNullParameter(socialTypeToStringMapper2, "<set-?>");
        this.socialTypeToStringMapper = socialTypeToStringMapper2;
    }
}
