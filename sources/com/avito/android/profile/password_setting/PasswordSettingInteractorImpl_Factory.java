package com.avito.android.profile.password_setting;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PasswordSettingInteractorImpl_Factory implements Factory<PasswordSettingInteractorImpl> {
    public final Provider<AccountStorageInteractor> a;
    public final Provider<SessionChangeTracker> b;
    public final Provider<ProfileApi> c;
    public final Provider<SchedulersFactory> d;

    public PasswordSettingInteractorImpl_Factory(Provider<AccountStorageInteractor> provider, Provider<SessionChangeTracker> provider2, Provider<ProfileApi> provider3, Provider<SchedulersFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static PasswordSettingInteractorImpl_Factory create(Provider<AccountStorageInteractor> provider, Provider<SessionChangeTracker> provider2, Provider<ProfileApi> provider3, Provider<SchedulersFactory> provider4) {
        return new PasswordSettingInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static PasswordSettingInteractorImpl newInstance(AccountStorageInteractor accountStorageInteractor, SessionChangeTracker sessionChangeTracker, ProfileApi profileApi, SchedulersFactory schedulersFactory) {
        return new PasswordSettingInteractorImpl(accountStorageInteractor, sessionChangeTracker, profileApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public PasswordSettingInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
