package com.avito.android.user_adverts.di;

import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsListItemsModule_ProvideDestroyableViewHolderBuilder$user_adverts_releaseFactory implements Factory<DestroyableViewHolderBuilder> {
    public final Provider<ItemBinder> a;

    public UserAdvertsListItemsModule_ProvideDestroyableViewHolderBuilder$user_adverts_releaseFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static UserAdvertsListItemsModule_ProvideDestroyableViewHolderBuilder$user_adverts_releaseFactory create(Provider<ItemBinder> provider) {
        return new UserAdvertsListItemsModule_ProvideDestroyableViewHolderBuilder$user_adverts_releaseFactory(provider);
    }

    public static DestroyableViewHolderBuilder provideDestroyableViewHolderBuilder$user_adverts_release(ItemBinder itemBinder) {
        return (DestroyableViewHolderBuilder) Preconditions.checkNotNullFromProvides(UserAdvertsListItemsModule.provideDestroyableViewHolderBuilder$user_adverts_release(itemBinder));
    }

    @Override // javax.inject.Provider
    public DestroyableViewHolderBuilder get() {
        return provideDestroyableViewHolderBuilder$user_adverts_release(this.a.get());
    }
}
