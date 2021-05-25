package com.avito.android.feedback_adverts.di;

import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class FeedbackAdvertsModule_ProvideAdvertPriceFormatter$feedback_adverts_releaseFactory implements Factory<Formatter<AdvertPrice>> {
    public final Provider<Locale> a;

    public FeedbackAdvertsModule_ProvideAdvertPriceFormatter$feedback_adverts_releaseFactory(Provider<Locale> provider) {
        this.a = provider;
    }

    public static FeedbackAdvertsModule_ProvideAdvertPriceFormatter$feedback_adverts_releaseFactory create(Provider<Locale> provider) {
        return new FeedbackAdvertsModule_ProvideAdvertPriceFormatter$feedback_adverts_releaseFactory(provider);
    }

    public static Formatter<AdvertPrice> provideAdvertPriceFormatter$feedback_adverts_release(Locale locale) {
        return (Formatter) Preconditions.checkNotNullFromProvides(FeedbackAdvertsModule.provideAdvertPriceFormatter$feedback_adverts_release(locale));
    }

    @Override // javax.inject.Provider
    public Formatter<AdvertPrice> get() {
        return provideAdvertPriceFormatter$feedback_adverts_release(this.a.get());
    }
}
