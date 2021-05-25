package com.avito.android.profile.password_change;

import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.profile.password_change.PasswordChangePresenter;
import com.avito.android.profile.password_change.business.PasswordChangeInteractor;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PasswordChangePresenterImpl_Factory implements Factory<PasswordChangePresenterImpl> {
    public final Provider<PasswordChangeInteractor> a;
    public final Provider<DialogPresenter> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<ErrorHelper> d;
    public final Provider<SmartLockLoader> e;
    public final Provider<SmartLockSaver> f;
    public final Provider<PasswordChangePresenter.Mode> g;
    public final Provider<Analytics> h;
    public final Provider<PasswordChangeResourceProvider> i;
    public final Provider<Kundle> j;

    public PasswordChangePresenterImpl_Factory(Provider<PasswordChangeInteractor> provider, Provider<DialogPresenter> provider2, Provider<SchedulersFactory> provider3, Provider<ErrorHelper> provider4, Provider<SmartLockLoader> provider5, Provider<SmartLockSaver> provider6, Provider<PasswordChangePresenter.Mode> provider7, Provider<Analytics> provider8, Provider<PasswordChangeResourceProvider> provider9, Provider<Kundle> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static PasswordChangePresenterImpl_Factory create(Provider<PasswordChangeInteractor> provider, Provider<DialogPresenter> provider2, Provider<SchedulersFactory> provider3, Provider<ErrorHelper> provider4, Provider<SmartLockLoader> provider5, Provider<SmartLockSaver> provider6, Provider<PasswordChangePresenter.Mode> provider7, Provider<Analytics> provider8, Provider<PasswordChangeResourceProvider> provider9, Provider<Kundle> provider10) {
        return new PasswordChangePresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static PasswordChangePresenterImpl newInstance(PasswordChangeInteractor passwordChangeInteractor, DialogPresenter dialogPresenter, SchedulersFactory schedulersFactory, ErrorHelper errorHelper, SmartLockLoader smartLockLoader, SmartLockSaver smartLockSaver, PasswordChangePresenter.Mode mode, Analytics analytics, PasswordChangeResourceProvider passwordChangeResourceProvider, Kundle kundle) {
        return new PasswordChangePresenterImpl(passwordChangeInteractor, dialogPresenter, schedulersFactory, errorHelper, smartLockLoader, smartLockSaver, mode, analytics, passwordChangeResourceProvider, kundle);
    }

    @Override // javax.inject.Provider
    public PasswordChangePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
