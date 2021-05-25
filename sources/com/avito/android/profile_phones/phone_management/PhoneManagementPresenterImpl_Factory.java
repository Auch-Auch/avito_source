package com.avito.android.profile_phones.phone_management;

import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhoneManagementPresenterImpl_Factory implements Factory<PhoneManagementPresenterImpl> {
    public final Provider<PhoneManagementInteractor> a;
    public final Provider<PhoneManagementResourceProvider> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<ErrorHelper> d;
    public final Provider<Boolean> e;
    public final Provider<String> f;
    public final Provider<Kundle> g;

    public PhoneManagementPresenterImpl_Factory(Provider<PhoneManagementInteractor> provider, Provider<PhoneManagementResourceProvider> provider2, Provider<SchedulersFactory> provider3, Provider<ErrorHelper> provider4, Provider<Boolean> provider5, Provider<String> provider6, Provider<Kundle> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static PhoneManagementPresenterImpl_Factory create(Provider<PhoneManagementInteractor> provider, Provider<PhoneManagementResourceProvider> provider2, Provider<SchedulersFactory> provider3, Provider<ErrorHelper> provider4, Provider<Boolean> provider5, Provider<String> provider6, Provider<Kundle> provider7) {
        return new PhoneManagementPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static PhoneManagementPresenterImpl newInstance(PhoneManagementInteractor phoneManagementInteractor, PhoneManagementResourceProvider phoneManagementResourceProvider, SchedulersFactory schedulersFactory, ErrorHelper errorHelper, boolean z, String str, Kundle kundle) {
        return new PhoneManagementPresenterImpl(phoneManagementInteractor, phoneManagementResourceProvider, schedulersFactory, errorHelper, z, str, kundle);
    }

    @Override // javax.inject.Provider
    public PhoneManagementPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get().booleanValue(), this.f.get(), this.g.get());
    }
}
