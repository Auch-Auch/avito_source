package com.avito.android.passport_verification.di;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PassportVerificationModule_ProvideAdapter$passport_verification_releaseFactory implements Factory<RecyclerView.Adapter<?>> {
    public final PassportVerificationModule a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;

    public PassportVerificationModule_ProvideAdapter$passport_verification_releaseFactory(PassportVerificationModule passportVerificationModule, Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = passportVerificationModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PassportVerificationModule_ProvideAdapter$passport_verification_releaseFactory create(PassportVerificationModule passportVerificationModule, Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new PassportVerificationModule_ProvideAdapter$passport_verification_releaseFactory(passportVerificationModule, provider, provider2);
    }

    public static RecyclerView.Adapter<?> provideAdapter$passport_verification_release(PassportVerificationModule passportVerificationModule, AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return (RecyclerView.Adapter) Preconditions.checkNotNullFromProvides(passportVerificationModule.provideAdapter$passport_verification_release(adapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public RecyclerView.Adapter<?> get() {
        return provideAdapter$passport_verification_release(this.a, this.b.get(), this.c.get());
    }
}
