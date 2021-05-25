package com.avito.android.user_adverts.tab_screens;

import android.content.Context;
import com.avito.android.user_advert.UserAdvertsInfoUpdateRunner;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserAdvertsCountUpdaterImpl_Factory implements Factory<UserAdvertsCountUpdaterImpl> {
    public final Provider<Context> a;
    public final Provider<UserAdvertsInfoUpdateRunner> b;

    public UserAdvertsCountUpdaterImpl_Factory(Provider<Context> provider, Provider<UserAdvertsInfoUpdateRunner> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserAdvertsCountUpdaterImpl_Factory create(Provider<Context> provider, Provider<UserAdvertsInfoUpdateRunner> provider2) {
        return new UserAdvertsCountUpdaterImpl_Factory(provider, provider2);
    }

    public static UserAdvertsCountUpdaterImpl newInstance(Context context, UserAdvertsInfoUpdateRunner userAdvertsInfoUpdateRunner) {
        return new UserAdvertsCountUpdaterImpl(context, userAdvertsInfoUpdateRunner);
    }

    @Override // javax.inject.Provider
    public UserAdvertsCountUpdaterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
