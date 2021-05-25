package com.avito.android.user_adverts.items_search.di;

import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertItemAction;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.functions.Consumer;
public final class ProfileItemsSearchModule_BindConsumerFactory implements Factory<Consumer<UserAdvertItemAction>> {

    public static final class a {
        public static final ProfileItemsSearchModule_BindConsumerFactory a = new ProfileItemsSearchModule_BindConsumerFactory();
    }

    public static Consumer<UserAdvertItemAction> bindConsumer() {
        return (Consumer) Preconditions.checkNotNullFromProvides(ProfileItemsSearchModule.INSTANCE.bindConsumer());
    }

    public static ProfileItemsSearchModule_BindConsumerFactory create() {
        return a.a;
    }

    @Override // javax.inject.Provider
    public Consumer<UserAdvertItemAction> get() {
        return bindConsumer();
    }
}
