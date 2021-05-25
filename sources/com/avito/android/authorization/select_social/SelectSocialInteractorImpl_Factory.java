package com.avito.android.authorization.select_social;

import com.avito.android.account.AccountInteractor;
import com.avito.android.remote.model.registration.ProfileSocial;
import dagger.internal.Factory;
import java.util.List;
import javax.inject.Provider;
public final class SelectSocialInteractorImpl_Factory implements Factory<SelectSocialInteractorImpl> {
    public final Provider<List<ProfileSocial>> a;
    public final Provider<AccountInteractor> b;
    public final Provider<SelectSocialResourceProvider> c;

    public SelectSocialInteractorImpl_Factory(Provider<List<ProfileSocial>> provider, Provider<AccountInteractor> provider2, Provider<SelectSocialResourceProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SelectSocialInteractorImpl_Factory create(Provider<List<ProfileSocial>> provider, Provider<AccountInteractor> provider2, Provider<SelectSocialResourceProvider> provider3) {
        return new SelectSocialInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static SelectSocialInteractorImpl newInstance(List<ProfileSocial> list, AccountInteractor accountInteractor, SelectSocialResourceProvider selectSocialResourceProvider) {
        return new SelectSocialInteractorImpl(list, accountInteractor, selectSocialResourceProvider);
    }

    @Override // javax.inject.Provider
    public SelectSocialInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
