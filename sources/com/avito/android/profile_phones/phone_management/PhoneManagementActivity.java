package com.avito.android.profile_phones.phone_management;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.CodeConfirmationIntentFactory;
import com.avito.android.code_confirmation.CodeConfirmationParamsKt;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.profile_phones.phone_management.PhoneManagementPresenter;
import com.avito.android.profile_phones.phone_management.di.DaggerPhoneManagementComponent;
import com.avito.android.profile_phones.phone_management.di.PhoneManagementComponent;
import com.avito.android.profile_phones.phone_management.di.PhoneManagementDependencies;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Bundles;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.ToastsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bB\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ)\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0014\u0010\u0007J7\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lcom/avito/android/profile_phones/phone_management/PhoneManagementActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "", "login", "text", "", "codeTimeout", "codeLength", "src", "openCodeConfirmation", "(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "success", "leaveScreen", "(Z)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementPresenter;", "presenter", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementPresenter;", "getPresenter", "()Lcom/avito/android/profile_phones/phone_management/PhoneManagementPresenter;", "setPresenter", "(Lcom/avito/android/profile_phones/phone_management/PhoneManagementPresenter;)V", "<init>", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneManagementActivity extends BaseActivity implements PhoneManagementPresenter.Router {
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public PhoneManagementPresenter presenter;

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
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

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
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
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final PhoneManagementPresenter getPresenter() {
        PhoneManagementPresenter phoneManagementPresenter = this.presenter;
        if (phoneManagementPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return phoneManagementPresenter;
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementPresenter.Router
    public void leaveScreen(boolean z) {
        setResult(z ? -1 : 0);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String login;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i != 42) {
            if (i == 43) {
                leaveScreen(true);
            }
        } else if (intent == null || (login = CodeConfirmationParamsKt.getLogin(intent)) == null) {
            throw new IllegalStateException("login must be specified");
        } else {
            PhoneManagementPresenter phoneManagementPresenter = this.presenter;
            if (phoneManagementPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            phoneManagementPresenter.onPhoneConfirmed(login);
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        PhoneManagementComponent.Builder dependentOn = DaggerPhoneManagementComponent.builder().dependentOn((PhoneManagementDependencies) ComponentDependenciesKt.getDependencies(PhoneManagementDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        String stringExtra = getIntent().getStringExtra("source");
        if (stringExtra == null) {
            stringExtra = "";
        }
        PhoneManagementComponent.Builder withRetry = dependentOn.withSrc(stringExtra).withRetry(false);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        withRetry.withResources(resources).withFromProfile(getIntent().getBooleanExtra("from_profile", false)).withPresenterState(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null).withActivity(this).build().inject(this);
        super.onCreate(bundle);
        if (bundle == null) {
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            String stringExtra2 = intent.getStringExtra("phone");
            if (stringExtra2 != null) {
                PhoneManagementPresenter phoneManagementPresenter = this.presenter;
                if (phoneManagementPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                Intent intent2 = getIntent();
                Intrinsics.checkNotNullExpressionValue(intent2, "intent");
                boolean booleanExtra = intent2.getBooleanExtra("verified", false);
                Intent intent3 = getIntent();
                Intrinsics.checkNotNullExpressionValue(intent3, "intent");
                phoneManagementPresenter.setStartPhone(stringExtra2, booleanExtra, intent3.getIntExtra("items_count", 0));
            }
        }
        setContentView(com.avito.android.profile_phones.R.layout.phone_management);
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        PhoneManagementViewImpl phoneManagementViewImpl = new PhoneManagementViewImpl(findViewById, dialogRouter2);
        PhoneManagementPresenter phoneManagementPresenter2 = this.presenter;
        if (phoneManagementPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        phoneManagementPresenter2.attachView(phoneManagementViewImpl);
        if (bundle == null) {
            phoneManagementViewImpl.requestFieldFocus();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        PhoneManagementPresenter phoneManagementPresenter = this.presenter;
        if (phoneManagementPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        phoneManagementPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        PhoneManagementPresenter phoneManagementPresenter = this.presenter;
        if (phoneManagementPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", phoneManagementPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        PhoneManagementPresenter phoneManagementPresenter = this.presenter;
        if (phoneManagementPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        phoneManagementPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        PhoneManagementPresenter phoneManagementPresenter = this.presenter;
        if (phoneManagementPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        phoneManagementPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementPresenter.Router
    public void openCodeConfirmation(@NotNull String str, @NotNull String str2, long j, int i, @NotNull String str3) {
        a.Z0(str, "login", str2, "text", str3, "src");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(IntentsKt.withClearTopFlags(CodeConfirmationIntentFactory.DefaultImpls.codeConfirmationIntent$default(activityIntentFactory, str, null, str2, j, i, str3, 2, null)), 42);
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPresenter(@NotNull PhoneManagementPresenter phoneManagementPresenter) {
        Intrinsics.checkNotNullParameter(phoneManagementPresenter, "<set-?>");
        this.presenter = phoneManagementPresenter;
    }
}
