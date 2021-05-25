package com.avito.android.user_advert.advert.autopublish_block;

import com.avito.android.user_advert_api.remote.UserAdvertApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutoPublishChangeStateInteractor_Factory implements Factory<AutoPublishChangeStateInteractor> {
    public final Provider<UserAdvertApi> a;

    public AutoPublishChangeStateInteractor_Factory(Provider<UserAdvertApi> provider) {
        this.a = provider;
    }

    public static AutoPublishChangeStateInteractor_Factory create(Provider<UserAdvertApi> provider) {
        return new AutoPublishChangeStateInteractor_Factory(provider);
    }

    public static AutoPublishChangeStateInteractor newInstance(UserAdvertApi userAdvertApi) {
        return new AutoPublishChangeStateInteractor(userAdvertApi);
    }

    @Override // javax.inject.Provider
    public AutoPublishChangeStateInteractor get() {
        return newInstance(this.a.get());
    }
}
