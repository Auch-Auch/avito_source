package com.avito.android.authorization.login_protection;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class LoginProtectionPhoneListFragment_MembersInjector implements MembersInjector<LoginProtectionPhoneListFragment> {
    public final Provider<LoginProtectionPhoneListPresenter> a;
    public final Provider<RecyclerView.Adapter<?>> b;
    public final Provider<ActivityIntentFactory> c;
    public final Provider<Analytics> d;

    public LoginProtectionPhoneListFragment_MembersInjector(Provider<LoginProtectionPhoneListPresenter> provider, Provider<RecyclerView.Adapter<?>> provider2, Provider<ActivityIntentFactory> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<LoginProtectionPhoneListFragment> create(Provider<LoginProtectionPhoneListPresenter> provider, Provider<RecyclerView.Adapter<?>> provider2, Provider<ActivityIntentFactory> provider3, Provider<Analytics> provider4) {
        return new LoginProtectionPhoneListFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.authorization.login_protection.LoginProtectionPhoneListFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(LoginProtectionPhoneListFragment loginProtectionPhoneListFragment, ActivityIntentFactory activityIntentFactory) {
        loginProtectionPhoneListFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.authorization.login_protection.LoginProtectionPhoneListFragment.adapterPresenter")
    public static void injectAdapterPresenter(LoginProtectionPhoneListFragment loginProtectionPhoneListFragment, RecyclerView.Adapter<?> adapter) {
        loginProtectionPhoneListFragment.adapterPresenter = adapter;
    }

    @InjectedFieldSignature("com.avito.android.authorization.login_protection.LoginProtectionPhoneListFragment.analytics")
    public static void injectAnalytics(LoginProtectionPhoneListFragment loginProtectionPhoneListFragment, Analytics analytics) {
        loginProtectionPhoneListFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.authorization.login_protection.LoginProtectionPhoneListFragment.presenter")
    public static void injectPresenter(LoginProtectionPhoneListFragment loginProtectionPhoneListFragment, LoginProtectionPhoneListPresenter loginProtectionPhoneListPresenter) {
        loginProtectionPhoneListFragment.presenter = loginProtectionPhoneListPresenter;
    }

    public void injectMembers(LoginProtectionPhoneListFragment loginProtectionPhoneListFragment) {
        injectPresenter(loginProtectionPhoneListFragment, this.a.get());
        injectAdapterPresenter(loginProtectionPhoneListFragment, this.b.get());
        injectActivityIntentFactory(loginProtectionPhoneListFragment, this.c.get());
        injectAnalytics(loginProtectionPhoneListFragment, this.d.get());
    }
}
