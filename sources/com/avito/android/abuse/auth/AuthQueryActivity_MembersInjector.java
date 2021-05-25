package com.avito.android.abuse.auth;

import com.avito.android.ActivityIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AuthQueryActivity_MembersInjector implements MembersInjector<AuthQueryActivity> {
    public final Provider<AuthQueryPresenter> a;
    public final Provider<ActivityIntentFactory> b;

    public AuthQueryActivity_MembersInjector(Provider<AuthQueryPresenter> provider, Provider<ActivityIntentFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<AuthQueryActivity> create(Provider<AuthQueryPresenter> provider, Provider<ActivityIntentFactory> provider2) {
        return new AuthQueryActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.abuse.auth.AuthQueryActivity.intentFactory")
    public static void injectIntentFactory(AuthQueryActivity authQueryActivity, ActivityIntentFactory activityIntentFactory) {
        authQueryActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.abuse.auth.AuthQueryActivity.presenter")
    public static void injectPresenter(AuthQueryActivity authQueryActivity, AuthQueryPresenter authQueryPresenter) {
        authQueryActivity.presenter = authQueryPresenter;
    }

    public void injectMembers(AuthQueryActivity authQueryActivity) {
        injectPresenter(authQueryActivity, this.a.get());
        injectIntentFactory(authQueryActivity, this.b.get());
    }
}
