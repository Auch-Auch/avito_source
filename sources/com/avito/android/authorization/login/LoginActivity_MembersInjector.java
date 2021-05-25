package com.avito.android.authorization.login;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.DialogRouter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class LoginActivity_MembersInjector implements MembersInjector<LoginActivity> {
    public final Provider<LoginPresenter> a;
    public final Provider<LoginInteractor> b;
    public final Provider<Analytics> c;
    public final Provider<Features> d;
    public final Provider<ActivityIntentFactory> e;
    public final Provider<DeepLinkIntentFactory> f;
    public final Provider<DialogRouter> g;
    public final Provider<SmartLockSaver> h;

    public LoginActivity_MembersInjector(Provider<LoginPresenter> provider, Provider<LoginInteractor> provider2, Provider<Analytics> provider3, Provider<Features> provider4, Provider<ActivityIntentFactory> provider5, Provider<DeepLinkIntentFactory> provider6, Provider<DialogRouter> provider7, Provider<SmartLockSaver> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static MembersInjector<LoginActivity> create(Provider<LoginPresenter> provider, Provider<LoginInteractor> provider2, Provider<Analytics> provider3, Provider<Features> provider4, Provider<ActivityIntentFactory> provider5, Provider<DeepLinkIntentFactory> provider6, Provider<DialogRouter> provider7, Provider<SmartLockSaver> provider8) {
        return new LoginActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @InjectedFieldSignature("com.avito.android.authorization.login.LoginActivity.activityIntentFactory")
    public static void injectActivityIntentFactory(LoginActivity loginActivity, ActivityIntentFactory activityIntentFactory) {
        loginActivity.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.authorization.login.LoginActivity.analytics")
    public static void injectAnalytics(LoginActivity loginActivity, Analytics analytics) {
        loginActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.authorization.login.LoginActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(LoginActivity loginActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        loginActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.authorization.login.LoginActivity.dialogRouter")
    public static void injectDialogRouter(LoginActivity loginActivity, DialogRouter dialogRouter) {
        loginActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.authorization.login.LoginActivity.features")
    public static void injectFeatures(LoginActivity loginActivity, Features features) {
        loginActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.authorization.login.LoginActivity.interactor")
    public static void injectInteractor(LoginActivity loginActivity, LoginInteractor loginInteractor) {
        loginActivity.interactor = loginInteractor;
    }

    @InjectedFieldSignature("com.avito.android.authorization.login.LoginActivity.presenter")
    public static void injectPresenter(LoginActivity loginActivity, LoginPresenter loginPresenter) {
        loginActivity.presenter = loginPresenter;
    }

    @InjectedFieldSignature("com.avito.android.authorization.login.LoginActivity.smartLock")
    public static void injectSmartLock(LoginActivity loginActivity, SmartLockSaver smartLockSaver) {
        loginActivity.smartLock = smartLockSaver;
    }

    public void injectMembers(LoginActivity loginActivity) {
        injectPresenter(loginActivity, this.a.get());
        injectInteractor(loginActivity, this.b.get());
        injectAnalytics(loginActivity, this.c.get());
        injectFeatures(loginActivity, this.d.get());
        injectActivityIntentFactory(loginActivity, this.e.get());
        injectDeepLinkIntentFactory(loginActivity, this.f.get());
        injectDialogRouter(loginActivity, this.g.get());
        injectSmartLock(loginActivity, this.h.get());
    }
}
