package com.avito.android.profile.password_change.business;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PasswordChangeInteractorImpl_Factory implements Factory<PasswordChangeInteractorImpl> {
    public final Provider<AccountStorageInteractor> a;
    public final Provider<ProfileApi> b;
    public final Provider<SessionChangeTracker> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<LoginSuggestStorage> e;

    public PasswordChangeInteractorImpl_Factory(Provider<AccountStorageInteractor> provider, Provider<ProfileApi> provider2, Provider<SessionChangeTracker> provider3, Provider<SchedulersFactory> provider4, Provider<LoginSuggestStorage> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static PasswordChangeInteractorImpl_Factory create(Provider<AccountStorageInteractor> provider, Provider<ProfileApi> provider2, Provider<SessionChangeTracker> provider3, Provider<SchedulersFactory> provider4, Provider<LoginSuggestStorage> provider5) {
        return new PasswordChangeInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PasswordChangeInteractorImpl newInstance(AccountStorageInteractor accountStorageInteractor, ProfileApi profileApi, SessionChangeTracker sessionChangeTracker, SchedulersFactory schedulersFactory, LoginSuggestStorage loginSuggestStorage) {
        return new PasswordChangeInteractorImpl(accountStorageInteractor, profileApi, sessionChangeTracker, schedulersFactory, loginSuggestStorage);
    }

    @Override // javax.inject.Provider
    public PasswordChangeInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
