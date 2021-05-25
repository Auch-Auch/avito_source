package com.avito.android.authorization.reset_password;

import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ResetPasswordPresenterImpl_Factory implements Factory<ResetPasswordPresenterImpl> {
    public final Provider<ResetPasswordInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<Kundle> c;

    public ResetPasswordPresenterImpl_Factory(Provider<ResetPasswordInteractor> provider, Provider<SchedulersFactory> provider2, Provider<Kundle> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ResetPasswordPresenterImpl_Factory create(Provider<ResetPasswordInteractor> provider, Provider<SchedulersFactory> provider2, Provider<Kundle> provider3) {
        return new ResetPasswordPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static ResetPasswordPresenterImpl newInstance(ResetPasswordInteractor resetPasswordInteractor, SchedulersFactory schedulersFactory, Kundle kundle) {
        return new ResetPasswordPresenterImpl(resetPasswordInteractor, schedulersFactory, kundle);
    }

    @Override // javax.inject.Provider
    public ResetPasswordPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
