package com.avito.android.remote;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationsApiModule_ProvideNotificationsApiFactory implements Factory<NotificationsApi> {
    public final Provider<RetrofitFactory> a;

    public NotificationsApiModule_ProvideNotificationsApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static NotificationsApiModule_ProvideNotificationsApiFactory create(Provider<RetrofitFactory> provider) {
        return new NotificationsApiModule_ProvideNotificationsApiFactory(provider);
    }

    public static NotificationsApi provideNotificationsApi(RetrofitFactory retrofitFactory) {
        return (NotificationsApi) Preconditions.checkNotNullFromProvides(NotificationsApiModule.INSTANCE.provideNotificationsApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public NotificationsApi get() {
        return provideNotificationsApi(this.a.get());
    }
}
