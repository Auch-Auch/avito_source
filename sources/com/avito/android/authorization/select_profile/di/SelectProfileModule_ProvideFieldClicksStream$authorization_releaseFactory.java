package com.avito.android.authorization.select_profile.di;

import com.avito.android.authorization.select_profile.adapter.SelectProfileField;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SelectProfileModule_ProvideFieldClicksStream$authorization_releaseFactory implements Factory<PublishRelay<SelectProfileField>> {

    public static final class a {
        public static final SelectProfileModule_ProvideFieldClicksStream$authorization_releaseFactory a = new SelectProfileModule_ProvideFieldClicksStream$authorization_releaseFactory();
    }

    public static SelectProfileModule_ProvideFieldClicksStream$authorization_releaseFactory create() {
        return a.a;
    }

    public static PublishRelay<SelectProfileField> provideFieldClicksStream$authorization_release() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(SelectProfileModule.INSTANCE.provideFieldClicksStream$authorization_release());
    }

    @Override // javax.inject.Provider
    public PublishRelay<SelectProfileField> get() {
        return provideFieldClicksStream$authorization_release();
    }
}
