package com.avito.android.authorization.login_suggests.di;

import com.avito.android.authorization.login_suggests.adapter.LoginSuggestsItem;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class LoginSuggestsModule_ProvideClicksStream$authorization_releaseFactory implements Factory<PublishRelay<LoginSuggestsItem>> {

    public static final class a {
        public static final LoginSuggestsModule_ProvideClicksStream$authorization_releaseFactory a = new LoginSuggestsModule_ProvideClicksStream$authorization_releaseFactory();
    }

    public static LoginSuggestsModule_ProvideClicksStream$authorization_releaseFactory create() {
        return a.a;
    }

    public static PublishRelay<LoginSuggestsItem> provideClicksStream$authorization_release() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(LoginSuggestsModule.provideClicksStream$authorization_release());
    }

    @Override // javax.inject.Provider
    public PublishRelay<LoginSuggestsItem> get() {
        return provideClicksStream$authorization_release();
    }
}
