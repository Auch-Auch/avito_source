package com.avito.android.authorization.phone_proving;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.avito.android.authorization.R;
import com.avito.android.authorization.phone_proving.PhoneProvingPresenter;
import com.avito.android.authorization.phone_proving.di.DaggerPhoneProvingComponent;
import com.avito.android.authorization.phone_proving.di.PhoneProvingComponent;
import com.avito.android.authorization.phone_proving.di.PhoneProvingDependencies;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b%\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/avito/android/authorization/phone_proving/PhoneProvingActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/authorization/phone_proving/PhoneProvingPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "outState", "onSaveInstanceState", "onBackPressed", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "success", "leaveScreen", "(Z)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/authorization/phone_proving/PhoneProvingPresenter;", "presenter", "Lcom/avito/android/authorization/phone_proving/PhoneProvingPresenter;", "getPresenter", "()Lcom/avito/android/authorization/phone_proving/PhoneProvingPresenter;", "setPresenter", "(Lcom/avito/android/authorization/phone_proving/PhoneProvingPresenter;)V", "<init>", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneProvingActivity extends BaseActivity implements PhoneProvingPresenter.Router {
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public PhoneProvingPresenter presenter;

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingPresenter.Router
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
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final PhoneProvingPresenter getPresenter() {
        PhoneProvingPresenter phoneProvingPresenter = this.presenter;
        if (phoneProvingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return phoneProvingPresenter;
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingPresenter.Router
    public void leaveScreen(boolean z) {
        setResult(z ? -1 : 0);
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PhoneProvingPresenter phoneProvingPresenter = this.presenter;
        if (phoneProvingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        phoneProvingPresenter.trackOnScreenClosed();
        super.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        String stringExtra = intent.getStringExtra("challenge_id");
        if (stringExtra != null) {
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "intent");
            String stringExtra2 = intent2.getStringExtra("phone_part");
            if (stringExtra2 != null) {
                Intent intent3 = getIntent();
                Intrinsics.checkNotNullExpressionValue(intent3, "intent");
                String stringExtra3 = intent3.getStringExtra("input_hint");
                if (stringExtra3 == null) {
                    stringExtra3 = "-- --";
                }
                Intent intent4 = getIntent();
                Intrinsics.checkNotNullExpressionValue(intent4, "intent");
                boolean booleanExtra = intent4.getBooleanExtra("is_opened_from_phone_list", false);
                PhoneProvingComponent.Builder withActivity = DaggerPhoneProvingComponent.builder().dependentOn((PhoneProvingDependencies) ComponentDependenciesKt.getDependencies(PhoneProvingDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withActivity(this);
                Resources resources = getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                withActivity.withResources(resources).withPresenterState(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null).withChallengeId(stringExtra).withPhonePart(stringExtra2).withInputHint(stringExtra3).withIsOpenedFromPhoneListFlag(booleanExtra).build().inject(this);
                super.onCreate(bundle);
                setContentView(R.layout.phone_proving);
                PhoneProvingPresenter phoneProvingPresenter = this.presenter;
                if (phoneProvingPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                View findViewById = findViewById(16908290);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
                phoneProvingPresenter.attachView(new PhoneProvingViewImpl(findViewById));
                return;
            }
            throw new IllegalArgumentException("phone_part must be specified");
        }
        throw new IllegalArgumentException("challenge_id must be specified");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        PhoneProvingPresenter phoneProvingPresenter = this.presenter;
        if (phoneProvingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        phoneProvingPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        PhoneProvingPresenter phoneProvingPresenter = this.presenter;
        if (phoneProvingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", phoneProvingPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        PhoneProvingPresenter phoneProvingPresenter = this.presenter;
        if (phoneProvingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        phoneProvingPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        PhoneProvingPresenter phoneProvingPresenter = this.presenter;
        if (phoneProvingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        phoneProvingPresenter.detachRouter();
        super.onStop();
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setPresenter(@NotNull PhoneProvingPresenter phoneProvingPresenter) {
        Intrinsics.checkNotNullParameter(phoneProvingPresenter, "<set-?>");
        this.presenter = phoneProvingPresenter;
    }
}
