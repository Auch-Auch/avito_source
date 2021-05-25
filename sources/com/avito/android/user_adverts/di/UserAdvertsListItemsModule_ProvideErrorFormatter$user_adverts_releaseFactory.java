package com.avito.android.user_adverts.di;

import android.content.res.Resources;
import com.avito.android.util.ErrorFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsListItemsModule_ProvideErrorFormatter$user_adverts_releaseFactory implements Factory<ErrorFormatter> {
    public final Provider<Resources> a;

    public UserAdvertsListItemsModule_ProvideErrorFormatter$user_adverts_releaseFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static UserAdvertsListItemsModule_ProvideErrorFormatter$user_adverts_releaseFactory create(Provider<Resources> provider) {
        return new UserAdvertsListItemsModule_ProvideErrorFormatter$user_adverts_releaseFactory(provider);
    }

    public static ErrorFormatter provideErrorFormatter$user_adverts_release(Resources resources) {
        return (ErrorFormatter) Preconditions.checkNotNullFromProvides(UserAdvertsListItemsModule.provideErrorFormatter$user_adverts_release(resources));
    }

    @Override // javax.inject.Provider
    public ErrorFormatter get() {
        return provideErrorFormatter$user_adverts_release(this.a.get());
    }
}
