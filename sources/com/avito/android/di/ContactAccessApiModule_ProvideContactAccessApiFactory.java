package com.avito.android.di;

import com.avito.android.contact_access.remote.ContactAccessApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ContactAccessApiModule_ProvideContactAccessApiFactory implements Factory<ContactAccessApi> {
    public final Provider<RetrofitFactory> a;

    public ContactAccessApiModule_ProvideContactAccessApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static ContactAccessApiModule_ProvideContactAccessApiFactory create(Provider<RetrofitFactory> provider) {
        return new ContactAccessApiModule_ProvideContactAccessApiFactory(provider);
    }

    public static ContactAccessApi provideContactAccessApi(RetrofitFactory retrofitFactory) {
        return (ContactAccessApi) Preconditions.checkNotNullFromProvides(ContactAccessApiModule.INSTANCE.provideContactAccessApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public ContactAccessApi get() {
        return provideContactAccessApi(this.a.get());
    }
}
