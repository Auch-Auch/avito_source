package com.avito.android.authorization.login_suggests;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.performance.ScreenTracker;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class LoginSuggestsActivity_MembersInjector implements MembersInjector<LoginSuggestsActivity> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<ItemBinder> d;
    public final Provider<LoginSuggestsPresenter> e;
    public final Provider<ScreenTracker> f;

    public LoginSuggestsActivity_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<LoginSuggestsPresenter> provider5, Provider<ScreenTracker> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<LoginSuggestsActivity> create(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<LoginSuggestsPresenter> provider5, Provider<ScreenTracker> provider6) {
        return new LoginSuggestsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.authorization.login_suggests.LoginSuggestsActivity.adapterPresenter")
    public static void injectAdapterPresenter(LoginSuggestsActivity loginSuggestsActivity, AdapterPresenter adapterPresenter) {
        loginSuggestsActivity.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.authorization.login_suggests.LoginSuggestsActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(LoginSuggestsActivity loginSuggestsActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        loginSuggestsActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.authorization.login_suggests.LoginSuggestsActivity.intentFactory")
    public static void injectIntentFactory(LoginSuggestsActivity loginSuggestsActivity, ActivityIntentFactory activityIntentFactory) {
        loginSuggestsActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.authorization.login_suggests.LoginSuggestsActivity.itemBinder")
    public static void injectItemBinder(LoginSuggestsActivity loginSuggestsActivity, ItemBinder itemBinder) {
        loginSuggestsActivity.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.authorization.login_suggests.LoginSuggestsActivity.presenter")
    public static void injectPresenter(LoginSuggestsActivity loginSuggestsActivity, LoginSuggestsPresenter loginSuggestsPresenter) {
        loginSuggestsActivity.presenter = loginSuggestsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.authorization.login_suggests.LoginSuggestsActivity.screenTracker")
    public static void injectScreenTracker(LoginSuggestsActivity loginSuggestsActivity, ScreenTracker screenTracker) {
        loginSuggestsActivity.screenTracker = screenTracker;
    }

    public void injectMembers(LoginSuggestsActivity loginSuggestsActivity) {
        injectIntentFactory(loginSuggestsActivity, this.a.get());
        injectDeepLinkIntentFactory(loginSuggestsActivity, this.b.get());
        injectAdapterPresenter(loginSuggestsActivity, this.c.get());
        injectItemBinder(loginSuggestsActivity, this.d.get());
        injectPresenter(loginSuggestsActivity, this.e.get());
        injectScreenTracker(loginSuggestsActivity, this.f.get());
    }
}
