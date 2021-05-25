package com.avito.android.abuse.category;

import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AbuseCategoryPresenterImpl_Factory implements Factory<AbuseCategoryPresenterImpl> {
    public final Provider<String> a;
    public final Provider<AbuseCategoryInteractor> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<SchedulersFactory3> d;
    public final Provider<ErrorFormatter> e;
    public final Provider<Kundle> f;

    public AbuseCategoryPresenterImpl_Factory(Provider<String> provider, Provider<AbuseCategoryInteractor> provider2, Provider<AdapterPresenter> provider3, Provider<SchedulersFactory3> provider4, Provider<ErrorFormatter> provider5, Provider<Kundle> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static AbuseCategoryPresenterImpl_Factory create(Provider<String> provider, Provider<AbuseCategoryInteractor> provider2, Provider<AdapterPresenter> provider3, Provider<SchedulersFactory3> provider4, Provider<ErrorFormatter> provider5, Provider<Kundle> provider6) {
        return new AbuseCategoryPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AbuseCategoryPresenterImpl newInstance(String str, AbuseCategoryInteractor abuseCategoryInteractor, Lazy<AdapterPresenter> lazy, SchedulersFactory3 schedulersFactory3, ErrorFormatter errorFormatter, Kundle kundle) {
        return new AbuseCategoryPresenterImpl(str, abuseCategoryInteractor, lazy, schedulersFactory3, errorFormatter, kundle);
    }

    @Override // javax.inject.Provider
    public AbuseCategoryPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), DoubleCheck.lazy(this.c), this.d.get(), this.e.get(), this.f.get());
    }
}
