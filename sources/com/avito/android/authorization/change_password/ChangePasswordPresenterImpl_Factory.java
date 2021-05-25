package com.avito.android.authorization.change_password;

import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChangePasswordPresenterImpl_Factory implements Factory<ChangePasswordPresenterImpl> {
    public final Provider<ChangePasswordInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<ErrorFormatter> c;
    public final Provider<Kundle> d;

    public ChangePasswordPresenterImpl_Factory(Provider<ChangePasswordInteractor> provider, Provider<SchedulersFactory> provider2, Provider<ErrorFormatter> provider3, Provider<Kundle> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ChangePasswordPresenterImpl_Factory create(Provider<ChangePasswordInteractor> provider, Provider<SchedulersFactory> provider2, Provider<ErrorFormatter> provider3, Provider<Kundle> provider4) {
        return new ChangePasswordPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ChangePasswordPresenterImpl newInstance(ChangePasswordInteractor changePasswordInteractor, SchedulersFactory schedulersFactory, ErrorFormatter errorFormatter, Kundle kundle) {
        return new ChangePasswordPresenterImpl(changePasswordInteractor, schedulersFactory, errorFormatter, kundle);
    }

    @Override // javax.inject.Provider
    public ChangePasswordPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
