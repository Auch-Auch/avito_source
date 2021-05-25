package com.avito.android.authorization.change_password;

import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChangePasswordInteractorImpl_Factory implements Factory<ChangePasswordInteractorImpl> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<ProfileApi> c;
    public final Provider<SchedulersFactory> d;

    public ChangePasswordInteractorImpl_Factory(Provider<String> provider, Provider<String> provider2, Provider<ProfileApi> provider3, Provider<SchedulersFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ChangePasswordInteractorImpl_Factory create(Provider<String> provider, Provider<String> provider2, Provider<ProfileApi> provider3, Provider<SchedulersFactory> provider4) {
        return new ChangePasswordInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ChangePasswordInteractorImpl newInstance(String str, String str2, ProfileApi profileApi, SchedulersFactory schedulersFactory) {
        return new ChangePasswordInteractorImpl(str, str2, profileApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public ChangePasswordInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
