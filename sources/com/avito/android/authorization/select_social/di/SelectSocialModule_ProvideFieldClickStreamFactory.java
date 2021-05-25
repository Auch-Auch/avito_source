package com.avito.android.authorization.select_social.di;

import com.avito.android.authorization.select_social.adapter.SelectSocialField;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SelectSocialModule_ProvideFieldClickStreamFactory implements Factory<PublishRelay<SelectSocialField>> {

    public static final class a {
        public static final SelectSocialModule_ProvideFieldClickStreamFactory a = new SelectSocialModule_ProvideFieldClickStreamFactory();
    }

    public static SelectSocialModule_ProvideFieldClickStreamFactory create() {
        return a.a;
    }

    public static PublishRelay<SelectSocialField> provideFieldClickStream() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(SelectSocialModule.provideFieldClickStream());
    }

    @Override // javax.inject.Provider
    public PublishRelay<SelectSocialField> get() {
        return provideFieldClickStream();
    }
}
