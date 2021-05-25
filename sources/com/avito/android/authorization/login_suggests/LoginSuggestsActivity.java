package com.avito.android.authorization.login_suggests;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.authorization.R;
import com.avito.android.authorization.login_suggests.LoginSuggestsPresenter;
import com.avito.android.authorization.login_suggests.di.DaggerLoginSuggestsComponent;
import com.avito.android.authorization.login_suggests.di.LoginSuggestsComponent;
import com.avito.android.authorization.login_suggests.di.LoginSuggestsDependencies;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.performance.DiInjectTracker;
import com.avito.android.performance.ScreenTracker;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bG\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000e\u0010\u0007J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\tJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\tR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006H"}, d2 = {"Lcom/avito/android/authorization/login_suggests/LoginSuggestsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "onBackPressed", "outState", "onSaveInstanceState", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "login", "closeWithLogin", "(Ljava/lang/String;)V", "social", "socialId", "closeWithSocial", "(Ljava/lang/String;Ljava/lang/String;)V", "closeWithCommon", "close", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenter;", "presenter", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenter;", "getPresenter", "()Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenter;", "setPresenter", "(Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenter;)V", "Lcom/avito/android/performance/ScreenTracker;", "screenTracker", "Lcom/avito/android/performance/ScreenTracker;", "getScreenTracker", "()Lcom/avito/android/performance/ScreenTracker;", "setScreenTracker", "(Lcom/avito/android/performance/ScreenTracker;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "<init>", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class LoginSuggestsActivity extends BaseActivity implements LoginSuggestsPresenter.Router {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public LoginSuggestsPresenter presenter;
    @Inject
    public ScreenTracker screenTracker;

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsPresenter.Router
    public void close() {
        finish();
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsPresenter.Router
    public void closeWithCommon() {
        setResult(-1);
        LoginSuggestsPresenter loginSuggestsPresenter = this.presenter;
        if (loginSuggestsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginSuggestsPresenter.onBackPressed();
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsPresenter.Router
    public void closeWithLogin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "login");
        setResult(-1, AuthParamsKt.putLogin(new Intent(), str));
        LoginSuggestsPresenter loginSuggestsPresenter = this.presenter;
        if (loginSuggestsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginSuggestsPresenter.onBackPressed();
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsPresenter.Router
    public void closeWithSocial(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "social");
        Intent intent = new Intent();
        AuthParamsKt.putSocial(intent, str);
        AuthParamsKt.putSocialId(intent, str2);
        setResult(-1, intent);
        LoginSuggestsPresenter loginSuggestsPresenter = this.presenter;
        if (loginSuggestsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginSuggestsPresenter.onBackPressed();
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsPresenter.Router
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
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
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
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final LoginSuggestsPresenter getPresenter() {
        LoginSuggestsPresenter loginSuggestsPresenter = this.presenter;
        if (loginSuggestsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return loginSuggestsPresenter;
    }

    @NotNull
    public final ScreenTracker getScreenTracker() {
        ScreenTracker screenTracker2 = this.screenTracker;
        if (screenTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        return screenTracker2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        LoginSuggestsPresenter loginSuggestsPresenter = this.presenter;
        if (loginSuggestsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginSuggestsPresenter.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Timer started = DiInjectTracker.Companion.started();
        LoginSuggestsComponent.Builder dependentOn = DaggerLoginSuggestsComponent.builder().dependentOn((LoginSuggestsDependencies) ComponentDependenciesKt.getDependencies(LoginSuggestsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        dependentOn.withResources(resources).withPresenterState(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null).build().inject(this);
        ScreenTracker screenTracker2 = this.screenTracker;
        if (screenTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker2.getDiInject().finished(started);
        super.onCreate(bundle);
        ScreenTracker screenTracker3 = this.screenTracker;
        if (screenTracker3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker3.getInit().started();
        setContentView(R.layout.login_suggests);
        ScreenTracker screenTracker4 = this.screenTracker;
        if (screenTracker4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker4.resetSession();
        LoginSuggestsPresenter loginSuggestsPresenter = this.presenter;
        if (loginSuggestsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        loginSuggestsPresenter.attachView(new LoginSuggestsViewImpl(findViewById, adapterPresenter2, itemBinder2));
        ScreenTracker screenTracker5 = this.screenTracker;
        if (screenTracker5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker5.getInit().finished();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ScreenTracker screenTracker2 = this.screenTracker;
        if (screenTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker2.stop();
        LoginSuggestsPresenter loginSuggestsPresenter = this.presenter;
        if (loginSuggestsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginSuggestsPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        LoginSuggestsPresenter loginSuggestsPresenter = this.presenter;
        if (loginSuggestsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", loginSuggestsPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        LoginSuggestsPresenter loginSuggestsPresenter = this.presenter;
        if (loginSuggestsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginSuggestsPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        LoginSuggestsPresenter loginSuggestsPresenter = this.presenter;
        if (loginSuggestsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginSuggestsPresenter.detachRouter();
        super.onStop();
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull LoginSuggestsPresenter loginSuggestsPresenter) {
        Intrinsics.checkNotNullParameter(loginSuggestsPresenter, "<set-?>");
        this.presenter = loginSuggestsPresenter;
    }

    public final void setScreenTracker(@NotNull ScreenTracker screenTracker2) {
        Intrinsics.checkNotNullParameter(screenTracker2, "<set-?>");
        this.screenTracker = screenTracker2;
    }
}
