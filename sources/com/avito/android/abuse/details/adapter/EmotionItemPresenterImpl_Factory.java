package com.avito.android.abuse.details.adapter;

import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class EmotionItemPresenterImpl_Factory implements Factory<EmotionItemPresenterImpl> {
    public final Provider<Consumer<AbuseField>> a;

    public EmotionItemPresenterImpl_Factory(Provider<Consumer<AbuseField>> provider) {
        this.a = provider;
    }

    public static EmotionItemPresenterImpl_Factory create(Provider<Consumer<AbuseField>> provider) {
        return new EmotionItemPresenterImpl_Factory(provider);
    }

    public static EmotionItemPresenterImpl newInstance(Consumer<AbuseField> consumer) {
        return new EmotionItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public EmotionItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
