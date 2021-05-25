package com.avito.android.di.module;

import com.avito.android.account.AccountStorageInteractorImpl;
import com.avito.android.account.MutableLastUserStorage;
import com.avito.android.preferences.MutableSessionStorage;
import com.avito.android.profile.MutableProfileInfoStorage;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AccountModule_ProvideAccountStorageInteractorImplFactory implements Factory<AccountStorageInteractorImpl> {
    public final Provider<MutableSessionStorage> a;
    public final Provider<MutableProfileInfoStorage> b;
    public final Provider<MutableLastUserStorage> c;
    public final Provider<BuildInfo> d;

    public AccountModule_ProvideAccountStorageInteractorImplFactory(Provider<MutableSessionStorage> provider, Provider<MutableProfileInfoStorage> provider2, Provider<MutableLastUserStorage> provider3, Provider<BuildInfo> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static AccountModule_ProvideAccountStorageInteractorImplFactory create(Provider<MutableSessionStorage> provider, Provider<MutableProfileInfoStorage> provider2, Provider<MutableLastUserStorage> provider3, Provider<BuildInfo> provider4) {
        return new AccountModule_ProvideAccountStorageInteractorImplFactory(provider, provider2, provider3, provider4);
    }

    public static AccountStorageInteractorImpl provideAccountStorageInteractorImpl(MutableSessionStorage mutableSessionStorage, MutableProfileInfoStorage mutableProfileInfoStorage, MutableLastUserStorage mutableLastUserStorage, BuildInfo buildInfo) {
        return (AccountStorageInteractorImpl) Preconditions.checkNotNullFromProvides(AccountModule.provideAccountStorageInteractorImpl(mutableSessionStorage, mutableProfileInfoStorage, mutableLastUserStorage, buildInfo));
    }

    @Override // javax.inject.Provider
    public AccountStorageInteractorImpl get() {
        return provideAccountStorageInteractorImpl(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
