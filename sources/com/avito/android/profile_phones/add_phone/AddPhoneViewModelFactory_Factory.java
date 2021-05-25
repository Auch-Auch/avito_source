package com.avito.android.profile_phones.add_phone;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AddPhoneViewModelFactory_Factory implements Factory<AddPhoneViewModelFactory> {
    public final Provider<AddPhoneInteractor> a;

    public AddPhoneViewModelFactory_Factory(Provider<AddPhoneInteractor> provider) {
        this.a = provider;
    }

    public static AddPhoneViewModelFactory_Factory create(Provider<AddPhoneInteractor> provider) {
        return new AddPhoneViewModelFactory_Factory(provider);
    }

    public static AddPhoneViewModelFactory newInstance(AddPhoneInteractor addPhoneInteractor) {
        return new AddPhoneViewModelFactory(addPhoneInteractor);
    }

    @Override // javax.inject.Provider
    public AddPhoneViewModelFactory get() {
        return newInstance(this.a.get());
    }
}
