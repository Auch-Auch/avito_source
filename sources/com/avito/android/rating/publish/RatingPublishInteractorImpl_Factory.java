package com.avito.android.rating.publish;

import com.avito.android.Features;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RatingPublishInteractorImpl_Factory implements Factory<RatingPublishInteractorImpl> {
    public final Provider<RatingApi> a;
    public final Provider<PhotoInteractor> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<Features> d;

    public RatingPublishInteractorImpl_Factory(Provider<RatingApi> provider, Provider<PhotoInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static RatingPublishInteractorImpl_Factory create(Provider<RatingApi> provider, Provider<PhotoInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<Features> provider4) {
        return new RatingPublishInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static RatingPublishInteractorImpl newInstance(RatingApi ratingApi, PhotoInteractor photoInteractor, SchedulersFactory3 schedulersFactory3, Features features) {
        return new RatingPublishInteractorImpl(ratingApi, photoInteractor, schedulersFactory3, features);
    }

    @Override // javax.inject.Provider
    public RatingPublishInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
