package com.avito.android.social;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.social.SignInManager;
import com.avito.android.social.SocialActivityPresenter;
import com.avito.android.social.di.DaggerSocialActivityComponent;
import com.avito.android.social.di.SocialActivityDependencies;
import java.io.Serializable;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0007¢\u0006\u0004\b,\u0010\u000bJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ3\u0010#\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/avito/android/social/SocialActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/avito/android/social/SocialActivityPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onDestroy", "()V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/social/SignInManager;", "signInManager", "Lkotlin/Function1;", "Lcom/avito/android/social/SignInManager$Result;", "callback", "login", "(Lcom/avito/android/social/SignInManager;Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/social/SocialType;", "type", "leaveScreen", "(Lcom/avito/android/social/SocialType;)V", "leaveScreenWithError", "", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "email", "user", "leaveScreenWithSuccess", "(Lcom/avito/android/social/SocialType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/social/SocialActivityPresenter;", "presenter", "Lcom/avito/android/social/SocialActivityPresenter;", "getPresenter", "()Lcom/avito/android/social/SocialActivityPresenter;", "setPresenter", "(Lcom/avito/android/social/SocialActivityPresenter;)V", "<init>", "Companion", "social_release"}, k = 1, mv = {1, 4, 2})
public final class SocialActivity extends AppCompatActivity implements SocialActivityPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String EXTRA_SOCIAL_EMAIL = "extra_social_email";
    @NotNull
    public static final String EXTRA_SOCIAL_TOKEN = "extra_social_token";
    @NotNull
    public static final String EXTRA_SOCIAL_TYPE = "extra_social_type";
    @NotNull
    public static final String EXTRA_SOCIAL_USER = "extra_social_user";
    public static final int RESULT_ERROR = 1;
    @NotNull
    public static final String SOCIAL_TYPE_PARAM = "social_type";
    @Inject
    public SocialActivityPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/avito/android/social/SocialActivity$Companion;", "", "", "EXTRA_SOCIAL_EMAIL", "Ljava/lang/String;", "EXTRA_SOCIAL_TOKEN", "EXTRA_SOCIAL_TYPE", "EXTRA_SOCIAL_USER", "", "RESULT_ERROR", "I", "SOCIAL_TYPE_PARAM", "<init>", "()V", "social_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @NotNull
    public final SocialActivityPresenter getPresenter() {
        SocialActivityPresenter socialActivityPresenter = this.presenter;
        if (socialActivityPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return socialActivityPresenter;
    }

    @Override // com.avito.android.social.SocialActivityPresenter.Router
    public void leaveScreen(@NotNull SocialType socialType) {
        Intrinsics.checkNotNullParameter(socialType, "type");
        Intent putExtra = new Intent().putExtra(EXTRA_SOCIAL_TYPE, socialType);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(EXTRA_SOCIAL_TYPE, type)");
        setResult(0, putExtra);
        finish();
    }

    @Override // com.avito.android.social.SocialActivityPresenter.Router
    public void leaveScreenWithError(@NotNull SocialType socialType) {
        Intrinsics.checkNotNullParameter(socialType, "type");
        Intent putExtra = new Intent().putExtra(EXTRA_SOCIAL_TYPE, socialType);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(EXTRA_SOCIAL_TYPE, type)");
        setResult(1, putExtra);
        finish();
    }

    @Override // com.avito.android.social.SocialActivityPresenter.Router
    public void leaveScreenWithSuccess(@NotNull SocialType socialType, @NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(socialType, "type");
        Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        Intent putExtra = new Intent().putExtra(EXTRA_SOCIAL_EMAIL, str2).putExtra(EXTRA_SOCIAL_TOKEN, str).putExtra(EXTRA_SOCIAL_TYPE, socialType).putExtra(EXTRA_SOCIAL_USER, str3);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent()\n            .pu…(EXTRA_SOCIAL_USER, user)");
        setResult(-1, putExtra);
        finish();
    }

    @Override // com.avito.android.social.SocialActivityPresenter.Router
    public void login(@NotNull SignInManager signInManager, @NotNull Function1<? super SignInManager.Result, Unit> function1) {
        Intrinsics.checkNotNullParameter(signInManager, "signInManager");
        Intrinsics.checkNotNullParameter(function1, "callback");
        signInManager.login(this, function1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        SocialActivityPresenter socialActivityPresenter = this.presenter;
        if (socialActivityPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        if (!socialActivityPresenter.handleActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerSocialActivityComponent.builder().dependencies((SocialActivityDependencies) ComponentDependenciesKt.getDependencies(SocialActivityDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).with(bundle != null ? bundle.getBundle("presenter_state") : null).build().inject(this);
        SocialActivityPresenter socialActivityPresenter = this.presenter;
        if (socialActivityPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        socialActivityPresenter.attachRouter(this);
        Serializable serializableExtra = getIntent().getSerializableExtra(SOCIAL_TYPE_PARAM);
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.avito.android.social.SocialType");
        SocialType socialType = (SocialType) serializableExtra;
        String stringExtra = getIntent().getStringExtra("social_action");
        if (!(bundle != null ? bundle.containsKey("presenter_state") : false) && stringExtra != null) {
            int hashCode = stringExtra.hashCode();
            if (hashCode != -1097329270) {
                if (hashCode == 103149417 && stringExtra.equals("login")) {
                    SocialActivityPresenter socialActivityPresenter2 = this.presenter;
                    if (socialActivityPresenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    socialActivityPresenter2.login(socialType);
                }
            } else if (stringExtra.equals("logout")) {
                SocialActivityPresenter socialActivityPresenter3 = this.presenter;
                if (socialActivityPresenter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                socialActivityPresenter3.logout(socialType);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SocialActivityPresenter socialActivityPresenter = this.presenter;
        if (socialActivityPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        socialActivityPresenter.detachRouter();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        SocialActivityPresenter socialActivityPresenter = this.presenter;
        if (socialActivityPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putBundle("presenter_state", socialActivityPresenter.saveState());
        super.onSaveInstanceState(bundle);
    }

    public final void setPresenter(@NotNull SocialActivityPresenter socialActivityPresenter) {
        Intrinsics.checkNotNullParameter(socialActivityPresenter, "<set-?>");
        this.presenter = socialActivityPresenter;
    }
}
