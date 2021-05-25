package com.avito.android.user_adverts.tab_screens.converters;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserItemConverterImpl_Factory implements Factory<UserItemConverterImpl> {
    public final Provider<UserElementItemConverter> a;
    public final Provider<SchedulersFactory> b;

    public UserItemConverterImpl_Factory(Provider<UserElementItemConverter> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserItemConverterImpl_Factory create(Provider<UserElementItemConverter> provider, Provider<SchedulersFactory> provider2) {
        return new UserItemConverterImpl_Factory(provider, provider2);
    }

    public static UserItemConverterImpl newInstance(UserElementItemConverter userElementItemConverter, SchedulersFactory schedulersFactory) {
        return new UserItemConverterImpl(userElementItemConverter, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public UserItemConverterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
