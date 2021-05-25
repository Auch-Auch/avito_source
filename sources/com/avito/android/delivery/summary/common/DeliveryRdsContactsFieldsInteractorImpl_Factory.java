package com.avito.android.delivery.summary.common;

import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.validation.LocalPretendInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryRdsContactsFieldsInteractorImpl_Factory implements Factory<DeliveryRdsContactsFieldsInteractorImpl> {
    public final Provider<TypedErrorThrowableConverter> a;
    public final Provider<LocalPretendInteractor> b;

    public DeliveryRdsContactsFieldsInteractorImpl_Factory(Provider<TypedErrorThrowableConverter> provider, Provider<LocalPretendInteractor> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DeliveryRdsContactsFieldsInteractorImpl_Factory create(Provider<TypedErrorThrowableConverter> provider, Provider<LocalPretendInteractor> provider2) {
        return new DeliveryRdsContactsFieldsInteractorImpl_Factory(provider, provider2);
    }

    public static DeliveryRdsContactsFieldsInteractorImpl newInstance(TypedErrorThrowableConverter typedErrorThrowableConverter, LocalPretendInteractor localPretendInteractor) {
        return new DeliveryRdsContactsFieldsInteractorImpl(typedErrorThrowableConverter, localPretendInteractor);
    }

    @Override // javax.inject.Provider
    public DeliveryRdsContactsFieldsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
