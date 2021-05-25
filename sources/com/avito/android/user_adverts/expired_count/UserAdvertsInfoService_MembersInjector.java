package com.avito.android.user_adverts.expired_count;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class UserAdvertsInfoService_MembersInjector implements MembersInjector<UserAdvertsInfoService> {
    public final Provider<UserAdvertsInfoInteractor> a;

    public UserAdvertsInfoService_MembersInjector(Provider<UserAdvertsInfoInteractor> provider) {
        this.a = provider;
    }

    public static MembersInjector<UserAdvertsInfoService> create(Provider<UserAdvertsInfoInteractor> provider) {
        return new UserAdvertsInfoService_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.expired_count.UserAdvertsInfoService.interactor")
    public static void injectInteractor(UserAdvertsInfoService userAdvertsInfoService, UserAdvertsInfoInteractor userAdvertsInfoInteractor) {
        userAdvertsInfoService.interactor = userAdvertsInfoInteractor;
    }

    public void injectMembers(UserAdvertsInfoService userAdvertsInfoService) {
        injectInteractor(userAdvertsInfoService, this.a.get());
    }
}
