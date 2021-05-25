package com.avito.android.profile.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.profile.edit.EditProfileInteractor;
import com.avito.android.profile.edit.EditProfilePresenter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditProfileModule_ProvidePresenterFactory implements Factory<EditProfilePresenter> {
    public final Provider<EditProfileInteractor> a;
    public final Provider<Analytics> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<ErrorFormatter> e;
    public final Provider<Kundle> f;

    public EditProfileModule_ProvidePresenterFactory(Provider<EditProfileInteractor> provider, Provider<Analytics> provider2, Provider<AdapterPresenter> provider3, Provider<SchedulersFactory> provider4, Provider<ErrorFormatter> provider5, Provider<Kundle> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static EditProfileModule_ProvidePresenterFactory create(Provider<EditProfileInteractor> provider, Provider<Analytics> provider2, Provider<AdapterPresenter> provider3, Provider<SchedulersFactory> provider4, Provider<ErrorFormatter> provider5, Provider<Kundle> provider6) {
        return new EditProfileModule_ProvidePresenterFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static EditProfilePresenter providePresenter(EditProfileInteractor editProfileInteractor, Analytics analytics, AdapterPresenter adapterPresenter, SchedulersFactory schedulersFactory, ErrorFormatter errorFormatter, Kundle kundle) {
        return (EditProfilePresenter) Preconditions.checkNotNullFromProvides(EditProfileModule.providePresenter(editProfileInteractor, analytics, adapterPresenter, schedulersFactory, errorFormatter, kundle));
    }

    @Override // javax.inject.Provider
    public EditProfilePresenter get() {
        return providePresenter(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
