package com.avito.android.authorization.phone_proving;

import com.avito.android.analytics.Analytics;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhoneProvingPresenterImpl_Factory implements Factory<PhoneProvingPresenterImpl> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<String> c;
    public final Provider<Boolean> d;
    public final Provider<PhoneProvingInteractor> e;
    public final Provider<DialogPresenter> f;
    public final Provider<ErrorHelper> g;
    public final Provider<SchedulersFactory> h;
    public final Provider<Analytics> i;
    public final Provider<Kundle> j;

    public PhoneProvingPresenterImpl_Factory(Provider<String> provider, Provider<String> provider2, Provider<String> provider3, Provider<Boolean> provider4, Provider<PhoneProvingInteractor> provider5, Provider<DialogPresenter> provider6, Provider<ErrorHelper> provider7, Provider<SchedulersFactory> provider8, Provider<Analytics> provider9, Provider<Kundle> provider10) {
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

    public static PhoneProvingPresenterImpl_Factory create(Provider<String> provider, Provider<String> provider2, Provider<String> provider3, Provider<Boolean> provider4, Provider<PhoneProvingInteractor> provider5, Provider<DialogPresenter> provider6, Provider<ErrorHelper> provider7, Provider<SchedulersFactory> provider8, Provider<Analytics> provider9, Provider<Kundle> provider10) {
        return new PhoneProvingPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static PhoneProvingPresenterImpl newInstance(String str, String str2, String str3, boolean z, PhoneProvingInteractor phoneProvingInteractor, DialogPresenter dialogPresenter, ErrorHelper errorHelper, SchedulersFactory schedulersFactory, Analytics analytics, Kundle kundle) {
        return new PhoneProvingPresenterImpl(str, str2, str3, z, phoneProvingInteractor, dialogPresenter, errorHelper, schedulersFactory, analytics, kundle);
    }

    @Override // javax.inject.Provider
    public PhoneProvingPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get().booleanValue(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
