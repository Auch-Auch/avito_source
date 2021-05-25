package com.avito.android.abuse.details;

import com.avito.android.abuse.details.remote.AbuseApi;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.remote.model.Action;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import java.util.List;
import javax.inject.Provider;
public final class AbuseDetailsInteractorImpl_Factory implements Factory<AbuseDetailsInteractorImpl> {
    public final Provider<Integer> a;
    public final Provider<String> b;
    public final Provider<String> c;
    public final Provider<List<Action>> d;
    public final Provider<AbuseApi> e;
    public final Provider<AccountStorageInteractor> f;
    public final Provider<AbuseDetailsResourceProvider> g;
    public final Provider<SchedulersFactory3> h;

    public AbuseDetailsInteractorImpl_Factory(Provider<Integer> provider, Provider<String> provider2, Provider<String> provider3, Provider<List<Action>> provider4, Provider<AbuseApi> provider5, Provider<AccountStorageInteractor> provider6, Provider<AbuseDetailsResourceProvider> provider7, Provider<SchedulersFactory3> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static AbuseDetailsInteractorImpl_Factory create(Provider<Integer> provider, Provider<String> provider2, Provider<String> provider3, Provider<List<Action>> provider4, Provider<AbuseApi> provider5, Provider<AccountStorageInteractor> provider6, Provider<AbuseDetailsResourceProvider> provider7, Provider<SchedulersFactory3> provider8) {
        return new AbuseDetailsInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static AbuseDetailsInteractorImpl newInstance(int i, String str, String str2, List<Action> list, AbuseApi abuseApi, AccountStorageInteractor accountStorageInteractor, AbuseDetailsResourceProvider abuseDetailsResourceProvider, SchedulersFactory3 schedulersFactory3) {
        return new AbuseDetailsInteractorImpl(i, str, str2, list, abuseApi, accountStorageInteractor, abuseDetailsResourceProvider, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public AbuseDetailsInteractorImpl get() {
        return newInstance(this.a.get().intValue(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
