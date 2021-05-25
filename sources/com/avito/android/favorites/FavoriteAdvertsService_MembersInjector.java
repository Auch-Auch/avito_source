package com.avito.android.favorites;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class FavoriteAdvertsService_MembersInjector implements MembersInjector<FavoriteAdvertsService> {
    public final Provider<FavoriteAdvertsServiceInteractor> a;

    public FavoriteAdvertsService_MembersInjector(Provider<FavoriteAdvertsServiceInteractor> provider) {
        this.a = provider;
    }

    public static MembersInjector<FavoriteAdvertsService> create(Provider<FavoriteAdvertsServiceInteractor> provider) {
        return new FavoriteAdvertsService_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.favorites.FavoriteAdvertsService.interactor")
    public static void injectInteractor(FavoriteAdvertsService favoriteAdvertsService, FavoriteAdvertsServiceInteractor favoriteAdvertsServiceInteractor) {
        favoriteAdvertsService.interactor = favoriteAdvertsServiceInteractor;
    }

    public void injectMembers(FavoriteAdvertsService favoriteAdvertsService) {
        injectInteractor(favoriteAdvertsService, this.a.get());
    }
}
