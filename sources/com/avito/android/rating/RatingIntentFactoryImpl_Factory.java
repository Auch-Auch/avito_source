package com.avito.android.rating;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RatingIntentFactoryImpl_Factory implements Factory<RatingIntentFactoryImpl> {
    public final Provider<Context> a;

    public RatingIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static RatingIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new RatingIntentFactoryImpl_Factory(provider);
    }

    public static RatingIntentFactoryImpl newInstance(Context context) {
        return new RatingIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public RatingIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
