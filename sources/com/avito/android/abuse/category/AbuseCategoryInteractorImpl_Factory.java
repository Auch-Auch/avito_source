package com.avito.android.abuse.category;

import com.avito.android.abuse.details.remote.AbuseApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AbuseCategoryInteractorImpl_Factory implements Factory<AbuseCategoryInteractorImpl> {
    public final Provider<AbuseApi> a;
    public final Provider<SchedulersFactory3> b;

    public AbuseCategoryInteractorImpl_Factory(Provider<AbuseApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AbuseCategoryInteractorImpl_Factory create(Provider<AbuseApi> provider, Provider<SchedulersFactory3> provider2) {
        return new AbuseCategoryInteractorImpl_Factory(provider, provider2);
    }

    public static AbuseCategoryInteractorImpl newInstance(AbuseApi abuseApi, SchedulersFactory3 schedulersFactory3) {
        return new AbuseCategoryInteractorImpl(abuseApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public AbuseCategoryInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
