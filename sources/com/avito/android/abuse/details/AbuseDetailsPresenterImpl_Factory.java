package com.avito.android.abuse.details;

import com.avito.android.abuse.details.adapter.AbuseField;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class AbuseDetailsPresenterImpl_Factory implements Factory<AbuseDetailsPresenterImpl> {
    public final Provider<AbuseDetailsInteractor> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<Observable<AbuseField>> c;
    public final Provider<Observable<AbuseField>> d;
    public final Provider<Observable<DeepLink>> e;
    public final Provider<ErrorFormatter> f;
    public final Provider<SchedulersFactory3> g;
    public final Provider<Kundle> h;

    public AbuseDetailsPresenterImpl_Factory(Provider<AbuseDetailsInteractor> provider, Provider<AdapterPresenter> provider2, Provider<Observable<AbuseField>> provider3, Provider<Observable<AbuseField>> provider4, Provider<Observable<DeepLink>> provider5, Provider<ErrorFormatter> provider6, Provider<SchedulersFactory3> provider7, Provider<Kundle> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static AbuseDetailsPresenterImpl_Factory create(Provider<AbuseDetailsInteractor> provider, Provider<AdapterPresenter> provider2, Provider<Observable<AbuseField>> provider3, Provider<Observable<AbuseField>> provider4, Provider<Observable<DeepLink>> provider5, Provider<ErrorFormatter> provider6, Provider<SchedulersFactory3> provider7, Provider<Kundle> provider8) {
        return new AbuseDetailsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static AbuseDetailsPresenterImpl newInstance(AbuseDetailsInteractor abuseDetailsInteractor, AdapterPresenter adapterPresenter, Observable<AbuseField> observable, Observable<AbuseField> observable2, Observable<DeepLink> observable3, ErrorFormatter errorFormatter, SchedulersFactory3 schedulersFactory3, Kundle kundle) {
        return new AbuseDetailsPresenterImpl(abuseDetailsInteractor, adapterPresenter, observable, observable2, observable3, errorFormatter, schedulersFactory3, kundle);
    }

    @Override // javax.inject.Provider
    public AbuseDetailsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
