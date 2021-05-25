package com.avito.android.user_adverts.items_search.di;

import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertItemAction;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.Observable;
public final class ProfileItemsSearchModule_BindObservableFactory implements Factory<Observable<UserAdvertItemAction>> {

    public static final class a {
        public static final ProfileItemsSearchModule_BindObservableFactory a = new ProfileItemsSearchModule_BindObservableFactory();
    }

    public static Observable<UserAdvertItemAction> bindObservable() {
        return (Observable) Preconditions.checkNotNullFromProvides(ProfileItemsSearchModule.INSTANCE.bindObservable());
    }

    public static ProfileItemsSearchModule_BindObservableFactory create() {
        return a.a;
    }

    @Override // javax.inject.Provider
    public Observable<UserAdvertItemAction> get() {
        return bindObservable();
    }
}
