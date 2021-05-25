package com.avito.android.profile.tfa.settings;

import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TfaSettingsPresenterImpl_Factory implements Factory<TfaSettingsPresenterImpl> {
    public final Provider<TfaSettingsInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<ErrorHelper> c;
    public final Provider<Kundle> d;

    public TfaSettingsPresenterImpl_Factory(Provider<TfaSettingsInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<ErrorHelper> provider3, Provider<Kundle> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static TfaSettingsPresenterImpl_Factory create(Provider<TfaSettingsInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<ErrorHelper> provider3, Provider<Kundle> provider4) {
        return new TfaSettingsPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static TfaSettingsPresenterImpl newInstance(TfaSettingsInteractor tfaSettingsInteractor, SchedulersFactory3 schedulersFactory3, ErrorHelper errorHelper, Kundle kundle) {
        return new TfaSettingsPresenterImpl(tfaSettingsInteractor, schedulersFactory3, errorHelper, kundle);
    }

    @Override // javax.inject.Provider
    public TfaSettingsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
