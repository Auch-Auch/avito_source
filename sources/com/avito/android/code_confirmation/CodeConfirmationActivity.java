package com.avito.android.code_confirmation;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.code_confirmation.CodeConfirmationPresenter;
import com.avito.android.code_confirmation.di.CodeConfirmationComponent;
import com.avito.android.code_confirmation.di.CodeConfirmationDependencies;
import com.avito.android.code_confirmation.di.DaggerCodeConfirmationComponent;
import com.avito.android.code_confirmation.event.CodeConfirmationOpenedEvent;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import com.avito.android.util.DialogRouter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b=\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tJ'\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lcom/avito/android/code_confirmation/CodeConfirmationActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/code_confirmation/CodeConfirmationPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "outState", "onSaveInstanceState", "leaveScreen", "", "login", "hash", "", "isPhoneUsed", "finishConfirmation", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/code_confirmation/CodeConfirmationPresenter;", "presenter", "Lcom/avito/android/code_confirmation/CodeConfirmationPresenter;", "getPresenter", "()Lcom/avito/android/code_confirmation/CodeConfirmationPresenter;", "setPresenter", "(Lcom/avito/android/code_confirmation/CodeConfirmationPresenter;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class CodeConfirmationActivity extends BaseActivity implements CodeConfirmationPresenter.Router {
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public CodeConfirmationPresenter presenter;

    @Override // com.avito.android.code_confirmation.CodeConfirmationPresenter.Router
    public void finishConfirmation(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "hash");
        setResult(-1, CodeConfirmationParamsKt.putPhoneUsed(CodeConfirmationParamsKt.putHash(CodeConfirmationParamsKt.putLogin(new Intent(), str), str2), z));
        leaveScreen();
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationPresenter.Router
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
    public final CodeConfirmationPresenter getPresenter() {
        CodeConfirmationPresenter codeConfirmationPresenter = this.presenter;
        if (codeConfirmationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return codeConfirmationPresenter;
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationPresenter.Router
    public void leaveScreen() {
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("src");
        CodeConfirmationComponent.Builder withActivity = DaggerCodeConfirmationComponent.builder().dependentOn((CodeConfirmationDependencies) ComponentDependenciesKt.getDependencies(CodeConfirmationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withActivity(this);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        CodeConfirmationComponent.Builder withResources = withActivity.withResources(resources);
        Intrinsics.checkNotNullExpressionValue(stringExtra, "src");
        withResources.withSrc(stringExtra).withRetry(true).withPresenterState(bundle != null ? Bundles.getKundle(bundle, "presenterState") : null).build().inject(this);
        super.onCreate(bundle);
        setContentView(R.layout.code_confirmation);
        if (bundle == null) {
            String stringExtra2 = getIntent().getStringExtra("challenge_id");
            if (stringExtra2 != null) {
                CodeConfirmationPresenter codeConfirmationPresenter = this.presenter;
                if (codeConfirmationPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                codeConfirmationPresenter.enablePhoneAntihack(stringExtra2);
            }
            String stringExtra3 = getIntent().getStringExtra("phone_number");
            if (stringExtra3 != null) {
                CodeConfirmationPresenter codeConfirmationPresenter2 = this.presenter;
                if (codeConfirmationPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                codeConfirmationPresenter2.enableTfaMode(stringExtra3);
            }
            CodeConfirmationPresenter codeConfirmationPresenter3 = this.presenter;
            if (codeConfirmationPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            String login = CodeConfirmationParamsKt.getLogin(this);
            String stringExtra4 = getIntent().getStringExtra("text");
            if (stringExtra4 == null) {
                stringExtra4 = "";
            }
            codeConfirmationPresenter3.initData(login, stringExtra4, getIntent().getLongExtra("timeout", 0), getIntent().getIntExtra("length", 0));
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new CodeConfirmationOpenedEvent(CodeConfirmationParamsKt.getLogin(this), stringExtra));
        }
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        CodeConfirmationViewImpl codeConfirmationViewImpl = new CodeConfirmationViewImpl(findViewById, dialogRouter2);
        CodeConfirmationPresenter codeConfirmationPresenter4 = this.presenter;
        if (codeConfirmationPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        codeConfirmationPresenter4.attachView(codeConfirmationViewImpl);
        if (bundle == null) {
            codeConfirmationViewImpl.requestFieldFocus();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CodeConfirmationPresenter codeConfirmationPresenter = this.presenter;
        if (codeConfirmationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        codeConfirmationPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        CodeConfirmationPresenter codeConfirmationPresenter = this.presenter;
        if (codeConfirmationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenterState", codeConfirmationPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        CodeConfirmationPresenter codeConfirmationPresenter = this.presenter;
        if (codeConfirmationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        codeConfirmationPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        CodeConfirmationPresenter codeConfirmationPresenter = this.presenter;
        if (codeConfirmationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        codeConfirmationPresenter.detachRouter();
        super.onStop();
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
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

    public final void setPresenter(@NotNull CodeConfirmationPresenter codeConfirmationPresenter) {
        Intrinsics.checkNotNullParameter(codeConfirmationPresenter, "<set-?>");
        this.presenter = codeConfirmationPresenter;
    }
}
