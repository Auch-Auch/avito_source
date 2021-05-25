package com.avito.android.profile.password_setting;

import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PasswordSettingPresenterImpl_Factory implements Factory<PasswordSettingPresenterImpl> {
    public final Provider<PasswordSettingInteractor> a;
    public final Provider<DialogPresenter> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<ErrorHelper> d;
    public final Provider<Kundle> e;

    public PasswordSettingPresenterImpl_Factory(Provider<PasswordSettingInteractor> provider, Provider<DialogPresenter> provider2, Provider<SchedulersFactory> provider3, Provider<ErrorHelper> provider4, Provider<Kundle> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static PasswordSettingPresenterImpl_Factory create(Provider<PasswordSettingInteractor> provider, Provider<DialogPresenter> provider2, Provider<SchedulersFactory> provider3, Provider<ErrorHelper> provider4, Provider<Kundle> provider5) {
        return new PasswordSettingPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PasswordSettingPresenterImpl newInstance(PasswordSettingInteractor passwordSettingInteractor, DialogPresenter dialogPresenter, SchedulersFactory schedulersFactory, ErrorHelper errorHelper, Kundle kundle) {
        return new PasswordSettingPresenterImpl(passwordSettingInteractor, dialogPresenter, schedulersFactory, errorHelper, kundle);
    }

    @Override // javax.inject.Provider
    public PasswordSettingPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
