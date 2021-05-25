package com.avito.android.passport_verification;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PassportVerificationModelImpl_Factory implements Factory<PassportVerificationModelImpl> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<PassportVerificationInteractor> c;
    public final Provider<SchedulersFactory3> d;
    public final Provider<Analytics> e;
    public final Provider<Boolean> f;

    public PassportVerificationModelImpl_Factory(Provider<String> provider, Provider<String> provider2, Provider<PassportVerificationInteractor> provider3, Provider<SchedulersFactory3> provider4, Provider<Analytics> provider5, Provider<Boolean> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static PassportVerificationModelImpl_Factory create(Provider<String> provider, Provider<String> provider2, Provider<PassportVerificationInteractor> provider3, Provider<SchedulersFactory3> provider4, Provider<Analytics> provider5, Provider<Boolean> provider6) {
        return new PassportVerificationModelImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static PassportVerificationModelImpl newInstance(String str, String str2, PassportVerificationInteractor passportVerificationInteractor, SchedulersFactory3 schedulersFactory3, Analytics analytics, boolean z) {
        return new PassportVerificationModelImpl(str, str2, passportVerificationInteractor, schedulersFactory3, analytics, z);
    }

    @Override // javax.inject.Provider
    public PassportVerificationModelImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get().booleanValue());
    }
}
