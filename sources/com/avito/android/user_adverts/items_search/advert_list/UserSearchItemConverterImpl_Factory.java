package com.avito.android.user_adverts.items_search.advert_list;

import android.content.res.Resources;
import com.avito.android.user_adverts.tab_screens.converters.UserItemConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserSearchItemConverterImpl_Factory implements Factory<UserSearchItemConverterImpl> {
    public final Provider<UserItemConverter> a;
    public final Provider<Resources> b;

    public UserSearchItemConverterImpl_Factory(Provider<UserItemConverter> provider, Provider<Resources> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserSearchItemConverterImpl_Factory create(Provider<UserItemConverter> provider, Provider<Resources> provider2) {
        return new UserSearchItemConverterImpl_Factory(provider, provider2);
    }

    public static UserSearchItemConverterImpl newInstance(UserItemConverter userItemConverter, Resources resources) {
        return new UserSearchItemConverterImpl(userItemConverter, resources);
    }

    @Override // javax.inject.Provider
    public UserSearchItemConverterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
