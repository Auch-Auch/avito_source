package com.avito.android.abuse.details.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SendingSuccessItemBlueprint_Factory implements Factory<SendingSuccessItemBlueprint> {
    public final Provider<SendingSuccessItemPresenter> a;

    public SendingSuccessItemBlueprint_Factory(Provider<SendingSuccessItemPresenter> provider) {
        this.a = provider;
    }

    public static SendingSuccessItemBlueprint_Factory create(Provider<SendingSuccessItemPresenter> provider) {
        return new SendingSuccessItemBlueprint_Factory(provider);
    }

    public static SendingSuccessItemBlueprint newInstance(SendingSuccessItemPresenter sendingSuccessItemPresenter) {
        return new SendingSuccessItemBlueprint(sendingSuccessItemPresenter);
    }

    @Override // javax.inject.Provider
    public SendingSuccessItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
